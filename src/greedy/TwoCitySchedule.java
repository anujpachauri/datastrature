package greedy;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Anuj Pachauri
 *
 *         11:30:07 pm
 */
public class TwoCitySchedule {

	public static int twoCitySchedule(int[][] costs) {

		ArrayList<Integer> changeA = new ArrayList<>();
		ArrayList<Integer> changeB = new ArrayList<>();
		int ans = 0;

		for (int[] c : costs) {
			if (c[0] < c[1]) {
				ans += c[0];
				changeB.add(c[1] - c[0]);
			} else {
				ans += c[1];
				changeA.add(c[0] - c[1]);
			}
		}

		if (changeA.size() > changeB.size()) {
			Collections.sort(changeA);
			for (int i = 0; i < changeA.size() - costs.length / 2; i++) {
				ans += changeA.get(i);
			}
		} else if (changeA.size() < changeB.size()) {
			Collections.sort(changeB);
			for (int i = 0; i < changeB.size() - costs.length / 2; i++) {
				ans += changeB.get(i);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int costs[][] = { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } };

		System.out.println(twoCitySchedule(costs));
	}
}
