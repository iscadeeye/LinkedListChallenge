
package academy.learningProgramming;

public class Main {


        public static void main(String[] args) {


            MyLinkedList list = new MyLinkedList(null);
            String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
            String[] data = stringData.split(" ");
            for (String city : data) {
                list.addItem(new Node(city));

            }


            list.removeItem(new Node("4"));
            list.removeItem(list.getRoot());

            list.removeItem(new Node("3"));
            list.removeItem(list.getRoot());
        }
        
}