package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes3.dex */
public final class HudTargetPlateTransportBinding implements ViewBinding {
    public final CustomCardView countContainer;
    public final CustomCardView legendTag;
    public final CustomCardView limitedTag;
    public final CustomCardView progressHealth;
    public final CustomCardView rareTag;
    private final CustomCardView rootView;
    public final CustomCardView trashTag;
    public final TextView tvCount;
    public final TextView tvHealth;
    public final TextView tvLegend;
    public final TextView tvLimited;
    public final TextView tvName;
    public final TextView tvRare;
    public final TextView tvTitleUserName;
    public final TextView tvTrash;
    public final TextView tvUserName;
    public final TextView tvUserNumber;

    private HudTargetPlateTransportBinding(CustomCardView rootView, CustomCardView countContainer, CustomCardView legendTag, CustomCardView limitedTag, CustomCardView progressHealth, CustomCardView rareTag, CustomCardView trashTag, TextView tvCount, TextView tvHealth, TextView tvLegend, TextView tvLimited, TextView tvName, TextView tvRare, TextView tvTitleUserName, TextView tvTrash, TextView tvUserName, TextView tvUserNumber) {
        this.rootView = rootView;
        this.countContainer = countContainer;
        this.legendTag = legendTag;
        this.limitedTag = limitedTag;
        this.progressHealth = progressHealth;
        this.rareTag = rareTag;
        this.trashTag = trashTag;
        this.tvCount = tvCount;
        this.tvHealth = tvHealth;
        this.tvLegend = tvLegend;
        this.tvLimited = tvLimited;
        this.tvName = tvName;
        this.tvRare = tvRare;
        this.tvTitleUserName = tvTitleUserName;
        this.tvTrash = tvTrash;
        this.tvUserName = tvUserName;
        this.tvUserNumber = tvUserNumber;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static HudTargetPlateTransportBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudTargetPlateTransportBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_target_plate_transport, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudTargetPlateTransportBinding bind(View rootView) {
        int i = R.id.count_container;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.legend_tag;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView2 != null) {
                i = R.id.limited_tag;
                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                if (customCardView3 != null) {
                    i = R.id.progress_health;
                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView4 != null) {
                        i = R.id.rare_tag;
                        CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                        if (customCardView5 != null) {
                            i = R.id.trash_tag;
                            CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                            if (customCardView6 != null) {
                                i = R.id.tv_count;
                                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView != null) {
                                    i = R.id.tv_health;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView2 != null) {
                                        i = R.id.tv_legend;
                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView3 != null) {
                                            i = R.id.tv_limited;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView4 != null) {
                                                i = R.id.tv_name;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView5 != null) {
                                                    i = R.id.tv_rare;
                                                    TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView6 != null) {
                                                        i = R.id.tv_title_user_name;
                                                        TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView7 != null) {
                                                            i = R.id.tv_trash;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView8 != null) {
                                                                i = R.id.tv_user_name;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView9 != null) {
                                                                    i = R.id.tv_user_number;
                                                                    TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (textView10 != null) {
                                                                        return new HudTargetPlateTransportBinding((CustomCardView) rootView, customCardView, customCardView2, customCardView3, customCardView4, customCardView5, customCardView6, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10);
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
