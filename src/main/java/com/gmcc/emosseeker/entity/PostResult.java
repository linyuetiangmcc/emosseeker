package com.gmcc.emosseeker.entity;
@lombok.Data
public class PostResult<T> {
    private String code;
    private T data;
    private String msg;
    private String tip;
}
