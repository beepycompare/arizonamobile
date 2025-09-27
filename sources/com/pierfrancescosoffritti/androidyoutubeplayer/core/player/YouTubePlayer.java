package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener;
import kotlin.Metadata;
/* compiled from: YouTubePlayer.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&J\b\u0010\f\u001a\u00020\u0003H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\u0003H&J\b\u0010\u0016\u001a\u00020\u0003H&J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u000fH&J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0007H&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J\u0010\u0010!\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H&J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020#H&¨\u0006%"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/YouTubePlayer;", "", "loadVideo", "", "videoId", "", "startSeconds", "", "cueVideo", "play", "pause", "nextVideo", "previousVideo", "playVideoAt", FirebaseAnalytics.Param.INDEX, "", "setLoop", "loop", "", "setShuffle", "shuffle", "mute", "unMute", "isMutedAsync", "callback", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/BooleanProvider;", "setVolume", "volumePercent", "seekTo", "time", "setPlaybackRate", "playbackRate", "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "addListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/listeners/YouTubePlayerListener;", "removeListener", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface YouTubePlayer {
    boolean addListener(YouTubePlayerListener youTubePlayerListener);

    void cueVideo(String str, float f);

    void isMutedAsync(BooleanProvider booleanProvider);

    void loadVideo(String str, float f);

    void mute();

    void nextVideo();

    void pause();

    void play();

    void playVideoAt(int i);

    void previousVideo();

    boolean removeListener(YouTubePlayerListener youTubePlayerListener);

    void seekTo(float f);

    void setLoop(boolean z);

    void setPlaybackRate(PlayerConstants.PlaybackRate playbackRate);

    void setShuffle(boolean z);

    void setVolume(int i);

    void unMute();
}
