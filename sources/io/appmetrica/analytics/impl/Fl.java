package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes4.dex */
public final class Fl implements X2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f440a;

    public Fl(Context context) {
        this.f440a = context;
    }

    @Override // io.appmetrica.analytics.impl.X2, io.appmetrica.analytics.impl.InterfaceC0515pm
    public final void a(C0389km c0389km) {
    }

    public final Context b() {
        return this.f440a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }
}
