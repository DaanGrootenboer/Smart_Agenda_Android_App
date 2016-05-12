package nl.secondchance.smartagenda;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import nl.secondchance.smartagenda.Adapters.RoomListAdapter;
import nl.secondchance.smartagenda.Fragments.DatePickerFragment;
import nl.secondchance.smartagenda.Fragments.TimePickerFragment;

public class ReservationOverviewActivity extends AppCompatActivity {
    private String roomName;
    private Bundle extras;

    public static final String TAG_VIEW_ID = "View id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_overview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (savedInstanceState == null) {
            extras = getIntent().getExtras();
            if(extras == null) {
                roomName = null;
            } else {
                roomName = extras.getString(RoomListAdapter.TAGROOMNAME);
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(roomName);
                }
            }
        }

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        ButterKnife.bind(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Thank you for your reservation!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @OnClick({R.id.select_begin_time_button, R.id.select_end_time_button})
    public void showTimePickerDialog(View view) {
        DialogFragment newFragment = new TimePickerFragment();
        newFragment.show(getSupportFragmentManager(), "timePicker");
    }

    @OnClick({R.id.select_begin_date_button, R.id.select_end_date_button})
    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

}
