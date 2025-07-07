package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.androidplot.xy.XYPlot;
import com.arizona.game.R;
/* loaded from: classes3.dex */
public final class FragmentServerInfoBinding implements ViewBinding {
    public final ImageView backIcon;
    public final LinearLayout backLayout;
    public final TextView backText;
    public final ImageView donateButton;
    public final ImageView favorite;
    public final Button forumButton;
    public final ImageView imageView20;
    public final ImageView instButton;
    public final ImageView playButton;
    public final TextView playersCount;
    public final XYPlot plot;
    public final ImageView projectLogo;
    public final ImageView ring;
    private final ConstraintLayout rootView;
    public final ImageView serverBanner;
    public final ImageView serverLogo;
    public final TextView serverName;
    public final Button siteButton;
    public final ImageView telegramButton;
    public final TextView textView19;
    public final ImageView vkButton;

    private FragmentServerInfoBinding(ConstraintLayout rootView, ImageView backIcon, LinearLayout backLayout, TextView backText, ImageView donateButton, ImageView favorite, Button forumButton, ImageView imageView20, ImageView instButton, ImageView playButton, TextView playersCount, XYPlot plot, ImageView projectLogo, ImageView ring, ImageView serverBanner, ImageView serverLogo, TextView serverName, Button siteButton, ImageView telegramButton, TextView textView19, ImageView vkButton) {
        this.rootView = rootView;
        this.backIcon = backIcon;
        this.backLayout = backLayout;
        this.backText = backText;
        this.donateButton = donateButton;
        this.favorite = favorite;
        this.forumButton = forumButton;
        this.imageView20 = imageView20;
        this.instButton = instButton;
        this.playButton = playButton;
        this.playersCount = playersCount;
        this.plot = plot;
        this.projectLogo = projectLogo;
        this.ring = ring;
        this.serverBanner = serverBanner;
        this.serverLogo = serverLogo;
        this.serverName = serverName;
        this.siteButton = siteButton;
        this.telegramButton = telegramButton;
        this.textView19 = textView19;
        this.vkButton = vkButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentServerInfoBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentServerInfoBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_server_info, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentServerInfoBinding bind(View rootView) {
        int i = R.id.back_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
        if (imageView != null) {
            i = R.id.back_layout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.back_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.donate_button;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                    if (imageView2 != null) {
                        i = R.id.favorite;
                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView3 != null) {
                            i = R.id.forum_button;
                            Button button = (Button) ViewBindings.findChildViewById(rootView, i);
                            if (button != null) {
                                i = R.id.imageView20;
                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                if (imageView4 != null) {
                                    i = R.id.inst_button;
                                    ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView5 != null) {
                                        i = R.id.play_button;
                                        ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (imageView6 != null) {
                                            i = R.id.players_count;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView2 != null) {
                                                i = R.id.plot;
                                                XYPlot xYPlot = (XYPlot) ViewBindings.findChildViewById(rootView, i);
                                                if (xYPlot != null) {
                                                    i = R.id.project_logo;
                                                    ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                    if (imageView7 != null) {
                                                        i = R.id.ring;
                                                        ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (imageView8 != null) {
                                                            i = R.id.server_banner;
                                                            ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                            if (imageView9 != null) {
                                                                i = R.id.server_logo;
                                                                ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                if (imageView10 != null) {
                                                                    i = R.id.server_name;
                                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView3 != null) {
                                                                        i = R.id.site_button;
                                                                        Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
                                                                        if (button2 != null) {
                                                                            i = R.id.telegram_button;
                                                                            ImageView imageView11 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                            if (imageView11 != null) {
                                                                                i = R.id.textView19;
                                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                                if (textView4 != null) {
                                                                                    i = R.id.vk_button;
                                                                                    ImageView imageView12 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                                    if (imageView12 != null) {
                                                                                        return new FragmentServerInfoBinding((ConstraintLayout) rootView, imageView, linearLayout, textView, imageView2, imageView3, button, imageView4, imageView5, imageView6, textView2, xYPlot, imageView7, imageView8, imageView9, imageView10, textView3, button2, imageView11, textView4, imageView12);
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
