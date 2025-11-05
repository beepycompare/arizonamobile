package ru.mrlargha.feature.arizona.promo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.commonui.utils.ui.GradientText.ArizonaGradientTextView;
import ru.mrlargha.feature.arizona.promo.R;
/* loaded from: classes6.dex */
public final class ManagementBinding implements ViewBinding {
    public final TextView activation;
    public final CustomCardView buttonInfo;
    public final LinearLayout copy;
    public final TextView currentLv;
    public final LinearLayout edit;
    public final LinearLayout info;
    public final TextView maxLv;
    public final TextView rating;
    private final LinearLayout rootView;
    public final RecyclerView rv;
    public final ArizonaGradientTextView title;
    public final LinearLayout upgrade;

    private ManagementBinding(LinearLayout linearLayout, TextView textView, CustomCardView customCardView, LinearLayout linearLayout2, TextView textView2, LinearLayout linearLayout3, LinearLayout linearLayout4, TextView textView3, TextView textView4, RecyclerView recyclerView, ArizonaGradientTextView arizonaGradientTextView, LinearLayout linearLayout5) {
        this.rootView = linearLayout;
        this.activation = textView;
        this.buttonInfo = customCardView;
        this.copy = linearLayout2;
        this.currentLv = textView2;
        this.edit = linearLayout3;
        this.info = linearLayout4;
        this.maxLv = textView3;
        this.rating = textView4;
        this.rv = recyclerView;
        this.title = arizonaGradientTextView;
        this.upgrade = linearLayout5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ManagementBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ManagementBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.management, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ManagementBinding bind(View view) {
        int i = R.id.activation;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
        if (textView != null) {
            i = R.id.button_info;
            CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView != null) {
                i = R.id.copy;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.current_lv;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.edit;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                        if (linearLayout2 != null) {
                            i = R.id.info;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                            if (linearLayout3 != null) {
                                i = R.id.max_lv;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.rating;
                                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView4 != null) {
                                        i = R.id.rv;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                        if (recyclerView != null) {
                                            i = R.id.title;
                                            ArizonaGradientTextView arizonaGradientTextView = (ArizonaGradientTextView) ViewBindings.findChildViewById(view, i);
                                            if (arizonaGradientTextView != null) {
                                                i = R.id.upgrade;
                                                LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                if (linearLayout4 != null) {
                                                    return new ManagementBinding((LinearLayout) view, textView, customCardView, linearLayout, textView2, linearLayout2, linearLayout3, textView3, textView4, recyclerView, arizonaGradientTextView, linearLayout4);
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
