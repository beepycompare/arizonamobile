package ru.mrlargha.feature.arizona.promo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.arizona.promo.R;
/* loaded from: classes6.dex */
public final class PromoMainBinding implements ViewBinding {
    public final ActivationPageBinding activate;
    public final LevelLockerBinding levelLocker;
    public final ManagementBinding management;
    public final PromoDetailsBinding promoDetails;
    public final ReferalsBinding referals;
    private final ConstraintLayout rootView;
    public final ConstraintLayout starterPack;
    public final TopbarBinding topbar;

    private PromoMainBinding(ConstraintLayout constraintLayout, ActivationPageBinding activationPageBinding, LevelLockerBinding levelLockerBinding, ManagementBinding managementBinding, PromoDetailsBinding promoDetailsBinding, ReferalsBinding referalsBinding, ConstraintLayout constraintLayout2, TopbarBinding topbarBinding) {
        this.rootView = constraintLayout;
        this.activate = activationPageBinding;
        this.levelLocker = levelLockerBinding;
        this.management = managementBinding;
        this.promoDetails = promoDetailsBinding;
        this.referals = referalsBinding;
        this.starterPack = constraintLayout2;
        this.topbar = topbarBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static PromoMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static PromoMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.promo_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static PromoMainBinding bind(View view) {
        int i = R.id.activate;
        View findChildViewById = ViewBindings.findChildViewById(view, i);
        if (findChildViewById != null) {
            ActivationPageBinding bind = ActivationPageBinding.bind(findChildViewById);
            i = R.id.level_locker;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i);
            if (findChildViewById2 != null) {
                LevelLockerBinding bind2 = LevelLockerBinding.bind(findChildViewById2);
                i = R.id.management;
                View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                if (findChildViewById3 != null) {
                    ManagementBinding bind3 = ManagementBinding.bind(findChildViewById3);
                    i = R.id.promo_details;
                    View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                    if (findChildViewById4 != null) {
                        PromoDetailsBinding bind4 = PromoDetailsBinding.bind(findChildViewById4);
                        i = R.id.referals;
                        View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                        if (findChildViewById5 != null) {
                            ReferalsBinding bind5 = ReferalsBinding.bind(findChildViewById5);
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            i = R.id.topbar;
                            View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                            if (findChildViewById6 != null) {
                                return new PromoMainBinding(constraintLayout, bind, bind2, bind3, bind4, bind5, constraintLayout, TopbarBinding.bind(findChildViewById6));
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
