package ru.mrlargha.arizonaui.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import ru.mrlargha.arizonaui.R;
/* loaded from: classes5.dex */
public final class MobilePhoneSpotifyPageBinding implements ViewBinding {
    public final ConstraintLayout mpSpotifyActionContainer;
    public final ConstraintLayout mpSpotifyBack;
    public final ImageView mpSpotifyBackArrow;
    public final TextView mpSpotifyBackTitle;
    public final ConstraintLayout mpSpotifyChangeTrackContainer;
    public final ConstraintLayout mpSpotifyFastGenreContainer;
    public final RecyclerView mpSpotifyFastGenreList;
    public final TextView mpSpotifyFastGenreTitle;
    public final ConstraintLayout mpSpotifyFoundTrackListContainer;
    public final TextView mpSpotifyFoundTrackListTitle;
    public final ConstraintLayout mpSpotifyHeader;
    public final ImageView mpSpotifyLogoBackArrow;
    public final ConstraintLayout mpSpotifyLogoContainer;
    public final AppCompatImageView mpSpotifyLogoImg;
    public final TextView mpSpotifyLogoTitle;
    public final ConstraintLayout mpSpotifyPage;
    public final AppCompatImageView mpSpotifyPlay;
    public final ConstraintLayout mpSpotifyPlayerContainer;
    public final AppCompatImageView mpSpotifySearchClose;
    public final EditText mpSpotifySearchInput;
    public final ConstraintLayout mpSpotifySearchInputContainer;
    public final AppCompatImageView mpSpotifySearchZoom;
    public final SeekBar mpSpotifySeekBar;
    public final TextView mpSpotifySingerName;
    public final ImageView mpSpotifySongLive;
    public final TextView mpSpotifySongName;
    public final TextView mpSpotifySongTime;
    public final TextView mpSpotifyTitle;
    public final ConstraintLayout mpSpotifyTrackContainer;
    public final RecyclerView mpSpotifyTracklist;
    public final AppCompatImageView mpSpotifyZoom;
    private final ConstraintLayout rootView;
    public final RecyclerView spotifyTrackList;

    private MobilePhoneSpotifyPageBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ImageView imageView, TextView textView, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, RecyclerView recyclerView, TextView textView2, ConstraintLayout constraintLayout6, TextView textView3, ConstraintLayout constraintLayout7, ImageView imageView2, ConstraintLayout constraintLayout8, AppCompatImageView appCompatImageView, TextView textView4, ConstraintLayout constraintLayout9, AppCompatImageView appCompatImageView2, ConstraintLayout constraintLayout10, AppCompatImageView appCompatImageView3, EditText editText, ConstraintLayout constraintLayout11, AppCompatImageView appCompatImageView4, SeekBar seekBar, TextView textView5, ImageView imageView3, TextView textView6, TextView textView7, TextView textView8, ConstraintLayout constraintLayout12, RecyclerView recyclerView2, AppCompatImageView appCompatImageView5, RecyclerView recyclerView3) {
        this.rootView = constraintLayout;
        this.mpSpotifyActionContainer = constraintLayout2;
        this.mpSpotifyBack = constraintLayout3;
        this.mpSpotifyBackArrow = imageView;
        this.mpSpotifyBackTitle = textView;
        this.mpSpotifyChangeTrackContainer = constraintLayout4;
        this.mpSpotifyFastGenreContainer = constraintLayout5;
        this.mpSpotifyFastGenreList = recyclerView;
        this.mpSpotifyFastGenreTitle = textView2;
        this.mpSpotifyFoundTrackListContainer = constraintLayout6;
        this.mpSpotifyFoundTrackListTitle = textView3;
        this.mpSpotifyHeader = constraintLayout7;
        this.mpSpotifyLogoBackArrow = imageView2;
        this.mpSpotifyLogoContainer = constraintLayout8;
        this.mpSpotifyLogoImg = appCompatImageView;
        this.mpSpotifyLogoTitle = textView4;
        this.mpSpotifyPage = constraintLayout9;
        this.mpSpotifyPlay = appCompatImageView2;
        this.mpSpotifyPlayerContainer = constraintLayout10;
        this.mpSpotifySearchClose = appCompatImageView3;
        this.mpSpotifySearchInput = editText;
        this.mpSpotifySearchInputContainer = constraintLayout11;
        this.mpSpotifySearchZoom = appCompatImageView4;
        this.mpSpotifySeekBar = seekBar;
        this.mpSpotifySingerName = textView5;
        this.mpSpotifySongLive = imageView3;
        this.mpSpotifySongName = textView6;
        this.mpSpotifySongTime = textView7;
        this.mpSpotifyTitle = textView8;
        this.mpSpotifyTrackContainer = constraintLayout12;
        this.mpSpotifyTracklist = recyclerView2;
        this.mpSpotifyZoom = appCompatImageView5;
        this.spotifyTrackList = recyclerView3;
    }

    @Override // androidx.viewbinding.ViewBinding
    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static MobilePhoneSpotifyPageBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static MobilePhoneSpotifyPageBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.mobile_phone_spotify_page, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static MobilePhoneSpotifyPageBinding bind(View view) {
        int i = R.id.mp_spotify_action_container;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
        if (constraintLayout != null) {
            i = R.id.mp_spotify_back;
            ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
            if (constraintLayout2 != null) {
                i = R.id.mp_spotify_back_arrow;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
                if (imageView != null) {
                    i = R.id.mp_spotify_back_title;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, i);
                    if (textView != null) {
                        i = R.id.mp_spotify_change_track_container;
                        ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                        if (constraintLayout3 != null) {
                            i = R.id.mp_spotify_fast_genre_container;
                            ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                            if (constraintLayout4 != null) {
                                i = R.id.mp_spotify_fast_genre_list;
                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                if (recyclerView != null) {
                                    i = R.id.mp_spotify_fast_genre_title;
                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, i);
                                    if (textView2 != null) {
                                        i = R.id.mp_spotify_found_track_list_container;
                                        ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                        if (constraintLayout5 != null) {
                                            i = R.id.mp_spotify_found_track_list_title;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, i);
                                            if (textView3 != null) {
                                                i = R.id.mp_spotify_header;
                                                ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                if (constraintLayout6 != null) {
                                                    i = R.id.mp_spotify_logo_back_arrow;
                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                    if (imageView2 != null) {
                                                        i = R.id.mp_spotify_logo_container;
                                                        ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                        if (constraintLayout7 != null) {
                                                            i = R.id.mp_spotify_logo_img;
                                                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                            if (appCompatImageView != null) {
                                                                i = R.id.mp_spotify_logo_title;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                if (textView4 != null) {
                                                                    ConstraintLayout constraintLayout8 = (ConstraintLayout) view;
                                                                    i = R.id.mp_spotify_play;
                                                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                    if (appCompatImageView2 != null) {
                                                                        i = R.id.mp_spotify_player_container;
                                                                        ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                        if (constraintLayout9 != null) {
                                                                            i = R.id.mp_spotify_search_close;
                                                                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                            if (appCompatImageView3 != null) {
                                                                                i = R.id.mp_spotify_search_input;
                                                                                EditText editText = (EditText) ViewBindings.findChildViewById(view, i);
                                                                                if (editText != null) {
                                                                                    i = R.id.mp_spotify_search_input_container;
                                                                                    ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                    if (constraintLayout10 != null) {
                                                                                        i = R.id.mp_spotify_search_zoom;
                                                                                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                                        if (appCompatImageView4 != null) {
                                                                                            i = R.id.mp_spotify_seek_bar;
                                                                                            SeekBar seekBar = (SeekBar) ViewBindings.findChildViewById(view, i);
                                                                                            if (seekBar != null) {
                                                                                                i = R.id.mp_spotify_singer_name;
                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                if (textView5 != null) {
                                                                                                    i = R.id.mp_spotify_song_live;
                                                                                                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, i);
                                                                                                    if (imageView3 != null) {
                                                                                                        i = R.id.mp_spotify_song_name;
                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                        if (textView6 != null) {
                                                                                                            i = R.id.mp_spotify_song_time;
                                                                                                            TextView textView7 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                            if (textView7 != null) {
                                                                                                                i = R.id.mp_spotify_title;
                                                                                                                TextView textView8 = (TextView) ViewBindings.findChildViewById(view, i);
                                                                                                                if (textView8 != null) {
                                                                                                                    i = R.id.mp_spotify_track_container;
                                                                                                                    ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view, i);
                                                                                                                    if (constraintLayout11 != null) {
                                                                                                                        i = R.id.mp_spotify_tracklist;
                                                                                                                        RecyclerView recyclerView2 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                        if (recyclerView2 != null) {
                                                                                                                            i = R.id.mp_spotify_zoom;
                                                                                                                            AppCompatImageView appCompatImageView5 = (AppCompatImageView) ViewBindings.findChildViewById(view, i);
                                                                                                                            if (appCompatImageView5 != null) {
                                                                                                                                i = R.id.spotify_track_list;
                                                                                                                                RecyclerView recyclerView3 = (RecyclerView) ViewBindings.findChildViewById(view, i);
                                                                                                                                if (recyclerView3 != null) {
                                                                                                                                    return new MobilePhoneSpotifyPageBinding(constraintLayout8, constraintLayout, constraintLayout2, imageView, textView, constraintLayout3, constraintLayout4, recyclerView, textView2, constraintLayout5, textView3, constraintLayout6, imageView2, constraintLayout7, appCompatImageView, textView4, constraintLayout8, appCompatImageView2, constraintLayout9, appCompatImageView3, editText, constraintLayout10, appCompatImageView4, seekBar, textView5, imageView3, textView6, textView7, textView8, constraintLayout11, recyclerView2, appCompatImageView5, recyclerView3);
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
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
