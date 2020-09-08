package com.example.mydigitalbloodbank;

public class userprofile {
    private  String address,age,bloodgroup,dod,name,phone,password,email;

    public userprofile() {
    }

    public userprofile(String name, String age, String address, String bloodgroup, String dod, String phone) {
        this.name = name;

        this.address = address;
        this.age = age;
        this.bloodgroup = bloodgroup;
        this.dod = dod;
        this.phone = phone;
        this.email=email;
        this.password=password;
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

    public String getname() {
        return name;
    }

    public void setUsername(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhonenumber(String phone) {
        this.phone = phone;
    }
}
