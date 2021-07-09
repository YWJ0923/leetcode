//自己想的  68ms  7.4MB
#include <string.h>
#include <stdlib.h>

int lengthOfLongestSubstring(char * s)
{
    if(!strlen(s))  return 0;
    int maxlen = 1;
    int len = 1;
    char *tmp = (char *)malloc(sizeof(char) * strlen(s) + 1);
    tmp[0] = s[0];
    tmp[1] = '\0';
    int n = 1;
    for(int i = 1; s[i] != '\0'; i++){
        char *position = strchr(tmp, s[i]);
        if(position == NULL){
            tmp[n++] = s[i];
            tmp[n] = '\0';
            len++;
            if(len > maxlen)  maxlen = len;
        }
        else{
            len = 1;
            if(position - tmp == n - 1)
                tmp[0] = s[i];
            else{
                tmp[0] = tmp[position - tmp + 1];
                i = i - (strlen(tmp) - (position - tmp));
            }
            for(int j = 1; j < n; j++)
                tmp[j] = '\0';
            n = 1;
        }
    }
    free(tmp);
    return maxlen;
}

//别人的  感觉应该挺容易想出来的  8ms  7.2MB
int lengthOfLongestSubstring(char* s) {
    int count=1;
    int max_count=1;
    int j_start=0;
    
    if(!s[0])
        return 0;
    else if(!s[1])
        return max_count;
    
    for(int i=1; s[i]; i++)
    {
        for(int j=j_start; j<i; j++)
        {
            if(s[i] != s[j])
                count++;
            else{
                j_start = j+1;     
            }
                    
        }
        if(max_count < count)
            max_count = count;
        count = 1;
    }
    return max_count;
}