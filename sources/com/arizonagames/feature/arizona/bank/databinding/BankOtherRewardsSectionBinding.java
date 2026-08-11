package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankOtherRewardsSectionBinding implements ViewBinding {
    public final LinearLayout bankOtherChestsContainer;
    public final CustomCardView bankOtherOligarchChest;
    public final CustomCardView bankOtherOligarchChestActionButton;
    public final TextView bankOtherOligarchChestActionText;
    public final TextView bankOtherOligarchChestTitle;
    public final CustomCardView bankOtherOrganizationChest;
    public final CustomCardView bankOtherOrganizationChestActionButton;
    public final TextView bankOtherOrganizationChestActionText;
    public final TextView bankOtherOrganizationChestTitle;
    public final CustomCardView bankOtherStatisticsButton;
    private final LinearLayout rootView;

    private BankOtherRewardsSectionBinding(LinearLayout linearLayout, LinearLayout linearLayout2, CustomCardView customCardView, CustomCardView customCardView2, TextView textView, TextView textView2, CustomCardView customCardView3, CustomCardView customCardView4, TextView textView3, TextView textView4, CustomCardView customCardView5) {
        this.rootView = linearLayout;
        this.bankOtherChestsContainer = linearLayout2;
        this.bankOtherOligarchChest = customCardView;
        this.bankOtherOligarchChestActionButton = customCardView2;
        this.bankOtherOligarchChestActionText = textView;
        this.bankOtherOligarchChestTitle = textView2;
        this.bankOtherOrganizationChest = customCardView3;
        this.bankOtherOrganizationChestActionButton = customCardView4;
        this.bankOtherOrganizationChestActionText = textView3;
        this.bankOtherOrganizationChestTitle = textView4;
        this.bankOtherStatisticsButton = customCardView5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static BankOtherRewardsSectionBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankOtherRewardsSectionBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_other_rewards_section, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankOtherRewardsSectionBinding bind(View view) {
        int i = R.id.bank_other_chests_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.bank_other_oligarch_chest;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView != null) {
                i = R.id.bank_other_oligarch_chest_action_button;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView2 != null) {
                    i = R.id.bank_other_oligarch_chest_action_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.bank_other_oligarch_chest_title;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.bank_other_organization_chest;
                            CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView3 != null) {
                                i = R.id.bank_other_organization_chest_action_button;
                                CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                if (customCardView4 != null) {
                                    i = R.id.bank_other_organization_chest_action_text;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView3 != null) {
                                        i = R.id.bank_other_organization_chest_title;
                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView4 != null) {
                                            i = R.id.bank_other_statistics_button;
                                            CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                            if (customCardView5 != null) {
                                                return new BankOtherRewardsSectionBinding((LinearLayout) view, linearLayout, customCardView, customCardView2, textView, textView2, customCardView3, customCardView4, textView3, textView4, customCardView5);
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
