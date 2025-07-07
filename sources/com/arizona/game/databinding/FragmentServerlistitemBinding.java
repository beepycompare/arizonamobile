package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
/* loaded from: classes3.dex */
public final class FragmentServerlistitemBinding implements ViewBinding {
    public final ImageView favoriteAddButton;
    public final LinearLayout linearLayout;
    public final ImageView playButton;
    public final TextView playersCount;
    public final ImageView projectLogo;
    public final ImageView ring;
    private final LinearLayout rootView;
    public final ImageView serverLogo;
    public final TextView serverName;
    public final TextView serverNumber;

    private FragmentServerlistitemBinding(LinearLayout rootView, ImageView favoriteAddButton, LinearLayout linearLayout, ImageView playButton, TextView playersCount, ImageView projectLogo, ImageView ring, ImageView serverLogo, TextView serverName, TextView serverNumber) {
        this.rootView = rootView;
        this.favoriteAddButton = favoriteAddButton;
        this.linearLayout = linearLayout;
        this.playButton = playButton;
        this.playersCount = playersCount;
        this.projectLogo = projectLogo;
        this.ring = ring;
        this.serverLogo = serverLogo;
        this.serverName = serverName;
        this.serverNumber = serverNumber;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static FragmentServerlistitemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentServerlistitemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_serverlistitem, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentServerlistitemBinding bind(View rootView) {
        int i = R.id.favorite_add_button;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) rootView;
            i = R.id.play_button;
            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView2 != null) {
                i = R.id.players_count;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.project_logo;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView3 != null) {
                        i = R.id.ring;
                        ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView4 != null) {
                            i = R.id.server_logo;
                            ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView5 != null) {
                                i = R.id.server_name;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.serverNumber;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView3 != null) {
                                        return new FragmentServerlistitemBinding(linearLayout, imageView, linearLayout, imageView2, textView, imageView3, imageView4, imageView5, textView2, textView3);
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
