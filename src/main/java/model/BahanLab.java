/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class BahanLab extends KeperluanLab {
    private String satuan;

    public BahanLab(int idBahan, String namaBahan, int jumlahBahan, String satuan) {
        super(idBahan, namaBahan, jumlahBahan);
        this.satuan = satuan;
    }

    // Getter dan Setter untuk Satuan
    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    @Override
    public void tampilkanInfo() {
    System.out.println("ID Bahan: " + id + " || Nama Bahan: " + nama + " || Stok: " + jumlah + " (" + satuan + ")");
}
}
