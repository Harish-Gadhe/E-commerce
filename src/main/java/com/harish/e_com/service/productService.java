package com.harish.e_com.service;

import java.io.IOException;
import java.util.List;

import com.harish.e_com.model.Product;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.harish.e_com.repo.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class productService {

    @Autowired
    private ProductRepo repo;

    public List<Product> getAllProducts() {

        return repo.findAll();
    }

    public Product getProductById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        return  repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        product.setImageData(imageFile.getBytes());
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        return repo.save(product);
    }
    public byte[] getProductImage(int id) {
        return repo.findById(id)
                   .map(Product::getImageData)
                   .orElse(null);
    }
    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}
