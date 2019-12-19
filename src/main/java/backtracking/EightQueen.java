package backtracking;

public class EightQueen {

    private int queen;

    private int total;

    private int[][] data;

    public int getQueen() {
        return queen;
    }

    public void setQueen(int queen) {
        this.queen = queen;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public EightQueen(int queen) {
        this.queen = queen;
        data = new int[queen][queen];
    }

    private void findQueue(int row) {
        if (row > queen - 1) {
            total++;
            print();
            return;
        } else {
            for (int m = 0; m < queen; m++) {
                if (is_ok(row, m)) {
                    data[row][m] = 1;
                    findQueue(row + 1);
                    data[row][m] = 0;
                }
            }
        }
    }

    private boolean is_ok(int row, int m) {
        for (int i = 0; i < queen; i++) {
            if (data[i][m] == 1) {
                return false;
            }
        }

        for (int i = row - 1, j = m - 1; i >= 0 && j >= 0; i--, j--) {//检查左对角线
            if (data[i][j] == 1) {
                return false;
            }
        }
        for (int i = row - 1, j = m + 1; i >= 0 && j < queen; i--, j++) {//检查右对角线
            if (data[i][j] == 1) {
                return false;
            }
        }


        return true;
    }

    private void print() {
        for (int i = 0; i < queen; i++) {
            for (int j = 0; j < queen; j++) {
                if (data[i][j] == 1) {
                    System.out.print("o ");
                } else {
                    System.out.print("+ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        EightQueen eightQueen = new EightQueen(8);
        eightQueen.findQueue(0);
        System.out.println("总共"+eightQueen.getTotal()+"种");

    }
}
