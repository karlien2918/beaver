package com.example.paymentservice.common.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
	private boolean status;
	private String message;
	private T data;

	public static <T> ApiResponse<T> success(T data){
		return new ApiResponse<>(true, "Success", data);
	}
	public static <T> ApiResponse<T> success(String message, T data){
		return new ApiResponse<>(true, message, data);
	}

	public static <T> ApiResponse<T> fail (String message){
		return new ApiResponse<>(false, message, null);
	}

}
