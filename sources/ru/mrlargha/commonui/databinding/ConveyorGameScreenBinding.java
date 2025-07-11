package ru.mrlargha.commonui.databinding;

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
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ConveyorGameScreenBinding implements ViewBinding {
    public final FrameLayout btnCloseScreen;
    public final FrameLayout conveyorGameContainer;
    public final TextView gameTitle;
    public final FrameLayout itemContainer;
    public final ImageView ivDefaultItem;
    public final LinearLayout leftContainer;
    public final TextView leftItem;
    private final FrameLayout rootView;
    public final RecyclerView rvBoxes;
    public final RecyclerView rvItems;
    public final FrameLayout topElementsContainer;
    public final TextView tvHint;

    private ConveyorGameScreenBinding(FrameLayout rootView, FrameLayout btnCloseScreen, FrameLayout conveyorGameContainer, TextView gameTitle, FrameLayout itemContainer, ImageView ivDefaultItem, LinearLayout leftContainer, TextView leftItem, RecyclerView rvBoxes, RecyclerView rvItems, FrameLayout topElementsContainer, TextView tvHint) {
        this.rootView = rootView;
        this.btnCloseScreen = btnCloseScreen;
        this.conveyorGameContainer = conveyorGameContainer;
        this.gameTitle = gameTitle;
        this.itemContainer = itemContainer;
        this.ivDefaultItem = ivDefaultItem;
        this.leftContainer = leftContainer;
        this.leftItem = leftItem;
        this.rvBoxes = rvBoxes;
        this.rvItems = rvItems;
        this.topElementsContainer = topElementsContainer;
        this.tvHint = tvHint;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static ConveyorGameScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ConveyorGameScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.conveyor_game_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ConveyorGameScreenBinding bind(View rootView) {
        int i = R.id.btn_close_screen;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
        if (frameLayout != null) {
            FrameLayout frameLayout2 = (FrameLayout) rootView;
            i = R.id.game_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.item_container;
                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                if (frameLayout3 != null) {
                    i = R.id.iv_default_item;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView != null) {
                        i = R.id.left_container;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            i = R.id.left_item;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.rv_boxes;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                if (recyclerView != null) {
                                    i = R.id.rv_items;
                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                    if (recyclerView2 != null) {
                                        i = R.id.top_elements_container;
                                        FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (frameLayout4 != null) {
                                            i = R.id.tv_hint;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null) {
                                                return new ConveyorGameScreenBinding(frameLayout2, frameLayout, frameLayout2, textView, frameLayout3, imageView, linearLayout, textView2, recyclerView, recyclerView2, frameLayout4, textView3);
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
