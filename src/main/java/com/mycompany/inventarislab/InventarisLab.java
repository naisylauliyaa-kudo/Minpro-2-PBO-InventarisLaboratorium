package com.mycompany.inventarislab;

import view.TampilkanInventarisLab;

public class InventarisLab {

    public static void main(String[] args) {
        // Memanggil View untuk menampilkan menu inventaris lab
        TampilkanInventarisLab view = new TampilkanInventarisLab();
        view.tampilkanMenu();
    }
}