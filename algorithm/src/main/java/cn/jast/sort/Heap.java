package cn.jast.sort;

import java.util.Arrays;

public class Heap {

    
    /**
     * 交换元素
     */
    public void swap(int a[] , int i , int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    } 

    //将某个节点堆化：将其自己堆化，并且将交换位置的子节点也进行堆化确保交换后还是一个堆
    // a：数组； n: 数组长度；i：数组中第i个元素，待堆化的元素
    public void heapify(int a[] , int n , int i){
        //递归出口
        if(i >= n){
            return ;
        }
        int c1 = 2 * i + 1;//左子节点，确保存在（不超过数组长度）
        int c2 = 2 * i + 2;//右子节点，确保存在（不超过数组长度）
        int max = i;
        if(c1 < n && a[c1] > a[max]){
            max = c1;
        }
        if(c2 < n && a[c2] > a[max]){
            max = c2;
        }
        if(max != i){
            swap(a,i,max);
            heapify(a,n,max);
        }
    }

    // 将数组构建成堆
    // a :待构建的数组，n：数组的长度
    public void build_heap(int a[] , int n){
        int last_node = n-1;
        int last_node_parent = (last_node-1)/2;
        for(int i = last_node_parent ; i >= 0 ; i--){
            heapify(a,n,i);
        }
    }

    // 堆排序
    public void heap_sort(int a[],int n){
        //数组堆化
        build_heap(a,n);
        //交换最后一个元素
        for(int i = n-1 ; i>=0 ; i--){
            //交换第0和最后一个元素
            swap(a,0,i);
            //对堆顶元素堆化
            heapify(a,i,0);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] a = {2,1,3,4,6,7,5,9,8};
        heap.heap_sort(a,a.length);
        System.out.println(Arrays.toString(a));
    }
}