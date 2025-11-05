package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textview.MaterialTextView;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemEmploymentTopTableBinding implements ViewBinding {
    public final Guideline guideline1;
    public final Guideline guideline2;
    public final Guideline guideline3;
    public final Guideline guideline4;
    public final Guideline guideline5;
    public final ConstraintLayout itemLayout;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final MaterialTextView tvAction;
    public final MaterialTextView tvAuthor;
    public final MaterialTextView tvDate;
    public final MaterialTextView tvDescription;
    public final MaterialTextView tvNumber;
    public final MaterialTextView tvOrganization;

    private ItemEmploymentTopTableBinding(ConstraintLayout rootView, Guideline guideline1, Guideline guideline2, Guideline guideline3, Guideline guideline4, Guideline guideline5, ConstraintLayout itemLayout, ConstraintLayout parentLayout, MaterialTextView tvAction, MaterialTextView tvAuthor, MaterialTextView tvDate, MaterialTextView tvDescription, MaterialTextView tvNumber, MaterialTextView tvOrganization) {
        this.rootView = rootView;
        this.guideline1 = guideline1;
        this.guideline2 = guideline2;
        this.guideline3 = guideline3;
        this.guideline4 = guideline4;
        this.guideline5 = guideline5;
        this.itemLayout = itemLayout;
        this.parentLayout = parentLayout;
        this.tvAction = tvAction;
        this.tvAuthor = tvAuthor;
        this.tvDate = tvDate;
        this.tvDescription = tvDescription;
        this.tvNumber = tvNumber;
        this.tvOrganization = tvOrganization;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemEmploymentTopTableBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemEmploymentTopTableBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_employment_top_table, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemEmploymentTopTableBinding bind(View rootView) {
        int i = R.id.guideline1;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.guideline2;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline2 != null) {
                i = R.id.guideline3;
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline3 != null) {
                    i = R.id.guideline4;
                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                    if (guideline4 != null) {
                        i = R.id.guideline5;
                        Guideline guideline5 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                        if (guideline5 != null) {
                            i = R.id.itemLayout;
                            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                            if (constraintLayout != null) {
                                ConstraintLayout constraintLayout2 = (ConstraintLayout) rootView;
                                i = R.id.tvAction;
                                MaterialTextView materialTextView = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                if (materialTextView != null) {
                                    i = R.id.tvAuthor;
                                    MaterialTextView materialTextView2 = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                    if (materialTextView2 != null) {
                                        i = R.id.tvDate;
                                        MaterialTextView materialTextView3 = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                        if (materialTextView3 != null) {
                                            i = R.id.tvDescription;
                                            MaterialTextView materialTextView4 = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                            if (materialTextView4 != null) {
                                                i = R.id.tvNumber;
                                                MaterialTextView materialTextView5 = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                                if (materialTextView5 != null) {
                                                    i = R.id.tvOrganization;
                                                    MaterialTextView materialTextView6 = (MaterialTextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (materialTextView6 != null) {
                                                        return new ItemEmploymentTopTableBinding(constraintLayout2, guideline, guideline2, guideline3, guideline4, guideline5, constraintLayout, constraintLayout2, materialTextView, materialTextView2, materialTextView3, materialTextView4, materialTextView5, materialTextView6);
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
