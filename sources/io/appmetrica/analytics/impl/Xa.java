package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Xa implements Parcelable {
    public static final Parcelable.Creator<Xa> CREATOR = new Wa();

    /* renamed from: a  reason: collision with root package name */
    public final ResultReceiver f856a;
    public final List b;
    public final HashMap c;
    public final boolean d;

    public Xa(B6 b6, List list, Map map, boolean z) {
        HashMap hashMap;
        this.b = list;
        this.f856a = b6;
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
        bundle.putParcelable("io.appmetrica.analytics.internal.CounterConfiguration.receiver", this.f856a);
        if (this.b != null) {
            bundle.putStringArrayList("io.appmetrica.analytics.internal.CounterConfiguration.identifiersList", new ArrayList<>(this.b));
        }
        HashMap hashMap = this.c;
        if (hashMap != null) {
            bundle.putString("io.appmetrica.analytics.internal.CounterConfiguration.clidsForVerification", Fm.a((Map) hashMap));
        }
        bundle.putBoolean("io.appmetrica.analytics.internal.CounterConfiguration.forceRefreshConfiguration", this.d);
        parcel.writeBundle(bundle);
    }

    public Xa(Parcel parcel) {
        Bundle readBundle = parcel.readBundle(B6.class.getClassLoader());
        if (readBundle != null) {
            this.f856a = (ResultReceiver) readBundle.getParcelable("io.appmetrica.analytics.internal.CounterConfiguration.receiver");
            this.b = readBundle.getStringArrayList("io.appmetrica.analytics.internal.CounterConfiguration.identifiersList");
            this.c = Fm.a(readBundle.getString("io.appmetrica.analytics.internal.CounterConfiguration.clidsForVerification"));
            this.d = readBundle.getBoolean("io.appmetrica.analytics.internal.CounterConfiguration.forceRefreshConfiguration");
            return;
        }
        this.c = new HashMap();
    }
}
