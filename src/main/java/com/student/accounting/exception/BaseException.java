package com.student.accounting.exception;

/**
 * 异常类
 * @author hzx
 */
public class BaseException extends RuntimeException {
    
    public BaseException(){
        super();
    }
    
    public BaseException(String msg) { super(msg); }
    
    public BaseException(Throwable cause){ super(cause); }
    
    public BaseException(String message, Throwable cause){
        super(message, cause);
    }
    
}
