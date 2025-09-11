package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes4.dex */
public final class Jl implements InterfaceC0112a3 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f523a;

    public Jl(Context context) {
        this.f523a = context;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0112a3, io.appmetrica.analytics.impl.InterfaceC0618tm
    public final void a(C0493om c0493om) {
    }

    public final Context b() {
        return this.f523a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }
}
