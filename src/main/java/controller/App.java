package controller;

import repository.*;
import service.*;
import util.Connector;
import util.View;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class App {
    private Scanner input = new Scanner(System.in);

    Connector connector = new Connector();
    Connection connection = connector.connect();
    View view = new View(connection);

    IProductRepo productRepo = new ProductRepo(connection);
    IProductService productService = new ProductService(productRepo);
    IProductController productController = new ProductController(productService);

    IProductPriceRepo productPriceRepo = new ProductPriceRepo(connection);
    IProductPriceService productPriceService = new ProductPriceService(productPriceRepo);
    IProductPriceController productPriceController = new ProductPriceController(productPriceService);

    ISellRepo sellRepo = new SellRepo(connection);
    ISellService sellService = new SellService(sellRepo);
    ISellController sellController = new SellController(sellService);

    ISellDetailRepo sellDetailRepo = new SellDetailRepo(connection);
    ISellDetailService sellDetailService = new SellDetailService(sellDetailRepo);
    ISellDetailController sellDetailController = new SellDetailController(sellDetailService);


    public void menu() {
        boolean run = true;
        while (run) {
            System.out.println("\n-----------------------------------");
            System.out.println("\t\t=== Main Menu ===");
            System.out.println("-----------------------------------");
            System.out.println("1. Product Barang");
            System.out.println("2. Transaksi Penjualan");
            System.out.println("3. Laporan Penjualan");
            System.out.println("4. Exit");
            int selectMenu;
            System.out.print("\nMasukan menu yang dipilih : ");

            try {
                selectMenu = input.nextInt();

                if (selectMenu < 1 || selectMenu > 4) {
                    System.err.println("Menu tidak tersedia !");
                    menu();
                } else {
                    switch (selectMenu) {
                        case 1 -> menu_product();
                        case 2 -> menu_transaksi();
                        case 4 -> System.exit(0);
                    }
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public void menu_product() {
        System.out.println("\n-----------------------------------");
        System.out.println("\t\t=== Select Menu Product Barang ===");
        System.out.println("-----------------------------------");
        System.out.println("1. Tambah Product");
        System.out.println("2. Hapus Product");
        System.out.println("3. Detail Product");
        int selectMenuProduct;
        System.out.print("\nMasukan menu yang dipilih : ");
        try {
            selectMenuProduct = input.nextInt();

            if (selectMenuProduct < 1 || selectMenuProduct > 3) {
                System.err.println("Menu tidak tersedia !");
                menu_product();
            } else {
                switch (selectMenuProduct) {
                    case 1 -> add_product();
                    case 2 -> delete_product();
                    case 3 -> productPriceController.detailProduct();
                }
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void menu_transaksi() {
        System.out.println("\n-----------------------------------");
        System.out.println("\t\t=== Select Menu Transaksi ===");
        System.out.println("-----------------------------------");
        System.out.println("1. Tambah Transaksi Penjualan");
        System.out.println("2. Hapus Transaksi Penjualan");
        System.out.println("3. Detail Transaksi Penjualan");
        int selectMenuTransaksi;
        System.out.print("\nMasukan menu yang dipilih : ");
        try {
            selectMenuTransaksi = input.nextInt();

            if (selectMenuTransaksi < 1 || selectMenuTransaksi > 3) {
                System.err.println("Menu tidak tersedia !");
                menu_transaksi();
            } else {
                switch (selectMenuTransaksi) {
                    case 1 -> add_transaksi();
                    case 2 -> {
                        System.out.println("Pilih id transaksi");
                        int inIdTrx = input.nextInt();
                        sellController.deleteTransaksi(inIdTrx);
                    }
                    case 3 -> sellDetailController.detailTransaksi();
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void add_product() throws SQLException {
        System.out.println("Masukan Name Product");
        var inName = input.nextLine();
        System.out.println("Masukan Price Product");
        int inPrice = input.nextInt();

        productController.addProduct(inName);
        productPriceController.addProductPrice(inPrice);
    }
    public void delete_product() throws SQLException {
        System.out.println("Masukan id product");
        int inIdProduct = input.nextInt();
        productController.deleteProduct(inIdProduct);
    }
    public void add_transaksi() throws SQLException {
        System.out.println("Masukan Tanggal nya manual hehe (yyyy-mm-dd)");
        String inDate = input.next();
        System.out.println("Masukan nama customer (optional)");
        String inNameCus = input.next();
        sellController.addSell(inDate, inNameCus);
        char confirm;
        try {
            do {
                System.out.println("Masukan id product :");
                int inProduct = input.nextInt();
                System.out.println("Masukan qty :");
                int inQty = input.nextInt();
                sellDetailController.addSellDetail(inProduct, inQty);

                System.out.println("Lanjut masukan data ? 'Y' or 'N'");
                confirm = input.next().charAt(0);

            }
            while (confirm == 'Y');
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
