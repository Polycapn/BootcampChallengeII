package com.example.polycap.bootcampchallengeii;

/**
 * Created by Polycap on 7/12/2015.
 */
public class list {
    String title;
    String desc;

    public list(String title, String desc) {
        this.title = title;
        this.desc =  desc;
    }

    public String getTitle(){
        return title;
    }

    public String getDesc(){
        return desc;
    }

}
