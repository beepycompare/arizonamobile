package ru.mrlargha.feature.battlepassWinter2025.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.battlepassWinter2025.R;
/* loaded from: classes6.dex */
public final class WinterBattlepassLevelSetsLayoutBinding implements ViewBinding {
    public final TextView epicDiscountText;
    public final TextView epicLvlText;
    public final TextView epicPriceButton;
    public final TextView epicPriceText;
    public final TextView goldDiscountText;
    public final TextView goldLvlText;
    public final TextView goldPriceButton;
    public final TextView goldPriceText;
    public final TextView legendaryDiscountText;
    public final TextView legendaryPriceButton;
    public final TextView legendaryPriceText;
    public final TextView mainPageTitle;
    public final TextView passName1;
    public final TextView passName2;
    public final TextView passName3;
    public final TextView passName4;
    private final LinearLayout rootView;
    public final TextView silverDiscountText;
    public final TextView silverLvlText;
    public final TextView silverPriceButton;
    public final TextView silverPriceText;

    private WinterBattlepassLevelSetsLayoutBinding(LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17, TextView textView18, TextView textView19, TextView textView20) {
        this.rootView = linearLayout;
        this.epicDiscountText = textView;
        this.epicLvlText = textView2;
        this.epicPriceButton = textView3;
        this.epicPriceText = textView4;
        this.goldDiscountText = textView5;
        this.goldLvlText = textView6;
        this.goldPriceButton = textView7;
        this.goldPriceText = textView8;
        this.legendaryDiscountText = textView9;
        this.legendaryPriceButton = textView10;
        this.legendaryPriceText = textView11;
        this.mainPageTitle = textView12;
        this.passName1 = textView13;
        this.passName2 = textView14;
        this.passName3 = textView15;
        this.passName4 = textView16;
        this.silverDiscountText = textView17;
        this.silverLvlText = textView18;
        this.silverPriceButton = textView19;
        this.silverPriceText = textView20;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassLevelSetsLayoutBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassLevelSetsLayoutBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_level_sets_layout, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassLevelSetsLayoutBinding bind(View view) {
        int i = R.id.epic_discount_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.epic_lvl_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.epic_price_button;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.epicPriceText;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.gold_discount_text;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView5 != null) {
                            i = R.id.gold_lvl_text;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView6 != null) {
                                i = R.id.gold_price_button;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView7 != null) {
                                    i = R.id.goldPriceText;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView8 != null) {
                                        i = R.id.legendary_discount_text;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView9 != null) {
                                            i = R.id.legendary_price_button;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView10 != null) {
                                                i = R.id.legendaryPriceText;
                                                TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView11 != null) {
                                                    i = R.id.main_page_title;
                                                    TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView12 != null) {
                                                        i = R.id.pass_name1;
                                                        TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView13 != null) {
                                                            i = R.id.pass_name2;
                                                            TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView14 != null) {
                                                                i = R.id.pass_name3;
                                                                TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView15 != null) {
                                                                    i = R.id.pass_name4;
                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView16 != null) {
                                                                        i = R.id.silver_discount_text;
                                                                        TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView17 != null) {
                                                                            i = R.id.silverLvlText;
                                                                            TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView18 != null) {
                                                                                i = R.id.silver_price_button;
                                                                                TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView19 != null) {
                                                                                    i = R.id.silverPriceText;
                                                                                    TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView20 != null) {
                                                                                        return new WinterBattlepassLevelSetsLayoutBinding((LinearLayout) view, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, textView16, textView17, textView18, textView19, textView20);
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
