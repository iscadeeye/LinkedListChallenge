package academy.learningProgramming;

public class MyLinkedList implements NodeList {
    private ListItem root = null;

    //Constructor


    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    //Implement methods defined by MyLinkedList.
    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) { // The list was empty so 'this' becomes head.
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;

        while (currentItem != null){
            int comparison = currentItem.compareTo(newItem);
            if (comparison < 0){
                //newItem is greater, move right if possible.
                if (currentItem.next() != null){
                    currentItem = currentItem.next();
                }else {
                    //There isn't next. insert at the end of the list.
                    currentItem.setNext(newItem).setPrevious(currentItem);

                    return true;
                }
            } else if (comparison > 0){
                // new is less, insert before.
                if (currentItem.previous() != null){

                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());

                    newItem.setNext(currentItem).setPrevious(newItem);
                }else {
                    //The node with a previous is the root.
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                //equal.
                System.out.println(newItem.getValue() + " is already present. NOT ADDED");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null){
            System.out.println("Deleting item: "+ item.getValue() + "...");
            ListItem currentItem = this.root;

            while (currentItem != null){
                int comparison = currentItem.compareTo(item);

                if (comparison == 0) {
                    if (currentItem == this.root) {
                        //found teh item
                        this.root = currentItem.next();
                    }else {
                        currentItem.previous().setNext(currentItem.next());
                        if (currentItem.next() != null){
                            currentItem.next().setPrevious(currentItem.previous());
                        }
                    }
                    return true;
                } else if(comparison < 0){
                    currentItem = currentItem.next();
                }else {
                    return false;
                }
            }

        }
        //reached end of the list without  finding item to delete.
        return false;
    }

    @Override
    public void traverse(ListItem item) {
        if (root == null){
            System.out.println("The list is empty.");
        }else {
            while (root != null){
                System.out.println(root.getValue());
                root = root.next();
            }
        }

    }
}
