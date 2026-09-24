package model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */

public class Peminjaman {
    private int idPeminjaman;
    private String namaPeminjam;
    private int idAlatPinjam;
    private int jumlahPinjam;
   
    public Peminjaman(int idPeminjaman, String namaPeminjam, int idAlatPinjam, int jumlahPinjam){
        this.idPeminjaman = idPeminjaman;
        this.namaPeminjam = namaPeminjam;
        this.idAlatPinjam = idAlatPinjam;
        this.jumlahPinjam = jumlahPinjam;
    }
   
    public int getIdPeminjaman(){
        return idPeminjaman;
    }
   
    public int getIdAlatPinjam(){
        return idAlatPinjam;
    }

    public int getJumlahPinjam(){
        return jumlahPinjam;
    }
   
    public void tampilkanInfoPeminjaman(){
        System.out.println("ID Peminjaman  : " + idPeminjaman);
        System.out.println("Nama Peminjam  : " + namaPeminjam);
        System.out.println("ID Alat Pinjam : " + idAlatPinjam);
        System.out.println("Jumlah Dipinjam: " + jumlahPinjam);
    }
}
