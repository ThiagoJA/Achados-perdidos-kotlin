package com.example.achadosperdidos.domain;

import java.io.Serializable;

import java.util.Set;

public class ItemDTO extends Throwable implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String description;
    private String date;
    private int reward;
    private Set<Tag> tags;
    private User user;

    private Address address;

    private ItemDTO() {
    }

    public ItemDTO(Long id, String name, String description, String date, int reward, Set<Tag> tags, User user, Address address) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.date = date;
        this.reward = reward;
        this.tags = tags;
        this.user = user;
        this.address = address;
    }

    public ItemDTO(Item entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.date = entity.getDate();
        this.reward = entity.getReward();
        this.tags = entity.getTags();
        this.user = entity.getUser();
        this.address = entity.getAdrress();
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Item toEntity() {
        return new Item(id, name, description, date, reward);
    }
}
