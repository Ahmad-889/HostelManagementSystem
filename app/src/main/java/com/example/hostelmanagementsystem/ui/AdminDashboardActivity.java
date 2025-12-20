package com.example.hostelmanagementsystem.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hostelmanagementsystem.R;
import com.example.hostelmanagementsystem.controller.HMSController;
import com.example.hostelmanagementsystem.model.HostelApplication;
import com.example.hostelmanagementsystem.ui.adapter.ApplicationAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdminDashboardActivity extends AppCompatActivity
        implements ApplicationAdapter.OnApplicationActionListener{

    private TextView tvWelcome, tvApplicationsTitle, tvRoomsTitle;
    private CardView btnApplications, btnRooms;
    private RecyclerView rvApplications;
    private ApplicationAdapter adapter;
    private List<HostelApplication> applicationsList = new ArrayList<>();
    private HMSController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        tvWelcome = findViewById(R.id.tvWelcome);
        btnApplications = findViewById(R.id.btnApplications);
        btnRooms = findViewById(R.id.btnRooms);
        rvApplications = findViewById(R.id.rvApplications);

        LinearLayout appLayout = (LinearLayout) btnApplications.getChildAt(0);
        tvApplicationsTitle = (TextView) appLayout.getChildAt(0);

        LinearLayout roomLayout = (LinearLayout) btnRooms.getChildAt(0);
        tvRoomsTitle = (TextView) roomLayout.getChildAt(0);


        controller = new HMSController();

        // Setup RecyclerView
        rvApplications.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ApplicationAdapter(this, applicationsList, controller, this);
        rvApplications.setAdapter(adapter);


        loadPendingApplications();
        loadAllApplicationsCount();
        loadRoomsCount();

        btnApplications.setOnClickListener(v -> {
            startActivity(new Intent(this, AdminApplicationsActivity.class));
        });

        btnRooms.setOnClickListener(v -> startActivity(new Intent(this, AdminRoomsActivity.class)));
    }


    private void loadPendingApplications() {
        controller.viewPendingApplications(apps -> {
            applicationsList.clear();
            applicationsList.addAll(apps);
            adapter.notifyDataSetChanged();

//            // Update Applications Card title safely
//            String buttonText = "All Applications";
//            if (apps.size() > 0) {
//                buttonText += " (" + apps.size() + ")";
//            }
//
//            // Update TextView in CardView
//            if (btnApplications.getChildCount() > 0) {
//                View innerLayout = btnApplications.getChildAt(0);
//                if (innerLayout instanceof LinearLayout && ((LinearLayout) innerLayout).getChildCount() > 0) {
//                    View textView = ((LinearLayout) innerLayout).getChildAt(0);
//                    if (textView instanceof TextView) {
//                        ((TextView) textView).setText(buttonText);
//                    }
//                }
//            }
        });
    }

    private void loadAllApplicationsCount() {
        controller.getAllApplicationsCount(count -> {
            tvApplicationsTitle.setText("All Applications (" + count + ")");
        });
    }

    private void loadRoomsCount() {
        controller.getAllRoomsCount(count -> {
            tvRoomsTitle.setText("Rooms (" + count + ")");
        });
    }


    @Override
    public void onApplicationUpdated() {
        loadPendingApplications(); // reload pending list
    }


}
