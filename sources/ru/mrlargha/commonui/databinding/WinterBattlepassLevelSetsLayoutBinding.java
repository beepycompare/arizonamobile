package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class WinterBattlepassLevelSetsLayoutBinding implements ViewBinding {
    public final TextView epicDiscountText;
    public final TextView epicLvlText;
    public final RelativeLayout epicPriceButton;
    public final TextView epicPriceText;
    public final TextView goldDiscountText;
    public final TextView goldLvlText;
    public final RelativeLayout goldPriceButton;
    public final TextView goldPriceText;
    public final TextView legendaryDiscountText;
    public final RelativeLayout legendaryPriceButton;
    public final TextView legendaryPriceText;
    public final TextView mainPageTitle;
    public final TextView passName1;
    public final TextView passName2;
    public final TextView passName3;
    public final TextView passName4;
    private final LinearLayout rootView;
    public final TextView silverDiscountText;
    public final TextView silverLvlText;
    public final RelativeLayout silverPriceButton;
    public final TextView silverPriceText;

    private WinterBattlepassLevelSetsLayoutBinding(LinearLayout rootView, TextView epicDiscountText, TextView epicLvlText, RelativeLayout epicPriceButton, TextView epicPriceText, TextView goldDiscountText, TextView goldLvlText, RelativeLayout goldPriceButton, TextView goldPriceText, TextView legendaryDiscountText, RelativeLayout legendaryPriceButton, TextView legendaryPriceText, TextView mainPageTitle, TextView passName1, TextView passName2, TextView passName3, TextView passName4, TextView silverDiscountText, TextView silverLvlText, RelativeLayout silverPriceButton, TextView silverPriceText) {
        this.rootView = rootView;
        this.epicDiscountText = epicDiscountText;
        this.epicLvlText = epicLvlText;
        this.epicPriceButton = epicPriceButton;
        this.epicPriceText = epicPriceText;
        this.goldDiscountText = goldDiscountText;
        this.goldLvlText = goldLvlText;
        this.goldPriceButton = goldPriceButton;
        this.goldPriceText = goldPriceText;
        this.legendaryDiscountText = legendaryDiscountText;
        this.legendaryPriceButton = legendaryPriceButton;
        this.legendaryPriceText = legendaryPriceText;
        this.mainPageTitle = mainPageTitle;
        this.passName1 = passName1;
        this.passName2 = passName2;
        this.passName3 = passName3;
        this.passName4 = passName4;
        this.silverDiscountText = silverDiscountText;
        this.silverLvlText = silverLvlText;
        this.silverPriceButton = silverPriceButton;
        this.silverPriceText = silverPriceText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassLevelSetsLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassLevelSetsLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_level_sets_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassLevelSetsLayoutBinding bind(View rootView) {
        int i = R.id.epic_discount_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.epic_lvl_text;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.epic_price_button;
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                if (relativeLayout != null) {
                    i = R.id.epicPriceText;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.gold_discount_text;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView4 != null) {
                            i = R.id.gold_lvl_text;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView5 != null) {
                                i = R.id.gold_price_button;
                                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                if (relativeLayout2 != null) {
                                    i = R.id.goldPriceText;
                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView6 != null) {
                                        i = R.id.legendary_discount_text;
                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView7 != null) {
                                            i = R.id.legendary_price_button;
                                            RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (relativeLayout3 != null) {
                                                i = R.id.legendaryPriceText;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView8 != null) {
                                                    i = R.id.main_page_title;
                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView9 != null) {
                                                        i = R.id.pass_name1;
                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView10 != null) {
                                                            i = R.id.pass_name2;
                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView11 != null) {
                                                                i = R.id.pass_name3;
                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView12 != null) {
                                                                    i = R.id.pass_name4;
                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView13 != null) {
                                                                        i = R.id.silver_discount_text;
                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView14 != null) {
                                                                            i = R.id.silverLvlText;
                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView15 != null) {
                                                                                i = R.id.silver_price_button;
                                                                                RelativeLayout relativeLayout4 = (RelativeLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                if (relativeLayout4 != null) {
                                                                                    i = R.id.silverPriceText;
                                                                                    TextView textView16 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView16 != null) {
                                                                                        return new WinterBattlepassLevelSetsLayoutBinding((LinearLayout) rootView, textView, textView2, relativeLayout, textView3, textView4, textView5, relativeLayout2, textView6, textView7, relativeLayout3, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, relativeLayout4, textView16);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
