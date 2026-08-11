package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankMainPageBinding implements ViewBinding {
    public final TextView bankMainAccountsBalanceBillions;
    public final CustomCardView bankMainAccountsCard;
    public final CustomCardView bankMainAccountsHistoryButton;
    public final ImageView bankMainAccountsScrollLeft;
    public final ImageView bankMainAccountsScrollRight;
    public final CustomCardView bankMainAccountsTabIndicator;
    public final RecyclerView bankMainAccountsTabsContainer;
    public final CustomCardView bankMainAccountsTopUpButton;
    public final CustomCardView bankMainAccountsTransferButton;
    public final TextView bankMainAccountsTransferCommission;
    public final CustomCardView bankMainAccountsWithdrawButton;
    public final TextView bankMainAccountsWithdrawCommission;
    public final CustomCardView bankMainOrganizationCard;
    public final CustomCardView bankMainOrganizationHistoryButton;
    public final ImageView bankMainOrganizationLogo;
    public final TextView bankMainOrganizationName;
    public final TextView bankMainOrganizationTitle;
    public final CustomCardView bankMainOrganizationTopUpButton;
    public final CustomCardView bankMainOrganizationWithdrawButton;
    public final TextView bankMainOrganizationWithdrawCommission;
    public final NestedScrollView bankMainPageAccountContent;
    public final CustomCardView bankMainPageAccountTab;
    public final TextView bankMainPageAccountTabText;
    public final CustomCardView bankMainPageSectionIndicator;
    public final CustomCardView bankMainPageSwitcher;
    public final RecyclerView bankMainPageTaxesContent;
    public final CustomCardView bankMainPageTaxesTab;
    public final TextView bankMainPageTaxesTabText;
    public final CustomCardView bankMainPageTaxesTabWarning;
    public final TextView bankMainPensionBalance;
    public final CustomCardView bankMainPensionBuyButton;
    public final TextView bankMainPensionBuyButtonText;
    public final CustomCardView bankMainPensionCard;
    public final TextView bankMainPensionInfoButton;
    public final LinearLayout bankMainPensionLockedState;
    public final LinearLayout bankMainPensionOpenState;
    public final TextView bankMainPensionTitle;
    public final CustomCardView bankMainPensionWithdrawButton;
    private final FrameLayout rootView;
    public final TextView tvCost;

    private BankMainPageBinding(FrameLayout frameLayout, TextView textView, CustomCardView customCardView, CustomCardView customCardView2, ImageView imageView, ImageView imageView2, CustomCardView customCardView3, RecyclerView recyclerView, CustomCardView customCardView4, CustomCardView customCardView5, TextView textView2, CustomCardView customCardView6, TextView textView3, CustomCardView customCardView7, CustomCardView customCardView8, ImageView imageView3, TextView textView4, TextView textView5, CustomCardView customCardView9, CustomCardView customCardView10, TextView textView6, NestedScrollView nestedScrollView, CustomCardView customCardView11, TextView textView7, CustomCardView customCardView12, CustomCardView customCardView13, RecyclerView recyclerView2, CustomCardView customCardView14, TextView textView8, CustomCardView customCardView15, TextView textView9, CustomCardView customCardView16, TextView textView10, CustomCardView customCardView17, TextView textView11, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView12, CustomCardView customCardView18, TextView textView13) {
        this.rootView = frameLayout;
        this.bankMainAccountsBalanceBillions = textView;
        this.bankMainAccountsCard = customCardView;
        this.bankMainAccountsHistoryButton = customCardView2;
        this.bankMainAccountsScrollLeft = imageView;
        this.bankMainAccountsScrollRight = imageView2;
        this.bankMainAccountsTabIndicator = customCardView3;
        this.bankMainAccountsTabsContainer = recyclerView;
        this.bankMainAccountsTopUpButton = customCardView4;
        this.bankMainAccountsTransferButton = customCardView5;
        this.bankMainAccountsTransferCommission = textView2;
        this.bankMainAccountsWithdrawButton = customCardView6;
        this.bankMainAccountsWithdrawCommission = textView3;
        this.bankMainOrganizationCard = customCardView7;
        this.bankMainOrganizationHistoryButton = customCardView8;
        this.bankMainOrganizationLogo = imageView3;
        this.bankMainOrganizationName = textView4;
        this.bankMainOrganizationTitle = textView5;
        this.bankMainOrganizationTopUpButton = customCardView9;
        this.bankMainOrganizationWithdrawButton = customCardView10;
        this.bankMainOrganizationWithdrawCommission = textView6;
        this.bankMainPageAccountContent = nestedScrollView;
        this.bankMainPageAccountTab = customCardView11;
        this.bankMainPageAccountTabText = textView7;
        this.bankMainPageSectionIndicator = customCardView12;
        this.bankMainPageSwitcher = customCardView13;
        this.bankMainPageTaxesContent = recyclerView2;
        this.bankMainPageTaxesTab = customCardView14;
        this.bankMainPageTaxesTabText = textView8;
        this.bankMainPageTaxesTabWarning = customCardView15;
        this.bankMainPensionBalance = textView9;
        this.bankMainPensionBuyButton = customCardView16;
        this.bankMainPensionBuyButtonText = textView10;
        this.bankMainPensionCard = customCardView17;
        this.bankMainPensionInfoButton = textView11;
        this.bankMainPensionLockedState = linearLayout;
        this.bankMainPensionOpenState = linearLayout2;
        this.bankMainPensionTitle = textView12;
        this.bankMainPensionWithdrawButton = customCardView18;
        this.tvCost = textView13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BankMainPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankMainPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_main_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankMainPageBinding bind(View view) {
        int i = R.id.bank_main_accounts_balance_billions;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.bank_main_accounts_card;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView != null) {
                i = R.id.bank_main_accounts_history_button;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView2 != null) {
                    i = R.id.bank_main_accounts_scroll_left;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.bank_main_accounts_scroll_right;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.bank_main_accounts_tab_indicator;
                            CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView3 != null) {
                                i = R.id.bank_main_accounts_tabs_container;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                if (recyclerView != null) {
                                    i = R.id.bank_main_accounts_top_up_button;
                                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                    if (customCardView4 != null) {
                                        i = R.id.bank_main_accounts_transfer_button;
                                        CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                        if (customCardView5 != null) {
                                            i = R.id.bank_main_accounts_transfer_commission;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.bank_main_accounts_withdraw_button;
                                                CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                if (customCardView6 != null) {
                                                    i = R.id.bank_main_accounts_withdraw_commission;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.bank_main_organization_card;
                                                        CustomCardView customCardView7 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                        if (customCardView7 != null) {
                                                            i = R.id.bank_main_organization_history_button;
                                                            CustomCardView customCardView8 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                            if (customCardView8 != null) {
                                                                i = R.id.bank_main_organization_logo;
                                                                ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                if (imageView3 != null) {
                                                                    i = R.id.bank_main_organization_name;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.bank_main_organization_title;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView5 != null) {
                                                                            i = R.id.bank_main_organization_top_up_button;
                                                                            CustomCardView customCardView9 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                            if (customCardView9 != null) {
                                                                                i = R.id.bank_main_organization_withdraw_button;
                                                                                CustomCardView customCardView10 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                if (customCardView10 != null) {
                                                                                    i = R.id.bank_main_organization_withdraw_commission;
                                                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                    if (textView6 != null) {
                                                                                        i = R.id.bank_main_page_account_content;
                                                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, i);
                                                                                        if (nestedScrollView != null) {
                                                                                            i = R.id.bank_main_page_account_tab;
                                                                                            CustomCardView customCardView11 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                            if (customCardView11 != null) {
                                                                                                i = R.id.bank_main_page_account_tab_text;
                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView7 != null) {
                                                                                                    i = R.id.bank_main_page_section_indicator;
                                                                                                    CustomCardView customCardView12 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (customCardView12 != null) {
                                                                                                        i = R.id.bank_main_page_switcher;
                                                                                                        CustomCardView customCardView13 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (customCardView13 != null) {
                                                                                                            i = R.id.bank_main_page_taxes_content;
                                                                                                            RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (recyclerView2 != null) {
                                                                                                                i = R.id.bank_main_page_taxes_tab;
                                                                                                                CustomCardView customCardView14 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (customCardView14 != null) {
                                                                                                                    i = R.id.bank_main_page_taxes_tab_text;
                                                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView8 != null) {
                                                                                                                        i = R.id.bank_main_page_taxes_tab_warning;
                                                                                                                        CustomCardView customCardView15 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (customCardView15 != null) {
                                                                                                                            i = R.id.bank_main_pension_balance;
                                                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView9 != null) {
                                                                                                                                i = R.id.bank_main_pension_buy_button;
                                                                                                                                CustomCardView customCardView16 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (customCardView16 != null) {
                                                                                                                                    i = R.id.bank_main_pension_buy_button_text;
                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView10 != null) {
                                                                                                                                        i = R.id.bank_main_pension_card;
                                                                                                                                        CustomCardView customCardView17 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (customCardView17 != null) {
                                                                                                                                            i = R.id.bank_main_pension_info_button;
                                                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView11 != null) {
                                                                                                                                                i = R.id.bank_main_pension_locked_state;
                                                                                                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (linearLayout != null) {
                                                                                                                                                    i = R.id.bank_main_pension_open_state;
                                                                                                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (linearLayout2 != null) {
                                                                                                                                                        i = R.id.bank_main_pension_title;
                                                                                                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (textView12 != null) {
                                                                                                                                                            i = R.id.bank_main_pension_withdraw_button;
                                                                                                                                                            CustomCardView customCardView18 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (customCardView18 != null) {
                                                                                                                                                                i = R.id.tv_cost;
                                                                                                                                                                TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                                                if (textView13 != null) {
                                                                                                                                                                    return new BankMainPageBinding((FrameLayout) view, textView, customCardView, customCardView2, imageView, imageView2, customCardView3, recyclerView, customCardView4, customCardView5, textView2, customCardView6, textView3, customCardView7, customCardView8, imageView3, textView4, textView5, customCardView9, customCardView10, textView6, nestedScrollView, customCardView11, textView7, customCardView12, customCardView13, recyclerView2, customCardView14, textView8, customCardView15, textView9, customCardView16, textView10, customCardView17, textView11, linearLayout, linearLayout2, textView12, customCardView18, textView13);
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
