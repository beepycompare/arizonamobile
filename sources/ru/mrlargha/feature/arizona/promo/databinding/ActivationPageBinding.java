package ru.mrlargha.feature.arizona.promo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.arizona.promo.R;
/* loaded from: classes6.dex */
public final class ActivationPageBinding implements ViewBinding {
    public final TextView detailsButton;
    public final EditText editText;
    public final ImageView imagePoster;
    public final TextView projectBonusText;
    private final LinearLayout rootView;
    public final RecyclerView rv;
    public final ImageView sendButton;

    private ActivationPageBinding(LinearLayout linearLayout, TextView textView, EditText editText, ImageView imageView, TextView textView2, RecyclerView recyclerView, ImageView imageView2) {
        this.rootView = linearLayout;
        this.detailsButton = textView;
        this.editText = editText;
        this.imagePoster = imageView;
        this.projectBonusText = textView2;
        this.rv = recyclerView;
        this.sendButton = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ActivationPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ActivationPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activation_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ActivationPageBinding bind(View view) {
        int i = R.id.details_button;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.edit_text;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
            if (editText != null) {
                i = R.id.image_poster;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.project_bonus_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.rv;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            i = R.id.send_button;
                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                            if (imageView2 != null) {
                                return new ActivationPageBinding((LinearLayout) view, textView, editText, imageView, textView2, recyclerView, imageView2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
