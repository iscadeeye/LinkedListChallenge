
package academy.learningProgramming;

public class Main {


        public static void main(String[] args) {
            SearchTree tree = new SearchTree(null);
            tree.traverse(tree.getRoot());

            String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";
            String[] data = stringData.split(" ");

            for (String city : data) {
                tree.addItem(new Node(city));

            }

            while (tree.getRoot() != null ){

                if (tree.getRoot().next() == null){
                    System.out.println("Deleting last item which is " + tree.removeItem(tree.getRoot()));
                }
                tree.traverse(tree.getRoot());
                tree.removeItem(tree.getRoot());
                System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++");

            }


        }

}