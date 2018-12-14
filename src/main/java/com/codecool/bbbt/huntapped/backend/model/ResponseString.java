package com.codecool.bbbt.huntapped.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseString {

    private String response;

    public ResponseString(String s) {
        this.response = s;
    }
}