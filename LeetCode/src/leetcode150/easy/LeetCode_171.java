package leetcode150.easy;

/**
 * Excel表列序号
 *
 * @author paksu
 * <p>
 * 链接：https://leetcode-cn.com/problems/excel-sheet-column-number/
 */
public class LeetCode_171 {

    /**
     * 26进制转10进制
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        char[] columnTitleChar = columnTitle.toCharArray();
        int length = columnTitleChar.length;
        int ASCII = 'A';
        int number = 0;
//        for (int i = 0; i < length; i++) {
//            if (i == length - 1) {
//                number += ((int) columnTitleChar[i] - ASCII + 1);
//            } else {
//                number += ((int) columnTitleChar[i] - ASCII + 1) * 26;
//            }
//        }
        for (int i = length - 1; i >= 0; i--) {
            number += ((int) columnTitleChar[i] - ASCII + 1) * (26 ^ (length - 1 - i));
        }
        return number;
    }

    public static void main(String[] args) {
        LeetCode_171 code171 = new LeetCode_171();
        System.out.println(code171.titleToNumber("A"));
    }

}
