package ss19_baithi.util;

import ss19_baithi.model.Contact;

import java.io.*;
import java.util.*;

public class ReadAndWrite {

    public static boolean isValidPhoneNumber(String phoneNumber) {
        String regex = "^\\d{10}$";  // Định dạng: 10 chữ số
        return phoneNumber.matches(regex);
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(regex);
    }

    // Ghi danh bạ vào file
    public static void writeToFile(List<Contact> contacts, String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Contact contact : contacts) {
                if (!isValidPhoneNumber(contact.getPhoneNumber())) {
                    System.out.println("Số điện thoại không hợp lệ: " + contact.getPhoneNumber());
                    continue;
                }
                if (!isValidEmail(contact.getEmail())) {
                    System.out.println("Email không hợp lệ: " + contact.getEmail());
                    continue;
                }
                writer.write(contact.getPhoneNumber() + "," + contact.getGroup() + "," + contact.getFullName() + "," +
                        contact.getGender() + "," + contact.getAddress() + "," + contact.getBirthDate() + "," + contact.getEmail());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi vào file: " + e.getMessage());
        }
    }

    public static List<Contact> readFromFile(String filePath) {
        List<Contact> contacts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length < 7 || !isValidPhoneNumber(data[0]) || !isValidEmail(data[6])) {
                    System.out.println("Dữ liệu không hợp lệ: " + line);
                    continue;
                }
                Contact contact = new Contact(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
                contacts.add(contact);
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc từ file: " + e.getMessage());
        }
        return contacts;
    }
}
