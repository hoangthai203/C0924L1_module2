package ss19_baithi.view;

import ss19_baithi.controller.ContactController;
import ss19_baithi.service.ContactService;

public class Main {
    public static void main(String[] args) {
        ContactService contactService = new ContactService();
        ContactController contactController = new ContactController(contactService);
        contactController.start();
    }
}

