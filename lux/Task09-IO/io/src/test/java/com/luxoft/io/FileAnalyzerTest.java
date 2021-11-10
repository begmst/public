package com.luxoft.io;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

public class FileAnalyzerTest {
    private FileAnalyzer fa;

    @BeforeEach
    protected void setUp() throws IOException {
        this.fa = spy(new FileAnalyzer(
                this.getClass().getProtectionDomain().getCodeSource().getLocation().getPath()
                        + "../../data/java.txt"
        ));
    }

    @Test
    public void testWordCount() {
        when(fa.getContent()).thenReturn("This is a test. It is a good day to die.");
        assertEquals(2, fa.getWordCount("is"));
        assertEquals(0, fa.getWordCount("Oracle"));
    }

    @Test
    public void testSentencesWithWord() {
        when(fa.getContent()).thenReturn("Microsoft Office. " +
            "Microsoft Word. " +
            "Microsoft Excel. " +
            "Microsoft PowerPoint. " +
            "Microsoft Skype. " +
            "Oracle Java. " +
            "Java Development Kit."
        );
        assertEquals(5, fa.getSentencesWithWord("Microsoft").length);
        assertEquals(2, fa.getSentencesWithWord("Java").length);
        assertEquals(1, fa.getSentencesWithWord("Oracle").length);
    }
}
