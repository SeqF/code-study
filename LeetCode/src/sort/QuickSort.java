package sort;

import java.util.Arrays;
import java.util.List;

/**
 * @author paksu
 */
public class QuickSort {

    public void quickSort(int[] a, int n) {
        quickSortC(a, 0, n-1);
    }

    public void quickSortC(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r);
        quickSortC(a, p, q - 1);
        quickSortC(a, q + 1, r);
    }

    public int partition(int[] a, int p, int r) {
        //使用数组最后一个元素作为中枢,划分为左小右大
        int pivot = a[r];
        int i = p;
        //i为已处理区最后一个元素的位置，j为未处理区的第一个元素位置，把j小于pivot的元素通过swap放在已处理区
        for (int j = p; j <=r - 1; j++) {
            if (a[j] < pivot) {
                swap(a,i,j);
                i++;
            }
        }
        swap(a,i,r);
        return i;
    }

    public void swap(int[] a,int f, int r) {
        int temp = a[f];
        a[f] = a[r];
        a[r] = temp;
    }

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        int[] test = new int[]{6, 11, 3, 9, 8};
        sort.quickSort(test,test.length);
        System.out.println(Arrays.toString(test));
    }
}
