package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class RodinaPersonalPropertyScreenBinding implements ViewBinding {
    public final Barrier barrier2;
    public final Guideline guideline;
    public final Guideline guideline29;
    public final AppCompatImageView imageView4;
    public final MaterialButton rodinaPersonalPropertyBtnBuy;
    public final AppCompatImageButton rodinaPersonalPropertyBtnClose;
    public final MaterialButton rodinaPersonalPropertyBtnEnter;
    public final TextView rodinaPersonalPropertyDescription;
    public final AppCompatImageView rodinaPersonalPropertyImage;
    public final RecyclerView rodinaPersonalPropertyRecycler;
    public final ConstraintLayout rodinaPersonalPropertyScreenRoot;
    public final TextView rodinaPersonalPropertyTitle;
    private final ConstraintLayout rootView;

    private RodinaPersonalPropertyScreenBinding(ConstraintLayout rootView, Barrier barrier2, Guideline guideline, Guideline guideline29, AppCompatImageView imageView4, MaterialButton rodinaPersonalPropertyBtnBuy, AppCompatImageButton rodinaPersonalPropertyBtnClose, MaterialButton rodinaPersonalPropertyBtnEnter, TextView rodinaPersonalPropertyDescription, AppCompatImageView rodinaPersonalPropertyImage, RecyclerView rodinaPersonalPropertyRecycler, ConstraintLayout rodinaPersonalPropertyScreenRoot, TextView rodinaPersonalPropertyTitle) {
        this.rootView = rootView;
        this.barrier2 = barrier2;
        this.guideline = guideline;
        this.guideline29 = guideline29;
        this.imageView4 = imageView4;
        this.rodinaPersonalPropertyBtnBuy = rodinaPersonalPropertyBtnBuy;
        this.rodinaPersonalPropertyBtnClose = rodinaPersonalPropertyBtnClose;
        this.rodinaPersonalPropertyBtnEnter = rodinaPersonalPropertyBtnEnter;
        this.rodinaPersonalPropertyDescription = rodinaPersonalPropertyDescription;
        this.rodinaPersonalPropertyImage = rodinaPersonalPropertyImage;
        this.rodinaPersonalPropertyRecycler = rodinaPersonalPropertyRecycler;
        this.rodinaPersonalPropertyScreenRoot = rodinaPersonalPropertyScreenRoot;
        this.rodinaPersonalPropertyTitle = rodinaPersonalPropertyTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static RodinaPersonalPropertyScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static RodinaPersonalPropertyScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.rodina_personal_property_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static RodinaPersonalPropertyScreenBinding bind(View rootView) {
        int i = R.id.barrier2;
        Barrier barrier = (Barrier) ViewBindings.findChildViewById(rootView, i);
        if (barrier != null) {
            i = R.id.guideline;
            Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline != null) {
                i = R.id.guideline29;
                Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline2 != null) {
                    i = R.id.imageView4;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                    if (appCompatImageView != null) {
                        i = R.id.rodina_personal_property_btn_buy;
                        MaterialButton materialButton = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                        if (materialButton != null) {
                            i = R.id.rodina_personal_property_btn_close;
                            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) ViewBindings.findChildViewById(rootView, i);
                            if (appCompatImageButton != null) {
                                i = R.id.rodina_personal_property_btn_enter;
                                MaterialButton materialButton2 = (MaterialButton) ViewBindings.findChildViewById(rootView, i);
                                if (materialButton2 != null) {
                                    i = R.id.rodina_personal_property_description;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView != null) {
                                        i = R.id.rodina_personal_property_image;
                                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(rootView, i);
                                        if (appCompatImageView2 != null) {
                                            i = R.id.rodina_personal_property_recycler;
                                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(rootView, i);
                                            if (recyclerView != null) {
                                                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                                                i = R.id.rodina_personal_property_title;
                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView2 != null) {
                                                    return new RodinaPersonalPropertyScreenBinding(constraintLayout, barrier, guideline, guideline2, appCompatImageView, materialButton, appCompatImageButton, materialButton2, textView, appCompatImageView2, recyclerView, constraintLayout, textView2);
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
