package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class SelectorDialogBinding implements ViewBinding {
    public final TextView btnClose;
    public final TextView btnFifthItem;
    public final TextView btnFirstItem;
    public final TextView btnFourthItem;
    public final TextView btnSecondItem;
    public final TextView btnSixthItem;
    public final TextView btnThirdItem;
    public final ConstraintLayout dialogLayout;
    public final Guideline guidelineHor1;
    public final Guideline guidelineHor2;
    public final Guideline guidelineVer1;
    public final Guideline guidelineVer2;
    public final ImageView ivItemBg;
    public final ConstraintLayout parentLayout;
    private final ConstraintLayout rootView;
    public final TextView tvItemDescription;
    public final TextView tvItemName;
    public final ImageView viewLine;

    private SelectorDialogBinding(ConstraintLayout rootView, TextView btnClose, TextView btnFifthItem, TextView btnFirstItem, TextView btnFourthItem, TextView btnSecondItem, TextView btnSixthItem, TextView btnThirdItem, ConstraintLayout dialogLayout, Guideline guidelineHor1, Guideline guidelineHor2, Guideline guidelineVer1, Guideline guidelineVer2, ImageView ivItemBg, ConstraintLayout parentLayout, TextView tvItemDescription, TextView tvItemName, ImageView viewLine) {
        this.rootView = rootView;
        this.btnClose = btnClose;
        this.btnFifthItem = btnFifthItem;
        this.btnFirstItem = btnFirstItem;
        this.btnFourthItem = btnFourthItem;
        this.btnSecondItem = btnSecondItem;
        this.btnSixthItem = btnSixthItem;
        this.btnThirdItem = btnThirdItem;
        this.dialogLayout = dialogLayout;
        this.guidelineHor1 = guidelineHor1;
        this.guidelineHor2 = guidelineHor2;
        this.guidelineVer1 = guidelineVer1;
        this.guidelineVer2 = guidelineVer2;
        this.ivItemBg = ivItemBg;
        this.parentLayout = parentLayout;
        this.tvItemDescription = tvItemDescription;
        this.tvItemName = tvItemName;
        this.viewLine = viewLine;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SelectorDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SelectorDialogBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.selector_dialog, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SelectorDialogBinding bind(View rootView) {
        int i = R.id.btnClose;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.btnFifthItem;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.btnFirstItem;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.btnFourthItem;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        i = R.id.btnSecondItem;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView5 != null) {
                            i = R.id.btnSixthItem;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView6 != null) {
                                i = R.id.btnThirdItem;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView7 != null) {
                                    i = R.id.dialogLayout;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(rootView, i);
                                    if (constraintLayout != null) {
                                        i = R.id.guidelineHor1;
                                        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                        if (guideline != null) {
                                            i = R.id.guidelineHor2;
                                            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                            if (guideline2 != null) {
                                                i = R.id.guidelineVer1;
                                                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                if (guideline3 != null) {
                                                    i = R.id.guidelineVer2;
                                                    Guideline guideline4 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                                                    if (guideline4 != null) {
                                                        i = R.id.ivItemBg;
                                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                        if (imageView != null) {
                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) rootView;
                                                            i = R.id.tvItemDescription;
                                                            TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView8 != null) {
                                                                i = R.id.tvItemName;
                                                                TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView9 != null) {
                                                                    i = R.id.viewLine;
                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(rootView, i);
                                                                    if (imageView2 != null) {
                                                                        return new SelectorDialogBinding(constraintLayout2, textView, textView2, textView3, textView4, textView5, textView6, textView7, constraintLayout, guideline, guideline2, guideline3, guideline4, imageView, constraintLayout2, textView8, textView9, imageView2);
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
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
