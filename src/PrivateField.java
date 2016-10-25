public class PrivateField {
    public static void main(String[] args) {
        Child child = new Child();
        child.printi();
        child.printj();
        child.printk();
    }
}


class Parent {
    private int i = 1;
    protected int j = 1;
    public int k = 1;

    public void printi() {
        System.out.println("i = " + i);
    }

    public void printj() {
        System.out.println("j = " + j);
    }

    public void printk() {
        System.out.println("k = " + k);
    }
}

class Child extends Parent{
    protected int i = 2;
    protected int j = 2;
    public int k = 2;
}