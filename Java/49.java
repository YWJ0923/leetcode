class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String stmp = new String(tmp);
            if (map.containsKey(stmp)) {
                map.get(stmp).add(str);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(str);
                map.put(stmp, list);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
