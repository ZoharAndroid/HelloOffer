package algorithm.二分查找;

/**
 * 744. 寻找比目标字母大的最小字母
 *
 * 给定一个只包含小写字母的有序数组letters 和一个目标字母 target，寻找有序数组里面比目标字母大的最小字母。
 * 数组里字母的顺序是循环的。举个例子，如果目标字母target = 'z' 并且有序数组为 letters = ['a', 'b']，则答案返回 'a'。
 *
 * https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
 */
public class _744 {

    static class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            // 解题思路：可以将target分不在letters范围内 和在范围内。
            // target不在范围内，那么直接比较收尾两个字符的大小，如果字符小于首字符，那么直接输出首字符，反之输出尾字符
            // target在范围内，这有分为两种情况，如果范围内有元素与target值相同，这里可以使用二分查找来查找，这时候处理的是当前的位置时候再最后的位置，如果
            // 是在最后的位置，那么就输出首位；如果范围内的元素没有与target相同的，直接输出后一个
            // 需要注意：范围可以包含多个相同的字符

            if (target < letters[0] || target > letters[letters.length - 1]){
                // target在范围之外
                return letters[0];
            }else {
                // target在范围之内
                int start = 0;
                int end = letters.length - 1;
                while ( start <= end){
                    int mid = start + (end - start)/2;
                    if (letters[mid] == target){
                        // 如果存在多个相同的字符，那么就需要向后移动找到第一个不相同的字符
                        int loc = mid;
                        while(loc < letters.length  && letters[loc] == target){
                            loc++;
                        }
                        if (loc == letters.length ){
                            return letters[0];
                        }else{
                            return letters[loc];
                        }
                    }else if (letters[mid] < target){
                        start = mid + 1;
                    }else{
                        end = mid - 1;
                    }
                }

                // 如果没有找到
                return letters[start];

            }
        }
    }

    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.nextGreatestLetter(new char[]{'c','f','j','v','v','y'},'v'));
        System.out.println(s.nextGreatestLetter(new char[]{'e','e','n','n','n'},'e'));
    }
}
