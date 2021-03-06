package com.app.gateway.models.login;



import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

@SerializedName("status")
@Expose
private Boolean status;
@SerializedName("message")
@Expose
private String message;
@SerializedName("id")
@Expose
private String id;
@SerializedName("username")
@Expose
private String username;
@SerializedName("passcode")
@Expose
private String passcode;
@SerializedName("email")
@Expose
private String email;
@SerializedName("mobile")
@Expose
private String mobile;

public Boolean getStatus() {
return status;
}

public void setStatus(Boolean status) {
this.status = status;
}

public String getMessage() {
return message;
}

public void setMessage(String message) {
this.message = message;
}

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getUsername() {
return username;
}

public void setUsername(String username) {
this.username = username;
}

public String getPasscode() {
return passcode;
}

public void setPasscode(String passcode) {
this.passcode = passcode;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getMobile() {
return mobile;
}

public void setMobile(String mobile) {
this.mobile = mobile;
}

}