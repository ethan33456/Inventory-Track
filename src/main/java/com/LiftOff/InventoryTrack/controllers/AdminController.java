package com.LiftOff.InventoryTrack.controllers;

import com.LiftOff.InventoryTrack.data.ProductRepository;
import com.LiftOff.InventoryTrack.data.StorefrontRepository;
import com.LiftOff.InventoryTrack.models.Product;
import com.LiftOff.InventoryTrack.models.Storefront;
import com.LiftOff.InventoryTrack.models.dto.StorefrontProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Iterator;
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
    public String displayAllProducts(Model model) {
        model.addAttribute("title", "All Products");
        model.addAttribute("products", productRepository.findAll());
        return "admin/editProducts.html";
    }
    @RequestMapping(value = "buy")
    public String buyNow(@RequestParam Integer productId)
    {
        Optional<Product> result = productRepository.findById(productId);
        Product product = result.get();

        product.buyNow();
        productRepository.save(product);
        return "redirect:";
    }

    @PostMapping(value = "editProducts")
    public String processAddProductForm(@RequestParam String name, @RequestParam String description, @RequestParam float price, @RequestParam int quantity) {
        productRepository.save(new Product(name, description,price, quantity));

        return "redirect:editProducts";
    }

    @GetMapping(value = "editStorefronts")
    public String displayStorefronts(Model model) {
        model.addAttribute("title", "All Storefronts");
        model.addAttribute("storefronts", storefrontRepository.findAll());
        return "admin/editStorefronts.html";
    }

    @PostMapping(value = "editStorefronts")
    public String processAddStorefrontForm(@RequestParam String name, @RequestParam String description) {
        storefrontRepository.save(new Storefront(name, description));

        return "admin/editStorefronts.html";
    }

    @PostMapping(value = "updateProduct")
    public String processUpdateProduct(@RequestParam String name, @RequestParam String description, @RequestParam float price, @RequestParam int quantity, @RequestParam Integer id)
    {
        System.out.println(name +" ,"+ description +" ,"+ price +" ,"+ quantity +" ,"+ id);
        productRepository.updateProductById(name, description, price, quantity, id);
        return "redirect:";
    }



    //Should respond to /add-product?storefrontId=
    @GetMapping("add-product")
    public String displayAddProductToStoreForm(@RequestParam Integer storefrontId, Model model) {
        Optional<Storefront> result = storefrontRepository.findById(storefrontId);
        Storefront storefront = result.get();
        model.addAttribute("Title", "Add product to " + storefront.getName());
        model.addAttribute("storefront", storefront);
        model.addAttribute("products", productRepository.findAll());
        StorefrontProductDTO storefrontProduct = new StorefrontProductDTO();
        storefrontProduct.setStorefront(storefront);
        model.addAttribute("storefrontProduct", storefrontProduct);
        return "admin/addProductToStore.html";
    }

    @PostMapping("add-product")
    public String processAddProductToStoreForm(@ModelAttribute @Validated StorefrontProductDTO storefrontProduct, Errors errors, Model model) {

        if (!errors.hasErrors()) {
            Storefront storefront = storefrontProduct.getStorefront();
            Product product = storefrontProduct.getProduct();
            if (!storefront.getProducts().contains(product)) {
                storefront.addProduct(product);
                System.out.print("fefefef");

                storefrontRepository.save(storefront);
            }
            return "redirect:add-product?storefrontId=" + storefront.getId();
        }
    return "redirect:add-product";
    }
    @RequestMapping("deleteProduct")
    public String deleteProduct(@RequestParam Integer id, Model model)
    {
        //Isolate product passed in
         Optional<Product> result = productRepository.findById(id);
         Product product = result.get();
         int size = product.getStorefronts().size();
         //Delete all storefronts from product
//        Iterator<Storefront> iterator = product.getStorefronts().iterator();
//        int size = product.getStorefronts().size();
//        while (iterator.hasNext())
//        {
//            Storefront s;
//            s = iterator.next();
//            s.deleteProduct(product);
//
//        }
//        product.getStorefronts().removeAll(product.getStorefronts());
        //Iterator<Storefront> iterator = product.getStorefronts().iterator();
        //for (int i = 0; i < size; i++) {
            //while (iterator.hasNext()) {
               // Storefront storefront = iterator.next();
                //storefront.deleteProduct(product);
             //   product.deleteStorefront(storefront);
           // }
        for ( Storefront storefront : new ArrayList<Storefront>( product.getStorefronts() )) {
            product.deleteStorefront(storefront);

        }
        //}
        productRepository.delete(product);

         return "redirect:";
    }
    @PostMapping("delete-product")
    public String processDeleteProductFromStoreForm(@ModelAttribute Storefront storefront, @ModelAttribute Product product, Model model) {

        product.deleteStorefront(storefront);
        productRepository.save(product);
        return "redirect:add-product?storefrontId=" + storefront.getId();

    }
    @GetMapping(value = "updateProduct")
    public String displayUpdateProduct(@RequestParam Integer id, Model model)
    {
        Optional<Product> result = productRepository.findById(id);
        Product product = result.get();
        model.addAttribute("Title", "Edit " + product.getName());
        model.addAttribute("product", product);
        return "admin/updateProduct.html";
    }
    @GetMapping("shop")
    public String displayShop(@RequestParam Integer storefrontId, Model model) {
        Optional<Storefront> result = storefrontRepository.findById(storefrontId);
        Storefront storefront = result.get();
        model.addAttribute("Title", "Shop " + storefront.getName());
        model.addAttribute("products", storefront.getProducts());
        StorefrontProductDTO storefrontProduct = new StorefrontProductDTO();
        storefrontProduct.setStorefront(storefront);
        model.addAttribute("storefront", storefront);
        model.addAttribute("storefrontProduct", storefrontProduct);
        return "shop.html";
    }
    @PostMapping("shop")
    public String buyProduct(@RequestParam Integer productId)
    {
       Optional<Product> result = productRepository.findById(productId);
       Product product = result.get();
       product.buyNow();
       productRepository.save(product);
        return "shop.html";
    }
}
