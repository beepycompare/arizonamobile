package ru.mrlargha.feature.arizona.cases.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.arizona.cases.R;
/* loaded from: classes6.dex */
public final class ArizonaCasesScreenBinding implements ViewBinding {
    public final LinearLayout backContainer;
    public final LinearLayout btnClose;
    public final FrameLayout btnSkip;
    public final CustomCardView cardInfo;
    public final ConstraintLayout cases;
    public final FrameLayout content;
    public final FrameLayout contentContainer;
    public final ProgressBar diamondProgress;
    public final FrameLayout goldBox;
    public final ImageView ivBack;
    public final ArizonaCasesMainPageBinding mainPage;
    public final ArizonaCasesOpenPageBinding openPage;
    public final View overlay;
    public final ProgressBar progressBar;
    private final ConstraintLayout rootView;
    public final LinearLayout skipVideo;
    public final TextView textBonus;
    public final FrameLayout topBar;
    public final TextView tvDiamondProgress;
    public final TextView tvTitle;
    public final PlayerView videoAdviceBg;

    private ArizonaCasesScreenBinding(ConstraintLayout constraintLayout, LinearLayout linearLayout, LinearLayout linearLayout2, FrameLayout frameLayout, CustomCardView customCardView, ConstraintLayout constraintLayout2, FrameLayout frameLayout2, FrameLayout frameLayout3, ProgressBar progressBar, FrameLayout frameLayout4, ImageView imageView, ArizonaCasesMainPageBinding arizonaCasesMainPageBinding, ArizonaCasesOpenPageBinding arizonaCasesOpenPageBinding, View view, ProgressBar progressBar2, LinearLayout linearLayout3, TextView textView, FrameLayout frameLayout5, TextView textView2, TextView textView3, PlayerView playerView) {
        this.rootView = constraintLayout;
        this.backContainer = linearLayout;
        this.btnClose = linearLayout2;
        this.btnSkip = frameLayout;
        this.cardInfo = customCardView;
        this.cases = constraintLayout2;
        this.content = frameLayout2;
        this.contentContainer = frameLayout3;
        this.diamondProgress = progressBar;
        this.goldBox = frameLayout4;
        this.ivBack = imageView;
        this.mainPage = arizonaCasesMainPageBinding;
        this.openPage = arizonaCasesOpenPageBinding;
        this.overlay = view;
        this.progressBar = progressBar2;
        this.skipVideo = linearLayout3;
        this.textBonus = textView;
        this.topBar = frameLayout5;
        this.tvDiamondProgress = textView2;
        this.tvTitle = textView3;
        this.videoAdviceBg = playerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ArizonaCasesScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ArizonaCasesScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.arizona_cases_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ArizonaCasesScreenBinding bind(View view) {
        View findChildViewById;
        int i = R.id.back_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.btn_close;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.btn_skip;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout != null) {
                    i = R.id.card_info;
                    CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.content;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout2 != null) {
                            i = R.id.content_container;
                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout3 != null) {
                                i = R.id.diamond_progress;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                if (progressBar != null) {
                                    i = R.id.gold_box;
                                    FrameLayout frameLayout4 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                    if (frameLayout4 != null) {
                                        i = R.id.iv_back;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                                        if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.main_page))) != null) {
                                            ArizonaCasesMainPageBinding bind = ArizonaCasesMainPageBinding.bind(findChildViewById);
                                            i = R.id.open_page;
                                            View findChildViewById2 = ViewBindings.findChildViewById(view, i);
                                            if (findChildViewById2 != null) {
                                                ArizonaCasesOpenPageBinding bind2 = ArizonaCasesOpenPageBinding.bind(findChildViewById2);
                                                i = R.id.overlay;
                                                View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                                                if (findChildViewById3 != null) {
                                                    i = R.id.progress_bar;
                                                    ProgressBar progressBar2 = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                                    if (progressBar2 != null) {
                                                        i = R.id.skip_video;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.text_bonus;
                                                            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView != null) {
                                                                i = R.id.top_bar;
                                                                FrameLayout frameLayout5 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                                                if (frameLayout5 != null) {
                                                                    i = R.id.tv_diamond_progress;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView2 != null) {
                                                                        i = R.id.tv_title;
                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView3 != null) {
                                                                            i = R.id.video_advice_bg;
                                                                            PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(view, i);
                                                                            if (playerView != null) {
                                                                                return new ArizonaCasesScreenBinding(constraintLayout, linearLayout, linearLayout2, frameLayout, customCardView, constraintLayout, frameLayout2, frameLayout3, progressBar, frameLayout4, imageView, bind, bind2, findChildViewById3, progressBar2, linearLayout3, textView, frameLayout5, textView2, textView3, playerView);
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
