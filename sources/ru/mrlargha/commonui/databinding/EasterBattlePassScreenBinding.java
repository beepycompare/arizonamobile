package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class EasterBattlePassScreenBinding implements ViewBinding {
    public final ImageView backButton;
    public final LinearLayout bg;
    public final ConstraintLayout easterBattlepassChoose;
    public final EasterBattlePassEventScreenBinding events;
    public final TextView infoText;
    public final FrameLayout infoTextBg;
    public final EasterBattlePassMainScreenBinding main;
    public final LinearLayout moneyContainer;
    public final TextView moneyText;
    public final EasterBattlePassMainResultScreenBinding resultMain;
    private final ConstraintLayout rootView;
    public final EasterBattlePassShopSceenBinding shop;
    public final TextView tabEvent;
    public final TextView tabMain;
    public final TextView tabShop;
    public final TextView tabTask;
    public final LinearLayout tabVideoBack;
    public final LinearLayout tabsContainer;
    public final EasterBattlePassTaskScreenBinding task;
    public final LinearLayout topElements;
    public final EasterBattlePassVideoScreenBinding video;
    public final LinearLayout videoTabsContainer;

    private EasterBattlePassScreenBinding(ConstraintLayout rootView, ImageView backButton, LinearLayout bg, ConstraintLayout easterBattlepassChoose, EasterBattlePassEventScreenBinding events, TextView infoText, FrameLayout infoTextBg, EasterBattlePassMainScreenBinding main, LinearLayout moneyContainer, TextView moneyText, EasterBattlePassMainResultScreenBinding resultMain, EasterBattlePassShopSceenBinding shop, TextView tabEvent, TextView tabMain, TextView tabShop, TextView tabTask, LinearLayout tabVideoBack, LinearLayout tabsContainer, EasterBattlePassTaskScreenBinding task, LinearLayout topElements, EasterBattlePassVideoScreenBinding video, LinearLayout videoTabsContainer) {
        this.rootView = rootView;
        this.backButton = backButton;
        this.bg = bg;
        this.easterBattlepassChoose = easterBattlepassChoose;
        this.events = events;
        this.infoText = infoText;
        this.infoTextBg = infoTextBg;
        this.main = main;
        this.moneyContainer = moneyContainer;
        this.moneyText = moneyText;
        this.resultMain = resultMain;
        this.shop = shop;
        this.tabEvent = tabEvent;
        this.tabMain = tabMain;
        this.tabShop = tabShop;
        this.tabTask = tabTask;
        this.tabVideoBack = tabVideoBack;
        this.tabsContainer = tabsContainer;
        this.task = task;
        this.topElements = topElements;
        this.video = video;
        this.videoTabsContainer = videoTabsContainer;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EasterBattlePassScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EasterBattlePassScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.easter_battle_pass_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EasterBattlePassScreenBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        View findChildViewById4;
        int i = R.id.back_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.bg;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.events;
                View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                if (findChildViewById5 != null) {
                    EasterBattlePassEventScreenBinding bind = EasterBattlePassEventScreenBinding.bind(findChildViewById5);
                    i = R.id.info_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.info_text_bg;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                        if (frameLayout != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.main))) != null) {
                            EasterBattlePassMainScreenBinding bind2 = EasterBattlePassMainScreenBinding.bind(findChildViewById);
                            i = R.id.money_container;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                            if (linearLayout2 != null) {
                                i = R.id.money_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.result_main))) != null) {
                                    EasterBattlePassMainResultScreenBinding bind3 = EasterBattlePassMainResultScreenBinding.bind(findChildViewById2);
                                    i = R.id.shop;
                                    View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                                    if (findChildViewById6 != null) {
                                        EasterBattlePassShopSceenBinding bind4 = EasterBattlePassShopSceenBinding.bind(findChildViewById6);
                                        i = R.id.tab_event;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView3 != null) {
                                            i = R.id.tab_main;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView4 != null) {
                                                i = R.id.tab_shop;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView5 != null) {
                                                    i = R.id.tab_task;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView6 != null) {
                                                        i = R.id.tab_video_back;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.tabs_container;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (linearLayout4 != null && (findChildViewById3 = ViewBindings.findChildViewById(rootView, (i = R.id.task))) != null) {
                                                                EasterBattlePassTaskScreenBinding bind5 = EasterBattlePassTaskScreenBinding.bind(findChildViewById3);
                                                                i = R.id.top_elements;
                                                                LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (linearLayout5 != null && (findChildViewById4 = ViewBindings.findChildViewById(rootView, (i = R.id.video))) != null) {
                                                                    EasterBattlePassVideoScreenBinding bind6 = EasterBattlePassVideoScreenBinding.bind(findChildViewById4);
                                                                    i = R.id.video_tabs_container;
                                                                    LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (linearLayout6 != null) {
                                                                        return new EasterBattlePassScreenBinding(constraintLayout, imageView, linearLayout, constraintLayout, bind, textView, frameLayout, bind2, linearLayout2, textView2, bind3, bind4, textView3, textView4, textView5, textView6, linearLayout3, linearLayout4, bind5, linearLayout5, bind6, linearLayout6);
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
