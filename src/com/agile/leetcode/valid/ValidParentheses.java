package com.agile.leetcode.valid;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 借助栈来判断括号是否闭合问题
 * 题目描述
 * 评论 (1.5k)
 * 题解(643)
 * 提交记录
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 * 注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String string="{()}";
        boolean valid = isValid(string);
        System.out.println(valid);
    }
    public static boolean isValid(String str){
        Map<Character,Character> map=new HashMap<>();
        Stack<Character> stack=new Stack<>();
        //初始化哪些是闭括号以及对应的开括号
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');
        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            //拿到闭括号，去栈顶寻找元素，判断是否为一对键值对
            if (map.containsKey(c)){
                char topElement=stack.isEmpty()?'#':stack.pop();
                if (topElement!=map.get(c)){
                    return false;
                }
            }else {
                //开括号，放入栈中
                stack.push(c);
            }

        }
        //如果全部匹配，栈中应该没有元素
        return stack.isEmpty();
    }
}
