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
public final class HudTaximeterContainerBinding implements ViewBinding {
    public final LinearLayout btnNext;
    public final ImageView ivDopIcon;
    public final LinearLayout linearSum;
    public final LinearLayout linearTime;
    public final ImageView priseTimeContainer;
    private final LinearLayout rootView;
    public final LinearLayout taximeterContainer;
    public final TextView tvTaximeterSum;
    public final TextView tvTaximeterSumTitle;
    public final TextView tvTaximeterTime;
    public final TextView tvType;

    private HudTaximeterContainerBinding(LinearLayout rootView, LinearLayout btnNext, ImageView ivDopIcon, LinearLayout linearSum, LinearLayout linearTime, ImageView priseTimeContainer, LinearLayout taximeterContainer, TextView tvTaximeterSum, TextView tvTaximeterSumTitle, TextView tvTaximeterTime, TextView tvType) {
        this.rootView = rootView;
        this.btnNext = btnNext;
        this.ivDopIcon = ivDopIcon;
        this.linearSum = linearSum;
        this.linearTime = linearTime;
        this.priseTimeContainer = priseTimeContainer;
        this.taximeterContainer = taximeterContainer;
        this.tvTaximeterSum = tvTaximeterSum;
        this.tvTaximeterSumTitle = tvTaximeterSumTitle;
        this.tvTaximeterTime = tvTaximeterTime;
        this.tvType = tvType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static HudTaximeterContainerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTaximeterContainerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_taximeter_container, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTaximeterContainerBinding bind(View rootView) {
        int i = R.id.btn_next;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.iv_dop_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.linearSum;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout2 != null) {
                    i = R.id.linearTime;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout3 != null) {
                        i = R.id.prise_time_container;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView2 != null) {
                            LinearLayout linearLayout4 = (LinearLayout) rootView;
                            i = R.id.tvTaximeterSum;
                            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView != null) {
                                i = R.id.tvTaximeterSumTitle;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.tvTaximeterTime;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        i = R.id.tv_type;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView4 != null) {
                                            return new HudTaximeterContainerBinding(linearLayout4, linearLayout, imageView, linearLayout2, linearLayout3, imageView2, linearLayout4, textView, textView2, textView3, textView4);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
