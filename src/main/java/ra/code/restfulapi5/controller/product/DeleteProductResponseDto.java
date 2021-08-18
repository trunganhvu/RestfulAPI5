package ra.code.restfulapi5.controller.product;

/**
 * @author trunganhvu
 * 2021/08/18
 */
public class DeleteProductResponseDto {
    private boolean isSuccess;

    public DeleteProductResponseDto() {
    }

    public DeleteProductResponseDto(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
