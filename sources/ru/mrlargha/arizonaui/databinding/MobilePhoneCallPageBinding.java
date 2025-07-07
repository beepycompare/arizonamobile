package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MobilePhoneCallPageBinding implements ViewBinding {
    public final RecyclerView mpCallMenuRc;
    public final ConstraintLayout mpCallPage;
    public final ConstraintLayout mpPageTitle;
    public final AppCompatImageView mpPageTitleImage;
    public final TextView mpPageTitleText;
    public final ConstraintLayout mpTypePhone;
    public final AppCompatImageView mpTypePhoneDecoration;
    public final ConstraintLayout mpTypePhoneNumber;
    public final AppCompatImageView mpTypePhoneNumberDecorative;
    public final TextView mpTypePhoneTitle;
    private final ConstraintLayout rootView;

    private MobilePhoneCallPageBinding(ConstraintLayout constraintLayout, RecyclerView recyclerView, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, AppCompatImageView appCompatImageView, TextView textView, ConstraintLayout constraintLayout4, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout5, AppCompatImageView appCompatImageView3, TextView textView2) {
        this.rootView = constraintLayout;
        this.mpCallMenuRc = recyclerView;
        this.mpCallPage = constraintLayout2;
        this.mpPageTitle = constraintLayout3;
        this.mpPageTitleImage = appCompatImageView;
        this.mpPageTitleText = textView;
        this.mpTypePhone = constraintLayout4;
        this.mpTypePhoneDecoration = appCompatImageView2;
        this.mpTypePhoneNumber = constraintLayout5;
        this.mpTypePhoneNumberDecorative = appCompatImageView3;
        this.mpTypePhoneTitle = textView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneCallPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneCallPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_call_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneCallPageBinding bind(View view) {
        int i = R.id.mp_call_menu_rc;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i = R.id.mp_page_title;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout2 != null) {
                i = R.id.mp_page_title_image;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.mp_page_title_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.mp_type_phone;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout3 != null) {
                            i = R.id.mp_type_phone_decoration;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                            if (appCompatImageView2 != null) {
                                i = R.id.mp_type_phone_number;
                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                if (constraintLayout4 != null) {
                                    i = R.id.mp_type_phone_number_decorative;
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                    if (appCompatImageView3 != null) {
                                        i = R.id.mp_type_phone_title;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                        if (textView2 != null) {
                                            return new MobilePhoneCallPageBinding(constraintLayout, recyclerView, constraintLayout, constraintLayout2, appCompatImageView, textView, constraintLayout3, appCompatImageView2, constraintLayout4, appCompatImageView3, textView2);
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
