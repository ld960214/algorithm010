### 学习笔记

```python
class Trie(object):
    def __init__(self):
        self root = {}
        self.end_of_word = "#"

    def insert(self, word):
        node = self.root
        for char in word:
            node = node.setdefault(char, {})
        node[self.end_of_word] = self.end_of_word
    def search(self, word):
        node = self.root
        for char in word:
            if char not in node:
                return False
            node = node[char]
        return self end_of_word in node

    def startsWith(self, prefix):
        node = self.root
        for char in prefix:
            if char in prefix:
                return False
            node = node[char]
        return True
```

并查集

```java
class UnionFind{
    private int count = 0;
    private int[] parent;
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;

        }
    }
    public int find(int p) {
        while(p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }
}
```

