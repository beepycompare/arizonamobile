package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class DocumentsArmyBinding implements ViewBinding {
    public final ImageView alertNot;
    public final TextView armyOnline;
    public final LinearLayout emptyDesc;
    public final TextView emptyDescText;
    public final TextView haveArmyTicket;
    public final TextView info;
    public final ImageView infoIc;
    public final TextView name;
    public final LinearLayout notAvailableContainer;
    public final ImageView photo;
    public final TextView rank;
    private final ConstraintLayout rootView;
    public final LinearLayout table1;
    public final LinearLayout table2;

    private DocumentsArmyBinding(ConstraintLayout constraintLayout, ImageView imageView, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3, TextView textView4, ImageView imageView2, TextView textView5, LinearLayout linearLayout2, ImageView imageView3, TextView textView6, LinearLayout linearLayout3, LinearLayout linearLayout4) {
        this.rootView = constraintLayout;
        this.alertNot = imageView;
        this.armyOnline = textView;
        this.emptyDesc = linearLayout;
        this.emptyDescText = textView2;
        this.haveArmyTicket = textView3;
        this.info = textView4;
        this.infoIc = imageView2;
        this.name = textView5;
        this.notAvailableContainer = linearLayout2;
        this.photo = imageView3;
        this.rank = textView6;
        this.table1 = linearLayout3;
        this.table2 = linearLayout4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DocumentsArmyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DocumentsArmyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.documents_army, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DocumentsArmyBinding bind(View view) {
        int i = R.id.alert_not;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.army_online;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.empty_desc;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout != null) {
                    i = R.id.empty_desc_text;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView2 != null) {
                        i = R.id.have_army_ticket;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.info;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.info_ic;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                if (imageView2 != null) {
                                    i = R.id.name;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView5 != null) {
                                        i = R.id.notAvailableContainer;
                                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout2 != null) {
                                            i = R.id.photo;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView3 != null) {
                                                i = R.id.rank;
                                                TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView6 != null) {
                                                    i = R.id.table1;
                                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                    if (linearLayout3 != null) {
                                                        i = R.id.table2;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                        if (linearLayout4 != null) {
                                                            return new DocumentsArmyBinding((ConstraintLayout) view, imageView, textView, linearLayout, textView2, textView3, textView4, imageView2, textView5, linearLayout2, imageView3, textView6, linearLayout3, linearLayout4);
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
