package com.example.comp2100_6442;

public class RegoData {
    String usernameData;
    String emailData;
    String passwordData;

    public RegoData() {
    }

    public RegoData(String usernameData, String emailData, String passwordData) {
        this.usernameData = usernameData;
        this.emailData = emailData;
        this.passwordData = passwordData;
    }

    public String getUsernameData() {
        return usernameData;
    }

    public void setUsernameData(String usernameData) {
        this.usernameData = usernameData;
    }

    public String getEmailData() {
        return emailData;
    }

    public void setEmailData(String emailData) {
        this.emailData = emailData;
    }

    public String getPasswordData() {
        return passwordData;
    }

    public void setPasswordData(String passwordData) {
        this.passwordData = passwordData;
    }
}
