package ru.mrlargha.feature.mobile.presentation.page.spotify.api.obj;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SpotifyResponse.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u001f\u001a\u00020\u0005J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J;\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010&\u001a\u00020\t2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010(\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010)\u001a\u00020\u0005HÖ\u0081\u0004R-\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR-\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R-\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0019¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R-\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0007¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006*"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/spotify/api/obj/ArizonaSpotifyTrackResponse;", "", "id", "", "songName", "", "artistName", TypedValues.TransitionType.S_DURATION, "isTrackActive", "", "<init>", "(ILjava/lang/String;Ljava/lang/String;IZ)V", "getId", "()I", "setId", "(I)V", "Lcom/google/gson/annotations/SerializedName;", "value", "getSongName", "()Ljava/lang/String;", "setSongName", "(Ljava/lang/String;)V", "song_name", "getArtistName", "setArtistName", "artist_name", "getDuration", "setDuration", "()Z", "setTrackActive", "(Z)V", "getTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaSpotifyTrackResponse {
    @SerializedName("artist_name")
    private String artistName;
    @SerializedName(TypedValues.TransitionType.S_DURATION)
    private int duration;
    @SerializedName("id")
    private int id;
    private boolean isTrackActive;
    @SerializedName("song_name")
    private String songName;

    public static /* synthetic */ ArizonaSpotifyTrackResponse copy$default(ArizonaSpotifyTrackResponse arizonaSpotifyTrackResponse, int i, String str, String str2, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = arizonaSpotifyTrackResponse.id;
        }
        if ((i3 & 2) != 0) {
            str = arizonaSpotifyTrackResponse.songName;
        }
        if ((i3 & 4) != 0) {
            str2 = arizonaSpotifyTrackResponse.artistName;
        }
        if ((i3 & 8) != 0) {
            i2 = arizonaSpotifyTrackResponse.duration;
        }
        if ((i3 & 16) != 0) {
            z = arizonaSpotifyTrackResponse.isTrackActive;
        }
        boolean z2 = z;
        String str3 = str2;
        return arizonaSpotifyTrackResponse.copy(i, str, str3, i2, z2);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.songName;
    }

    public final String component3() {
        return this.artistName;
    }

    public final int component4() {
        return this.duration;
    }

    public final boolean component5() {
        return this.isTrackActive;
    }

    public final ArizonaSpotifyTrackResponse copy(int i, String songName, String artistName, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(songName, "songName");
        Intrinsics.checkNotNullParameter(artistName, "artistName");
        return new ArizonaSpotifyTrackResponse(i, songName, artistName, i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArizonaSpotifyTrackResponse) {
            ArizonaSpotifyTrackResponse arizonaSpotifyTrackResponse = (ArizonaSpotifyTrackResponse) obj;
            return this.id == arizonaSpotifyTrackResponse.id && Intrinsics.areEqual(this.songName, arizonaSpotifyTrackResponse.songName) && Intrinsics.areEqual(this.artistName, arizonaSpotifyTrackResponse.artistName) && this.duration == arizonaSpotifyTrackResponse.duration && this.isTrackActive == arizonaSpotifyTrackResponse.isTrackActive;
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.id) * 31) + this.songName.hashCode()) * 31) + this.artistName.hashCode()) * 31) + Integer.hashCode(this.duration)) * 31) + Boolean.hashCode(this.isTrackActive);
    }

    public String toString() {
        int i = this.id;
        String str = this.songName;
        String str2 = this.artistName;
        int i2 = this.duration;
        return "ArizonaSpotifyTrackResponse(id=" + i + ", songName=" + str + ", artistName=" + str2 + ", duration=" + i2 + ", isTrackActive=" + this.isTrackActive + ")";
    }

    public ArizonaSpotifyTrackResponse(int i, String songName, String artistName, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(songName, "songName");
        Intrinsics.checkNotNullParameter(artistName, "artistName");
        this.id = i;
        this.songName = songName;
        this.artistName = artistName;
        this.duration = i2;
        this.isTrackActive = z;
    }

    public /* synthetic */ ArizonaSpotifyTrackResponse(int i, String str, String str2, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, i2, (i3 & 16) != 0 ? false : z);
    }

    public final int getId() {
        return this.id;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final String getSongName() {
        return this.songName;
    }

    public final void setSongName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.songName = str;
    }

    public final String getArtistName() {
        return this.artistName;
    }

    public final void setArtistName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.artistName = str;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final void setDuration(int i) {
        this.duration = i;
    }

    public final boolean isTrackActive() {
        return this.isTrackActive;
    }

    public final void setTrackActive(boolean z) {
        this.isTrackActive = z;
    }

    public final String getTime() {
        try {
            String format = new SimpleDateFormat("mm:ss", Locale.US).format(new Date(this.duration * 1000));
            Intrinsics.checkNotNull(format);
            return format;
        } catch (Exception e) {
            return e.toString();
        }
    }
}
