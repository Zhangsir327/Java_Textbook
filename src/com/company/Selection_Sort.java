package com.company;

import java.util.Scanner;

/**
 * Created by zhangsirui on 15/9/16.
 * 选择排序算法
 */
public class Selection_Sort {
    public static void main(String[] args)
    {
        System.out.println("please input an array:");
        Scanner scanner=new Scanner(System.in);
        String string=scanner.nextLine();
        String[] strings=string.trim().split("\\s{1,}");
        int[] a=new int[strings.length];
        for (int i=0;i<a.length;i++)
        {
            a[i]=Integer.parseInt(strings[i]);
        }

        Selection selection=new Selection();
        selection.Select(a);
    }
}
class Selection
{
    public void Select(int[] a)
    {
        int min;//用于记录当前的最小值
        int index;//用于记录最小元素的编号
        for (int i=0;i<a.length-1;i++)
        {
            min=a[i];
            index=i;
            //寻找最小的元素
            for (int j=i;j<a.length;j++)
            {
                if (a[j]<min)
                {
                    min=a[j];
                    index=j;
                }
            }
            if (a[index]<a[i])
            {
                //交换
                int temp;
                temp=a[index];
                a[index]=a[i];
                a[i]=temp;
            }
        }
        for (int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
    }

}
