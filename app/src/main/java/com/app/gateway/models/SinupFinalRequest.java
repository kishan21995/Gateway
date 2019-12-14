package com.app.gateway.models;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SinupFinalRequest {

@SerializedName("status")
@Expose
private String status;
@SerializedName("username")
@Expose
private String username;
@SerializedName("password")
@Expose
private String password;
@SerializedName("email")
@Expose
private String email;
@SerializedName("address")
@Expose
private String address;
@SerializedName("mobile")
@Expose
private String mobile;

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getMobile() {
return mobile;
}

public void setMobile(String mobile) {
this.mobile = mobile;
}

}