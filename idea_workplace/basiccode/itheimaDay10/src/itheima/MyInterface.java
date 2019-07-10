package itheima;

public interface MyInterface {
    public abstract void method01();
    public static final int a=123;
    public default void method02(){
        System.out.println("默认方法");

    }
    public static void method03(){
        System.out.println("静态方法");
    }
    private void method04(){
        System.out.println("私有方法");
    }
}
