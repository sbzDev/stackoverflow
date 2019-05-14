package com.stackoverflow.questions;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NestedZipTest
{

    public static void main(String[] args)
            throws IOException, URISyntaxException
    {

        NestedZipTest.class.getClassLoader().getResource("src/main/resources/a.zip");

        Path path = Paths.get("src/main/resources/a.zip");

        System.out.println("Open: " + path.toUri());
        try (FileSystem zipfs = FileSystems.newFileSystem(path, null))
        {
            for (Path rootPath : zipfs.getRootDirectories())
            {
                Files.walk(rootPath).forEach(p -> {
                    System.out.println("Root-Path " + rootPath + " File: " + p);
                    if (p.toString().endsWith(".zip"))
                    {
                        System.out.println("Try to open nested zip file " + p);
                        try
                        {
                            URI u = p.toUri();

                            System.out.println("Nested zip file URI: " + u);
                            try (FileSystem zipP = FileSystems.newFileSystem(p, null))
                            {
                                System.out.println("Success :-)");
                            }
                        }
                        catch (Throwable exp)
                        {
                            System.err.println("Creating file system for nested zip file failed :-(");
                            exp.printStackTrace();
                        }
                    }
                });
            }
        }
    }
}