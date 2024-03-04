package com.cybersoft.crm04.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity(name = "tasks")
public class TasksEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Temporal(TemporalType.DATE)
    @Column(name = "start_date")
    private Date startDate;
    @Temporal(TemporalType.DATE)
    @Column(name = "end_date")
    private Date endDate;
    @ManyToOne      // TODO note: Dựa vào "ManyToOne" hay "OneToMany" Xem chữ sau cùng để chọn một đối tượng private hay một List đối tượng.
    @JoinColumn(name = "user_id")       // TODO note: Tên cột trong dâatabase dùng để liên kết dữ liệu
    private UsersEntity usersEntity;    // TODO note: Dựa vào "ManyToOne" hay "OneToMany" Xem chữ sau cùng để chọn một đối tượng private hay một List đối tượng.
    @ManyToOne
    @JoinColumn(name = "job_id")
    private JobsEntity jobsEntity;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEntity statusEntity;

    public TasksEntity() {
    }

    public TasksEntity(int id, String name, Date startDate, Date endDate, UsersEntity usersEntity, JobsEntity jobsEntity, StatusEntity statusEntity) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.usersEntity = usersEntity;
        this.jobsEntity = jobsEntity;
        this.statusEntity = statusEntity;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public UsersEntity getUsersEntity() {
        return usersEntity;
    }

    public void setUsersEntity(UsersEntity usersEntity) {
        this.usersEntity = usersEntity;
    }

    public JobsEntity getJobsEntity() {
        return jobsEntity;
    }

    public void setJobsEntity(JobsEntity jobsEntity) {
        this.jobsEntity = jobsEntity;
    }

    public StatusEntity getStatusEntity() {
        return statusEntity;
    }

    public void setStatusEntity(StatusEntity statusEntity) {
        this.statusEntity = statusEntity;
    }
}
