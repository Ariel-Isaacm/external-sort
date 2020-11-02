package utils;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class SorterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void testSorter() {
        Sorter sorter = new Sorter();
        sorter.readAllFilesInDirectory("tmp");
        assertEquals( //
                "2016-12-20T19:00:45Z, Server A started.\n" +
                        "2016-12-20T19:01:10Z, Server C started.\n" +
                        "2016-12-20T19:01:16Z, Server B started.\n" +
                        "2016-12-20T19:01:25Z, Server A completed job.\n" +
                        "2016-12-20T19:02:48Z, Server A terminated.\n" +
                        "2016-12-20T19:03:25Z, Server B completed job.\n" +
                        "2016-12-20T19:04:50Z, Server B terminated.\n" +
                        "2016-12-20T19:05:25Z, Server C completed job.\n" +
                        "2016-12-20T19:07:50Z, Server C terminated.\n", outContent.toString());
    }
}