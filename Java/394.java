class Solution {
    int index = 0;
    public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque();
        while (index< s.length()) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                int repeat = 0;
                for (; Character.isDigit(s.charAt(index)); index++) {
                    repeat = repeat * 10 + s.charAt(index) - '0';
                }
                stack.push(String.valueOf(repeat));
            } else if (c == '[' || Character.isLetter(c)) {
                stack.push(String.valueOf(c));
                index++;
            } else {
                List<String> sub = new ArrayList();
                while (!"[".equals(stack.peek())) {
                    sub.add(stack.poll());
                }
                stack.poll();
                int repeat = Integer.parseInt(stack.poll());
                Collections.reverse(sub);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < sub.size(); i++) {
                    sb.append(sub.get(i));
                }
                while (repeat-- > 0) {
                    stack.push(sb.toString());
                }
                index++;
            }
        }
        while (!stack.isEmpty()) {
            res.append(stack.pollLast());
        }
        return res.toString();
    }
}