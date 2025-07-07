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
public final class DocumentsHealthBinding implements ViewBinding {
    public final ImageView alertNot;
    public final DocumentsHealthBarItemBinding bar1;
    public final DocumentsHealthBarItemBinding bar10;
    public final DocumentsHealthBarItemBinding bar2;
    public final DocumentsHealthBarItemBinding bar3;
    public final DocumentsHealthBarItemBinding bar4;
    public final DocumentsHealthBarItemBinding bar5;
    public final DocumentsHealthBarItemBinding bar6;
    public final DocumentsHealthBarItemBinding bar7;
    public final DocumentsHealthBarItemBinding bar8;
    public final DocumentsHealthBarItemBinding bar9;
    public final TextView desc;
    public final TextView descText;
    public final TextView drugs;
    public final TextView duration;
    public final LinearLayout gpsButton;
    public final TextView hpState;
    public final TextView insurance;
    public final LinearLayout medReviewBars;
    public final TextView medReviewCount;
    public final ImageView medReviewImage;
    public final TextView medReviewText;
    public final TextView name;
    public final LinearLayout notAvailableContainer;
    public final ImageView photo;
    public final TextView psych;
    public final TextView psychDesc;
    public final TextView psychLabel;
    public final LinearLayout reviewContainer;
    private final ConstraintLayout rootView;
    public final LinearLayout table1;
    public final LinearLayout table2;

    private DocumentsHealthBinding(ConstraintLayout constraintLayout, ImageView imageView, DocumentsHealthBarItemBinding documentsHealthBarItemBinding, DocumentsHealthBarItemBinding documentsHealthBarItemBinding2, DocumentsHealthBarItemBinding documentsHealthBarItemBinding3, DocumentsHealthBarItemBinding documentsHealthBarItemBinding4, DocumentsHealthBarItemBinding documentsHealthBarItemBinding5, DocumentsHealthBarItemBinding documentsHealthBarItemBinding6, DocumentsHealthBarItemBinding documentsHealthBarItemBinding7, DocumentsHealthBarItemBinding documentsHealthBarItemBinding8, DocumentsHealthBarItemBinding documentsHealthBarItemBinding9, DocumentsHealthBarItemBinding documentsHealthBarItemBinding10, TextView textView, TextView textView2, TextView textView3, TextView textView4, LinearLayout linearLayout, TextView textView5, TextView textView6, LinearLayout linearLayout2, TextView textView7, ImageView imageView2, TextView textView8, TextView textView9, LinearLayout linearLayout3, ImageView imageView3, TextView textView10, TextView textView11, TextView textView12, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6) {
        this.rootView = constraintLayout;
        this.alertNot = imageView;
        this.bar1 = documentsHealthBarItemBinding;
        this.bar10 = documentsHealthBarItemBinding2;
        this.bar2 = documentsHealthBarItemBinding3;
        this.bar3 = documentsHealthBarItemBinding4;
        this.bar4 = documentsHealthBarItemBinding5;
        this.bar5 = documentsHealthBarItemBinding6;
        this.bar6 = documentsHealthBarItemBinding7;
        this.bar7 = documentsHealthBarItemBinding8;
        this.bar8 = documentsHealthBarItemBinding9;
        this.bar9 = documentsHealthBarItemBinding10;
        this.desc = textView;
        this.descText = textView2;
        this.drugs = textView3;
        this.duration = textView4;
        this.gpsButton = linearLayout;
        this.hpState = textView5;
        this.insurance = textView6;
        this.medReviewBars = linearLayout2;
        this.medReviewCount = textView7;
        this.medReviewImage = imageView2;
        this.medReviewText = textView8;
        this.name = textView9;
        this.notAvailableContainer = linearLayout3;
        this.photo = imageView3;
        this.psych = textView10;
        this.psychDesc = textView11;
        this.psychLabel = textView12;
        this.reviewContainer = linearLayout4;
        this.table1 = linearLayout5;
        this.table2 = linearLayout6;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DocumentsHealthBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DocumentsHealthBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.documents_health, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DocumentsHealthBinding bind(View view) {
        View findChildViewById;
        int i = R.id.alert_not;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.bar1))) != null) {
            DocumentsHealthBarItemBinding bind = DocumentsHealthBarItemBinding.bind(findChildViewById);
            i = R.id.bar10;
            View findChildViewById2 = ViewBindings.findChildViewById(view, i);
            if (findChildViewById2 != null) {
                DocumentsHealthBarItemBinding bind2 = DocumentsHealthBarItemBinding.bind(findChildViewById2);
                i = R.id.bar2;
                View findChildViewById3 = ViewBindings.findChildViewById(view, i);
                if (findChildViewById3 != null) {
                    DocumentsHealthBarItemBinding bind3 = DocumentsHealthBarItemBinding.bind(findChildViewById3);
                    i = R.id.bar3;
                    View findChildViewById4 = ViewBindings.findChildViewById(view, i);
                    if (findChildViewById4 != null) {
                        DocumentsHealthBarItemBinding bind4 = DocumentsHealthBarItemBinding.bind(findChildViewById4);
                        i = R.id.bar4;
                        View findChildViewById5 = ViewBindings.findChildViewById(view, i);
                        if (findChildViewById5 != null) {
                            DocumentsHealthBarItemBinding bind5 = DocumentsHealthBarItemBinding.bind(findChildViewById5);
                            i = R.id.bar5;
                            View findChildViewById6 = ViewBindings.findChildViewById(view, i);
                            if (findChildViewById6 != null) {
                                DocumentsHealthBarItemBinding bind6 = DocumentsHealthBarItemBinding.bind(findChildViewById6);
                                i = R.id.bar6;
                                View findChildViewById7 = ViewBindings.findChildViewById(view, i);
                                if (findChildViewById7 != null) {
                                    DocumentsHealthBarItemBinding bind7 = DocumentsHealthBarItemBinding.bind(findChildViewById7);
                                    i = R.id.bar7;
                                    View findChildViewById8 = ViewBindings.findChildViewById(view, i);
                                    if (findChildViewById8 != null) {
                                        DocumentsHealthBarItemBinding bind8 = DocumentsHealthBarItemBinding.bind(findChildViewById8);
                                        i = R.id.bar8;
                                        View findChildViewById9 = ViewBindings.findChildViewById(view, i);
                                        if (findChildViewById9 != null) {
                                            DocumentsHealthBarItemBinding bind9 = DocumentsHealthBarItemBinding.bind(findChildViewById9);
                                            i = R.id.bar9;
                                            View findChildViewById10 = ViewBindings.findChildViewById(view, i);
                                            if (findChildViewById10 != null) {
                                                DocumentsHealthBarItemBinding bind10 = DocumentsHealthBarItemBinding.bind(findChildViewById10);
                                                i = R.id.desc;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                                                if (textView != null) {
                                                    i = R.id.desc_text;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                                    if (textView2 != null) {
                                                        i = R.id.drugs;
                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                                        if (textView3 != null) {
                                                            i = R.id.duration;
                                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                            if (textView4 != null) {
                                                                i = R.id.gps_button;
                                                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                if (linearLayout != null) {
                                                                    i = R.id.hp_state;
                                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                    if (textView5 != null) {
                                                                        i = R.id.insurance;
                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                        if (textView6 != null) {
                                                                            i = R.id.medReviewBars;
                                                                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                            if (linearLayout2 != null) {
                                                                                i = R.id.medReviewCount;
                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                if (textView7 != null) {
                                                                                    i = R.id.medReviewImage;
                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                    if (imageView2 != null) {
                                                                                        i = R.id.medReviewText;
                                                                                        TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                        if (textView8 != null) {
                                                                                            i = R.id.name;
                                                                                            TextView textView9 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                            if (textView9 != null) {
                                                                                                i = R.id.notAvailableContainer;
                                                                                                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                if (linearLayout3 != null) {
                                                                                                    i = R.id.photo;
                                                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (imageView3 != null) {
                                                                                                        i = R.id.psych;
                                                                                                        TextView textView10 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView10 != null) {
                                                                                                            i = R.id.psychDesc;
                                                                                                            TextView textView11 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView11 != null) {
                                                                                                                i = R.id.psychLabel;
                                                                                                                TextView textView12 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView12 != null) {
                                                                                                                    i = R.id.review_container;
                                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (linearLayout4 != null) {
                                                                                                                        i = R.id.table1;
                                                                                                                        LinearLayout linearLayout5 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (linearLayout5 != null) {
                                                                                                                            i = R.id.table2;
                                                                                                                            LinearLayout linearLayout6 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (linearLayout6 != null) {
                                                                                                                                return new DocumentsHealthBinding((ConstraintLayout) view, imageView, bind, bind2, bind3, bind4, bind5, bind6, bind7, bind8, bind9, bind10, textView, textView2, textView3, textView4, linearLayout, textView5, textView6, linearLayout2, textView7, imageView2, textView8, textView9, linearLayout3, imageView3, textView10, textView11, textView12, linearLayout4, linearLayout5, linearLayout6);
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
