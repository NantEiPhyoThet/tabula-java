package technology.restservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/getCroppedCSV")
    public Controller controller(@RequestParam(value = "directory", defaultValue = "") String directory,
            @RequestParam(value = "top", defaultValue = "30") String top,
            @RequestParam(value = "left", defaultValue = "30") String left,
            @RequestParam(value = "bottom", defaultValue = "100") String bottom,
            @RequestParam(value = "right", defaultValue = "100") String right,
            @RequestParam(value = "pages", defaultValue = "1") String pages) {
        String areaString = top + "," + left + "," + bottom + "," + right;
        return new Controller(directory, areaString, pages);
    }
}
