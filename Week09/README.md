### 学习笔记

#### 递归、分治、回溯、动态规划复习

递归-函数自己调用自己


```java
public void recur(int level, int param) {
    //terminator
    if (level > MAX_LEVEL) {
        //process result
        return;
    }

    //process current logic
    process(level, param);

    //drill down
    recur(level: level + 1, newParam);

    // restore current status
}
```

分治代码模板
```python
def divide_conquer(problem, param1, param2, ...) :
    # recursion terminator
    if problem is None:
        print_result
        return

    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)


    # conquer subproblems
    subresult1 = self.divide_conquer(subproblem[0], p1, ...)
    subresult2 = self.divide_conquer(subproblem[1], p1, ...)
    subresult3 = self.divide_conquer(subproblem[2], p1, ...)
    
    ...

    # process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, ...)

    # revert the current level states
```


DP顺推模板

```java
function DP():

    dp = [][]  # 二位情况

    for i = 0 .. M {
        for j = 0 .. N {
            dp[i][j] = _Function(dp[j'][j']);
        }
    }

    return dp[M][N];
```

关键点

动态规划 和 递归 或者分治 没有根本上的区别 (关键看有无最优子结构)

拥有共性：找到重复子问题

差异性：最优子结构、中途可以淘汰次优解


#### 字符串

- Python:

x = 'abbc'
x = "abbc"

- Java:

String x = "abbc";

- C++:

string x("abbc");


#### 遍历字符串

- Python:

```python
for ch in "abbc":
    print(ch)
```

- java:

```java
String x = "abbc";
for (int i = 0; i < x.size(); ++i) {
    char ch = x.charAt(i);
}
for ch in x.toCharArray() {
    System.out.println(ch);
}

- C++:

string x("abbc");

for (int i = 0; i < s1.length(); i++) {
    cout << x[i];
}
```

字符串比较

-java

String x = "abb";

String y = "abb";

x == y --> false

x.equals(y) --> true

x.equalsIgnoreCase(y) --> true

atoi:

```java
public int myAtoi(String str) {
    int index = 0, sign = 1, total = 0;
    // 1. Empty string

    if(str.length() == 0) return 0;

    // 2. Remove Spaces
    while(str.charAt(index) == '' && index < str.length())
        index++;

    // 3. Handle signs
    if (str.charAt(index) == '+' || str.charAt(index) == '-') {
        sign = str.charAt(index) == '+'?1:-1;
        index++;
    }

    // 4. Convert number and avoid overflow

    while(index < str.length() ) {
        int digit = str.charAt(index) - '0';
        if(digit < 0 || digit > 9) break;

        // check if total will be overflow after 10 times and add digit
        if(Integer.MAX_VALUE / 10 < total ||
           Integer.MAX_VALUE / 10 == tatal && Integer.MAX_VLAUE % 10 < digit
        )
            return sign == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE:

        total = 10 * total + digit;

        index++;


    }

    return total * sign;
}
```

```python
class Solution(object):
    def myAtoi(self, s):
        if len(s) == 0: return 0
        ls = list(s.strip())

        sign = -1 if ls[0] == '-' else 1

        if ls[0] in ['-','+']: del ls[0]

        ret, i = 0, 0

        while i < len(ls) and ls[i].isdigit():
            ret = ret * 10 + ord(ls[i]) - ord('0')
            i += 1

        return max(-2 * 31, min(sign * ret, 2 ** 31 -1))
```

字符串匹配算法

1. 暴力法(brute force) - O(mn) 
2. Rabin-Karp 算法
3. KMP 算法

暴力法

```java
public static int forceSearch(String txt, String pat) {
    int N = txt.length();
    int N = pat.length();

    for (int i = 0; i <= M - N; i++) {
        int j;
        for (j = 0; j < N; j++) {
            if (txt.charAt(i + j) != pat.charAt(j))
                break;
        }

        if (j == N) {
            return i;
        }

        // 更加聪明？
        // 1. 预先判断 —— hash(txt.substring(i, M)) == hash(pat)
        // 2. KMP
    }

    return -1;
}
```

Rabin-Karp 算法

在朴素算法中，我们需要挨个比较所有字符，才知道目标字符串中是否包含子串。那么，是否有别的方法可以用来判断目标字符串是否包含子串呢？

答案是肯定的，确实存在一种更快的方法。为了避免挨个字符对目标字符串和子串进行比较，我们可以尝试一次性判断两者是否想等。 因此，我们需要一个好的哈希函数(hash function)。通过哈希函数，我们可以算出子串的哈希值，然后将它和目标字符串中的子串的哈希值进行比较。 这个新方法在速度上比暴力法有显著提升。

Rabin-Karp 算法的思想：

1. 假设子串的长度为M(pat), 目标字符串的长度为N(txt)

2. 计算子串的hash值 hash_pat

3. 计算目标字符串txt中每个长度为M的子串的hash值(共需要计算 N-M+1 次)

4. 比较hash值：如果hash值不同，字符串必然不匹配；如果hash值相同，还需要使用朴素算法再次判断


Rabin-Karp:

```java
public final static int D = 256;
public final static int Q = 9997;

static int RabinKarpSerach (String txt, String pat) {
    int M = pat.length();
    int N = txt.length();

    int i,j;
    int patHash = 0, txtHash = 0;

    for (i = 0; i < M; i++) {
        patHash = (D * patHash + Pat.charAt(i)) % Q;
        txtHash = (D * txtHash + txt.charAt(i)) % Q;
    }

    int highestPow = 1; // pow(256, M - 1)
    for(i = 0; i < M; i++) {
        highestPow = (highestPow * D) % Q;

    }

    for(i = 0; i <= N - M; i++) { // 枚举起点
        if(patHash == txtHash) {
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAtA(j))
                    break;
            }
            if (j == M)
                return i;
        }

        if (j < N - M) {
            txtHash = (D * (txtHash - txt.charAt(i) * highestPow) + txt.charAt(i + M)) % Q;
            if (txtHash < 0 ) 
                txtHash += Q;
        }

    }
    return -1;
}

#### KMP算法

KMP算法的思想就是， 当子串与目标字符串不匹配时，其实你已经知道了前面已经匹配成功那一部分的字符(包括子串与目标字符串)。以阮一峰的文章为例，当空格与D不匹配时，你其实知道前面六个字符是"ABCDAB"。KMP算法的想法是，设法利用这个已知信息，不要把‘搜索位置’移回已经比较过的位置，继续把他向后移，这样就提高了效率。