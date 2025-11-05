package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class RodinaQuestItemBinding implements ViewBinding {
    public final AppCompatImageView awardIcon;
    public final ConstraintLayout doneContainer;
    public final AppCompatImageView doneIcon;
    public final ConstraintLayout getAwardContainer;
    public final TextView rodinaQuestInfoStatText;
    public final TextView rodinaQuestInfoStatTitle;
    public final TextView rodinaQuestInfoTitle;
    public final CardView rodinaQuestItem;
    public final AppCompatImageView rodinaQuestItemBackground;
    public final ConstraintLayout rodinaQuestItemContainer;
    public final AppCompatImageView rodinaQuestItemImage;
    public final ConstraintLayout rodinaQuestItemInfoContainer;
    public final ProgressBar rodinaQuestProgress;
    private final CardView rootView;

    private RodinaQuestItemBinding(CardView rootView, AppCompatImageView awardIcon, ConstraintLayout doneContainer, AppCompatImageView doneIcon, ConstraintLayout getAwardContainer, TextView rodinaQuestInfoStatText, TextView rodinaQuestInfoStatTitle, TextView rodinaQuestInfoTitle, CardView rodinaQuestItem, AppCompatImageView rodinaQuestItemBackground, ConstraintLayout rodinaQuestItemContainer, AppCompatImageView rodinaQuestItemImage, ConstraintLayout rodinaQuestItemInfoContainer, ProgressBar rodinaQuestProgress) {
        this.rootView = rootView;
        this.awardIcon = awardIcon;
        this.doneContainer = doneContainer;
        this.doneIcon = doneIcon;
        this.getAwardContainer = getAwardContainer;
        this.rodinaQuestInfoStatText = rodinaQuestInfoStatText;
        this.rodinaQuestInfoStatTitle = rodinaQuestInfoStatTitle;
        this.rodinaQuestInfoTitle = rodinaQuestInfoTitle;
        this.rodinaQuestItem = rodinaQuestItem;
        this.rodinaQuestItemBackground = rodinaQuestItemBackground;
        this.rodinaQuestItemContainer = rodinaQuestItemContainer;
        this.rodinaQuestItemImage = rodinaQuestItemImage;
        this.rodinaQuestItemInfoContainer = rodinaQuestItemInfoContainer;
        this.rodinaQuestProgress = rodinaQuestProgress;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static RodinaQuestItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RodinaQuestItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.rodina_quest_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RodinaQuestItemBinding bind(View rootView) {
        int i = R.id.award_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.done_container;
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
            if (constraintLayout != null) {
                i = R.id.done_icon;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageView2 != null) {
                    i = R.id.get_award_container;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout2 != null) {
                        i = R.id.rodina_quest_info_stat_text;
                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView != null) {
                            i = R.id.rodina_quest_info_stat_title;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView2 != null) {
                                i = R.id.rodina_quest_info_title;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    CardView cardView = (CardView) rootView;
                                    i = R.id.rodina_quest_item_background;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (appCompatImageView3 != null) {
                                        i = R.id.rodina_quest_item_container;
                                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (constraintLayout3 != null) {
                                            i = R.id.rodina_quest_item_image;
                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                            if (appCompatImageView4 != null) {
                                                i = R.id.rodina_quest_item_info_container;
                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (constraintLayout4 != null) {
                                                    i = R.id.rodina_quest_progress;
                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                                                    if (progressBar != null) {
                                                        return new RodinaQuestItemBinding(cardView, appCompatImageView, constraintLayout, appCompatImageView2, constraintLayout2, textView, textView2, textView3, cardView, appCompatImageView3, constraintLayout3, appCompatImageView4, constraintLayout4, progressBar);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
