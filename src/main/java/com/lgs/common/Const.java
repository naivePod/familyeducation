package com.lgs.common;






import com.google.common.collect.Sets;

import java.util.Set;

public class Const {
    public static final String CURRENT_USER = "current_account";
    public static final String USER_NAME = "username";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";
    public static final String QUESTION = "question";
    public static final String ANSWER = "answer";
    public static final String PARENT_ID = "parentId";



    public interface OrderBy {
        Set PRICE_DESC_ASC = Sets.newHashSet("price_asc","price_desc");
    }
    public interface Title {
        String TITLE_ORDER = "预约通知";
        String TITLE_AUDIT = "审核通知";
    }
    public interface Role{
        int ROLE_CUSTOMER = 0;
        int ROLE_ADMIN = 1;
        int ROLE_TEACHER = 2;
        int ROLE_STUDENT = 3;
    }
    public interface StudentState{
        byte DEFAULT = 0;
    }

    public interface AuditState{
        byte WAIT = 0;//待审核
        byte SUCCESS = 1;//已通过
        byte FAIL = 2;//未通过
    }

    public enum TeachInformationStatus {
        ON_ORDER((byte)0, "待预约"),
        SUCCESS((byte)1, "已预约"),
        DELETED((byte)2, "已删除");

        private final byte status;
        private final String desc;

        TeachInformationStatus(byte status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        public byte getStatus() {
            return status;
        }

        public String getDesc() {
            return desc;
        }
    }
    public enum TeacherStatus {
        DELETED((byte)0, "已删除"),
        ORDINARY((byte)1, "普通教师"),
        EXCELLENT((byte)2,"优秀教师");


        private final byte status;
        private final String desc;

        TeacherStatus(byte status, String desc) {
            this.status = status;
            this.desc = desc;
        }

        public byte getStatus() {
            return status;
        }

        public String getDesc() {
            return desc;
        }
    }

    public enum OrderStatusEnum {
        CANCELED((byte)0, "预约取消"),
        DEFEAT((byte)1, "未成功"),
        WAIT_CONFIRM((byte)10, "待确认"),
        ORDER_SUCCESS((byte)20, "预约成功"),
        ORDER_CLOSED((byte)30, "订单完成");



        private byte code;
        private String value;

        OrderStatusEnum(byte code, String value) {
            this.code = code;
            this.value = value;
        }

        public byte getCode() {
            return code;
        }

        public void setCode(byte code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }




}
