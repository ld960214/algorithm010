class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        if (s == null || p == null || s.length() < p.length()) return new ArrayList<>();
        
        List<Integer> list = new ArrayList<>();

        int[] pArr = new int[26];
        int pSize = p.length();
        int[] sArr = new int[26];
    
        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a']++;  
            pArr[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            int index = p.charAt(i) - 'a';
            if (pArr[index] == sArr[index]) 
                pSize--;
        }
        
        int i = 0;
        int j = p.length();
        
        // 窗口大小固定为p的长度
        while (j < s.length()) {
            if (isSame(pArr, sArr))
                list.add(i);            
            //sArr[s.charAt(i) - 'a']-- 左指针位置处字母减1
            sArr[s.charAt(i) - 'a']--;
            i++;
                //sArr[s.charAt(j) - 'a']++ 右指针位置处字母加1
                sArr[s.charAt(j) - 'a']++;
            j++;
        }
        
        if (isSame( pArr, sArr))
            list.add(i);
        
        return list;
    }

    public boolean isSame(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; ++i)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }
}