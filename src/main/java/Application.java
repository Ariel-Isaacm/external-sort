import utils.Sorter;


public class Application {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        sorter.readAllFilesInDirectory("tmp");
    }
}
