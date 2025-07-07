package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class EasterBattlePassAwardItemBinding implements ViewBinding {
    public final CardView button;
    public final ImageView itemLevelIcUsually;
    public final TextView itemLevelNameUsually;
    public final LinearLayout itemLevelUsuallyContainer;
    public final FrameLayout itemLevelUsuallyContainerFull;
    public final ImageView levelContainer;
    public final TextView levelText;
    public final FrameLayout locked;
    public final LinearLayout received;
    private final LinearLayout rootView;
    public final TextView tvErrorText;
    public final View viewAfterLevel;
    public final View viewBeforeLevel;

    private EasterBattlePassAwardItemBinding(LinearLayout rootView, CardView button, ImageView itemLevelIcUsually, TextView itemLevelNameUsually, LinearLayout itemLevelUsuallyContainer, FrameLayout itemLevelUsuallyContainerFull, ImageView levelContainer, TextView levelText, FrameLayout locked, LinearLayout received, TextView tvErrorText, View viewAfterLevel, View viewBeforeLevel) {
        this.rootView = rootView;
        this.button = button;
        this.itemLevelIcUsually = itemLevelIcUsually;
        this.itemLevelNameUsually = itemLevelNameUsually;
        this.itemLevelUsuallyContainer = itemLevelUsuallyContainer;
        this.itemLevelUsuallyContainerFull = itemLevelUsuallyContainerFull;
        this.levelContainer = levelContainer;
        this.levelText = levelText;
        this.locked = locked;
        this.received = received;
        this.tvErrorText = tvErrorText;
        this.viewAfterLevel = viewAfterLevel;
        this.viewBeforeLevel = viewBeforeLevel;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EasterBattlePassAwardItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EasterBattlePassAwardItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.easter_battle_pass_award_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EasterBattlePassAwardItemBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.button;
        CardView cardView = (CardView) ViewBindings.findChildViewById(rootView, i);
        if (cardView != null) {
            i = R.id.item_level_ic_usually;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
            if (imageView != null) {
                i = R.id.item_level_name_usually;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.item_level_usually_container;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout != null) {
                        i = R.id.item_level_usually_container_full;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                        if (frameLayout != null) {
                            i = R.id.level_container;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                            if (imageView2 != null) {
                                i = R.id.level_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView2 != null) {
                                    i = R.id.locked;
                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (frameLayout2 != null) {
                                        i = R.id.received;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout2 != null) {
                                            i = R.id.tv_error_text;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView3 != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.view_after_level))) != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.view_before_level))) != null) {
                                                return new EasterBattlePassAwardItemBinding((LinearLayout) rootView, cardView, imageView, textView, linearLayout, frameLayout, imageView2, textView2, frameLayout2, linearLayout2, textView3, findChildViewById, findChildViewById2);
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
