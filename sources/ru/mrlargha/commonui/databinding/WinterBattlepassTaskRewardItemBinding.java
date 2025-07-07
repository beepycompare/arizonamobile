package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class WinterBattlepassTaskRewardItemBinding implements ViewBinding {
    private final LinearLayout rootView;
    public final ImageView taskInfoRewardItemImage;
    public final TextView taskInfoRewardItemName;

    private WinterBattlepassTaskRewardItemBinding(LinearLayout rootView, ImageView taskInfoRewardItemImage, TextView taskInfoRewardItemName) {
        this.rootView = rootView;
        this.taskInfoRewardItemImage = taskInfoRewardItemImage;
        this.taskInfoRewardItemName = taskInfoRewardItemName;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassTaskRewardItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassTaskRewardItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_task_reward_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassTaskRewardItemBinding bind(View rootView) {
        int i = R.id.task_info_reward_item_image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.task_info_reward_item_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new WinterBattlepassTaskRewardItemBinding((LinearLayout) rootView, imageView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
