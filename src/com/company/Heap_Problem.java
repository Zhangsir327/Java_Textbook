package com.company;

/**
 * Created by zhangsirui on 15/9/16.
 * 堆排序
 */
public class Heap_Problem {
    public static void main(String[] args)
    {
        int[] a={16,4,10,14,7,9,3,2,8,1};
        Max_Heap max_heap=new Max_Heap();
        int[] b=max_heap.Build_Max_Heap(a);
        max_heap.HeapSort(b);
    }
}
class Max_Heap
{
    int l;//第i个结点的左孩子
    int r;//第i个结点的右孩子
    int largest;//用于记录当前最大结点的标号
    int heap_size;//表示当前堆的元素个数,通过这个变量来动态控制数组中进行堆排序的元素个数

    //进行建堆调整
    public void Max_Heapify(int[] a,int i)//a为数组形式的堆，i为序号
    {
        l=2*i+1;
        r=2*i+2;
        if (l<heap_size&&a[l]>a[i])
        {
            largest=l;
        }else {
            largest=i;
        }
        if (r<heap_size&&a[r]>a[largest])
        {
            largest=r;
        }
        if (largest!=i)
        {
            int temp;
            temp=a[i];
            a[i]=a[largest];
            a[largest]=temp;
            Max_Heapify(a,largest);
        }
    }

    //建立大根堆
    public int[] Build_Max_Heap(int[] a)
    {
        heap_size=a.length;
        for (int i=heap_size/2-1;i>=0;i--)
        {
            Max_Heapify(a,i);
        }
        //打印堆数组
        System.out.println("此时调整完后的堆数组为：");
        for (int i=0;i<heap_size;i++)
        {
            System.out.print(a[i]+" ");
        }
        System.out.println();
        return a;
    }

    //进行堆排序
    public void HeapSort(int[] a)
    {
        heap_size=a.length;
        int[] b=new int[a.length];//用于存储排序后的数列
        for (int i=a.length-1;i>=0;i--)
        {
            b[i]=a[0];//将堆顶元素写到b的末尾

            //交换堆顶和堆底元素
            int temp;
            temp=a[i];
            a[i]=a[0];
            a[0]=temp;

            //减少一个堆长度
            heap_size--;


            //重新调整堆
            Max_Heapify(a,0);
        }
        System.out.println("排序后的数列为：");
        for (int i=0;i<b.length;i++)
        {
            System.out.print(b[i]+" ");
        }
    }
}
