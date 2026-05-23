package ru.mrlargha.feature.arizona.item.rating.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.arizona.item.rating.R;
/* loaded from: classes6.dex */
public final class RatingFullscreenItemBinding implements ViewBinding {
    public final TextView bonusTitle;
    public final CustomCardView cardInfo;
    public final ImageView image;
    public final CustomCardView labelBg;
    public final TextView labelText;
    public final TextView nick;
    public final View overlay;
    public final CustomCardView qualityButton;
    private final ConstraintLayout rootView;
    public final TextView textBonus;
    public final TextView top;

    private RatingFullscreenItemBinding(ConstraintLayout constraintLayout, TextView textView, CustomCardView customCardView, ImageView imageView, CustomCardView customCardView2, TextView textView2, TextView textView3, View view, CustomCardView customCardView3, TextView textView4, TextView textView5) {
        this.rootView = constraintLayout;
        this.bonusTitle = textView;
        this.cardInfo = customCardView;
        this.image = imageView;
        this.labelBg = customCardView2;
        this.labelText = textView2;
        this.nick = textView3;
        this.overlay = view;
        this.qualityButton = customCardView3;
        this.textBonus = textView4;
        this.top = textView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RatingFullscreenItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RatingFullscreenItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.rating_fullscreen_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RatingFullscreenItemBinding bind(View view) {
        View findChildViewById;
        int i = R.id.bonus_title;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.card_info;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView != null) {
                i = R.id.image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.label_bg;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView2 != null) {
                        i = R.id.label_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.nick;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.overlay))) != null) {
                                i = R.id.quality_button;
                                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                if (customCardView3 != null) {
                                    i = R.id.text_bonus;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.top;
                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView5 != null) {
                                            return new RatingFullscreenItemBinding((ConstraintLayout) view, textView, customCardView, imageView, customCardView2, textView2, textView3, findChildViewById, customCardView3, textView4, textView5);
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
