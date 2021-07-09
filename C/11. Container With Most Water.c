
//自己写的，暴力无脑，O(n^2)，1072ms，7.9MB 
int maxArea(int* height, int heightSize)
{
    int m = 0;
    int tmp = 0;
    for(int i = 0; i < heightSize; i++){
        for(int j = i + 1; j < heightSize; j++){
            tmp = ((height[i] < height[j]) ? height[i] : height[j]) * (j - i);
            if(tmp > m)     m = tmp; 
        }
    }
    return m;
}

//答案解法  从两边开始，遍历一次，短的那根移动  12ms  7.9MB
int maxArea(int *height, int heightSize)
{
    int m = 0;
    int tmp;
    int left = 0;
    int right = heightSize - 1;
    while(left < right){
        if(height[left] < height[right]){
            tmp = height[left] * (right - left);
            if(tmp > m)     m = tmp;
            left++;
        }
        else{
            tmp = height[right] * (right - left);
            if(tmp > m)     m = tmp;
            right--;
        }
    }
    return m;
}