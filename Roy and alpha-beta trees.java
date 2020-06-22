import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class ANKBST02_solver {
    long go(int lo, int hi, int odd) {
        if (lo > hi) {
            return 0;
        }
        if (dp[lo][hi][odd] == -1) {
            long ans = 0;
            for (int root = lo; root <= hi; root++) {
                //consider all BST in left subtree of root
                ans += (go(lo, root - 1, 1 -odd) * cnt[hi - root - 1 + 1]) % MOD;
                if (ans >= MOD) ans -= MOD;
                if (ans < 0) ans += MOD;
                //consider all BST in right subtree
                ans += (go(root + 1, hi, 1 -odd) * cnt[root - 1 - lo + 1]) % MOD;
                if (ans >= MOD) ans -= MOD;
                if (ans < 0) ans += MOD;
                //totTrees is total number of trees considered
                long totTrees = (cnt[hi - root] * cnt[root - lo]) % MOD;
                //remember to add the root as many times for each tree
                ans += (totTrees * ((mul[odd] * a[root]) % MOD)) % MOD;
                if(ans >= MOD) ans -= MOD;
                if (ans < 0) ans += MOD;
            }
            dp[lo][hi][odd] = ans;
        }
        return dp[lo][hi][odd];
    }

    public void solve() throws IOException {
        cnt = generateCatalan(205, MOD);
        cnt[0] = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());

        while (t --> 0) {
            int n = Integer.parseInt(br.readLine());
            assert(n <= 200);
            a = new long[n] ;
            mul = new long[2];
            int i = 0;
            for (StringTokenizer tokenizer = new StringTokenizer(br.readLine()); tokenizer.hasMoreTokens(); 