package dev.ahmed.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author Ahmed Bughra
 * @create 2023-02-13  12:13 AM
 */
public class FileDemo {

    @Test
    public void test1() throws IOException {
        File file = new File("D:\\io\\io1\\hello.txt");
// Create another file in the same directory as file, the file name is: haha.txt
        File destFile = new File(file.getParent(),"haha.txt");
        boolean newFile = destFile.createNewFile();
        if(newFile){
            System.out.println("created successfully！");
        }
    }
}
