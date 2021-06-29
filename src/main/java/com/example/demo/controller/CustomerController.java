package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;


    @GetMapping("")
    public ModelAndView showList(){
        return new ModelAndView("/customer/list","list",customerService.findAll());
    }


    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        return new ModelAndView("/customer/create", "customer", new  Customer());
    }

    @PostMapping("/create")
    public ModelAndView create(Customer customer){
        customerService.save(customer);
        return new ModelAndView("redirect:");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Long id){
        return new ModelAndView("/customer/edit", "customer", customerService.findById(id));

    }

    @PostMapping("/edit")
    public ModelAndView edit(Customer customer){
        customerService.save(customer);
        return new ModelAndView("redirect:");
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showFormDelete(@PathVariable Long id){
        return new ModelAndView("/customer/delete", "customer",customerService.findById(id));
    }

    @PostMapping("/delete")
    public ModelAndView delete(Customer customer){
        customerService.remove(customer.getId());
        return new ModelAndView("redirect:");
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable Long id){
        return new ModelAndView("/customer/view", "customer", customerService.findById(id));
    }

}
