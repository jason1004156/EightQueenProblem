import java.util.ArrayList;
import java.util.List;

public class EightQueenProblem {
	public static void main(String[] args) {
		System.out.println(new EightQueenProblem().solveNQueens(8));
	}

	public List<List<String>> solveNQueens(int max) {
		int[] array = new int[max];

		List<List<String>> res = new ArrayList<>();
		check(0, max, array, res);
		return res;
	}

	private void check(int n, int max, int[] array, List<List<String>> res) {
		if (n == max) { 
			List<String> list = print(array);
			res.add(list);
			return;
		}

		
		for (int i = 0; i < max; i++) {
			array[n] = i;
			if (judge(n, array)) {			
				check(n + 1, max, array, res);
			}
		}
	}

	private boolean judge(int n, int[] array) {
		for (int i = 0; i < n; i++) {
			if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
				return false;
			}
		}
		return true;
	}

	private List<String> print(int[] array) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < array.length; i++) {
			String str = "\n";
			for (int j = 0; j < array.length; j++) {
				if (j == array[i]) {
					str = str + "Q ";
				} else {
					str = str + ". ";
				}
			}
			list.add(str);
		}
		return list;
	}
}