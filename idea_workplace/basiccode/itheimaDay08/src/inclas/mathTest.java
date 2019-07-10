package inclas;

public class mathTest {
    public static void main(String[] args) {
        double max=100.9;
        int count=0;
        double min=-12.12;
        for(double i=Math.floor(max);i>=min;i--){
            if(i>46||Math.abs(i)>70){
                System.out.print(i+"  ");
                count++;
            }
        }
        System.out.println();
        System.out.println("总共的个数为："+count);
    }
}
