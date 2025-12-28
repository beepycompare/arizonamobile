package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes5.dex */
public final class HudChickenGameToolsItemBinding implements ViewBinding {
    public final CustomCardView hudImposterGameItem1;
    public final ImageView ivIc;
    public final ImageView ivItem;
    private final FrameLayout rootView;
    public final TextView tvCount;

    private HudChickenGameToolsItemBinding(FrameLayout rootView, CustomCardView hudImposterGameItem1, ImageView ivIc, ImageView ivItem, TextView tvCount) {
        this.rootView = rootView;
        this.hudImposterGameItem1 = hudImposterGameItem1;
        this.ivIc = ivIc;
        this.ivItem = ivItem;
        this.tvCount = tvCount;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudChickenGameToolsItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudChickenGameToolsItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_chicken_game_tools_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudChickenGameToolsItemBinding bind(View rootView) {
        int i = R.id.hud_imposter_game_item1;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
        if (customCardView != null) {
            i = R.id.iv_ic;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.iv_item;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                if (imageView2 != null) {
                    i = R.id.tv_count;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        return new HudChickenGameToolsItemBinding((FrameLayout) rootView, customCardView, imageView, imageView2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
