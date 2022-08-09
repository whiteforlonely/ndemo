package com.ake.netty.action.javanio;

import java.nio.IntBuffer;

public class BufferTest {

    public static void main(String[] args) {
        IntBuffer intBuffer = null;
        intBuffer = IntBuffer.allocate(20);
        System.out.println("after allocate-----------------");
        System.out.println("position: " + intBuffer.position());
        System.out.println("capacity: " + intBuffer.capacity());
        System.out.println("limit: " + intBuffer.limit());

        intBuffer.put(4);
        intBuffer.put(5);
        intBuffer.put(6);
        intBuffer.put(7);
        intBuffer.put(8);

        intBuffer.flip();

        System.out.println("after flip-----------------");
        System.out.println("position: " + intBuffer.position());
        System.out.println("capacity: " + intBuffer.capacity());
        System.out.println("limit: " + intBuffer.limit());


        System.out.println("get test ------------------------");
        // 编辑下，等下可以重复读
//        intBuffer.mark();
        System.out.println("get() =  " + intBuffer.get());
        System.out.println("get() =  " + intBuffer.get());
        System.out.println("get() =  " + intBuffer.get());
//        System.out.println("get() =  " + intBuffer.get());
//        System.out.println("get() =  " + intBuffer.get());
//        intBuffer.reset();
//        intBuffer.rewind();
        System.out.println("position: " + intBuffer.position());

        System.out.println("clean test------------------------");
        // 这边的压缩的意思就是将未读的数据直接的移到顶部，然后position从对应的原来的limit-原来的position开始，也就是说这样子可以开始进入写模式。
        intBuffer.compact();
        System.out.println("position after clear: " + intBuffer.position());
        intBuffer.put(10);
        intBuffer.put(11);
//        System.out.println("position: " + intBuffer.position());
//        System.out.println("capacity: " + intBuffer.capacity());
//        System.out.println("limit: " + intBuffer.limit());

    }
}
