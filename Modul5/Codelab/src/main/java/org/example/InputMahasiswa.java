package org.example;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class InputMahasiswa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<String> namaSet = new HashSet<>();
        List<Mahasiswa> dataList = new ArrayList<>();

        System.out.println("Masukkan data mahasiswa. Ketik 'selesai' pada nama untuk mengakhiri");

        while (true) {
            System.out.print("Masukkan Nama: ");
            String nama = sc.nextLine();

            if (nama.equalsIgnoreCase("selesai")) {
                break;
            }

            if (namaSet.contains(nama)) {
                System.out.println("Nama sudah ada, masukkan nama yang berbeda !");
                continue;
            }

            System.out.print("Masukkan Semester: ");
            int semester = Integer.parseInt(sc.nextLine());

            System.out.print("Masukkan Mata Kuliah: ");
            String matkul = sc.nextLine();

            Mahasiswa m = new Mahasiswa(nama, semester, matkul);
            namaSet.add(nama);
            dataList.add(m);

            saveToExcel(dataList);

            System.out.println("Data berhasil disimpan ke dalam file data_mahasiswa.xlsx !");
            System.out.println();
        }

        System.out.println("Terima kasih !");
    }

    private static void saveToExcel(List<Mahasiswa> data) {
        String filePath = "src/main/resources/data_mahasiswa.xlsx";

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Mahasiswa");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Nama");
        header.createCell(1).setCellValue("Semester");
        header.createCell(2).setCellValue("Mata Kuliah");

        int rowIndex = 1;
        for (Mahasiswa m : data) {
            Row row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(m.getNama());
            row.createCell(1).setCellValue(m.getSemester());
            row.createCell(2).setCellValue(m.getMatkul());
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
            workbook.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
