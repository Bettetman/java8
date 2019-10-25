package cn.sicnu.frank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;

import static org.junit.Assert.*;

public class lambdaTest {

    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println( "开始测试///" );
            }
        };
        r1.run();


        System.out.println( "*****************************" );
        Runnable r2 = ()->System.out.println( "测试lambda" );
        r2.run();
    }
    @Test
    public  void  test2(){
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare( o1,o2 );
            }

        };
        int end =comparator.compare( 12, 21);
        System.out.println( end );

        System.out.println("*****************lambda****************");
        Comparator<Integer> cm2 = ((o1, o2) -> Integer.compare( o1,o2 ));
        int compare = cm2.compare( 21, 12 );
        System.out.println(compare);

        System.out.println("*********方法引用*********");
        Comparator<Integer> cm3 = Integer::compareTo;
        int compare1 = cm3.compare( 15, 51 );
        System.out.println(compare1);
    }
    @Test
    public void  test3()
    {
        //无参 无返回值
        Runnable r1  = ()-> System.out.println("helloword");
        r1.run();
        //有参，无返回值
        Consumer<String> con1 = (String s) -> System.out.println(s);
        con1.accept( "誓言和谎言的区别是什么？" );
        //数据类型可以省略，由编译器推断得出，称为类型推断
        ArrayList<String> objects = new ArrayList<>();//类型推断
        Consumer<String> con2 = (s) -> System.out.println(s);
        con2.accept( "一个说话的人当真了，一个听话的人当真了" );

        //一个参数，可省
        Consumer<String> con3 = s -> System.out.println(s);
        con3.accept( "了解" );
        //2个参数，允许有多个返回值
        Comparator<Integer> comparator = ((o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo( o2 );
        });
        int compare = comparator.compare( 12, 21 );
        System.out.println(compare);
        //2个参数，只有一条语句，{return }可省
        Comparator<Integer> cm2 =(o1,o2)-> o1.compareTo( o2 );
        int compare1 = cm2.compare( 12, 21 );
        System.out.println(compare1);

    }
}