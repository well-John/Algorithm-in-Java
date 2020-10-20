package unionFindSet;

/**
 * 并查集
 */
public class UnionFindSet {

    private int[] parent;

    public UnionFindSet(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }


    public int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x= parent[x];
        }
        return x;
    }

    public void union(int x,int y){
        int rootX = find(x);
        int rootY =find(y);
        parent[rootX]= rootY;
    }

    public boolean isConnected(int x,int y){
        return find(x) == find(y);
    }

}
