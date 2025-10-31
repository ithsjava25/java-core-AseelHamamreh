package com.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public class FoodProduct extends Product implements Perishable, Shippable {

    private final LocalDate bestBefore;
    private final BigDecimal mass;

    public FoodProduct(UUID productId, String productName, Category productCategory, BigDecimal price,
                       LocalDate bestBefore, BigDecimal mass) {
        super(productId, productName, productCategory, price);

        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price cannot be negative.");
        }
        if (mass.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Weight cannot be negative.");
        }

        this.bestBefore = bestBefore;
        this.mass = mass;
    }

    @Override
    public LocalDate expirationDate() {
        return bestBefore;
    }

    @Override
    public String productDetails() {
        return "Food: " + name() + ", Expires: " + bestBefore;
    }

    @Override
    public double weight() {
        return mass.doubleValue();
    }

    @Override
    public BigDecimal calculateShippingCost() {
        return mass.multiply(BigDecimal.valueOf(50));
    }
}
