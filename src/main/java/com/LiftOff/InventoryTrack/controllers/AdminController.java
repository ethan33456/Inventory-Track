package com.LiftOff.InventoryTrack.controllers;

import com.LiftOff.InventoryTrack.data.ProductRepository;
import com.LiftOff.InventoryTrack.data.StorefrontRepository;
import com.LiftOff.InventoryTrack.models.Product;
import com.LiftOff.InventoryTrack.models.Storefront;
import com.LiftOff.InventoryTrack.models.dto.StorefrontProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

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

        return "admin/editProducts.html";
    }

    @GetMapping(value = "editStorefronts")
    public String displayStorefronts(Model model)
    {
        model.addAttribute("title", "All Storefronts");
        model.addAttribute("storefronts", storefrontRepository.findAll());
        return "admin/editStorefronts.html";
    }
    @PostMapping(value = "editStorefronts")
    public String processAddStorefrontForm(@RequestParam String name, @RequestParam String description)
    {
        storefrontRepository.save(new Storefront(name, description));

        return "admin/editStorefronts.html";
    }

    //Should respond to /add-product?storefrontId=
    @GetMapping("add-product")
    public String displayAddProductToStoreForm(@RequestParam Integer storefrontId, Model model)
    {
        Optional<Storefront> result = storefrontRepository.findById(storefrontId);
        Storefront storefront = result.get();
        model.addAttribute("Title", "Add product to " + storefront.getName());
        model.addAttribute("products", productRepository.findAll());
        model.addAttribute("storefront", storefront);
        model.addAttribute("storefrontProduct",new StorefrontProductDTO());
        return "admin/addProductToStore.html";
    }
    @PostMapping
    public String processAddProductToStoreForm(@ModelAttribute)
    {

    }

}
