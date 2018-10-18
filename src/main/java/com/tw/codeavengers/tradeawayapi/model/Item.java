package com.tw.codeavengers.tradeawayapi.model;

import javax.persistence.*;
import java.net.URL;
import java.util.Set;

@Entity
@Table(name = "items")
public class Item {

    @Id
    @Column(name = "item_name")
    private String itemName;

    @ManyToOne
    private Category category;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private URL imageUrl;

    @Column
    private double price;

    @ManyToMany(targetEntity = User.class, fetch = FetchType.EAGER)
    private Set<User> sellers;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(URL imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Set<User> getSellers() {
        return sellers;
    }

    public void setSellers(Set<User> sellers) {
        this.sellers = sellers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        return itemName != null ? itemName.equals(item.itemName) : item.itemName == null;
    }

    @Override
    public int hashCode() {
        return itemName != null ? itemName.hashCode() : 0;
    }
}
