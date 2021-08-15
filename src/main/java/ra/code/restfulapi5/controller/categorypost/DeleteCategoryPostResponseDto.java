package ra.code.restfulapi5.controller.categorypost;

/**
 * @author trunganhvu
 * 2021/08/14
 */
public class DeleteCategoryPostResponseDto {
    private boolean isSuccess;

    public DeleteCategoryPostResponseDto() {
    }

    public DeleteCategoryPostResponseDto(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
