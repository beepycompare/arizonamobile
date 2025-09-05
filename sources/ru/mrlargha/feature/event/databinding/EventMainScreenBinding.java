package ru.mrlargha.feature.event.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.progressindicator.LinearProgressIndicator;
import ru.mrlargha.feature.event.R;
/* loaded from: classes3.dex */
public final class EventMainScreenBinding implements ViewBinding {
    public final ImageView ivVideo;
    public final LinearLayout levelContainer;
    public final TextView levelPassText;
    public final ImageView logo;
    public final TextView mainExperienceText;
    public final LinearProgressIndicator progressExperience;
    public final LinearLayout remainingTime;
    public final TextView remainingTimeTextMain;
    private final ConstraintLayout rootView;
    public final RecyclerView rvPrice;

    private EventMainScreenBinding(ConstraintLayout constraintLayout, ImageView imageView, LinearLayout linearLayout, TextView textView, ImageView imageView2, TextView textView2, LinearProgressIndicator linearProgressIndicator, LinearLayout linearLayout2, TextView textView3, RecyclerView recyclerView) {
        this.rootView = constraintLayout;
        this.ivVideo = imageView;
        this.levelContainer = linearLayout;
        this.levelPassText = textView;
        this.logo = imageView2;
        this.mainExperienceText = textView2;
        this.progressExperience = linearProgressIndicator;
        this.remainingTime = linearLayout2;
        this.remainingTimeTextMain = textView3;
        this.rvPrice = recyclerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EventMainScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EventMainScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.event_main_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EventMainScreenBinding bind(View view) {
        int i = R.id.iv_video;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.level_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.level_pass_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.logo;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.main_experience_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.progress_experience;
                            LinearProgressIndicator linearProgressIndicator = (LinearProgressIndicator) ViewBindings.findChildViewById(view, i);
                            if (linearProgressIndicator != null) {
                                i = R.id.remaining_time;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = R.id.remaining_time_text_main;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.rv_price;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                        if (recyclerView != null) {
                                            return new EventMainScreenBinding((ConstraintLayout) view, imageView, linearLayout, textView, imageView2, textView2, linearProgressIndicator, linearLayout2, textView3, recyclerView);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
