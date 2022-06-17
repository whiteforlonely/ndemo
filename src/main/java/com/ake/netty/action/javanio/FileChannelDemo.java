package com.ake.netty.action.javanio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileChannelDemo {

    // 通过使用通道来进行文件的复制
    public static void copyFile(String srcPath, String descPath){

        if (!Files.exists(Paths.get(srcPath))) {
            System.out.println(String.format("source file %s not exist", srcPath));
            return;
        }

        if (!Files.exists(Paths.get(descPath))) {
            try {
                Files.createFile(Paths.get(descPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        long startTime = System.currentTimeMillis();
        try(FileInputStream fileInputStream = new FileInputStream(srcPath); FileOutputStream fileOutputStream = new FileOutputStream(descPath)) {
            FileChannel inChannel = fileInputStream.getChannel();
            FileChannel outChannel = fileOutputStream.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (inChannel.read(buf) != -1) {
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("copy file done, cost %dms", (endTime-startTime)));

    }

    public static void main(String[] args) {
        copyFile("C:\\Users\\86151\\Pictures\\Camera Roll\\src=http___preview.21cnjy.com_files_e7_00_e7004152f8952126176e9c3ea636ddc3.png&refer=http___preview.21cnjy.webp", "C:\\Users\\86151\\Pictures\\Camera Roll\\copy.png");
    }
}
