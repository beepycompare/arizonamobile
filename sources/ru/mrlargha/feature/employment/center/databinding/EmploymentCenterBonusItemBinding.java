package ru.mrlargha.feature.employment.center.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
import ru.mrlargha.feature.employment.center.R;
/* loaded from: classes6.dex */
public final class EmploymentCenterBonusItemBinding implements ViewBinding {
    public final CustomCardView buttonInfo;
    public final CustomCardView cardBg;
    public final ImageView image;
    public final FrameLayout item;
    public final EmploymentCenterLabelItemBinding label1;
    private final FrameLayout rootView;
    public final TextView text;

    private EmploymentCenterBonusItemBinding(FrameLayout frameLayout, CustomCardView customCardView, CustomCardView customCardView2, ImageView imageView, FrameLayout frameLayout2, EmploymentCenterLabelItemBinding employmentCenterLabelItemBinding, TextView textView) {
        this.rootView = frameLayout;
        this.buttonInfo = customCardView;
        this.cardBg = customCardView2;
        this.image = imageView;
        this.item = frameLayout2;
        this.label1 = employmentCenterLabelItemBinding;
        this.text = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static EmploymentCenterBonusItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EmploymentCenterBonusItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.employment_center_bonus_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EmploymentCenterBonusItemBinding bind(View view) {
        int i = R.id.button_info;
        CustomCardView customCardView = (CustomCardView) ViewBindings.findChildViewById(view, i);
        if (customCardView != null) {
            i = R.id.card_bg;
            CustomCardView customCardView2 = (CustomCardView) ViewBindings.findChildViewById(view, i);
            if (customCardView2 != null) {
                i = R.id.image;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    i = R.id.label1;
                    View findChildViewById = ViewBindings.findChildViewById(view, i);
                    if (findChildViewById != null) {
                        EmploymentCenterLabelItemBinding bind = EmploymentCenterLabelItemBinding.bind(findChildViewById);
                        i = R.id.text;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            return new EmploymentCenterBonusItemBinding(frameLayout, customCardView, customCardView2, imageView, frameLayout, bind, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
