package ru.mrlargha.feature.battlepassWinter2025.databinding;

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
import ru.mrlargha.feature.battlepassWinter2025.R;
import ru.mrlargha.feature.battlepassWinter2025.roulette.RouletteView;
/* loaded from: classes6.dex */
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

    private WinterBattlepassRouletteMainScreenBinding(ConstraintLayout constraintLayout, TextView textView, FrameLayout frameLayout, TextView textView2, FrameLayout frameLayout2, TextView textView3, FrameLayout frameLayout3, TextView textView4, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout4, TextView textView5, ImageView imageView, ImageView imageView2, TextView textView6, TextView textView7, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView8, RecyclerView recyclerView, RecyclerView recyclerView2, FrameLayout frameLayout5, RouletteView rouletteView, TextView textView9, TextView textView10) {
        this.rootView = constraintLayout;
        this.attempsCount = textView;
        this.btn1 = frameLayout;
        this.btn1Text = textView2;
        this.btn2 = frameLayout2;
        this.btn2Text = textView3;
        this.btn3 = frameLayout3;
        this.btn3Text = textView4;
        this.btnBack = linearLayout;
        this.btnBuy = linearLayout2;
        this.btnSprint = frameLayout4;
        this.buttonPrice = textView5;
        this.buttonPriceIcon = imageView;
        this.buttonPriceIconTop = imageView2;
        this.buttonPriceRub = textView6;
        this.buttonPriceRubTop = textView7;
        this.dopInfo = linearLayout3;
        this.oldPrise = linearLayout4;
        this.oldPriseEmpty = textView8;
        this.oldPriseRv = recyclerView;
        this.priseListRv = recyclerView2;
        this.roulette = frameLayout5;
        this.rouletteView = rouletteView;
        this.textPrice = textView9;
        this.tvBuy = textView10;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static WinterBattlepassRouletteMainScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static WinterBattlepassRouletteMainScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.winter_battlepass_roulette_main_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static WinterBattlepassRouletteMainScreenBinding bind(View view) {
        int i = R.id.attempsCount;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.btn_1;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
            if (frameLayout != null) {
                i = R.id.btn_1_text;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.btn_2;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                    if (frameLayout2 != null) {
                        i = R.id.btn_2_text;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.btn_3;
                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout3 != null) {
                                i = R.id.btn_3_text;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView4 != null) {
                                    i = R.id.btn_back;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout != null) {
                                        i = R.id.btn_buy;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout2 != null) {
                                            i = R.id.btn_sprint;
                                            FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                            if (frameLayout4 != null) {
                                                i = R.id.buttonPrice;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView5 != null) {
                                                    i = R.id.buttonPriceIcon;
                                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView != null) {
                                                        i = R.id.buttonPriceIconTop;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView2 != null) {
                                                            i = R.id.buttonPriceRub;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = R.id.buttonPriceRubTop;
                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView7 != null) {
                                                                    i = R.id.dop_info;
                                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                    if (linearLayout3 != null) {
                                                                        i = R.id.old_prise;
                                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (linearLayout4 != null) {
                                                                            i = R.id.old_prise_empty;
                                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                            if (textView8 != null) {
                                                                                i = R.id.old_prise_rv;
                                                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                if (recyclerView != null) {
                                                                                    i = R.id.prise_list_rv;
                                                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                    if (recyclerView2 != null) {
                                                                                        i = R.id.roulette;
                                                                                        FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                                        if (frameLayout5 != null) {
                                                                                            i = R.id.roulette_view;
                                                                                            RouletteView rouletteView = (RouletteView) ViewBindings.findChildViewById(view, i);
                                                                                            if (rouletteView != null) {
                                                                                                i = R.id.textPrice;
                                                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView9 != null) {
                                                                                                    i = R.id.tv_buy;
                                                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (textView10 != null) {
                                                                                                        return new WinterBattlepassRouletteMainScreenBinding((ConstraintLayout) view, textView, frameLayout, textView2, frameLayout2, textView3, frameLayout3, textView4, linearLayout, linearLayout2, frameLayout4, textView5, imageView, imageView2, textView6, textView7, linearLayout3, linearLayout4, textView8, recyclerView, recyclerView2, frameLayout5, rouletteView, textView9, textView10);
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
