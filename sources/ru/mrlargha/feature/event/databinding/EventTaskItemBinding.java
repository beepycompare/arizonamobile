package ru.mrlargha.feature.event.databinding;

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
import ru.mrlargha.feature.event.R;
/* loaded from: classes3.dex */
public final class EventTaskItemBinding implements ViewBinding {
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

    private EventTaskItemBinding(FrameLayout frameLayout, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ImageView imageView2, ProgressBar progressBar, LinearLayout linearLayout4, RecyclerView recyclerView, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, CardView cardView, CardView cardView2) {
        this.rootView = frameLayout;
        this.bgImg = imageView;
        this.btnGet = linearLayout;
        this.completeTextContainer = linearLayout2;
        this.errorOverlay = linearLayout3;
        this.ivCheckMark = imageView2;
        this.progressBar = progressBar;
        this.progressBarContainer = linearLayout4;
        this.rvTaskPrise = recyclerView;
        this.tvBtnGet = textView;
        this.tvCompletePercent = textView2;
        this.tvDescription = textView3;
        this.tvErrorText = textView4;
        this.tvName = textView5;
        this.tvTaskCount = textView6;
        this.typeEveryday = cardView;
        this.typeStory = cardView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static EventTaskItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EventTaskItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.event_task_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EventTaskItemBinding bind(View view) {
        int i = R.id.bg_img;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.btn_get;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.complete_text_container;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout2 != null) {
                    i = R.id.error_overlay;
                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout3 != null) {
                        i = R.id.iv_check_mark;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                        if (imageView2 != null) {
                            i = R.id.progress_bar;
                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                            if (progressBar != null) {
                                i = R.id.progress_bar_container;
                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout4 != null) {
                                    i = R.id.rv_task_prise;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                    if (recyclerView != null) {
                                        i = R.id.tv_btn_get;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView != null) {
                                            i = R.id.tv_complete_percent;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView2 != null) {
                                                i = R.id.tv_description;
                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView3 != null) {
                                                    i = R.id.tv_error_text;
                                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView4 != null) {
                                                        i = R.id.tv_name;
                                                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView5 != null) {
                                                            i = R.id.tv_task_count;
                                                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView6 != null) {
                                                                i = R.id.type_everyday;
                                                                CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
                                                                if (cardView != null) {
                                                                    i = R.id.type_story;
                                                                    CardView cardView2 = (CardView) ViewBindings.findChildViewById(view, i);
                                                                    if (cardView2 != null) {
                                                                        return new EventTaskItemBinding((FrameLayout) view, imageView, linearLayout, linearLayout2, linearLayout3, imageView2, progressBar, linearLayout4, recyclerView, textView, textView2, textView3, textView4, textView5, textView6, cardView, cardView2);
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
