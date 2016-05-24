package com.hfad.beeradviser;


import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import java.util.List;


public class FindBeerActivity extends Activity {
    private BeerExpert expert = new BeerExpert();
    //當按鈕被點擊時被呼叫
    public void onClickFindBeer(View view){
        //取得指向TextView的參考
        TextView brands = (TextView)findViewById(R.id.brands);
        //取得指向Spinner的參考
        Spinner color = (Spinner) findViewById(R.id.color);
        //取得在Spinner 中被點選的項目
        String beerType = String.valueOf(color.getSelectedItem());

       //從BeerExpert類別取得建議
         List<String> brandsList = expert.getBrands(beerType);//取得啤酒品牌清單
         StringBuilder brandsFormatted = new StringBuilder();//使用List裡的值建立String
         for(String brand : brandsList){
             brandsFormatted.append(brand).append('\n');//每一行展示一個啤酒品牌
         }
        //展示啤酒
        brands.setText(brandsFormatted);//講最後的結果展示在文字視圖元件
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }
}
