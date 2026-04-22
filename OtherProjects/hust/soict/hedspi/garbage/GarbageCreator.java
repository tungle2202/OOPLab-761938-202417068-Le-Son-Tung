package hust.soict.hedspi.garbage;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) throws java.io.IOException{
        String filename = "/home/tungle/Downloads/astah-uml_11.0.0.ba221e-0_all.deb";
        byte[] inputBytes = { 0 };

        long startTime, endTime;

        inputBytes = Files.readAllBytes(Paths.get(filename));
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for(byte b: inputBytes){
            outputStringBuilder.append((char)b);
        }
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);
    }
}
