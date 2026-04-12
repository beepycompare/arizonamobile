package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class HudBodycamBinding implements ViewBinding {
    private final CustomCardView rootView;
    public final TextView tvNumber;
    public final TextView tvStartDate;
    public final TextView tvStartTime;
    public final TextView tvTimer;

    private HudBodycamBinding(CustomCardView rootView, TextView tvNumber, TextView tvStartDate, TextView tvStartTime, TextView tvTimer) {
        this.rootView = rootView;
        this.tvNumber = tvNumber;
        this.tvStartDate = tvStartDate;
        this.tvStartTime = tvStartTime;
        this.tvTimer = tvTimer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static HudBodycamBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudBodycamBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_bodycam, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudBodycamBinding bind(View rootView) {
        int i = R.id.tv_number;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.tv_start_date;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.tv_start_time;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.tv_timer;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        return new HudBodycamBinding((CustomCardView) rootView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
