package com.company;

/**
 * Created by zhangsirui on 15/9/17.
 * 快速排序
 */
public class Quick_Sort {
    public static void main(String[] args)
    {
        Quick quick=new Quick(new int[]{12,2,30,55,44,28,14,3,77});
        quick.QuickSort(0,8);
        quick.showInfo();
    }
}
class Quick
{
    int[] a;
    int i,j;
    public Quick(int[] a)
    {
        this.a=a;
    }
    public void showInfo()
    {
        for (int index:a)
        {
            System.out.print(index+" ");
        }
    }
    public void QuickSort(int p,int r)
    {
        if (p<r)
        {
            int q=partition(p,r);
            QuickSort(p,q-1);
            QuickSort(q+1,r);
        }
    }
    public int partition(int p,int r)
    {
        int x=a[r];
        i=p-1;
        for (j=p;j<r;j++)
        {
            if (a[j]<=x)
            {
                i++;
                int temp;
                temp=a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }
        int temp;
        temp=a[i+1];
        a[i+1]=a[r];
        a[r]=temp;
        return i+1;
    }


}
