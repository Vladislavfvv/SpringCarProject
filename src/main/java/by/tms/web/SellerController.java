package by.tms.web;

import by.tms.entity.Seller;
import by.tms.service.CustomerService;
import by.tms.service.SellerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/seller")
public class SellerController {

    private final CustomerService customerService;
    private final SellerService sellerService;


    public SellerController(CustomerService customerService, SellerService sellerService) {
        this.customerService = customerService;
        this.sellerService = sellerService;

    }

    @GetMapping("/sellerRegistration")
    public String sellerRegistration(@ModelAttribute("newSeller") Seller seller) {
        return "sellerRegistration";
    }

    @PostMapping("/sellerRegistration")
    public String sellerRegistration(@Valid @ModelAttribute("newSeller") Seller seller, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "sellerRegistration";
        }
        if (sellerService.findSellerByEmail(seller.getEmail()).isEmpty()
                && customerService.findCustomerByEmail(seller.getEmail()).isEmpty()) {
            sellerService.saveSeller(seller);
            return "redirect:/";
        } else {
            model.addAttribute("message", "User already exist");
            return "sellerRegistration";
        }

    }
}
