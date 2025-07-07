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
public final class SpotifyTracklistItemBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final ConstraintLayout spotifyActionContainer;
    public final AppCompatImageView spotifyFavourite;
    public final AppCompatImageView spotifyPlay;
    public final ConstraintLayout spotifySelectTrackContainer;
    public final TextView spotifySingerName;
    public final TextView spotifySongName;
    public final TextView spotifySongTime;
    public final ConstraintLayout spotifyTrackContainer;
    public final ConstraintLayout spotifyTracklistItem;

    private SpotifyTracklistItemBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout3, TextView textView, TextView textView2, TextView textView3, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5) {
        this.rootView = constraintLayout;
        this.spotifyActionContainer = constraintLayout2;
        this.spotifyFavourite = appCompatImageView;
        this.spotifyPlay = appCompatImageView2;
        this.spotifySelectTrackContainer = constraintLayout3;
        this.spotifySingerName = textView;
        this.spotifySongName = textView2;
        this.spotifySongTime = textView3;
        this.spotifyTrackContainer = constraintLayout4;
        this.spotifyTracklistItem = constraintLayout5;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static SpotifyTracklistItemBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static SpotifyTracklistItemBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.spotify_tracklist_item, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static SpotifyTracklistItemBinding bind(View view) {
        int i = R.id.spotify_action_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.spotify_favourite;
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
            if (appCompatImageView != null) {
                i = R.id.spotify_play;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                if (appCompatImageView2 != null) {
                    i = R.id.spotify_select_track_container;
                    ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                    if (constraintLayout2 != null) {
                        i = R.id.spotify_singer_name;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                        if (textView != null) {
                            i = R.id.spotify_song_name;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                            if (textView2 != null) {
                                i = R.id.spotify_song_time;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                if (textView3 != null) {
                                    i = R.id.spotify_track_container;
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                    if (constraintLayout3 != null) {
                                        ConstraintLayout constraintLayout4 = (ConstraintLayout) view;
                                        return new SpotifyTracklistItemBinding(constraintLayout4, constraintLayout, appCompatImageView, appCompatImageView2, constraintLayout2, textView, textView2, textView3, constraintLayout3, constraintLayout4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
