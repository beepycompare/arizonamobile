package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.w  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0675w implements InterfaceC0701x {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1254a;

    public C0675w(Context context) {
        this.f1254a = context;
    }

    public final String a() {
        C0576s4 l = C0576s4.l();
        Context context = this.f1254a;
        C0298ha c0298ha = l.u;
        if (c0298ha == null) {
            synchronized (l) {
                c0298ha = l.u;
                if (c0298ha == null) {
                    c0298ha = new C0298ha(context);
                    l.u = c0298ha;
                }
            }
        }
        Bundle applicationMetaData = c0298ha.d.getApplicationMetaData(c0298ha.f1011a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
