## 学习笔记

泛型递归  树的递归

递归代码模板：

```python
def recursion(level, param1, param2, ...):
    if level > MAX_LEVEL:  # 递归终止条件
    process_result
    return

    # process logic in current level
    process(level, dasta...) # 处理当前层逻辑

    # drill dowm
    self.recursion(level + 1, p1, ...)  # 下探到下一层

    # reverse the current level status if needed
    # 清理当前层
```

```java
public void recur(int level, int param) {
    // terminator
    if (level > MAX_LEVEL) {
        return;
    }

    // process current logic
    process(level, param);

    // drill down
    recur(level:level + 1, newParam);
    //restore current status
}
```

### 递归思维要点

- 不要人肉进行递归(最大误区)
- 找到最近最简方法，将其拆解成可重复解决的问题(重复子问题)
- 数学归纳法思维

分治代码模板

```python
# Python
def divide_conquer(problem, param1, param2, ...): 
  # recursion terminator 
  if problem is None: 
	print_result 
	return 
  # prepare data 
  data = prepare_data(problem) 
  subproblems = split_problem(problem, data) 
  # conquer subproblems 
  subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
  subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
  subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
  …
  # process and generate the final result 
  result = process_result(subresult1, subresult2, subresult3, …)
	
  # revert the current level states
```