class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int L =0, R =skill.length-1;
        
        int temp = skill[L]+skill[R];
        while(L<R){
            int a = skill[L]+skill[R];
           if(a!= temp){
            return (long)-1;
           }
           L++; R--;
        } 
        long res =0;
        int  i =0, j = skill.length-1;
        while(i< j){
            long tem = skill[i]*skill[j];
            res += tem;
            i++; j--;
        }
        return res;
    }
}