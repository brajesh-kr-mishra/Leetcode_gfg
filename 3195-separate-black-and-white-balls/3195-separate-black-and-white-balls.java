/*public long minimumSteps(String s) {
  int n = s.length();
  int blackBallsRight[] = new int[n];
  int whiteBallsLeft[] = new int[n];

  // Count black balls to the right (optimized)
  int blackCount = 0;
  for (int i = n - 1; i >= 0; i--) {
    if (s.charAt(i) == '1') {
      blackCount++;
    }
    blackBallsRight[i] = blackCount;
  }

  // Count white balls to the left
  int whiteCount = 0;
  for (int i = 0; i < n; i++) {
    whiteBallsLeft[i] = whiteCount;
    if (s.charAt(i) == '0') {
      whiteCount++;
    }
  }

  // Find the minimum steps required
  long minSteps = Long.MAX_VALUE;
  for (int i = 0; i < n; i++) {
    minSteps = Math.min(minSteps, blackBallsRight[i] + whiteBallsLeft[i]);
  }

  return minSteps;
}*/class Solution {
    public long minimumSteps(String s) {
        long swap = 0;
        int black = 0; 
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') 
                swap += (long) black; 
            else
                black++; 
        }
        return swap;
    }
}

