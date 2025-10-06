package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes4.dex */
public final class Jl implements InterfaceC0113a3 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f524a;

    public Jl(Context context) {
        this.f524a = context;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0113a3, io.appmetrica.analytics.impl.InterfaceC0619tm
    public final void a(C0494om c0494om) {
    }

    public final Context b() {
        return this.f524a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }
}
