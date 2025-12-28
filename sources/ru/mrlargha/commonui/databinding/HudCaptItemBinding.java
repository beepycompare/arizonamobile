package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class HudCaptItemBinding implements ViewBinding {
    public final ImageView ivScore;
    private final LinearLayout rootView;
    public final TextView tvKillsCount;
    public final TextView tvName;
    public final TextView tvNumbering;
    public final TextView tvPeopleCount;

    private HudCaptItemBinding(LinearLayout rootView, ImageView ivScore, TextView tvKillsCount, TextView tvName, TextView tvNumbering, TextView tvPeopleCount) {
        this.rootView = rootView;
        this.ivScore = ivScore;
        this.tvKillsCount = tvKillsCount;
        this.tvName = tvName;
        this.tvNumbering = tvNumbering;
        this.tvPeopleCount = tvPeopleCount;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HudCaptItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudCaptItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_capt_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudCaptItemBinding bind(View rootView) {
        int i = R.id.iv_score;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.tv_kills_count;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tv_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.tv_numbering;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.tv_people_count;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            return new HudCaptItemBinding((LinearLayout) rootView, imageView, textView, textView2, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
