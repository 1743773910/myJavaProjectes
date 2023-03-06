package IO;

import java.io.File;
import java.io.IOException;

public class FileOperation {
    public static void main(String[] args) throws IOException {

    }
    // 1. 文件创建
    public void creat1() throws IOException {
        String filePath = "e:\\newfile1.txt";
        File file = new File(filePath);
        file.createNewFile();
        file.delete();
    }
    public void creat2() throws IOException{
        File parentFile = new File("e:\\");
        String fileName = "newfile2.txt";
        File file = new File(parentFile,fileName);
        file.createNewFile();
    }
    // 2.获取文件相关信息
    /*
    file.getName();
    .getAbsolutePath();
    .getParent();
    .length();  文件大小,返回字节数
    .exists();
    .isFile();
    .isDirectory();
     */
    // 3.目录操作和文件删除(目录也可以当作文件)
    /*
    file.delete(), 返回boolean值
    file.mkdir() 创建一级目录
    file.mkdirs() 创建多级目录
     */

}
