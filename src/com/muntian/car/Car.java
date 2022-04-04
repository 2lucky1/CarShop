package com.muntian.car;

import java.math.BigDecimal;

public class Car {
    private String name;
    private Color color;

    private BigDecimal price;

    public Car(String name, Color color, BigDecimal price) {
        this.name = name;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color=" + color +
                ", price=" + price +
                '}';
    }
}
