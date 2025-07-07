package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class FamilyTopbarBinding implements ViewBinding {
    public final CardView backButton;
    public final CardView buttonCoins;
    public final CardView buttonDevil;
    public final CardView buttonMoney;
    public final CardView buttonRep;
    public final FrameLayout centerContainer;
    public final CardView closeButton;
    public final TextView createMoney;
    public final LinearLayout createMoneyInfo;
    public final EditText editText;
    public final TextView familyNotice;
    public final TextView familyTitle;
    public final TextView familyType;
    public final ImageView flag;
    public final LinearLayout homeContainer;
    public final CardView inviteBtn;
    public final CardView kickBtn;
    public final ImageView logo;
    public final LinearLayout mainMenuContainer;
    public final FrameLayout messageContainer;
    public final LinearLayout nameContainer;
    public final CardView ratingBtn;
    public final LinearLayout ratingContainer;
    public final TextView ratingTop;
    private final LinearLayout rootView;
    public final CardView searchBtn;
    public final LinearLayout searchContainer;
    public final TextView serverName;
    public final LinearLayout settingsContainer;
    public final TextView textCoins;
    public final TextView textDevil;
    public final TextView textMoney;
    public final TextView textRep;
    public final TextView title;
    public final TextView titleCreate;

    private FamilyTopbarBinding(LinearLayout linearLayout, CardView cardView, CardView cardView2, CardView cardView3, CardView cardView4, CardView cardView5, FrameLayout frameLayout, CardView cardView6, TextView textView, LinearLayout linearLayout2, EditText editText, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, LinearLayout linearLayout3, CardView cardView7, CardView cardView8, ImageView imageView2, LinearLayout linearLayout4, FrameLayout frameLayout2, LinearLayout linearLayout5, CardView cardView9, LinearLayout linearLayout6, TextView textView5, CardView cardView10, LinearLayout linearLayout7, TextView textView6, LinearLayout linearLayout8, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = linearLayout;
        this.backButton = cardView;
        this.buttonCoins = cardView2;
        this.buttonDevil = cardView3;
        this.buttonMoney = cardView4;
        this.buttonRep = cardView5;
        this.centerContainer = frameLayout;
        this.closeButton = cardView6;
        this.createMoney = textView;
        this.createMoneyInfo = linearLayout2;
        this.editText = editText;
        this.familyNotice = textView2;
        this.familyTitle = textView3;
        this.familyType = textView4;
        this.flag = imageView;
        this.homeContainer = linearLayout3;
        this.inviteBtn = cardView7;
        this.kickBtn = cardView8;
        this.logo = imageView2;
        this.mainMenuContainer = linearLayout4;
        this.messageContainer = frameLayout2;
        this.nameContainer = linearLayout5;
        this.ratingBtn = cardView9;
        this.ratingContainer = linearLayout6;
        this.ratingTop = textView5;
        this.searchBtn = cardView10;
        this.searchContainer = linearLayout7;
        this.serverName = textView6;
        this.settingsContainer = linearLayout8;
        this.textCoins = textView7;
        this.textDevil = textView8;
        this.textMoney = textView9;
        this.textRep = textView10;
        this.title = textView11;
        this.titleCreate = textView12;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FamilyTopbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilyTopbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_topbar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilyTopbarBinding bind(View view) {
        int i = R.id.back_button;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.button_coins;
            CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
            if (cardView2 != null) {
                i = R.id.button_devil;
                CardView cardView3 = (CardView) ViewBindings.findChildViewById(view, i);
                if (cardView3 != null) {
                    i = R.id.button_money;
                    CardView cardView4 = (CardView) ViewBindings.findChildViewById(view, i);
                    if (cardView4 != null) {
                        i = R.id.button_rep;
                        CardView cardView5 = (CardView) ViewBindings.findChildViewById(view, i);
                        if (cardView5 != null) {
                            i = R.id.center_container;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout != null) {
                                i = R.id.close_button;
                                CardView cardView6 = (CardView) ViewBindings.findChildViewById(view, i);
                                if (cardView6 != null) {
                                    i = R.id.create_money;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.create_money_info;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout != null) {
                                            i = R.id.edit_text;
                                            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                            if (editText != null) {
                                                i = R.id.family_notice;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView2 != null) {
                                                    i = R.id.family_title;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.family_type;
                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView4 != null) {
                                                            i = R.id.flag;
                                                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                            if (imageView != null) {
                                                                i = R.id.home_container;
                                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout2 != null) {
                                                                    i = R.id.invite_btn;
                                                                    CardView cardView7 = (CardView) ViewBindings.findChildViewById(view, i);
                                                                    if (cardView7 != null) {
                                                                        i = R.id.kick_btn;
                                                                        CardView cardView8 = (CardView) ViewBindings.findChildViewById(view, i);
                                                                        if (cardView8 != null) {
                                                                            i = R.id.logo;
                                                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (imageView2 != null) {
                                                                                i = R.id.main_menu_container;
                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                if (linearLayout3 != null) {
                                                                                    i = R.id.message_container;
                                                                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (frameLayout2 != null) {
                                                                                        i = R.id.name_container;
                                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (linearLayout4 != null) {
                                                                                            i = R.id.rating_btn;
                                                                                            CardView cardView9 = (CardView) ViewBindings.findChildViewById(view, i);
                                                                                            if (cardView9 != null) {
                                                                                                i = R.id.rating_container;
                                                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (linearLayout5 != null) {
                                                                                                    i = R.id.rating_top;
                                                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView5 != null) {
                                                                                                        i = R.id.search_btn;
                                                                                                        CardView cardView10 = (CardView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (cardView10 != null) {
                                                                                                            i = R.id.search_container;
                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                            if (linearLayout6 != null) {
                                                                                                                i = R.id.server_name;
                                                                                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView6 != null) {
                                                                                                                    i = R.id.settings_container;
                                                                                                                    LinearLayout linearLayout7 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (linearLayout7 != null) {
                                                                                                                        i = R.id.text_coins;
                                                                                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (textView7 != null) {
                                                                                                                            i = R.id.text_devil;
                                                                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (textView8 != null) {
                                                                                                                                i = R.id.text_money;
                                                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (textView9 != null) {
                                                                                                                                    i = R.id.text_rep;
                                                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                    if (textView10 != null) {
                                                                                                                                        i = R.id.title;
                                                                                                                                        TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                        if (textView11 != null) {
                                                                                                                                            i = R.id.title_create;
                                                                                                                                            TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                                            if (textView12 != null) {
                                                                                                                                                return new FamilyTopbarBinding((LinearLayout) view, cardView, cardView2, cardView3, cardView4, cardView5, frameLayout, cardView6, textView, linearLayout, editText, textView2, textView3, textView4, imageView, linearLayout2, cardView7, cardView8, imageView2, linearLayout3, frameLayout2, linearLayout4, cardView9, linearLayout5, textView5, cardView10, linearLayout6, textView6, linearLayout7, textView7, textView8, textView9, textView10, textView11, textView12);
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
