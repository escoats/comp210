package assn03;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList<Integer>();
        list.add(10);
        list.add(20);
        list.add(60);
        list.add(30);
        System.out.println("list = " + list.toString());
        System.out.println("size of list = " + list.size());
        System.out.println("list contains 10?: " + list.contains(10));     // implemented
        System.out.println("list contains 50?: " + list.contains(50));
        System.out.println("set element at index 2 to be 10");
        list.set(2, 10);
        System.out.println("get element at index 2 = " + list.get(2));
        System.out.println("list = " + list.toString());
        System.out.println("Last Index of element 10 in list = " + list.lastIndexOf(10));

        list.remove(20);
        System.out.println("list after removing 20 = " + list.toString());

        System.out.println("index of '30' = " + list.indexOf(30));
        

        // Test task 1
        System.out.println("LIST BEFORE REMOVAL: " + list.toString());
        list.removeAtIndex(1);  // TBD
        System.out.println("Task 1: list after removing element at index 1 = " + list.toString());

        // Test task 2
        LinkedList list2 = new LinkedList();
        list2.add(10);
        list2.add(10);
        System.out.println("list2 = " + list2.toString());
        System.out.println("Task 2: list == list2 ?: " + list.isEqual(list2));

        // Test task 3
        list.add(30);
        list.add(30);
        list.add(40);
        System.out.println("list before removing repeats = " + list.toString()); // TODO delete line?
        list.removeRepeats();
        System.out.println("Task 3: list after removing repeats = " + list.toString());

        // Test task 4
        LinkedList list3 = new LinkedList<Integer>();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(5);

        System.out.println("List before reversal: " +list3.toString());
        list3.reverse();
        System.out.println("list after reversal: " +list3.toString());

        // Test task 5
        System.out.println("task 5!!");
        LinkedList listA = new LinkedList<Character>();
        listA.add('a');
        listA.add('b');
        listA.add('c');
        listA.add('d');

        LinkedList listB = new LinkedList<Integer>();
        listB.add(1);
        listB.add(2);
        listB.add(3);
        listB.add(4);

        System.out.println("listA: " + listA.toString());
        System.out.println("listB: " + listB.toString());
        listA.merge(listB);
        System.out.println("merged!: " + listA.toString());
    }
}
