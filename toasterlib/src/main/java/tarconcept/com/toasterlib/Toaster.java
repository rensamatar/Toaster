package tarconcept.com.toasterlib;

import android.content.Context;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Tar on 5/16/17.
 * company : Iwa Labs (Thailand)
 * email : tar@iwa.fi
 */
public class Toaster {

    // Default toast message
    public static void showDefault(Context context, String message) {
        setText(context, message, Duration.LENGTH_LONG, Type.TYPE_INFO);
    }

    // Info
    public static void showInfo(Context context, String message, int duration) {
        setText(context, message, duration, Type.TYPE_INFO);
    }

    // Info with default
    public static void showInfo(Context context, String message) {
        setText(context, message, Duration.LENGTH_LONG, Type.TYPE_INFO);
    }

    // Warning
    public static void showWarning(Context context, String message, int duration) {
        setText(context, message, duration, Type.TYPE_WARNING);
    }

    // Warning with default
    public static void showWarning(Context context, String message) {
        setText(context, message, Duration.LENGTH_LONG, Type.TYPE_WARNING);
    }

    // Error
    public static void showError(Context context, String message, int duration) {
        setText(context, message, duration, Type.TYPE_ERROR);
    }

    // Error with default
    public static void showError(Context context, String message) {
        setText(context, message, Duration.LENGTH_LONG, Type.TYPE_ERROR);
    }

    // Success
    public static void showSuccess(Context context, String message, int duration) {
        setText(context, message, duration, Type.TYPE_SUCCESS);
    }

    // Success with default
    public static void showSuccess(Context context, String message) {
        setText(context, message, Duration.LENGTH_LONG, Type.TYPE_SUCCESS);
    }

    private static void setText(Context context, String message, int duration, Type type) {
        LinearLayout layout = new LinearLayout(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.toaster_layout, null);
        layout.addView(view);

        LinearLayout customToastContainer = (LinearLayout) layout.findViewById(R.id.toaster_container);
        ImageView icon = (ImageView) layout.findViewById(R.id.toaster_icon);
        TextView msg = (TextView) layout.findViewById(R.id.toaster_message);
        msg.setText(message);

        switch (type) {
            case TYPE_WARNING:
                icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_warning));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    customToastContainer.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_warning));
                } else {
                    customToastContainer.setBackgroundColor(ContextCompat.getColor(context, R.color.warning));
                }
                break;
            case TYPE_ERROR:
                icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_error));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    customToastContainer.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_error));
                } else {
                    customToastContainer.setBackgroundColor(ContextCompat.getColor(context, R.color.error));
                }
                break;
            case TYPE_SUCCESS:
                icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_success));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    customToastContainer.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_success));
                } else {
                    customToastContainer.setBackgroundColor(ContextCompat.getColor(context, R.color.success));
                }
                break;
            default:
                icon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_info));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    customToastContainer.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_info));
                } else {
                    customToastContainer.setBackgroundColor(ContextCompat.getColor(context, R.color.info));
                }
                break;
        }

        Toast toast = new Toast(context);
        toast.setDuration(duration);
        toast.setView(layout);
        toast.show();
    }
}
