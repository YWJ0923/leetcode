class Solution {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        List<char[]> partital = new ArrayList<>();
        int len1 = num1.length(), len2 = num2.length();
        for (int i = len2 - 1; i >= 0; i--) {
            StringBuilder tmp = new StringBuilder();
            int carry = 0;
            for (int j = 0; j < len2 - i - 1; j++) {
                tmp.append(0);
            }
            for (int j = len1 - 1; j >= 0; j--) {
                int product = (arr1[j] - '0') * (arr2[i] - '0') + carry;
                tmp.append(product % 10);
                carry = product / 10;
            }
            if (carry != 0) {
                tmp.append(carry);
            }
            partital.add(tmp.toString().toCharArray());
        }
        StringBuilder res = new StringBuilder();
        int maxLen = 0;
        for (char[] arr : partital) {
            maxLen = Math.max(maxLen, arr.length);
        }
        int carry = 0;
        for (int i = 0; i < maxLen; i++) {
            int sum = 0;
            for (int j = 0; j < partital.size(); j++) {
                if (i < partital.get(j).length) {
                    sum += partital.get(j)[i] - '0';
                }
            }
            sum += carry;
            res.append(sum % 10);
            carry = sum / 10;
        }
        if (carry > 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
