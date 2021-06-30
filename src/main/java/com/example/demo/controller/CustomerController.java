package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteBlog(@PathVariable Long id) {
        customerService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable Long id){
        return new ModelAndView("/customer/view", "customer", customerService.findById(id));
    }

}
