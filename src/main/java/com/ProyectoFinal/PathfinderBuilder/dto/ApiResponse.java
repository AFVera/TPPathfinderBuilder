package com.ProyectoFinal.PathfinderBuilder.dto;

import lombok.Data;

// clase para tomar la respuesta de una API

@Data
public class ApiResponse {

    private String message;
    private Object data;
    private String error;

    public ApiResponse(String message, Object data, String error) {
        this.message = message;
        this.data = data;
        this.error = error;
    }
}
