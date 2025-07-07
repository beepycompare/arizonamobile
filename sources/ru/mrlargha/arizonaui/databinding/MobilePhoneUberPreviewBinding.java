package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MobilePhoneUberPreviewBinding implements ViewBinding {
    public final ConstraintLayout mpArizonamobilUberPreviewPage;
    public final ConstraintLayout mpUberAction;
    public final TextView mpUberActionButton;
    public final AppCompatImageView mpUberHeaderBack;
    public final TextView mpUberHeaderDescription;
    public final TextView mpUberHeaderTitle;
    private final ConstraintLayout rootView;

    private MobilePhoneUberPreviewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, TextView textView, AppCompatImageView appCompatImageView, TextView textView2, TextView textView3) {
        this.rootView = constraintLayout;
        this.mpArizonamobilUberPreviewPage = constraintLayout2;
        this.mpUberAction = constraintLayout3;
        this.mpUberActionButton = textView;
        this.mpUberHeaderBack = appCompatImageView;
        this.mpUberHeaderDescription = textView2;
        this.mpUberHeaderTitle = textView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneUberPreviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneUberPreviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_uber_preview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneUberPreviewBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.mp_uber_action;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout2 != null) {
            i = R.id.mp_uber_action_button;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.mp_uber_header_back;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.mp_uber_header_description;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.mp_uber_header_title;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            return new MobilePhoneUberPreviewBinding(constraintLayout, constraintLayout, constraintLayout2, textView, appCompatImageView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
