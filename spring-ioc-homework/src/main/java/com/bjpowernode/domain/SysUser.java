package com.bjpowernode.domain;

public class SysUser {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "SysUser={" + 
                "name:'" + name + '\'' +
                "id:'" + id + '\'' +
                '}';
    }

}