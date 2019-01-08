package com.codecool.bbbt.huntapped.backend.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CheckinForm {

    private String username;
    private String description;
    private Double rating;
    private Long beerId;
    private Long venueId;

    @Override
    public String toString() {
        return "CheckinForm{" +
                "username='" + username + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", beerId=" + beerId +
                ", venueId=" + venueId +
                '}';
    }
}
