package com.example.part_2.controller;

import com.example.part_2.model.Product;
import com.example.part_2.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("/products")
    public String viewProducts(Model model) {
        model.addAttribute("products", productService.findAll());

        return "products.html";
    }

    @PostMapping("/products")
    public String addProduct(@RequestParam String name, @RequestParam double price, Model model) {
        Product p = new Product();
        p.setName(name);
        p.setPrice(price);
        productService.addProduct(p);

        model.addAttribute("products", productService.findAll());

        return "products.html";
   }

    @PostMapping("/products1")
    public String addProduct1(Product p, Model model) {
        productService.addProduct(p);
        model.addAttribute("products", productService.findAll());

        return "products.html";
    }

}
