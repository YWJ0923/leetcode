class Solution {
    public int translateNum(int num) {
        if (num == 0) {
            return 1;
        }
        if (num % 100 <= 25 && num % 100 >= 10) {
            return translateNum(num / 100) + translateNum(num / 10);
        } else {
            return translateNum(num / 10);
        }
    }
}