/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nhom12.lop02;

public class WheyProduct {
    private String productName;
    private double price;
    private int stock;
    private String brand;
    private double protein;  
    private boolean isAvailable;
    private int soldQuantity;
    private String expiryDate;
    public WheyProduct(String productName, double price, int stock, String brand, double protein) {
        this.productName = productName.trim().toUpperCase();
        this.price = (price < 0) ? 0 : price;
        this.stock = (stock < 0) ? 0 : stock;
        this.brand = brand.trim();
        this.protein = protein;
        this.isAvailable = true;
        this.soldQuantity = 0;
    }
    public String getProductName() {
        return productName.toUpperCase();
    }
    public double getPrice() {
        return Math.round(price * 100.0) / 100.0;
    }
    
    public int getStock() {
        return stock;
    }
    
    public String getBrand() {
        return brand;
    }
    
    public double getProtein() {
        return protein;
    }
    
    public boolean isAvailable() {
        return isAvailable;
    }
    
    public int getSoldQuantity() {
        return soldQuantity;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setPrice(double price) {
        if(price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price;
    }
    public void setStock(int stock) {
        if(stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
        this.stock = stock;
    }
    public void setProtein(double protein) {
        if(protein < 0 || protein > 100) {
            throw new IllegalArgumentException("Protein must be 0-100%");
        }
        this.protein = protein;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public void displayProductInfo() {
        System.out.println("=== PRODUCT INFO ===");
        System.out.println("Name: " + productName);
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
        System.out.println("Stock: " + stock);
        System.out.println("Protein: " + protein + "%");
    }
    public void updateAvailability() {
        if(stock > 0) {
            isAvailable = true;
            System.out.println(productName + " is available");
        } else {
            isAvailable = false;
            System.out.println(productName + " is out of stock");
        }
    }
    public void restockProduct(int quantity) {
        if(quantity > 0) {
            stock += quantity;
            isAvailable = true;
            System.out.println("Added " + quantity + " units. New stock: " + stock);
        }
    }
    public void applyDiscount(double discountPercent) {
        double discount = price * (discountPercent / 100);
        price = price - discount;
        System.out.println("Applied " + discountPercent + "% discount. New price: $" + price);
    }
    public boolean isHighQuality() {
        return (protein >= 80.0 && price >= 500.0);
    }
    public String getQualityRating() {
        if(protein >= 90) return "Excellent";
        if(protein >= 80) return "Good";
        if(protein >= 70) return "Average";
        return "Low";
    }
    public double getTotalInventoryValue() {
        return price * stock;
    }
    public boolean isEligibleForDiscount() {
        return (stock > 100 || protein < 75.0);
    }
    
    public void processSale(int quantity) throws Exception{
        if(quantity <= 0) {
            throw new Exception("Quantity must be greater than 0");
        }
        if(quantity > stock) {
            throw new Exception("Not enough stock. Available: " + stock);
        }
        if(!isAvailable) {
            throw new Exception("Product is not available");
        }
        stock -= quantity;
        soldQuantity += quantity;
        System.out.println("Sold " + quantity + " units. Remaining: " + stock);
    }
    public void placeOrder(int quantity, double paymentAmount) throws Exception {
        if(quantity <= 0) {
            throw new Exception("Order quantity must be positive");
        }
        
        double totalCost = price * quantity;
        if(paymentAmount < totalCost) {
            throw new Exception("Insufficient payment. Need: $" + totalCost);
        }
        
        if(quantity > stock) {
            throw new Exception("Cannot order " + quantity + " units. Stock: " + stock);
        }
        
        stock -= quantity;
        System.out.println("Order placed successfully!");
    }
    public void updatePrice(double newPrice) throws Exception {
        if(newPrice <= 0) {
            throw new Exception("Price must be positive");
        }
        if(newPrice > price * 2) {
            throw new Exception("Price increase too high (max 200%)");
        }
        
        price = newPrice;
        System.out.println("Price updated to: $" + price);
    }
    
    public void checkExpiry(String currentDate) throws Exception {
        if(expiryDate == null || expiryDate.isEmpty()) {
            throw new Exception("Expiry date not set");
        }
        if(currentDate == null || currentDate.isEmpty()) {
            throw new Exception("Current date is invalid");
        }
      
        if(currentDate.compareTo(expiryDate) > 0) {
            throw new Exception("Product has expired!");
        }
        
        System.out.println("Product is still valid");
    }
}
