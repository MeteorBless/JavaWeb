
public class helloworld {


    public static void main(String[] args) {
        System.out.println("nihao");

        int[] nums={0,1,2,2,3,0,4,2};
        System.out.println(nums.length);
        System.out.println("剩余个数为："+removeElement(nums,2));

    }
    public static int removeElement(int[] nums, int val) {
        int count=0;
        for(int i=0;i<nums.length;++i){
            if(nums[i]==val){
                count++;
            }else {
                nums[i-count]=nums[i];
            }
        }
        return count;
    }
}