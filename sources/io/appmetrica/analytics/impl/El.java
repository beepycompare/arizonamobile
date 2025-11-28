package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes5.dex */
public final class El implements S2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f464a;

    public El(Context context) {
        this.f464a = context;
    }

    @Override // io.appmetrica.analytics.impl.S2, io.appmetrica.analytics.impl.InterfaceC0483om
    public final void a(C0356jm c0356jm) {
    }

    public final Context b() {
        return this.f464a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }
}
