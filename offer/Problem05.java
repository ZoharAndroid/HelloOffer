package offer;

public class Problem05 {

    /**
     * 面试题05：替换空格
     * @param str：输入的字符串
     * @return
     *  返回替换后的字符串
     */
    private String replaceBlack(String str){
        if (str == null){
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args){
        Problem05 p = new Problem05();
        System.out.println(p.replaceBlack("hello world"));// 空格在中间 -> hello%20world
        System.out.println(p.replaceBlack(" helloworld"));// 空格在开头 -> %20helloworld
        System.out.println(p.replaceBlack("helloworld "));// 空格结束 -> helloworld%20
        System.out.println(p.replaceBlack("hello  world"));// 连续两个空格 -> hello%20%20world
        System.out.println(p.replaceBlack(""));// 传入null -> null

    }
}
