package com.app.gateway.models;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginFinalRequest {

@SerializedName("status")
@Expose
private String status;
@SerializedName("username")
@Expose
private String username;
@SerializedName("password")
@Expose
private String password;

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

}