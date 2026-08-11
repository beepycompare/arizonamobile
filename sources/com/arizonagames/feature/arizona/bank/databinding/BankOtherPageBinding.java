package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankOtherPageBinding implements ViewBinding {
    public final TextView bankOtherBusinessBalanceK;
    public final TextView bankOtherBusinessBalanceKk;
    public final TextView bankOtherBusinessBalanceM;
    public final TextView bankOtherBusinessSelectedBalance;
    public final CustomCardView bankOtherBusinessSelectedCard;
    public final TextView bankOtherBusinessSelectedHint;
    public final TextView bankOtherBusinessSelectedPercents;
    public final TextView bankOtherBusinessSelectedTitle;
    public final CustomCardView bankOtherBusinessTopUpButton;
    public final CustomCardView bankOtherBusinessWithdrawButton;
    public final TextView bankOtherBusinessWithdrawCommission;
    public final CustomCardView bankOtherBusinessesCard;
    public final LinearLayout bankOtherBusinessesContainer;
    public final TextView bankOtherBusinessesEmpty;
    public final CustomCardView bankOtherBusinessesIndicator;
    public final LinearLayout bankOtherContent;
    public final TextView bankOtherElectricBalanceK;
    public final TextView bankOtherElectricBalanceKk;
    public final TextView bankOtherElectricBalanceM;
    public final CustomCardView bankOtherElectricCard;
    public final LinearLayout bankOtherElectricContainer;
    public final TextView bankOtherElectricEmpty;
    public final CustomCardView bankOtherElectricIndicator;
    public final TextView bankOtherElectricSelectedBalance;
    public final CustomCardView bankOtherElectricSelectedCard;
    public final TextView bankOtherElectricSelectedHint;
    public final TextView bankOtherElectricSelectedPercents;
    public final TextView bankOtherElectricSelectedTitle;
    public final CustomCardView bankOtherElectricTopUpButton;
    public final LinearLayout bankOtherMobileAmounts;
    public final TextView bankOtherMobileBalance;
    public final CustomCardView bankOtherMobileButton;
    public final TextView bankOtherMobileButtonText;
    public final CustomCardView bankOtherMobileCard;
    public final TextView bankOtherMobileMax;
    public final TextView bankOtherMobileState;
    public final TextView bankOtherMobileTitle;
    public final ImageView bankOtherPhoneImage;
    public final BankOtherRewardsSectionBinding bankOtherRewardsSection;
    public final FrameLayout bankOtherRoot;
    public final NestedScrollView bankOtherScroll;
    public final CustomCardView bankOtherScrollProgressThumb;
    public final CustomCardView bankOtherScrollProgressTrack;
    public final CustomCardView bankOtherVehiclesCard;
    public final LinearLayout bankOtherVehiclesContainer;
    public final TextView bankOtherVehiclesEmpty;
    public final LinearLayout bankOtherVehiclesHeader;
    public final CustomCardView bankOtherVipButton;
    public final TextView bankOtherVipButtonCost;
    public final TextView bankOtherVipButtonText;
    public final CustomCardView bankOtherVipCard;
    public final ImageView bankOtherVipImage;
    public final TextView bankOtherVipTitle;
    private final FrameLayout rootView;

    private BankOtherPageBinding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, CustomCardView customCardView, TextView textView5, TextView textView6, TextView textView7, CustomCardView customCardView2, CustomCardView customCardView3, TextView textView8, CustomCardView customCardView4, LinearLayout linearLayout, TextView textView9, CustomCardView customCardView5, LinearLayout linearLayout2, TextView textView10, TextView textView11, TextView textView12, CustomCardView customCardView6, LinearLayout linearLayout3, TextView textView13, CustomCardView customCardView7, TextView textView14, CustomCardView customCardView8, TextView textView15, TextView textView16, TextView textView17, CustomCardView customCardView9, LinearLayout linearLayout4, TextView textView18, CustomCardView customCardView10, TextView textView19, CustomCardView customCardView11, TextView textView20, TextView textView21, TextView textView22, ImageView imageView, BankOtherRewardsSectionBinding bankOtherRewardsSectionBinding, FrameLayout frameLayout2, NestedScrollView nestedScrollView, CustomCardView customCardView12, CustomCardView customCardView13, CustomCardView customCardView14, LinearLayout linearLayout5, TextView textView23, LinearLayout linearLayout6, CustomCardView customCardView15, TextView textView24, TextView textView25, CustomCardView customCardView16, ImageView imageView2, TextView textView26) {
        this.rootView = frameLayout;
        this.bankOtherBusinessBalanceK = textView;
        this.bankOtherBusinessBalanceKk = textView2;
        this.bankOtherBusinessBalanceM = textView3;
        this.bankOtherBusinessSelectedBalance = textView4;
        this.bankOtherBusinessSelectedCard = customCardView;
        this.bankOtherBusinessSelectedHint = textView5;
        this.bankOtherBusinessSelectedPercents = textView6;
        this.bankOtherBusinessSelectedTitle = textView7;
        this.bankOtherBusinessTopUpButton = customCardView2;
        this.bankOtherBusinessWithdrawButton = customCardView3;
        this.bankOtherBusinessWithdrawCommission = textView8;
        this.bankOtherBusinessesCard = customCardView4;
        this.bankOtherBusinessesContainer = linearLayout;
        this.bankOtherBusinessesEmpty = textView9;
        this.bankOtherBusinessesIndicator = customCardView5;
        this.bankOtherContent = linearLayout2;
        this.bankOtherElectricBalanceK = textView10;
        this.bankOtherElectricBalanceKk = textView11;
        this.bankOtherElectricBalanceM = textView12;
        this.bankOtherElectricCard = customCardView6;
        this.bankOtherElectricContainer = linearLayout3;
        this.bankOtherElectricEmpty = textView13;
        this.bankOtherElectricIndicator = customCardView7;
        this.bankOtherElectricSelectedBalance = textView14;
        this.bankOtherElectricSelectedCard = customCardView8;
        this.bankOtherElectricSelectedHint = textView15;
        this.bankOtherElectricSelectedPercents = textView16;
        this.bankOtherElectricSelectedTitle = textView17;
        this.bankOtherElectricTopUpButton = customCardView9;
        this.bankOtherMobileAmounts = linearLayout4;
        this.bankOtherMobileBalance = textView18;
        this.bankOtherMobileButton = customCardView10;
        this.bankOtherMobileButtonText = textView19;
        this.bankOtherMobileCard = customCardView11;
        this.bankOtherMobileMax = textView20;
        this.bankOtherMobileState = textView21;
        this.bankOtherMobileTitle = textView22;
        this.bankOtherPhoneImage = imageView;
        this.bankOtherRewardsSection = bankOtherRewardsSectionBinding;
        this.bankOtherRoot = frameLayout2;
        this.bankOtherScroll = nestedScrollView;
        this.bankOtherScrollProgressThumb = customCardView12;
        this.bankOtherScrollProgressTrack = customCardView13;
        this.bankOtherVehiclesCard = customCardView14;
        this.bankOtherVehiclesContainer = linearLayout5;
        this.bankOtherVehiclesEmpty = textView23;
        this.bankOtherVehiclesHeader = linearLayout6;
        this.bankOtherVipButton = customCardView15;
        this.bankOtherVipButtonCost = textView24;
        this.bankOtherVipButtonText = textView25;
        this.bankOtherVipCard = customCardView16;
        this.bankOtherVipImage = imageView2;
        this.bankOtherVipTitle = textView26;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BankOtherPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankOtherPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_other_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankOtherPageBinding bind(View view) {
        View findChildViewById;
        int i = R.id.bank_other_business_balance_k;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bank_other_business_balance_kk;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView2 != null) {
                i = R.id.bank_other_business_balance_m;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView3 != null) {
                    i = R.id.bank_other_business_selected_balance;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView4 != null) {
                        i = R.id.bank_other_business_selected_card;
                        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                        if (customCardView != null) {
                            i = R.id.bank_other_business_selected_hint;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView5 != null) {
                                i = R.id.bank_other_business_selected_percents;
                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView6 != null) {
                                    i = R.id.bank_other_business_selected_title;
                                    TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView7 != null) {
                                        i = R.id.bank_other_business_top_up_button;
                                        CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                        if (customCardView2 != null) {
                                            i = R.id.bank_other_business_withdraw_button;
                                            CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                            if (customCardView3 != null) {
                                                i = R.id.bank_other_business_withdraw_commission;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView8 != null) {
                                                    i = R.id.bank_other_businesses_card;
                                                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                    if (customCardView4 != null) {
                                                        i = R.id.bank_other_businesses_container;
                                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout != null) {
                                                            i = R.id.bank_other_businesses_empty;
                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView9 != null) {
                                                                i = R.id.bank_other_businesses_indicator;
                                                                CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                if (customCardView5 != null) {
                                                                    i = R.id.bank_other_content;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout2 != null) {
                                                                        i = R.id.bank_other_electric_balance_k;
                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView10 != null) {
                                                                            i = R.id.bank_other_electric_balance_kk;
                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView11 != null) {
                                                                                i = R.id.bank_other_electric_balance_m;
                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView12 != null) {
                                                                                    i = R.id.bank_other_electric_card;
                                                                                    CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                    if (customCardView6 != null) {
                                                                                        i = R.id.bank_other_electric_container;
                                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout3 != null) {
                                                                                            i = R.id.bank_other_electric_empty;
                                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView13 != null) {
                                                                                                i = R.id.bank_other_electric_indicator;
                                                                                                CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                if (customCardView7 != null) {
                                                                                                    i = R.id.bank_other_electric_selected_balance;
                                                                                                    TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView14 != null) {
                                                                                                        i = R.id.bank_other_electric_selected_card;
                                                                                                        CustomCardView customCardView8 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (customCardView8 != null) {
                                                                                                            i = R.id.bank_other_electric_selected_hint;
                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView15 != null) {
                                                                                                                i = R.id.bank_other_electric_selected_percents;
                                                                                                                TextView textView16 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView16 != null) {
                                                                                                                    i = R.id.bank_other_electric_selected_title;
                                                                                                                    TextView textView17 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView17 != null) {
                                                                                                                        i = R.id.bank_other_electric_top_up_button;
                                                                                                                        CustomCardView customCardView9 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (customCardView9 != null) {
                                                                                                                            i = R.id.bank_other_mobile_amounts;
                                                                                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (linearLayout4 != null) {
                                                                                                                                i = R.id.bank_other_mobile_balance;
                                                                                                                                TextView textView18 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView18 != null) {
                                                                                                                                    i = R.id.bank_other_mobile_button;
                                                                                                                                    CustomCardView customCardView10 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (customCardView10 != null) {
                                                                                                                                        i = R.id.bank_other_mobile_button_text;
                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView19 != null) {
                                                                                                                                            i = R.id.bank_other_mobile_card;
                                                                                                                                            CustomCardView customCardView11 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (customCardView11 != null) {
                                                                                                                                                i = R.id.bank_other_mobile_max;
                                                                                                                                                TextView textView20 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (textView20 != null) {
                                                                                                                                                    i = R.id.bank_other_mobile_state;
                                                                                                                                                    TextView textView21 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (textView21 != null) {
                                                                                                                                                        i = R.id.bank_other_mobile_title;
                                                                                                                                                        TextView textView22 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView22 != null) {
                                                                                                                                                            i = R.id.bank_other_phone_image;
                                                                                                                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.bank_other_rewards_section))) != null) {
                                                                                                                                                                BankOtherRewardsSectionBinding bind = BankOtherRewardsSectionBinding.bind(findChildViewById);
                                                                                                                                                                FrameLayout frameLayout = (FrameLayout) view;
                                                                                                                                                                i = R.id.bank_other_scroll;
                                                                                                                                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (nestedScrollView != null) {
                                                                                                                                                                    i = R.id.bank_other_scroll_progress_thumb;
                                                                                                                                                                    CustomCardView customCardView12 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                    if (customCardView12 != null) {
                                                                                                                                                                        i = R.id.bank_other_scroll_progress_track;
                                                                                                                                                                        CustomCardView customCardView13 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                        if (customCardView13 != null) {
                                                                                                                                                                            i = R.id.bank_other_vehicles_card;
                                                                                                                                                                            CustomCardView customCardView14 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                            if (customCardView14 != null) {
                                                                                                                                                                                i = R.id.bank_other_vehicles_container;
                                                                                                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                if (linearLayout5 != null) {
                                                                                                                                                                                    i = R.id.bank_other_vehicles_empty;
                                                                                                                                                                                    TextView textView23 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                    if (textView23 != null) {
                                                                                                                                                                                        i = R.id.bank_other_vehicles_header;
                                                                                                                                                                                        LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                        if (linearLayout6 != null) {
                                                                                                                                                                                            i = R.id.bank_other_vip_button;
                                                                                                                                                                                            CustomCardView customCardView15 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                            if (customCardView15 != null) {
                                                                                                                                                                                                i = R.id.bank_other_vip_button_cost;
                                                                                                                                                                                                TextView textView24 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                if (textView24 != null) {
                                                                                                                                                                                                    i = R.id.bank_other_vip_button_text;
                                                                                                                                                                                                    TextView textView25 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                    if (textView25 != null) {
                                                                                                                                                                                                        i = R.id.bank_other_vip_card;
                                                                                                                                                                                                        CustomCardView customCardView16 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                        if (customCardView16 != null) {
                                                                                                                                                                                                            i = R.id.bank_other_vip_image;
                                                                                                                                                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                            if (imageView2 != null) {
                                                                                                                                                                                                                i = R.id.bank_other_vip_title;
                                                                                                                                                                                                                TextView textView26 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                                                                if (textView26 != null) {
                                                                                                                                                                                                                    return new BankOtherPageBinding(frameLayout, textView, textView2, textView3, textView4, customCardView, textView5, textView6, textView7, customCardView2, customCardView3, textView8, customCardView4, linearLayout, textView9, customCardView5, linearLayout2, textView10, textView11, textView12, customCardView6, linearLayout3, textView13, customCardView7, textView14, customCardView8, textView15, textView16, textView17, customCardView9, linearLayout4, textView18, customCardView10, textView19, customCardView11, textView20, textView21, textView22, imageView, bind, frameLayout, nestedScrollView, customCardView12, customCardView13, customCardView14, linearLayout5, textView23, linearLayout6, customCardView15, textView24, textView25, customCardView16, imageView2, textView26);
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
