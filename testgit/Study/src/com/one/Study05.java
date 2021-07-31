package com.one;

import com.sun.deploy.net.cookie.CookieUnavailableException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.junit.Test;

import javax.crypto.spec.PSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.security.KeyStore;
import java.sql.Connection;
import java.util.*;

class Student implements Comparator<Student> {
    int age;
    String name;

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1.age > o2.age) {
            return 1;
        } else if (o1.age < o2.age) {
            return -1;
        }else {
            return 0;
        }
    }
}

class goods implements Comparable{
    String name;
    int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public goods(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public goods() {
    }

    @Override
    public String toString() {
        return "goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof goods) {
            goods god5 = (goods)o;
            if (this.price > god5.price) {
                return 1;
            } else if (this.price < god5.price) {
                return -1;
            } else {
//                return 0;
                return /*-this.*/name.compareTo(god5.name);
            }
        }
        throw new RuntimeException("传入的数据类型不一致！");
    }
}
public class Study05 {

    double price = 55;
    int aa;
    Study04 o1 = new Study04();
    public void setAa(int aa) {
        this.aa = aa;
        System.out.println(aa);
    }

    @Test
    public void is31() {
        Student s1 = new Student(31, "赵is");
        Student s2 = new Student(41, "薛is");
        Student s3 = new Student(72, "李is");
        Student s4 = new Student(7, "张is");

        List<Student> stus = new ArrayList<Student>();
        stus.add(s1);
        stus.add(s2);
        stus.add(s3);
        stus.add(s4);
        Collections.sort(stus,new Student());
        for (Student stuu :
                stus) {
            System.out.println(stuu.toString());
        }
        Student themax = Collections.max(stus, new Student());
        System.out.println(themax);
        System.out.println(Collections.frequency(stus,s1));
    }
    @Test//TreeMap按字典顺序排序
    public void is30() {
        Map<Integer, String> map = new TreeMap<Integer, String>();
        map.put(4,"a");
        map.put(2,"a");
        map.put(3,"a");
        map.put(1,"a");
        System.out.println(map);
        Map<String, String> map1 = new TreeMap<String, String>();
        map1.put("b", "b");
        map1.put("c", "c");
        map1.put("d", "d");
        map1.put("a", "a");
        map1.put("ab", "ab");
        System.out.println(map1);
    }
    @Test//Map集合
    public void is29() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("b", 1);
        map.put("c", 2);
        map.put("d", 2);
        map.put("e", 4);
        System.out.println(map);
        System.out.println(map.get("b"));//根据key取值
//        map.remove("c");//根据key值移除元素
//        map.clear();//清空集合
        System.out.println(map.size());//集合长度
        System.out.println(map.containsKey("b"));//看是否包含这个key
        System.out.println(map.containsValue(2));//看是否包含这个value
        //遍历Map集合
        Set<String> keys = map.keySet();
        for (String s :
                keys) {
            System.out.println(s + ":" + map.get(s));
        }
        //第二种遍历Map集合
        Set<Map.Entry<String, Integer>> entrys = map.entrySet();
        for (Map.Entry<String, Integer> en : entrys){
            System.out.println(en.getKey()+":"+en.getValue());
        }
    }
    @Test//List集合
    public void is28() {
        List<String> list = new ArrayList<String>();
        list.add("ss");
        list.add("sssf");
        list.add("sssfds");
        List<String> list1 = new ArrayList<String>();
        list1.add("插入数据1");
        list1.add("插入数据2");
        list.addAll(1, list1);//这方法不能直接插字符串,是在指定索引下标的位置插入集合
        System.out.println(list.get(2));//通过索引来访问指定位置的集合元素
        System.out.println(list.indexOf("sssf"));//获取指定元素在集合第一次出现的索引下标
        System.out.println(list.lastIndexOf("sssf"));//获取指定元素在集合最后一次出现的索引下标
//        list.remove(2);//根据指定的索引下标移除元素
        list.set(1, "修改后数据");//根据指定索引下标修改元素
        System.out.println(list);
        List<String> sublist = list.subList(1, 3);//截取，注意看此行其实是下标1到下标2的数据被截取出来形成新集合
        System.out.println(sublist);
        System.out.println(list.size());//集合的长度
    }
    @Test
    public void is26() {
        int q = 5;
        goods[] s1 = new goods[q];
        s1[0] = new goods("sds", 566);
        s1[1] = new goods("gfd",5527 );
        s1[2] = new goods("dfgdr",775 );
        s1[3] = new goods("xbxxx", 5257);
        s1[4] = new goods("aax", 5257);
        Arrays.sort(s1);
//        System.out.println(Arrays.toString(s1));
        for (Object j :  //这种方式不如用Arrays工具类方便,但是更灵活
                s1) {
            System.out.println(j);
        }
    }
    @Test//倒序排首字母--->对于字符串
    public void is25() {
        String[] arr = new String[]{"AA", "CC", "DD", "YY", "JJ", "KK", "SS", "EE", "RR", "TT"};
        /*Arrays.sort(arr);      //String是重写过compareTo()方法的,所以能直接排序
        System.out.println(Arrays.toString(arr));*/
        Arrays.sort(arr, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof String && o2 instanceof String) {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的数据类型不一致！");
            }
        });
        for (Object j :  //这种方式不如用Arrays工具类方便,但是更灵活
                arr) {
            System.out.println(j);
        }
    }
    @Test//先按名称从低到高，再按价格从低到高
    public void is27() {
        int q = 5;
        goods[] g1 = new goods[q];
        g1[0] = new goods("sds", 566);
        g1[1] = new goods("gfd",5527 );
        g1[2] = new goods("dfgdr",775 );
        g1[3] = new goods("xbxxx", 5257);
        g1[4] = new goods("aax", 5257);
        Arrays.sort(g1, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof goods && o2 instanceof goods) {
                    goods s1 = (goods) o1;
                    goods s2 = (goods) o2;
                    if (s1.getName().equals(s2.getName())) {
                        return Double.compare(s1.getPrice(), s2.getPrice());
                    }
                    else{
                        return s1.getName().compareTo(s2.getName());
                    }
                }
                throw new RuntimeException("输入的数据类型不一致！");
            }

        });
        for (Object j :  //这种方式不如用Arrays工具类方便,但是更灵活
                g1) {
            System.out.println(j);
        }
    }
    @Test//Set集合
    public void is24() {
        Set set = new HashSet();
        set.add(5);
        set.add("fsf");
        set.add("s");
        set.add("ef");
        set.add("fdg");
        System.out.println(set);
        //移除元素的方法
//        set.remove("fsf");
        //清空集合的方法
//        set.clear();
        //使用迭代器输出
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //使用foreach迭代集合
        for (Object obj :
                set) {
            System.out.println(obj);
        }
        //获取set集合的元素个数
        System.out.println(set.size());
        //使用泛型
        Set<String> set2 = new HashSet<String>();
        set2.add("ss");

    }
    @Test
    public void is23() {
        String c = "55";
        int a = 34;
        float w = (short)2;
        System.out.println();
    }
    @Test
    public void is2() {
//        Integer[] a = new Integer[5];
//        a = {2, 6, 9, 55, 3};
//        int[] a = new int[5];
        Integer[] a ={2, 6, 9, 55, 3};
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    @Test
    public void is() {
        char ij = 65;
        int a = 65;
//        String b = new String("65");
        String b = "65";
        System.out.println(a == ij);
        System.out.println(b.equals(a));

    }
@Test
    public void ii() throws IOException {
        int[] a = {8,2,6,8,2,3,6};
        byte[] b = new byte[4];
        FileInputStream sis = new FileInputStream("E:/临时/eded.txt");
        int read1 = sis.read(b);
        System.out.println(read1);
        System.out.println(new String(b));
    if (read1 == -1) {
        sis.close();
    }
    }

    @Test
    public void momo(){
        String io = "j";
        System.out.println(io.length());
    }

    public String add(int aa, int d3) {
        aa = this.aa;
        System.out.println(aa + d3);
        return "o";
    }

    @Override
    public String toString() {
        String b = super.toString();
        return super.toString() + "\nssss:0";
    }

    @Test
    public void sa2() {
        List a3 = new ArrayList();
        a3.add(8);
        a3.add(8);
        a3.add(8);
        List a6 = new ArrayList();
        a6.add(a3);
        Object[] a= {5,5,'s','f','s',"jfdd",6,4};
        a6.add(a);
        a6.add(6535);
        String a4 = "da";
        System.out.println(a6.toString());
//        System.out.println(ArrayList.toString(a3));
    }

    @Test
    public void sa4() {

        System.out.println(5+"=====================================");
    }
    @Test
    public void sa1() {
        int[] a = {3, 95, 96, 6, 5, 3, 544, 54, 5, 4, 98};
        System.out.println(Arrays.toString(a));
    }
}
class son1 extends Study05{
    public son1() {
        System.out.println("son1的构造函数");
    }
    void add2(){

    System.out.println("子类方法");
    }
}
@Component
class  dd{
    public static void main(String[] args) throws ClassNotFoundException {
        Study05 d = new Study05();
        d.setAa(45);
        d.add(5, 6);
        System.out.println(d.toString());
        Study04 i = new Study04();
        System.out.println(i.toString());
        Date ij = new Date();
        System.out.println(ij.toString());
        List<String>list = new ArrayList<String>();
        list.add("保护环境");  //向列表中添加数据
        list.add("爱护地球");  //向列表中添加数据
        list.add("从我做起");  //向列表中添加数据
        List list2 = new ArrayList();
        list2.add(9);
        list2.add("dad");
        System.out.println(list2);
        System.out.println(list);
        String[] in = {"55", "55", "5"};
        System.out.println(in[0]);
        Class c1 = Study04.class;
        System.out.println(c1);
        Class c2 = c1.getClass();
        System.out.println(c2);
        Class c3 = Class.forName("com.one.Study05");
        System.out.println(c3);
        System.out.println("=========1");
        son1 po = new son1();
        Class c4 = po.getClass();
        Class c5 = c4.getSuperclass();
        System.out.println(c5);
        String c6 = c4.getSimpleName();
        System.out.println(c6);
        System.out.println("=========2");
        /*Method c7 = c4.getMethod("add2");
        System.out.println(c7);*//*destroy*/
    }
    }





