package ru.geekbrains.lesson5;

import java.io.File;

public class Tree {

    /**
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent); // рисуем отступ
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        int subFileTotal = 0;
        for (File value : files) {
            if (value.isDirectory()) {
                subDirTotal++;
            } else {
                subFileTotal++;
            }
        }

        int subDirCounter = 0;
        int subFileCounter = 0;
        for (File value : files) {
            if (value.isDirectory()) {
                print(value, indent, subDirCounter == subDirTotal - 1);
                subDirCounter++;
            } else {
                print(value, indent, subFileCounter == subFileTotal - 1);
                subFileCounter++;
            }
        }


    }

}
