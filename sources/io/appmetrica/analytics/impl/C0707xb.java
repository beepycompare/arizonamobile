package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.xb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0707xb implements Parcelable {
    public static final Parcelable.Creator<C0707xb> CREATOR = new C0682wb();

    /* renamed from: a  reason: collision with root package name */
    public final ResultReceiver f1149a;
    public final List b;
    public final HashMap c;
    public final boolean d;

    public C0707xb(ResultReceiverC0116a7 resultReceiverC0116a7, List list, Map map, boolean z) {
        HashMap hashMap;
        this.b = list;
        this.f1149a = resultReceiverC0116a7;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        this.c = hashMap;
        this.d = z;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.internal.CounterConfiguration.receiver", this.f1149a);
        if (this.b != null) {
            bundle.putStringArrayList("io.appmetrica.analytics.internal.CounterConfiguration.identifiersList", new ArrayList<>(this.b));
        }
        HashMap hashMap = this.c;
        if (hashMap != null) {
            bundle.putString("io.appmetrica.analytics.internal.CounterConfiguration.clidsForVerification", Pm.a((Map) hashMap));
        }
        bundle.putBoolean("io.appmetrica.analytics.internal.CounterConfiguration.forceRefreshConfiguration", this.d);
        parcel.writeBundle(bundle);
    }

    public C0707xb(Parcel parcel) {
        Bundle readBundle = parcel.readBundle(ResultReceiverC0116a7.class.getClassLoader());
        if (readBundle != null) {
            this.f1149a = (ResultReceiver) readBundle.getParcelable("io.appmetrica.analytics.internal.CounterConfiguration.receiver");
            this.b = readBundle.getStringArrayList("io.appmetrica.analytics.internal.CounterConfiguration.identifiersList");
            this.c = Pm.a(readBundle.getString("io.appmetrica.analytics.internal.CounterConfiguration.clidsForVerification"));
            this.d = readBundle.getBoolean("io.appmetrica.analytics.internal.CounterConfiguration.forceRefreshConfiguration");
            return;
        }
        this.c = new HashMap();
    }
}
