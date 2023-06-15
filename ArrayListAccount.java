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
