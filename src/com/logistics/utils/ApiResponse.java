package com.logistics.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {

    public boolean isSuccess;
    public Object data;
}
