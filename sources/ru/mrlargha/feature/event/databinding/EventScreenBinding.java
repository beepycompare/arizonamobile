package ru.mrlargha.feature.event.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.event.R;
/* loaded from: classes6.dex */
public final class EventScreenBinding implements ViewBinding {
    public final LinearLayout bg;
    public final ConstraintLayout easterBattlepassChoose;
    public final EventEventsScreenBinding events;
    public final TextView infoText;
    public final FrameLayout infoTextBg;
    public final EventMainScreenBinding main;
    public final PiratesRatingScreenBinding rating;
    public final EventMainResultScreenBinding resultMain;
    private final ConstraintLayout rootView;
    public final PiratesShipScreenBinding ship;
    public final EventShopSceenBinding shop;
    public final EventTaskScreenBinding task;
    public final EventTopbarBinding topElements;
    public final EventVideoScreenBinding video;

    private EventScreenBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, ConstraintLayout constraintLayout2, EventEventsScreenBinding eventEventsScreenBinding, TextView textView, FrameLayout frameLayout, EventMainScreenBinding eventMainScreenBinding, PiratesRatingScreenBinding piratesRatingScreenBinding, EventMainResultScreenBinding eventMainResultScreenBinding, PiratesShipScreenBinding piratesShipScreenBinding, EventShopSceenBinding eventShopSceenBinding, EventTaskScreenBinding eventTaskScreenBinding, EventTopbarBinding eventTopbarBinding, EventVideoScreenBinding eventVideoScreenBinding) {
        this.rootView = constraintLayout;
        this.bg = linearLayout;
        this.easterBattlepassChoose = constraintLayout2;
        this.events = eventEventsScreenBinding;
        this.infoText = textView;
        this.infoTextBg = frameLayout;
        this.main = eventMainScreenBinding;
        this.rating = piratesRatingScreenBinding;
        this.resultMain = eventMainResultScreenBinding;
        this.ship = piratesShipScreenBinding;
        this.shop = eventShopSceenBinding;
        this.task = eventTaskScreenBinding;
        this.topElements = eventTopbarBinding;
        this.video = eventVideoScreenBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EventScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EventScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.event_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EventScreenBinding bind(View view) {
        View findChildViewById;
        int i = R.id.bg;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.events;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i);
            if (findChildViewById2 != null) {
                EventEventsScreenBinding bind = EventEventsScreenBinding.bind(findChildViewById2);
                i = R.id.info_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.info_text_bg;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.main))) != null) {
                        EventMainScreenBinding bind2 = EventMainScreenBinding.bind(findChildViewById);
                        i = R.id.rating;
                        View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                        if (findChildViewById3 != null) {
                            PiratesRatingScreenBinding bind3 = PiratesRatingScreenBinding.bind(findChildViewById3);
                            i = R.id.result_main;
                            View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                            if (findChildViewById4 != null) {
                                EventMainResultScreenBinding bind4 = EventMainResultScreenBinding.bind(findChildViewById4);
                                i = R.id.ship;
                                View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                                if (findChildViewById5 != null) {
                                    PiratesShipScreenBinding bind5 = PiratesShipScreenBinding.bind(findChildViewById5);
                                    i = R.id.shop;
                                    View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                                    if (findChildViewById6 != null) {
                                        EventShopSceenBinding bind6 = EventShopSceenBinding.bind(findChildViewById6);
                                        i = R.id.task;
                                        View findChildViewById7 = ViewBindings.findChildViewById(view, i);
                                        if (findChildViewById7 != null) {
                                            EventTaskScreenBinding bind7 = EventTaskScreenBinding.bind(findChildViewById7);
                                            i = R.id.top_elements;
                                            View findChildViewById8 = ViewBindings.findChildViewById(view, i);
                                            if (findChildViewById8 != null) {
                                                EventTopbarBinding bind8 = EventTopbarBinding.bind(findChildViewById8);
                                                i = R.id.video;
                                                View findChildViewById9 = ViewBindings.findChildViewById(view, i);
                                                if (findChildViewById9 != null) {
                                                    return new EventScreenBinding(constraintLayout, linearLayout, constraintLayout, bind, textView, frameLayout, bind2, bind3, bind4, bind5, bind6, bind7, bind8, EventVideoScreenBinding.bind(findChildViewById9));
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
