package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankLotteryTaskItemBinding implements ViewBinding {
    public final CustomCardView bankLotteryTaskCard;
    public final TextView bankLotteryTaskDescription;
    public final ImageView bankLotteryTaskIcon;
    public final ImageView bankLotteryTaskPlatformIcon;
    public final TextView bankLotteryTaskState;
    public final CustomCardView bankLotteryTaskStateBadge;
    public final ImageView bankLotteryTaskStateIcon;
    public final TextView bankLotteryTaskTitle;
    private final CustomCardView rootView;

    private BankLotteryTaskItemBinding(CustomCardView customCardView, CustomCardView customCardView2, TextView textView, ImageView imageView, ImageView imageView2, TextView textView2, CustomCardView customCardView3, ImageView imageView3, TextView textView3) {
        this.rootView = customCardView;
        this.bankLotteryTaskCard = customCardView2;
        this.bankLotteryTaskDescription = textView;
        this.bankLotteryTaskIcon = imageView;
        this.bankLotteryTaskPlatformIcon = imageView2;
        this.bankLotteryTaskState = textView2;
        this.bankLotteryTaskStateBadge = customCardView3;
        this.bankLotteryTaskStateIcon = imageView3;
        this.bankLotteryTaskTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static BankLotteryTaskItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankLotteryTaskItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_lottery_task_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankLotteryTaskItemBinding bind(View view) {
        CustomCardView customCardView = (CustomCardView) view;
        int i = R.id.bank_lottery_task_description;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bank_lottery_task_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.bank_lottery_task_platform_icon;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView2 != null) {
                    i = R.id.bank_lottery_task_state;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.bank_lottery_task_state_badge;
                        CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView2 != null) {
                            i = R.id.bank_lottery_task_state_icon;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView3 != null) {
                                i = R.id.bank_lottery_task_title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    return new BankLotteryTaskItemBinding(customCardView, customCardView, textView, imageView, imageView2, textView2, customCardView2, imageView3, textView3);
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
