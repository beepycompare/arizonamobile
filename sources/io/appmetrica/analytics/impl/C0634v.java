package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.v  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0634v implements InterfaceC0659w {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1159a;

    public C0634v(Context context) {
        this.f1159a = context;
    }

    public final String a() {
        C0338j4 l = C0338j4.l();
        Context context = this.f1159a;
        T9 t9 = l.t;
        if (t9 == null) {
            synchronized (l) {
                t9 = l.t;
                if (t9 == null) {
                    t9 = new T9(context);
                    l.t = t9;
                }
            }
        }
        Bundle applicationMetaData = t9.d.getApplicationMetaData(t9.f702a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
