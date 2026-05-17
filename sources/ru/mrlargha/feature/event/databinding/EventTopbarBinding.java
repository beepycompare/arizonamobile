package ru.mrlargha.feature.event.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.event.R;
/* loaded from: classes6.dex */
public final class EventTopbarBinding implements ViewBinding {
    public final ImageView backButton;
    public final LinearLayout moneyContainer;
    public final TextView moneyText;
    private final LinearLayout rootView;
    public final TextView tabMain;
    public final TextView tabShop;
    public final TextView tabTask;
    public final LinearLayout tabVideoBack;
    public final LinearLayout tabsContainer;
    public final LinearLayout videoTabsContainer;

    private EventTopbarBinding(LinearLayout linearLayout, ImageView imageView, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5) {
        this.rootView = linearLayout;
        this.backButton = imageView;
        this.moneyContainer = linearLayout2;
        this.moneyText = textView;
        this.tabMain = textView2;
        this.tabShop = textView3;
        this.tabTask = textView4;
        this.tabVideoBack = linearLayout3;
        this.tabsContainer = linearLayout4;
        this.videoTabsContainer = linearLayout5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EventTopbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EventTopbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.event_topbar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EventTopbarBinding bind(View view) {
        int i = R.id.back_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.money_container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout != null) {
                i = R.id.money_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.tab_main;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.tab_shop;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.tab_task;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.tab_video_back;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                if (linearLayout2 != null) {
                                    i = R.id.tabs_container;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout3 != null) {
                                        i = R.id.video_tabs_container;
                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout4 != null) {
                                            return new EventTopbarBinding((LinearLayout) view, imageView, linearLayout, textView, textView2, textView3, textView4, linearLayout2, linearLayout3, linearLayout4);
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
