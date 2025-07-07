package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class SpotifyPlaylistItemBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ConstraintLayout spotifyPlaylistCircle;
    public final AppCompatImageView spotifyPlaylistIcon;
    public final ConstraintLayout spotifyPlaylistItem;
    public final TextView spotifyPlaylistTitle;

    private SpotifyPlaylistItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout3, TextView textView) {
        this.rootView = constraintLayout;
        this.spotifyPlaylistCircle = constraintLayout2;
        this.spotifyPlaylistIcon = appCompatImageView;
        this.spotifyPlaylistItem = constraintLayout3;
        this.spotifyPlaylistTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SpotifyPlaylistItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SpotifyPlaylistItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.spotify_playlist_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SpotifyPlaylistItemBinding bind(View view) {
        int i = R.id.spotify_playlist_circle;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.spotify_playlist_icon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                i = R.id.spotify_playlist_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new SpotifyPlaylistItemBinding(constraintLayout2, constraintLayout, appCompatImageView, constraintLayout2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
