package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class AuctionCurrentContainerBinding implements ViewBinding {
    public final LinearLayout acBetBg;
    public final AppCompatImageView acExitButton;
    public final AppCompatImageView acGeneralExit;
    public final AppCompatImageView acRun;
    public final AppCompatImageView acSetBetButton;
    public final ConstraintLayout auctionCurrentContainer;
    public final Guideline ccHorizontalButton;
    public final Guideline ccHorizontalItemLine;
    public final Guideline ccHorizontalLastBet;
    public final Guideline ccHorizontalListItem;
    public final Guideline ccHorizontalMenuName;
    public final Guideline ccHorizontalTimer;
    public final Guideline ccHorizontalTittle;
    public final LinearLayout ccInputBetBg;
    public final TextView ccInputBetName;
    public final TextView ccInputBetPrice;
    public final TextView ccInputBetTittle;
    public final EditText ccInputForm;
    public final TextView ccInputTittle;
    public final TextView ccItemDescription;
    public final AppCompatImageView ccItemImage;
    public final TextView ccItemLastBetName;
    public final TextView ccItemLastBetPrice;
    public final TextView ccItemLastBetTittle;
    public final TextView ccItemListTittle;
    public final TextView ccItemMenuTittle;
    public final TextView ccItemPrice;
    public final TextView ccItemPriceIcone;
    public final TextView ccItemTimeLeftTimer;
    public final TextView ccItemTimeLeftTittle;
    public final TextView ccItemTittle;
    public final RelativeLayout ccLastBetBg;
    public final RecyclerView ccRcView;
    public final Guideline ccVerticalButton;
    public final Guideline ccVerticalInput;
    public final Guideline ccVerticalItemLine;
    public final Guideline ccVerticalLastBet;
    public final Guideline ccVerticalMenuExit;
    public final Guideline ccVerticalMenuName;
    private final ConstraintLayout rootView;

    private AuctionCurrentContainerBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, ConstraintLayout constraintLayout2, Guideline guideline, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, Guideline guideline6, Guideline guideline7, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, EditText editText, TextView textView4, TextView textView5, AppCompatImageView appCompatImageView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, RelativeLayout relativeLayout, RecyclerView recyclerView, Guideline guideline8, Guideline guideline9, Guideline guideline10, Guideline guideline11, Guideline guideline12, Guideline guideline13) {
        this.rootView = constraintLayout;
        this.acBetBg = linearLayout;
        this.acExitButton = appCompatImageView;
        this.acGeneralExit = appCompatImageView2;
        this.acRun = appCompatImageView3;
        this.acSetBetButton = appCompatImageView4;
        this.auctionCurrentContainer = constraintLayout2;
        this.ccHorizontalButton = guideline;
        this.ccHorizontalItemLine = guideline2;
        this.ccHorizontalLastBet = guideline3;
        this.ccHorizontalListItem = guideline4;
        this.ccHorizontalMenuName = guideline5;
        this.ccHorizontalTimer = guideline6;
        this.ccHorizontalTittle = guideline7;
        this.ccInputBetBg = linearLayout2;
        this.ccInputBetName = textView;
        this.ccInputBetPrice = textView2;
        this.ccInputBetTittle = textView3;
        this.ccInputForm = editText;
        this.ccInputTittle = textView4;
        this.ccItemDescription = textView5;
        this.ccItemImage = appCompatImageView5;
        this.ccItemLastBetName = textView6;
        this.ccItemLastBetPrice = textView7;
        this.ccItemLastBetTittle = textView8;
        this.ccItemListTittle = textView9;
        this.ccItemMenuTittle = textView10;
        this.ccItemPrice = textView11;
        this.ccItemPriceIcone = textView12;
        this.ccItemTimeLeftTimer = textView13;
        this.ccItemTimeLeftTittle = textView14;
        this.ccItemTittle = textView15;
        this.ccLastBetBg = relativeLayout;
        this.ccRcView = recyclerView;
        this.ccVerticalButton = guideline8;
        this.ccVerticalInput = guideline9;
        this.ccVerticalItemLine = guideline10;
        this.ccVerticalLastBet = guideline11;
        this.ccVerticalMenuExit = guideline12;
        this.ccVerticalMenuName = guideline13;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AuctionCurrentContainerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static AuctionCurrentContainerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.auction_current_container, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuctionCurrentContainerBinding bind(View view) {
        int i = R.id.ac_bet_bg;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.ac_exit_button;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.ac_general_exit;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView2 != null) {
                    i = R.id.ac_run;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                    if (appCompatImageView3 != null) {
                        i = R.id.ac_set_bet_button;
                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView4 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            i = R.id.cc_horizontal_button;
                            Guideline guideline = (Guideline) ViewBindings.findChildViewById(view, i);
                            if (guideline != null) {
                                i = R.id.cc_horizontal_item_line;
                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(view, i);
                                if (guideline2 != null) {
                                    i = R.id.cc_horizontal_last_bet;
                                    Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(view, i);
                                    if (guideline3 != null) {
                                        i = R.id.cc_horizontal_list_item;
                                        Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(view, i);
                                        if (guideline4 != null) {
                                            i = R.id.cc_horizontal_menu_name;
                                            Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(view, i);
                                            if (guideline5 != null) {
                                                i = R.id.cc_horizontal_timer;
                                                Guideline guideline6 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                if (guideline6 != null) {
                                                    i = R.id.cc_horizontal_tittle;
                                                    Guideline guideline7 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                    if (guideline7 != null) {
                                                        i = R.id.cc_input_bet_bg;
                                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout2 != null) {
                                                            i = R.id.cc_input_bet_name;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView != null) {
                                                                i = R.id.cc_input_bet_price;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView2 != null) {
                                                                    i = R.id.cc_input_bet_tittle;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView3 != null) {
                                                                        i = R.id.cc_input_form;
                                                                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                                        if (editText != null) {
                                                                            i = R.id.cc_input_tittle;
                                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView4 != null) {
                                                                                i = R.id.cc_item_description;
                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView5 != null) {
                                                                                    i = R.id.cc_item_image;
                                                                                    AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (appCompatImageView5 != null) {
                                                                                        i = R.id.cc_item_last_bet_name;
                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView6 != null) {
                                                                                            i = R.id.cc_item_last_bet_price;
                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView7 != null) {
                                                                                                i = R.id.cc_item_last_bet_tittle;
                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView8 != null) {
                                                                                                    i = R.id.cc_item_list_tittle;
                                                                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView9 != null) {
                                                                                                        i = R.id.cc_item_menu_tittle;
                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView10 != null) {
                                                                                                            i = R.id.cc_item_price;
                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView11 != null) {
                                                                                                                i = R.id.cc_item_price_icone;
                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView12 != null) {
                                                                                                                    i = R.id.cc_item_time_left_timer;
                                                                                                                    TextView textView13 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (textView13 != null) {
                                                                                                                        i = R.id.cc_item_time_left_tittle;
                                                                                                                        TextView textView14 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView14 != null) {
                                                                                                                            i = R.id.cc_item_tittle;
                                                                                                                            TextView textView15 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView15 != null) {
                                                                                                                                i = R.id.cc_last_bet_bg;
                                                                                                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (relativeLayout != null) {
                                                                                                                                    i = R.id.cc_rc_view;
                                                                                                                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (recyclerView != null) {
                                                                                                                                        i = R.id.cc_vertical_button;
                                                                                                                                        Guideline guideline8 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (guideline8 != null) {
                                                                                                                                            i = R.id.cc_vertical_input;
                                                                                                                                            Guideline guideline9 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (guideline9 != null) {
                                                                                                                                                i = R.id.cc_vertical_item_line;
                                                                                                                                                Guideline guideline10 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                if (guideline10 != null) {
                                                                                                                                                    i = R.id.cc_vertical_last_bet;
                                                                                                                                                    Guideline guideline11 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                    if (guideline11 != null) {
                                                                                                                                                        i = R.id.cc_vertical_menu_exit;
                                                                                                                                                        Guideline guideline12 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                        if (guideline12 != null) {
                                                                                                                                                            i = R.id.cc_vertical_menu_name;
                                                                                                                                                            Guideline guideline13 = (Guideline) ViewBindings.findChildViewById(view, i);
                                                                                                                                                            if (guideline13 != null) {
                                                                                                                                                                return new AuctionCurrentContainerBinding(constraintLayout, linearLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, constraintLayout, guideline, guideline2, guideline3, guideline4, guideline5, guideline6, guideline7, linearLayout2, textView, textView2, textView3, editText, textView4, textView5, appCompatImageView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12, textView13, textView14, textView15, relativeLayout, recyclerView, guideline8, guideline9, guideline10, guideline11, guideline12, guideline13);
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
