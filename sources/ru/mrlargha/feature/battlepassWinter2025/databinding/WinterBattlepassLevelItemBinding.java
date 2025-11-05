package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassLevelItemBinding implements ViewBinding {
    public final View boost1;
    public final View boost2;
    public final View boost3;
    public final View boost4;
    public final RelativeLayout center;
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
    public final CustomCardView premiumContainerCount;
    public final CustomCardView qualityButton;
    public final CustomCardView qualityButton1;
    private final LinearLayout rootView;
    public final TextView tvPremiumCount;
    public final TextView tvUsuallyCount;
    public final CustomCardView usuallyCountContainer;
    public final View viewAfterLevel;
    public final View viewBeforeLevel;

    private WinterBattlepassLevelItemBinding(LinearLayout linearLayout, View view, View view2, View view3, View view4, RelativeLayout relativeLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, TextView textView, TextView textView2, LinearLayout linearLayout2, FrameLayout frameLayout, LinearLayout linearLayout3, FrameLayout frameLayout2, ImageView imageView7, TextView textView3, CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, TextView textView4, TextView textView5, CustomCardView customCardView4, View view5, View view6) {
        this.rootView = linearLayout;
        this.boost1 = view;
        this.boost2 = view2;
        this.boost3 = view3;
        this.boost4 = view4;
        this.center = relativeLayout;
        this.itemLevelBackgroundPremium = imageView;
        this.itemLevelBackgroundUsual = imageView2;
        this.itemLevelBtnPremium = imageView3;
        this.itemLevelBtnUsually = imageView4;
        this.itemLevelIcPremium = imageView5;
        this.itemLevelIcUsually = imageView6;
        this.itemLevelNamePremium = textView;
        this.itemLevelNameUsually = textView2;
        this.itemLevelPremiumContainer = linearLayout2;
        this.itemLevelPremiumContainerFull = frameLayout;
        this.itemLevelUsuallyContainer = linearLayout3;
        this.itemLevelUsuallyContainerFull = frameLayout2;
        this.levelContainer = imageView7;
        this.levelText = textView3;
        this.premiumContainerCount = customCardView;
        this.qualityButton = customCardView2;
        this.qualityButton1 = customCardView3;
        this.tvPremiumCount = textView4;
        this.tvUsuallyCount = textView5;
        this.usuallyCountContainer = customCardView4;
        this.viewAfterLevel = view5;
        this.viewBeforeLevel = view6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassLevelItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassLevelItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_level_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassLevelItemBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        View findChildViewById5;
        int i = R.id.boost1;
        View findChildViewById6 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById6 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.boost2))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.boost3))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.boost4))) != null) {
            i = R.id.center;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null) {
                i = R.id.item_level_background_premium;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.item_level_background_usual;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.item_level_btn_premium;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView3 != null) {
                            i = R.id.item_level_btn_usually;
                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView4 != null) {
                                i = R.id.item_level_ic_premium;
                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView5 != null) {
                                    i = R.id.item_level_ic_usually;
                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view, i);
                                    if (imageView6 != null) {
                                        i = R.id.item_level_name_premium;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.item_level_name_usually;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.item_level_premium_container;
                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout != null) {
                                                    i = R.id.item_level_premium_container_full;
                                                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                    if (frameLayout != null) {
                                                        i = R.id.item_level_usually_container;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.item_level_usually_container_full;
                                                            FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                            if (frameLayout2 != null) {
                                                                i = R.id.level_container;
                                                                ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView7 != null) {
                                                                    i = R.id.level_text;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView3 != null) {
                                                                        i = R.id.premium_container_count;
                                                                        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                        if (customCardView != null) {
                                                                            i = R.id.quality_button;
                                                                            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                            if (customCardView2 != null) {
                                                                                i = R.id.quality_button1;
                                                                                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                if (customCardView3 != null) {
                                                                                    i = R.id.tv_premium_count;
                                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView4 != null) {
                                                                                        i = R.id.tv_usually_count;
                                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView5 != null) {
                                                                                            i = R.id.usually_count_container;
                                                                                            CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                            if (customCardView4 != null && (findChildViewById4 = ViewBindings.findChildViewById(view, (i = R.id.view_after_level))) != null && (findChildViewById5 = ViewBindings.findChildViewById(view, (i = R.id.view_before_level))) != null) {
                                                                                                return new WinterBattlepassLevelItemBinding((LinearLayout) view, findChildViewById6, findChildViewById, findChildViewById2, findChildViewById3, relativeLayout, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, textView, textView2, linearLayout, frameLayout, linearLayout2, frameLayout2, imageView7, textView3, customCardView, customCardView2, customCardView3, textView4, textView5, customCardView4, findChildViewById4, findChildViewById5);
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
