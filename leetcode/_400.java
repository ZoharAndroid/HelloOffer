//400. 第N个数字
public class _400 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.findNthDigit(11));
	}

	/**
	 * 首先来分析自然数序列和其位数的关系，前九个数都是1位的，然后10到99总共90个数字都是两位的，100到999共900个数都是三位的，那么这就很有规律了，我们可以定义个变量cnt，初始化为9，然后每次循环扩大10倍，再用一个变量len记录当前循环区间数字的位数，另外再需要一个变量start用来记录当前循环区间的第一个数字，我们n每次循环都减去len*cnt
	 * (区间总位数)，当n落到某一个确定的区间里了，那么(n-1)/len就是目标数字在该区间里的坐标，加上start就是得到了目标数字，然后我们将目标数字start转为字符串，(n-1)%len就是所要求的目标位，
	 * @author zohar
	 *
	 */
	static class Solution {
		public int findNthDigit(int n) {
			int start = 1;// 起始值
			long count = 9;// 步长
			int len = 1;// 当前循环区间数字的位数

			while (n > len * count) {
				n -= len * count;
				start *= 10;
				count *= 10;
				len++;
			}

			start += (n - 1) / len;
			String s = Integer.toString(start);
			return Character.getNumericValue(s.charAt((n - 1) % len));
		}
	}
}
