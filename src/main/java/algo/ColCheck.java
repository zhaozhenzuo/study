package algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ColCheck {

    private static Map<Character,Character> colMap=new HashMap<>();

    static {
        colMap.put('(',')');
        colMap.put('[',']');
        colMap.put('{','}');
    }

    public static void main(String[] args) {
        ColCheck colCheck=new ColCheck();
        boolean r=colCheck.isValid("()");
        System.out.println(r);
    }

    public boolean isValid(String s){
        if (s==null || s.length()<=0) {
            return true;
        }

        Stack<Character> stack=new Stack<Character>();
        char[] chars=s.toCharArray();
        for(Character c:chars){
            Character matchC=!stack.isEmpty()?colMap.get(stack.peek()):null;
            if(matchC!=null && c.equals(matchC)){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
