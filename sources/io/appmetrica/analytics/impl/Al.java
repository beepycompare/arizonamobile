package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes4.dex */
public final class Al implements X2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f344a;

    public Al(Context context) {
        this.f344a = context;
    }

    @Override // io.appmetrica.analytics.impl.X2, io.appmetrica.analytics.impl.InterfaceC0392km
    public final void a(C0267fm c0267fm) {
    }

    public final Context b() {
        return this.f344a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }
}
