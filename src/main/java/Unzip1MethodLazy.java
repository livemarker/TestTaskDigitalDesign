import java.util.Scanner;

/**
 * lazy класс предназначен для одиночных команд типа 2[x] и максимум двойных типа 2[2[x]y] согласно заданию.
 * textValidator проверяет введенный текст на соответствие условию задания.
 * inputForConsole считывает текст с консоли.
 * unzipString конвертирует записи 3[zx] к типу zxzxzx.
 * start метод активации
 */
public class Unzip1MethodLazy {
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
        Scanner scConsole = new Scanner(System.in);
        text = scConsole.nextLine();
        scConsole.close();
    }

    private void unzipString() {
        String changeSymbol = text.replaceAll("\\[", " ");
        String changeSymbol2 = changeSymbol.replaceAll("]", " ");

        Scanner scanner = new Scanner(changeSymbol2);

        while (scanner.hasNext()) {
            String resultSubString = "";
            String partOfString = "";
            String partOfString2 = "";
            int num = 1;
            int num2 = 0;
            try {
                num = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    num2 = scanner.nextInt();
                }
            } catch (Exception e) {
            }

            if (!scanner.hasNextInt()) {
                if (num2 == 0) {
                    try {
                        partOfString += scanner.next();
                    } catch (Exception e) {
                    }
                    for (int i = 0; i < num; i++) {
                        resultSubString += partOfString;
                    }
                }
                if (num2 > 0) {
                    try {
                        partOfString += scanner.next();
                        partOfString2 += scanner.next();
                    } catch (Exception e) {
                    }

                    for (int i = 0; i < num; i++) {
                        for (int j = 0; j < num2; j++) {
                            resultSubString += partOfString;
                        }
                        resultSubString += partOfString2;
                    }
                }
                System.out.print(resultSubString);
            }
        }
        scanner.close();
    }
}
