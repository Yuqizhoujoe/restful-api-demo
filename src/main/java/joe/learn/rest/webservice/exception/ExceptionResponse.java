package joe.learn.rest.webservice.exception;

import java.util.Date;

// this class is the response format when exception occurs
public class ExceptionResponse {

    //time stamp
    private Date timestamp;
    // message
    private String message;
    // detail
    private String detail;

    public ExceptionResponse(Date timestamp, String message, String detail) {
        this.timestamp = timestamp;
        this.message = message;
        this.detail = detail;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetail() {
        return detail;
    }
}
