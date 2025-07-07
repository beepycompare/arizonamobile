package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AzBattlepassCommonTaskItemBinding implements ViewBinding {
    public final ConstraintLayout commonTaskItem;
    public final ProgressBar dayTaskProgressBar;
    public final TextView itemCount;
    public final TextView itemDescription;
    public final ConstraintLayout itemRewardContainer;
    public final TextView itemRewardDescription;
    public final ImageView itemRewardIc;
    public final TextView itemTitle;
    private final ConstraintLayout rootView;

    private AzBattlepassCommonTaskItemBinding(ConstraintLayout rootView, ConstraintLayout commonTaskItem, ProgressBar dayTaskProgressBar, TextView itemCount, TextView itemDescription, ConstraintLayout itemRewardContainer, TextView itemRewardDescription, ImageView itemRewardIc, TextView itemTitle) {
        this.rootView = rootView;
        this.commonTaskItem = commonTaskItem;
        this.dayTaskProgressBar = dayTaskProgressBar;
        this.itemCount = itemCount;
        this.itemDescription = itemDescription;
        this.itemRewardContainer = itemRewardContainer;
        this.itemRewardDescription = itemRewardDescription;
        this.itemRewardIc = itemRewardIc;
        this.itemTitle = itemTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AzBattlepassCommonTaskItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AzBattlepassCommonTaskItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.az_battlepass_common_task_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AzBattlepassCommonTaskItemBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.day_task_progress_bar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
        if (progressBar != null) {
            i = R.id.item_count;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.item_description;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.item_reward_container;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout2 != null) {
                        i = R.id.item_reward_description;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.item_reward_ic;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView != null) {
                                i = R.id.item_title;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    return new AzBattlepassCommonTaskItemBinding(constraintLayout, constraintLayout, progressBar, textView, textView2, constraintLayout2, textView3, imageView, textView4);
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
