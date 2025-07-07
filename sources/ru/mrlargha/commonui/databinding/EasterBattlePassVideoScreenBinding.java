package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class EasterBattlePassVideoScreenBinding implements ViewBinding {
    public final PlayerView playerView;
    private final ConstraintLayout rootView;

    private EasterBattlePassVideoScreenBinding(ConstraintLayout rootView, PlayerView playerView) {
        this.rootView = rootView;
        this.playerView = playerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EasterBattlePassVideoScreenBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static EasterBattlePassVideoScreenBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.easter_battle_pass_video_screen, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static EasterBattlePassVideoScreenBinding bind(View rootView) {
        int i = R.id.playerView;
        PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(rootView, i);
        if (playerView != null) {
            return new EasterBattlePassVideoScreenBinding((ConstraintLayout) rootView, playerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
