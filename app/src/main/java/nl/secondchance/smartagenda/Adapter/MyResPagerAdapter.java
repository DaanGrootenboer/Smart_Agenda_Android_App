package nl.secondchance.smartagenda.Adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import nl.secondchance.smartagenda.Model.Reservation;
import nl.secondchance.smartagenda.R;

public class MyResPagerAdapter extends PagerAdapter {
    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<Reservation> mReservationsList;

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
        View itemView = mLayoutInflater.inflate(R.layout.fragment_my_res_widget, container, false);

        TextView room = (TextView) itemView.findViewById(R.id.widget_my_res_room);
        TextView date = (TextView) itemView.findViewById(R.id.widget_my_res_date);
        TextView btime = (TextView) itemView.findViewById(R.id.widget_my_res_btime);
        TextView etime = (TextView) itemView.findViewById(R.id.widget_my_res_etime);
        TextView scenario = (TextView) itemView.findViewById(R.id.widget_my_res_scenario);

        room.setText(mReservationsList.get(position).getRoom());
        date.setText(mReservationsList.get(position).getDate());
        btime.setText(mReservationsList.get(position).getBtime());
        etime.setText(mReservationsList.get(position).getEtime());
        scenario.setText(mReservationsList.get(position).getScenario());

        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
