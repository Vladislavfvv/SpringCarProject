package by.tms.web;

import by.tms.entity.Customer;
import by.tms.entity.Seller;
import by.tms.entity.User;
import by.tms.service.CustomerService;
import by.tms.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    private final SellerService sellerService;
    private final CustomerService customerService;

    public UserController(SellerService sellerService, CustomerService customerService) {
        this.sellerService = sellerService;
        this.customerService = customerService;
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("user") User user) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, HttpSession httpSession, Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        Optional<Seller> seller = sellerService.findSellerByEmail(user.getEmail());
        Optional<Customer> customer = customerService.findCustomerByEmail(user.getEmail());
        if (seller.isPresent()) {
            if (seller.get().getPassword().equals(user.getPassword())) {
                httpSession.setAttribute("currentSeller", seller.get());
                return "redirect:/";
            } else {
                model.addAttribute("message", "Wrong password");
                return "login";
            }
        } else if (customer.isPresent()) {
            if (customer.get().getPassword().equals(user.getPassword())) {
                httpSession.setAttribute("currentCustomer", customer.get());
                return "redirect:/";
            } else {
                model.addAttribute("message", "Wrong password");
                return "login";
            }
        } else {
            model.addAttribute("message", "No such user");
            return "login";
        }
    }


    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
