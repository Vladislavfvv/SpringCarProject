package by.tms.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/catalog/transport")
    public String transport() {
        return "catalog/catalogTransports";
    }
    @GetMapping("/catalog/parts")
    public String parts() {
        return "catalog/catalogParts";
    }

    @GetMapping("/catalog/tires")
    public String tires() {
        return "catalog/catalogTires";
    }

    @GetMapping("/catalog/carServices")
    public String carServices() {
        return "catalog/catalogCarServices";
    }
}
