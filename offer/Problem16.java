package offer;

/**
 * 面试题16
 *
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Problem16 {


    public double Power(double base, int exponent) {
        if (exponent == 0){
            return 1;
        }

        if (exponent == 1){
            return base;
        }

        boolean isNegtive = false;
        if (exponent < 0){
            exponent = -exponent;
            isNegtive = true;
        }

        double result = Power(base *base, exponent /2 );
        if (exponent % 2 != 0){
            result *= base;
        }

        return isNegtive?1/result : result;
    }

    public static void main(String[] args){

    }
}
