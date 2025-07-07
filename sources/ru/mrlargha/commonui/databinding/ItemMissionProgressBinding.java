package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemMissionProgressBinding implements ViewBinding {
    public final AppCompatImageView icDone;
    public final TextView missionText;
    public final LinearProgressIndicator progressBar;
    public final TextView progressText;
    private final CardView rootView;

    private ItemMissionProgressBinding(CardView rootView, AppCompatImageView icDone, TextView missionText, LinearProgressIndicator progressBar, TextView progressText) {
        this.rootView = rootView;
        this.icDone = icDone;
        this.missionText = missionText;
        this.progressBar = progressBar;
        this.progressText = progressText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemMissionProgressBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemMissionProgressBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_mission_progress, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemMissionProgressBinding bind(View rootView) {
        int i = R.id.ic_done;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.mission_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.progressBar;
                LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(rootView, i);
                if (linearProgressIndicator != null) {
                    i = R.id.progress_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new ItemMissionProgressBinding((CardView) rootView, appCompatImageView, textView, linearProgressIndicator, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
