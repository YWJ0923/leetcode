//自己想的  4ms 6.5MB

#include <limits.h>

int myAtoi(char * str)
{
    int i = 0;
    while(str[i] == ' ')
        i++;
    if((str[i] != '-' && str[i] != '+' && (str[i] < '0' || str[i] > '9')) || ((str[i] == '-' || str[i] == '+') && (str[i + 1] < '0' || str[i + 1] > '9')))  return 0;
    int sign;
    if(str[i] == '-'){
        sign = -1;
        i++;
    }
    else if(str[i] == '+'){
        sign = 1;
        i++;
    } 
    else  sign = 1;
    int sum = 0;
    while(str[i] >= '0' && str[i] <= '9'){
        if (sum > INT_MAX / 10 || (sum == INT_MAX / 10 && str[i] > '7'))  return INT_MAX;
        if (sum < INT_MIN / 10 || (sum == INT_MIN / 10 && str[i] > '8'))  return INT_MIN;
        sum = (sign == 1) ? (str[i] - '0' + sum * 10) : (-str[i] + '0' + sum * 10);
        i++;
    }
    return sum;
}

//0ms的他们设输出为double，赖皮tm，所以他们空间占得多