package cn.com.taiji.exception;

/**
 *  自定义异常类，针对预期的异常，在程序中抛出响应的异常
 * */
public class CustomException extends Exception{
    //异常信息
    public String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
