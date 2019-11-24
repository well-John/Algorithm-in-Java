package array;

/**
 * 动态扩容的数组
 */
public class DynamicArray {
    private Object[] data;
    private int size = 16;
    private int index = 0;
    private double load_factor = 0.75f;

    public DynamicArray() {
        data = new Object[size];
    }

    public DynamicArray(int size) {
        this.size = size;
        data = new Object[size];
    }

    public void add(Object value) {
        if (index < (int) size * load_factor - 1) {
            data[index++] = value;
        } else {
            size *= 2;
            Object[] temp = new Object[size];
            System.arraycopy(data, 0, temp, 0, index);
            temp[index++] = value;
            data = temp;
        }
    }

    public Object get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("超过数组下标");
        }
        return data[index];
    }

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();

        for (int i = 0; i < 18; i++) {
            dynamicArray.add(i);
        }

        for (int i = 0; i < 18; i++) {
            System.out.println(dynamicArray.get(i));
        }

    }

}
