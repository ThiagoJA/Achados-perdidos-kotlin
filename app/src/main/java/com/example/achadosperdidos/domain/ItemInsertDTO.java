package com.example.achadosperdidos.domain;

import java.io.Serializable;

public class ItemInsertDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;
    private String description;
    private String date;
    //	private int object_flag; todo -- enum
    private int reward;

    public ItemInsertDTO() {
    }


    public ItemInsertDTO(Long id, String name, String description, String date, int reward) {
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

    public Item toEntity() {
        return new Item(id, name, description, date, reward);
    }
}
