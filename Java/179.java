class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.equals(s2)) {
                    return 0;
                }
                StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
                sb1.append(s1);
                sb1.append(s2);
                sb2.append(s2);
                sb2.append(s1);
                return sb2.compareTo(sb1);
            }
        });
        if ("0".equals(arr[0])) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        for (String str : arr) {
            res.append(str);
        }
        return res.toString();
    }
}
