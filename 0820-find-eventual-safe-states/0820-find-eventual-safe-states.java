class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer , Boolean > memo = new HashMap<>();
        for(int i =0; i< graph.length; i++){
            // Terminal node
            if(graph[i].length ==0){
                memo.put(i , true);

            }
           
        }
         for(int i =0; i < graph.length; i++){
                boolean result = dfs(i , graph , new HashSet<Integer>() , memo);
                memo.put(i , result);

            }
            List <Integer> l = new ArrayList<>();
            for(int i =0; i < graph.length; i++){
                if(memo.get(i)){
                    l.add(i);
                }
            }
            return l;
    }
    private boolean dfs(int curr , int[][] graph , Set<Integer> visited ,Map<Integer , Boolean > memo ){
        if(memo.containsKey(curr)){
            return memo.get(curr);
        }
        //if node is visited , it means multiple possible paths in that noe , so will return false
        if(visited.contains(curr)){
            return false;
        }
        visited.add(curr);
        for(int i : graph[curr]){
            boolean flag = dfs(i , graph , visited , memo);
            if(flag){
                memo.put(i , true);
            }else{
                return false;
            }
        }
        //backtracking
        visited.remove(curr);
        return true;

    }
}