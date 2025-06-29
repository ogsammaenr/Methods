public class longestRepeatedNumber {
    public static void main(String[] args) {
        int[] array = {3,3,3,3,1,2,3,4,5,6,7,8,9,1,2,4};

        int a  = majorityElement(array);

        System.out.println(a );

    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count += 1;
            } else {
                count -= 1;
            }
        }

        return candidate;
    }
}
