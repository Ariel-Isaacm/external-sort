package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.*;

public class Sorter {
    private Map<Date, Entry> files = new HashMap<>();
    private PriorityQueue<Date> queue = new PriorityQueue<>();

    public void readAllFilesInDirectory(String folder) {
        File[] fileNames = getResourceFolderFiles(folder);
        for (File file : fileNames) {
            try {
                openAllFiles(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        printContent();
    }

    private void printContent() {
        while (!files.isEmpty()) {
            Entry remove = files.remove(queue.poll());
            System.out.println(remove.getText());
            readNextLine(remove.getReader());
        }
    }

    private static File[] getResourceFolderFiles(String folder) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(folder);
        String path = url.getPath();
        return new File(path).listFiles();
    }


    private void openAllFiles(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        readNextLine(br);
    }

    private void readNextLine(BufferedReader br) {
        try {
            String strLine = br.readLine();
            if (strLine != null) {
                String[] line = strLine.split(",");
                Date localDate = parseDate(line[0]);
                Entry entry = new Entry(localDate, strLine, br);
                queue.add(localDate);
                files.put(localDate, entry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Date parseDate(String dateString) {
        DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_DATE_TIME;
        TemporalAccessor accessor = timeFormatter.parse(dateString);
        return Date.from(Instant.from(accessor));
    }
}
