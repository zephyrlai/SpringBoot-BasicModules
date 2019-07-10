package cn.zephyr.redis.enums;

/**
 * @Author: laizonghao
 * @Description:
 * @Date: 2019-07-10 11:45
 */
public enum TopicEnum {
    TOPIC_01("TOPIC_01","主题01"),
    TOPIC_02("TOPIC_02","主题02"),
    TOPIC_03("TOPIC_03","主题03"),
    ;
    private String code;
    private String desc;

    TopicEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
