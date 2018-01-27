package com.johnnysayshiandroid.historynotesapplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 28/1/2018.
 */

public class CSVReader {
    InputStream inputStream;

    public CSVReader(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public List<String[]> read(){
        List<String[]> resultList = new ArrayList<String[]>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try{
            String csvItem;
            while((csvItem = reader.readLine()) != null){
                String[] row = csvItem.split(";");
                resultList.add(row);
            }
        } catch(IOException ex){
            throw new RuntimeException("Error in reading CSV file: "+ ex);
        }
        finally {
            try {
                inputStream.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resultList;
    }
}
