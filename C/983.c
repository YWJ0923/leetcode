/*
我们用 dp[i] 来表示从第 i 天开始到一年的结束，我们需要花的钱。考虑到一张通行证可以让我们在「接下来」的若干天进行旅行，所以我们「从后往前」倒着进行动态规划。

对于一年中的任意一天：

如果这一天不是必须出行的日期，那我们可以贪心地选择不买。这是因为如果今天不用出行，那么也不必购买通行证，并且通行证越晚买越好。所以有 dp[i] = dp[i + 1]；

如果这一天是必须出行的日期，我们可以选择买 1，7 或 30 天的通行证。若我们购买了 j 天的通行证，那么接下来的 j - 1 天，我们都不再需要购买通行证，只需要考虑第 i + j 天及以后即可。因此，我们有

dp[i] = min{costs[0] + dp[i + 1], costs[1] + dp[i + 7], costs[2] + dp[i + 30]};

为什么我们只需要考虑第 i + j 天及以后呢？这里和第一条的贪心思路是一样的，如果我们需要购买通行证，那么一定越晚买越好，在握着一张有效的通行证的时候购买其它的通行证显然是不划算的。

*/
#define MAXDAY 400

int Min(int x, int y)
{
    return x < y ? x : y;
}

int mincostTickets(int* days, int daysSize, int* costs, int costsSize){
    int *dp = (int *)malloc(sizeof(int) * MAXDAY);
    memset(dp, 0, sizeof(int) * MAXDAY);
    for (int i = days[daysSize - 1], j = daysSize - 1; j >= 0; i--) {
        if (i == days[j]) { 
            dp[i] = Min(Min(dp[i + 1] + costs[0], dp[i + 7] + costs[1]), dp[i + 30] + costs[2]);
            j--;
        }
        else
            dp[i] = dp[i + 1];
    }
    return dp[days[0]];
}