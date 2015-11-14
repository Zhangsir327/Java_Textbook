package com.company;

/**
 * Created by zhangsirui on 15/9/23.
 * 归并排序，不使用哨兵
 */
public class Merge_sort {
    public static void main(String[] args)
    {
        Merge merge=new Merge(new int[]{12,2,30,55,44});
        merge.merge_sort(0,4);
        merge.showInfo();
    }
}
class Merge
{
    private int[] a;
    public Merge(int[] a)
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
    public void merge_sort(int p,int r)
    {
        if (p<r)
        {
            int q=(p+r)/2;
            merge_sort(p, q);
            merge_sort(q + 1, r);
            merge(p,q,r);
        }
    }

    public void merge(int p,int q,int r)
    {
        int n1=q-p+1;
        int n2=r-q;
        int[] L=new int[n1];
        int[] R=new int[n2];
        for (int i=0;i<n1;i++)
        {
            L[i]=a[p+i];
        }
        for (int j=0;j<n2;j++)
        {
            R[j]=a[q+1+j];
        }

        int i=0;
        int j=0;
        for (int k=p;k<=r;k++)
        {
            if (L[i]<=R[j])
            {
                a[k]=L[i];
                i++;
            }else {
                a[k]=R[j];
                j++;
            }
            if (i==n1)
            {
                for (int t=k+1;t<=r;t++,j++)
                {
                    a[t]=R[j];
                }
                break;
            }
            if (j==n2)
            {
                for (int s=k+1;s<=r;s++,i++)
                {
                    a[s]=L[i];
                }
                break;
            }
        }
    }
}
