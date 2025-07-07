package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemColorBinding implements ViewBinding {
    public final CardView parentCardView;
    private final CardView rootView;
    public final TextView tvColorName;
    public final View viewBgLocked;

    private ItemColorBinding(CardView rootView, CardView parentCardView, TextView tvColorName, View viewBgLocked) {
        this.rootView = rootView;
        this.parentCardView = parentCardView;
        this.tvColorName = tvColorName;
        this.viewBgLocked = viewBgLocked;
    }

    @Override // androidx.viewbinding.ViewBinding
    public CardView getRoot() {
        return this.rootView;
    }

    public static ItemColorBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemColorBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_color, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemColorBinding bind(View rootView) {
        View findChildViewById;
        CardView cardView = (CardView) rootView;
        int i = R.id.tvColorName;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null && (findChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.viewBgLocked))) != null) {
            return new ItemColorBinding(cardView, cardView, textView, findChildViewById);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
