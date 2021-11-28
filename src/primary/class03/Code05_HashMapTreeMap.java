package primary.class03;

import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @author xt
 * @Desc
 */
public class Code05_HashMapTreeMap {
    public static class Node {
        public int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Tsubasa", "足球小子");
        System.out.println(map.containsKey("Tsubasa"));
        System.out.println(map.containsKey("To"));
        System.out.println(map.get("Tsubasa"));

        map.put("Tsubasa", "Captain Tsubasa");
        System.out.println(map.get("Tsubasa"));

//        map.remove("Tsubasa");
//        System.out.println(map.containsKey("Tsubasa"));
//        System.out.println(map.get("Tsubasa"));

        String str1 = "Tsubasa";
        String str2 = "Tsubasa";
        System.out.println(str1 == str2);
        System.out.println(map.containsKey(str1));
        System.out.println(map.containsKey(str2));

        HashMap<Integer, String> map2 = new HashMap<>();
        map2.put(1234567, "我是1234567");
        Integer a = 1234567;
        Integer b = 1234567;
        System.out.println(a == b);
        System.out.println(map2.containsKey(a));
        System.out.println(map2.containsKey(b));

        Node node1 = new Node(1);
        Node node2 = new Node(1);
        HashMap<Node, String> map3 = new HashMap<>();
        map3.put(node1, "我进来了");
        System.out.println(map3.containsKey(node1));
        System.out.println(map3.containsKey(node2)); // false

        System.out.println("==============");

        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(3, "我是3");
        treeMap.put(0, "我是0");
        treeMap.put(7, "我是7");
        treeMap.put(2, "我是2");
        treeMap.put(5, "我是5");
        treeMap.put(9, "我是9");

        System.out.println(treeMap.containsKey(7));
        System.out.println(treeMap.containsKey(6));
        System.out.println(treeMap.get(3));

        treeMap.put(3, "他是3");
        System.out.println(treeMap.get(3));

        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.lastKey());
        // <=5 离5最近的key告诉我
        System.out.println(treeMap.floorKey(5));
        // <=6 离6最近的key告诉我
        System.out.println(treeMap.floorKey(6));
        // >=5 离5最近的key告诉我
        System.out.println(treeMap.ceilingKey(5));
        // >=6 离6最近的key告诉我
        System.out.println(treeMap.ceilingKey(6));

        Node node3 = new Node(3);
        Node node4 = new Node(4);
        TreeMap<Node, String> treeMap2 = new TreeMap<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.value - o2.value;
            }
        });
        treeMap2.put(node3, "我是3");
        treeMap2.put(node4, "我是4");
        System.out.println(treeMap2);
    }
}
