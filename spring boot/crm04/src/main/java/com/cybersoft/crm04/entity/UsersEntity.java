package com.cybersoft.crm04.entity;

import jakarta.persistence.*;
/*
   * Để mapping khóa ngoại trong Entity
   - B1: Xem khóa chính 2 bảng đang có quan hệ với nhau có phải là tự dộng tăng hay không.
   Nếu tự dộng tăng thì không là OneToOne => OneToMany
   - B2: Nếu khóa chính không tự động tăng và vừa là khóa chính và khóa ngoại => OneToOne

   * 1 : OneToMany : Entity nào giữ khóa ngoại thì sẽ có 2 @ sau đây:
   - @ManyToOne và @JoinColumn
   Bảng đc tham chiếu khóa ngoại sẽ map ngược lại
   - @OneToMany:
 */
@Entity(name="users")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name="fullname")
    private String fullname;
    @Column(name="avatar")
    private String avatar;
//    @Column(name="role_id")
//    private int roleId;
    @ManyToOne
    @JoinColumn(name="role_id")//tên cột khóa ngoại trong database dùng để liên kết dữ liệu
    private RolesEntity rolesEntity;//dựa vào chữ đằng sau OneToMany hay ManyToOne thì sẽ biết đc là
//  1 đối tượng hay 1 list đối tượng

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public RolesEntity getRolesEntity() {
        return rolesEntity;
    }

    public void setRolesEntity(RolesEntity rolesEntity) {
        this.rolesEntity = rolesEntity;
    }
}
