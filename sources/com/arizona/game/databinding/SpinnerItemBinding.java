package com.arizona.game.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.arizona.game.R;
/* loaded from: classes3.dex */
public final class SpinnerItemBinding implements ViewBinding {
    private final TextView rootView;

    private SpinnerItemBinding(TextView rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public TextView getRoot() {
        return this.rootView;
    }

    public static SpinnerItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static SpinnerItemBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.spinner_item, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static SpinnerItemBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new SpinnerItemBinding((TextView) rootView);
    }
}
