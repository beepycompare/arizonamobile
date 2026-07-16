package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassLevelSetsLayoutMaximumBinding implements ViewBinding {
    public final LinearLayout buttonReturn;
    public final ImageView logo;
    public final TextView mainPageTitle;
    private final FrameLayout rootView;

    private WinterBattlepassLevelSetsLayoutMaximumBinding(FrameLayout frameLayout, LinearLayout linearLayout, ImageView imageView, TextView textView) {
        this.rootView = frameLayout;
        this.buttonReturn = linearLayout;
        this.logo = imageView;
        this.mainPageTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassLevelSetsLayoutMaximumBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassLevelSetsLayoutMaximumBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_level_sets_layout_maximum, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassLevelSetsLayoutMaximumBinding bind(View view) {
        int i = R.id.buttonReturn;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.logo;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.main_page_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new WinterBattlepassLevelSetsLayoutMaximumBinding((FrameLayout) view, linearLayout, imageView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
