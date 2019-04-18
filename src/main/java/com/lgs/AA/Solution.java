package com.lgs.AA;

import sun.reflect.generics.tree.Tree;

import java.math.BigDecimal;
import java.util.*;

public class Solution {
//    public static void main(String[] args) {
//        while(true) {
//            Scanner in = new Scanner(System.in);
//            List<TreeNode> list = new ArrayList<>();
//            while(in.hasNext()) {
//                int a = in.nextInt();
//                if(a == -1) break;
//                list.add(new TreeNode(a));
//            }
//            Solution s = new Solution();
//            s.reverseToTree(list);
//            s.searchMiddle(list.get(0));
//            String str = "a";
//            StringBuilder sb = new StringBuilder("ab");
//            sb.append('a');
//            StringBuffer stringBuffer = new StringBuffer("a");
//            stringBuffer.append("a");
//            System.out.println(s.getHight(list.get(0)));
//        }
//    }
    //create tree
    private void reverseToTree(List<TreeNode> list) {
        int lastNode = list.size()/2-1;
        for(int i = 0; i < lastNode; i++) {
            TreeNode node = list.get(i);
            if(list.get(2*i+1).val != 0) node.left = list.get(2*i+1);
            if(list.get(2*i+2).val != 0) node.right = list.get(2*i+2);
        }
        if(list.get(lastNode*2+1).val != 0) list.get(lastNode).left = list.get(lastNode*2+1);
        if(list.size() % 2 == 1) list.get(lastNode).right = list.get(lastNode*2+2);
    }

    private void searchMiddle(TreeNode node) {
        if(node == null) return;
        searchMiddle(node.left);
        System.out.println(node.val);
        searchMiddle(node.right);
    }

    private int getHight(TreeNode node) {
        if(node == null) return 0;
        int left = getHight(node.left) + 1;
        System.out.println("left"+left);
        int right = getHight(node.right) + 1;
        System.out.println(right);
        return left > right? left : right;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    public void digui(int nums[], int l, int r) {
        if(l > r) return;
        int position = getPosition(nums, l, r);
        digui(nums, l, position-1);
        digui(nums, position+1, r);
    }

    public int getPosition(int nums[], int l, int r) {
        int k = nums[l];
        int li = l, lo = r;
        while(li < r) {
            while(li < r && nums[li] < k) li++;
            while(lo > l && nums[lo] > k) lo--;
            if(li >= lo) {
                break;
            }
            swap(nums, li, lo);
        }

        return lo;
    }


    public void swap(int nums[], int i, int j) {
        int k = nums[i];
        nums[i] = nums[j];
        nums[j] = k;
    }

    public void test(String str) {
        if(str.length() %2 == 1) {
            System.out.println("1");
            return;
        }
        int len = str.length();
        int cur = len;
        int i = 1;
        while(cur /2 != 1) {
            String front_half = str.substring(0, cur/2-1);
            String behind = str.substring(cur/2, cur-1);
            if(!front_half.equals(behind)) {
                System.out.println(i);
                break;
            }

        }
    }

    public void lruCache() {
        Map<Integer, String> cache = new LinkedHashMap<Integer, String>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return super.removeEldestEntry(eldest);
            }
        };
        cache.put(1, "2");
        cache.put(2,"2");
        cache.put(2,"2");
        cache.put(3,"2");
        cache.put(4,"2");
        cache.put(5,"2");
        cache.put(6,"2");
        cache.put(7,"2");
        System.out.println(cache.get(1));
        Queue queue = new LinkedList();
        
    }

    public void digui(int[] nums, int i, List<Integer> cur, List<List<Integer>> res) {
        if(i == nums.length) return;
        //res.add(new ArrayList<>(cur));
        digui(nums, i+1, cur, res);
        cur.add(nums[i]);
        res.add(new ArrayList<>(cur));
        digui(nums, i+1, cur, res);
        cur.remove(cur.size()-1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        double a = 20.2;
        double c = 1;
        double b = 300.03;
        BigDecimal decimal = new BigDecimal(1.5);
        System.out.println(a+b+c);
    }
}
