package com.pierfrancescosoffritti.androidyoutubeplayer.core.player;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* compiled from: PlayerConstants.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants;", "", "<init>", "()V", "PlayerState", "PlaybackQuality", "PlayerError", "PlaybackRate", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlayerConstants {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: PlayerConstants.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "UNSTARTED", "ENDED", "PLAYING", "PAUSED", "BUFFERING", "VIDEO_CUED", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class PlayerState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PlayerState[] $VALUES;
        public static final PlayerState UNKNOWN = new PlayerState("UNKNOWN", 0);
        public static final PlayerState UNSTARTED = new PlayerState("UNSTARTED", 1);
        public static final PlayerState ENDED = new PlayerState("ENDED", 2);
        public static final PlayerState PLAYING = new PlayerState("PLAYING", 3);
        public static final PlayerState PAUSED = new PlayerState("PAUSED", 4);
        public static final PlayerState BUFFERING = new PlayerState("BUFFERING", 5);
        public static final PlayerState VIDEO_CUED = new PlayerState("VIDEO_CUED", 6);

        private static final /* synthetic */ PlayerState[] $values() {
            return new PlayerState[]{UNKNOWN, UNSTARTED, ENDED, PLAYING, PAUSED, BUFFERING, VIDEO_CUED};
        }

        public static EnumEntries<PlayerState> getEntries() {
            return $ENTRIES;
        }

        private PlayerState(String str, int i) {
        }

        static {
            PlayerState[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static PlayerState valueOf(String str) {
            return (PlayerState) Enum.valueOf(PlayerState.class, str);
        }

        public static PlayerState[] values() {
            return (PlayerState[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: PlayerConstants.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackQuality;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "SMALL", "MEDIUM", "LARGE", "HD720", "HD1080", "HIGH_RES", "DEFAULT", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class PlaybackQuality {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PlaybackQuality[] $VALUES;
        public static final PlaybackQuality UNKNOWN = new PlaybackQuality("UNKNOWN", 0);
        public static final PlaybackQuality SMALL = new PlaybackQuality("SMALL", 1);
        public static final PlaybackQuality MEDIUM = new PlaybackQuality("MEDIUM", 2);
        public static final PlaybackQuality LARGE = new PlaybackQuality("LARGE", 3);
        public static final PlaybackQuality HD720 = new PlaybackQuality("HD720", 4);
        public static final PlaybackQuality HD1080 = new PlaybackQuality("HD1080", 5);
        public static final PlaybackQuality HIGH_RES = new PlaybackQuality("HIGH_RES", 6);
        public static final PlaybackQuality DEFAULT = new PlaybackQuality("DEFAULT", 7);

        private static final /* synthetic */ PlaybackQuality[] $values() {
            return new PlaybackQuality[]{UNKNOWN, SMALL, MEDIUM, LARGE, HD720, HD1080, HIGH_RES, DEFAULT};
        }

        public static EnumEntries<PlaybackQuality> getEntries() {
            return $ENTRIES;
        }

        private PlaybackQuality(String str, int i) {
        }

        static {
            PlaybackQuality[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static PlaybackQuality valueOf(String str) {
            return (PlaybackQuality) Enum.valueOf(PlaybackQuality.class, str);
        }

        public static PlaybackQuality[] values() {
            return (PlaybackQuality[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: PlayerConstants.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlayerError;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "INVALID_PARAMETER_IN_REQUEST", "HTML_5_PLAYER", "VIDEO_NOT_FOUND", "VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER", "REQUEST_MISSING_HTTP_REFERER", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class PlayerError {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PlayerError[] $VALUES;
        public static final PlayerError UNKNOWN = new PlayerError("UNKNOWN", 0);
        public static final PlayerError INVALID_PARAMETER_IN_REQUEST = new PlayerError("INVALID_PARAMETER_IN_REQUEST", 1);
        public static final PlayerError HTML_5_PLAYER = new PlayerError("HTML_5_PLAYER", 2);
        public static final PlayerError VIDEO_NOT_FOUND = new PlayerError("VIDEO_NOT_FOUND", 3);
        public static final PlayerError VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER = new PlayerError("VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER", 4);
        public static final PlayerError REQUEST_MISSING_HTTP_REFERER = new PlayerError("REQUEST_MISSING_HTTP_REFERER", 5);

        private static final /* synthetic */ PlayerError[] $values() {
            return new PlayerError[]{UNKNOWN, INVALID_PARAMETER_IN_REQUEST, HTML_5_PLAYER, VIDEO_NOT_FOUND, VIDEO_NOT_PLAYABLE_IN_EMBEDDED_PLAYER, REQUEST_MISSING_HTTP_REFERER};
        }

        public static EnumEntries<PlayerError> getEntries() {
            return $ENTRIES;
        }

        private PlayerError(String str, int i) {
        }

        static {
            PlayerError[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static PlayerError valueOf(String str) {
            return (PlayerError) Enum.valueOf(PlayerError.class, str);
        }

        public static PlayerError[] values() {
            return (PlayerError[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: PlayerConstants.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/pierfrancescosoffritti/androidyoutubeplayer/core/player/PlayerConstants$PlaybackRate;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "RATE_0_25", "RATE_0_5", "RATE_0_75", "RATE_1", "RATE_1_25", "RATE_1_5", "RATE_1_75", "RATE_2", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class PlaybackRate {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PlaybackRate[] $VALUES;
        public static final PlaybackRate UNKNOWN = new PlaybackRate("UNKNOWN", 0);
        public static final PlaybackRate RATE_0_25 = new PlaybackRate("RATE_0_25", 1);
        public static final PlaybackRate RATE_0_5 = new PlaybackRate("RATE_0_5", 2);
        public static final PlaybackRate RATE_0_75 = new PlaybackRate("RATE_0_75", 3);
        public static final PlaybackRate RATE_1 = new PlaybackRate("RATE_1", 4);
        public static final PlaybackRate RATE_1_25 = new PlaybackRate("RATE_1_25", 5);
        public static final PlaybackRate RATE_1_5 = new PlaybackRate("RATE_1_5", 6);
        public static final PlaybackRate RATE_1_75 = new PlaybackRate("RATE_1_75", 7);
        public static final PlaybackRate RATE_2 = new PlaybackRate("RATE_2", 8);

        private static final /* synthetic */ PlaybackRate[] $values() {
            return new PlaybackRate[]{UNKNOWN, RATE_0_25, RATE_0_5, RATE_0_75, RATE_1, RATE_1_25, RATE_1_5, RATE_1_75, RATE_2};
        }

        public static EnumEntries<PlaybackRate> getEntries() {
            return $ENTRIES;
        }

        private PlaybackRate(String str, int i) {
        }

        static {
            PlaybackRate[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        public static PlaybackRate valueOf(String str) {
            return (PlaybackRate) Enum.valueOf(PlaybackRate.class, str);
        }

        public static PlaybackRate[] values() {
            return (PlaybackRate[]) $VALUES.clone();
        }
    }
}
