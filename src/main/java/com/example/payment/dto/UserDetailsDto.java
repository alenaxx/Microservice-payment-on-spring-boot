package com.example.payment.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDetailsDto {
    private String name;
    private String cardInfo;

    public UserDetailsDto(
            @JsonProperty("username") String name,
            @JsonProperty("cardInfo") String cardAuthorizationInfo) {
        this.name = name;
        this.cardInfo = cardAuthorizationInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardInfo() {
        return cardInfo;
    }

    public void setCardAuthorizationInfo(String cardAuthorizationInfo) {
        this.cardInfo = cardAuthorizationInfo;
    }
}