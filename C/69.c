//偷懒法
#include <math.h>

int mySqrt(int x){
    return (int)sqrt(x);
}

//x^1/2换成e^(1/2 * lnx)
#include <math.h>
int mySqrt(int x)
{
    if (x == 0)
        return 0;
    int ans = exp(0.5 * log(x));
    return (long long)(ans + 1) * (ans + 1) <= x ? ans + 1 : ans;   //exp和log计算的都是浮点数，会有误差，所以要选择到底返回ans + 1还是ans
}