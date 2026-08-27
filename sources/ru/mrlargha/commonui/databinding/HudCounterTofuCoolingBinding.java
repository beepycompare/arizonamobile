package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class HudCounterTofuCoolingBinding implements ViewBinding {
    public final CustomCardView background;
    public final CustomCardView progressFill;
    public final CustomCardView progressTrack;
    private final FrameLayout rootView;
    public final CustomCardView timerContainer;
    public final TextView title;
    public final CustomCardView titleContainer;
    public final ImageView tofuBox;
    public final TextView tvFirst;

    private HudCounterTofuCoolingBinding(FrameLayout rootView, CustomCardView background, CustomCardView progressFill, CustomCardView progressTrack, CustomCardView timerContainer, TextView title, CustomCardView titleContainer, ImageView tofuBox, TextView tvFirst) {
        this.rootView = rootView;
        this.background = background;
        this.progressFill = progressFill;
        this.progressTrack = progressTrack;
        this.timerContainer = timerContainer;
        this.title = title;
        this.titleContainer = titleContainer;
        this.tofuBox = tofuBox;
        this.tvFirst = tvFirst;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudCounterTofuCoolingBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudCounterTofuCoolingBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_counter_tofu_cooling, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudCounterTofuCoolingBinding bind(View rootView) {
        int i = R.id.background;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.progress_fill;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView2 != null) {
                i = R.id.progress_track;
                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                if (customCardView3 != null) {
                    i = R.id.timer_container;
                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView4 != null) {
                        i = R.id.title;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.title_container;
                            CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                            if (customCardView5 != null) {
                                i = R.id.tofu_box;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView != null) {
                                    i = R.id.tv_first;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView2 != null) {
                                        return new HudCounterTofuCoolingBinding((FrameLayout) rootView, customCardView, customCardView2, customCardView3, customCardView4, textView, customCardView5, imageView, textView2);
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
