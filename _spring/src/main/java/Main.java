import com.atbit.Duck;
import com.atbit.Student;
import com.atbit.Student2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author hyc
 * @date 2020/8/10
 **/
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applications.xml");

        String str = (String)context.getBean("myName");
        System.out.println(str);

 /*       String s = context.getBean(String.class);//可以根据类型获得对象，如果该类型有多个对象，则会报错
        //也就是说只能适用于只有一个该类型的对象时才能获得该对象
        System.out.println(s);

        Student s1 = (Student) context.getBean("s1");
        System.out.println(s1);

        Student2 s2 =(Student2) context.getBean("s2");
        System.out.println(s2);*/

        Duck duck = (Duck)context.getBean("d1");
        System.out.println(duck);

    }
}