package Graphs;

import java.util.*;

public class WordLadderII {
    public static void main(String[] args) {
        String beginWord = "der";
        String targetWord = "dfs";

        String[] wordList = {"des", "der", "dfr", "dgt", "dfs"};

        List<List<String>> result = wordLadder(beginWord, targetWord, wordList);
        System.out.println(Arrays.toString(result.stream().toArray()));
    }

    public static List<List<String>> wordLadder(String begWord, String targetWord, String[] wordList){
        List<List<String>> result = new ArrayList<>();

        Set<String> set = new HashSet<>();
        for (int i = 0; i < wordList.length; i++) {
            set.add(wordList[i]);
        }

        Queue<List<String>> q = new LinkedList<>();

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(begWord);
        int level = 0;

        q.offer(usedOnLevel);

        while(! q.isEmpty()){
            List<String> current = q.poll();
            String currStr = current.get(current.size()-1);

            if(current.size() > level){
                level++;
                for (String it : usedOnLevel){
                    set.remove(it);
                }
            }

            if (currStr.equals(targetWord)){
                if(result.size() == 0){
                    result.add(current);
                } else if (result.get(0).size() == current.size()) {
                    result.add(current);
                }
            }

            int len = currStr.length();
            for (int i = 0; i < len; i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    String newStr = currStr.replace(currStr.charAt(i), j);
                    if(set.contains(newStr)) {
                        current.add(newStr);
                        List<String> temp = current;

                        q.add(temp);
                        //usedOnLevel.add(newStr);
                        current.remove(current.size()-1);
                    }
                }
            }
        }
        return result;
    }
}
