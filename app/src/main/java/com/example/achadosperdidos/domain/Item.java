package com.example.achadosperdidos.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Item implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String name;
    private String description;
    private String date;
    private int reward;


    private Address adrress;



    private Set<Tag> tags = new HashSet<>();


    private User user;

    private Item() {
    }

    public Item(Long id, String name, String description, String date, int reward) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.reward = reward;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAdrress() {
        return adrress;
    }

    public void setAdrress(Address adrress) {
        this.adrress = adrress;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
