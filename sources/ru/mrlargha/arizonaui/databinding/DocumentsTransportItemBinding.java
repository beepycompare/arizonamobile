package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class DocumentsTransportItemBinding implements ViewBinding {
    public final LinearLayout costContainer;
    public final TextView documentsTransportCarStatus;
    public final TextView documentsTransportItemCost;
    public final ImageView documentsTransportItemIc;
    public final TextView documentsTransportItemMilliage;
    public final TextView documentsTransportItemNumber;
    public final TextView documentsTransportItemText;
    public final LinearLayout milliageContainer;
    private final LinearLayout rootView;
    public final LinearLayout statusContainer;
    public final ImageView statusImage;

    private DocumentsTransportItemBinding(LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, TextView textView5, LinearLayout linearLayout3, LinearLayout linearLayout4, ImageView imageView2) {
        this.rootView = linearLayout;
        this.costContainer = linearLayout2;
        this.documentsTransportCarStatus = textView;
        this.documentsTransportItemCost = textView2;
        this.documentsTransportItemIc = imageView;
        this.documentsTransportItemMilliage = textView3;
        this.documentsTransportItemNumber = textView4;
        this.documentsTransportItemText = textView5;
        this.milliageContainer = linearLayout3;
        this.statusContainer = linearLayout4;
        this.statusImage = imageView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static DocumentsTransportItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DocumentsTransportItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.documents_transport_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DocumentsTransportItemBinding bind(View view) {
        int i = R.id.cost_container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null) {
            i = R.id.documents_transport_car_status;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
            if (textView != null) {
                i = R.id.documents_transport_item_cost;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView2 != null) {
                    i = R.id.documents_transport_item_ic;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                    if (imageView != null) {
                        i = R.id.documents_transport_item_milliage;
                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView3 != null) {
                            i = R.id.documents_transport_item_number;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView4 != null) {
                                i = R.id.documents_transport_item_text;
                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView5 != null) {
                                    i = R.id.milliage_container;
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                    if (linearLayout2 != null) {
                                        i = R.id.status_container;
                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                        if (linearLayout3 != null) {
                                            i = R.id.status_image;
                                            ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                            if (imageView2 != null) {
                                                return new DocumentsTransportItemBinding((LinearLayout) view, linearLayout, textView, textView2, imageView, textView3, textView4, textView5, linearLayout2, linearLayout3, imageView2);
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
