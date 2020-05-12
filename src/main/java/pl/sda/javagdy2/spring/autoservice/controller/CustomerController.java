package pl.sda.javagdy2.spring.autoservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.javagdy2.spring.autoservice.model.Customer;
import pl.sda.javagdy2.spring.autoservice.service.CustomerService;

import java.util.Optional;


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


    @GetMapping("/edit")
    public String editCustomer(Model model, @RequestParam(name = "cust_id") Long customerId) {
        return getCustomerToEdit(model, customerId);
    }

    private String getCustomerToEdit(Model model, Long customerId) {
        Optional<Customer> optionalCustomer = customerService.findCustomer(customerId);
        if (optionalCustomer.isPresent()) {
            Customer customer = optionalCustomer.get();
            model.addAttribute("newCustomer", customer);
            model.addAttribute("customerId", customer.getId());
            //czemu w customer-form nie moge wywowałać tego pola?
            return "customer-form";
        } else {
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam(name = "cust_id") Long customerId) {
        customerService.deleteById(customerId);
        return "redirect:/customer/list";
    }
    @GetMapping("/details")
    public String customerDetailPage(Model model, @RequestParam(name="cust_id") Long customerId){
        Optional<Customer> customerOptional= customerService.findCustomer(customerId);
        if(customerOptional.isPresent()){
            Customer customer=customerOptional.get();
            model.addAttribute("customerDetails",customer);
            return "customer-detail";
        }

        return "redirect:/customer/list";
    }
}
