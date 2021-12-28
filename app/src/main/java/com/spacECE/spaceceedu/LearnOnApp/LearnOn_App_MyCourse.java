package com.spacECE.spaceceedu.LearnOnApp;

public class LearnOn_App_MyCourse {
    private String id;
    private String title;
    private final String description;
    private String type;
    private final String mode;
    private final String duration;
    private final String price;

    public LearnOn_App_MyCourse(String id, String title, String description, String type, String mode, String duration, String price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.type = type;
        this.mode = mode;
        this.duration = duration;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMode() {
        return mode;
    }

    public String getDuration() {
        return duration;
    }

    public String getPrice() {
        return price;
    }
}
