package ru.mrlargha.feature.event.databinding;

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
import ru.mrlargha.feature.event.R;
/* loaded from: classes6.dex */
public final class EventAwardItemBinding implements ViewBinding {
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

    private EventAwardItemBinding(LinearLayout linearLayout, CardView cardView, ImageView imageView, TextView textView, LinearLayout linearLayout2, FrameLayout frameLayout, ImageView imageView2, TextView textView2, FrameLayout frameLayout2, LinearLayout linearLayout3, TextView textView3, View view, View view2) {
        this.rootView = linearLayout;
        this.button = cardView;
        this.itemLevelIcUsually = imageView;
        this.itemLevelNameUsually = textView;
        this.itemLevelUsuallyContainer = linearLayout2;
        this.itemLevelUsuallyContainerFull = frameLayout;
        this.levelContainer = imageView2;
        this.levelText = textView2;
        this.locked = frameLayout2;
        this.received = linearLayout3;
        this.tvErrorText = textView3;
        this.viewAfterLevel = view;
        this.viewBeforeLevel = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EventAwardItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EventAwardItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.event_award_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EventAwardItemBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.button;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.item_level_ic_usually;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
            if (imageView != null) {
                i = R.id.item_level_name_usually;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.item_level_usually_container;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                    if (linearLayout != null) {
                        i = R.id.item_level_usually_container_full;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout != null) {
                            i = R.id.level_container;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                i = R.id.level_text;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView2 != null) {
                                    i = R.id.locked;
                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                                    if (frameLayout2 != null) {
                                        i = R.id.received;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout2 != null) {
                                            i = R.id.tv_error_text;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.view_after_level))) != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view_before_level))) != null) {
                                                return new EventAwardItemBinding((LinearLayout) view, cardView, imageView, textView, linearLayout, frameLayout, imageView2, textView2, frameLayout2, linearLayout2, textView3, findChildViewById, findChildViewById2);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
