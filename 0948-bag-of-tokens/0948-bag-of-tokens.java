class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // Initialize variables to keep track of the maximum and current scores.
        int maxScore = 0; // Initialize maxScore to 0.
        int score = 0;    // Initialize score to 0.
        int n = tokens.length; // Get the number of tokens.
        int i = 0, j = n - 1;  // Initialize pointers to the first and last tokens.
        
        // Sort the tokens in ascending order to efficiently play them.
        Arrays.sort(tokens);
        
        // Iterate through the tokens.
        while (i <= j) {
            if (power >= tokens[i]) {
                // If you have enough power to play the token face up:
                power -= tokens[i]; // Deduct the token's power from your power.
                score++;           // Increase your score by 1.
                i++;               // Move to the next token.
            } else if (score >= 1) {
                // If you have a score of at least 1 and can play a token face down:
                power += tokens[j]; // Gain the token's power.
                score--;            // Decrease your score by 1.
                j--;                // Move to the previous token.
            } else {
                // If you cannot play any more tokens, break the loop.
                break;
            }
            
            // Update maxScore with the maximum score achieved so far.
            maxScore = Math.max(maxScore, score);
        }
        
        // Return the maximum score obtained.
        return maxScore;
    }
}
