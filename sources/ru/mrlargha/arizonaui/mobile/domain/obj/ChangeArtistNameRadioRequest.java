package ru.mrlargha.arizonaui.mobile.domain.obj;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MobilePhoneObject.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/obj/ChangeArtistNameRadioRequest;", "", "id", "", "artistName", "", "<init>", "(ILjava/lang/String;)V", "getId", "()I", "getArtistName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChangeArtistNameRadioRequest {
    private final String artistName;
    private final int id;

    public static /* synthetic */ ChangeArtistNameRadioRequest copy$default(ChangeArtistNameRadioRequest changeArtistNameRadioRequest, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = changeArtistNameRadioRequest.id;
        }
        if ((i2 & 2) != 0) {
            str = changeArtistNameRadioRequest.artistName;
        }
        return changeArtistNameRadioRequest.copy(i, str);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.artistName;
    }

    public final ChangeArtistNameRadioRequest copy(int i, String artistName) {
        Intrinsics.checkNotNullParameter(artistName, "artistName");
        return new ChangeArtistNameRadioRequest(i, artistName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChangeArtistNameRadioRequest) {
            ChangeArtistNameRadioRequest changeArtistNameRadioRequest = (ChangeArtistNameRadioRequest) obj;
            return this.id == changeArtistNameRadioRequest.id && Intrinsics.areEqual(this.artistName, changeArtistNameRadioRequest.artistName);
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.id) * 31) + this.artistName.hashCode();
    }

    public String toString() {
        int i = this.id;
        return "ChangeArtistNameRadioRequest(id=" + i + ", artistName=" + this.artistName + ")";
    }

    public ChangeArtistNameRadioRequest(int i, String artistName) {
        Intrinsics.checkNotNullParameter(artistName, "artistName");
        this.id = i;
        this.artistName = artistName;
    }

    public final String getArtistName() {
        return this.artistName;
    }

    public final int getId() {
        return this.id;
    }
}
