package ru.mrlargha.feature.item.rating.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.item.rating.R;
/* loaded from: classes6.dex */
public final class RatingItemBinding implements ViewBinding {
    public final CustomCardView card;
    public final ImageView image;
    public final CustomCardView labelBg;
    public final TextView labelText;
    public final TextView nick;
    public final TextView number;
    private final CustomCardView rootView;
    public final TextView title;

    private RatingItemBinding(CustomCardView customCardView, CustomCardView customCardView2, ImageView imageView, CustomCardView customCardView3, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = customCardView;
        this.card = customCardView2;
        this.image = imageView;
        this.labelBg = customCardView3;
        this.labelText = textView;
        this.nick = textView2;
        this.number = textView3;
        this.title = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static RatingItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RatingItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.rating_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RatingItemBinding bind(View view) {
        CustomCardView customCardView = (CustomCardView) view;
        int i = R.id.image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.label_bg;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.label_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.nick;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.number;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.title;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                return new RatingItemBinding(customCardView, customCardView, imageView, customCardView2, textView, textView2, textView3, textView4);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
