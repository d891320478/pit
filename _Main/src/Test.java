/**
 * @author htdong
 * @date 2018年12月28日 下午6:17:31
 */

class BlackRedNode {
    public static final int RED = 0;
    public static final int BLACK = 1;
    private static BlackRedNode LEAF = null;

    public int key;
    public int val;
    public int sz, color;
    public BlackRedNode[] ch;

    private BlackRedNode() {
    }

    public BlackRedNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.sz = 1;
        this.color = RED;
        this.ch = new BlackRedNode[2];
        this.ch[0] = this.ch[1] = leaf();
    }

    public static BlackRedNode leaf() {
        if (LEAF != null) {
            return LEAF;
        }
        LEAF = new BlackRedNode();
        LEAF.ch = new BlackRedNode[2];
        LEAF.ch[0] = LEAF.ch[1] = LEAF;
        LEAF.sz = 0;
        LEAF.key = -1;
        LEAF.val = -1;
        LEAF.color = BLACK;
        return LEAF;
    }
}

class BlackRedTree {
    private BlackRedNode root;
    private BlackRedNode leaf;

    public BlackRedTree() {
        this.root = BlackRedNode.leaf();
        this.leaf = BlackRedNode.leaf();
    }

    public int size() {
        return root.sz;
    }

    public void insert(int key, int val) {
        insert(root, key, val, null, 0);
    }

    private void insert(BlackRedNode x, int k, int v, BlackRedNode p, int pt) {
        if (x == leaf) {
            x = new BlackRedNode(k, v);
            if (p == null) {
                root = x;
            } else {
                p.ch[pt] = x;
                // TODO
            }
            return;
        }
        if (x.key == k) {
            x.val = v;
            return;
        }
        if (x.key < k) {
            insert(x.ch[1], k, v, x, 1);
        } else {
            insert(x.ch[0], k, v, x, 0);
        }
    }

    private void rorate(BlackRedNode x, BlackRedNode p, int pt, int ptx) {
        BlackRedNode y = x.ch[pt ^ 1];
        BlackRedNode z = y.ch[pt];
        y.ch[pt] = x;
        x.ch[pt ^ 1] = z;
        p.ch[ptx] = y;
    }
}

public class Test {

    public static void main(String[] args) {
    }
}