package ru.mrlargha.feature.arizona.promo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.arizona.promo.R;
/* loaded from: classes6.dex */
public final class ProgressItemBinding implements ViewBinding {
    public final TextView buttonGet;
    public final RelativeLayout center;
    public final View colorBottom;
    public final ImageView image;
    public final ImageView levelContainer;
    public final TextView levelText;
    public final FrameLayout recieved;
    private final LinearLayout rootView;
    public final TextView text;
    public final TextView text2;
    public final View viewAfterLevel;
    public final View viewBeforeLevel;

    private ProgressItemBinding(LinearLayout linearLayout, TextView textView, RelativeLayout relativeLayout, View view, ImageView imageView, ImageView imageView2, TextView textView2, FrameLayout frameLayout, TextView textView3, TextView textView4, View view2, View view3) {
        this.rootView = linearLayout;
        this.buttonGet = textView;
        this.center = relativeLayout;
        this.colorBottom = view;
        this.image = imageView;
        this.levelContainer = imageView2;
        this.levelText = textView2;
        this.recieved = frameLayout;
        this.text = textView3;
        this.text2 = textView4;
        this.viewAfterLevel = view2;
        this.viewBeforeLevel = view3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ProgressItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ProgressItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.progress_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ProgressItemBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i = R.id.button_get;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.center;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, i);
            if (relativeLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.color_bottom))) != null) {
                i = R.id.image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.level_container;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.level_text;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView2 != null) {
                            i = R.id.recieved;
                            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, i);
                            if (frameLayout != null) {
                                i = R.id.text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.text2;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view_after_level))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.view_before_level))) != null) {
                                        return new ProgressItemBinding((LinearLayout) view, textView, relativeLayout, findChildViewById, imageView, imageView2, textView2, frameLayout, textView3, textView4, findChildViewById2, findChildViewById3);
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
