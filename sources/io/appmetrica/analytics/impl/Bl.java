package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
/* loaded from: classes5.dex */
public final class Bl implements L2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f512a;

    public Bl(Context context) {
        this.f512a = context;
    }

    @Override // io.appmetrica.analytics.impl.L2, io.appmetrica.analytics.impl.InterfaceC0407lm
    public final void a(C0278gm c0278gm) {
    }

    public final Context b() {
        return this.f512a;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }
}
