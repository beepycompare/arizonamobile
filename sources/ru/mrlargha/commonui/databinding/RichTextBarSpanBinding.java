package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class RichTextBarSpanBinding implements ViewBinding {
    public final TextView richTextBarLabel;
    public final CustomCardView richTextBarLevelBadge;
    public final TextView richTextBarLevelText;
    public final CustomCardView richTextBarProgress;
    public final LinearLayout richTextBarRoot;
    public final CustomCardView richTextBarTrack;
    public final CustomCardView richTextBarValueBadge;
    public final TextView richTextBarValueText;
    private final LinearLayout rootView;

    private RichTextBarSpanBinding(LinearLayout rootView, TextView richTextBarLabel, CustomCardView richTextBarLevelBadge, TextView richTextBarLevelText, CustomCardView richTextBarProgress, LinearLayout richTextBarRoot, CustomCardView richTextBarTrack, CustomCardView richTextBarValueBadge, TextView richTextBarValueText) {
        this.rootView = rootView;
        this.richTextBarLabel = richTextBarLabel;
        this.richTextBarLevelBadge = richTextBarLevelBadge;
        this.richTextBarLevelText = richTextBarLevelText;
        this.richTextBarProgress = richTextBarProgress;
        this.richTextBarRoot = richTextBarRoot;
        this.richTextBarTrack = richTextBarTrack;
        this.richTextBarValueBadge = richTextBarValueBadge;
        this.richTextBarValueText = richTextBarValueText;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RichTextBarSpanBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RichTextBarSpanBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.rich_text_bar_span, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RichTextBarSpanBinding bind(View rootView) {
        int i = R.id.rich_text_bar_label;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.rich_text_bar_level_badge;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
            if (customCardView != null) {
                i = R.id.rich_text_bar_level_text;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.rich_text_bar_progress;
                    CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                    if (customCardView2 != null) {
                        LinearLayout linearLayout = (LinearLayout) rootView;
                        i = R.id.rich_text_bar_track;
                        CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                        if (customCardView3 != null) {
                            i = R.id.rich_text_bar_value_badge;
                            CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(rootView, i);
                            if (customCardView4 != null) {
                                i = R.id.rich_text_bar_value_text;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView3 != null) {
                                    return new RichTextBarSpanBinding(linearLayout, textView, customCardView, textView2, customCardView2, linearLayout, customCardView3, customCardView4, textView3);
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
