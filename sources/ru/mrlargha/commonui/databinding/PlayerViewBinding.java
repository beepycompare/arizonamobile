package ru.mrlargha.commonui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.commonui.R;
/* loaded from: classes5.dex */
public final class PlayerViewBinding implements ViewBinding {
    public final TextView playerId;
    public final TextView playerLevel;
    public final TextView playerNickname;
    public final TextView playerPing;
    private final LinearLayout rootView;

    private PlayerViewBinding(LinearLayout rootView, TextView playerId, TextView playerLevel, TextView playerNickname, TextView playerPing) {
        this.rootView = rootView;
        this.playerId = playerId;
        this.playerLevel = playerLevel;
        this.playerNickname = playerNickname;
        this.playerPing = playerPing;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static PlayerViewBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static PlayerViewBinding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View inflate = inflater.inflate(R.layout.player_view, parent, false);
        if (attachToParent) {
            parent.addView(inflate);
        }
        return bind(inflate);
    }

    public static PlayerViewBinding bind(View rootView) {
        int i = R.id.player_id;
        TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
        if (textView != null) {
            i = R.id.player_level;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
            if (textView2 != null) {
                i = R.id.player_nickname;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView3 != null) {
                    i = R.id.player_ping;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView4 != null) {
                        return new PlayerViewBinding((LinearLayout) rootView, textView, textView2, textView3, textView4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
