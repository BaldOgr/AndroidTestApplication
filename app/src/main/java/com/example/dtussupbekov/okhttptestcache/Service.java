package com.example.dtussupbekov.okhttptestcache;

import java.io.Serializable;

public class Service implements Serializable {
    private Long id;
    private String name;
    private Long parentId;
    private String title;
    private String description;
    private String picture;
    private String pictureUrl;
    private String merchant;
    private int status;
    private boolean isSimple;
    private String updatedAt;
    private int type;
    private boolean withChildren;
    private String template;

    public Service(Long id, String name, Long parentId, String title, String description,
                   String picture, String pictureUrl, String merchant, int status, boolean isSimple,
                   String updatedAt, int type, boolean withChildren, String template) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.pictureUrl = pictureUrl;
        this.merchant = merchant;
        this.status = status;
        this.isSimple = isSimple;
        this.updatedAt = updatedAt;
        this.type = type;
        this.withChildren = withChildren;
        this.template = template;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isSimple() {
        return isSimple;
    }

    public void setSimple(boolean simple) {
        isSimple = simple;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isWithChildren() {
        return withChildren;
    }

    public void setWithChildren(boolean withChildren) {
        this.withChildren = withChildren;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }
}
