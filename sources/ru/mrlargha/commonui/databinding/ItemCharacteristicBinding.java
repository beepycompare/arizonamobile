package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.progressBar.StoriesProgressView;
/* loaded from: classes5.dex */
public final class ItemCharacteristicBinding implements ViewBinding {
    public final StoriesProgressView progressView;
    private final ConstraintLayout rootView;
    public final TextView tvProgressCount;
    public final TextView tvProgressCountPlus;
    public final TextView tvTitle;

    private ItemCharacteristicBinding(ConstraintLayout rootView, StoriesProgressView progressView, TextView tvProgressCount, TextView tvProgressCountPlus, TextView tvTitle) {
        this.rootView = rootView;
        this.progressView = progressView;
        this.tvProgressCount = tvProgressCount;
        this.tvProgressCountPlus = tvProgressCountPlus;
        this.tvTitle = tvTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemCharacteristicBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemCharacteristicBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_characteristic, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemCharacteristicBinding bind(View rootView) {
        int i = R.id.progressView;
        StoriesProgressView storiesProgressView = (StoriesProgressView) ViewBindings.findChildViewById(rootView, i);
        if (storiesProgressView != null) {
            i = R.id.tvProgressCount;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                i = R.id.tvProgressCountPlus;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView2 != null) {
                    i = R.id.tvTitle;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView3 != null) {
                        return new ItemCharacteristicBinding((ConstraintLayout) rootView, storiesProgressView, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
