import java.util.Scanner;

/**
 * Kelas TicketSales menangani penjualan berbagai jenis tiket untuk pertandingan sepak bola.
 * Ini memungkinkan pengguna untuk membeli tiket, memeriksa ketersediaan tiket, dan keluar dari sistem.
 */
class TicketSales {
    private static final int PELAJAR_PRICE = 25000;
    private static final int EKONOMI_PRICE = 40000;
    private static final int VIP_PRICE = 70000;
    private static final int INITIAL_PELAJAR_TICKETS = 500;
    private static final int INITIAL_EKONOMI_TICKETS = 15000;
    private static final int INITIAL_VIP_TICKETS = 350;
    private static int pelajarTickets = INITIAL_PELAJAR_TICKETS;
    private static int ekonomiTickets = INITIAL_EKONOMI_TICKETS;
    private static int vipTickets = INITIAL_VIP_TICKETS;

    /**
     * Metode utama merupakan titik masuk dari program.
     * Ini menampilkan menu dan menangani input pengguna untuk membeli tiket atau memeriksa ketersediaan.
     *
     * @param args Argumen baris perintah (tidak digunakan).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    buyTicket(scanner);
                    break;
                case 2:
                    checkAvailability();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Terima kasih telah menggunakan layanan kami!");
                    break;
                default:
                    System.out.println("Opsi tidak valid, silakan coba lagi.");
            }
        }
    }

    /**
     * Menampilkan menu utama untuk penjualan tiket.
     */
    private static void showMenu() {
        System.out.println("\n=== Penjualan Tiket Pertandingan Sepak Bola ===");
        System.out.println("1. Beli Tiket");
        System.out.println("2. Cek Ketersediaan Tiket");
        System.out.println("3. Keluar");
        System.out.print("Pilih opsi: ");
    }

    /**
     * Menangani proses pembelian tiket.
     *
     * @param scanner Objek Scanner yang digunakan untuk membaca input pengguna.
     */
    private static void buyTicket(Scanner scanner) {
        System.out.println("\nPilih jenis tiket:");
        System.out.println("1. Tiket Pelajar - Harga: Rp " + PELAJAR_PRICE);
        System.out.println("2. Tiket Ekonomi - Harga: Rp " + EKONOMI_PRICE);
        System.out.println("3. Tiket VIP - Harga: Rp " + VIP_PRICE);
        System.out.print("Masukkan pilihan: ");
        int ticketType = scanner.nextInt();
        System.out.print("Masukkan jumlah tiket yang ingin dibeli: ");
        int quantity = scanner.nextInt();
        switch (ticketType) {
            case 1:
                processTicketPurchase("Tiket Pelajar", quantity, PELAJAR_PRICE, pelajarTickets);
                pelajarTickets = updateTicketStock(quantity, pelajarTickets);
                break;
            case 2:
                processTicketPurchase("Tiket Ekonomi", quantity, EKONOMI_PRICE, ekonomiTickets);
                ekonomiTickets = updateTicketStock(quantity, ekonomiTickets);
                break;
            case 3:
                processTicketPurchase("Tiket VIP", quantity, VIP_PRICE, vipTickets);
                vipTickets = updateTicketStock(quantity, vipTickets);
                break;
            default:
                System.out.println("Jenis tiket tidak valid.");
        }
    }

    /**
     * Memproses pembelian tiket.
     *
     * @param ticketType Jenis tiket yang dibeli.
     * @param quantity Jumlah tiket yang dibeli.
     * @param price Harga setiap tiket.
     * @param availableTickets Jumlah tiket yang tersedia untuk dibeli.
     */
    private static void processTicketPurchase(String ticketType, int quantity, int price, int availableTickets) {
        if (quantity <= availableTickets) {
            System.out.println("Anda telah membeli " + quantity + " " + ticketType + ". Total: Rp " + (quantity * price));
        } else {
            System.out.println("Maaf, " + ticketType.toLowerCase() + " tidak mencukupi.");
        }
    }

    /**
     * Memperbarui stok tiket yang tersedia setelah pembelian.
     *
     * @param quantity Jumlah tiket yang dibeli.
     * @param availableTickets Jumlah tiket yang tersedia sebelum pembelian.
     * @return Jumlah tiket yang tersedia setelah pembelian.
     */
    private static int updateTicketStock(int quantity, int availableTickets) {
        return availableTickets - quantity;
    }

    /**
     * Menampilkan ketersediaan berbagai jenis tiket.
     */
    private static void checkAvailability() {
        System.out.println("\nKetersediaan Tiket:");
        System.out.println("Tiket Pelajar: " + pelajarTickets + " tiket");
        System.out.println("Tiket Ekonomi: " + ekonomiTickets + " tiket");
        System.out.println("Tiket VIP: " + vipTickets + " tiket");
    }
}
