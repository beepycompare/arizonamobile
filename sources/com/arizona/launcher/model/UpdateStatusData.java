package com.arizona.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UpdateStatusData.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0019J\u0014\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0005HÖ\u0081\u0004J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0019R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000bÊ\u0001\u0002\b%Ê\u0001\f\b&\u0012\b\b'\u0012\u0004\b\u0003\u0010\u0002¨\u0006$"}, d2 = {"Lcom/arizona/launcher/model/UpdateStatusData;", "Landroid/os/Parcelable;", "playMarket", "", "url", "", "text", "needStart", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Z)V", "getPlayMarket", "()Z", "Lcom/google/gson/annotations/SerializedName;", "value", "pm", "getUrl", "()Ljava/lang/String;", "getText", "getNeedStart", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "app", "Lkotlinx/parcelize/Parcelize;", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
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
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
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
