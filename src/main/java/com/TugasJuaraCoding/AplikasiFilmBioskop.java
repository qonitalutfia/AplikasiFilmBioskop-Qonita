package com.TugasJuaraCoding;

import java.util.ArrayList;   // Mengimpor kelas ArrayList untuk menyimpan daftar film
import java.util.Scanner;     // Mengimpor kelas Scanner untuk input dari user

public class AplikasiFilmBioskop { // Kelas utama aplikasi

    static Scanner scanner = new Scanner(System.in); // Scanner untuk membaca input dari pengguna
    static ArrayList<Film> daftarFilm = new ArrayList<>(); // Menyimpan daftar semua film

    // Kelas Film sebagai blueprint untuk objek film
    static class Film {
        String judul; // Judul film
        String genre; // Genre film
        int tahun;    // Tahun rilis film

        // Konstruktor untuk menginisialisasi objek Film
        public Film(String judul, String genre, int tahun) {
            this.judul = judul;
            this.genre = genre;
            this.tahun = tahun;
        }
    }

    // Method utama yang dijalankan pertama kali
    public static void main(String[] args) {
        if (login()) {        // Jika login berhasil
            tampilkanMenu();  // Tampilkan menu utama
        }
    }

    // Method login untuk otentikasi user
    public static boolean login() {
        System.out.println("=== Login ===");
        System.out.print("Input username: ");
        String username = scanner.nextLine(); // Input username
        System.out.print("Input password: ");
        String password = scanner.nextLine(); // Input password

        // Cek apakah username dan password sesuai
        if (username.equals("admin") && password.equals("12345")) {
            System.out.println("Login Berhasil!");
            return true; // Login sukses
        } else {
            System.out.println("Login Gagal!");
            return false; // Login gagal
        }
    }

    // Method untuk menampilkan menu utama
    public static void tampilkanMenu() {
        int menu;

        while (true) { // Loop terus menerus sampai user memilih keluar
            System.out.println("=== Menu Utama ===");
            System.out.println("1. Tampilkan Daftar Film");
            System.out.println("2. Input Data Film");
            System.out.println("3. Cari Film");
            System.out.println("4. Keluar");
            System.out.print("Pilih menu (1-4): ");
            menu = scanner.nextInt();   // Baca pilihan menu
            scanner.nextLine();        // Membersihkan buffer setelah nextInt

            // Proses pilihan menu
            switch (menu) {
                case 1:
                    tampilkanDaftarFilm(); // Tampilkan semua film
                    break;
                case 2:
                    inputDataFilm();       // Input film baru
                    break;
                case 3:
                    cariFilmBerdasarkanJudul(); // Cari film berdasarkan judul
                    break;
                case 4:
                    System.out.println("4. Keluar");
                    return; // Keluar dari method (dan loop)
                default:
                    System.out.println("Input tidak valid"); // Jika input bukan 1-4
            }
        }
    }

    // Method untuk menampilkan semua film
    public static void tampilkanDaftarFilm() {
        System.out.println("=== Daftar Film ===");
        if (daftarFilm.isEmpty()) { // Jika belum ada film
            System.out.println("Belum ada data film.");
        } else {
            // Loop dan tampilkan tiap film
            for (int i = 0; i < daftarFilm.size(); i++) {
                Film film = daftarFilm.get(i);
                System.out.println("Film ke - " + (i + 1) + ". " + film.judul +
                        " | Genre: " + film.genre +
                        " | Tahun: " + film.tahun);
            }
        }
    }

    // Method untuk menambahkan film ke daftar
    public static void inputDataFilm() {
        System.out.println("=== Input Data Film ===");
        System.out.print("Judul Film: ");
        String judul = scanner.nextLine(); // Input judul film
        System.out.print("Genre Film: ");
        String genre = scanner.nextLine(); // Input genre film
        System.out.print("Tahun Rilis: ");
        int tahun = scanner.nextInt();     // Input tahun film
        scanner.nextLine(); // Membersihkan buffer

        // Membuat objek film dan menambahkannya ke daftar
        Film film = new Film(judul, genre, tahun);
        daftarFilm.add(film);
        System.out.println("Film berhasil ditambahkan!");
    }

    // Method untuk mencari film berdasarkan judul
    public static void cariFilmBerdasarkanJudul() {
        System.out.println("=== Cari Film Berdasarkan Judul ===");
        System.out.print("Masukkan judul film yang ingin dicari: ");
        String keyword = scanner.nextLine().toLowerCase(); // Input kata kunci, diubah ke huruf kecil

        boolean ditemukan = false; // Flag untuk mengetahui apakah film ditemukan
        for (int i = 0; i < daftarFilm.size(); i++) {
            Film film = daftarFilm.get(i);
            // Jika judul mengandung kata kunci
            if (film.judul.toLowerCase().contains(keyword)) {
                System.out.println("Film ke - " + (i + 1) + ". " + film.judul +
                        " | Genre: " + film.genre +
                        " | Tahun: " + film.tahun);
                ditemukan = true;
            }
        }

        // Jika tidak ditemukan
        if (!ditemukan) {
            System.out.println("Film dengan judul tersebut tidak ditemukan.");
        }
    }
}