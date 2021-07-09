class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t r;
        uint32_t sum = 0;
        for (int i = 1; i <= 32; i++) {
            r = n & 1;
            sum = (sum << 1) + r;
            n >>= 1;
        }
        return sum;
    }
};