package technology.restservice;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/getCroppedCSV")
    public Controller controller(
            @RequestParam(value = "pdfFile", defaultValue = "src/test/resources/technology/tabula/twotables.pdf") String pdfFile,
            @RequestParam(value = "areaString", defaultValue = "%30, 0.0, 80, 100") String areaString) {
        return new Controller(pdfFile, areaString);
    }
}
