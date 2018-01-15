package com.sheygam.masa_g2_15_01_18_part2;

/**
 * Created by gregorysheygam on 15/01/2018.
 */

public class User {
    private String name, email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
