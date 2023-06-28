package assignment;

import java.util.*;

public class ComparatorAccount implements Comparator<account>{
	
	public int compare(account ac1, account ac2)
	{
		System.out.println("Comparing ac1's acctHolderName: " + ac1.getAccountHolderName() + " with ac2's acctHolderName: " + ac2.getAccountHolderName());
		return (int)(ac1.getAccountHolderName().length() - ac2.getAccountHolderName().length());
	}

}
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

	
query ($productIndividualId: Int) {
  products {
    search(productIndividualId: $productIndividualId) {
      list {
        id
        productClassText
        chassisNumber
        productIndividualNumber
        country {
          name
          iSOCode
          __typename
        }
        fitForUseNumber
        specialOrderNumber
        uniqueDesignNumber
        invoicedDate
        finalAssemblyUnit
        serialNumber
        totalMaterialValue
        totalProductionValue
        totalMarkupValue
        totalCurrencyValue
        baseCost
        __typename
      }
      __typename
    }
    __typename
  }
}


query ($paging: Paging, $order: String, $filter: String, $productIndividualId: Int) {
  products {
    specification(paging: $paging, order: $order, filter: $filter, productIndividualId: $productIndividualId) {
      list {
        id
        variantOption {
          value
          description
          variantFamily {
            value
            description
            variantClass {
              value
              description
              __typename
            }
            __typename
          }
          __typename
        }
        __typename
      }
      totalCount
      __typename
    }
    __typename
  }
}


query ($productIndividualId: Int, $allocationScaniaUnitId: Int) {
  orchestrator {
    productIndividualStepFault(productIndividualId: $productIndividualId, allocationScaniaUnitId: $allocationScaniaUnitId) {
      type
      details
      message
      referenceValue
      flowExecutionStep {
        startDate
        __typename
      }
      __typename
    }
    __typename
  }
}


query productIndividualComponentsQuery($productIndividualId: Int, $allocationScaniaUnitId: Int) {
  components {
    fetch(productIndividualId: $productIndividualId, allocationScaniaUnitId: $allocationScaniaUnitId) {
      id
      componentUnitCode
      componentUnitDescription
      componentDescription
      __typename
    }
    __typename
  }
}


query ($productIndividualId: Int, $allocationScaniaUnitId: Int) {
  products {
    productionValue(productIndividualId: $productIndividualId, allocationScaniaUnitId: $allocationScaniaUnitId) {
      id
      componentType {
        id
        name
        description
        code
        __typename
      }
      productionPriceConditionPrice {
        price
        productionPriceCondition {
          id
          description
          productionPriceList {
            description
            __typename
          }
          variantCodeSummary
          __typename
        }
        productionPriceType {
          name
          description
          isManualType
          __typename
        }
        __typename
      }
      productionValue
      isUniqueDesign
      __typename
    }
    __typename
  }
}


query ($paging: Paging, $order: String, $filter: String, $productIndividualId: Int) {
  products {
    specification(paging: $paging, order: $order, filter: $filter, productIndividualId: $productIndividualId) {
      list {
        id
        variantOption {
          value
          description
          variantFamily {
            value
            description
            variantClass {
              value
              description
              __typename
            }
            __typename
          }
          __typename
        }
        __typename
      }
      totalCount
      __typename
    }
    __typename
  }
}


query ($productIndividualId: Int, $allocationScaniaUnitId: Int) {
  products {
    manualProductionValue(productIndividualId: $productIndividualId, allocationScaniaUnitId: $allocationScaniaUnitId) {
      id
      componentType {
        id
        name
        description
        code
        __typename
      }
      productionPriceType {
        name
        description
        isManualType
        __typename
      }
      value
      comment
      __typename
    }
    __typename
  }
}

