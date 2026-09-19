package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class DonatePayPassBinding implements ViewBinding {
    public final ImageView paypassBannerWoman;
    public final TextView paypassDescription;
    public final TextView paypassEmpty;
    public final CustomCardView paypassHeader;
    public final CustomCardView paypassInfoButton;
    public final TextView paypassProgressLabel;
    public final TextView paypassProgressValue;
    public final RecyclerView paypassTiers;
    public final ImageView paypassTimerIcon;
    public final TextView paypassTimerLabel;
    public final TextView paypassTimerValue;
    public final TextView paypassTitle;
    private final FrameLayout rootView;

    private DonatePayPassBinding(FrameLayout rootView, ImageView paypassBannerWoman, TextView paypassDescription, TextView paypassEmpty, CustomCardView paypassHeader, CustomCardView paypassInfoButton, TextView paypassProgressLabel, TextView paypassProgressValue, RecyclerView paypassTiers, ImageView paypassTimerIcon, TextView paypassTimerLabel, TextView paypassTimerValue, TextView paypassTitle) {
        this.rootView = rootView;
        this.paypassBannerWoman = paypassBannerWoman;
        this.paypassDescription = paypassDescription;
        this.paypassEmpty = paypassEmpty;
        this.paypassHeader = paypassHeader;
        this.paypassInfoButton = paypassInfoButton;
        this.paypassProgressLabel = paypassProgressLabel;
        this.paypassProgressValue = paypassProgressValue;
        this.paypassTiers = paypassTiers;
        this.paypassTimerIcon = paypassTimerIcon;
        this.paypassTimerLabel = paypassTimerLabel;
        this.paypassTimerValue = paypassTimerValue;
        this.paypassTitle = paypassTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DonatePayPassBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static DonatePayPassBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.donate_pay_pass, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static DonatePayPassBinding bind(View rootView) {
        int i = R.id.paypass_banner_woman;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.paypass_description;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.paypass_empty;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.paypass_header;
                    CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView != null) {
                        i = R.id.paypass_info_button;
                        CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                        if (customCardView2 != null) {
                            i = R.id.paypass_progress_label;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.paypass_progress_value;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.paypass_tiers;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                    if (recyclerView != null) {
                                        i = R.id.paypass_timer_icon;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView2 != null) {
                                            i = R.id.paypass_timer_label;
                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView5 != null) {
                                                i = R.id.paypass_timer_value;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView6 != null) {
                                                    i = R.id.paypass_title;
                                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView7 != null) {
                                                        return new DonatePayPassBinding((FrameLayout) rootView, imageView, textView, textView2, customCardView, customCardView2, textView3, textView4, recyclerView, imageView2, textView5, textView6, textView7);
                                                    }
                                                }
                                            }
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
