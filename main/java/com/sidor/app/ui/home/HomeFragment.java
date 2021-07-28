package com.sidor.app.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.tabs.TabLayout;
import com.sidor.app.R;

import java.time.DayOfWeek;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    private String[][] Schedule=new String[6][8]; //6 days, 8 lessons. First - number of day
    private TabLayout DayTabs;
    private TabLayout.Tab tab;
    private TextView Class;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        DayTabs=(TabLayout)root.findViewById(R.id.tabLayout3);

        TextView Time1=root.findViewById(R.id.startTime1);
        TextView Time2=root.findViewById(R.id.startTime2);
        TextView Time3=root.findViewById(R.id.startTime3);
        TextView Time4=root.findViewById(R.id.startTime4);
        TextView Time5=root.findViewById(R.id.startTime5);
        TextView Time6=root.findViewById(R.id.startTime6);
        TextView Time7=root.findViewById(R.id.startTime7);
        TextView Time8=root.findViewById(R.id.startTime8);

        TextView Lesson1=root.findViewById(R.id.subj1);
        TextView Lesson2=root.findViewById(R.id.subj2);
        TextView Lesson3=root.findViewById(R.id.subj3);
        TextView Lesson4=root.findViewById(R.id.subj4);
        TextView Lesson5=root.findViewById(R.id.subj5);
        TextView Lesson6=root.findViewById(R.id.subj6);
        TextView Lesson7=root.findViewById(R.id.subj7);
        TextView Lesson8=root.findViewById(R.id.subj8);

        for(int i=0; i<=5; i++){
            Schedule[0][i]=getResources().getString(R.string.disc_algebra);
            Schedule[1][i]=getResources().getString(R.string.disc_english);
            Schedule[2][i]=getResources().getString(R.string.disc_french);
            Schedule[3][i]=getResources().getString(R.string.disc_geometry);
            Schedule[4][i]=getResources().getString(R.string.disc_russian);
            Schedule[5][i]=getResources().getString(R.string.disc_biology);
        }
        Schedule[0][1]=getResources().getString(R.string.disc_geometry);
        Schedule[0][2]=getResources().getString(R.string.disc_biology);
        Schedule[0][3]=getResources().getString(R.string.disc_history);
        Schedule[0][4]=getResources().getString(R.string.disc_english);
        Schedule[0][5]=getResources().getString(R.string.disc_russian);

        Schedule[5][1]=getResources().getString(R.string.disc_physics);
        Schedule[5][2]=getResources().getString(R.string.disc_social);
        Schedule[5][3]=getResources().getString(R.string.disc_history);
        Schedule[5][4]=getResources().getString(R.string.disc_french);
        Schedule[5][5]=getResources().getString(R.string.disc_blanc);

        DayTabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int ChosenDay=DayTabs.getSelectedTabPosition();
                if(ChosenDay==5){
                    Time1.setText(R.string.sat_start1);
                    Time2.setText(R.string.sat_start2);
                    Time3.setText(R.string.sat_start3);
                    Time4.setText(R.string.sat_start4);
                    Time5.setText(R.string.sat_start5);
                    Time6.setText(R.string.sat_start6);
                    Time7.setText(R.string.sat_start7);
                    Time8.setText(R.string.sat_start8);
                }
                else{
                    Time1.setText(R.string.start1);
                    Time2.setText(R.string.start2);
                    Time3.setText(R.string.start3);
                    Time4.setText(R.string.start4);
                    Time5.setText(R.string.start5);
                    Time6.setText(R.string.start6);
                    Time7.setText(R.string.start7);
                    Time8.setText(R.string.start8);
                }

                    Lesson1.setText(Schedule[ChosenDay][0]);
                    Lesson2.setText(Schedule[ChosenDay][1]);
                    Lesson3.setText(Schedule[ChosenDay][2]);
                    Lesson4.setText(Schedule[ChosenDay][3]);
                    Lesson5.setText(Schedule[ChosenDay][4]);
                    Lesson6.setText(Schedule[ChosenDay][5]);
                    Lesson7.setText(Schedule[ChosenDay][6]);
                    if(ChosenDay!=5)
                        Lesson8.setText(Schedule[ChosenDay][7]);
                    else
                        Lesson8.setText(R.string.disc_blanc);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {}

            @Override
            public void onTabReselected(TabLayout.Tab tab) {}
        });

        Calendar calendar=Calendar.getInstance(TimeZone.getTimeZone("Asia/Irkutsk"), new Locale("ru"));
        int DayOfWeek=calendar.get(Calendar.DAY_OF_WEEK);
        int Hours=calendar.get(Calendar.HOUR_OF_DAY);
        int Minutes=calendar.get(Calendar.MINUTE);

        //неделя начинается с ВС=1, потом ПН=2 и т.д. до СБ=7
        if(DayOfWeek==1) //
            DayOfWeek=2;
        else{
            if(Hours>16) //
                DayOfWeek++;
            if(DayOfWeek==8) //
                DayOfWeek=2;
        }
        DayOfWeek-=2;

        tab=DayTabs.getTabAt(DayOfWeek);
        tab.select();
        return root;
    }
}