package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class DocumentsHealthBarItemBinding implements ViewBinding {
    public final View bar;
    private final View rootView;

    private DocumentsHealthBarItemBinding(View view, View view2) {
        this.rootView = view;
        this.bar = view2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        return this.rootView;
    }

    public static DocumentsHealthBarItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static DocumentsHealthBarItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.documents_health_bar_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DocumentsHealthBarItemBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        return new DocumentsHealthBarItemBinding(view, view);
    }
}
