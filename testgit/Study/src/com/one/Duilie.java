package com.one;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//long skip(long n) :这个方法是跳过几个字节不读。

public class Duilie {
    public static void main(String[] args) {
        FileInputStream sis = null;
        FileInputStream sis2 = null;
        FileInputStream sis3 = null;
        try {
            sis = new FileInputStream("test");
//            while (true) {
//                int readData = sis.read();
//                if (readData == -1) {
//                    break;
//                }
//                System.out.println(readData);
//            }//未优化的循环结构
            int readDate ;
            while ((readDate = sis.read()) != -1) {
                System.out.println(readDate+"剩余未读的字节数量为"+sis.available());//有了这个函数就可以一次性读出文件的所有字节
            }
            sis2 = new FileInputStream("test");//IDEA默认的路径在项目根

            byte[] a1 = new byte[5];
            int readDate2 ;
            while ((readDate2 = sis2.read(a1)) != -1) {
                System.out.println(readDate2);
                System.out.println(new String(a1,0,readDate2));
            }
            sis3 = new FileInputStream("test");//这种一次性输出的方式不适合太大的文件，因为byte[]数组不能太大
            byte[] a2 = new byte[sis3.available()];
            int readDate3 = sis3.read(a2);
            System.out.println(readDate3);//这一行因为上方的read()方法中有a1,所以输出结果是这一轮未读出的字节的长度，
                                          // 因为这一块方法是一次性读出所有字节，所以直接输出8
            System.out.println(new String(a2));//以上所有的文件中有中文的话输出会有乱码的问题还没有解决
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sis != null) {
                try {
                    sis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sis2 != null) {
                try {
                    sis2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (sis3 != null) {
                try {
                    sis3.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}