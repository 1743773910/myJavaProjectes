package IO.OutPutStream;

import java.io.*;

public class BufferedOutputStream_ {
    public static void main(String[] args) throws IOException {
        String srcFileName = "e:\\hello.txt";
        String destFileName = "e:\\hello1.txt";
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        bis = new BufferedInputStream(new FileInputStream(srcFileName));
        bos = new BufferedOutputStream(new FileOutputStream(destFileName));

        byte[] buffer =new byte[1024];
        int len = 0;
        while((len = bis.read(buffer)) != -1){
            bos.write(buffer, 0, buffer.length);
        }
        bis.close();
        bos.close();
    }
}
