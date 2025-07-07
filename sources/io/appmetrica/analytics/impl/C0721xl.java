package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
/* renamed from: io.appmetrica.analytics.impl.xl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0721xl implements X2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1130a;

    public C0721xl(Context context) {
        this.f1130a = context;
    }

    @Override // io.appmetrica.analytics.impl.X2, io.appmetrica.analytics.impl.InterfaceC0324hm
    public final void a(C0198cm c0198cm) {
    }

    public final Context b() {
        return this.f1130a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }
}
