package nl.secondchance.smartagenda.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
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


    private String mName;
    private int mCurrentTemp;
    private int mAverageTemp;
    private int mCurrentSound;
    private int mAverageSound;
    private int mCurrentLight;
    private int mAverageLight;
    private boolean mIsAvailable;
    private boolean mHasScreen;

    public static final String TAG_ROOM_NAME = "Room name";
    public static final String TAG_ROOM_CURRENT_TEMP = "Room name";
    public static final String TAG_ROOM_AVERAGE_TEMP = "Room name";
    public static final String TAG_ROOM_CURRENT_SOUND = "Room name";
    public static final String TAG_ROOM_AVERAGE_SOUND = "Room name";
    public static final String TAG_ROOM_CURRENT_LIGHT = "Room name";
    public static final String TAG_ROOM_AVERAGE_LIGHT = "Room name";
    public static final String TAG_ROOM_IS_AVAILABLE = "Room name";
    public static final String TAG_ROOM_HAS_SCREEN = "Room name";

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
        mContext = holder.itemView.getContext();
        holder.mName.setText(room.getName());
        holder.mTemp.setText(String.valueOf(room.getAverageTemp()));
        holder.mSound.setText(String.valueOf(room.getAverageSound()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(mContext, ReservationOverviewActivity.class);
//                intent.putExtra(TAG_ROOM_NAME, roomName);
//                mContext.startActivity(intent);

                showReservationDialog(room);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mRoomsList.size();
    }

    public void showReservationDialog(final Room room) {
        Activity activity = (Activity) mContext;
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(activity);

        dialogBuilder.setTitle(room.getName());
        LayoutInflater inflater = activity.getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.dialog_room_overview, null);
        dialogBuilder.setView(dialogView);

        dialogBuilder.setPositiveButton(activity.getString(R.string.dialog_room_action_reservation), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                Intent intent = new Intent(mContext, ReservationOverviewActivity.class);
                intent.putExtra(TAG_ROOM_NAME, room.getName());
                intent.putExtra(TAG_ROOM_CURRENT_TEMP, room.getCurrentTemp());
                intent.putExtra(TAG_ROOM_AVERAGE_TEMP, room.getAverageTemp());
                intent.putExtra(TAG_ROOM_CURRENT_SOUND, room.getCurrentSound());
                intent.putExtra(TAG_ROOM_AVERAGE_SOUND, room.getAverageSound());
                intent.putExtra(TAG_ROOM_CURRENT_LIGHT, room.getCurrentLight());
                intent.putExtra(TAG_ROOM_AVERAGE_LIGHT, room.getAverageLight());
                intent.putExtra(TAG_ROOM_IS_AVAILABLE, room.isAvailable());
                intent.putExtra(TAG_ROOM_HAS_SCREEN, room.hasScreen());
                mContext.startActivity(intent);
            }
        });
        dialogBuilder.setNegativeButton(activity.getString(R.string.dialog_action_cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        if (!room.hasScreen()) {
            b.getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(false); //BUTTON1 is positive button
        }
        b.show();
    }

}
