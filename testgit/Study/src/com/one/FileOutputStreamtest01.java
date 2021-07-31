package com.one;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamtest01 {
    @Test//以跟着写的方式不清空原文件来追加内容
    public void wr2() {
        FileOutputStream fos = null;
        try {
            //test02文件不存在的话会自动新建
            fos = new FileOutputStream("test02",true);//加了true,所以追加写入，不加的话
                                                                    // 会清空原文件内容然后写入，谨慎
            //开始写
            byte[] bytes = {97, 98, 99, 100};
            fos.write(bytes);
            //写入bytes数组的一部分
            fos.write(bytes,0,2);
            String oi = "空山不见人";
            byte[] b2 = oi.getBytes();
            fos.write(b2);
            //写完以后一定要刷新
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
