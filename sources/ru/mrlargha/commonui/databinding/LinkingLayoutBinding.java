package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class LinkingLayoutBinding implements ViewBinding {
    public final Guideline centerLine;
    public final TextView defenceAccountTitle;
    public final TextView defenceTitle;
    public final TextView description;
    public final ImageView exitButton;
    public final Guideline leftLine;
    public final ConstraintLayout linkingLayout;
    public final ConstraintLayout payDayButton;
    public final ConstraintLayout payDayButtonIcContainer;
    public final Guideline rightLine;
    private final ConstraintLayout rootView;
    public final ConstraintLayout tgButton;
    public final Guideline tgButtonTopLine;
    public final ImageView tgIc;
    public final Guideline topLine;
    public final ConstraintLayout vipStatusButton;
    public final ConstraintLayout vipStatusButtonIcContainer;
    public final ConstraintLayout vkButton;
    public final ImageView vkIc;

    private LinkingLayoutBinding(ConstraintLayout rootView, Guideline centerLine, TextView defenceAccountTitle, TextView defenceTitle, TextView description, ImageView exitButton, Guideline leftLine, ConstraintLayout linkingLayout, ConstraintLayout payDayButton, ConstraintLayout payDayButtonIcContainer, Guideline rightLine, ConstraintLayout tgButton, Guideline tgButtonTopLine, ImageView tgIc, Guideline topLine, ConstraintLayout vipStatusButton, ConstraintLayout vipStatusButtonIcContainer, ConstraintLayout vkButton, ImageView vkIc) {
        this.rootView = rootView;
        this.centerLine = centerLine;
        this.defenceAccountTitle = defenceAccountTitle;
        this.defenceTitle = defenceTitle;
        this.description = description;
        this.exitButton = exitButton;
        this.leftLine = leftLine;
        this.linkingLayout = linkingLayout;
        this.payDayButton = payDayButton;
        this.payDayButtonIcContainer = payDayButtonIcContainer;
        this.rightLine = rightLine;
        this.tgButton = tgButton;
        this.tgButtonTopLine = tgButtonTopLine;
        this.tgIc = tgIc;
        this.topLine = topLine;
        this.vipStatusButton = vipStatusButton;
        this.vipStatusButtonIcContainer = vipStatusButtonIcContainer;
        this.vkButton = vkButton;
        this.vkIc = vkIc;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static LinkingLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static LinkingLayoutBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.linking_layout, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static LinkingLayoutBinding bind(View rootView) {
        int i = R.id.center_line;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.defence_account_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.defence_title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.description;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        i = R.id.exit_button;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                        if (imageView != null) {
                            i = R.id.left_line;
                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                            if (guideline2 != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                i = R.id.pay_day_button;
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                if (constraintLayout2 != null) {
                                    i = R.id.pay_day_button_ic_container;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout3 != null) {
                                        i = R.id.right_line;
                                        Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline3 != null) {
                                            i = R.id.tg_button;
                                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                            if (constraintLayout4 != null) {
                                                i = R.id.tg_button_top_line;
                                                Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline4 != null) {
                                                    i = R.id.tg_ic;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                    if (imageView2 != null) {
                                                        i = R.id.top_line;
                                                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                        if (guideline5 != null) {
                                                            i = R.id.vip_status_button;
                                                            ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                            if (constraintLayout5 != null) {
                                                                i = R.id.vip_status_button_ic_container;
                                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                if (constraintLayout6 != null) {
                                                                    i = R.id.vk_button;
                                                                    ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                                                    if (constraintLayout7 != null) {
                                                                        i = R.id.vk_ic;
                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                        if (imageView3 != null) {
                                                                            return new LinkingLayoutBinding(constraintLayout, guideline, textView, textView2, textView3, imageView, guideline2, constraintLayout, constraintLayout2, constraintLayout3, guideline3, constraintLayout4, guideline4, imageView2, guideline5, constraintLayout5, constraintLayout6, constraintLayout7, imageView3);
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
