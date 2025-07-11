package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
/* renamed from: io.appmetrica.analytics.impl.xl  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0713xl implements X2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1131a;

    public C0713xl(Context context) {
        this.f1131a = context;
    }

    @Override // io.appmetrica.analytics.impl.X2, io.appmetrica.analytics.impl.InterfaceC0316hm
    public final void a(C0190cm c0190cm) {
    }

    public final Context b() {
        return this.f1131a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }
}
