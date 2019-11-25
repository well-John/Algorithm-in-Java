package array;

/**
 * 合并两个有序数组（前提两个有序数组都是升序,降序也行，反正必须顺序要一致）
 */
public class MergeTwoSortArray {

    public int[] mergeTwoArray(int[] a, int[] b) {
        int length_a = a.length - 1;
        int length_b = b.length - 1;
        int length = length_a + length_b + 1;
        int[] result = new int[a.length + b.length];
        while (length_a >= 0 && length_b >= 0) {
            result[length--] = a[length_a] > b[length_b] ? a[length_a--] : b[length_b--];
        }

        if (length_a >= 0) {
            System.arraycopy(a, 0, result, 0, length_a + 1);
        } else {
            System.arraycopy(b, 0, result, 0, length_b + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 6, 7};

        int[] b = {1};

        MergeTwoSortArray mergeTwoSortArray = new MergeTwoSortArray();
        int[] result = mergeTwoSortArray.mergeTwoArray(a, b);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
