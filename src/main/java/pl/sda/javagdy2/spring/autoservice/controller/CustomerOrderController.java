package pl.sda.javagdy2.spring.autoservice.controller;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.javagdy2.spring.autoservice.model.Customer;
import pl.sda.javagdy2.spring.autoservice.model.CustomerOrder;
import pl.sda.javagdy2.spring.autoservice.model.Fault;
import pl.sda.javagdy2.spring.autoservice.service.CustomerOrderService;
import pl.sda.javagdy2.spring.autoservice.service.CustomerService;

import java.util.Optional;

@Controller
@RequestMapping("/order")
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping("/add")
    public String orderAddForm(Model model,
                               @RequestParam("customer_id") Long customerId) {
        model.addAttribute("newOrder", new CustomerOrder());
        model.addAttribute("customerId", customerId);
        model.addAttribute("faults", Fault.values());
        return "order-form";
    }

    @PostMapping("/add")
    public String saveOrder(CustomerOrder customerOrder, Long customerOrdered) {
        customerOrderService.saveOrder(customerOrder, customerOrdered);
        return "redirect:/customer/details?cust_id=" + customerOrdered;
    }

    @GetMapping("/edit")
    public String editOrder(Model model, @RequestParam(name = "orderId") Long orderId) {
        Optional<CustomerOrder> optionalOrder = customerOrderService.findById(orderId);
        if (optionalOrder.isPresent()) {
            CustomerOrder customerOrder = optionalOrder.get();
            model.addAttribute("newOrder", customerOrder);
            model.addAttribute("faults", Fault.values());
            model.addAttribute("customerId", customerOrder.getCustomer().getId());
            model.addAttribute("car_plate", customerOrder.getCar_plate());
            model.addAttribute("paid", customerOrder.isPaid());
            return "order-form";
        }
        return "redirect:/customer/list";
    }

    @GetMapping("/delete")
    public String deleteOrder(@RequestParam(name = "orderId") Long orderId) {
        Optional<CustomerOrder> optionalOrder = customerOrderService.findById(orderId);
        Long cust_id = null;
        if (optionalOrder.isPresent()) {
            CustomerOrder customerOrder = optionalOrder.get();
            cust_id = customerOrder.getCustomer().getId();
        }
        customerOrderService.deleteById(orderId);
        return "redirect:/customer/details?cust_id=" + cust_id;
    }
}
