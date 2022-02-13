package com.chuli.solution.base;


/**
 * @Author: kk
 * @Date: 2022-02-11 17:52
 */
public class Bitmap {

    private byte[] bytes;

    private int capacity;

    public Bitmap(int capacity) {
        this.capacity = capacity;

        bytes = new byte[(capacity >> 3) + 1];
    }

    public void add(int num) {
        int arrayIndex = num >> 3;
        int position = num & 0x07;
        bytes[arrayIndex] |= 1 << position;
    }

    public boolean contain(int num) {
        int arrayIndex = num >> 3;
        int position = num & 0x07;
        return (bytes[arrayIndex] & (1 << position)) != 0;
    }

    public void clear(int num) {
        int arrayIndex = num >> 3;
        int position = num & 0x07;
        bytes[arrayIndex] &= ~(1 << position);
    }

    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap(100);
        bitmap.add(7);
        System.out.println("插入7成功");

        boolean isexsit = bitmap.contain(7);
        System.out.println("7是否存在:"+isexsit);

        bitmap.clear(7);
        isexsit = bitmap.contain(7);
        System.out.println("7是否存在:"+isexsit);
    }
}
