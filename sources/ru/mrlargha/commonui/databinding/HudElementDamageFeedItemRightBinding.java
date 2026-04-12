package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.StrokeTextView;
/* loaded from: classes3.dex */
public final class HudElementDamageFeedItemRightBinding implements ViewBinding {
    public final CustomCardView cardId;
    public final LinearLayout container;
    public final ImageView ivWeapon;
    public final FrameLayout root;
    private final FrameLayout rootView;
    public final TextView tvId;
    public final StrokeTextView tvName;
    public final StrokeTextView tvValue;
    public final StrokeTextView tvValueTotal;

    private HudElementDamageFeedItemRightBinding(FrameLayout rootView, CustomCardView cardId, LinearLayout container, ImageView ivWeapon, FrameLayout root, TextView tvId, StrokeTextView tvName, StrokeTextView tvValue, StrokeTextView tvValueTotal) {
        this.rootView = rootView;
        this.cardId = cardId;
        this.container = container;
        this.ivWeapon = ivWeapon;
        this.root = root;
        this.tvId = tvId;
        this.tvName = tvName;
        this.tvValue = tvValue;
        this.tvValueTotal = tvValueTotal;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementDamageFeedItemRightBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementDamageFeedItemRightBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_damage_feed_item_right, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementDamageFeedItemRightBinding bind(View rootView) {
        int i = R.id.cardId;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.container;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.ivWeapon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView != null) {
                    FrameLayout frameLayout = (FrameLayout) rootView;
                    i = R.id.tvId;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.tvName;
                        StrokeTextView strokeTextView = (StrokeTextView) ViewBindings.findChildViewById(rootView, i);
                        if (strokeTextView != null) {
                            i = R.id.tvValue;
                            StrokeTextView strokeTextView2 = (StrokeTextView) ViewBindings.findChildViewById(rootView, i);
                            if (strokeTextView2 != null) {
                                i = R.id.tvValueTotal;
                                StrokeTextView strokeTextView3 = (StrokeTextView) ViewBindings.findChildViewById(rootView, i);
                                if (strokeTextView3 != null) {
                                    return new HudElementDamageFeedItemRightBinding(frameLayout, customCardView, linearLayout, imageView, frameLayout, textView, strokeTextView, strokeTextView2, strokeTextView3);
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
