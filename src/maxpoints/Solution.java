package maxpoints;

public class Solution {
	//没有考虑可能存在两个点坐标相等。
	//
	static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
		
		public String toString() {
			return "x: " + this.x + "y: " + this.y;
		}
	}

	public static void main(String[] args) {
//		Point[] points = {new Point(0,9),new Point(138,429),new Point(115,359),new Point(115,359),new Point(-30,-102),new Point(230,709),new Point(-150,-686),new Point(-135,-613),new Point(-60,-248),new Point(-161,-481),new Point(207,639),new Point(23,79),new Point(-230,-691),new Point(-115,-341),new Point(92,289),new Point(60,336),new Point(-105,-467),new Point(135,701),new Point(-90,-394),new Point(-184,-551),new Point(150,774)};
//		Point[] points = {new Point(40,-23),new Point(9,138),new Point(429,115),new Point(50,-17),new Point(-3,80),new Point(-10,33),new Point(5,-21),new Point(-3,80),new Point(-6,-65),new Point(-18,26),new Point(-6,-65),new Point(5,72),new Point(0,77),new Point(-9,86),new Point(10,-2),new Point(-8,85),new Point(21,130),new Point(18,-6),new Point(-18,26),new Point(-1,-15),new Point(10,-2),new Point(8,69),new Point(-4,63),new Point(0,3),new Point(-4,40),new Point(-7,84),new Point(-8,7),new Point(30,154),new Point(16,-5),new Point(6,90),new Point(18,-6),new Point(5,77),new Point(-4,77),new Point(7,-13),new Point(-1,-45),new Point(16,-5),new Point(-9,86),new Point(-16,11),new Point(-7,84),new Point(1,76),new Point(3,77),new Point(10,67),new Point(1,-37),new Point(-10,-81),new Point(4,-11),new Point(-20,13),new Point(-10,77),new Point(6,-17),new Point(-27,2),new Point(-10,-81),new Point(10,-1),new Point(-9,1),new Point(-8,43),new Point(2,2),new Point(2,-21),new Point(3,82),new Point(8,-1),new Point(10,-1),new Point(-9,1),new Point(-12,42),new Point(16,-5),new Point(-5,-61),new Point(20,-7),new Point(9,-35),new Point(10,6),new Point(12,106),new Point(5,-21),new Point(-5,82),new Point(6,71),new Point(-15,34),new Point(-10,87),new Point(-14,-12),new Point(12,106),new Point(-5,82),new Point(-46,-45),new Point(-4,63),new Point(16,-5),new Point(4,1),new Point(-3,-53),new Point(0,-17),new Point(9,98),new Point(-18,26),new Point(-9,86),new Point(2,77),new Point(-2,-49),new Point(1,76),new Point(-3,-38),new Point(-8,7),new Point(-17,-37),new Point(5,72),new Point(10,-37),new Point(-4,-57),new Point(-3,-53),new Point(3,74),new Point(-3,-11),new Point(-8,7),new Point(1,88),new Point(-12,42),new Point(1,-37),new Point(2,77),new Point(-6,77),new Point(5,72),new Point(-4,-57),new Point(-18,-33),new Point(-12,42),new Point(-9,86),new Point(2,77),new Point(-8,77),new Point(-3,77),new Point(9,-42),new Point(16,41),new Point(-29,-37),new Point(0,-41),new Point(-21,18),new Point(-27,-34),new Point(0,77),new Point(3,74),new Point(-7,-69),new Point(-21,18),new Point(27,146),new Point(-20,13),new Point(21,130),new Point(-6,-65),new Point(14,-4),new Point(0,3),new Point(9,-5),new Point(6,-29),new Point(-2,73),new Point(-1,-15),new Point(1,76),new Point(-4,77),new Point(6,-29)};
		Point[] points = {new Point(0,0),new Point(0,0)};
		System.out.println(new Solution().maxPoints(points));
	}

	public int maxPoints(Point[] points) {
		int length = points.length;
		int maxPointsNum = 0;
		for (int i = 0; i < length; i++) {
			Point a = points[i];
			int pointsNum = 1;
			int sameNum = 0;
			for (int j = i+1; j < length; j++) {
				Point b = points[j];
				pointsNum = 2;
				
				while (b.x == a.x && b.y == a.y) {
					if (j >= length-1) {
						break;
					}
					j++;
					b = points[j];
					sameNum = sameNum + 1;
				}
				pointsNum = sameNum + pointsNum;
				for (int k = j+1; k < length; k++) {
					Point c = points[k];
					if ((a.x-b.x)*(b.y-c.y) == (a.y-b.y)*(b.x-c.x)) {
						pointsNum++;
					}
				}
				if (pointsNum > maxPointsNum) {
					maxPointsNum = pointsNum;
				}
			}
			if (pointsNum > maxPointsNum) {
				maxPointsNum = pointsNum;
			}
		}
		
		return maxPointsNum;
	}
}
