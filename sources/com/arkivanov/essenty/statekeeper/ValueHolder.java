package com.arkivanov.essenty.statekeeper;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BundleExt.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u0000 \u0016*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0003:\u0001\u0016B!\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016R\u0015\u0010\u0004\u001a\u0004\u0018\u00018\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0017"}, d2 = {"Lcom/arkivanov/essenty/statekeeper/ValueHolder;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroid/os/Parcelable;", "value", "bytes", "Lkotlin/Lazy;", "", "<init>", "(Ljava/lang/Object;Lkotlin/Lazy;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getBytes", "()Lkotlin/Lazy;", "writeToParcel", "", "dest", "Landroid/os/Parcel;", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "describeContents", "CREATOR", "state-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ValueHolder<T> implements Parcelable {
    public static final CREATOR CREATOR = new CREATOR(null);
    private final Lazy<byte[]> bytes;
    private final T value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ValueHolder(T t, Lazy<byte[]> bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.value = t;
        this.bytes = bytes;
    }

    public final T getValue() {
        return this.value;
    }

    public final Lazy<byte[]> getBytes() {
        return this.bytes;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i) {
        Intrinsics.checkNotNullParameter(dest, "dest");
        dest.writeByteArray(this.bytes.getValue());
    }

    /* compiled from: BundleExt.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0016J#\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/arkivanov/essenty/statekeeper/ValueHolder$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/arkivanov/essenty/statekeeper/ValueHolder;", "", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/arkivanov/essenty/statekeeper/ValueHolder;", "state-keeper_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class CREATOR implements Parcelable.Creator<ValueHolder<? extends Object>> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: createFromParcel */
        public ValueHolder<? extends Object> createFromParcel2(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ValueHolder<>(null, LazyKt.lazyOf(parcel.createByteArray()));
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: newArray */
        public ValueHolder<? extends Object>[] newArray2(int i) {
            return new ValueHolder[i];
        }
    }
}
