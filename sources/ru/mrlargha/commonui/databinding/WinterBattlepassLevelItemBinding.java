package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class WinterBattlepassLevelItemBinding implements ViewBinding {
    public final ImageView itemLevelBackgroundPremium;
    public final ImageView itemLevelBackgroundUsual;
    public final ImageView itemLevelBtnPremium;
    public final ImageView itemLevelBtnUsually;
    public final ImageView itemLevelIcPremium;
    public final ImageView itemLevelIcUsually;
    public final TextView itemLevelNamePremium;
    public final TextView itemLevelNameUsually;
    public final LinearLayout itemLevelPremiumContainer;
    public final FrameLayout itemLevelPremiumContainerFull;
    public final LinearLayout itemLevelUsuallyContainer;
    public final FrameLayout itemLevelUsuallyContainerFull;
    public final ImageView levelContainer;
    public final TextView levelText;
    private final LinearLayout rootView;
    public final View viewAfterLevel;
    public final View viewBeforeLevel;

    private WinterBattlepassLevelItemBinding(LinearLayout rootView, ImageView itemLevelBackgroundPremium, ImageView itemLevelBackgroundUsual, ImageView itemLevelBtnPremium, ImageView itemLevelBtnUsually, ImageView itemLevelIcPremium, ImageView itemLevelIcUsually, TextView itemLevelNamePremium, TextView itemLevelNameUsually, LinearLayout itemLevelPremiumContainer, FrameLayout itemLevelPremiumContainerFull, LinearLayout itemLevelUsuallyContainer, FrameLayout itemLevelUsuallyContainerFull, ImageView levelContainer, TextView levelText, View viewAfterLevel, View viewBeforeLevel) {
        this.rootView = rootView;
        this.itemLevelBackgroundPremium = itemLevelBackgroundPremium;
        this.itemLevelBackgroundUsual = itemLevelBackgroundUsual;
        this.itemLevelBtnPremium = itemLevelBtnPremium;
        this.itemLevelBtnUsually = itemLevelBtnUsually;
        this.itemLevelIcPremium = itemLevelIcPremium;
        this.itemLevelIcUsually = itemLevelIcUsually;
        this.itemLevelNamePremium = itemLevelNamePremium;
        this.itemLevelNameUsually = itemLevelNameUsually;
        this.itemLevelPremiumContainer = itemLevelPremiumContainer;
        this.itemLevelPremiumContainerFull = itemLevelPremiumContainerFull;
        this.itemLevelUsuallyContainer = itemLevelUsuallyContainer;
        this.itemLevelUsuallyContainerFull = itemLevelUsuallyContainerFull;
        this.levelContainer = levelContainer;
        this.levelText = levelText;
        this.viewAfterLevel = viewAfterLevel;
        this.viewBeforeLevel = viewBeforeLevel;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassLevelItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassLevelItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_level_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassLevelItemBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.item_level_background_premium;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.item_level_background_usual;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.item_level_btn_premium;
                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView3 != null) {
                    i = R.id.item_level_btn_usually;
                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView4 != null) {
                        i = R.id.item_level_ic_premium;
                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView5 != null) {
                            i = R.id.item_level_ic_usually;
                            ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView6 != null) {
                                i = R.id.item_level_name_premium;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView != null) {
                                    i = R.id.item_level_name_usually;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView2 != null) {
                                        i = R.id.item_level_premium_container;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout != null) {
                                            i = R.id.item_level_premium_container_full;
                                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (frameLayout != null) {
                                                i = R.id.item_level_usually_container;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (linearLayout2 != null) {
                                                    i = R.id.item_level_usually_container_full;
                                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (frameLayout2 != null) {
                                                        i = R.id.level_container;
                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (imageView7 != null) {
                                                            i = R.id.level_text;
                                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView3 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.view_after_level))) != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.view_before_level))) != null) {
                                                                return new WinterBattlepassLevelItemBinding((LinearLayout) rootView, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, textView, textView2, linearLayout, frameLayout, linearLayout2, frameLayout2, imageView7, textView3, findChildViewById, findChildViewById2);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
