package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class GhettoMainBinding implements ViewBinding {
    public final ConstraintLayout familyMain;
    public final ConstraintLayout familyOverlay;
    public final GhettoMapFrameBinding frameMap;
    public final GhettoMapBinding map;
    private final ConstraintLayout rootView;
    public final GhettoTopbarBinding topbar;
    public final GhettoWarBinding war;

    private GhettoMainBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, GhettoMapFrameBinding ghettoMapFrameBinding, GhettoMapBinding ghettoMapBinding, GhettoTopbarBinding ghettoTopbarBinding, GhettoWarBinding ghettoWarBinding) {
        this.rootView = constraintLayout;
        this.familyMain = constraintLayout2;
        this.familyOverlay = constraintLayout3;
        this.frameMap = ghettoMapFrameBinding;
        this.map = ghettoMapBinding;
        this.topbar = ghettoTopbarBinding;
        this.war = ghettoWarBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static GhettoMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static GhettoMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.ghetto_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static GhettoMainBinding bind(View view) {
        View findChildViewById;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.family_overlay;
        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.frame_map))) != null) {
            GhettoMapFrameBinding bind = GhettoMapFrameBinding.bind(findChildViewById);
            i = R.id.map;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i);
            if (findChildViewById2 != null) {
                GhettoMapBinding bind2 = GhettoMapBinding.bind(findChildViewById2);
                i = R.id.topbar;
                View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                if (findChildViewById3 != null) {
                    GhettoTopbarBinding bind3 = GhettoTopbarBinding.bind(findChildViewById3);
                    i = R.id.war;
                    View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                    if (findChildViewById4 != null) {
                        return new GhettoMainBinding(constraintLayout, constraintLayout, constraintLayout2, bind, bind2, bind3, GhettoWarBinding.bind(findChildViewById4));
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
