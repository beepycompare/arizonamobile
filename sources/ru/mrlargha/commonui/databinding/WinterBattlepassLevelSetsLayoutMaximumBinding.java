package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class WinterBattlepassLevelSetsLayoutMaximumBinding implements ViewBinding {
    public final LinearLayout buttonReturn;
    public final ImageView logo;
    public final TextView mainPageTitle;
    private final ConstraintLayout rootView;

    private WinterBattlepassLevelSetsLayoutMaximumBinding(ConstraintLayout rootView, LinearLayout buttonReturn, ImageView logo, TextView mainPageTitle) {
        this.rootView = rootView;
        this.buttonReturn = buttonReturn;
        this.logo = logo;
        this.mainPageTitle = mainPageTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassLevelSetsLayoutMaximumBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassLevelSetsLayoutMaximumBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_level_sets_layout_maximum, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassLevelSetsLayoutMaximumBinding bind(View rootView) {
        int i = R.id.buttonReturn;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null) {
            i = R.id.logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.main_page_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    return new WinterBattlepassLevelSetsLayoutMaximumBinding((ConstraintLayout) rootView, linearLayout, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
