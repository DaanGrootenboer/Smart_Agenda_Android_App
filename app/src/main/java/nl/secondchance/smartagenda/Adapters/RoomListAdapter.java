package nl.secondchance.smartagenda.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import nl.secondchance.smartagenda.Models.Room;
import nl.secondchance.smartagenda.R;

public class RoomListAdapter extends RecyclerView.Adapter<RoomListAdapter.RoomViewHolder> {

    private List<Room> mRoomsList;

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
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_room, parent, false);

        return new RoomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(RoomViewHolder holder, int position) {
        Room room = mRoomsList.get(position);
        holder.mName.setText(room.getName());
        holder.mTemp.setText(String.valueOf(room.getAverageTemp()));
        holder.mSound.setText(String.valueOf(room.getAverageSound()));
    }

    @Override
    public int getItemCount() {
        return mRoomsList.size();
    }
}
