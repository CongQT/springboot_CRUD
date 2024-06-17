package com.example.demo_springboot.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentRequest {

    @NotBlank(message = "MISSING_NAME")
    @JsonProperty("name")
    private String name;

    @NotBlank(message = "MISSING_EMAIL")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "MISSING_PHONE")
    @JsonProperty("phone")
    private String phone;

    @NotBlank(message = "MISSING_ADDRESS")
    @JsonProperty("address")
    private String address;
}
