package ru.mrlargha.feature.event.databinding;

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
import ru.mrlargha.feature.event.R;
/* loaded from: classes6.dex */
public final class EventShopSceenBinding implements ViewBinding {
    public final TextView awardName;
    public final TextView count;
    public final FrameLayout itemTop1;
    public final FrameLayout itemTop2;
    public final ImageView ivAward;
    public final FrameLayout result;
    public final LinearLayout resultBack;
    private final LinearLayout rootView;
    public final RecyclerView rvItems;
    public final TextView top1desc;
    public final TextView top1name;
    public final TextView top2desc;
    public final TextView top2name;
    public final TextView tvDescription;

    private EventShopSceenBinding(LinearLayout linearLayout, TextView textView, TextView textView2, FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, FrameLayout frameLayout3, LinearLayout linearLayout2, RecyclerView recyclerView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.rootView = linearLayout;
        this.awardName = textView;
        this.count = textView2;
        this.itemTop1 = frameLayout;
        this.itemTop2 = frameLayout2;
        this.ivAward = imageView;
        this.result = frameLayout3;
        this.resultBack = linearLayout2;
        this.rvItems = recyclerView;
        this.top1desc = textView3;
        this.top1name = textView4;
        this.top2desc = textView5;
        this.top2name = textView6;
        this.tvDescription = textView7;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EventShopSceenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EventShopSceenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.event_shop_sceen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EventShopSceenBinding bind(View view) {
        int i = R.id.award_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.count;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.item_top1;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.item_top2;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout2 != null) {
                        i = R.id.iv_award;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView != null) {
                            i = R.id.result;
                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout3 != null) {
                                i = R.id.result_back;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout != null) {
                                    i = R.id.rv_items;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                    if (recyclerView != null) {
                                        i = R.id.top1desc;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView3 != null) {
                                            i = R.id.top1name;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView4 != null) {
                                                i = R.id.top2desc;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.top2name;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView6 != null) {
                                                        i = R.id.tv_description;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView7 != null) {
                                                            return new EventShopSceenBinding((LinearLayout) view, textView, textView2, frameLayout, frameLayout2, imageView, frameLayout3, linearLayout, recyclerView, textView3, textView4, textView5, textView6, textView7);
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
