package com.LiftOff.InventoryTrack.controllers;

import com.LiftOff.InventoryTrack.data.ProductData;
import com.LiftOff.InventoryTrack.models.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @RequestMapping(value="")
    @ResponseBody
    public String index(){
        return "Hello World";
    }


    @RequestMapping(value="home")
    public String home(){
        return "HomePage.html";
    }

    @GetMapping(value = "admin")
    public String displayAllProductsAndStorefronts(Model model) {
        model.addAttribute("title", "All Products");
        model.addAttribute("products", ProductData.getAll());
        return "admin.html";
    }
    @PostMapping(value = "admin")
    public String processAddProductForm(@RequestParam String name, @RequestParam String description, @RequestParam float price, @RequestParam int quantity)
    {
        ProductData.add(new Product(name, description, price, quantity));
        return "admin.html";
    }

    @RequestMapping(value="goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye";
    }
}
