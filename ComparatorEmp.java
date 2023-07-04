package assignment;

import java.util.*;

public class ComparatorEmp implements Comparator<employee>{

	public int compare(employee e1, employee e2)
	{
		System.out.println("Comparing e1's deptno: " + e1.getEmpDeptNo() + " with e2's deptno: " + e2.getEmpDeptNo());
		return (int)(e1.getEmpDeptNo() - e2.getEmpDeptNo());
	}
}
-----------------------------------------------------------------------------------------------------------------------------------------------------------
	        [HttpPost("storefile")]
        public async Task<IActionResult> storefile([FromBody] GraphQLQuery query, string fname, bool ignorePropertyPath = false)
        { 
            string fileName = string.Empty;            
            if (query == null) { throw new ArgumentNullException(nameof(query)); }

            try
            {
                var variables = JObject.Parse(query.Variables.ToString());
                if (!variables.ContainsKey("paging"))
                {
                    variables["paging"] = JToken.FromObject(PagingInputGraphType.MaxDefault,
                        new JsonSerializer() { ContractResolver = new CamelCasePropertyNamesContractResolver() });
                }

                var executionOptions = new ExecutionOptions
                {
                    Schema = _schema,
                    Query = query.Query,
                    Inputs = variables.ToInputs()
                };
                
                fileName = $"{DateTime.Now.ToString("yyyyMMddHHmmssFFF")}/{fname.Replace("/", "-")}";

                _exportService.Execute(executionOptions, fileName, bucketName);

                var tableName = GetTableName(query.Query);

                using (_unitOfWorkFactory.Create())
                {
                    executionOptions.Inputs.Add("query", executionOptions.Query);
                    executionOptions.Inputs.Add("operationName", query.OperationName);
                    _auditLogRepository.Add(new AuditLog()
                    {
                        TableName = tableName,
                        ActionType = ActionTypes.Export.ToString(),
                        CreatedBy = _userResolverService.GetUser(),
                        CreatedOn = DateTime.Now,
                        IPAddress = _userResolverService.GetUserIP(),
                        RequestParams = JsonConvert.SerializeObject(executionOptions.Inputs)
                    });
                }

                _logger.LogInformation("Request submitted storefile method {fileName}", fileName);

            }
            catch (Exception ex)
            {
                _logger.LogError("Exception in storefile {0}", ex);
                return StatusCode((int)HttpStatusCode.InternalServerError, ex.ToString());
            }
            return Ok(new { fileName = fileName});
        }
