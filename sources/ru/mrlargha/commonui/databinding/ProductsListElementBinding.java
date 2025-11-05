package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ProductsListElementBinding implements ViewBinding {
    public final Guideline horizontalLine;
    public final Guideline leftLine;
    public final ConstraintLayout productItem;
    public final Guideline rightLine;
    private final ConstraintLayout rootView;
    public final TextView title1;
    public final TextView title2;
    public final TextView title3;
    public final TextView title4;
    public final TextView title5;
    public final TextView title6;
    public final TextView value1;
    public final TextView value2;
    public final TextView value3;
    public final TextView value4;
    public final TextView value5;
    public final TextView value6;

    private ProductsListElementBinding(ConstraintLayout rootView, Guideline horizontalLine, Guideline leftLine, ConstraintLayout productItem, Guideline rightLine, TextView title1, TextView title2, TextView title3, TextView title4, TextView title5, TextView title6, TextView value1, TextView value2, TextView value3, TextView value4, TextView value5, TextView value6) {
        this.rootView = rootView;
        this.horizontalLine = horizontalLine;
        this.leftLine = leftLine;
        this.productItem = productItem;
        this.rightLine = rightLine;
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
        this.title4 = title4;
        this.title5 = title5;
        this.title6 = title6;
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.value5 = value5;
        this.value6 = value6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ProductsListElementBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ProductsListElementBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.products_list_element, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ProductsListElementBinding bind(View rootView) {
        int i = R.id.horizontal_line;
        Guideline guideline = (Guideline) ViewBindings.findChildViewById(rootView, i);
        if (guideline != null) {
            i = R.id.left_line;
            Guideline guideline2 = (Guideline) ViewBindings.findChildViewById(rootView, i);
            if (guideline2 != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) rootView;
                i = R.id.right_line;
                Guideline guideline3 = (Guideline) ViewBindings.findChildViewById(rootView, i);
                if (guideline3 != null) {
                    i = R.id.title1;
                    TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView != null) {
                        i = R.id.title2;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                        if (textView2 != null) {
                            i = R.id.title3;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                            if (textView3 != null) {
                                i = R.id.title4;
                                TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                if (textView4 != null) {
                                    i = R.id.title5;
                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                    if (textView5 != null) {
                                        i = R.id.title6;
                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                        if (textView6 != null) {
                                            i = R.id.value1;
                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                            if (textView7 != null) {
                                                i = R.id.value2;
                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                if (textView8 != null) {
                                                    i = R.id.value3;
                                                    TextView textView9 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                    if (textView9 != null) {
                                                        i = R.id.value4;
                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                        if (textView10 != null) {
                                                            i = R.id.value5;
                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                            if (textView11 != null) {
                                                                i = R.id.value6;
                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(rootView, i);
                                                                if (textView12 != null) {
                                                                    return new ProductsListElementBinding(constraintLayout, guideline, guideline2, constraintLayout, guideline3, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, textView11, textView12);
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
