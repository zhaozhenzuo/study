package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Stack20 {

    public boolean isValid(String s) {
        if(s == null || s.length()<=0){
            return true;
        }

        Stack<Character> stack=new Stack<>();
        char[] cArr=s.toCharArray();
        Map<Character,Character> colMap=new HashMap<>(4);
        colMap.put(')','(');
        colMap.put('}','{');
        colMap.put(']','[');
        for(char c:cArr){
            if(c == '(' || c == '{' || c=='['){
                stack.add(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char topC=stack.pop();
                if(colMap.get(c) != topC){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
