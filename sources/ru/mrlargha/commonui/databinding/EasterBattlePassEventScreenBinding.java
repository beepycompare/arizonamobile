package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class EasterBattlePassEventScreenBinding implements ViewBinding {
    public final EasterBattlePassEventItemBinding event1;
    public final EasterBattlePassEventItemBinding event2;
    public final EasterBattlePassEventItemBinding event3;
    private final ConstraintLayout rootView;

    private EasterBattlePassEventScreenBinding(ConstraintLayout rootView, EasterBattlePassEventItemBinding event1, EasterBattlePassEventItemBinding event2, EasterBattlePassEventItemBinding event3) {
        this.rootView = rootView;
        this.event1 = event1;
        this.event2 = event2;
        this.event3 = event3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EasterBattlePassEventScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EasterBattlePassEventScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.easter_battle_pass_event_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EasterBattlePassEventScreenBinding bind(View rootView) {
        int i = R.id.event1;
        View findChildViewById = ViewBindings.findChildViewById(rootView, i);
        if (findChildViewById != null) {
            EasterBattlePassEventItemBinding bind = EasterBattlePassEventItemBinding.bind(findChildViewById);
            int i2 = R.id.event2;
            View findChildViewById2 = ViewBindings.findChildViewById(rootView, i2);
            if (findChildViewById2 != null) {
                EasterBattlePassEventItemBinding bind2 = EasterBattlePassEventItemBinding.bind(findChildViewById2);
                int i3 = R.id.event3;
                View findChildViewById3 = ViewBindings.findChildViewById(rootView, i3);
                if (findChildViewById3 != null) {
                    return new EasterBattlePassEventScreenBinding((ConstraintLayout) rootView, bind, bind2, EasterBattlePassEventItemBinding.bind(findChildViewById3));
                }
                i = i3;
            } else {
                i = i2;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
