package com.cybersoft.crm04.entity;

import jakarta.persistence.*;

@Entity(name = "users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "email",nullable = false,unique = true)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name="fullname")
    private String fullname;
    @Column(name="avatar")
    private String avatarPath;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private RolesEntity rolesEntity;

    public UsersEntity() {
    }

    public UsersEntity(int id, String email, String password, String fullname, String avatarPath, RolesEntity rolesEntity) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullname = fullname;
        this.avatarPath = avatarPath;
        this.rolesEntity = rolesEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAvatarPath() {
        return avatarPath;
    }

    public void setAvatarPath(String avatarPath) {
        this.avatarPath = avatarPath;
    }

    public RolesEntity getRolesEntity() {
        return rolesEntity;
    }

    public void setRolesEntity(RolesEntity rolesEntity) {
        this.rolesEntity = rolesEntity;
    }
}
