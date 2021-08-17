package ra.code.restfulapi5.controller.productsize;

/**
 * @author trunganhvu
 * 2021/08/16
 */
public class DeleteProductSizeResponseDto {
    private boolean isSuccess;

    public DeleteProductSizeResponseDto() {
    }

    public DeleteProductSizeResponseDto(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
