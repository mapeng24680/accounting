package com.student.logistics.utils;

import java.io.Serializable;

/**
 * @author ZhongLiang.Xian
 * @ description: 统一响应结构体
 * @ date: 2019/2/21.
 */
public class Response implements Serializable {
    private static final int SUCCESS = 1000;
    public static final int INVALID_APP = 1001;
    public static final int UNREGISTED_APP = 1002;
    public static final int APPINFO_ERROR = 1003;
    public static final int NULL_USERNAME = 1004;
    public static final int NULL_PASSWORD = 1005;
    public static final int NOT_FOUND_USER = 1006;
    public static final int USERNAME_OR_PASSWORD_ERROR = 1007;
    public static final int REPEAT_USERNAME = 1008;
    public static final int USER_NOT_MATCH = 1009;
    public static final int USER_TYPE_NOT_MATCH = 1010;
    public static final int OLD_PASSWROD_ERROR = 1011;
    public static final int NULL_ROLE = 1012;
    public static final int ROLE_NOT_MATCH = 1013;
    public static final int INVALID_TOKEN = 2001;
    public static final int UNAUTHORIZED = 2002;
    public static final int ACCESS_DENIED = 2003;
    public static final int CHECK_ERROR = 4001;
    public static final int OTHER_EXCEPTION = 9999;
    private static final long serialVersionUID = 7341577111112356482L;
    private Response.ResponseStatus meta;
    private Integer code = 1000;
    private Object data;

    public Response() {
    }

    public Integer getCode() {
        return this.code;
    }

    public Response setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Response.ResponseStatus getMeta() {
        return this.meta;
    }

    public Response setMeta(Response.ResponseStatus meta) {
        this.meta = meta;
        return this;
    }

    public Object getData() {
        return this.data;
    }

    public Response setData(Object data) {
        this.data = data;
        return this;
    }

    public Response success(String message) {
        this.setMeta(new Response.ResponseStatus(true, message));
        return this;
    }

    public Response fail(String message) {
        this.setMeta(new Response.ResponseStatus(false, message));
        return this;
    }

    public static Response build() {
        return new Response();
    }

    public class ResponseStatus {
        private Boolean success;
        private String message;

        public ResponseStatus(Boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public Boolean getSuccess() {
            return this.success;
        }

        public void setSuccess(Boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
