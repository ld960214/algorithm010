class Solution {
public boolean isIsomorphic(String s, String t) {
        return canMap(s, t) && canMap(t, s);
    }

    private boolean canMap(String s, String t){
        int[] map = new int[128]; // ascii 128个字符
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for(int i = 0; i < chars1.length; i++){
            if(map[chars1[i]] == 0)
                map[chars1[i]] = chars2[i];
            else {
                if(map[chars1[i]] != chars2[i])
                    return false;
            }
        }
        return true;
    }
}