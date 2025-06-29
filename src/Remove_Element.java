public class Remove_Element {
    public static void main(String[] args) {
        int[] arr = {2,3,3,2};

        System.out.println(removeElement(arr,3));

    }

    public static int removeElement(int[] nums, int val) {
        int output = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[output++] = nums[i];
            }
        }
        return output;
    }

}
