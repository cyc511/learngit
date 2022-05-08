import java.util.Scanner;

public class experiment1_1 {
    public static void main(String[] args){
        System.out.println("202012900410邓世玮");
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数");
        double x = sc.nextDouble();
        double y ;
        if(x < 1){
            y = x;
        }else if(x <= 10){
            y = x * 3 - 1;
        }else{
            y = x * 4 + 2;
        }
        System.out.println(y);
    }
}
