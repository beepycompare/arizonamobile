package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AuthorizationNewsItemBinding implements ViewBinding {
    public final TextView authorizationNewsDate;
    public final TextView authorizationNewsDescription;
    public final ConstraintLayout authorizationNewsItem;
    public final AppCompatImageView authorizationNewsItemBanner;
    private final ConstraintLayout rootView;

    private AuthorizationNewsItemBinding(ConstraintLayout rootView, TextView authorizationNewsDate, TextView authorizationNewsDescription, ConstraintLayout authorizationNewsItem, AppCompatImageView authorizationNewsItemBanner) {
        this.rootView = rootView;
        this.authorizationNewsDate = authorizationNewsDate;
        this.authorizationNewsDescription = authorizationNewsDescription;
        this.authorizationNewsItem = authorizationNewsItem;
        this.authorizationNewsItemBanner = authorizationNewsItemBanner;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AuthorizationNewsItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AuthorizationNewsItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.authorization_news_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AuthorizationNewsItemBinding bind(View rootView) {
        int i = R.id.authorization_news_date;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.authorization_news_description;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.authorization_news_item_banner;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageView != null) {
                    return new AuthorizationNewsItemBinding(constraintLayout, textView, textView2, constraintLayout, appCompatImageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
