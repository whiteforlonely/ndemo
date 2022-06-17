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
        intBuffer.mark();
        System.out.println("get() =  " + intBuffer.get());
        System.out.println("get() =  " + intBuffer.get());
        System.out.println("get() =  " + intBuffer.get());
        System.out.println("get() =  " + intBuffer.get());
        System.out.println("get() =  " + intBuffer.get());
//        intBuffer.reset();
        intBuffer.rewind();
        System.out.println("position: " + intBuffer.position());

        System.out.println("clean test------------------------");
        intBuffer.compact();
        System.out.println("position after clear: " + intBuffer.position());
        intBuffer.put(10);
        intBuffer.put(11);
        System.out.println("position: " + intBuffer.position());
        System.out.println("capacity: " + intBuffer.capacity());
        System.out.println("limit: " + intBuffer.limit());

    }
}
