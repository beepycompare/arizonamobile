package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class ItemInvetoryCharacterBinding implements ViewBinding {
    private final ConstraintLayout rootView;

    private ItemInvetoryCharacterBinding(ConstraintLayout rootView) {
        this.rootView = rootView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ItemInvetoryCharacterBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ItemInvetoryCharacterBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.item_invetory_character, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static ItemInvetoryCharacterBinding bind(View rootView) {
        if (rootView == null) {
            throw new NullPointerException("rootView");
        }
        return new ItemInvetoryCharacterBinding((ConstraintLayout) rootView);
    }
}
