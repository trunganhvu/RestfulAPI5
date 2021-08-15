package ra.code.restfulapi5.controller.category;

/**
 * @author trunganhvu
 * 2021/08/13
 */
public class DeleteCategoryResponseDto {
    private boolean isSuccess;

    public DeleteCategoryResponseDto() {
    }

    public DeleteCategoryResponseDto(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
