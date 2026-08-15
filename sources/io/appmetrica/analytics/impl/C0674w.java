package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.w  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0674w implements InterfaceC0700x {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1256a;

    public C0674w(Context context) {
        this.f1256a = context;
    }

    public final String a() {
        C0575s4 l = C0575s4.l();
        Context context = this.f1256a;
        C0297ha c0297ha = l.u;
        if (c0297ha == null) {
            synchronized (l) {
                c0297ha = l.u;
                if (c0297ha == null) {
                    c0297ha = new C0297ha(context);
                    l.u = c0297ha;
                }
            }
        }
        Bundle applicationMetaData = c0297ha.d.getApplicationMetaData(c0297ha.f1013a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
