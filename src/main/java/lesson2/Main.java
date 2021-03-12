package lesson2;

public class Main {
    public static void main(String[] args) {
      MyArrayList myArrayList = new MyArrayList();
      Integer i = 0;
      String s = i.toString();
      for (int j = 0; j < 20; j++) {
         myArrayList.add(s);
         i++;
         s = i.toString();
      }
      myArrayList.add(0, "99");
      System.out.println(myArrayList.toString());

      myArrayList.remove(0);
      System.out.println(myArrayList.toString());

      myArrayList.remove("108");
        System.out.println(myArrayList.toString());

    MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
        Integer ii = 0;
        String ss = ii.toString();
        for (int j = 0; j < 10; j++) {
            myLinkedList.insertFirst(ss);
            ii++;
            ss = ii.toString();
        }

        System.out.println("MyLinkedList");

        System.out.println(myLinkedList.toString());

    }
}
