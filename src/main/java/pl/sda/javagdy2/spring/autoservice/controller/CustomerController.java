package pl.sda.javagdy2.spring.autoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.javagdy2.spring.autoservice.model.Customer;
import pl.sda.javagdy2.spring.autoservice.service.CustomerService;


@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/add")
    public String customerAdd(Model model) {
        model.addAttribute("newCustomer", new Customer());
        return "customer-form";
    }

    @PostMapping("/add")
    public String customerAdd(Customer customer) {
        customerService.add(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/list")
    public String customerList(Model model) {
        model.addAttribute("listOfCustomers", customerService.getDataBase());
        return "customer-list";
    }

}
