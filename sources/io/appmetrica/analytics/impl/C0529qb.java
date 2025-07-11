package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.qb  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0529qb implements Parcelable {
    public static final Parcelable.Creator<C0529qb> CREATOR = new C0504pb();

    /* renamed from: a  reason: collision with root package name */
    public final ResultReceiver f1005a;
    public final List b;
    public final HashMap c;

    public C0529qb(T6 t6, List list, Map map) {
        HashMap hashMap;
        this.b = list;
        this.f1005a = t6;
        if (map == null) {
            hashMap = new HashMap();
        } else {
            hashMap = new HashMap(map);
        }
        this.c = hashMap;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("io.appmetrica.analytics.internal.CounterConfiguration.receiver", this.f1005a);
        if (this.b != null) {
            bundle.putStringArrayList("io.appmetrica.analytics.internal.CounterConfiguration.identifiersList", new ArrayList<>(this.b));
        }
        HashMap hashMap = this.c;
        if (hashMap != null) {
            bundle.putString("io.appmetrica.analytics.internal.CounterConfiguration.clidsForVerification", Dm.a((Map) hashMap));
        }
        parcel.writeBundle(bundle);
    }

    public C0529qb(Parcel parcel) {
        Bundle readBundle = parcel.readBundle(T6.class.getClassLoader());
        if (readBundle != null) {
            this.f1005a = (ResultReceiver) readBundle.getParcelable("io.appmetrica.analytics.internal.CounterConfiguration.receiver");
            this.b = readBundle.getStringArrayList("io.appmetrica.analytics.internal.CounterConfiguration.identifiersList");
            this.c = Dm.a(readBundle.getString("io.appmetrica.analytics.internal.CounterConfiguration.clidsForVerification"));
            return;
        }
        this.c = new HashMap();
    }
}
