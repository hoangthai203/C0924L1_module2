package ss16_text_file.bai_tap.bai_tap1;

import java.io.*;
import java.util.Scanner;

public class CopyFileText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //src/ss16_text_file/data/sourcefile.csv
        System.out.print("Nhập đường dẫn tập tin nguồn: ");
        String sourceFilePath = scanner.nextLine();
        //src/ss16_text_file/data/targetfile.csv
        System.out.print("Nhập đường dẫn tập tin đích: ");
        String targetFilePath = scanner.nextLine();

        File sourceFile = new File(sourceFilePath);
        if (!sourceFile.exists()) {
            System.out.println("Tập tin nguồn không tồn tại.");
            return;
        }

        File targetFile = new File(targetFilePath);
        if (targetFile.exists()) {
            System.out.print("Tập tin đích đã tồn tại. Bạn có muốn ghi đè không? (y/n): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("y")) {
                System.out.println("Hủy bỏ quá trình sao chép.");
                return;
            }
        }

        try (FileReader fileReader = new FileReader(sourceFile);
             FileWriter fileWriter = new FileWriter(targetFile)) {

            int characterCount = 0;
            int c;

            while ((c = fileReader.read()) != -1) {
                fileWriter.write(c);
                characterCount++;
            }

            System.out.println("Sao chép hoàn thành. Tổng số ký tự: " + characterCount);

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi trong quá trình sao chép: " + e.getMessage());
        }
    }
}

