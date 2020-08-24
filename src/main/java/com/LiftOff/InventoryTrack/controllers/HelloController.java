package com.LiftOff.InventoryTrack.controllers;

import com.LiftOff.InventoryTrack.data.ProductData;
import com.LiftOff.InventoryTrack.data.ProductRepository;
import com.LiftOff.InventoryTrack.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value="")
    public String home(){
        return "HomePage.html";
    }



    @RequestMapping(value="goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye";
    }
}
