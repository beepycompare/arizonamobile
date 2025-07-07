package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class FamilyCreateClanBinding implements ViewBinding {
    public final CardView buttonCreateFamily;
    public final TextView buttonTitle;
    public final ImageView colorLeftArrow;
    public final ImageView colorRightArrow;
    public final RecyclerView colorsRv;
    public final TextView createCost;
    public final EditText familyNameEdit;
    public final EditText familySloganEdit;
    public final ProgressBar loaderBar;
    public final ImageView logoImage;
    public final ImageView logoLeftArrow;
    public final TextView logoNumber;
    public final ImageView logoRightArrow;
    public final TextView logoTitle;
    public final LinearLayout nameTitle;
    public final View nameView;
    public final ConstraintLayout neighborGameTaskScreen;
    private final ConstraintLayout rootView;
    public final TextView sloganHint;
    public final TextView titleHint;

    private FamilyCreateClanBinding(ConstraintLayout constraintLayout, CardView cardView, TextView textView, ImageView imageView, ImageView imageView2, RecyclerView recyclerView, TextView textView2, EditText editText, EditText editText2, ProgressBar progressBar, ImageView imageView3, ImageView imageView4, TextView textView3, ImageView imageView5, TextView textView4, LinearLayout linearLayout, View view, ConstraintLayout constraintLayout2, TextView textView5, TextView textView6) {
        this.rootView = constraintLayout;
        this.buttonCreateFamily = cardView;
        this.buttonTitle = textView;
        this.colorLeftArrow = imageView;
        this.colorRightArrow = imageView2;
        this.colorsRv = recyclerView;
        this.createCost = textView2;
        this.familyNameEdit = editText;
        this.familySloganEdit = editText2;
        this.loaderBar = progressBar;
        this.logoImage = imageView3;
        this.logoLeftArrow = imageView4;
        this.logoNumber = textView3;
        this.logoRightArrow = imageView5;
        this.logoTitle = textView4;
        this.nameTitle = linearLayout;
        this.nameView = view;
        this.neighborGameTaskScreen = constraintLayout2;
        this.sloganHint = textView5;
        this.titleHint = textView6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static FamilyCreateClanBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static FamilyCreateClanBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.family_create_clan, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static FamilyCreateClanBinding bind(View view) {
        View findChildViewById;
        int i = R.id.button_create_family;
        CardView cardView = (CardView) ViewBindings.findChildViewById(view, i);
        if (cardView != null) {
            i = R.id.button_title;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.color_left_arrow;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.color_right_arrow;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView2 != null) {
                        i = R.id.colors_rv;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                        if (recyclerView != null) {
                            i = R.id.create_cost;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.family_name_edit;
                                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                if (editText != null) {
                                    i = R.id.family_slogan_edit;
                                    EditText editText2 = (EditText) ViewBindings.findChildViewById(view, i);
                                    if (editText2 != null) {
                                        i = R.id.loader_bar;
                                        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, i);
                                        if (progressBar != null) {
                                            i = R.id.logo_image;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView3 != null) {
                                                i = R.id.logo_left_arrow;
                                                ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                if (imageView4 != null) {
                                                    i = R.id.logo_number;
                                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView3 != null) {
                                                        i = R.id.logo_right_arrow;
                                                        ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                        if (imageView5 != null) {
                                                            i = R.id.logo_title;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.name_title;
                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.name_view))) != null) {
                                                                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                                                    i = R.id.slogan_hint;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.title_hint;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            return new FamilyCreateClanBinding(constraintLayout, cardView, textView, imageView, imageView2, recyclerView, textView2, editText, editText2, progressBar, imageView3, imageView4, textView3, imageView5, textView4, linearLayout, findChildViewById, constraintLayout, textView5, textView6);
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
