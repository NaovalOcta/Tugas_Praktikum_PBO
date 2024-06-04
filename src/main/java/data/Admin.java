package data;

import exception.custom.IllegalAdminAccess;
import com.main.LibrarySystem;
import books.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Admin extends User {
    private final String adminUsername = "Admin";
    private final String adminPassword = "Admin";
    private static ArrayList<Student> studentList = new ArrayList<>();
    private Scanner objScanner = new Scanner(System.in);

    public static ArrayList<Student> getStudentList() {
//        studentList.add(new Student("Naoval", "Teknik", "202310370311172", "Informatika"));
        return studentList;
    }

//    @Override
//    public void menu() {
//        try {
//            System.out.print("===== Menu Admin =====\n1. Tambah Mahasiswa\n2. Tampilkan Mahasiswa\n3. Input Buku\n4. Tampilkan Daftar Buku\n5. Logout\nPilih antara (1-5): ");
//            System.out.println("====== Admin Menu ======");
//            System.out.println("1. Add Student");
//            System.out.println("2. Add Book");
//            System.out.println("3. Display Registered Student");
//            System.out.println("4. Display Available Books");
//            System.out.println("5. Logout");
//            System.out.print("Choose menu (1-5): ");
//            int choice = addButtonResponse;
//
//            switch (choice) {
//                case 1:
//                    addStudent(objStudent.getName(), objStudent.getNim(), objStudent.getFaculty(), objStudent.getprogramStudi());
//                    break;
//                case 2:
//                    inputBook();
//                    break;
//                case 3:
//                    LibrarySystem.addTempStudent();
//                    displayStudents();
//                    break;
//                case 4:
//                    LibrarySystem.addTempBooks();
//                    displayBooks();
//                    break;
//                case 5:
//                    System.out.println("Logout berhasil.\n");
//                    break;
//                default:
//                    throw new IllegalInvalidChoice("Invalid parameter choice!");
//            }
//        } catch (IllegalInvalidChoice e) {
//            System.err.println(e);
//        }
//    }
    public boolean isAdmin(String username, String password) throws IllegalAdminAccess {
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            return true;
        } else {
            throw new IllegalAdminAccess("Invalid parameter!");
        }
    }
    public int addStudent(String name, String nim, String faculty, String programStudi) {
        if (nim.length() != 15) {
            return 0;
        }

        LibrarySystem librarySystem = new LibrarySystem();
        for(int i = 0; i < librarySystem.getNimStudentList().size(); i++ ) {
            if(nim.equals(librarySystem.getNimStudentList().get(i))) {
                return 2;
            }
        }

        librarySystem.setNimStudentList(nim);

        studentList.add(new Student(name, faculty, nim, programStudi));

        return 1;
    }

    public void displayStudents() {
        for (Student student : studentList) {
//            System.out.println("===================================");
            System.out.println("Nama            : " + student.getName());
            System.out.println("NIM             : " + student.getNim());
            System.out.println("Fakultas        : " + student.getFaculty());
            System.out.println("Program Studi   : " + student.getProgramStudi());
            System.out.println("===================================");
        }

        System.out.println();
//        menu();
    }

    public int inputBook(int bookType, String title, String author, int stock) throws RuntimeException {
//        int bookType;
//        do {
//            System.out.println("\nPilih jenis buku:");
//            System.out.println("1. History Book");
//            System.out.println("2. Story Book");
//            System.out.println("3. Text Book");
//            System.out.print("Pilih jenis buku (1-3): ");
//            bookType = objScanner.nextInt();
//            objScanner.nextLine();
//        } while(bookType > 3 || bookType < 1);

//        System.out.print("Masukkan title buku: ");
//        String title = objScanner.nextLine();
//        System.out.print("Masukkan author buku: ");
//        String author = objScanner.nextLine();
//        System.out.print("Masukkan stock buku: ");
//        int stock = objScanner.nextInt();
//        objScanner.nextLine();

        String bookId;
        String category = "";
        switch (bookType) {
            case 1:
                HistoryBook historyBook = new HistoryBook("", "", "", "", 0);
                category = historyBook.getCategory();
                break;
            case 2:
                StoryBook storyBook = new StoryBook("", "", "", "", 0);
                category = storyBook.getCategory();
                break;
            case 3:
                TextBook textBook = new TextBook("", "", "", "", 0);
                category = textBook.getCategory();
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return 0;
        }
        bookId = generateId();
        User.addBooks(bookId, title, author, category, stock);

        // KODE TESTING | Apakah inputan telah masuk ke dalam array
        System.out.println(bookId);
        System.out.println(author);
        System.out.println(category);
        System.out.println(stock);

        return 1;

//            System.out.println("Buku berhasil ditambahkan.\n");
//        menu();
    }

//    @Override
//    public void displayBooks() {
//        super.displayBooks();
////        menu();
//    }

    public String generateId() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder id = new StringBuilder();

        for (int i = 0; i < 12; i++) {
            int index = random.nextInt(characters.length());
            id.append(characters.charAt(index));
        }

        // Menambahkan strip setiap 4 karakter
        for (int i = 4; i < id.length(); i += 5) {
            id.insert(i, "-");
        }

        return id.toString();
    }
}
