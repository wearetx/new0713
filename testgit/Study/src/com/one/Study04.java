package com.one;

public class Study04 {
            int number;
            String name;

            void Study(int number,String name){
                this.number = number;
                this.name = name;
                System.out.println("名字是"+name+"学号是"+number);
            }
            void ioio1() {
                System.out.println("ceshi"+this.name);
            }


}
class UniverStudent extends Study04{
    boolean b;
//    UniverStudent(int number,String name,boolean b){
////        super(number,name);
//        Study04(int number,String name);
//        this.b = b;
//        System.out.println("婚否="+b);
//    }
    public void jj(boolean b) {
        this.b = b;
        System.out.println("婚否" + b);
    }

}

/*class factory{
    public static UniverStudent getUN(){
        return new UniverStudent();
    }
}*/
class examplel5_8{
    public static void main(String[] args) {
        UniverStudent zhang = new UniverStudent();
        zhang.Study(55565,"但胡素");
        zhang.jj(false);
        zhang.ioio1();
    }
}

/*class test {
    public static void main(String[] args) {
        UniverStudent tt = factory.getUN();
        tt.Study(667, "dsds");
    }
}
不适用（测试工厂模式时）

*/


