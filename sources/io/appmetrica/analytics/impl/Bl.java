package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes5.dex */
public final class Bl implements L2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f414a;

    public Bl(Context context) {
        this.f414a = context;
    }

    @Override // io.appmetrica.analytics.impl.L2, io.appmetrica.analytics.impl.InterfaceC0408lm
    public final void a(C0279gm c0279gm) {
    }

    public final Context b() {
        return this.f414a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }
}
