package com.rma.placeholder.rascunho_placeholder.presentation;

import android.os.Parcel;
import android.os.Parcelable;

import com.rma.placeholder.rascunho_placeholder.presentation.user.Address;
import com.rma.placeholder.rascunho_placeholder.presentation.user.Company;

public class User implements Parcelable {

    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public User() {
    }

    protected User(Parcel in) {
        id = in.readInt();
        name = in.readString();
        username = in.readString();
        email = in.readString();
        phone = in.readString();
        website = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return
                        "Id: "+getId()+"\n"+
                                "Name: "+getName()+"\n"+
                                "Username: "+getUsername()+"\n"+
                                "Email: "+getEmail()+"\n"+
                                "Street: "+getAddress().getStreet()+"\n"+
                                "Suite: "+getAddress().getSuite()+"\n"+
                                "City: "+getAddress().getCity()+"\n"+
                                "ZipCode: "+getAddress().getZipcode()+"\n"+
                                "Latitude: "+ getAddress().getGeo().getLat()+"\n"+
                                "Longitude: "+getAddress().getGeo().getLng()+"\n"+
                                "Phone: "+ getPhone()+"\n"+
                                "Website: "+getWebsite()+"\n"+
                                "Company Name: "+  getCompany().getName()+"\n"+
                                "Catch Prase: "+ getCompany().getCatchPhrase()+"\n"+
                                "BS: "+ getCompany().getBs()+"\n";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(username);
        parcel.writeString(email);
        parcel.writeString(phone);
        parcel.writeString(website);
    }
}
