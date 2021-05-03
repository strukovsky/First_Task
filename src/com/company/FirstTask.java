package com.company;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

public class FirstTask {
    TreeMap<String, Integer> map;

    public FirstTask()
    {
        map = new TreeMap<>();
    }

    private void addToFileCollection(File f)
    {
        String name = f.getName();
        if(map.get(name) == null)
        {
            map.put(name, 1);
        }
        else{
            map.put(name, map.get(name)+1);
        }
    }

    public void displayResult()
    {
        for(Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue().toString());
        }
    }

    public void writeToFile(File f)
    {
        try(FileOutputStream out = new FileOutputStream(f))
        {
            for(Map.Entry<String, Integer> e : map.entrySet())
            {
                String filename = e.getKey();
                Integer times = e.getValue();
                for (int i = 0; i < times; i++) {
                    out.write(filename.getBytes(StandardCharsets.UTF_8));
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public void execute(String currentDir)
    {
        File f = new File(currentDir);
        if(!f.isDirectory())
            return;

        File[] files = f.listFiles();
        if(files == null)
            return;
        for(File file : files)
        {
            if(file.getName().endsWith(".txt"))
            {
                addToFileCollection(file);
            }
            if(file.isDirectory())
            {
                execute(file.getAbsolutePath());
            }
        }
    }
}
