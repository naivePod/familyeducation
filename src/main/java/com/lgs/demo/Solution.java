package com.lgs.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        byte[] b = {12, 45,70};
        System.out.println(s.bytesToHexString(b));
    }
    public void dfs(char[] chs, int index, List res,List cur) {

        for(int i = index; i < chs.length; i++) {
            if(i != 0 && chs[i] == chs[i-1]) continue;
           cur.add(chs[i]);
           res.add(new ArrayList<>(cur));
            dfs(chs, i+1, res, cur);
            cur.remove(cur.size()-1);
        }

    }
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);

            stringBuilder.append(i + ":");

            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv + ";");
        }
        return stringBuilder.toString();
    }


}
