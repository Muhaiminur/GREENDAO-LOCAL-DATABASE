package com.example.abir.greendaodatabase;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by ABIR on 3/12/2018.
 */

@Entity(nameInDb = "user")
public class STORE {

    @Id(autoincrement = true)
    private Long id;

    @Property(nameInDb = "name")
    private String name;

    @Property(nameInDb = "owner")
    private String owner;

    @Property(nameInDb = "address")
    private String address;
    @Property(nameInDb = "mobile")
    private String mobile;
    @Generated(hash = 1553651928)
    public STORE(Long id, String name, String owner, String address,
            String mobile) {
        this.id = id;
        this.name = name;
        this.owner = owner;
        this.address = address;
        this.mobile = mobile;
    }
    @Generated(hash = 2014861033)
    public STORE() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOwner() {
        return this.owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getMobile() {
        return this.mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}