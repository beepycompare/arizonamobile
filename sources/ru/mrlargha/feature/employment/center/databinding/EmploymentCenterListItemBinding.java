package ru.mrlargha.feature.employment.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.employment.center.R;
/* loaded from: classes6.dex */
public final class EmploymentCenterListItemBinding implements ViewBinding {
    public final ImageView image;
    public final CustomCardView item;
    public final EmploymentCenterLabelItemBinding label1;
    public final EmploymentCenterLabelItemBinding label2;
    private final CustomCardView rootView;
    public final TextView text;

    private EmploymentCenterListItemBinding(CustomCardView customCardView, ImageView imageView, CustomCardView customCardView2, EmploymentCenterLabelItemBinding employmentCenterLabelItemBinding, EmploymentCenterLabelItemBinding employmentCenterLabelItemBinding2, TextView textView) {
        this.rootView = customCardView;
        this.image = imageView;
        this.item = customCardView2;
        this.label1 = employmentCenterLabelItemBinding;
        this.label2 = employmentCenterLabelItemBinding2;
        this.text = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static EmploymentCenterListItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EmploymentCenterListItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.employment_center_list_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EmploymentCenterListItemBinding bind(View view) {
        int i = R.id.image;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            CustomCardView customCardView = (CustomCardView) view;
            i = R.id.label1;
            View findChildViewById = ViewBindings.findChildViewById(view, i);
            if (findChildViewById != null) {
                EmploymentCenterLabelItemBinding bind = EmploymentCenterLabelItemBinding.bind(findChildViewById);
                i = R.id.label2;
                View findChildViewById2 = ViewBindings.findChildViewById(view, i);
                if (findChildViewById2 != null) {
                    EmploymentCenterLabelItemBinding bind2 = EmploymentCenterLabelItemBinding.bind(findChildViewById2);
                    i = R.id.text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new EmploymentCenterListItemBinding(customCardView, imageView, customCardView, bind, bind2, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
