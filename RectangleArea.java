public class RectangleArea {
	public static void main(String[] args) {
		int A = 0, B = 0, C = 0, D = 0, E = -1, F = -1, G = 1, H = 1;
		System.out.print(computeArea(A,B,C,D,E,F,G,H) + "\n");
	}
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		if (E >= C || G <= A || F >= D || H <= B) {
			return (C - A)*(D - B) + (G - E)*(H - F);
		}
		int l = 0, w = 0;
		if (A <= E && E <= C && C <= G) {
			l = C - E;
		} else if (E <= A && A <= G && G <= C) {
			l = G - A;
		} else if (A <= E && G <= C) {
			l = G - E;
		} else {
			l = C - A;
		}

		if (F <= B && B <= H && H <= D) {
			w = H - B;
		} else if (B <= F && F <= D && D <= H) {
			w = D - F;
		} else if (B <= F && H <= D) {
			w = H - F;
		} else {
			w = D - B;
		}
		return (C - A)*(D - B) + (G - E)*(H - F) - l * w;
	}
}