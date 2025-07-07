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
public final class EasterBattlePassShopSceenBinding implements ViewBinding {
    public final TextView awardName;
    public final TextView count;
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

    private EasterBattlePassShopSceenBinding(LinearLayout rootView, TextView awardName, TextView count, ImageView ivAward, FrameLayout result, LinearLayout resultBack, RecyclerView rvItems, TextView top1desc, TextView top1name, TextView top2desc, TextView top2name, TextView tvDescription) {
        this.rootView = rootView;
        this.awardName = awardName;
        this.count = count;
        this.ivAward = ivAward;
        this.result = result;
        this.resultBack = resultBack;
        this.rvItems = rvItems;
        this.top1desc = top1desc;
        this.top1name = top1name;
        this.top2desc = top2desc;
        this.top2name = top2name;
        this.tvDescription = tvDescription;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EasterBattlePassShopSceenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EasterBattlePassShopSceenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.easter_battle_pass_shop_sceen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EasterBattlePassShopSceenBinding bind(View rootView) {
        int i = R.id.award_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.count;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.iv_award;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    i = R.id.result;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                    if (frameLayout != null) {
                        i = R.id.result_back;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                        if (linearLayout != null) {
                            i = R.id.rv_items;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                            if (recyclerView != null) {
                                i = R.id.top1desc;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    i = R.id.top1name;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView4 != null) {
                                        i = R.id.top2desc;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView5 != null) {
                                            i = R.id.top2name;
                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView6 != null) {
                                                i = R.id.tv_description;
                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView7 != null) {
                                                    return new EasterBattlePassShopSceenBinding((LinearLayout) rootView, textView, textView2, imageView, frameLayout, linearLayout, recyclerView, textView3, textView4, textView5, textView6, textView7);
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
