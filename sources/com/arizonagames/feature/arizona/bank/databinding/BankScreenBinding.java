package com.arizonagames.feature.arizona.bank.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizonagames.feature.arizona.bank.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class BankScreenBinding implements ViewBinding {
    public final ImageView bankCardIssuePreviewBg;
    public final CustomCardView bankContent;
    public final CustomCardView bankContentFrame;
    public final ImageView bankLogo;
    public final FrameLayout bankPageContainer;
    public final FrameLayout bankScreen;
    public final RecyclerView bankTabsRecycler;
    public final CustomCardView buttonClose;
    private final FrameLayout rootView;

    private BankScreenBinding(FrameLayout frameLayout, ImageView imageView, CustomCardView customCardView, CustomCardView customCardView2, ImageView imageView2, FrameLayout frameLayout2, FrameLayout frameLayout3, RecyclerView recyclerView, CustomCardView customCardView3) {
        this.rootView = frameLayout;
        this.bankCardIssuePreviewBg = imageView;
        this.bankContent = customCardView;
        this.bankContentFrame = customCardView2;
        this.bankLogo = imageView2;
        this.bankPageContainer = frameLayout2;
        this.bankScreen = frameLayout3;
        this.bankTabsRecycler = recyclerView;
        this.buttonClose = customCardView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BankScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BankScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.bank_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static BankScreenBinding bind(View view) {
        int i = R.id.bank_card_issue_preview_bg;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.bank_content;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView != null) {
                i = R.id.bank_content_frame;
                CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView2 != null) {
                    i = R.id.bank_logo;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.bank_page_container;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            FrameLayout frameLayout2 = (FrameLayout) view;
                            i = R.id.bank_tabs_recycler;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                            if (recyclerView != null) {
                                i = R.id.button_close;
                                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                if (customCardView3 != null) {
                                    return new BankScreenBinding(frameLayout2, imageView, customCardView, customCardView2, imageView2, frameLayout, frameLayout2, recyclerView, customCardView3);
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
