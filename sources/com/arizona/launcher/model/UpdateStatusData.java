package com.arizona.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateStatusData.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0016HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006!"}, d2 = {"Lcom/arizona/launcher/model/UpdateStatusData;", "Landroid/os/Parcelable;", "playMarket", "", "url", "", "text", "needStart", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Z)V", "getPlayMarket", "()Z", "getUrl", "()Ljava/lang/String;", "getText", "getNeedStart", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "app_arizonaRelease_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateStatusData implements Parcelable {
    public static final int $stable = 0;
    public static final Parcelable.Creator<UpdateStatusData> CREATOR = new Creator();
    private final boolean needStart;
    @SerializedName("pm")
    private final boolean playMarket;
    private final String text;
    private final String url;

    /* compiled from: UpdateStatusData.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<UpdateStatusData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UpdateStatusData createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UpdateStatusData(parcel.readInt() != 0, parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final UpdateStatusData[] newArray(int i) {
            return new UpdateStatusData[i];
        }
    }

    public static /* synthetic */ UpdateStatusData copy$default(UpdateStatusData updateStatusData, boolean z, String str, String str2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = updateStatusData.playMarket;
        }
        if ((i & 2) != 0) {
            str = updateStatusData.url;
        }
        if ((i & 4) != 0) {
            str2 = updateStatusData.text;
        }
        if ((i & 8) != 0) {
            z2 = updateStatusData.needStart;
        }
        return updateStatusData.copy(z, str, str2, z2);
    }

    public final boolean component1() {
        return this.playMarket;
    }

    public final String component2() {
        return this.url;
    }

    public final String component3() {
        return this.text;
    }

    public final boolean component4() {
        return this.needStart;
    }

    public final UpdateStatusData copy(boolean z, String url, String text, boolean z2) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(text, "text");
        return new UpdateStatusData(z, url, text, z2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpdateStatusData) {
            UpdateStatusData updateStatusData = (UpdateStatusData) obj;
            return this.playMarket == updateStatusData.playMarket && Intrinsics.areEqual(this.url, updateStatusData.url) && Intrinsics.areEqual(this.text, updateStatusData.text) && this.needStart == updateStatusData.needStart;
        }
        return false;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.playMarket) * 31) + this.url.hashCode()) * 31) + this.text.hashCode()) * 31) + Boolean.hashCode(this.needStart);
    }

    public String toString() {
        boolean z = this.playMarket;
        String str = this.url;
        String str2 = this.text;
        return "UpdateStatusData(playMarket=" + z + ", url=" + str + ", text=" + str2 + ", needStart=" + this.needStart + ")";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeInt(this.playMarket ? 1 : 0);
        dest.writeString(this.url);
        dest.writeString(this.text);
        dest.writeInt(this.needStart ? 1 : 0);
    }

    public UpdateStatusData(boolean z, String url, String text, boolean z2) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(text, "text");
        this.playMarket = z;
        this.url = url;
        this.text = text;
        this.needStart = z2;
    }

    public final boolean getPlayMarket() {
        return this.playMarket;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getText() {
        return this.text;
    }

    public final boolean getNeedStart() {
        return this.needStart;
    }
}
