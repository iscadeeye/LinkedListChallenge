package academy.learningProgramming;
public class SearchTree implements NodeList {
    private ListItem root = null;
    public SearchTree(ListItem root) {
        this.root = root;
    }
    @Override
    public ListItem getRoot() {
        return this.root;
    }
    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null){
            //the tree was empty, so my item becomes the head of tree
            this.root = newItem;
            return true;
        }

        //otherwise, start comparing from the head od the tree.
        ListItem currentItem = this.root;
        while (currentItem != null){
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0){//newItem is greater, move right if possible.

                if (currentItem.next() != null){
                    currentItem = currentItem.next();
                }else {
                    currentItem.setNext(newItem);
                    return true;
                }
            } else if (comparison > 0){//newItem is less, move to the left if possible.
                if (currentItem.previous() != null){
                    currentItem = currentItem.previous();
                }else {//There isn't node to the left, so add at this point.
                    currentItem = currentItem.setPrevious(newItem);
                    return true;
                }
            }else {//Equal, so don't add.
                System.out.println(currentItem.getValue()+ " is present.");
                return false;
            }
        }
        //cannot get here but Java complains if there isn't return
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null){
            System.out.println("Deleting " + item.getValue());
        }

        ListItem currentItem = this.root;
        ListItem parentItem = currentItem;
        while (currentItem != null){
            int comparison = currentItem.compareTo(item);
            if (comparison < 0){
                parentItem = currentItem;
                currentItem = currentItem.next();

            }else if(comparison > 0){
                parentItem = currentItem;
                currentItem = currentItem.previous();

            }else {//Equal: we have found item so remove it.
                performRemoval(currentItem, parentItem);
                return true;
            }
        }//Java complains.
        return false;
    }
    private void performRemoval(ListItem item, ListItem parent){
        //remove item from the tree.
        if(item.next() == null){//No right tree, so make parent point to left tree which may be null.
            if (parent.next() == item){// item is right child of its parent.
                parent.setNext(item.previous());

            }else if (item.previous() == item){//item is left child of its parent.
                parent.setPrevious(item.previous());
            }else {//parent must be item, which means we were looking at root of the tree.
                this.root = item.previous();
            }

        }else if (item.previous() == null ){//No left tree, so make parent point ot tight tree (which may be null)
            if (parent.next() == item){//item is right child ot its parent.
                parent.setNext(parent.next());

            }else if(parent.previous() == item){//item is left child of its parent.
                parent.setPrevious(item.next());
            } else {// again, are deleting the root.
                this.root = item.next();
            }
        } else {//Neither left nor right are null, deletion is now a lot trickier
            //From the right subtree, find the smallest value (i.e. the leftmost)
            ListItem current = item.next();
            ListItem leftMostParent = item;
            while (current.previous() != null){
                leftMostParent = current;
                current = current.previous();
            }
            //Now put the smallest value into our node to be deleted.
            item.setValue(current.getValue());//and delete the smallest.
            if (leftMostParent == item){
                //There was no leftMost node, so 'current' points to the smallest node, which is the one
                //that must be deleted
                item.setNext(current.next());
            }else {
                //set the smallest node's parent to point to the smallest node's right child which may be null.
                leftMostParent.setPrevious(current.next());
            }
        }
    }
    @Override
    public void traverse(ListItem root) {
        //recursive method.

        if(root != null) {
            traverse(root.previous());
            System.out.println(root.getValue());
            traverse(root.next());
        }
    }
}
