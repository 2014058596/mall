package cn.com.mall.test;

/**
 * @ClassName: Main
 * @Description: TODO
 * @author: 55555
 * @date: 2020年07月24日 12:24 上午
 */
public class Main {
    public static byte[] b = new byte[1024*1024*30];

    public static void main(String[] args) {
        System.gc();
        System.out.printf("1");
    }
}
