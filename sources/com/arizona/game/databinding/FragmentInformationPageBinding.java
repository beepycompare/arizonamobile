package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arizona.game.R;
/* loaded from: classes3.dex */
public final class FragmentInformationPageBinding implements ViewBinding {
    public final TextView backText2;
    public final LinearLayout discordButton;
    public final Guideline donateTopLine;
    public final LinearLayout forumButton;
    public final TextView gameCacheUpdateStatus;
    public final ConstraintLayout gameStatusBg;
    public final Guideline guideline27;
    public final ConstraintLayout mainLayout;
    public final ImageView notificationBell;
    public final RecyclerView recentPlayedServersRecycler;
    public final Flow resourcesFlow;
    private final ConstraintLayout rootView;
    public final ImageView shopIc;
    public final RecyclerView storiesRecycler;
    public final LinearLayout tgButton;
    public final LinearLayout vkButton;

    private FragmentInformationPageBinding(ConstraintLayout rootView, TextView backText2, LinearLayout discordButton, Guideline donateTopLine, LinearLayout forumButton, TextView gameCacheUpdateStatus, ConstraintLayout gameStatusBg, Guideline guideline27, ConstraintLayout mainLayout, ImageView notificationBell, RecyclerView recentPlayedServersRecycler, Flow resourcesFlow, ImageView shopIc, RecyclerView storiesRecycler, LinearLayout tgButton, LinearLayout vkButton) {
        this.rootView = rootView;
        this.backText2 = backText2;
        this.discordButton = discordButton;
        this.donateTopLine = donateTopLine;
        this.forumButton = forumButton;
        this.gameCacheUpdateStatus = gameCacheUpdateStatus;
        this.gameStatusBg = gameStatusBg;
        this.guideline27 = guideline27;
        this.mainLayout = mainLayout;
        this.notificationBell = notificationBell;
        this.recentPlayedServersRecycler = recentPlayedServersRecycler;
        this.resourcesFlow = resourcesFlow;
        this.shopIc = shopIc;
        this.storiesRecycler = storiesRecycler;
        this.tgButton = tgButton;
        this.vkButton = vkButton;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FragmentInformationPageBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static FragmentInformationPageBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.fragment_information_page, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static FragmentInformationPageBinding bind(View rootView) {
        int i = R.id.back_text2;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.discord_button;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.donate_top_line;
                Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline != null) {
                    i = R.id.forum_button;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout2 != null) {
                        i = R.id.game_cache_update_status;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.game_status_bg;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout != null) {
                                i = R.id.guideline27;
                                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                if (guideline2 != null) {
                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) rootView;
                                    i = R.id.notification_bell;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                    if (imageView != null) {
                                        i = R.id.recent_played_servers_recycler;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                        if (recyclerView != null) {
                                            i = R.id.resources_flow;
                                            Flow flow = (Flow) ViewBindings.findChildViewById(rootView, i);
                                            if (flow != null) {
                                                i = R.id.shop_ic;
                                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                if (imageView2 != null) {
                                                    i = R.id.stories_recycler;
                                                    RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                                    if (recyclerView2 != null) {
                                                        i = R.id.tg_button;
                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                        if (linearLayout3 != null) {
                                                            i = R.id.vk_button;
                                                            LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (linearLayout4 != null) {
                                                                return new FragmentInformationPageBinding(constraintLayout2, textView, linearLayout, guideline, linearLayout2, textView2, constraintLayout, guideline2, constraintLayout2, imageView, recyclerView, flow, imageView2, recyclerView2, linearLayout3, linearLayout4);
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
