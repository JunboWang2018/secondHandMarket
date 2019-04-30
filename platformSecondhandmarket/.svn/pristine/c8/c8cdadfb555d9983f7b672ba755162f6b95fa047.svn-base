package cn.showclear.www.common.constant;

public enum Message {
    VALIDATE_SUCCESS(101, "校验成功"),
    LOGIN_SUCCESS(102, "登录成功"),
    REGISTER_SUCCESS(103, "注册成功"),
    RELEASE_SUCCESS(104, "发布成功"),
    BIDDING_SUCCESS(105, "出价成功"),
    ORDER_GEN_SUCCESS(105, "交易成功"),
    TAKE_UP_PROD_SUCCESS(106, "上架成功"),
    TAKE_DOWN_PROD_SUCCESS(107, "下架成功"),
    DELETE_BARG_RECORD_SUCCESS(108, "议价记录删除成功"),
    LOGOUT_SUCCESS(109, "退出成功"),

    VALIDATE_FAILED(0, "校验失败"),
    USERNAME_NULL(1, "用户名为空"),
    PASSWORD_NULL(2, "密码为空"),
    USER_NOT_EXIST(3,"用户不存在"),
    PASSWORD_ERROR(4, "密码错误"),
    USER_IS_EXIST(5, "用户名已存在"),
    REGISTER_FAILED(6, "注册失败"),
    IMAGE_UPLOAD_FAILED(7, "图片上传失败"),
    RELEASE_FAILED(8, "发布失败"),
    NUMBER_GEN_ERROR(9, "生成编号时出错"),

    PRODUCT_NOT_EXIST(10, "物品已售出或不存在"),

    SALE_WAY_NOT_EXIST(11, "出售方式不存在"),
    PROD_TYPE_NOT_EXIST(12, "物品类型不存在"),
    BIDDING_FAILED(13, "出价失败"),
    ORDER_GEN_FAILED(14, "下单失败"),
    SAME_SALE_AND_BUY_USER(15, "相同的买家和卖家"),
    TAKE_UP_PROD_FAILED(16, "上架失败"),
    TAKE_DOWN_PROD_FAILED(17, "下架失败"),
    BIDD_PROD_REJECT_TAKE_DOWN(18, "竞价商品不能下架"),
    NO_BARG_RECORD(19, "没有议价记录"),
    DELETE_BARG_RECORD_FAILED(20, "议价记录删除失败"),
    LOGIN_FAILED(21, "登录失败");




    private int code;
    private String message;

    Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
