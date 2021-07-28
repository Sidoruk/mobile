package com.sidor.app.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.sidor.app.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private SubsamplingScaleImageView map;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        map = (SubsamplingScaleImageView) root.findViewById(R.id.mapImage);

        RadioGroup LevelGroup=(RadioGroup) root.findViewById(R.id.GroupLevel);
        RadioButton radioButtonLvl1=(RadioButton) root.findViewById(R.id.radioButtonLvl1);
        RadioButton radioButtonLvl2=(RadioButton) root.findViewById(R.id.radioButtonLvl2);
        RadioButton radioButtonLvl3=(RadioButton) root.findViewById(R.id.radioButtonLvl3);
        RadioButton radioButtonLvl4=(RadioButton) root.findViewById(R.id.radioButtonLvl4);
        radioButtonLvl1.setChecked(true);

        map.setImage(ImageSource.resource(R.drawable.level1));

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.radioButtonLvl1:
                        map.setImage(ImageSource.resource(R.drawable.level1));
                        break;
                    case R.id.radioButtonLvl2:
                        map.setImage(ImageSource.resource(R.drawable.level2));
                        break;
                    case R.id.radioButtonLvl3:
                        map.setImage(ImageSource.resource(R.drawable.level3));
                        break;
                    case R.id.radioButtonLvl4:
                        map.setImage(ImageSource.resource(R.drawable.level4));
                        break;
                    default:
                        break;
                }
            }
        };

        radioButtonLvl1.setOnClickListener(onClickListener);
        radioButtonLvl2.setOnClickListener(onClickListener);
        radioButtonLvl3.setOnClickListener(onClickListener);
        radioButtonLvl4.setOnClickListener(onClickListener);

        return root;
    }
}