import java.io.*;

public class ImageConverter {
    public static byte[] ImageToByte(File file) throws FileNotFoundException{
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try{
            for(int readNum; (readNum = fis.read(buf)) != -1;){
                bos.write(buf, 0, readNum);
                System.out.println("read " + readNum + " bytes");
            }
        }catch(IOException e){

        }
        byte[] bytes = bos.toByteArray();
        return bytes;
    }
}
