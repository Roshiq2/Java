import java.util.*;

public class Test {
    public static Queue processScheduling(Stack<String> inStrStack) {
        Queue outStrQueue = new LinkedList();
        Map<Integer, String> p1 = new TreeMap<>();
        Map<Integer, String> p2 = new TreeMap<>();
        Map<Integer, String> p3 = new TreeMap<>();
        List<Map<Integer, String>> l = new ArrayList<>(Arrays.asList(p1, p2, p3));

        while (!inStrStack.isEmpty()) {
            String s = inStrStack.pop();
            if (s.charAt(2) == '1') {
                p1.put(s.charAt(0) - 48, s);
            } else if (s.charAt(2) == '2') {
                p2.put(s.charAt(0) - 48, s);
            } else if (s.charAt(2) == '3') {
                p3.put(s.charAt(0) - 48, s);
            }
        }
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        for (Map<Integer, String> a : l) {
            for(String s:a.values()){
                outStrQueue.add(s);
            }
        }
            return outStrQueue;
    }
    public static void main(String[] args) {

        Stack inStrStack = new Stack();
        inStrStack.push("4P2");
        inStrStack.push("3P1");
        inStrStack.push("2P1");
        inStrStack.push("1P2");


        System.out.println(processScheduling(inStrStack));

    }
}
