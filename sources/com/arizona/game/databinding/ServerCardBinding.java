package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
/* loaded from: classes3.dex */
public final class ServerCardBinding implements ViewBinding {
    public final AppCompatImageView imageView3;
    public final ImageView imageView4;
    public final AppCompatImageView materialCardView;
    public final TextView playersCount;
    private final ConstraintLayout rootView;
    public final ImageView serverLogo;
    public final ImageView serverLogoBgBg;
    public final TextView serverName;
    public final TextView serverType;

    private ServerCardBinding(ConstraintLayout rootView, AppCompatImageView imageView3, ImageView imageView4, AppCompatImageView materialCardView, TextView playersCount, ImageView serverLogo, ImageView serverLogoBgBg, TextView serverName, TextView serverType) {
        this.rootView = rootView;
        this.imageView3 = imageView3;
        this.imageView4 = imageView4;
        this.materialCardView = materialCardView;
        this.playersCount = playersCount;
        this.serverLogo = serverLogo;
        this.serverLogoBgBg = serverLogoBgBg;
        this.serverName = serverName;
        this.serverType = serverType;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ServerCardBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ServerCardBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.server_card, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ServerCardBinding bind(View rootView) {
        int i = R.id.imageView3;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
        if (appCompatImageView != null) {
            i = R.id.imageView4;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.materialCardView;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                if (appCompatImageView2 != null) {
                    i = R.id.players_count;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.server_logo;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView2 != null) {
                            i = R.id.server_logo_bg_bg;
                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView3 != null) {
                                i = R.id.server_name;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.server_type;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        return new ServerCardBinding((ConstraintLayout) rootView, appCompatImageView, imageView, appCompatImageView2, textView, imageView2, imageView3, textView2, textView3);
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
