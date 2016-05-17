package nl.secondchance.smartagenda.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import nl.secondchance.smartagenda.LoginActivity;
import nl.secondchance.smartagenda.R;

public class AlertDialogFragment extends DialogFragment {

    private String mMessage;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        mMessage = getArguments().getString(LoginActivity.TAG_ERROR_MSG);
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(mMessage)
                .setMessage(context.getString(R.string.error_msg))
                .setPositiveButton(context.getString(R.string.error_positive_button_msg), null);

        AlertDialog dialog = builder.create();
        return dialog;
    }
}