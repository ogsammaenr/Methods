public class Find_Median_Sorted_Arrays {


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            merged[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            merged[i + nums1.length] = nums2[i];
        }

        for (int i = 1; i < merged.length; i++) {
            for (int j = 1; j < merged.length; j++) {
                if ((merged[j - 1] > merged[j])) {
                    int a = merged[j - 1];
                    int b = merged[j];
                    merged[j - 1] = b;
                    merged[j] = a;
                }
            }
        }
        double length = merged.length;
        double median;
        if (!(length % 2 > 0)){
            median = merged[ (merged.length / 2)] + merged[ (merged.length / 2 - 1)] / 2.0;
            return median;
        }
        else {
            return merged[merged.length / 2];
        }
    }
}
