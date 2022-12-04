package by.tms.web;

import by.tms.entity.Customer;
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
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final SellerService sellerService;


    public CustomerController(CustomerService customerService, SellerService sellerService) {
        this.customerService = customerService;
        this.sellerService = sellerService;

    }

    @GetMapping("/customerRegistration")
    public String customerRegistration(@ModelAttribute("newCustomer") Customer customer) {
        return "customerRegistration";
    }

    @PostMapping("/customerRegistration")
    public String customerRegistration(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return "customerRegistration";
        }
        if(customerService.findCustomerByEmail(customer.getEmail()).isEmpty()
        && sellerService.findSellerByEmail(customer.getEmail()).isEmpty()){
            customerService.saveCustomer(customer);
            return "redirect:/";
        }
        else {
            model.addAttribute("message", "User already exist");
            return "customerRegistration";
        }
    }
}
