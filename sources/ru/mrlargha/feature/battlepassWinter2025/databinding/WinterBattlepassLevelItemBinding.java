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
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassLevelItemBinding implements ViewBinding {
    public final View boost1;
    public final View boost2;
    public final View boost3;
    public final View boost4;
    public final FrameLayout center;
    public final CustomCardView itemLevelBackgroundPremium;
    public final CustomCardView itemLevelBackgroundUsual;
    public final CustomCardView itemLevelBtnPremium;
    public final TextView itemLevelBtnPremiumText;
    public final CustomCardView itemLevelBtnUsually;
    public final TextView itemLevelBtnUsuallyText;
    public final ImageView itemLevelIcPremium;
    public final ImageView itemLevelIcUsually;
    public final ImageView itemLevelLockPremium;
    public final ImageView itemLevelLockUsually;
    public final TextView itemLevelNamePremium;
    public final TextView itemLevelNameUsually;
    public final FrameLayout itemLevelPremiumContainer;
    public final CustomCardView itemLevelPremiumContainerFull;
    public final LinearLayout itemLevelReceivedPremium;
    public final LinearLayout itemLevelReceivedUsually;
    public final FrameLayout itemLevelUsuallyContainer;
    public final CustomCardView itemLevelUsuallyContainerFull;
    public final ImageView levelContainer;
    public final TextView levelText;
    public final CustomCardView premiumContainerCount;
    public final CustomCardView qualityButton;
    public final CustomCardView qualityButton1;
    private final LinearLayout rootView;
    public final TextView tvPremiumCount;
    public final TextView tvUsuallyCount;
    public final CustomCardView usuallyCountContainer;
    public final CustomCardView viewAfterLevel;
    public final CustomCardView viewBeforeLevel;

    private WinterBattlepassLevelItemBinding(LinearLayout linearLayout, View view, View view2, View view3, View view4, FrameLayout frameLayout, CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, TextView textView, CustomCardView customCardView4, TextView textView2, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView3, TextView textView4, FrameLayout frameLayout2, CustomCardView customCardView5, LinearLayout linearLayout2, LinearLayout linearLayout3, FrameLayout frameLayout3, CustomCardView customCardView6, ImageView imageView5, TextView textView5, CustomCardView customCardView7, CustomCardView customCardView8, CustomCardView customCardView9, TextView textView6, TextView textView7, CustomCardView customCardView10, CustomCardView customCardView11, CustomCardView customCardView12) {
        this.rootView = linearLayout;
        this.boost1 = view;
        this.boost2 = view2;
        this.boost3 = view3;
        this.boost4 = view4;
        this.center = frameLayout;
        this.itemLevelBackgroundPremium = customCardView;
        this.itemLevelBackgroundUsual = customCardView2;
        this.itemLevelBtnPremium = customCardView3;
        this.itemLevelBtnPremiumText = textView;
        this.itemLevelBtnUsually = customCardView4;
        this.itemLevelBtnUsuallyText = textView2;
        this.itemLevelIcPremium = imageView;
        this.itemLevelIcUsually = imageView2;
        this.itemLevelLockPremium = imageView3;
        this.itemLevelLockUsually = imageView4;
        this.itemLevelNamePremium = textView3;
        this.itemLevelNameUsually = textView4;
        this.itemLevelPremiumContainer = frameLayout2;
        this.itemLevelPremiumContainerFull = customCardView5;
        this.itemLevelReceivedPremium = linearLayout2;
        this.itemLevelReceivedUsually = linearLayout3;
        this.itemLevelUsuallyContainer = frameLayout3;
        this.itemLevelUsuallyContainerFull = customCardView6;
        this.levelContainer = imageView5;
        this.levelText = textView5;
        this.premiumContainerCount = customCardView7;
        this.qualityButton = customCardView8;
        this.qualityButton1 = customCardView9;
        this.tvPremiumCount = textView6;
        this.tvUsuallyCount = textView7;
        this.usuallyCountContainer = customCardView10;
        this.viewAfterLevel = customCardView11;
        this.viewBeforeLevel = customCardView12;
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
        int i = R.id.boost1;
        View findChildViewById4 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById4 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.boost2))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.boost3))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.boost4))) != null) {
            i = R.id.center;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.item_level_background_premium;
                CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView != null) {
                    i = R.id.item_level_background_usual;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView2 != null) {
                        i = R.id.item_level_btn_premium;
                        CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView3 != null) {
                            i = R.id.item_level_btn_premium_text;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView != null) {
                                i = R.id.item_level_btn_usually;
                                CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                if (customCardView4 != null) {
                                    i = R.id.item_level_btn_usually_text;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.item_level_ic_premium;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView != null) {
                                            i = R.id.item_level_ic_usually;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView2 != null) {
                                                i = R.id.item_level_lock_premium;
                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView3 != null) {
                                                    i = R.id.item_level_lock_usually;
                                                    ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView4 != null) {
                                                        i = R.id.item_level_name_premium;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.item_level_name_usually;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.item_level_premium_container;
                                                                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                if (frameLayout2 != null) {
                                                                    i = R.id.item_level_premium_container_full;
                                                                    CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                    if (customCardView5 != null) {
                                                                        i = R.id.item_level_received_premium;
                                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout != null) {
                                                                            i = R.id.item_level_received_usually;
                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout2 != null) {
                                                                                i = R.id.item_level_usually_container;
                                                                                FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (frameLayout3 != null) {
                                                                                    i = R.id.item_level_usually_container_full;
                                                                                    CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                    if (customCardView6 != null) {
                                                                                        i = R.id.level_container;
                                                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                        if (imageView5 != null) {
                                                                                            i = R.id.level_text;
                                                                                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView5 != null) {
                                                                                                i = R.id.premium_container_count;
                                                                                                CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                if (customCardView7 != null) {
                                                                                                    i = R.id.quality_button;
                                                                                                    CustomCardView customCardView8 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (customCardView8 != null) {
                                                                                                        i = R.id.quality_button1;
                                                                                                        CustomCardView customCardView9 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (customCardView9 != null) {
                                                                                                            i = R.id.tv_premium_count;
                                                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView6 != null) {
                                                                                                                i = R.id.tv_usually_count;
                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView7 != null) {
                                                                                                                    i = R.id.usually_count_container;
                                                                                                                    CustomCardView customCardView10 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (customCardView10 != null) {
                                                                                                                        i = R.id.view_after_level;
                                                                                                                        CustomCardView customCardView11 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (customCardView11 != null) {
                                                                                                                            i = R.id.view_before_level;
                                                                                                                            CustomCardView customCardView12 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (customCardView12 != null) {
                                                                                                                                return new WinterBattlepassLevelItemBinding((LinearLayout) view, findChildViewById4, findChildViewById, findChildViewById2, findChildViewById3, frameLayout, customCardView, customCardView2, customCardView3, textView, customCardView4, textView2, imageView, imageView2, imageView3, imageView4, textView3, textView4, frameLayout2, customCardView5, linearLayout, linearLayout2, frameLayout3, customCardView6, imageView5, textView5, customCardView7, customCardView8, customCardView9, textView6, textView7, customCardView10, customCardView11, customCardView12);
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
