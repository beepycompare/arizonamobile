package ru.mrlargha.feature.event.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.media3.ui.PlayerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.feature.event.R;
/* loaded from: classes3.dex */
public final class EventVideoScreenBinding implements ViewBinding {
    public final PlayerView playerView;
    private final ConstraintLayout rootView;

    private EventVideoScreenBinding(ConstraintLayout constraintLayout, PlayerView playerView) {
        this.rootView = constraintLayout;
        this.playerView = playerView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static EventVideoScreenBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static EventVideoScreenBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.event_video_screen, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static EventVideoScreenBinding bind(View view) {
        int i = R.id.playerView;
        PlayerView playerView = (PlayerView) ViewBindings.findChildViewById(view, i);
        if (playerView != null) {
            return new EventVideoScreenBinding((ConstraintLayout) view, playerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
