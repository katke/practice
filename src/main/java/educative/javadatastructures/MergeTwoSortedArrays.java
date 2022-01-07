package educative.javadatastructures;

import java.util.Arrays;

public class MergeTwoSortedArrays {

  int[] mergeArrays(int[] arr1, int[] arr2) {
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
    if (arr1 == null && arr2 == null) {
      return new int[]{};
    } else if (arr1 == null) {
      return arr2;
    } else if (arr2 == null) {
      return arr1;
    }
    if (arr1.length == 0 && arr2.length == 0) {
      return arr1;
    } else if (arr1.length == 0) {
      return arr2;
    } else if (arr2.length == 0) {
      return arr1;
    }
    int mergedSize = arr1.length + arr2.length;
    int[] mergedArr = new int[mergedSize];
    int arr1Idx = 0;
    int arr2Idx = 0;
    int mergedIdx = 0;
    while (mergedIdx < mergedSize) {
      int arr1Item = arr1Idx >= arr1.length ? Integer.MAX_VALUE : arr1[arr1Idx];
      int arr2Item = arr2Idx >= arr2.length ? Integer.MAX_VALUE : arr2[arr2Idx];
      if (arr1Item > arr2Item) {
        mergedArr[mergedIdx] = arr2Item;
        arr2Idx++;
      } else {
        mergedArr[mergedIdx] = arr1Item;
        arr1Idx++;
      }
      mergedIdx++;
    }

    return mergedArr;
  }


  }
