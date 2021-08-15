package ra.code.restfulapi5.controller.config;

/**
 * @author trunganhvu
 * 2021/08/14
 */
public class CachingResponseDto {
    private boolean isSuccess;

    public CachingResponseDto() {
    }

    public CachingResponseDto(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
