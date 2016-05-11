package nl.secondchance.smartagenda.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nl.secondchance.smartagenda.Models.Room;
import nl.secondchance.smartagenda.R;
import nl.secondchance.smartagenda.ReservationOverviewActivity;

public class RoomListAdapter extends RecyclerView.Adapter<RoomListAdapter.RoomViewHolder> {

    private List<Room> mRoomsList;
    private Context mContext;

    public static final String TAGROOMNAME = "Room name";

    public class RoomViewHolder extends RecyclerView.ViewHolder {
        public TextView mName, mTemp, mSound;

        public RoomViewHolder(View view) {
            super(view);
            mName = (TextView) view.findViewById(R.id.list_item_room_name);
            mTemp = (TextView) view.findViewById(R.id.list_item_room_temp);
            mSound = (TextView) view.findViewById(R.id.list_item_room_sound);
        }
    }


    public RoomListAdapter(List<Room> roomsList) {
        this.mRoomsList = roomsList;
    }

    @Override
    public RoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_room, parent, false);

        return new RoomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final RoomViewHolder holder, int position) {
        final Room room = mRoomsList.get(position);
        final String roomName = room.getName();
        mContext = holder.itemView.getContext();
        holder.mName.setText(room.getName());
        holder.mTemp.setText(String.valueOf(room.getAverageTemp()));
        holder.mSound.setText(String.valueOf(room.getAverageSound()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReservationOverviewActivity.class);
                intent.putExtra(TAGROOMNAME, roomName);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRoomsList.size();
    }
}
