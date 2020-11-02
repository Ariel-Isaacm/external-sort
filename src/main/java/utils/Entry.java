package utils;

import java.io.BufferedReader;
import java.util.Date;

public class Entry {
    private Date date;
    private String text;
    private BufferedReader reader;

    public Entry(Date date, String text, BufferedReader reader) {
        this.date = date;
        this.text = text;
        this.reader = reader;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public BufferedReader getReader() {
        return reader;
    }
}
