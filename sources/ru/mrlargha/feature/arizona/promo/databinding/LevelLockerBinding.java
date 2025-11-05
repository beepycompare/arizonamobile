package ru.mrlargha.feature.arizona.promo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.utils.ui.GradientText.ArizonaGradientTextView;
import ru.mrlargha.feature.arizona.promo.R;
/* loaded from: classes6.dex */
public final class LevelLockerBinding implements ViewBinding {
    private final FrameLayout rootView;
    public final ArizonaGradientTextView text;

    private LevelLockerBinding(FrameLayout frameLayout, ArizonaGradientTextView arizonaGradientTextView) {
        this.rootView = frameLayout;
        this.text = arizonaGradientTextView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static LevelLockerBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static LevelLockerBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.level_locker, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static LevelLockerBinding bind(View view) {
        int i = R.id.text;
        ArizonaGradientTextView arizonaGradientTextView = (ArizonaGradientTextView) ViewBindings.findChildViewById(view, i);
        if (arizonaGradientTextView != null) {
            return new LevelLockerBinding((FrameLayout) view, arizonaGradientTextView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
