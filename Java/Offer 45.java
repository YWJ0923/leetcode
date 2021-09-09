class Solution {
    public String minNumber(int[] nums) {
        int len = nums.length;
        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (x, y) -> {
            return (x + y).compareTo(y + x);
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}