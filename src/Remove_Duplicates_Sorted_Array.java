public class Remove_Duplicates_Sorted_Array {

    public static int removeDuplicates(int[] nums) {


        for (int i = 0; i < nums.length-1; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] != 200 && nums[i] == nums[j])
                    nums[j] = 200;

        int deger = 0;
        for (int i = nums.length-1; i > 1; i--) {
            for (int j = nums.length -1 ; j > 1; j--) {
                if (nums[j - 1] == 200) {
                    deger = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = deger;
                }
            }
        }
        deger = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 200){
                deger++;
            }
        }
        int[] dizi = new int[deger];
        for (int i = 0; i < dizi.length; i++){
            dizi[i] = nums[i];
        }
        nums = dizi.clone();

        return deger;
    }
}
