package control;

import model.AlatLab;
import model.BahanLab;
import model.Peminjaman;
import java.util.ArrayList;

public class LabControll {
    private final ArrayList<AlatLab> daftarAlat = new ArrayList<>();
    private final ArrayList<BahanLab> daftarBahan = new ArrayList<>();
    private final ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();

    public LabControll() {
        daftarAlat.add(new AlatLab(101, "Mikroskop Cahaya", 5));
        daftarAlat.add(new AlatLab(102, "Gelas Ukur 100ml", 12));

        daftarBahan.add(new BahanLab(201, "Alkohol 96%", 10, "100 ml"));
    }
    
    public int generateIdAlat() {
        if (daftarAlat.isEmpty()) {
            return 1;
        }
        int maxId = daftarAlat.get(0).getId();
        for (AlatLab alat : daftarAlat) {
            if (alat.getId() > maxId) {
                maxId = alat.getId();
            }
        }
        return maxId + 1;
    }

    public int generateIdBahan() {
        if (daftarBahan.isEmpty()) {
            return 1; // 
        }
        int maxId = daftarBahan.get(0).getId();
        for (BahanLab bahan : daftarBahan) {
            if (bahan.getId() > maxId) {
                maxId = bahan.getId();
            }
        }
        return maxId + 1;
    }

    public void tambahAlat(AlatLab alat) {

        daftarAlat.add(alat);
        System.out.println("Data alat berhasil ditambahkan ^-^");
    }

    public void tampilkanAlat() {
        if (daftarAlat.isEmpty()) {
            System.out.println("\nBelum ada data alat di inventaris.");
            return;
        }
        System.out.println("\n======== DAFTAR ALAT LABORATORIUM ========");
        for (int i = 0; i < daftarAlat.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarAlat.get(i).tampilkanInfo(); 
        }
    }

    public void ubahAlat(int idUbah, String namaBaru, int jumlahBaru) {
        boolean ditemukan = false;
        for (AlatLab alat : daftarAlat) {
            if (alat.getId() == idUbah) {
                alat.setNama(namaBaru);
                alat.setJumlah(jumlahBaru);
                System.out.println("Data alat berhasil diubah ^-^");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) System.out.println("Alat dengan ID tersebut tidak ditemukan.");
    }

    public void hapusAlat(int idHapus) {
        boolean ditemukan = false;
        for (int i = 0; i < daftarAlat.size(); i++) {
            if (daftarAlat.get(i).getId() == idHapus) {
                daftarAlat.remove(i);
                System.out.println("Data alat berhasil dihapus");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) System.out.println("Alat dengan ID tersebut tidak ditemukan.");
    }

    public void tambahBahan(BahanLab bahan) {
        daftarBahan.add(bahan);
        System.out.println("Data bahan berhasil ditambahkan ^-^");
    }

    public void tampilkanBahan() {
        if (daftarBahan.isEmpty()) {
            System.out.println("\nBelum ada data bahan di inventaris.");
            return;
        }
        System.out.println("\n======== DAFTAR BAHAN LABORATORIUM ========");
        for (int i = 0; i < daftarBahan.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarBahan.get(i).tampilkanInfo(); 
        }
    }

    public void ubahBahan(int idUbah, String namaBaru, int jumlahBaru, String satuanBaru) {
        boolean ditemukan = false;
        for (BahanLab bahan : daftarBahan) {
            if (bahan.getId() == idUbah) {
                bahan.setNama(namaBaru);
                bahan.setJumlah(jumlahBaru);
                bahan.setSatuan(satuanBaru);
                System.out.println("Data bahan berhasil diubah ^-^");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) System.out.println("Bahan dengan ID tersebut tidak ditemukan.");
    }

    public void hapusBahan(int idHapus) {
        boolean ditemukan = false;
        for (int i = 0; i < daftarBahan.size(); i++) {
            if (daftarBahan.get(i).getId() == idHapus) {
                daftarBahan.remove(i);
                System.out.println("Data bahan berhasil dihapus");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) System.out.println("Bahan dengan ID tersebut tidak ditemukan.");
    }

    public void tambahPeminjaman(Peminjaman peminjaman) {
        AlatLab alatDipinjam = null;
        for (AlatLab alat : daftarAlat) {
            if (alat.getId() == peminjaman.getIdAlatPinjam()) {
                alatDipinjam = alat;
                break;
            }
        }

        if (alatDipinjam == null) {
            System.out.println("Gagal: ID Alat yang ingin dipinjam tidak terdaftar di inventaris.");
        } else if (alatDipinjam.getJumlah() < peminjaman.getJumlahPinjam()) {
            System.out.println("Gagal: Stok alat tidak mencukupi. Sisa stok: " + alatDipinjam.getJumlah());
        } else {
            alatDipinjam.setJumlah(alatDipinjam.getJumlah() - peminjaman.getJumlahPinjam());
            daftarPeminjaman.add(peminjaman);
            System.out.println("Peminjaman berhasil dicatat dan stok alat diperbarui");
        }
    }

    public void tampilkanPeminjaman() {
        if (daftarPeminjaman.isEmpty()) {
            System.out.println("\nBelum ada data peminjaman aktif.");
            return;
        }
        System.out.println("\n======== DAFTAR PEMINJAMAN ALAT ========");
        for (int i = 0; i < daftarPeminjaman.size(); i++) {
            System.out.println("----- Peminjaman ke-" + (i + 1) + " -----");
            daftarPeminjaman.get(i).tampilkanInfoPeminjaman();
        }
    }

    public void pengembalian(int idKembali) {
        Peminjaman peminjamanDitemukan = null;
        int indexHapus = -1;

        for (int i = 0; i < daftarPeminjaman.size(); i++) {
            if (daftarPeminjaman.get(i).getIdPeminjaman() == idKembali) {
                peminjamanDitemukan = daftarPeminjaman.get(i);
                indexHapus = i;
                break;
            }
        }

        if (peminjamanDitemukan != null) {
            for (AlatLab alat : daftarAlat) {
                if (alat.getId() == peminjamanDitemukan.getIdAlatPinjam()) {
                    alat.setJumlah(alat.getJumlah() + peminjamanDitemukan.getJumlahPinjam());
                    break;
                }
            }
            daftarPeminjaman.remove(indexHapus);
            System.out.println("Pengembalian berhasil dicatat. Stok alat telah dikembalikan ^-^");
        } else {
            System.out.println("ID Peminjaman tidak ditemukan.");
        }
    }
}