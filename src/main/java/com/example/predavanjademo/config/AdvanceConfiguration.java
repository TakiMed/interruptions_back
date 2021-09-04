package com.example.predavanjademo.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "advance")
public class AdvanceConfiguration {
// mapiras iz app.yaml atribute
    private String url; // https://advanceweb.com
    private Number port; // 555
    private String username; // dispecer
    private String password; // dispecer

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Number getPort() {
        return port;
    }

    public void setPort(Number port) {
        this.port = port;
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

//    advance:
//    url: https://advanceweb.com
//    port: 555
//    username: dispecer
//    password: dispecer

}
