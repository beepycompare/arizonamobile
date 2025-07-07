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
public final class MobilePhoneArizonamobilCarBinding implements ViewBinding {
    public final AppCompatImageView mpArizonamobileCarArrow;
    public final AppCompatImageView mpArizonamobileCarImage;
    public final ConstraintLayout mpArizonamobileCarItem;
    public final TextView mpArizonamobileCarName;
    public final TextView mpArizonamobileDistance;
    public final AppCompatImageView mpArizonamobileGps;
    public final ConstraintLayout mpArizonamobileLocation;
    private final ConstraintLayout rootView;

    private MobilePhoneArizonamobilCarBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout2, TextView textView, TextView textView2, AppCompatImageView appCompatImageView3, ConstraintLayout constraintLayout3) {
        this.rootView = constraintLayout;
        this.mpArizonamobileCarArrow = appCompatImageView;
        this.mpArizonamobileCarImage = appCompatImageView2;
        this.mpArizonamobileCarItem = constraintLayout2;
        this.mpArizonamobileCarName = textView;
        this.mpArizonamobileDistance = textView2;
        this.mpArizonamobileGps = appCompatImageView3;
        this.mpArizonamobileLocation = constraintLayout3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneArizonamobilCarBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneArizonamobilCarBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_arizonamobil_car, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneArizonamobilCarBinding bind(View view) {
        int i = R.id.mp_arizonamobile_car_arrow;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
        if (appCompatImageView != null) {
            i = R.id.mp_arizonamobile_car_image;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                i = R.id.mp_arizonamobile_car_name;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    i = R.id.mp_arizonamobile_distance;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.mp_arizonamobile_gps;
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                        if (appCompatImageView3 != null) {
                            i = R.id.mp_arizonamobile_location;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout2 != null) {
                                return new MobilePhoneArizonamobilCarBinding(constraintLayout, appCompatImageView, appCompatImageView2, constraintLayout, textView, textView2, appCompatImageView3, constraintLayout2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
