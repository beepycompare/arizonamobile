package com.arizonagames.feature.minigames.conveyor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.minigames.conveyor.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class ConveyorGameScreenBinding implements ViewBinding {
    public final ImageView ageLabel;
    public final FrameLayout ageLocker;
    public final FrameLayout btnCloseScreen;
    public final CustomCardView buttonClose;
    public final CustomCardView buttonPlay;
    public final FrameLayout conveyorGameContainer;
    public final LinearLayout counterContainer;
    public final TextView gameTitle;
    public final FrameLayout itemContainer;
    public final ImageView ivDefaultItem;
    public final CustomCardView leftContainer;
    public final TextView leftItem;
    private final FrameLayout rootView;
    public final RecyclerView rvBoxes;
    public final RecyclerView rvItems;
    public final FrameLayout topElementsContainer;
    public final TextView tvHint;

    private ConveyorGameScreenBinding(FrameLayout frameLayout, ImageView imageView, FrameLayout frameLayout2, FrameLayout frameLayout3, CustomCardView customCardView, CustomCardView customCardView2, FrameLayout frameLayout4, LinearLayout linearLayout, TextView textView, FrameLayout frameLayout5, ImageView imageView2, CustomCardView customCardView3, TextView textView2, RecyclerView recyclerView, RecyclerView recyclerView2, FrameLayout frameLayout6, TextView textView3) {
        this.rootView = frameLayout;
        this.ageLabel = imageView;
        this.ageLocker = frameLayout2;
        this.btnCloseScreen = frameLayout3;
        this.buttonClose = customCardView;
        this.buttonPlay = customCardView2;
        this.conveyorGameContainer = frameLayout4;
        this.counterContainer = linearLayout;
        this.gameTitle = textView;
        this.itemContainer = frameLayout5;
        this.ivDefaultItem = imageView2;
        this.leftContainer = customCardView3;
        this.leftItem = textView2;
        this.rvBoxes = recyclerView;
        this.rvItems = recyclerView2;
        this.topElementsContainer = frameLayout6;
        this.tvHint = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ConveyorGameScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ConveyorGameScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.conveyor_game_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ConveyorGameScreenBinding bind(View view) {
        int i = R.id.age_label;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.age_locker;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.btn_close_screen;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout2 != null) {
                    i = R.id.button_close;
                    CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView != null) {
                        i = R.id.button_play;
                        CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView2 != null) {
                            FrameLayout frameLayout3 = (FrameLayout) view;
                            i = R.id.counter_container;
                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout != null) {
                                i = R.id.game_title;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView != null) {
                                    i = R.id.item_container;
                                    FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                    if (frameLayout4 != null) {
                                        i = R.id.iv_default_item;
                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView2 != null) {
                                            i = R.id.left_container;
                                            CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                            if (customCardView3 != null) {
                                                i = R.id.left_item;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.rv_boxes;
                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                    if (recyclerView != null) {
                                                        i = R.id.rv_items;
                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                        if (recyclerView2 != null) {
                                                            i = R.id.top_elements_container;
                                                            FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                            if (frameLayout5 != null) {
                                                                i = R.id.tv_hint;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView3 != null) {
                                                                    return new ConveyorGameScreenBinding(frameLayout3, imageView, frameLayout, frameLayout2, customCardView, customCardView2, frameLayout3, linearLayout, textView, frameLayout4, imageView2, customCardView3, textView2, recyclerView, recyclerView2, frameLayout5, textView3);
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
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
