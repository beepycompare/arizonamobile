package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.w  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0673w implements InterfaceC0699x {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1256a;

    public C0673w(Context context) {
        this.f1256a = context;
    }

    public final String a() {
        C0574s4 l = C0574s4.l();
        Context context = this.f1256a;
        C0296ha c0296ha = l.u;
        if (c0296ha == null) {
            synchronized (l) {
                c0296ha = l.u;
                if (c0296ha == null) {
                    c0296ha = new C0296ha(context);
                    l.u = c0296ha;
                }
            }
        }
        Bundle applicationMetaData = c0296ha.d.getApplicationMetaData(c0296ha.f1013a);
        if (applicationMetaData != null) {
            return applicationMetaData.getString("io.appmetrica.analytics.plugin_supported_ad_revenue_sources");
        }
        return null;
    }
}
