package Leetcode;

public class LongestSubString3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring01("bbbbb"));
        System.out.println(lengthOfLongestSubstring02("bbbbb"));
    }

    // when string only contains 26 alphabets
    public static int lengthOfLongestSubstring01(String s) {
        boolean[] alphabets = new boolean[128];
        String currentString = "";
        String longestSubString = "";

        for(int i = 0; i < s.length(); i++){
            int currCharacter = s.charAt(i) - 'a';
            if(alphabets[currCharacter] == false){
                currentString += s.charAt(i);
                alphabets[currCharacter] = true;
            }
            else{
                if(longestSubString.length() < currentString.length()){
                    longestSubString = currentString;;
                }
                currentString = "";
                alphabets = new boolean[26];
                currentString += s.charAt(i);
                alphabets[currCharacter] = true;
            }
        }
        if(longestSubString.length() < currentString.length()){
            longestSubString = currentString;
        }
        return longestSubString.length();
    }

    // when string contains all alphabets and spaces, symbols, numeric chars, etc
    public static int lengthOfLongestSubstring02(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] lastIndex = new int[128];

        for (int start = 0, end = 0; end < n; end++) {
            char currentChar = s.charAt(end);
            start = Math.max(start, lastIndex[currentChar]);
            maxLength = Math.max(maxLength, end - start + 1);
            lastIndex[currentChar] = end + 1;
        }

        return maxLength;
    }
}
