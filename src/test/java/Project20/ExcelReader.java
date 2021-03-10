package Project20;

import com.sun.tools.javac.comp.Todo;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    //creating class variables
    private Workbook workbook;
    private Sheet sheet;

    //creating constructor
    public ExcelReader(String pathname) throws IOException {
        File f = new File(pathname);
        workbook = WorkbookFactory.create(f);
        sheet = workbook.getSheetAt(0);
    }

    //creating Map which will contain key and value form table
    public Map<String, String> getMap() {
        int numberOfRows = sheet.getPhysicalNumberOfRows();

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < numberOfRows; i++) {
            Row row = sheet.getRow(i);
            String key = row.createCell(0).toString();
            String value = row.getCell(1).toString();
            map.put(key, value);
        }
        return map;
    }

    //crating list of list to cover each row as list and put it all in a list (list of lists)
    public List<List<String>> getLists() throws IOException {
        List<List<String>> listOfLists = new ArrayList<>();
        int numberOfRows = sheet.getPhysicalNumberOfRows();

        for (int i = 0; i < numberOfRows; i++) { // creating new array for each row
            List<String> list = new ArrayList<>();

            Row row = sheet.getRow(i);
            int numberOfCells = row.getPhysicalNumberOfCells();
            for (int j = 0; j < numberOfCells; j++) {
                Cell cell = row.getCell(j);
                //if (cell == null) {//If else for empty cell
                  //  list.add(" ");
                //}// else {
                    list.add(cell.getStringCellValue()); //puts the cells in a row in to the list
                //}
            }

            listOfLists.add(list);
        }

        return listOfLists;
    }

    //creating list of map to join map and lists together for getting the hole table
    public List<Map<String, String>> getListOfMaps() throws IOException {
        Cell titleCell = null;
        List<String> titles = new ArrayList<String>();
        Row titleRow = sheet.getRow(0); // reading the first row
        for (int i = 0; i < titleRow.getPhysicalNumberOfCells(); i++) {


            //if (titleCell == null) {//If else for empty  title cell
                //titles.add(" ");
            //} else {
             //   titles.add(titleCell.toString());
            //}
            try {
                 titleCell = titleRow.getCell(i);
            }catch (NullPointerException exception){
                titles.add(titleCell.toString());;
            }
        }

            List<Map<String, String>> listOfMaps = new ArrayList<>();
            for ( int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) { // staring from second row
                Map<String, String> map = new HashMap<>();

                Row row = sheet.getRow(i);
                for (int j = 0; j < titles.size(); j++) {
                    String key = titles.get(j);
                   // if (key == null){
                     //   key = " ";
                    //}
                    String value = row.getCell(j).toString();
                    //if( value == null){
                    //    map.put(key," ");
                    //}

                    map.put(key, value);
                }

                // save the map inside a list
                listOfMaps.add(map);
            }
            return listOfMaps;

        }

        public  void fillTheCell(int index) {

            int numberOfRows = sheet.getPhysicalNumberOfRows();

            for (int i = 0; i < numberOfRows; i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.createCell(index);
                cell.setCellValue("-");

            }

        }

    }