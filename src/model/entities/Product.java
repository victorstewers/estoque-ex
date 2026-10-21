package model.entities;

import model.exceptions.DomainException;

public class Product {
    private String name;
    private Double price;
    private Integer quantity;

    public Product(String name, Double price, Integer quantity) throws DomainException{
        if(quantity<1){
            throw new DomainException("Can't save a product without a single quantity");
        }
        if(price<=0){
            throw new DomainException("Price must be greater than zero.");
        }
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    // public void setQuantity(Integer quantity) {
    //     this.quantity = quantity;
    // }

    public void addProducts(Integer quantity){
        this.quantity+=quantity;
    }
    public void removeProducts(Integer quantity) throws DomainException{
        if(quantity <= 0){
            throw new DomainException("Withdraw quantity must be greater than zero");
        }
        if(quantity>getQuantity()){
            throw new DomainException("Not enough stock for this operation");
        }
        this.quantity-=quantity;
    }
    public Double totalValueInStock(){
        return this.quantity*this.getPrice();
    }


    @Override 
    public String toString(){
        return this.getName()
                +", $ "
                +String.format("%.2f, ",getPrice())
                +this.getQuantity()
                +" units, Total: $ "
                +String.format("%.2f",totalValueInStock());
    }
    
}
