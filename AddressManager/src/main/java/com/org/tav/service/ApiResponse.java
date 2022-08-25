package com.org.tav.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String status;
    public Boolean checkResponse(){
        return status.equalsIgnoreCase("OK");
    }
}