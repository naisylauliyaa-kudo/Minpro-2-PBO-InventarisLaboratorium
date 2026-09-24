/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import control.LabControll;
import model.AlatLab;
import model.BahanLab;
import model.Peminjaman;
import java.util.Scanner;

public class TampilkanInventarisLab {
    private Scanner input = new Scanner(System.in);
    private LabControll crud = new LabControll();

    public void tampilkanMenu() {
        int pilihan;

        do {
            System.out.println("\n^-^ ============================================ ^-^");
            System.out.println(" SISTEM INVENTARIS LABORATORIUM");
            System.out.println("^-^ ============================================ ^-^");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Ubah Data");
            System.out.println("4. Hapus Data");
            System.out.println("5. Peminjaman dan Pengembalian");
            System.out.println("6. Keluar");
            System.out.println("==================================================");
            System.out.print("Pilih menu: ");

            String inputPilihan = input.nextLine();
            boolean isMenuNumeric = true;
            for (int i = 0; i < inputPilihan.length(); i++) {
                if (!Character.isDigit(inputPilihan.charAt(i))) {
                    isMenuNumeric = false;
                    break;
                }
            }
            if (!isMenuNumeric || inputPilihan.isEmpty()) {
                System.out.println("Pilihan tidak valid! Masukkan angka menu (1-6).");
                pilihan = 0;
                continue;
            }

            pilihan = Integer.parseInt(inputPilihan);

            switch (pilihan) {
                case 1: 
                    System.out.println("\n--- MENU TAMBAH DATA ---");
                    System.out.println("1. Tambah Alat");
                    System.out.println("2. Tambah Bahan");
                    System.out.print("Pilih jenis: ");
                    String subTambah = input.nextLine();

                    if (subTambah.equals("1")) {
                        System.out.println("\n===== TAMBAH ALAT =====");
                        int idAlat = crud.generateIdAlat();
                        
                        String namaAlat = "";
                        while (true) {
                            System.out.print("Nama Alat: ");
                            namaAlat = input.nextLine();
                            if (namaAlat.isEmpty()) { 
                                System.out.println("Nama tidak boleh kosong!"); 
                                
                                continue; }
                            
                            boolean adaHurufAtauAngka = namaAlat.matches(".*[a-zA-Z0-9].*");
                            if (!adaHurufAtauAngka) {
                                System.out.println("Nama alat tidak boleh hanya berisi simbol atau spasi!");
                            
                                continue;
                            }
                            break;
                           
                        }
                    int jumlahAlat = 0;
                    
                    while (true) {
                        System.out.print("Jumlah: ");
                        String inputJml = input.nextLine();

                        if (inputJml.isEmpty()) { 
                            System.out.println("Jumlah tidak boleh kosong!"); 
                            continue; 
                        }
                        boolean valid = true;
                        for (int i = 0; i < inputJml.length(); i++) {
                            char c = inputJml.charAt(i);
                           
                            if (i == 0 && c == '-') {
                                continue;
                            }
                            if (!Character.isDigit(c)) { 
                                valid = false; 
                                break; 
                            }
                        }
                        if (!valid) { 
                            System.out.println("Jumlah harus angka!"); 
                            continue; 
                        }
                        jumlahAlat = Integer.parseInt(inputJml);

                        if (jumlahAlat <= 0) { 
                            System.out.println("Jumlah tidak boleh 0 atau minus"); 
                            continue; 
                        }
                        break;
                    }

                    crud.tambahAlat(new AlatLab(idAlat, namaAlat, jumlahAlat));

                    } else if (subTambah.equals("2")) {
                        System.out.println("\n===== TAMBAH BAHAN =====");
                        int idBahan = crud.generateIdBahan();

                        String namaBahan = "";
                        while (true) {
                            System.out.print("Nama Bahan: ");
                            namaBahan = input.nextLine();
                            if (namaBahan.isEmpty()) { 
                                System.out.println("Nama tidak boleh kosong!"); 
                                continue; 
                            }
                            
                            boolean adaHurufAtauAngka = namaBahan.matches(".*[a-zA-Z0-9].*");
                            if (!adaHurufAtauAngka) {
                                System.out.println("Nama alat tidak boleh hanya berisi simbol atau spasi!");                            
                                continue;
                            }
                            break;
                        }

                        int jumlahBahan = 0;
                        
                        while (true) {
                            System.out.print("Jumlah    : ");
                            String inputJml = input.nextLine();

                            if (inputJml.isEmpty()) { 
                                System.out.println("Jumlah tidak boleh kosong!"); 
                                continue; 
                            }
                            boolean valid = true;
                            for (int i = 0; i < inputJml.length(); i++) {
                                char c = inputJml.charAt(i);
                                if (i == 0 && c == '-') {
                                    continue;
                                }
                                if (!Character.isDigit(c)) { 
                                    valid = false; 
                                    break; 
                                }
                            }
                            if (!valid) { 
                                System.out.println("Jumlah harus angka!"); 
                                continue; 
                            }
                            jumlahBahan = Integer.parseInt(inputJml);

                            if (jumlahBahan <= 0) { 
                                System.out.println("Jumlah tidak boleh 0 atau minus"); 
                                continue; 
                            }
                            break;
                        }

                        String satuan = "";
                        while (true) {
                            System.out.print("Satuan (ml/gram/pcs): ");
                            satuan = input.nextLine();
                            if (satuan.isEmpty()) { System.out.println("Satuan tidak boleh kosong!"); continue; }
                            break;
                        }

                        crud.tambahBahan(new BahanLab(idBahan, namaBahan, jumlahBahan, satuan));
                    } else {
                        System.out.println("Pilihan submenu tidak valid.");
                    }
                    break;

                case 2: 
                    System.out.println("\n--- MENU LIHAT DATA ---");
                    System.out.println("1. Lihat Data Alat");
                    System.out.println("2. Lihat Data Bahan");
                    System.out.print("Pilih jenis: ");
                    String subLihat = input.nextLine();

                    if (subLihat.equals("1")) {
                        crud.tampilkanAlat();
                    } else if (subLihat.equals("2")) {
                        crud.tampilkanBahan(); 
                    } else {
                        System.out.println("Pilihan submenu tidak valid.");
                    }
                    break;

                case 3: 
                    System.out.println("\n--- MENU UBAH DATA ---");
                    System.out.println("1. Ubah Data Alat");
                    System.out.println("2. Ubah Data Bahan");
                    System.out.print("Pilih jenis: ");
                    String subUbah = input.nextLine();

                    if (subUbah.equals("1")) {
                        System.out.println("\n--- DAFTAR ALAT TERSEDIA ---");
                        crud.tampilkanAlat();
                        System.out.println("----------------------------------------");

                        System.out.print("ID Alat yang akan diubah: ");
                        int idUbah = input.nextInt();
                        input.nextLine();

                        String namaBaru = "";
                        while (true) {
                            System.out.print("Nama Baru (tekan Enter jika tidak ingin mengubah): ");
                            namaBaru = input.nextLine();
                            if (namaBaru.isEmpty()) {
                                break; 
                            }
                            boolean adaHurufAtauAngka = namaBaru.matches(".*[a-zA-Z0-9].*");

                            if (!adaHurufAtauAngka) {
                                System.out.println("Nama tidak boleh hanya berisi simbol atau spasi!");
                                continue;
                            }

                            break; 
                        }

                        int jmlBaru = 0;
                        while (true) {
                            System.out.print("Jumlah Baru: ");
                            String inputJml = input.nextLine();
                            if (inputJml.isEmpty()) { System.out.println("Jumlah tidak boleh kosong"); continue; }

                            boolean valid = true;
                            for (int i = 0; i < inputJml.length(); i++) {
                                char c = inputJml.charAt(i);
                                if (i == 0 && c == '-') { continue; }
                                if (!Character.isDigit(c)) { valid = false; break; }
                            }
                            if (!valid) { System.out.println("Jumlah harus angka"); continue; }

                            jmlBaru = Integer.parseInt(inputJml);
                            if (jmlBaru <= 0) { System.out.println("Jumlah tidak boleh 0 dan minus"); continue; }
                            break;
                        }

                        crud.ubahAlat(idUbah, namaBaru, jmlBaru);

                    } else if (subUbah.equals("2")) {
                        System.out.println("\n--- DAFTAR BAHAN TERSEDIA ---");
                        crud.tampilkanBahan();
                        System.out.println("----------------------------------------");

                        System.out.print("ID Bahan yang akan diubah: ");
                        int idUbahBahan = input.nextInt();
                        input.nextLine(); 

                        String namaBaruBahan = "";
                        while (true) {
                             System.out.print("Nama Baru (tekan Enter jika tidak ingin mengubah): ");
                             namaBaruBahan = input.nextLine();
                                if (namaBaruBahan.isEmpty()) {
                                    break; 
                            }
                                boolean adaHurufAtauAngka = namaBaruBahan.matches(".*[a-zA-Z0-9].*");

                                if (!adaHurufAtauAngka) {
                                System.out.println("Nama tidak boleh hanya berisi simbol atau spasi!");
                                    continue;
                            }
                                break; 
                        }

                        int jmlBaruBahan = 0;
                        while (true) {
                            System.out.print("Jumlah Baru: ");
                            String inputJml = input.nextLine();
                            if (inputJml.isEmpty()) { System.out.println("Jumlah tidak boleh kosong"); continue; }

                            boolean valid = true;
                            for (int i = 0; i < inputJml.length(); i++) {
                                char c = inputJml.charAt(i);
                                if (i == 0 && c == '-') { continue; }
                                if (!Character.isDigit(c)) { valid = false; break; }
                            }
                            if (!valid) { System.out.println("Jumlah harus angka"); continue; }

                            jmlBaruBahan = Integer.parseInt(inputJml);
                            if (jmlBaruBahan <= 0) { System.out.println("Jumlah tidak boleh 0 dan minus"); continue; }
                            break;
                        }

                        String satuanBaru = "";
                        while (true) {
                            System.out.print("Satuan Baru (ml/gram/pcs): ");
                            satuanBaru = input.nextLine();
                            if (satuanBaru.isEmpty()) { System.out.println("Satuan tidak boleh kosong!"); continue; }
                            break;
                        }

                        crud.ubahBahan(idUbahBahan, namaBaruBahan, jmlBaruBahan, satuanBaru); 
                    } else {
                        System.out.println("Pilihan submenu tidak valid.");
                    }
                    break;

                case 4: 
                    System.out.println("\n--- MENU HAPUS DATA ---");
                    System.out.println("1. Hapus Data Alat");
                    System.out.println("2. Hapus Data Bahan");
                    System.out.print("Pilih jenis: ");
                    String subHapus = input.nextLine();

                    if (subHapus.equals("1")) {
                        
                        crud.tampilkanAlat(); 
                        System.out.println("----------------------------------------");
                        
                        System.out.print("ID Alat yang akan dihapus: ");
                        int idHapus = input.nextInt();
                        input.nextLine();
                        crud.hapusAlat(idHapus);

                    } else if (subHapus.equals("2")) {
                        
                        crud.tampilkanBahan(); 
                        System.out.println("----------------------------------------");
                        
                        System.out.print("ID Bahan yang akan dihapus: ");
                        int idHapusBahan = input.nextInt();
                        input.nextLine();
                        crud.hapusBahan(idHapusBahan); 
                    } else {
                        System.out.println("Pilihan submenu tidak valid.");
                    }
                    break;

                case 5: 
                    System.out.println("\n===== PEMINJAMAN =====");
                    System.out.println("1. Pinjam Alat");
                    System.out.println("2. Lihat Peminjaman");
                    System.out.println("3. Pengembalian");
                    System.out.print("Pilih: ");

                    int pilihanPinjam = input.nextInt();
                    input.nextLine();

                    if (pilihanPinjam == 1) {
                        System.out.print("ID Peminjaman : ");
                        int idPeminjaman = input.nextInt();
                        input.nextLine();
                        System.out.print("Nama Peminjam : ");
                        String namaPeminjam = input.nextLine();
                        crud.tampilkanAlat(); 
                        System.out.println("----------------------------------------");
                        System.out.print("ID Alat       : ");
                        int idAlatPinjam = input.nextInt();
                        System.out.print("Jumlah Pinjam : ");
                        int jumlahPinjam = input.nextInt();
                        input.nextLine();

                        crud.tambahPeminjaman(new Peminjaman(idPeminjaman, namaPeminjam, idAlatPinjam, jumlahPinjam));

                    } else if (pilihanPinjam == 2) {
                        crud.tampilkanPeminjaman();

                    } else if (pilihanPinjam == 3) {
                        System.out.print("ID Peminjaman yang dikembalikan: ");
                        int idKembali = input.nextInt();
                        input.nextLine();
                        crud.pengembalian(idKembali);
                    }
                    break;

                case 6:
                    System.out.println("Program selesai. Terima kasih!");
                    break;

                default:
                    if (pilihan != 0) {
                        System.out.println("Pilihan tidak tersedia.");
                    }
            }
        } while (pilihan != 6);

        input.close();
    }
}
