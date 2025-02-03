public class MedianArray {

    public double median(int[] nums1, int[] nums2) {
        int[] merged = merge(nums1, nums2);
        int mid = merged.length / 2;
        if (merged.length % 2 == 0) {
            return (merged[mid - 1] + merged[mid]) / 2.0 ;//Average for even length
        } else {
            return merged[mid]; // Middle element for odd length
        }
    }

    public int[] merge(int[] nums1, int[] nums2) {
        int nums1Index = 0;
        int nums2Index = 0;
        int currentIndex = 0;
        int length = Math.min(nums1.length, nums2.length);
        int[] temp = new int[nums1.length + nums2.length];
        while (nums1Index < nums1.length && nums2Index < nums2.length) {
            if (nums1[nums1Index] < nums2[nums2Index]) {
                temp[currentIndex++] = nums1[nums1Index++];
            } else {
                temp[currentIndex++] = nums2[nums2Index++];
            }
        }

        while (nums1Index < nums1.length) {
            temp[currentIndex++] = nums1[nums1Index++];

        }
        while (nums2Index < nums2.length) {
            temp[currentIndex++] = nums2[nums2Index++];
        }

        return temp;

    }
}
