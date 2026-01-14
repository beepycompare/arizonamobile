package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes5.dex */
public final class Al implements K2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f503a;

    public Al(Context context) {
        this.f503a = context;
    }

    @Override // io.appmetrica.analytics.impl.K2, io.appmetrica.analytics.impl.InterfaceC0386km
    public final void a(C0257fm c0257fm) {
    }

    public final Context b() {
        return this.f503a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }
}
