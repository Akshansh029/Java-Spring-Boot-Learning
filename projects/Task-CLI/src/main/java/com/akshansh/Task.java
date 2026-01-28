package com.akshansh;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


public class Task implements Comparable<Task>{
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private int id;
    private String desc;
    private Status status;
    private Date createdAt;
    private Date updatedAt;

    public Task(String desc, Status status, Date createdAt, Date updatedAt) {
        this.id = idCounter.incrementAndGet();
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

    @Override
    public int compareTo(Task that){
        if(this.getId() > that.getId()){
            return 1;
        } else{
            return 0;
        }
    }
}
