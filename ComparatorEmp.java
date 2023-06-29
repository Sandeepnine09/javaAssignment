package assignment;

import java.util.*;

public class ComparatorEmp implements Comparator<employee>{

	public int compare(employee e1, employee e2)
	{
		System.out.println("Comparing e1's deptno: " + e1.getEmpDeptNo() + " with e2's deptno: " + e2.getEmpDeptNo());
		return (int)(e1.getEmpDeptNo() - e2.getEmpDeptNo());
	}
}

select pi.ProductIndividualNumber, pi.Id, pi.ChassisNumber,vo.Description as 'Product Class', als.Description as 'Allocation Status', 
co.Name, ii.InvoiceDate, ci.SerialNumber, su.Name as 'Final Assembly Unit', cua.MaterialValue, cua.ProductionValue, cua.MarkupValue
from  ProductIndividual pi 
inner join ProductClass pc on pc.id = pi.ProductClassId 
inner JOIN VariantOption vo on vo.Id = pc.VariantOptionId
inner join FinalAssemblyAllocation fas on fas.ProductIndividualId = pi.Id
inner join AllocationStatus als on als.Id = fas.AllocationStatusId
inner join Country co on co.Id = pi.CountryId
inner join InvoicedIndividual ii on ii.ProductindividualId = pi.Id
inner join ComponentIndividual ci on ci.ProductindividualId = pi.Id
inner join ScaniaUnitScaniaUnitType sus on sus.ScaniaUnitId = ci.ScaniaUnitId and sus.ScaniaunitTypeId = 4
inner join ScaniaUnit su on su.Id = sus.ScaniaUnitId
inner join ConsolidationUnitAllocation cua on cua.ProductindividualId = pi.Id
where  pi.ProductIndividualNumber = 10707629;

how to add groupBy query on productindividualnumber and sum multiple materialvalue according to groupBy?
