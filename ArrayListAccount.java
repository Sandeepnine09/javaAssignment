package assignment;

import java.util.*;

public class ArrayListAccount {

	public static void main(String[] args) {
		
		List<account> lt = new ArrayList<>();
		
		account ac1 = new account("Benjamin Pavard", 1201, 2000);
		lt.add(ac1);
		
		account ac2 = new account("Lucas Hernandez", 1351, 3810);
		lt.add(ac2);
		
		lt.add(new account("Niko Mazaroui", 5431, 2230));
		lt.add(new account("Kingsley Koman", 9761, 4495));
		
		System.out.println(lt);
		System.out.println(lt.size());
		
		lt.remove(2);
		System.out.println(lt);
		System.out.println(lt.size());
		
		boolean isIt = lt.contains(ac1);
		System.out.println(isIt + " this element is present here!!!");
		
		account ac3 = new account("Sadio Mane", 5541, 2989);
		
		lt.set(2, ac3);
		System.out.println(lt);
		System.out.println(lt.size());
	}

}

---------------------------------------------------------------------------------------------------------------------------------------------------------------

	public class OpenXmlFormatter : IFormatter
    {
        public Stream Execute(JObject graphQLResult) => Execute(graphQLResult, false);

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
                    var sheet1 = (ISheet)workbook.CreateSheet("Sheet1");

                    var header = (Dictionary<string, int>)null;
                    var rowIndex = 0;
                    var dictList = (list as JArray).ToFlatDictionaries();
                    foreach (var record in dictList)
                    {
                        if (rowIndex == 0)
                        {
                            var orderedHeaders = dictList.SelectMany(lst => lst.Select((row, index) => new { text = row.Key, index }));
                            var allHeaders = orderedHeaders
                                .GroupBy(gp => new { gp.text})
                                .OrderBy(x => x.Max(y => y.index))
                                .Select(x => x.Key.text).Distinct();
                            header = WriteHeader(allHeaders, sheet1, ignorePropertyPath);
                            rowIndex++;
                        }

                        foreach (var k in record.ToList())
                        {
                            if (k.Value != null && k.Value.GetType() == typeof(string))
                            {
                                record[k.Key] = ((string)k.Value).Replace("\r", "");
                            }
                        }
                        sheet1.CreateFreezePane(0, 1, 0, 1);
                        rowIndex = WriteRow(header, record, sheet1, rowIndex, ignorePropertyPath);
                    }
                    workbook.Write(excelStream);
                    byte[] excelStreamContent = excelStream.ToArray();
                    ms.Write(excelStreamContent, 0, excelStreamContent.Length);
                }
                return ms;
            }
            return null;
        }

        private int WriteRow(Dictionary<string, int> headerDict, Dictionary<string, object> data, ISheet sheet, int rowIndex, bool ignorePropertyPath)
        {
            if (data == null || data.Count == 0)
                return rowIndex;

            var row = sheet.CreateRow(rowIndex);

            foreach (var item in data)
            {
                var cellNumber = headerDict[item.Key];
                var cell = row.CreateCell(cellNumber);

                if (item.Value == null)
                {
                    cell.SetCellValue(string.Empty);
                }
                else
                {
                    var type = item.Value.GetType();

                    if (type == typeof(double))
                        cell.SetCellValue((double)item.Value);
                    else if (type == typeof(bool))
                        cell.SetCellValue((bool)item.Value);
                    else if (type == typeof(DateTime))
                        cell.SetCellValue((DateTime)item.Value);
                    else
                        cell.SetCellValue(item.Value.ToString());
                }
            }
            return rowIndex + 1;
        }

        private Dictionary<string, int> WriteHeader(IEnumerable<string> headers, ISheet sheet, bool ignorePropertyPath)
        {
            var cellIndex = 0;
            var headerDictionary = new Dictionary<string, int>();
            var row = sheet.CreateRow(0);
            foreach (var prop in headers)
            {
                headerDictionary.Add(prop, cellIndex);
                row.CreateCell(cellIndex).SetCellValue(GetTitleForProperty(prop, ignorePropertyPath));
                cellIndex++;
            }
            return headerDictionary;
        }

        private string GetTitleForProperty(string property, bool ignorePropertyPath)
        {
            string title = property;
            if (ignorePropertyPath && title.IndexOf(".") > 0)
            {
                title = title.Split('.').Last();
            }
            title = IncludeSpaces(title);
            title = ToPascalCase(title);
            return title;
        }

        private string IncludeSpaces(string text)
        {
            return text.Replace("_", " ");
        }

        private string ToPascalCase(string text)
        {
            return string.Join(".",
                text.Split('.').Select(p => Char.ToUpperInvariant(p[0]) + p.Substring(1))
            );
        }

        public string GetFileExtension() => ".xlsx";

        public string GetMimeType() => "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    }
}
	
-------------------------------------------------------------------------------------------------------------------------------
	
