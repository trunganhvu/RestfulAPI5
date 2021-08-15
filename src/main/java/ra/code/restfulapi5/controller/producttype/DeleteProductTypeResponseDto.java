package ra.code.restfulapi5.controller.producttype;

/**
 * @author trunganhvu
 * 2021/08/15
 */
public class DeleteProductTypeResponseDto {
    private boolean isSuccess;

    public DeleteProductTypeResponseDto(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
