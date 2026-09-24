package model;

public class AlatLab extends KeperluanLab {

    public AlatLab(int idAlat, String namaAlat, int jumlahAlat) {
        super(idAlat, namaAlat, jumlahAlat);
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("ID Alat: " + id + " || Nama Alat: " + nama + " || Stok Tersedia: " + jumlah);
    }
}