//自己想的  32ms  7MB
#include <string.h>
#include <stdbool.h>

bool isValid(char * s){
    if(!s[0])  return true;
    if(s[0] != '(' && s[0] != '{' && s[0] != '[')  return false;
    int len = strlen(s);
    if(len % 2 == 1)  return false;
    int interval;
    for(interval = 1; interval < len; interval += 2){
        for(int i = 0; i < len - interval; i++){
            if(s[i] == '('){
                if(s[i + interval] == ')'){
                    s[i] = 'a';
                    s[i + interval] = 'a';
                }
            }
            else if(s[i] == '[' || s[i] == '{'){
                if(s[i + interval] == s[i] + 2){
                    s[i] = 'a';
                    s[i + interval] = 'a';
                }
            }
        }
    }
    for(int i = 0; i < len; i++){
        if(s[i] != 'a')  return false;
    }
    return true;
}

//瞟了眼答案，然后自己想的  0ms  6.9MB
#include <string.h>
#include <stdbool.h>

bool isValid(char * s){
    if(!s[0])  return true;
    if(s[0] != '(' && s[0] != '{' && s[0] != '[')  return false;
    int len = strlen(s);
    if(len % 2 == 1)  return false;
    int stack[len];
    int n = 0;
    for(int i = 0; i < len; i++){
        if(s[i] == '(' || s[i] == '[' || s[i] == '{'){
            stack[n++] = s[i];
        }
        else if(s[i] == ')'){
            if(stack[n - 1] == '(')
                n -= 1;
            else 
                return false;
        }
        else if(s[i] == ']' || s[i] == '}'){
            if(stack[n - 1] == s[i] - 2)
                n -= 1;
            else 
                return false;
        }
    }
    if(n > 0)  return false;
    else  return true;
}
