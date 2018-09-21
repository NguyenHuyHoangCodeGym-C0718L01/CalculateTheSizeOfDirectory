package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        System.out.println("Calculate the size of the directory");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Input the directory: ");

        String path = scanner.nextLine();

        File dir = new File(path);

        File dir2 = new File(dir.getCanonicalPath());

        System.out.println("The size of the directory: "+path+" is: "+getSize(dir));
    }

    public static long getSize(File file) throws IOException {
        if(!file.exists()){
            return 0;
        }else{
            File[] list = file.listFiles();
            if(list!=null){
                int i = 0;
                for (File f : list) {
                    i += getSize(f.getCanonicalFile());
                }
                return file.listFiles().length + i;
            }
            return 1;
            }
        }
    }
