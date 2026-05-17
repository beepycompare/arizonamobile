package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes6.dex */
public final class HudElementDamageInformerBinding implements ViewBinding {
    public final LinearLayout leftGroup;
    public final HudElementDamageFeedItemLeftBinding leftItem0;
    public final HudElementDamageFeedItemLeftBinding leftItem1;
    public final HudElementDamageFeedItemLeftBinding leftItem2;
    public final HudElementDamageFeedItemLeftBinding leftItem3;
    public final HudElementDamageFeedItemLeftBinding leftItem4;
    public final HudElementDamageFeedItemLeftBinding leftItem5;
    public final HudElementDamageFeedItemLeftBinding leftItem6;
    public final LinearLayout main;
    public final LinearLayout rightGroup;
    public final HudElementDamageFeedItemRightBinding rightItem0;
    public final HudElementDamageFeedItemRightBinding rightItem1;
    public final HudElementDamageFeedItemRightBinding rightItem2;
    public final HudElementDamageFeedItemRightBinding rightItem3;
    public final HudElementDamageFeedItemRightBinding rightItem4;
    public final HudElementDamageFeedItemRightBinding rightItem5;
    public final HudElementDamageFeedItemRightBinding rightItem6;
    public final FrameLayout root;
    private final FrameLayout rootView;

    private HudElementDamageInformerBinding(FrameLayout rootView, LinearLayout leftGroup, HudElementDamageFeedItemLeftBinding leftItem0, HudElementDamageFeedItemLeftBinding leftItem1, HudElementDamageFeedItemLeftBinding leftItem2, HudElementDamageFeedItemLeftBinding leftItem3, HudElementDamageFeedItemLeftBinding leftItem4, HudElementDamageFeedItemLeftBinding leftItem5, HudElementDamageFeedItemLeftBinding leftItem6, LinearLayout main, LinearLayout rightGroup, HudElementDamageFeedItemRightBinding rightItem0, HudElementDamageFeedItemRightBinding rightItem1, HudElementDamageFeedItemRightBinding rightItem2, HudElementDamageFeedItemRightBinding rightItem3, HudElementDamageFeedItemRightBinding rightItem4, HudElementDamageFeedItemRightBinding rightItem5, HudElementDamageFeedItemRightBinding rightItem6, FrameLayout root) {
        this.rootView = rootView;
        this.leftGroup = leftGroup;
        this.leftItem0 = leftItem0;
        this.leftItem1 = leftItem1;
        this.leftItem2 = leftItem2;
        this.leftItem3 = leftItem3;
        this.leftItem4 = leftItem4;
        this.leftItem5 = leftItem5;
        this.leftItem6 = leftItem6;
        this.main = main;
        this.rightGroup = rightGroup;
        this.rightItem0 = rightItem0;
        this.rightItem1 = rightItem1;
        this.rightItem2 = rightItem2;
        this.rightItem3 = rightItem3;
        this.rightItem4 = rightItem4;
        this.rightItem5 = rightItem5;
        this.rightItem6 = rightItem6;
        this.root = root;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static HudElementDamageInformerBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static HudElementDamageInformerBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.hud_element_damage_informer, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static HudElementDamageInformerBinding bind(View rootView) {
        View findChildViewById;
        View findChildViewById2;
        int i = R.id.leftGroup;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
        if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.leftItem0))) != null) {
            HudElementDamageFeedItemLeftBinding bind = HudElementDamageFeedItemLeftBinding.bind(findChildViewById);
            i = R.id.leftItem1;
            View findChildViewById3 = ViewBindings.findChildViewById(rootView, i);
            if (findChildViewById3 != null) {
                HudElementDamageFeedItemLeftBinding bind2 = HudElementDamageFeedItemLeftBinding.bind(findChildViewById3);
                i = R.id.leftItem2;
                View findChildViewById4 = ViewBindings.findChildViewById(rootView, i);
                if (findChildViewById4 != null) {
                    HudElementDamageFeedItemLeftBinding bind3 = HudElementDamageFeedItemLeftBinding.bind(findChildViewById4);
                    i = R.id.leftItem3;
                    View findChildViewById5 = ViewBindings.findChildViewById(rootView, i);
                    if (findChildViewById5 != null) {
                        HudElementDamageFeedItemLeftBinding bind4 = HudElementDamageFeedItemLeftBinding.bind(findChildViewById5);
                        i = R.id.leftItem4;
                        View findChildViewById6 = ViewBindings.findChildViewById(rootView, i);
                        if (findChildViewById6 != null) {
                            HudElementDamageFeedItemLeftBinding bind5 = HudElementDamageFeedItemLeftBinding.bind(findChildViewById6);
                            i = R.id.leftItem5;
                            View findChildViewById7 = ViewBindings.findChildViewById(rootView, i);
                            if (findChildViewById7 != null) {
                                HudElementDamageFeedItemLeftBinding bind6 = HudElementDamageFeedItemLeftBinding.bind(findChildViewById7);
                                i = R.id.leftItem6;
                                View findChildViewById8 = ViewBindings.findChildViewById(rootView, i);
                                if (findChildViewById8 != null) {
                                    HudElementDamageFeedItemLeftBinding bind7 = HudElementDamageFeedItemLeftBinding.bind(findChildViewById8);
                                    i = R.id.main;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.rightGroup;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                        if (linearLayout3 != null && (findChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.rightItem0))) != null) {
                                            HudElementDamageFeedItemRightBinding bind8 = HudElementDamageFeedItemRightBinding.bind(findChildViewById2);
                                            i = R.id.rightItem1;
                                            View findChildViewById9 = ViewBindings.findChildViewById(rootView, i);
                                            if (findChildViewById9 != null) {
                                                HudElementDamageFeedItemRightBinding bind9 = HudElementDamageFeedItemRightBinding.bind(findChildViewById9);
                                                i = R.id.rightItem2;
                                                View findChildViewById10 = ViewBindings.findChildViewById(rootView, i);
                                                if (findChildViewById10 != null) {
                                                    HudElementDamageFeedItemRightBinding bind10 = HudElementDamageFeedItemRightBinding.bind(findChildViewById10);
                                                    i = R.id.rightItem3;
                                                    View findChildViewById11 = ViewBindings.findChildViewById(rootView, i);
                                                    if (findChildViewById11 != null) {
                                                        HudElementDamageFeedItemRightBinding bind11 = HudElementDamageFeedItemRightBinding.bind(findChildViewById11);
                                                        i = R.id.rightItem4;
                                                        View findChildViewById12 = ViewBindings.findChildViewById(rootView, i);
                                                        if (findChildViewById12 != null) {
                                                            HudElementDamageFeedItemRightBinding bind12 = HudElementDamageFeedItemRightBinding.bind(findChildViewById12);
                                                            i = R.id.rightItem5;
                                                            View findChildViewById13 = ViewBindings.findChildViewById(rootView, i);
                                                            if (findChildViewById13 != null) {
                                                                HudElementDamageFeedItemRightBinding bind13 = HudElementDamageFeedItemRightBinding.bind(findChildViewById13);
                                                                i = R.id.rightItem6;
                                                                View findChildViewById14 = ViewBindings.findChildViewById(rootView, i);
                                                                if (findChildViewById14 != null) {
                                                                    FrameLayout frameLayout = (FrameLayout) rootView;
                                                                    return new HudElementDamageInformerBinding(frameLayout, linearLayout, bind, bind2, bind3, bind4, bind5, bind6, bind7, linearLayout2, linearLayout3, bind8, bind9, bind10, bind11, bind12, bind13, HudElementDamageFeedItemRightBinding.bind(findChildViewById14), frameLayout);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
