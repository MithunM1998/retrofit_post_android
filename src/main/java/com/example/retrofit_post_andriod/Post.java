package com.example.retrofit_post_andriod;
import com.google.gson.annotations.SerializedName;
public class Post {
    @SerializedName("userId")
    int userId;

    @SerializedName("id")
    int id;

    @SerializedName("title")
    String title;

    @SerializedName("body")
    String body;


    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getUserId() {
        return userId;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public String getBody() {
        return body;
    }
}
