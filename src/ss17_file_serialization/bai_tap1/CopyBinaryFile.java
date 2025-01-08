package ss17_file_serialization.bai_tap1;

import java.io.*;
import java.util.Scanner;

public class CopyBinaryFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // src/ss17_file_serialization/data/sourcefile.dat
        System.out.print("Nhập đường dẫn tập tin nguồn: ");
        String sourceFilePath = scanner.nextLine();
        // src/ss17_file_serialization/data/targetfile.dat
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

        try (InputStream inputStream = new FileInputStream(sourceFile);
             OutputStream outputStream = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[1024];
            int bytesRead;
            int totalBytes = 0;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }

            System.out.println("Sao chép hoàn thành. Tổng số byte: " + totalBytes);

        } catch (IOException e) {
            System.out.println("Đã xảy ra lỗi trong quá trình sao chép: " + e.getMessage());
        }
    }
}
