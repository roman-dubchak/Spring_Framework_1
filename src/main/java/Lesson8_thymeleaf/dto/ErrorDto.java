package Lesson8_thymeleaf.dto;

public class ErrorDto {
    private String massage;

    public ErrorDto(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }
}
