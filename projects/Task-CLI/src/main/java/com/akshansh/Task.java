package com.akshansh;

import java.util.Date;

enum Status{
    TODO("todo"), IN_PROGRESS("in-progress"), DONE("done");

    private final String stat;

    Status(String stat){
        this.stat = stat;
    }

    public String getStat(){
        return stat;
    }
}


public class Task {
    private int id;
    private String desc;
    private Status status;
    private Date createdAt;
    private Date updatedAt;

    public Task(int id, String desc, Status status, Date createdAt, Date updatedAt) {
        this.id = id;
        this.desc = desc;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
