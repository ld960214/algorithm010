## 学习笔记


在树上使用基于队列的遍历算法

```java

List<Integer> values = new ArrayList<>();
Queue<Node> queue = new LinkedList<>();
queue.add(root);
while (!queue.isEmpty()) {
    Node nextNode = queue.remove();
    values.add(nextNode.val);
    for (Node child : nextNode.children) {
        queue.add(child);
    }
}

```

用一个列表存放节点值，队列存放节点。首先将根节点放到队列中，当队列不为空时，则在队列取出一个节点，并将其子节点添加到队列中。
