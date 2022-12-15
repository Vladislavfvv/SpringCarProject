package by.tms.web;

import by.tms.dto.UserDto;
import by.tms.entity.User;
import by.tms.service.OfferService;
import by.tms.service.UserService;
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

    //    private final SellerService sellerService;
//    private final CustomerService customerService;

    private final UserService userService;
    private final OfferService offerService;

    public UserController(UserService userService, OfferService offerService) {
        this.offerService = offerService;
        this.userService = userService;
    }


//    public UserController(SellerService sellerService, CustomerService customerService, UserService userService) {
//        this.sellerService = sellerService;
//        this.customerService = customerService;
//        this.userService = userService;
//    }

    @GetMapping("/signup")
    public String signup(@ModelAttribute("newUser") User user) {
        return "/user/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/user/signup";
        }

        Optional<User> isExist = userService.findUserByEmail(user.getEmail());

        if (isExist.isEmpty()) {
            userService.save(user);
            return "redirect:/";
        } else {
            model.addAttribute("message", "User is already exists");
            return "/user/signup";
        }
    }


    @GetMapping("/login")
    public String login(@ModelAttribute("loginUser") UserDto userDto) {
        return "user/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginUser") UserDto userDto, BindingResult bindingResult, HttpSession httpSession, Model model) {
        if (bindingResult.hasErrors()) {
            return "user/login";
        }
        Optional<User> userByEmail = userService.findUserByEmail(userDto.getEmail());
        if (userByEmail.isPresent()) {
            if (userByEmail.get().getPassword().equals(userDto.getPassword())) {
                httpSession.setAttribute("currentUser", userByEmail.get());
//                model.addAttribute("listOfOffers", offerService.findOfferByUser((User) model.getAttribute("currentUser"));
//                model.addAttribute("listOfOffers", offerService.findOfferByUser((User) httpSession.getAttribute("currentUser")));
                //System.out.println(userDto);
                return "user/personalAccount";
            } else {
                model.addAttribute("message", "Wrong password");
                return "user/login";
            }

        } else {
            model.addAttribute("message", "No such user");
            return "user/login";
        }
    }

//        Optional<Seller> seller = sellerService.findSellerByEmail(user.getEmail());
//        Optional<Customer> customer = customerService.findCustomerByEmail(user.getEmail());
//        if (seller.isPresent()) {
//            if (seller.get().getPassword().equals(user.getPassword())) {
//                httpSession.setAttribute("currentSeller", seller.get());
//                return "redirect:/";
//            } else {
//                model.addAttribute("message", "Wrong password");
//                return "login";
//            }
//        } else if (customer.isPresent()) {
//            if (customer.get().getPassword().equals(user.getPassword())) {
//                httpSession.setAttribute("currentCustomer", customer.get());
//                return "redirect:/";
//            } else {
//                model.addAttribute("message", "Wrong password");
//                return "login";
//            }
//        }
//        else {
//            model.addAttribute("message", "No such user");
//        return "login";
//        }


    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }

    @GetMapping("/personalAccount")
    public String personalAccount(/*@Valid @ModelAttribute("personalUserData") User user*/) {
        return "user/personalAccount";
    }
//    @PostMapping("/personalAccount")
//    public String personalAccount(/*@Valid @ModelAttribute("personalUserData") User user*/) {
//        return "user/personalAccount";
//    }


}
