package Test;

/**
 * Created by zhangsirui on 15/9/23.
 * 最大子数组问题的暴力求解法
 */
public class Max_subarray {
    public static void main(String[] args)
    {
        int[] a={13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int max_sum=0;
        int low=0;
        int high=0;
        for (int i=0;i<a.length;i++)
        {
            int temp=0;
            for (int j=i;j<a.length;j++)
            {
                temp+=a[j];
                if (temp>max_sum)
                {
                    max_sum=temp;
                    low=i;
                    high=j;
                }
            }

        }
        System.out.print(low+" "+high+" "+max_sum);
    }
}

