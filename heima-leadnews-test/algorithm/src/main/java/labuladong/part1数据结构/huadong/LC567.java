package labuladong.part1数据结构.huadong;

public class LC567 {

    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        boolean b = checkInclusion(s1, s2);
    }

    public static boolean checkInclusion(String s1, String s2) {
        char[] pattern = s1.toCharArray();
        char[] text = s2.toCharArray();

        int pLen = s1.length();
        int tLen = s2.length();

        int[] pFreq = new int[26];
        int[] winFreq = new int[26];

        for (int i = 0; i < pLen; i++) {
            pFreq[pattern[i] - 'a']++;
        }

        int pCount = 0;
        for (int i = 0; i < 26; i++) {
            if (pFreq[i] > 0){
                pCount++;
            }
        }

        int left = 0;
        int right = 0;
        // 当滑动窗口中的某个字符个数与 s1 中对应相等的时候才计数
        int winCount = 0;
        while (right < tLen){
            if (pFreq[text[right] - 'a'] > 0 ) {
                winFreq[text[right] - 'a']++;
                if (winFreq[text[right] - 'a'] == pFreq[text[right] - 'a']){
                    winCount++;
                }
            }
            right++;

            while (pCount == winCount){
                if (right - left == pLen){
                    return true;
                }
                if (pFreq[text[left] - 'a'] > 0 ) {
                    winFreq[text[left] - 'a']--;
                    if (winFreq[text[left] - 'a'] < pFreq[text[left] - 'a']){
                        winCount--;
                    }
                }
                left++;
            }
        }
        return false;
    }


}
