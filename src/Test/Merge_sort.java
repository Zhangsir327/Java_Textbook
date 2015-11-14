package Test;

/**
 * Created by zhangsirui on 15/9/23.
 * 分治策略之归并排序，使用哨兵
 */
public class Merge_sort {
    public static void main(String[] args)
    {
        Merge merge=new Merge(new int[]{12,2,44,55,32,17});
        merge.merge_sort(0,5);
        merge.showInfo();
    }
}
class Merge
{
    private int[] a;
    public Merge(int[] a)
    {
        System.out.println("排序前：");
        for (int index:a)
        {
            System.out.print(index+" ");
        }
        System.out.println();
        this.a=a;
    }
    public void showInfo()
    {
        System.out.println("排序后：");
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
            merge_sort(p,q);
            merge_sort(q+1,r);
            merge(p,q,r);
        }
    }
    //将分治后的数组合并
    public void merge(int p,int q,int r)
    {
        int n1=q-p+1;//左组元素个数
        int n2=r-q;//右组元素个数
        int[] L=new int[n1+1];
        int[] R=new int[n2+1];
        L[n1]=5000;//左数组哨兵
        R[n2]=5000;//右数组哨兵

        //构造L、R数组
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
            //如果L数组先看到哨兵，则将R数组的剩余元素全部给数组a
            if (L[i]==L[n1])
            {
                for (int t=k+1;t<=r;t++,j++)
                {
                    a[t]=R[j];
                }
                break;
            }
            //如果R数组先看到哨兵，则将L数组的剩余元素全部给数组a
            if (R[j]==R[n2])
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