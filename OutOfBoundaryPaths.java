class Solution {
    Integer dp[][][];
    int mod=(int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        dp=new Integer[m][n][maxMove+1];
        return helper(m,n,maxMove,startRow,startColumn);
    }

    public int helper(int m, int n, int Move, int Row, int Column){
        if(Row<0 || Row>=m || Column<0 ||Column>=n){
            return 1;
        }

        if(Move<=0){
            return 0;
        }

        if(dp[Row][Column][Move]!=null){
            return dp[Row][Column][Move];
        }

        int ans = 0;
        ans = (ans + helper(m,n,Move-1,Row-1,Column))%mod;
        ans = (ans + helper(m,n,Move-1,Row+1,Column))%mod;
        ans = (ans + helper(m,n,Move-1,Row,Column-1))%mod;
        ans = (ans + helper(m,n,Move-1,Row,Column+1))%mod;
        
        return dp[Row][Column][Move] = ans;
    }
}
