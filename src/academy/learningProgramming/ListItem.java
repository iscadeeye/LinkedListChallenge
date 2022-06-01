package academy.learningProgramming;

public abstract class ListItem {

    //protected access modifier is accessible within the same package. how
    //however, it can also accessible outside the package but through inheritance.
    protected ListItem rightLink = null;
    protected  ListItem leftLink = null;

    /*Class Object is the root of the class hierarchy. Every class has Object as a superclass.
     All objects, including arrays, implement the methods of this class

     Object class is present in java.lang package.
     every class in Java is directly or indirectly derived form the Object class.
     if a class does not extend any other class, then it is direct child class of Object.
     */
    protected Object value;

    //Constructor

    public ListItem(Object value){
        this.value = value;
    }

    //methods to be implemented, and their return type is ListItem class.
    abstract ListItem next ();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract  ListItem setPrevious(ListItem item);
    abstract int compareTo(ListItem item);

    // +++++++++++++++getters and setters +++++++++

    //getter
    public Object getValue (){
        return value;
    }

    //setter.
    public void setValue(Object value){
        this.value = value;
    }

}
