package com.example.mydigitalbloodbank;

public class peopleInformation {
    private String address,age,bloodgroup,dod,name,phone;

    public peopleInformation() {
    }

    @Override
    public String toString() {
        return "peopleInformation{" +
                "address='" + address + '\'' +
                ", age='" + age + '\'' +
                ", bloodgroup='" + bloodgroup + '\'' +
                ", dod='" + dod + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public void setDod(String dod) {
        this.dod = dod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public String getAge() {
        return age;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public String getDod() {
        return dod;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
