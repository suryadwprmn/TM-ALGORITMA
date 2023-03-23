package connect;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ConnectServer {


    public int getJumlahData() {
        return jumlahData;
    }

    public void setJumlahData(int jumlahData) {
        this.jumlahData = jumlahData;
    }

    public int getHargaTertinggi() {
        return hargaTertinggi;
    }

    public void setHargaTertinggi(int hargaTertinggi) {
        this.hargaTertinggi = hargaTertinggi;
    }

    private int hargaTertinggi;
    private int jumlahData;
    public void result() throws IOException {
        int AllData = 0;
        int hargaMax =0;
        int count =0;

        ConnectURI connectURI = new ConnectURI();
        URL myAddres = connectURI.buildURL("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = connectURI.getResponseFromHttpurl(myAddres);
        assert response != null;
        JSONArray responJSON = new JSONArray(response);
        ArrayList<Obatobatan> obatobats = new ArrayList<>();
        for (int i = 0; i<responJSON.length();i++){
            Obatobatan obatobat = new Obatobatan();
            JSONObject myJSONObject = responJSON.getJSONObject(i);
            obatobat.setBarcode(myJSONObject.getString("i_barcode"));
            obatobat.setName(myJSONObject.getString("i_name"));
            obatobat.setQty(myJSONObject.getString("i_qty"));
            obatobat.setSell(myJSONObject.getString("i_sell"));
            obatobats.add(obatobat);
        }
        System.out.println("Response");
        for (int index = 0;index<obatobats.size();index++){
            System.out.println("Barcode : " + obatobats.get(index).getBarcode());
            System.out.println("Nama Barang : " + obatobats.get(index).getName());
            System.out.println("Harga : " + obatobats.get(index).getSell());
            System.out.println("Qty : " +obatobats.get(index).getQty());

            int hargaObat = Integer.parseInt(obatobats.get(index).getSell());

            if (count == 0){
                hargaMax = Integer.parseInt(obatobats.get(0).getSell());
            }
            if (hargaObat <=2000){
                count++;
                if (hargaObat > hargaMax){
                    hargaMax =hargaObat;
                }
            }
            AllData = count;
        }

        setJumlahData(AllData);
        setHargaTertinggi(hargaMax);
    }
}
