package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.elements.battlepassWinter2025.roulette.RouletteView;
/* loaded from: classes5.dex */
public final class WinterBattlepassRouletteMainScreenBinding implements ViewBinding {
    public final TextView attempsCount;
    public final FrameLayout btn1;
    public final TextView btn1Text;
    public final FrameLayout btn2;
    public final TextView btn2Text;
    public final FrameLayout btn3;
    public final TextView btn3Text;
    public final LinearLayout btnBack;
    public final LinearLayout btnBuy;
    public final FrameLayout btnSprint;
    public final TextView buttonPrice;
    public final ImageView buttonPriceIcon;
    public final ImageView buttonPriceIconTop;
    public final TextView buttonPriceRub;
    public final TextView buttonPriceRubTop;
    public final LinearLayout dopInfo;
    public final LinearLayout oldPrise;
    public final TextView oldPriseEmpty;
    public final RecyclerView oldPriseRv;
    public final RecyclerView priseListRv;
    private final ConstraintLayout rootView;
    public final FrameLayout roulette;
    public final RouletteView rouletteView;
    public final TextView textPrice;
    public final TextView tvBuy;

    private WinterBattlepassRouletteMainScreenBinding(ConstraintLayout rootView, TextView attempsCount, FrameLayout btn1, TextView btn1Text, FrameLayout btn2, TextView btn2Text, FrameLayout btn3, TextView btn3Text, LinearLayout btnBack, LinearLayout btnBuy, FrameLayout btnSprint, TextView buttonPrice, ImageView buttonPriceIcon, ImageView buttonPriceIconTop, TextView buttonPriceRub, TextView buttonPriceRubTop, LinearLayout dopInfo, LinearLayout oldPrise, TextView oldPriseEmpty, RecyclerView oldPriseRv, RecyclerView priseListRv, FrameLayout roulette, RouletteView rouletteView, TextView textPrice, TextView tvBuy) {
        this.rootView = rootView;
        this.attempsCount = attempsCount;
        this.btn1 = btn1;
        this.btn1Text = btn1Text;
        this.btn2 = btn2;
        this.btn2Text = btn2Text;
        this.btn3 = btn3;
        this.btn3Text = btn3Text;
        this.btnBack = btnBack;
        this.btnBuy = btnBuy;
        this.btnSprint = btnSprint;
        this.buttonPrice = buttonPrice;
        this.buttonPriceIcon = buttonPriceIcon;
        this.buttonPriceIconTop = buttonPriceIconTop;
        this.buttonPriceRub = buttonPriceRub;
        this.buttonPriceRubTop = buttonPriceRubTop;
        this.dopInfo = dopInfo;
        this.oldPrise = oldPrise;
        this.oldPriseEmpty = oldPriseEmpty;
        this.oldPriseRv = oldPriseRv;
        this.priseListRv = priseListRv;
        this.roulette = roulette;
        this.rouletteView = rouletteView;
        this.textPrice = textPrice;
        this.tvBuy = tvBuy;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassRouletteMainScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static WinterBattlepassRouletteMainScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.winter_battlepass_roulette_main_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassRouletteMainScreenBinding bind(View rootView) {
        int i = R.id.attempsCount;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.btn_1;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
            if (frameLayout != null) {
                i = R.id.btn_1_text;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.btn_2;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                    if (frameLayout2 != null) {
                        i = R.id.btn_2_text;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView3 != null) {
                            i = R.id.btn_3;
                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                            if (frameLayout3 != null) {
                                i = R.id.btn_3_text;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.btn_back;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (linearLayout != null) {
                                        i = R.id.btn_buy;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout2 != null) {
                                            i = R.id.btn_sprint;
                                            FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (frameLayout4 != null) {
                                                i = R.id.buttonPrice;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView5 != null) {
                                                    i = R.id.buttonPriceIcon;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                    if (imageView != null) {
                                                        i = R.id.buttonPriceIconTop;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (imageView2 != null) {
                                                            i = R.id.buttonPriceRub;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView6 != null) {
                                                                i = R.id.buttonPriceRubTop;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.dop_info;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (linearLayout3 != null) {
                                                                        i = R.id.old_prise;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                        if (linearLayout4 != null) {
                                                                            i = R.id.old_prise_empty;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView8 != null) {
                                                                                i = R.id.old_prise_rv;
                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (recyclerView != null) {
                                                                                    i = R.id.prise_list_rv;
                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (recyclerView2 != null) {
                                                                                        i = R.id.roulette;
                                                                                        FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                                                                        if (frameLayout5 != null) {
                                                                                            i = R.id.roulette_view;
                                                                                            RouletteView rouletteView = (RouletteView) ViewBindings.findChildViewById(rootView, i);
                                                                                            if (rouletteView != null) {
                                                                                                i = R.id.textPrice;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.tv_buy;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                                    if (textView10 != null) {
                                                                                                        return new WinterBattlepassRouletteMainScreenBinding((ConstraintLayout) rootView, textView, frameLayout, textView2, frameLayout2, textView3, frameLayout3, textView4, linearLayout, linearLayout2, frameLayout4, textView5, imageView, imageView2, textView6, textView7, linearLayout3, linearLayout4, textView8, recyclerView, recyclerView2, frameLayout5, rouletteView, textView9, textView10);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
