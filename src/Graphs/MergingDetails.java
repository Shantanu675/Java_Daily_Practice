package Graphs;

import java.util.*;

public class MergingDetails {
    public static void main(String[] args) {
        int n = 6;
        List<List<String>> details = new ArrayList<>();

        details.add(Arrays.asList("John", "j1@com", "j2@com", "j3@com"));
        details.add(Arrays.asList("John", "j4@com"));
        details.add(Arrays.asList("raj", "r1@com", "r2@com"));
        details.add(Arrays.asList("John", "j1@com", "j5@com"));
        details.add(Arrays.asList("raj", "r2@com", "r3@com"));
        details.add(Arrays.asList("Marry", "m1@com"));

        System.out.println(Arrays.toString(mergeDetails(n, details).toArray()));
    }

    private static List<List<String>> mergeDetails(int n, List<List<String>> details){
        //List<List<String>> mergeDetails = new ArrayList<>();

        DiSet ds = new DiSet(n);
        HashMap<String, Integer> mapNode = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < details.get(i).size(); j++) {
                String mail = details.get(i).get(j);
                if(mapNode.containsKey(mail) == false){
                    mapNode.put(mail, i);
                }
                else {
                    ds.unionByRank(i, mapNode.get(mail));
                }
            }
        }

        ArrayList<String>[] mergeMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergeMail[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> it : mapNode.entrySet()){
            String mail = it.getKey();
            int node = it.getValue();
            mergeMail[ds.findParent(node)].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(mergeMail[i].size() == 0) continue;
            Collections.sort(mergeMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(details.get(i).get(0));
            for (String cs : mergeMail[i]){
                temp.add(cs);
            }
            ans.add(temp);
        }
        return ans;
    }
}
