package technology.restservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

import technology.tabula.CommandLineApp;

public class Controller {
    private String areaString;
    private String directory;
    private String pages;
    private static ArrayList<List> result;

    public Controller(String directory, String areaString, String pages) {
        this.directory = directory;
        this.areaString = areaString;
        this.pages = pages;
    }

    public static void setResult(ArrayList<List> r) {
        // System.out.println("Set result is called" + r);
        result = r;
    }

    public ArrayList<List> getCroppedCSV() {
        String[] argsLine = new String[] { "--batch", directory, "-f", "CSV", "-a", areaString, "--pages", pages };
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine line = parser.parse(CommandLineApp.buildOptions(), argsLine);
            System.out.println("Args string" + Arrays.toString(argsLine));
            new CommandLineApp(System.out, line).extractTables(line);
            return result;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
