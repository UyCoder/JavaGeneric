package dev.ahmed.java3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Use of the File class
 *
 * 1. An object of the File class, representing a file or a file directory (commonly known as: folder)
 * 2. The File class is declared under the java.io package
 * 3. The File class involves methods such as creating, deleting, renaming, modifying time, and file size of files or file directories.
 * does not refer to operations that write or read file contents. If you need to read or write file content, it must be done using IO streams.
 * 4. Subsequent objects of the File class are often passed as parameters to the constructor of the stream, indicating the "end" of reading or writing.
 *
 *
 *
 *
 * @author Ahmed Bughra
 * @create 2023-02-13  12:13 AM
 */
public class FileTest {
    /*
1. How to create an instance of the File class
         File(String filePath)
         File(String parentPath, String childPath)
         File(File parentFile, String childPath)

     2.
     Relative path: Compared with a certain path, the specified path.
     Absolute path: the path of the file or file directory including the drive letter

     3. Path separator
     windows:\\
     unix:/
     */
    @Test
    public void test1(){
        //构造器1
        File file1 = new File("hello.txt");//相对于当前module
        File file2 =  new File("D:\\workspace_idea1\\JavaSenior\\day08\\he.txt");

        System.out.println(file1);
        System.out.println(file2);

        //构造器2：
        File file3 = new File("D:\\workspace_idea1","JavaSenior");
        System.out.println(file3);

        //构造器3：
        File file4 = new File(file3,"hi.txt");
        System.out.println(file4);
    }

    /*
public String getAbsolutePath(): Get the absolute path
public String getPath() : Get the path
public String getName() : get the name
public String getParent(): Get the upper-level file directory path. If not, return null
public long length() : Get the length of the file (ie: the number of bytes). Could not get the length of the directory.
public long lastModified() : Get the last modification time, in milliseconds

The following two methods apply to file directories:
public String[] list() : Get the name array of all files or file directories under the specified directory
public File[] listFiles() : Get all the files in the specified directory or the File array of the file directory

     */
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("d:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());
    }
    @Test
    public void test3(){
        File file = new File("D:\\workspace_idea1\\JavaSenior");

        String[] list = file.list();
        for(String s : list){
            System.out.println(s);
        }

        System.out.println();

        File[] files = file.listFiles();
        for(File f : files){
            System.out.println(f);
        }

    }
    /*
         public boolean renameTo(File dest): Rename the file to the specified file path
          For example: file1.renameTo(file2) as an example:
             To ensure that it returns true, file1 needs to exist in the hard disk, and file2 cannot exist in the hard disk.
          */
    @Test
    public void test4(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\io\\hi.txt");

        boolean renameTo = file2.renameTo(file1);
        System.out.println(renameTo);

    }
    /*
public boolean isDirectory(): Determine whether it is a file directory
public boolean isFile() : Determine whether it is a file
public boolean exists() : Determine whether it exists
public boolean canRead() : determine whether it is readable
public boolean canWrite() : determine whether it is writable
public boolean isHidden() : determine whether to hide
     */
    @Test
    public void test5(){
        File file1 = new File("hello.txt");
        file1 = new File("hello1.txt");

        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

        System.out.println();

        File file2 = new File("d:\\io");
        file2 = new File("d:\\io1");
        System.out.println(file2.isDirectory());
        System.out.println(file2.isFile());
        System.out.println(file2.exists());
        System.out.println(file2.canRead());
        System.out.println(file2.canWrite());
        System.out.println(file2.isHidden());

    }
    /*
Create the corresponding file or file directory in the hard disk
public boolean createNewFile() : Create a file. If the file exists, do not create it and return false
public boolean mkdir() : Create a file directory. If this file directory exists, it will not be created. If the upper directory of this file directory does not exist, it will not be created.
public boolean mkdirs() : Create file directories. If this file directory exists, it will not be created. If the upper-level file directory does not exist, create it together

     Delete a file or directory of files from disk
public boolean delete(): delete file or folder
     Note on deletion: Delete in Java does not go to the recycle bin.
     */
    @Test
    public void test6() throws IOException {
        File file1 = new File("hi.txt");
        if(!file1.exists()){
            //文件的创建
            file1.createNewFile();
            System.out.println("创建成功");
        }else{//文件存在
            file1.delete();
            System.out.println("删除成功");
        }


    }
    @Test
    public void test7(){
// Create the file directory
        File file1 = new File("d:\\io\\io1\\io3");

        boolean mkdir = file1.mkdir();
        if(mkdir){
            System.out.println("创建成功1");
        }

        File file2 = new File("d:\\io\\io1\\io4");

        boolean mkdir1 = file2.mkdirs();
        if(mkdir1){
            System.out.println("创建成功2");
        }
        // To delete successfully, there cannot be subdirectories or files under the io4 file directory
        File file3 = new File("D:\\io\\io1\\io4");
        file3 = new File("D:\\io\\io1");
        System.out.println(file3.delete());
    }
}
