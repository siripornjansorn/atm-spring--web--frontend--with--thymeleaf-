package th.ac.kmitl.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.ac.kmitl.atm.model.Customer;
import th.ac.kmitl.atm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

   private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getCustomerPage(Model model){


        model.addAttribute("allCustomer",customerService.getCustomers());
        return "customer"; //customre.html tempate

    }

    @PostMapping
    public String registerCustomer(Customer customer, Model model){

       customerService.creatCustomer(customer);
        model.addAttribute("allCustomer", customerService.getCustomers());
        return  "redirect:customer";
    }
}
