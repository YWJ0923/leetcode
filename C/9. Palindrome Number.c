#include <stdbool.h>

//自己想的  16ms  7.1MB  
//翻转了整个数字
bool isPalindrome(int x)
{
    if(x < 0 || x % 10 == 0 && x != 0)  return false;
    if(x >= 0 && x <= 9)  return true;
    long long rev = 0;
    int tmp = x;
    while(tmp){
        rev = rev * 10 + tmp % 10;
        tmp /= 10;
    }
    if(rev == x)  return true;
    else  return false;
}

//标准答案  8ms  7.1MB
//只要翻转半个数字就行
bool isPalindrome(int x)
{
    if(x < 0 || x % 10 == 0 && x != 0)  return false;
    if(x >= 0 && x <= 9)  return true;
    int rev = 0;
    while(x > rev){
        rev = rev * 10 + x % 10;
        x /= 10;
    }
    return x == rev || x == rev / 10;
}
