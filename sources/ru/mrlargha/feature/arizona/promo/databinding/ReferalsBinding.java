package ru.mrlargha.feature.arizona.promo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.GradientText.ArizonaGradientTextView;
import ru.mrlargha.feature.arizona.promo.R;
/* loaded from: classes6.dex */
public final class ReferalsBinding implements ViewBinding {
    public final LinearLayout editRefs;
    public final RefsHeaderBinding header;
    public final LinearLayout info;
    public final LinearLayout listRefs;
    private final LinearLayout rootView;
    public final RecyclerView rv;
    public final ArizonaGradientTextView title;
    public final View viewAfterLevel;
    public final View viewBeforeLevel;

    private ReferalsBinding(LinearLayout linearLayout, LinearLayout linearLayout2, RefsHeaderBinding refsHeaderBinding, LinearLayout linearLayout3, LinearLayout linearLayout4, RecyclerView recyclerView, ArizonaGradientTextView arizonaGradientTextView, View view, View view2) {
        this.rootView = linearLayout;
        this.editRefs = linearLayout2;
        this.header = refsHeaderBinding;
        this.info = linearLayout3;
        this.listRefs = linearLayout4;
        this.rv = recyclerView;
        this.title = arizonaGradientTextView;
        this.viewAfterLevel = view;
        this.viewBeforeLevel = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ReferalsBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static ReferalsBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.referals, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static ReferalsBinding bind(View view) {
        View findChildViewById;
        View findChildViewById2;
        View findChildViewById3;
        int i = R.id.edit_refs;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, i);
        if (linearLayout != null && (findChildViewById = ViewBindings.findChildViewById(view, (i = R.id.header))) != null) {
            RefsHeaderBinding bind = RefsHeaderBinding.bind(findChildViewById);
            i = R.id.info;
            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, i);
            if (linearLayout2 != null) {
                i = R.id.list_refs;
                LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, i);
                if (linearLayout3 != null) {
                    i = R.id.rv;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                    if (recyclerView != null) {
                        i = R.id.title;
                        ArizonaGradientTextView arizonaGradientTextView = (ArizonaGradientTextView) ViewBindings.findChildViewById(view, i);
                        if (arizonaGradientTextView != null && (findChildViewById2 = ViewBindings.findChildViewById(view, (i = R.id.view_after_level))) != null && (findChildViewById3 = ViewBindings.findChildViewById(view, (i = R.id.view_before_level))) != null) {
                            return new ReferalsBinding((LinearLayout) view, linearLayout, bind, linearLayout2, linearLayout3, recyclerView, arizonaGradientTextView, findChildViewById2, findChildViewById3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
