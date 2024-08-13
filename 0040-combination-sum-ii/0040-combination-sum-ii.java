import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort the candidates array to help skip duplicates
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> currentCombination, List<List<Integer>> res) {
        // Base case: if the target is 0, add the current combination to the result
        if (target == 0) {
            res.add(new ArrayList<>(currentCombination));
            return;
        }

        // Iterate over the candidates starting from the 'start' index
        for (int i = start; i < candidates.length; i++) {
            // Skip duplicate numbers to avoid duplicate combinations in the result
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            
            // If the candidate is greater than the remaining target, stop further exploration
            if (candidates[i] > target) {
                break;
            }
            
            // Include the candidate in the current combination
            currentCombination.add(candidates[i]);
            
            // Recurse with the reduced target and the next starting index
            backtrack(candidates, target - candidates[i], i + 1, currentCombination, res);
            
            // Backtrack by removing the last element added
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}
