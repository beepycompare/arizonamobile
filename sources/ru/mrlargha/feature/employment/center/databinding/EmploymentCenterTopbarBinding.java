package ru.mrlargha.feature.employment.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.employment.center.R;
/* loaded from: classes6.dex */
public final class EmploymentCenterTopbarBinding implements ViewBinding {
    public final CustomCardView close;
    private final LinearLayout rootView;
    public final TextView title;
    public final LinearLayout topbar;

    private EmploymentCenterTopbarBinding(LinearLayout linearLayout, CustomCardView customCardView, TextView textView, LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.close = customCardView;
        this.title = textView;
        this.topbar = linearLayout2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static EmploymentCenterTopbarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EmploymentCenterTopbarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.employment_center_topbar, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EmploymentCenterTopbarBinding bind(View view) {
        int i = R.id.close;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new EmploymentCenterTopbarBinding(linearLayout, customCardView, textView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
