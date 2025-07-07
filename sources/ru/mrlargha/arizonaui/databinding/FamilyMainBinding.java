package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class FamilyMainBinding implements ViewBinding {
    public final FamilyCharterBinding charter;
    public final FamilyCharterMembersBinding charterMembers;
    public final FamilyCreateClanBinding create;
    public final FamilyEstateBinding estate;
    public final ConstraintLayout familyMain;
    public final ConstraintLayout familyOverlay;
    public final FamilyCharterFrameBinding frameCharter;
    public final FamilyMapFrameBinding frameMap;
    public final FamilyMembersFrameBinding frameMember;
    public final FamilyHomePageBinding home;
    public final FamilyMapBinding map;
    public final FamilyMeetingsBinding meetings;
    public final FamilyMembersBinding members;
    public final FamilyMainMenuBinding menu;
    public final FamilyRatingBinding rating;
    private final ConstraintLayout rootView;
    public final FamilySettingsBinding settings;
    public final FamilyTerritoriesBinding territories;
    public final FamilyTopbarBinding topbar;
    public final FamilyWarBinding war;

    private FamilyMainBinding(ConstraintLayout constraintLayout, FamilyCharterBinding familyCharterBinding, FamilyCharterMembersBinding familyCharterMembersBinding, FamilyCreateClanBinding familyCreateClanBinding, FamilyEstateBinding familyEstateBinding, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, FamilyCharterFrameBinding familyCharterFrameBinding, FamilyMapFrameBinding familyMapFrameBinding, FamilyMembersFrameBinding familyMembersFrameBinding, FamilyHomePageBinding familyHomePageBinding, FamilyMapBinding familyMapBinding, FamilyMeetingsBinding familyMeetingsBinding, FamilyMembersBinding familyMembersBinding, FamilyMainMenuBinding familyMainMenuBinding, FamilyRatingBinding familyRatingBinding, FamilySettingsBinding familySettingsBinding, FamilyTerritoriesBinding familyTerritoriesBinding, FamilyTopbarBinding familyTopbarBinding, FamilyWarBinding familyWarBinding) {
        this.rootView = constraintLayout;
        this.charter = familyCharterBinding;
        this.charterMembers = familyCharterMembersBinding;
        this.create = familyCreateClanBinding;
        this.estate = familyEstateBinding;
        this.familyMain = constraintLayout2;
        this.familyOverlay = constraintLayout3;
        this.frameCharter = familyCharterFrameBinding;
        this.frameMap = familyMapFrameBinding;
        this.frameMember = familyMembersFrameBinding;
        this.home = familyHomePageBinding;
        this.map = familyMapBinding;
        this.meetings = familyMeetingsBinding;
        this.members = familyMembersBinding;
        this.menu = familyMainMenuBinding;
        this.rating = familyRatingBinding;
        this.settings = familySettingsBinding;
        this.territories = familyTerritoriesBinding;
        this.topbar = familyTopbarBinding;
        this.war = familyWarBinding;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamilyMainBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilyMainBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_main, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilyMainBinding bind(View view) {
        View findChildViewById;
        int i = R.id.charter;
        View findChildViewById2 = ViewBindings.findChildViewById(view, i);
        if (findChildViewById2 != null) {
            FamilyCharterBinding bind = FamilyCharterBinding.bind(findChildViewById2);
            i = R.id.charter_members;
            View findChildViewById3 = ViewBindings.findChildViewById(view, i);
            if (findChildViewById3 != null) {
                FamilyCharterMembersBinding bind2 = FamilyCharterMembersBinding.bind(findChildViewById3);
                i = R.id.create;
                View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                if (findChildViewById4 != null) {
                    FamilyCreateClanBinding bind3 = FamilyCreateClanBinding.bind(findChildViewById4);
                    i = R.id.estate;
                    View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                    if (findChildViewById5 != null) {
                        FamilyEstateBinding bind4 = FamilyEstateBinding.bind(findChildViewById5);
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i = R.id.family_overlay;
                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout2 != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.frame_charter))) != null) {
                            FamilyCharterFrameBinding bind5 = FamilyCharterFrameBinding.bind(findChildViewById);
                            i = R.id.frame_map;
                            View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                            if (findChildViewById6 != null) {
                                FamilyMapFrameBinding bind6 = FamilyMapFrameBinding.bind(findChildViewById6);
                                i = R.id.frame_member;
                                View findChildViewById7 = ViewBindings.findChildViewById(view, i);
                                if (findChildViewById7 != null) {
                                    FamilyMembersFrameBinding bind7 = FamilyMembersFrameBinding.bind(findChildViewById7);
                                    i = R.id.home;
                                    View findChildViewById8 = ViewBindings.findChildViewById(view, i);
                                    if (findChildViewById8 != null) {
                                        FamilyHomePageBinding bind8 = FamilyHomePageBinding.bind(findChildViewById8);
                                        i = R.id.map;
                                        View findChildViewById9 = ViewBindings.findChildViewById(view, i);
                                        if (findChildViewById9 != null) {
                                            FamilyMapBinding bind9 = FamilyMapBinding.bind(findChildViewById9);
                                            i = R.id.meetings;
                                            View findChildViewById10 = ViewBindings.findChildViewById(view, i);
                                            if (findChildViewById10 != null) {
                                                FamilyMeetingsBinding bind10 = FamilyMeetingsBinding.bind(findChildViewById10);
                                                i = R.id.members;
                                                View findChildViewById11 = ViewBindings.findChildViewById(view, i);
                                                if (findChildViewById11 != null) {
                                                    FamilyMembersBinding bind11 = FamilyMembersBinding.bind(findChildViewById11);
                                                    i = R.id.menu;
                                                    View findChildViewById12 = ViewBindings.findChildViewById(view, i);
                                                    if (findChildViewById12 != null) {
                                                        FamilyMainMenuBinding bind12 = FamilyMainMenuBinding.bind(findChildViewById12);
                                                        i = R.id.rating;
                                                        View findChildViewById13 = ViewBindings.findChildViewById(view, i);
                                                        if (findChildViewById13 != null) {
                                                            FamilyRatingBinding bind13 = FamilyRatingBinding.bind(findChildViewById13);
                                                            i = R.id.settings;
                                                            View findChildViewById14 = ViewBindings.findChildViewById(view, i);
                                                            if (findChildViewById14 != null) {
                                                                FamilySettingsBinding bind14 = FamilySettingsBinding.bind(findChildViewById14);
                                                                i = R.id.territories;
                                                                View findChildViewById15 = ViewBindings.findChildViewById(view, i);
                                                                if (findChildViewById15 != null) {
                                                                    FamilyTerritoriesBinding bind15 = FamilyTerritoriesBinding.bind(findChildViewById15);
                                                                    i = R.id.topbar;
                                                                    View findChildViewById16 = ViewBindings.findChildViewById(view, i);
                                                                    if (findChildViewById16 != null) {
                                                                        FamilyTopbarBinding bind16 = FamilyTopbarBinding.bind(findChildViewById16);
                                                                        i = R.id.war;
                                                                        View findChildViewById17 = ViewBindings.findChildViewById(view, i);
                                                                        if (findChildViewById17 != null) {
                                                                            return new FamilyMainBinding(constraintLayout, bind, bind2, bind3, bind4, constraintLayout, constraintLayout2, bind5, bind6, bind7, bind8, bind9, bind10, bind11, bind12, bind13, bind14, bind15, bind16, FamilyWarBinding.bind(findChildViewById17));
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
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
