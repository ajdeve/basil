package burger.view;

import javax.swing.JOptionPane;

import burger.controller.FeelingsController;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class StartView {

	public static void main(String[] args) {

		System.out.println("\n-- 오늘의 당신의 기분에 추천할 버거세트 --");
		FeelingsController.reqProcess(7);
		FeelingsController.reqProcess(1);


		int i = 0; // iterator to be used later for the askQuestion loop
		String response = ""; // holds the answer the user supplied temporarily

		String[][] question = new String[10][4]; // Array to store questions

		question[0][0] = "How are you feeling today? Please pick a, b, or c!";
		question[0][1] = "a. happy:)";
		question[0][2] = "b. angry!";
		question[0][3] = "c. sad:(";
		
		question[1][0] = "구매하시겠습니까";
		question[1][1] = "네";
		question[1][2] = "아니오";
		question[1][3] = "할인을 주면 생각해볼께요.";
		
		response = askQuestion(question[i]);
		if (response.equals("a")) {
			FeelingsController.reqProcess(2);
			JOptionPane.showMessageDialog(null, "good");
			
		} else if (response.equals("b")) {
			FeelingsController.reqProcess(3);
			JOptionPane.showMessageDialog(null, "oh...");
			// return :
		} else if (response.equals("c")) {
			FeelingsController.reqProcess(4);
			JOptionPane.showMessageDialog(null, "I'm sorry");
			// return:
		} else {
			JOptionPane.showMessageDialog(null, "See you soon");
		}
	}

	private static String askQuestion(String[] q) {
		String fmtQuestion = ""; // String to hold the formatted question
		String answer = "";

		for (int i = 0; i < q.length; i++)
			fmtQuestion += q[i] + "\n";
		// 안될 시 삭제!
		do {
			answer = JOptionPane.showInputDialog(null, fmtQuestion);
			if (answer == null) {
				int quit = JOptionPane.showConfirmDialog(null, "Would you like to quit?", "Quit",
						JOptionPane.YES_NO_OPTION);
				if (quit == 0)
					answer = "See you next time!";
				return answer;
				// else
				// continue;
			}
		} while (answer == null || !(isValid(answer)));

		return answer;
	}

	private static boolean isValid(String a) {
		a = a.toLowerCase();
		if (a.equals("a") || a.equals("b") || a.equals("c")) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Please pick A, B, or C");
			return false;
		}
	}

}
