package com.smaboy.pc120.xiuxiu.c.fragment.talking;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smaboy.pc120.xiuxiu.R;

/**
 * Created by Smoboy on 2017/8/7.
 */

public class TalkingRoomFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_talking_room,container,false);
        return view;
    }
}
