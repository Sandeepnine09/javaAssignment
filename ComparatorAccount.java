package assignment;

import java.util.*;

public class ComparatorAccount implements Comparator<account>{
	
	public int compare(account ac1, account ac2)
	{
		System.out.println("Comparing ac1's acctHolderName: " + ac1.getAccountHolderName() + " with ac2's acctHolderName: " + ac2.getAccountHolderName());
		return (int)(ac1.getAccountHolderName().length() - ac2.getAccountHolderName().length());
	}

}


public Stream Execute(JObject graphQLResult, bool ignorePropertyPath)
{
    var list = graphQLResult.SelectToken("$.search.list") ?? graphQLResult.SelectToken("$..search.list")
        ?? graphQLResult.SelectToken("$..search");
    if (list != null && list is JArray)
    {
        var ms = new MemoryStream();
        using (var excelStream = new MemoryStream())
        {
            var workbook = (IWorkbook)new XSSFWorkbook();

            // Get distinct sheet names from the data
            var sheetNames = GetDistinctSheetNames((list as JArray), ignorePropertyPath);

            foreach (var sheetName in sheetNames)
            {
                var sheet = (ISheet)workbook.CreateSheet(sheetName);

                var header = (Dictionary<string, int>)null;
                var rowIndex = 0;
                var dictList = (list as JArray).ToFlatDictionaries();
                foreach (var record in dictList)
                {
                    if (rowIndex == 0)
                    {
                        var orderedHeaders = dictList.SelectMany(lst => lst.Select((row, index) => new { text = row.Key, index }));
                        var allHeaders = orderedHeaders
                            .GroupBy(gp => new { gp.text })
                            .OrderBy(x => x.Max(y => y.index))
                            .Select(x => x.Key.text).Distinct();
                        header = WriteHeader(allHeaders, sheet, ignorePropertyPath);
                        rowIndex++;
                    }

                    foreach (var k in record.ToList())
                    {
                        if (k.Value != null && k.Value.GetType() == typeof(string))
                        {
                            record[k.Key] = ((string)k.Value).Replace("\r", "");
                        }
                    }
                    sheet.CreateFreezePane(0, 1, 0, 1);
                    rowIndex = WriteRow(header, record, sheet, rowIndex, ignorePropertyPath);
                }
            }

            workbook.Write(excelStream);
            byte[] excelStreamContent = excelStream.ToArray();
            ms.Write(excelStreamContent, 0, excelStreamContent.Length);
        }
        return ms;
    }
    return null;
}

private List<string> GetDistinctSheetNames(JArray data, bool ignorePropertyPath)
{
    var sheetNames = new List<string>();
    foreach (var record in data)
    {
        var sheetName = ignorePropertyPath ? "Sheet1" : GetSheetNameFromRecord(record);
        if (!sheetNames.Contains(sheetName))
            sheetNames.Add(sheetName);
    }
    return sheetNames;
}

private string GetSheetNameFromRecord(JToken record)
{
    // Modify this logic to extract the sheet name from the record
    // Example: Assuming the record has a property "SheetName" containing the sheet name
    return record.Value<string>("SheetName");
}

modified WriteHeader 

private Dictionary<string, int> WriteHeader(IEnumerable<string> headers, ISheet sheet, bool ignorePropertyPath)
{
    var headerRow = sheet.CreateRow(0);
    var headerDict = new Dictionary<string, int>();
    var columnIndex = 0;
    foreach (var header in headers)
    {
        var cell = headerRow.CreateCell(columnIndex);
        cell.SetCellValue(header);
        headerDict[header] = columnIndex;
        columnIndex++;
    }
    return headerDict;
}



