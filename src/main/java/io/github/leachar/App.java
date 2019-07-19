package io.github.leachar;

import java.util.Scanner;

/**
 * 将图片转换为WebP格式
 */
public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean flag = true;

    public static void main(String[] args) {

        new App().boot();

    }

    private void boot() {
        do {
            start();
            System.out.println("退出？(y/n)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                flag = false;
            }
        } while (flag);
        System.exit(0);
    }

    private void start() {
        System.out.println("输入需要转化图片或者文件夹路径：");
        String srcPath = scanner.nextLine();
        ToWebPUtil.toWebP(srcPath);
    }

}
