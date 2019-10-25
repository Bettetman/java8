package cn.sicnu.frank;

public class lambdaTest {

    public  void  test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println( "开始测试///" );
            }
        };
        r1.run();
    }

}
