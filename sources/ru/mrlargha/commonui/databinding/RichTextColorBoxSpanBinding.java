package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class RichTextColorBoxSpanBinding implements ViewBinding {
    public final CustomCardView richTextColorBoxCard;
    public final TextView richTextColorBoxLabel;
    private final CustomCardView rootView;

    private RichTextColorBoxSpanBinding(CustomCardView rootView, CustomCardView richTextColorBoxCard, TextView richTextColorBoxLabel) {
        this.rootView = rootView;
        this.richTextColorBoxCard = richTextColorBoxCard;
        this.richTextColorBoxLabel = richTextColorBoxLabel;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static RichTextColorBoxSpanBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RichTextColorBoxSpanBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.rich_text_color_box_span, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RichTextColorBoxSpanBinding bind(View rootView) {
        CustomCardView customCardView = (CustomCardView) rootView;
        int i = R.id.rich_text_color_box_label;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            return new RichTextColorBoxSpanBinding(customCardView, customCardView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
