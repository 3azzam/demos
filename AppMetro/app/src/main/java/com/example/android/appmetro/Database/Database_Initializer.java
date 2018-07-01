package com.example.android.appmetro.Database;

import android.content.Context;

import com.example.android.appmetro.Station;
import java.util.ArrayList;


public class Database_Initializer {

    private ArrayList<Station> firstLine ;
    private ArrayList<Station> secondLine ;
    private ArrayList<Station> thirdLine ;


    public Database_Initializer(Context context)
    {
        firstLine = new ArrayList<>() ;
        secondLine = new ArrayList<>() ;
        thirdLine = new ArrayList<>() ;

        firstLine = makeLine( firstLineArabic() , firstLineEnglish() , 1) ;
        secondLine = makeLine( secondLineArabic() , secondLineEnglish() ,  2) ;
        thirdLine = makeLine( thirdLineArabic() ,  thirdLineEnglish() , 3 ) ;

        setTransition();

        //createDataBase(context);

    }

    private void createDataBase(Context context)
    {
        DbModel dbModel = new DbModel(context) ;

        for(int i = 0 ; i < firstLine.size() ; i++)
            dbModel.addStationToFirstLine( firstLine.get(i) );

        for(int i = 0 ; i < secondLine.size() ; i++)
            dbModel.addStationToSecondLine( secondLine.get(i) );

        for(int i = 0 ; i < thirdLine.size() ; i++)
            dbModel.addStationToThirdLine(thirdLine.get(i));
    }

    public void setTransition()
    {
        for(int i = 0 ; i < firstLine.size() ; i++)
        {
            if(firstLine.get(i).getArabicName().equals("السادات"))
                firstLine.get(i).setState(2);

            if(firstLine.get(i).getArabicName().equals("الشهداء"))
                firstLine.get(i).setState(2);
        }

        for(int i = 0 ; i < secondLine.size() ; i++)
        {
            if( secondLine.get(i).getArabicName().equals("السادات") )
                secondLine.get(i).setState(1);

            if( secondLine.get(i).getArabicName().equals("الشهداء") )
                secondLine.get(i).setState(1);

            if( secondLine.get(i).getArabicName().equals("العتبة") )
                secondLine.get(i).setState(3);
        }

        for(int i = 0 ; i < thirdLine.size() ; i++)
        {
            if(thirdLine.get(i).getArabicName().equals("العتبة"))
                thirdLine.get(i).setState(2) ;
        }

    }

    public ArrayList<Station> makeLine( ArrayList<String> arabic , ArrayList<String> english , int lineNumber)
    {
        ArrayList<Station> line = new ArrayList<>() ;
        for(int i = 0 ; i < arabic.size() ; i++ )
            line.add( new Station( arabic.get(i) , english.get(i) , i , 0 , lineNumber ) ) ;

        return line ;
    }

    public ArrayList<String> firstLineArabic()
    {
        ArrayList<String> firstLine = new ArrayList<>() ;
        firstLine.add("حلوان") ;
        firstLine.add("عين حلوان") ;
        firstLine.add("جامعة حلوان") ;
        firstLine.add("وادى حوف") ;
        firstLine.add("حدائق حلوان") ;
        firstLine.add("المعصرة") ;
        firstLine.add("طرة الاسمنت") ;
        firstLine.add("كوتسيكا") ;
        firstLine.add("طرة البلد") ;
        firstLine.add("ثكنات المعادى") ;
        firstLine.add("المعادى") ;
        firstLine.add("حدائق المعادى") ;
        firstLine.add("دار السلام") ;
        firstLine.add("الزهراء") ;
        firstLine.add("مار جرجس") ;
        firstLine.add("الملك الصالح") ;
        firstLine.add("السيدة زينب") ;
        firstLine.add("سعد زعلول") ;
        firstLine.add("السادات") ;   /* transition station 1,2 */
        firstLine.add("ناصر") ;
        firstLine.add("عرابى") ;
        firstLine.add("الشهداء") ; /* transition station 1,2 */
        firstLine.add("غمرة") ;
        firstLine.add("الدمرداش") ;
        firstLine.add("منشية الصدر") ;
        firstLine.add("كوبرى القبة") ;
        firstLine.add("حمامات القبة") ;
        firstLine.add("سراى القبة") ;
        firstLine.add("حدائق الزيتون") ;
        firstLine.add("حلمية الزيتون") ;
        firstLine.add("المطرية") ;
        firstLine.add("عين شمس") ;
        firstLine.add("عزبة النخل") ;
        firstLine.add("المرج") ;
        firstLine.add("المرج الجديدة") ;
        return firstLine ;
    }
    public ArrayList<String> firstLineEnglish()
    {
        ArrayList<String> firstLine = new ArrayList<>() ;
        firstLine.add("Helwan") ;
        firstLine.add("Ain Helwan") ;
        firstLine.add("Helwan University") ;
        firstLine.add("Wadi Hof") ;
        firstLine.add("Hadayek Helwan") ;
        firstLine.add("El-Maasara") ;
        firstLine.add("Tora El-Asmant") ;
        firstLine.add("Kozzika") ;
        firstLine.add("Tora El-Balad") ;
        firstLine.add("Sakanat El-Maadi") ;
        firstLine.add("Maadi") ;
        firstLine.add("Hadayek El-Maadi") ;
        firstLine.add("Dar El-Salam") ;
        firstLine.add("El-Zahraa") ;
        firstLine.add("Mar Girgis") ;
        firstLine.add("El-Malek El-Saleh") ;
        firstLine.add("Al-Sayeda Zeinab") ;
        firstLine.add("Saad Zaghloul") ;
        firstLine.add("Sadat") ;   /* transition station 1,2 */
        firstLine.add("Nasser") ;
        firstLine.add("Orabi") ;
        firstLine.add("Al-Shohadaa") ; /* transition station 1,2 */
        firstLine.add("Ghamra") ;
        firstLine.add("El-Demerdash") ;
        firstLine.add("Manshiet El-Sadr") ;
        firstLine.add("Kobri El-Qobba") ;
        firstLine.add("Hammamat El-Qobba") ;
        firstLine.add("Saray El-Qobba") ;
        firstLine.add("Hadayeq El-Zaitoun") ;
        firstLine.add("Helmeyet El-Zaitoun") ;
        firstLine.add("El-Matareyya") ;
        firstLine.add("Ain Shams") ;
        firstLine.add("Ezbet El-Nakhl") ;
        firstLine.add("El-Marg") ;
        firstLine.add("New El-Marg") ;
        return firstLine ;
    }

    public ArrayList<String> secondLineArabic()
    {
        ArrayList<String> secondLine = new ArrayList() ;
        secondLine.add("المنيب");
        secondLine.add("ساقية مكى ");
        secondLine.add("أم المصريين");
        secondLine.add("الجيزة");
        secondLine.add("فيصل");
        secondLine.add("جامعة القاهرة");
        secondLine.add("البحوث");
        secondLine.add("الدقى");
        secondLine.add("الأوبرا");
        secondLine.add("السادات");
        secondLine.add("محمـد نجيب");
        secondLine.add("العتبة");
        secondLine.add("الشهداء");
        secondLine.add("مسرة");
        secondLine.add("روض الفرج");
        secondLine.add("سانتا تريز");
        secondLine.add("الخلفاوى");
        secondLine.add("المظلات");
        secondLine.add("كلية الزراعة");
        secondLine.add("شبرا الخيمة");

        return secondLine ;
    }
    public ArrayList<String> secondLineEnglish()
    {
        ArrayList<String> secondLine = new ArrayList() ;
        secondLine.add("El-Mounib");
        secondLine.add("Sakiat Mekky");
        secondLine.add("Omm El-Masryeen");
        secondLine.add("Giza");
        secondLine.add("Faisal");
        secondLine.add("Cairo University");
        secondLine.add("El Bohoth");
        secondLine.add("Dokki");
        secondLine.add("Opera");
        secondLine.add("Sadat");
        secondLine.add("Mohamed Naguib");
        secondLine.add("Attaba");
        secondLine.add("Al Shohadaa");
        secondLine.add("Masarra");
        secondLine.add("Rod El-Farag");
        secondLine.add("St. Teresa");
        secondLine.add("Khalafawy");
        secondLine.add("Mezallat");
        secondLine.add("Kolleyyet El-Zeraa");
        secondLine.add("Shubra El-Kheima");

        return secondLine ;
    }

    public ArrayList<String> thirdLineArabic()
    {
        ArrayList<String> thirdline = new ArrayList<>() ;

        thirdline.add("الأهرام") ;
        thirdline.add("كلية البنات") ;
        thirdline.add("ستاد القاهرة") ;
        thirdline.add("أرض المعارض") ;
        thirdline.add("العباسية") ;
        thirdline.add("عبده باشا") ;
        thirdline.add("الجيش") ;
        thirdline.add("باب الشعرية") ;
        thirdline.add("العتبة") ;
        return thirdline ;
    }

    public ArrayList<String> thirdLineEnglish()
    {
        ArrayList<String> thirdline = new ArrayList<>() ;
        thirdline.add("Al-Ahram") ;
        thirdline.add("Koleyet El-Banat") ;
        thirdline.add("Stadium") ;
        thirdline.add("Fair Zone") ;
        thirdline.add("Abbassiya") ;
        thirdline.add("Abdou Pasha") ;
        thirdline.add("El-Geish") ;
        thirdline.add("Bab El-Shaaria") ;
        thirdline.add("Attaba") ;

        return thirdline ;
    }


    public ArrayList<Station> getFirstLine() {
        return firstLine;
    }

    public ArrayList<Station> getSecondLine() {
        return secondLine;
    }

    public ArrayList<Station> getThirdLine() {
        return thirdLine;
    }

    public ArrayList<String> getLineNames(int appLanguage)
    {
        ArrayList<String> arr = new ArrayList<>() ;

        if(appLanguage == 0)
        {
             arr.addAll(firstLineArabic()) ;
             arr.addAll(secondLineArabic()) ;
             arr.addAll(thirdLineArabic()) ;
        }
        else
        {
            arr.addAll(firstLineEnglish()) ;
            arr.addAll(secondLineEnglish());
            arr.addAll(thirdLineEnglish()) ;
        }
        return arr ;
    }

}
