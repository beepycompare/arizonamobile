package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class AnimationMenuBinding implements ViewBinding {
    public final TextView amCategoryTittle;
    public final LinearLayout amExitButton;
    public final RecyclerView animationList;
    public final LinearLayout animationListContainer;
    public final TextView animationListTittle;
    public final ConstraintLayout animationMenu;
    public final EditText animationSearch;
    public final RecyclerView categoryList;
    public final LinearLayout categoryListContainer;
    public final Guideline categoryListHz;
    public final Guideline categoryTittleHz;
    public final Guideline categoryTittleVc;
    public final Guideline exitButtonVc;
    private final ConstraintLayout rootView;

    private AnimationMenuBinding(ConstraintLayout rootView, TextView amCategoryTittle, LinearLayout amExitButton, RecyclerView animationList, LinearLayout animationListContainer, TextView animationListTittle, ConstraintLayout animationMenu, EditText animationSearch, RecyclerView categoryList, LinearLayout categoryListContainer, Guideline categoryListHz, Guideline categoryTittleHz, Guideline categoryTittleVc, Guideline exitButtonVc) {
        this.rootView = rootView;
        this.amCategoryTittle = amCategoryTittle;
        this.amExitButton = amExitButton;
        this.animationList = animationList;
        this.animationListContainer = animationListContainer;
        this.animationListTittle = animationListTittle;
        this.animationMenu = animationMenu;
        this.animationSearch = animationSearch;
        this.categoryList = categoryList;
        this.categoryListContainer = categoryListContainer;
        this.categoryListHz = categoryListHz;
        this.categoryTittleHz = categoryTittleHz;
        this.categoryTittleVc = categoryTittleVc;
        this.exitButtonVc = exitButtonVc;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AnimationMenuBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static AnimationMenuBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.animation_menu, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static AnimationMenuBinding bind(View rootView) {
        int i = R.id.am_category_tittle;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.am_exit_button;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
            if (linearLayout != null) {
                i = R.id.animation_list;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                if (recyclerView != null) {
                    i = R.id.animation_list_container;
                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                    if (linearLayout2 != null) {
                        i = R.id.animation_list_tittle;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                            i = R.id.animation_search;
                            EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
                            if (editText != null) {
                                i = R.id.category_list;
                                RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                if (recyclerView2 != null) {
                                    i = R.id.category_list_container;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (linearLayout3 != null) {
                                        i = R.id.category_list_hz;
                                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline != null) {
                                            i = R.id.category_tittle_hz;
                                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                            if (guideline2 != null) {
                                                i = R.id.category_tittle_vc;
                                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline3 != null) {
                                                    i = R.id.exit_button_vc;
                                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline4 != null) {
                                                        return new AnimationMenuBinding(constraintLayout, textView, linearLayout, recyclerView, linearLayout2, textView2, constraintLayout, editText, recyclerView2, linearLayout3, guideline, guideline2, guideline3, guideline4);
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
