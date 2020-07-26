package algo;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram validAnagram=new ValidAnagram();
        String s="anagram";
        String t="nagaram";
        boolean r=validAnagram.isAnagram(s,t);
        System.out.println(r);
    }

    public boolean isAnagram(String s, String t) {
        //参数校验
        if(s==null || s.length()<=0 || t==null || t.length()<=0){
            return true;
        }
        if(s.length()!=t.length()){
            return false;
        }

        //构建map
        Map<Character,Integer> map=new HashMap<>(128);
        char[] arr=s.toCharArray();
        for(Character c:arr){
            Integer count=map.get(c);
            if(count == null){
                count=1;
            }else{
                count++;
            }
            map.put(c,count);
        }

        //依次循环t，判断是否符合
        char[] tArr=t.toCharArray();
        for(Character c:tArr){
            Integer count=map.get(c);
            if(count == null || count<=0){
                //找不到这个字符，或者次数小于0
                return false;
            }
            //更新下这个字符的引用次数
            count=count-1;
            map.put(c,count);
        }
        return true;
    }

}
