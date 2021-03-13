import java.util.ArrayList;
import java.util.Scanner;

/**
 * этот класс можно использовать для любого количества вложений в виде 2[2[2[2[x]e]y]t], является более гибким к расширению.
 * textValidator проверяет введенный текст на соответствие условию задания.
 * inputForConsole считывает текст с консоли.
 * unzipString конвертирует записи 3[zx] к типу zxzxzx.
 * start метод активации
 */
public class UnzipMethodArrays {
    private String text = "";

    public void start() {
        inputForConsole();
        if (TextValidator()) {
            unzipString();
        } else {
            System.out.println("Invalid input text");
        }
    }

    private boolean TextValidator() {
        return !text.matches(".*[^0-9a-zA-Z\\[\\]]+.*");
    }

    private void inputForConsole() {
        Scanner sc = new Scanner(System.in);
        text = sc.nextLine();
        sc.close();
    }

    private void unzipString() {
        String changeSymbol = text.replaceAll("\\[", " ");
        String changeSymbol2 = changeSymbol.replaceAll("]", " ");

        Scanner scanner = new Scanner(changeSymbol2);

        while (scanner.hasNext()) {
            ArrayList<String> stringsArray = new ArrayList<>();
            ArrayList<Integer> numsArray = new ArrayList<>();
            int num = 1;
            numsArray.add(num);
            String result = "";

            try {
                num = scanner.nextInt();
                numsArray.set(0, num);
            } catch (Exception e) {
            }
            try {
                while (scanner.hasNextInt()) {
                    numsArray.add(scanner.nextInt());
                }
            } catch (Exception e) {
            }
            try {
                while (!scanner.hasNextInt()) {
                    stringsArray.add(scanner.next());
                }
            } catch (Exception e) {
            }

            int j = 0;  // index for stringArray
            for (int i = numsArray.size() - 1; i >= 0; i--) {
                String partOfString = "";
                for (int l = 0; l < numsArray.get(i); l++) {
                    partOfString += result + stringsArray.get(j);
                }
                result = partOfString;
                j++;
            }
            if (numsArray.size() < stringsArray.size()) {                  //last element stringArray without couples numArray
                result += stringsArray.get(stringsArray.size() - 1);
            }
            System.out.print(result);
        }
        scanner.close();
    }
}
