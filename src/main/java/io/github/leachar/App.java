package io.github.leachar;

import java.io.File;
import java.util.Scanner;

/**
 * 将图片转换为WebP格式
 */
public class App {

    private static Scanner scanner = new Scanner(System.in);
    private static boolean flag = true;

    public static void main(String[] args) {

        new App().start();

    }

    private void start() {
        do {
            run();
            System.out.println("继续？(y/n)");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("n")) {
                flag = false;
            }
        } while (flag);
    }

    private void run() {
        System.out.println("输入需要转化图片或者文件夹路径：");
        String srcPath = scanner.nextLine();
        System.out.println("是否需要将该路径下的所有图片转为webp格式(包括子文件夹)");
        System.out.println("(yes/no)?");
        String recursive = scanner.nextLine();
        try {
            String destPath = FileUtil.processSrcAndDest(srcPath, recursive);
            System.out.println("输出的WebP图片放于此路径中");
            System.out.println(">>>>> " + destPath);
        } catch (Exception e) {
            System.out.println("路径错误 >>>> " + srcPath);
        }

    }

}
