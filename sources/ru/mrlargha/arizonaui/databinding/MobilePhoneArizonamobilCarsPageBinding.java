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
public final class MobilePhoneArizonamobilCarsPageBinding implements ViewBinding {
    public final ConstraintLayout mpArizonamobilCarsPage;
    public final RecyclerView mpArizonamobileCars;
    public final ConstraintLayout mpArizonamobileCarsHeader;
    public final AppCompatImageView mpArizonamobileHeaderBack;
    public final TextView mpArizonamobileHeaderTitle;
    private final ConstraintLayout rootView;

    private MobilePhoneArizonamobilCarsPageBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, RecyclerView recyclerView, ConstraintLayout constraintLayout3, AppCompatImageView appCompatImageView, TextView textView) {
        this.rootView = constraintLayout;
        this.mpArizonamobilCarsPage = constraintLayout2;
        this.mpArizonamobileCars = recyclerView;
        this.mpArizonamobileCarsHeader = constraintLayout3;
        this.mpArizonamobileHeaderBack = appCompatImageView;
        this.mpArizonamobileHeaderTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneArizonamobilCarsPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneArizonamobilCarsPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_arizonamobil_cars_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneArizonamobilCarsPageBinding bind(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.mp_arizonamobile_cars;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
        if (recyclerView != null) {
            i = R.id.mp_arizonamobile_cars_header;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout2 != null) {
                i = R.id.mp_arizonamobile_header_back;
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView != null) {
                    i = R.id.mp_arizonamobile_header_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        return new MobilePhoneArizonamobilCarsPageBinding(constraintLayout, constraintLayout, recyclerView, constraintLayout2, appCompatImageView, textView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
