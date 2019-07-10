package inclass.demo01;

public class dick {
    private String file;

    @Override
    public String toString() {
        return "dick{" +
                "file='" + file + '\'' +
                '}';
    }
    public void use(String s1,String s2){
        System.out.println(s1+s2);
    }
    public void use2(){
        System.out.println("还是无用");
    }
}
