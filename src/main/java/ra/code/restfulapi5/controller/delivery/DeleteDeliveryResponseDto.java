package ra.code.restfulapi5.controller.delivery;

/**
 * @author trunganhvu
 * 2021/08/15
 */
public class DeleteDeliveryResponseDto {
    private boolean isSuccess;

    public DeleteDeliveryResponseDto() {
    }

    public DeleteDeliveryResponseDto(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
