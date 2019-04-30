package com.lgs.util;

import com.lgs.common.Const;

public class RoleUtil {
    //将roleid转化成name
    public static String roleidToString(int id) {
        if (id == Const.Role.ROLE_CUSTOMER) {
            return "user";
        } else if (id == Const.Role.ROLE_ADMIN) {
            return "manage";
        } else if (id == Const.Role.ROLE_TEACHER) {
            return "teacher";
        }
        return "";
    }

}
