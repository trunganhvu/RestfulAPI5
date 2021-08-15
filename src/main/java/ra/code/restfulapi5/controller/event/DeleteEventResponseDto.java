package ra.code.restfulapi5.controller.event;

/**
 * @author trunganhvu
 * 2021/08/15
 */
public class DeleteEventResponseDto {
    private boolean isSuccess;

    public DeleteEventResponseDto(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public DeleteEventResponseDto() {
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
