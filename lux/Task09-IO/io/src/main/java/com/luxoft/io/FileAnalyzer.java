package com.luxoft.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileAnalyzer {

    private String content;

    public static void main(String[] args) {
        if (args.length != 2) {
            String className = FileAnalyzer.class.getSimpleName();
            System.out.println(String.format(
                "Usage: java %s <file> <word>\n\tjava %s../../../../../../data/java.txt Oracle",
                className,
                className
            ));
        } else {
            String filename = args[0];
            String word = args[1];
            FileAnalyzer fa = null;
            try {
                fa = new FileAnalyzer(filename);
                long wordCount = fa.getWordCount(word);
                System.out.println(String.format("File %s contains \"%s\" %d times.", filename, word, wordCount));
                String[] sentences = fa.getFileLinesWithWord(word);
                System.out.println(String.format("Sentences with \"%s\":", word));
                for (String sentence : sentences) {
                    System.out.println(sentence.trim());
                }
            } catch (IOException ignored) {
            }
        }
    }

    public FileAnalyzer(String filename) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            br.close();
            content = sb.toString();
        } catch (FileNotFoundException e) {
            System.err.println(String.format("File %s not found.", filename));
            throw e;
        } catch (IOException e) {
            System.err.println(String.format("Cannot read from %s.", filename));
            throw e;
        }
    }

    private long getWordCount(String word) {
        long result;
        Pattern pattern = Pattern.compile(String.format("\\b%s\\b", word));
        Matcher matcher = pattern.matcher(content);
        result = matcher.results().count();
        return result;
    }


    public String[] getFileLinesWithWord(String word) {
        List<String> result = new ArrayList<String>();

        Pattern pattern = Pattern.compile(String.format("\\b%s\\b", word));
        String[] sentences = content.split(String.format("((?<=%1$s)|(?=%1$s))", "[!\\.\\?]"));
        for (String sentence : sentences) {
            Matcher matcher = pattern.matcher(sentence);
            if (matcher.find()) {
                result.add(sentence);
            }
        }
        return result.toArray(String[]::new);
    }

}
