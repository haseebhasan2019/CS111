public class MergeSort {

  public static void sort (int[] a, int lo, int hi){
    // sort a[lo, hi)
    int n = hi - lo;
    if ( n <= 1 ) return;
    int middle = lo + n/2;
    sort(a, lo, middle);
    sort(a, middle, hi);
    merge(a, lo, middle, hi);

  }

  public static void merge (int[] a, int lo, int mid, int hi){
    // merge a[lo,mid) with a[mid,hi) into aux[0,hi-lo)
    int i =  lo, j = mid, n = hi - lo;
    int[] aux = new int[n];
    for ( int k = 0; k < n; k++ ) {
      if ( i == mid ) aux[k] = a[j++];
      else if ( j == hi ) aux[k] = a[i++];
      else if ( a[j] < a[i] ) aux[k] = a[j++];
      else aux[k] = a[i++];
    }

    // copy back into a[lo, hi)
    for ( int k = 0; k < n; k++ ) {
      a[lo+k] = aux[k];
    }

    for (int l = 0; l < a.length; l++) {
    	System.out.print(a[l] + " ");
    }

    System.out.println();

    for (int m = 0; m < aux.length; m++) {
    	System.out.print(aux[m] + " ");
    }

    System.out.println();
    System.out.println();


  }

  public static void main(String[] args) {
  	int[] list = {3, 17, 19, 1, 24, 2, 20};
  	sort(list, 0, 6);
  	System.out.println();
  	// for (int i = 0; i < a.length; i++) {
  	// 	System.out.print(a[i] + " ");
  	// }
  	// System.out.println();
  	// for (int i = 0; i < a.length; i++) {
  	// 	System.out.print(aux[i] + " ");
  	// }
  }
}