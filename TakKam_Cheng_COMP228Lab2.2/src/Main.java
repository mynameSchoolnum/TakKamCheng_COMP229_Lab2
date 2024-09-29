import javax.swing.JOptionPane;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int userNumber = Integer.parseInt(JOptionPane.showInputDialog("Please Choose a number between 3 and 27, Good Luck!!:"));

        if (userNumber < 3 || userNumber > 27) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please choose a number between 3 and 27!");
            return;
        }

        boolean userWon = false;
        for (int i = 1; i <= 5; i++) {
            Lotto lotto = new Lotto();
            int[] lottoNumbers = lotto.getLottoNumbers();
            int sum = calculateSum(lottoNumbers);

            JOptionPane.showMessageDialog(null, "Lotto roll #" + i + "\nLotto numbers: " +
                    lottoNumbers[0] + ", " + lottoNumbers[1] + ", " + lottoNumbers[2] +
                    "\nSum: " + sum);

            if (sum == userNumber) {
                JOptionPane.showMessageDialog(null, "Congratulations!!! You won! The sum matches your number!");
                userWon = true;
                break;
            }
        }

        if (!userWon) {
            JOptionPane.showMessageDialog(null, "Sorry, the computer wins! You didn't match the sum in 5 tries, good luck next time");
        }
    }

    private static int calculateSum(int[] lottoNumbers) {
        int sum = 0;
        for (int num : lottoNumbers) {
            sum += num;
        }
        return sum;
    }
}

class Lotto {
    private int[] lottoNumbers;
    private Random random;

    public Lotto() {
        random = new Random();
        lottoNumbers = new int[3];
        populateLottoNumbers();
    }

    private void populateLottoNumbers() {
        for (int i = 0; i < lottoNumbers.length; i++) {
            lottoNumbers[i] = random.nextInt(9) + 1;
        }
    }

    public int[] getLottoNumbers() {
        return lottoNumbers;
    }
}