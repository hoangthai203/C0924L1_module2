package ss19_baithi.service;

import ss19_baithi.model.Contact;
import ss19_baithi.util.ReadAndWrite;

import java.util.*;

public class ContactService {
    private List<Contact> contacts;

    public ContactService() {
        contacts = new ArrayList<>();
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void addContact(Contact contact) {
        // Kiểm tra tính hợp lệ của contact trước khi thêm vào danh sách
        if (findContactByPhoneNumber(contact.getPhoneNumber()) != null) {
            System.out.println("Số điện thoại này đã tồn tại trong danh bạ.");
        } else {
            contacts.add(contact);
            System.out.println("Danh bạ đã được thêm.");
        }
    }

    public boolean removeContact(String phoneNumber) {
        Contact contact = findContactByPhoneNumber(phoneNumber);
        if (contact != null) {
            contacts.remove(contact);
            System.out.println("Danh bạ đã được xoá.");
            return true;
        }
        System.out.println("Không tìm thấy danh bạ với số điện thoại này.");
        return false;
    }

    public Contact findContactByPhoneNumber(String phoneNumber) {
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().equals(phoneNumber)) {
                return contact;
            }
        }
        return null;
    }

    public void updateContact(String phoneNumber, Contact updatedContact) {
        Contact contact = findContactByPhoneNumber(phoneNumber);
        if (contact != null) {
            contact.setGroup(updatedContact.getGroup());
            contact.setFullName(updatedContact.getFullName());
            contact.setGender(updatedContact.getGender());
            contact.setAddress(updatedContact.getAddress());
            contact.setBirthDate(updatedContact.getBirthDate());
            contact.setEmail(updatedContact.getEmail());
            System.out.println("Thông tin danh bạ đã được cập nhật.");
        } else {
            System.out.println("Không tìm thấy danh bạ với số điện thoại này.");
        }
    }

    public void loadContactsFromFile(String filePath) {
        this.contacts = ReadAndWrite.readFromFile(filePath);
        System.out.println("Danh bạ đã được tải từ file.");
    }

    public void saveContactsToFile(String filePath) {
        ReadAndWrite.writeToFile(contacts, filePath);
        System.out.println("Danh bạ đã được lưu vào file.");
    }
}
