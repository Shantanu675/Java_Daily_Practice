package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Box{
    String s;
    int length;

    Box(String s, int length){
        this.s = s;
        this.length = length;
    }
}

public class WordLadderI {
    public static void main(String[] args) {
//        String beginWord = "hit";
//        String targetWord = "cog";
//
//        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};

        String beginWord = "der";
        String targetWord = "dfs";

        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};

        System.out.println(wordLadderlength(beginWord, targetWord, wordList));
    }

    private static int wordLadderlength(String beginWord, String targetWord, String[] wordList) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < wordList.length; i++){
            set.add(wordList[i]);
        }

        Queue<Box> q = new LinkedList<>();
        q.offer(new Box(beginWord, 1));
        set.remove(beginWord);

        while (! q.isEmpty()){
            Box current = q.poll();
            String currStr = current.s;
            int len = current.length;

            for (int i = 0; i < currStr.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    String newStr = currStr.replace(currStr.charAt(i),j);
                    if(newStr.equals(targetWord)){
                        return len+1;
                    }
                    if(set.contains(newStr)){
                        q.offer(new Box(newStr, len+1));
                        set.remove(newStr);
                    }
                }
            }
        }
        return -1;
    }
}