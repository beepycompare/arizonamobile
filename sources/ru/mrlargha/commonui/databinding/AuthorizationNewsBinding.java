package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AuthorizationNewsBinding implements ViewBinding {
    public final ConstraintLayout authorizationNews;
    public final ConstraintLayout authorizationNewsCloseButton;
    public final AppCompatImageView authorizationNewsCloseButtonIc;
    public final ConstraintLayout authorizationNewsContainer;
    public final ConstraintLayout authorizationNewsOpenButton;
    public final AppCompatImageView authorizationNewsOpenButtonIc;
    public final RecyclerView authorizationNewsRc;
    public final TextView authorizationNewsTitle;
    private final ConstraintLayout rootView;

    private AuthorizationNewsBinding(ConstraintLayout rootView, ConstraintLayout authorizationNews, ConstraintLayout authorizationNewsCloseButton, AppCompatImageView authorizationNewsCloseButtonIc, ConstraintLayout authorizationNewsContainer, ConstraintLayout authorizationNewsOpenButton, AppCompatImageView authorizationNewsOpenButtonIc, RecyclerView authorizationNewsRc, TextView authorizationNewsTitle) {
        this.rootView = rootView;
        this.authorizationNews = authorizationNews;
        this.authorizationNewsCloseButton = authorizationNewsCloseButton;
        this.authorizationNewsCloseButtonIc = authorizationNewsCloseButtonIc;
        this.authorizationNewsContainer = authorizationNewsContainer;
        this.authorizationNewsOpenButton = authorizationNewsOpenButton;
        this.authorizationNewsOpenButtonIc = authorizationNewsOpenButtonIc;
        this.authorizationNewsRc = authorizationNewsRc;
        this.authorizationNewsTitle = authorizationNewsTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AuthorizationNewsBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AuthorizationNewsBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.authorization_news, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuthorizationNewsBinding bind(View rootView) {
        ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
        int i = R.id.authorization_news_close_button;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
        if (constraintLayout2 != null) {
            i = R.id.authorization_news_close_button_ic;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
            if (appCompatImageView != null) {
                i = R.id.authorization_news_container;
                ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                if (constraintLayout3 != null) {
                    i = R.id.authorization_news_open_button;
                    ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                    if (constraintLayout4 != null) {
                        i = R.id.authorization_news_open_button_ic;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                        if (appCompatImageView2 != null) {
                            i = R.id.authorization_news_rc;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                            if (recyclerView != null) {
                                i = R.id.authorization_news_title;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView != null) {
                                    return new AuthorizationNewsBinding(constraintLayout, constraintLayout, constraintLayout2, appCompatImageView, constraintLayout3, constraintLayout4, appCompatImageView2, recyclerView, textView);
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
