package ru.mrlargha.feature.arizona.item.rating.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.arizona.item.rating.R;
/* loaded from: classes6.dex */
public final class RatingTopbarBinding implements ViewBinding {
    public final CustomCardView card1;
    public final CustomCardView card2;
    public final CustomCardView card3;
    public final CustomCardView card4;
    public final EditText editText;
    public final CustomCardView filter;
    private final LinearLayout rootView;
    public final CustomCardView search;
    public final TextView text1;
    public final TextView text2;
    public final TextView text3;
    public final TextView text4;

    private RatingTopbarBinding(LinearLayout linearLayout, CustomCardView customCardView, CustomCardView customCardView2, CustomCardView customCardView3, CustomCardView customCardView4, EditText editText, CustomCardView customCardView5, CustomCardView customCardView6, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.rootView = linearLayout;
        this.card1 = customCardView;
        this.card2 = customCardView2;
        this.card3 = customCardView3;
        this.card4 = customCardView4;
        this.editText = editText;
        this.filter = customCardView5;
        this.search = customCardView6;
        this.text1 = textView;
        this.text2 = textView2;
        this.text3 = textView3;
        this.text4 = textView4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static RatingTopbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static RatingTopbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.rating_topbar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static RatingTopbarBinding bind(View view) {
        int i = R.id.card1;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.card2;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.card3;
                CustomCardView customCardView3 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                if (customCardView3 != null) {
                    i = R.id.card4;
                    CustomCardView customCardView4 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                    if (customCardView4 != null) {
                        i = R.id.edit_text;
                        EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                        if (editText != null) {
                            i = R.id.filter;
                            CustomCardView customCardView5 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                            if (customCardView5 != null) {
                                i = R.id.search;
                                CustomCardView customCardView6 = (CustomCardView) ViewBindings.findChildViewById(view, i);
                                if (customCardView6 != null) {
                                    i = R.id.text1;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView != null) {
                                        i = R.id.text2;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            i = R.id.text3;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.text4;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView4 != null) {
                                                    return new RatingTopbarBinding((LinearLayout) view, customCardView, customCardView2, customCardView3, customCardView4, editText, customCardView5, customCardView6, textView, textView2, textView3, textView4);
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
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
