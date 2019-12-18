import java.io.Serializable;
import java.util.ArrayList;

//com.example.sony.quote.Filter class in which all the values are stored from filter that's com.example.sony.quote.ListFragment. THE MOST IMPORTANT AND MOST used class
@SuppressWarnings("serial")
public class Filter implements Serializable
{
    static double latitude = 0;
    static double longitude = 0;

    static ArrayList<String >cities = new ArrayList<String>();
    static	String levelAL[] = new String[3];

    static int index;
    static int filtercolor;
    static int flag;

    static String city;
    static int citypos;

    static String boardAL[] = new String[4];
    static String coeducationAL[] = new String[3];
    static String ratingAL[] = new String[5];
    static int numberofschoolselected=0;
    static int school1=-1;
    static int school2=-1;
  static int id1=-1;
    static  int id2=-1;
    static String name1="";
    static  String name2="";
   static  String rating1;
    static  String rating2;
    static String descriptioncompare1 ="";
    static String imagecompare1 = "";

    static String descriptioncompare2 ="";
    static String imagecompare2 = "";
    static Boolean AC;
    static Boolean Wifi;
    static Boolean EducationalTrips;
    static Boolean hostel;
    static Boolean auditorium;


    static Boolean primary;
    static Boolean senior_secondary;
    static Boolean play_school;


    static Boolean CBSE;
    static Boolean ICSE;
    static Boolean IGCSE;
    static Boolean SSC;

    static Boolean girls_only;
    static Boolean boys_only;
    static Boolean coed;

    static Boolean star_1;
    static Boolean star_2;
    static Boolean star_3;
    static Boolean star_4;
    static Boolean star_5;


    ArrayList<Integer> selectedlevel;

    void filter()
    {
        flag = 0;
        index = 0;
        filtercolor = 0;

        citypos = -1;
        city= null;

        auditorium =null;
        AC = null;
        Wifi = false;
        EducationalTrips=null;
        hostel =null;

        primary = null;
        senior_secondary = null;
        play_school = null;

        CBSE = null;
        ICSE = null;
        IGCSE = null;
        SSC = null;

        boys_only = null;
        girls_only = null;
        coed = null;

        star_1 = null;
        star_2 = null;
        star_3 = null;
        star_4 = null;
        star_5 = null;

    }

}
