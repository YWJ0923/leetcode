class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            res.add((digits[i] + carry) % 10);
            carry = (digits[i] + carry) / 10;
        }
        if (carry != 0) {
            res.add(carry);
        }
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(res.size() - i - 1);
        }
        return answer;
    }
}
