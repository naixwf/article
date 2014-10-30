package com.naixwf.article.domain;

public class Category {
    private Integer id;

    private String categroyName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategroyName() {
        return categroyName;
    }

    public void setCategroyName(String categroyName) {
        this.categroyName = categroyName == null ? null : categroyName.trim();
    }
}