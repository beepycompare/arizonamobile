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
public final class SpotifyGenreItemBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ConstraintLayout spotifyGenreContainer;
    public final AppCompatImageView spotifyGenreIcon;
    public final ConstraintLayout spotifyGenreItem;
    public final TextView spotifyGenreTitle;

    private SpotifyGenreItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout3, TextView textView) {
        this.rootView = constraintLayout;
        this.spotifyGenreContainer = constraintLayout2;
        this.spotifyGenreIcon = appCompatImageView;
        this.spotifyGenreItem = constraintLayout3;
        this.spotifyGenreTitle = textView;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SpotifyGenreItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SpotifyGenreItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.spotify_genre_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SpotifyGenreItemBinding bind(View view) {
        int i = R.id.spotify_genre_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.spotify_genre_icon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                i = R.id.spotify_genre_title;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                if (textView != null) {
                    return new SpotifyGenreItemBinding(constraintLayout2, constraintLayout, appCompatImageView, constraintLayout2, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
