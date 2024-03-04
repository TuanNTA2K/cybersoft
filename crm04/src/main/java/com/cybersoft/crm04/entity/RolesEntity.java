package com.cybersoft.crm04.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "roles")
public class RolesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column( name = "name",nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "rolesEntity") // TODO note: Tên của thuộc tính entity khai báo bên UserEntity
    private List<UsersEntity> users;

    public RolesEntity() {
    }

    public RolesEntity(int id, String name, String description, List<UsersEntity> users) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<UsersEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UsersEntity> users) {
        this.users = users;
    }
}
