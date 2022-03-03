import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Scanner;

public class Store {
    public static void main(String[] args) throws FileNotFoundException {

        String[] store = new String[10];

        for (int j = 0; ; j++) {

            System.out.println("Введите команду");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();

            if (command.equals("add")) {
                System.out.println("Кладём новый товар, укажите название");
                String item = scanner.nextLine();
                for (int i = 0; i < store.length; i++) {
                    if (store[i] == null || store[i].isEmpty()) {
                        store[i] = item;
                        System.out.println("Товар " + item + " успешно доваблен на склад");
                        break;

                    } else if (store[i] != null) {
                        System.out.println("Склад переполнен");
                    }

                }
            }

            if (command.equals("del")) {
                System.out.println("Что удаляем?");
                String itemToDel = scanner.nextLine();
                for (int i = 0; i < store.length; i++) {
                    if (store[i] == null) {
                        continue;
                    }
                    if (store[i].equals(itemToDel)) {
                        store[i] = null;
//                        System.out.println("Товар " + itemToDel + " успешно удалён со склада");
                        break;
                    }
                    System.out.println("Товар " + itemToDel + " успешно удалён со склада");
                }
            }

            if (command.equals("find")) {
                System.out.println("Что ищем??");
                String findItem = scanner.nextLine();
                for (int i = 0; i < store.length; i++) {
                    if (store[i] == null) {
                        continue;
                    }
                    if (store[i].equals(findItem)) {
                        System.out.println("Товар " + findItem + " есть на складе");
                        break;
                    }
//                    else System.out.println("Товара " + findItem + " На складе нет");
                }
//                System.out.println("Товара " + findItem + " На складе нет");
            }

            if (command.equals("count")) {
                int count = 0;
                for (int i = 0; i < store.length; i++) {
                    if (store[i] != null) {
                        count = count + 1;
                    }

                }
                System.out.println("На складе " + count + " позиций");
            }

            if (command.equals("toEx")) {
                Workbook storeBook = new XSSFWorkbook();
                FileOutputStream exelDoc = new FileOutputStream(new File("./sss.xlsx"));
                Sheet sheet = storeBook.createSheet("itemsS");
                for (int i = 0; i < store.length; i++) {
                    if (store[i] != null) {
                        for (int p = 0; p < store.length; p++) {
                            Row rowI = sheet.createRow(0);
                            Cell item = rowI.createCell(0);
                            item.setCellValue(store[i]);
                        }
                    }
                }
                try {
                    storeBook.write(exelDoc);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    exelDoc.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            for (int i = 0; i < store.length; i++) {
//                if (store[i] != null) {
                System.out.println("На складе " + store[i]);
            }
        }
    }
}

