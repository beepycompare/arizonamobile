package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class HudElementTimeBinding implements ViewBinding {
    public final TextView btnClose;
    public final HudElementTimeItemBinding card0;
    public final HudElementTimeItemBinding card1;
    public final HudElementTimeItemBinding card2;
    public final HudElementTimeItemBinding card3;
    public final HudElementTimeItemBinding card4;
    public final HudElementTimeItemBinding card5;
    public final HudElementTimeItemBinding card6;
    public final CustomCardView close;
    public final LinearLayout layoutCardsRow1;
    public final LinearLayout layoutCardsRow2;
    public final LinearLayout layoutCardsRow3;
    public final LinearLayout layoutOnlineInfo;
    public final LinearLayout main;
    public final FrameLayout promo;
    private final FrameLayout rootView;
    public final TextView tvDate;
    public final TextView tvHourLabel;
    public final TextView tvHourTime;
    public final TextView tvOnlineLabel;
    public final TextView tvTime;
    public final TextView tvTodayLabel;
    public final TextView tvTodayTime;

    private HudElementTimeBinding(FrameLayout rootView, TextView btnClose, HudElementTimeItemBinding card0, HudElementTimeItemBinding card1, HudElementTimeItemBinding card2, HudElementTimeItemBinding card3, HudElementTimeItemBinding card4, HudElementTimeItemBinding card5, HudElementTimeItemBinding card6, CustomCardView close, LinearLayout layoutCardsRow1, LinearLayout layoutCardsRow2, LinearLayout layoutCardsRow3, LinearLayout layoutOnlineInfo, LinearLayout main, FrameLayout promo, TextView tvDate, TextView tvHourLabel, TextView tvHourTime, TextView tvOnlineLabel, TextView tvTime, TextView tvTodayLabel, TextView tvTodayTime) {
        this.rootView = rootView;
        this.btnClose = btnClose;
        this.card0 = card0;
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.card4 = card4;
        this.card5 = card5;
        this.card6 = card6;
        this.close = close;
        this.layoutCardsRow1 = layoutCardsRow1;
        this.layoutCardsRow2 = layoutCardsRow2;
        this.layoutCardsRow3 = layoutCardsRow3;
        this.layoutOnlineInfo = layoutOnlineInfo;
        this.main = main;
        this.promo = promo;
        this.tvDate = tvDate;
        this.tvHourLabel = tvHourLabel;
        this.tvHourTime = tvHourTime;
        this.tvOnlineLabel = tvOnlineLabel;
        this.tvTime = tvTime;
        this.tvTodayLabel = tvTodayLabel;
        this.tvTodayTime = tvTodayTime;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementTimeBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementTimeBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_time, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementTimeBinding bind(View rootView) {
        View findChildViewById;
        int i = R.id.btnClose;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.card0))) != null) {
            HudElementTimeItemBinding bind = HudElementTimeItemBinding.bind(findChildViewById);
            i = R.id.card1;
            View findChildViewById2 = ViewBindings.findChildViewById(rootView, i);
            if (findChildViewById2 != null) {
                HudElementTimeItemBinding bind2 = HudElementTimeItemBinding.bind(findChildViewById2);
                i = R.id.card2;
                View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
                if (findChildViewById3 != null) {
                    HudElementTimeItemBinding bind3 = HudElementTimeItemBinding.bind(findChildViewById3);
                    i = R.id.card3;
                    View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                    if (findChildViewById4 != null) {
                        HudElementTimeItemBinding bind4 = HudElementTimeItemBinding.bind(findChildViewById4);
                        i = R.id.card4;
                        View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                        if (findChildViewById5 != null) {
                            HudElementTimeItemBinding bind5 = HudElementTimeItemBinding.bind(findChildViewById5);
                            i = R.id.card5;
                            View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                            if (findChildViewById6 != null) {
                                HudElementTimeItemBinding bind6 = HudElementTimeItemBinding.bind(findChildViewById6);
                                i = R.id.card6;
                                View findChildViewById7 = ViewBindings.findChildViewById(rootView, i);
                                if (findChildViewById7 != null) {
                                    HudElementTimeItemBinding bind7 = HudElementTimeItemBinding.bind(findChildViewById7);
                                    i = R.id.close;
                                    CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                                    if (customCardView != null) {
                                        i = R.id.layoutCardsRow1;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout != null) {
                                            i = R.id.layoutCardsRow2;
                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (linearLayout2 != null) {
                                                i = R.id.layoutCardsRow3;
                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                if (linearLayout3 != null) {
                                                    i = R.id.layoutOnlineInfo;
                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                    if (linearLayout4 != null) {
                                                        i = R.id.main;
                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (linearLayout5 != null) {
                                                            FrameLayout frameLayout = (FrameLayout) rootView;
                                                            i = R.id.tvDate;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView2 != null) {
                                                                i = R.id.tvHourLabel;
                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView3 != null) {
                                                                    i = R.id.tvHourTime;
                                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView4 != null) {
                                                                        i = R.id.tvOnlineLabel;
                                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (textView5 != null) {
                                                                            i = R.id.tvTime;
                                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (textView6 != null) {
                                                                                i = R.id.tvTodayLabel;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.tvTodayTime;
                                                                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (textView8 != null) {
                                                                                        return new HudElementTimeBinding(frameLayout, textView, bind, bind2, bind3, bind4, bind5, bind6, bind7, customCardView, linearLayout, linearLayout2, linearLayout3, linearLayout4, linearLayout5, frameLayout, textView2, textView3, textView4, textView5, textView6, textView7, textView8);
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
