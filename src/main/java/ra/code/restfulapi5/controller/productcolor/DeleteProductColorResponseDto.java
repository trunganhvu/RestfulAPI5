package ra.code.restfulapi5.controller.productcolor;

/**
 * @author trunganhvu
 * 2021/08/16
 */
public class DeleteProductColorResponseDto {
    private boolean isSuccess;

    public DeleteProductColorResponseDto() {
    }

    public DeleteProductColorResponseDto(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
