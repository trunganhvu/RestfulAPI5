package ra.code.restfulapi5.controller.header;

/**
 * @author trunganhvu
 * 2021/08/15
 */
public class DeleteHeaderResponseDto {
    private boolean isSuccess;

    public DeleteHeaderResponseDto() {
    }

    public DeleteHeaderResponseDto(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
