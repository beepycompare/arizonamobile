package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
import ru.mrlargha.commonui.utils.ui.CustomCardView;
/* loaded from: classes6.dex */
public final class ViewMoneyPartInputBinding implements ViewBinding {
    public final EditText etValue;
    private final CustomCardView rootView;
    public final TextView tvSuffix;

    private ViewMoneyPartInputBinding(CustomCardView rootView, EditText etValue, TextView tvSuffix) {
        this.rootView = rootView;
        this.etValue = etValue;
        this.tvSuffix = tvSuffix;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CustomCardView getRoot() {
        return this.rootView;
    }

    public static ViewMoneyPartInputBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ViewMoneyPartInputBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.view_money_part_input, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ViewMoneyPartInputBinding bind(View rootView) {
        int i = R.id.etValue;
        EditText editText = (EditText) ViewBindings.findChildViewById(rootView, i);
        if (editText != null) {
            i = R.id.tvSuffix;
            TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView != null) {
                return new ViewMoneyPartInputBinding((CustomCardView) rootView, editText, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
