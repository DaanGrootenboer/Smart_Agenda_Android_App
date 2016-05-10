package nl.secondchance.smartagenda.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import nl.secondchance.smartagenda.Models.Reservation;
import nl.secondchance.smartagenda.R;

public class MyResPagerAdapter extends PagerAdapter {
    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<Reservation> mReservationsList;

    @Bind(R.id.widget_my_res_room) TextView mRoom;
    @Bind(R.id.widget_my_res_bdate) TextView mBdate;
    @Bind(R.id.widget_my_res_edate) TextView mEdate;
    @Bind(R.id.widget_my_res_btime) TextView mBtime;
    @Bind(R.id.widget_my_res_etime) TextView mEtime;
    @Bind(R.id.widget_my_res_scenario) TextView mScenario;
    @Bind(R.id.widget_my_res_room_next) ImageButton mNextRoom;
    @Bind(R.id.widget_my_res_room_prev) ImageButton mPrevRoom;

    public MyResPagerAdapter(Context context, ArrayList<Reservation> list) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mReservationsList = list;
    }

    @Override
    public int getCount() {
        return mReservationsList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.slide_item_my_res_widget, container, false);

        ButterKnife.bind(this, itemView);

        mRoom.setText(mReservationsList.get(position).getRoom());
        mBdate.setText(mReservationsList.get(position).getBdate());
        mEdate.setText(mReservationsList.get(position).getEdate());
        mBtime.setText(mReservationsList.get(position).getBtime());
        mEtime.setText(mReservationsList.get(position).getEtime());
        mScenario.setText(mReservationsList.get(position).getScenario());

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
