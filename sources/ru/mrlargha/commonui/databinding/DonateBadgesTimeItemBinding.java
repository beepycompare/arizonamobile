package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class DonateBadgesTimeItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final TextView tvLeftTime;

    private DonateBadgesTimeItemBinding(LinearLayout rootView, TextView tvLeftTime) {
        this.rootView = rootView;
        this.tvLeftTime = tvLeftTime;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DonateBadgesTimeItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonateBadgesTimeItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_badges_time_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonateBadgesTimeItemBinding bind(View rootView) {
        int i = R.id.tv_left_time;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            return new DonateBadgesTimeItemBinding((LinearLayout) rootView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
