package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes5.dex */
public final class Al implements K2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f502a;

    public Al(Context context) {
        this.f502a = context;
    }

    @Override // io.appmetrica.analytics.impl.K2, io.appmetrica.analytics.impl.InterfaceC0385km
    public final void a(C0256fm c0256fm) {
    }

    public final Context b() {
        return this.f502a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }
}
