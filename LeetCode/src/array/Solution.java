package array;

import array.base.Array1;
import array.base.Array2;

public class Solution {

    public static void main(String[] args) {

        Array1 array = new Array1(5);
        for (int i = 0; i < array.size; i++) {
            array.data[i]="key"+i;
            array.count++;
        }
        array.append("key5");
        System.out.println(array.size);


        Array2 array2=new Array2(5);
        array2.insert(1);
        array2.insert(2);
        array2.insert(2);
        array2.insert(2);
        array2.insert(3);
        int i =array2.bSearch(3);
        System.out.println(array2.bSearch(3));
    }
}
