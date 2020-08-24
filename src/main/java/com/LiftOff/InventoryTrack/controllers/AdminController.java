package com.LiftOff.InventoryTrack.controllers;

import com.LiftOff.InventoryTrack.data.ProductRepository;
import com.LiftOff.InventoryTrack.data.StorefrontRepository;
import com.LiftOff.InventoryTrack.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StorefrontRepository storefrontRepository;

    @GetMapping(value = "admin")
    public String displayAllProductsAndStorefronts(Model model) {
        model.addAttribute("title", "All Products");
        model.addAttribute("products", productRepository.findAll());
        return "admin/index.html";
    }
    @GetMapping(value = "editProducts")
    public String displayAllProducts(Model model)
    {
        model.addAttribute("title", "All Products");
        model.addAttribute("products", productRepository.findAll());
        return "admin/editProducts.html";
    }
    @PostMapping(value = "editProducts")
    public String processAddProductForm(@RequestParam String name, @RequestParam String description, @RequestParam float price, @RequestParam int quantity)
    {
        productRepository.save(new Product(name, description, price, quantity));

        return "redirect:../";
    }

}
