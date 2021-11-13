package com.luxoft.io;

import java.io.*;

public class FileManager {

    public static void main(String[] args) {
        String command = "";
        if (args.length > 0) {
            command = args[0];
        }
        switch (command) {
            case "countFiles":
                int countFiles = FileManager.countFiles(args[0]);
                System.out.println(String.format("Total %d files in %s.", countFiles, args[1]));
                break;
            case "countDirs":
                int countDirs = FileManager.countDirs(args[0]);
                System.out.println(String.format("Total %d directories in %s.", countDirs, args[1]));
                break;
            case "copy":
                FileManager.copy(args[1], args[2]);
                break;
            case "move":
                FileManager.move(args[1], args[2]);
                break;
            default:
                System.out.println(String.format(
                    "Usage: java %s command path [path]\n\t command: countFiles countDirs copy move",
                    FileManager.class.getSimpleName()
                ));
                break;
        }
    }

    // принимает путь к папке,
    // возвращает количество файлов в папке и всех подпапках по пути
    public static int countFiles(String path) {
        File sourceDir = new File(path);
        int result = 0;
        if (sourceDir.isDirectory()) {
            File[] files = sourceDir.listFiles();
            for (File file : files) {
                try {
                    if (file.isDirectory()) {
                        result += FileManager.countFiles(file.getCanonicalPath());
                    } else {
                        result++;
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        } else {
            result = 1;
        }
        return result;
    }

    // принимает путь к папке,
    // возвращает количество папок в папке и всех подпапках по пути
    public static int countDirs(String path) {
        File sourceDir = new File(path);
        int result = 0;
        if (sourceDir.isDirectory()) {
            File[] files = sourceDir.listFiles();
            for (File file : files) {
                try {
                    if (file.isDirectory()) {
                        result += 1 + FileManager.countDirs(file.getCanonicalPath());
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        } else {
            result = 1;
        }
        return result;
    }

    // метод по копированию папок и файлов.
    // Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
    public static void copy(String from, String to) {
        File source = new File(from);
        File destination = new File(to);
        if (source.isFile()) {
            if (destination.isDirectory()) {
                try {
                    copyFile(from, to + File.separator + source.getName());
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            } else {
                if (destination.exists()) {
                    System.err.println(String.format("Cannot overwrite file %s."));
                } else {
                    try {
                        copyFile(from, to);
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        } else {
            if (!destination.exists()) {
                destination.mkdir();
            }
            for (File file : source.listFiles()) {
                try {
                    if (file.isFile()) {
                        copyFile(file.getPath(), to + File.separator + file.getName());
                    } else if (file.isDirectory()) {
                        copy(file.getPath(), to + File.separator + file.getName());
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }

    private static boolean copyFile(String from, String to) throws IOException {
        File source = new File(from);
        File destination = new File(to);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(source);
            outputStream = new FileOutputStream(destination);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        } finally {
            inputStream.close();
            outputStream.close();
        }
        return true;
    }

    // метод по перемещению папок и файлов.
    // Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
    public static void move(String from, String to) {
        File source = new File(from);
        File destination = new File(to);
        source.renameTo(destination);
    }
}
