package array;

import java.util.Random;

import static utils.CommonUtils.backward;

/**
 * 实现一个大小固定的有序数组(在这里只考虑自然数,进行升序排列)，实现增删查改
 */
public class SortArray {

    private int[] data;

    private int size;

    public SortArray(int size) {
        this.size = size;
        data = new int[size];
        //初始化
        for (int i = 0; i < size; i++) {
            data[i] = -1;
        }
    }

    public void add(int value) {
        if (data[0] == -1) {
            data[0] = value;
            return;
        }
        for (int i = 0; i < size; i++) {
            if (value >= data[i]) {
                if (data[i] == -1) {
                    data[i] = value;
                    break;
                }
            } else {
                backward(data, i, size - 1, 1);
                data[i] = value;
                break;
            }
        }
    }

    public int get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(size);
        }
        return data[index];
    }

    /**
     * 更新分为两种情况
     * ① 当要更新的下标没有值的情况，应该是相当于新增一个值，再重新排序
     * ② 当更新的下标有值的情况，是将该下标的值更新为目标值，再重新排序
     *
     * @param index
     * @param value
     * @return
     */
    public int update(int index, int value) {
        int result = data[index];
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(size);
        }
        //考虑当前index没有值的情况
        if (data[index] == -1) {
            int k = index;
            while (k > 0 && data[--k] == -1) {
            }
            for (int i = 0; i <= k; i++) {
                if (data[i] >= value) {
                    backward(data, i, k + 1, 1);
                    data[i] = value;
                    return result;
                }
            }
            data[k] = value;
            return result;
        }

        //下面都是有值的情况
        if (data[index] == value) {
            return result;
        }

        if (data[index] > value) {
            int j = index - 1;
            while (j >= 0) {
                //插在j位置上,将j到index的位置往后移一位
                if (data[j] <= value) {
                    backward(data, j, index, 1);
                    data[j] = value;
                    return result;
                }
                j--;
            }
            backward(data, 0, index, 1);
            data[0] = value;
            return result;
        }

        if (data[index] < value) {
            int j = index + 1;
            while (j < size) {
                if (data[j] >= value) {
                    //插到j-1的位置上,将index-》j-1向前移动一位
                    backward(data, index, j - 1, 0);
                    data[j - 1] = value;
                    return result;
                }
                j++;
            }
            backward(data, 0, size - 1, 1);
            data[size - 1] = value;
            return result;
        }
        return result;
    }

    public int remove(int index) {
        int result = data[index];
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException(size);
        }
        //如果移除的位置没有值，直接返回
        if (result == -1) {
            return result;
        }
        backward(data, index, size - 1, 0);
        return result;
    }


    public static void main(String[] args) {
        SortArray sortArray = new SortArray(16);
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            sortArray.add(random.nextInt(16) + 1);
        }
        for (int i = 0; i < 16; i++) {
            System.out.println("i=" + i + ":" + sortArray.get(i));
        }

        System.out.println("-----------------------");
        int index = 0;
        int value = 10;
        int update = sortArray.update(index, value);
        System.out.println("index = " + index + " before update = " + update + "; after update=" + value);

        for (int i = 0; i < 16; i++) {
            System.out.println("i=" + i + ":" + sortArray.get(i));
        }

        int remove = sortArray.remove(index);
        System.out.println("index = " + index + ";  remove=" + remove);
        for (int i = 0; i < 16; i++) {
            System.out.println("i=" + i + ":" + sortArray.get(i));
        }

    }
}
