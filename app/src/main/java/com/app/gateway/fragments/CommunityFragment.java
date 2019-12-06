package com.app.gateway.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.app.gateway.R;
import com.app.gateway.activities.EmergencyNoActivity;
import com.app.gateway.activities.LocalServicesActivity;
import com.app.gateway.activities.NoticeBoardActivity;
import com.app.gateway.activities.NotifyGateActivity;
import com.app.gateway.activities.QuickActionsActivity;
import com.app.gateway.activities.ResidentsActivity;


public class CommunityFragment extends Fragment implements View.OnClickListener {

    private ImageView _localServices,_noticeBoard,_residents,_emergencyNo,_notifyGate,_quickAction;

    public CommunityFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_community, container, false);


        _localServices=view.findViewById(R.id.localServices_IMG);
        _localServices.setOnClickListener(this);

        _noticeBoard=view.findViewById(R.id.noticeBoard_IMG);
        _noticeBoard.setOnClickListener(this);

        _residents=view.findViewById(R.id.residents_IMG);
        _residents.setOnClickListener(this);

        _emergencyNo=view.findViewById(R.id.emergencyNo_IMG);
        _emergencyNo.setOnClickListener(this);

        _notifyGate=view.findViewById(R.id.notifyGate_IMG);
        _notifyGate.setOnClickListener(this);

        _quickAction=view.findViewById(R.id.quickAction_IMG);
        _quickAction.setOnClickListener(this);




        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.localServices_IMG:
                /* Intent intent = new Intent(CommunityFragment.this,LocalServicesActivity.class);
          startActivity(intent);*/
         //Imp.
         startActivity(new Intent(getActivity(),LocalServicesActivity.class));
         break;

            case R.id.noticeBoard_IMG:
                /* Intent intent = new Intent(CommunityFragment.this,LocalServicesActivity.class);
          startActivity(intent);*/
                //Imp.
                startActivity(new Intent(getActivity(), NoticeBoardActivity.class));
                break;

            case R.id.residents_IMG:
                /* Intent intent = new Intent(CommunityFragment.this,LocalServicesActivity.class);
          startActivity(intent);*/
                //Imp.
                startActivity(new Intent(getActivity(), ResidentsActivity.class));
                break;

            case R.id.emergencyNo_IMG:
                /* Intent intent = new Intent(CommunityFragment.this,LocalServicesActivity.class);
          startActivity(intent);*/
                //Imp.
                startActivity(new Intent(getActivity(), EmergencyNoActivity.class));
                break;

            case R.id.notifyGate_IMG:
                /* Intent intent = new Intent(CommunityFragment.this,LocalServicesActivity.class);
          startActivity(intent);*/
                //Imp.
                startActivity(new Intent(getActivity(), NotifyGateActivity.class));
                break;

            case R.id.quickAction_IMG:
                /* Intent intent = new Intent(CommunityFragment.this,LocalServicesActivity.class);
          startActivity(intent);*/
                //Imp.
                startActivity(new Intent(getActivity(), QuickActionsActivity.class));
                break;

        }
    }

}
