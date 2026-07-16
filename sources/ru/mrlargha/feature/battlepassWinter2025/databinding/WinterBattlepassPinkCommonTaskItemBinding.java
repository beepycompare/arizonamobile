package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassPinkCommonTaskItemBinding implements ViewBinding {
    public final CustomCardView commonTaskItem;
    public final ProgressBar dayTaskProgressBar;
    public final TextView itemCount;
    public final TextView itemDescription;
    public final CustomCardView itemRewardContainer;
    public final TextView itemRewardDescription;
    public final ImageView itemRewardIc;
    public final TextView itemTitle;
    public final LinearLayout progressDoneContainer;
    public final TextView progressInPercentText;
    private final CustomCardView rootView;

    private WinterBattlepassPinkCommonTaskItemBinding(CustomCardView customCardView, CustomCardView customCardView2, ProgressBar progressBar, TextView textView, TextView textView2, CustomCardView customCardView3, TextView textView3, ImageView imageView, TextView textView4, LinearLayout linearLayout, TextView textView5) {
        this.rootView = customCardView;
        this.commonTaskItem = customCardView2;
        this.dayTaskProgressBar = progressBar;
        this.itemCount = textView;
        this.itemDescription = textView2;
        this.itemRewardContainer = customCardView3;
        this.itemRewardDescription = textView3;
        this.itemRewardIc = imageView;
        this.itemTitle = textView4;
        this.progressDoneContainer = linearLayout;
        this.progressInPercentText = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassPinkCommonTaskItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassPinkCommonTaskItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_pink_common_task_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassPinkCommonTaskItemBinding bind(View view) {
        CustomCardView customCardView = (CustomCardView) view;
        int i = R.id.day_task_progress_bar;
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
        if (progressBar != null) {
            i = R.id.item_count;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.item_description;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.item_reward_container;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView2 != null) {
                        i = R.id.item_reward_description;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.item_reward_ic;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView != null) {
                                i = R.id.item_title;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.progress_done_container;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        i = R.id.progress_in_percent_text;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            return new WinterBattlepassPinkCommonTaskItemBinding(customCardView, customCardView, progressBar, textView, textView2, customCardView2, textView3, imageView, textView4, linearLayout, textView5);
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
