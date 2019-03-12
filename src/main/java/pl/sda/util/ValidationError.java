package pl.sda.util;

public class ValidationError {
    private String field;
    private String errorMsg;

    public ValidationError(String field, String errorMsg) {
        this.field = field;
        this.errorMsg = errorMsg;
    }

    public String getField() {
        return field;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
