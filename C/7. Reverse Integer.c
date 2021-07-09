//自己写的  4ms 6.7MB
//不用两次循环，不用数组，负数求余是负数
#include <math.h>
#include <limits.h>

int reverse(int x)
{
    int sign = (x < 0) ? -1 : 1;
    int k = (x < 0) ? (-x) : x;
    int digit[10];
    int i = 0;
    for(; k > 0; i++){
        digit[i] = k % 10;
        k /= 10;
    }
    long long sum = 0;
    for(int j = 0; j < i; j++){
        sum = sum * 10 + digit[j];
        if(sign * sum > INT_MAX || sign * sum < INT_MIN)  return 0;
    }
    return sign * sum;
}

//标准答案
int reverse(int x) {
    int rev = 0;
    while (x != 0) {
        int pop = x % 10;
        x /= 10;
        if (rev > INT_MAX/10 || (rev == INT_MAX / 10 && pop > 7)) return 0;
        if (rev < INT_MIN/10 || (rev == INT_MIN / 10 && pop < -8)) return 0;
        rev = rev * 10 + pop;
    }
    return rev;
}