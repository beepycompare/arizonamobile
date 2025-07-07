package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class EasterBattlePassTaskItemBinding implements ViewBinding {
    public final ImageView bgImg;
    public final LinearLayout btnGet;
    public final LinearLayout completeTextContainer;
    public final LinearLayout errorOverlay;
    public final ImageView ivCheckMark;
    public final ProgressBar progressBar;
    public final LinearLayout progressBarContainer;
    private final FrameLayout rootView;
    public final RecyclerView rvTaskPrise;
    public final TextView tvBtnGet;
    public final TextView tvCompletePercent;
    public final TextView tvDescription;
    public final TextView tvErrorText;
    public final TextView tvName;
    public final TextView tvTaskCount;
    public final CardView typeEveryday;
    public final CardView typeStory;

    private EasterBattlePassTaskItemBinding(FrameLayout rootView, ImageView bgImg, LinearLayout btnGet, LinearLayout completeTextContainer, LinearLayout errorOverlay, ImageView ivCheckMark, ProgressBar progressBar, LinearLayout progressBarContainer, RecyclerView rvTaskPrise, TextView tvBtnGet, TextView tvCompletePercent, TextView tvDescription, TextView tvErrorText, TextView tvName, TextView tvTaskCount, CardView typeEveryday, CardView typeStory) {
        this.rootView = rootView;
        this.bgImg = bgImg;
        this.btnGet = btnGet;
        this.completeTextContainer = completeTextContainer;
        this.errorOverlay = errorOverlay;
        this.ivCheckMark = ivCheckMark;
        this.progressBar = progressBar;
        this.progressBarContainer = progressBarContainer;
        this.rvTaskPrise = rvTaskPrise;
        this.tvBtnGet = tvBtnGet;
        this.tvCompletePercent = tvCompletePercent;
        this.tvDescription = tvDescription;
        this.tvErrorText = tvErrorText;
        this.tvName = tvName;
        this.tvTaskCount = tvTaskCount;
        this.typeEveryday = typeEveryday;
        this.typeStory = typeStory;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static EasterBattlePassTaskItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EasterBattlePassTaskItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.easter_battle_pass_task_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EasterBattlePassTaskItemBinding bind(View rootView) {
        int i = R.id.bg_img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.btn_get;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.complete_text_container;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                if (linearLayout2 != null) {
                    i = R.id.error_overlay;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout3 != null) {
                        i = R.id.iv_check_mark;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView2 != null) {
                            i = R.id.progress_bar;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(rootView, i);
                            if (progressBar != null) {
                                i = R.id.progress_bar_container;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                if (linearLayout4 != null) {
                                    i = R.id.rv_task_prise;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                    if (recyclerView != null) {
                                        i = R.id.tv_btn_get;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView != null) {
                                            i = R.id.tv_complete_percent;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView2 != null) {
                                                i = R.id.tv_description;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView3 != null) {
                                                    i = R.id.tv_error_text;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_name;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_task_count;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView6 != null) {
                                                                i = R.id.type_everyday;
                                                                CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
                                                                if (cardView != null) {
                                                                    i = R.id.type_story;
                                                                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (cardView2 != null) {
                                                                        return new EasterBattlePassTaskItemBinding((FrameLayout) rootView, imageView, linearLayout, linearLayout2, linearLayout3, imageView2, progressBar, linearLayout4, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, cardView, cardView2);
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
