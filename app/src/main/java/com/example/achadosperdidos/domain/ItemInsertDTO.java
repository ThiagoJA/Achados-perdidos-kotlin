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


    public ItemInsertDTO(Item entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.description = entity.getDescription();
        this.date = entity.getDate();
        this.reward = entity.getReward();
    }


    public Item toEntity() {
        return new Item(id, name, description, date, reward);
    }
}
