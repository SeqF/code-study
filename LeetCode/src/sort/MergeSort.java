package sort;

/**
 * 归并排序
 *
 * @author paksu
 */
public class MergeSort {

    public void merge(int[] a, int low, int mid, int high) {

        //新建一个B数组来保存A数组中的元素
        int[] b = new int[]{};
        int k;

        //将A数组中的元素放入B数组中
        for (k = low; k <= high; k++) {
            b[k] = a[k];
        }

        int i, j;
        //k表示a数组的位置，i表示从左边那段数组开始，j表示从右边那段数组开始，对两段数组进行比较
        //将较小的元素放回a数组中
        for (i = low, j = mid + 1, k = i; i <= mid && j <= high; k++) {
            if (b[i] <= b[j]) {
                a[k] = b[i++];
            } else {
                a[k] = b[j++];
            }
        }

        //将剩余的数组放入a数组中
        while (i <= mid) {
            a[k++] = b[i++];
        }
        while (j <= high) {
            a[k++] = b[j++];
        }
    }

    public void mergeSort(int[] a, int low, int high) {
        int mid = (high + low) / 2;
        mergeSort(a, low, mid);
        mergeSort(a, mid + 1, high);
        merge(a, low, mid, high);
    }
}
