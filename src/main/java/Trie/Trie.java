package Trie;

/**
 * 字典树实现
 */
public class Trie {

    private TrieNode root; //字典树的根

    private int size = 26;

    public Trie() {
        root = new TrieNode();
    }

    class TrieNode {
        private char val;//节点的值
        private TrieNode[] son;//所有的儿子节点
        private boolean isEnd;//是不是最后一个节点
        private int num; // 有多少单词通过这个节点
        private boolean haveSon; //是否有儿子节点

        public TrieNode() {
            num = 1;
            son = new TrieNode[size];
            isEnd = false;
            haveSon = false;
        }
    }

    //字典树的插入
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        TrieNode node = root;
        char[] letters = word.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null) {
                node.haveSon = true;
                node.son[pos] = new TrieNode();
                node.son[pos].val = letters[i];
            } else {
                node.son[pos].num++;
            }
            node = node.son[pos];
        }
        node.isEnd = true;
    }

    /**
     * 完全匹配字符串是否在字典树中
     *
     * @param str
     * @return
     */
    public boolean has(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        TrieNode node = root;
        char[] letters = str.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] != null) {
                node = node.son[pos];
            } else {
                return false;
            }
        }
        return node.isEnd;
    }

    //计算某个单词前缀的数量
    public int countPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return 0;
        }
        char[] letters = prefix.toCharArray();
        TrieNode node = root;
        for (int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null) {
                return 0;
            } else {
                node = node.son[pos];
            }
        }
        return node.num;
    }

    public void printPrefix(String prefix) {
        if (prefix == null || prefix.length() == 0) {
            return;
        }
        TrieNode node = root;
        char[] letters = prefix.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int pos = letters[i] - 'a';
            if (node.son[pos] == null) {
                return;
            } else {
                node = node.son[pos];
            }
        }
        preTraverse(node, prefix);
    }


    /**
     * 遍历经过此节点的单词
     *
     * @param node
     * @param prefix
     */
    public void preTraverse(TrieNode node, String prefix) {
        if (node.haveSon) {
            for (TrieNode child : node.son) {
                if (child != null) {
                    preTraverse(child, prefix + child.val);
                }
            }
            return;
        }
        System.out.println(prefix);
    }

    public TrieNode getRoot() {
        return root;
    }


    public static void main(String[] args) {
        Trie tree = new Trie();
        String[] strs = {"banana", "band", "bee", "absolute", "acm",};
        String[] prefix = {"ba", "b", "band", "abc",};
        for (String str : strs) {
            tree.insert(str);
        }
        System.out.println(tree.has("abc"));
        for (String pre : prefix) {
            int num = tree.countPrefix(pre);
            System.out.print(pre +"前缀的单词：");
            tree.printPrefix(pre);
            System.out.println(pre + " : " + num);
        }


    }
}
