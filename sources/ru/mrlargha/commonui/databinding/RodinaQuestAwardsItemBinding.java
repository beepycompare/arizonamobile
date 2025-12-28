package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class RodinaQuestAwardsItemBinding implements ViewBinding {
    public final AppCompatImageView rodinaQuestAwardsImage;
    public final ConstraintLayout rodinaQuestAwardsItem;
    public final TextView rodinaQuestInfoTitle;
    private final ConstraintLayout rootView;

    private RodinaQuestAwardsItemBinding(ConstraintLayout rootView, AppCompatImageView rodinaQuestAwardsImage, ConstraintLayout rodinaQuestAwardsItem, TextView rodinaQuestInfoTitle) {
        this.rootView = rootView;
        this.rodinaQuestAwardsImage = rodinaQuestAwardsImage;
        this.rodinaQuestAwardsItem = rodinaQuestAwardsItem;
        this.rodinaQuestInfoTitle = rodinaQuestInfoTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RodinaQuestAwardsItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RodinaQuestAwardsItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.rodina_quest_awards_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RodinaQuestAwardsItemBinding bind(View rootView) {
        int i = R.id.rodina_quest_awards_image;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
            int i2 = R.id.rodina_quest_info_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i2);
            if (textView != null) {
                return new RodinaQuestAwardsItemBinding(constraintLayout, appCompatImageView, constraintLayout, textView);
            }
            i = i2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
