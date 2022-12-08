package by.tms.web;

import by.tms.entity.Car;
import by.tms.entity.Offer;
import by.tms.entity.User;
import by.tms.service.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/offer")
public class OfferController {

    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }


    @GetMapping("/createOffer")
    public String createOffer() {
        return "createOffer";
    }

///////Create first offer!!!!
    @GetMapping("/createOffer/addCar")
    public String createOffer(@ModelAttribute("newCar") Car car) {
        return "addOfferUser/addCar";
    }

    @PostMapping("/createOffer/addCar")
    public String createOffer(@Valid @ModelAttribute("newCar") Car car, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "/addOfferUser/addCar";
        }
        User currentU = (User) httpSession.getAttribute("currentUser");
        //offerService.save(car);

        return "redirect:/user/personalAccount";
    }
}
