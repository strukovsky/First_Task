package com.company;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Give me root path to begin");
        String path = s.next();
        FirstTask f = new FirstTask();
        f.execute(path);
        File out = new File("Output.txt");
        f.writeToFile(out);
    }
}
