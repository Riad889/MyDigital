package com.example.mydigitalbloodbank;

public class InfoGather {
    private String name,address,age,bloodgroup,dod,phone,email,password;

    public InfoGather() {
    }

    public InfoGather(String name, String age, String address, String bloodgroup, String dod, String phone, String email, String password) {
        this.name = name;

        this.address = address;
        this.age = age;
        this.bloodgroup = bloodgroup;
        this.dod = dod;
        this.phone = phone;
        this.email=email;
        this.password=password;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getDod() {
        return dod;
    }

    public void setDod(String dod) {
        this.dod = dod;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
