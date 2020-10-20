package technology.restservice;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

import technology.tabula.CommandLineApp;

public class Controller {
    private String areaString;
    private String pdfFile;
    private String result;

    public Controller() {
    }

    public Controller(String pdfFile, String areaString) {
        this.pdfFile = pdfFile;
        this.areaString = areaString;
        System.out.println("From Controller constructor" + pdfFile + areaString);
    }

    public void setResult(String result) {
        System.out.println("Set result is called" + result);
        this.result = result;
    }

    // public String getResult() {
    // return result;
    // }

    public String getAreaString() {
        String[] argsLine = new String[] { "tabula " + pdfFile + " -a " + areaString + " " };
        CommandLineParser parser = new DefaultParser();
        try {
            CommandLine line = parser.parse(CommandLineApp.buildOptions(), argsLine);
            new CommandLineApp(System.out, line, areaString).extractTables(line);
            System.out.println("from get area stirng" + result);
            return result;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
}
