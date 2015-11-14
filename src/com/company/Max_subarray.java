package com.company;

/**
 * Created by zhangsirui on 15/9/15.
 * 分治策略——最大子数组问题
 */
public class Max_subarray {
    public static void main(String[] args)
    {
        int[] a={13,-3,-25,20,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
        int low=0,high=15;

        Maximum_array maximum_array=new Maximum_array();
        maximum_array.Find_Maximum_Array(a,low,high);
        maximum_array.print_result();

    }
}
//最大子数组类
class Maximum_array
{
    int low;//最左边元素

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    int high;//最右边元素
    int sum;//找到最大子数组中的所有值的和
    public void Find_Maximum_Array(int[] a,int low,int high)
    {
        int mid;
        int left_low,left_high,left_sum;
        int right_low,right_high,right_sum;
        int cross_low,cross_high,cross_sum;

        //只有一个元素的情形
        if (low==high)
        {
            this.low=low;
            this.high=low;
            this.sum=a[low];
        }
        //有两种以上元素时
        else
        {
            mid=(low+high)/2;

            //搜索左边
            Maximum_array maximum_array_left=new Maximum_array();
            maximum_array_left.Find_Maximum_Array(a,low,mid);
            left_low=maximum_array_left.getLow();
            left_high=maximum_array_left.getHigh();
            left_sum=maximum_array_left.getSum();

            //搜索右边
            Maximum_array maximum_array_right=new Maximum_array();
            maximum_array_right.Find_Maximum_Array(a,mid+1,high);
            right_low=maximum_array_right.getLow();
            right_high=maximum_array_right.getHigh();
            right_sum=maximum_array_right.getSum();

            //搜索跨越中点的子数组
            Max_Crossing_array max_crossing_array=new Max_Crossing_array();
            max_crossing_array.Find_Max_Crossing_array(a,low,mid,high);
            cross_low=max_crossing_array.getLow();
            cross_high=max_crossing_array.getHigh();
            cross_sum=max_crossing_array.getSum();

            //进行判断
            if ((left_sum>=right_sum)&&(left_sum>=cross_sum))
            {
                this.low=left_low;
                this.high=left_high;
                this.sum=left_sum;
            }
            else if ((right_sum>=left_sum)&&(right_sum>=cross_sum))
            {
                this.low=right_low;
                this.high=right_high;
                this.sum=right_sum;
            }
            else
            {
                this.low=cross_low;
                this.high=cross_high;
                this.sum=cross_sum;
            }
        }
    }
    public void print_result()
    {
        System.out.println("最大子数组的起始序号、终止序号和里面所有值的和分别为:");
        System.out.print(getLow()+" "+getHigh()+" "+getSum());
    }
}
//跨越中点的最大子数组类
class Max_Crossing_array
{
    int low;

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    int high;
    int sum;
    public void Find_Max_Crossing_array(int[] a,int low,int mid,int high)
    {
        int left_sum=-5000;//用于记录当前左边子数组的最大值
        int right_sum=-5000;//用于记录当前右边子数组的最大值
        int sum=0;//左边或右边子数组中所有值的和
        int max_left=0;//用于记录左边下标i
        int max_right=0;//用于记录右边下标j
        for (int i=mid;i>=low;i--)
        {
            sum=sum+a[i];
            if (sum>left_sum)
            {
                left_sum=sum;
                max_left=i;
            }
        }
        sum=0;
        for (int j=mid+1;j<=high;j++)
        {
            sum=sum+a[j];
            if (sum>right_sum)
            {
                right_sum=sum;
                max_right=j;
            }
        }
        int total_sum=left_sum+right_sum;
        this.low=max_left;
        this.high=max_right;
        this.sum=total_sum;
    }
}
