package io.appmetrica.analytics.impl;

import android.content.Context;
import javax.net.ssl.SSLSocketFactory;
/* renamed from: io.appmetrica.analytics.impl.cm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0174cm implements X2 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f937a;

    public C0174cm(Context context) {
        this.f937a = context;
    }

    @Override // io.appmetrica.analytics.impl.X2, io.appmetrica.analytics.impl.Mm
    public final void a(Hm hm) {
    }

    @Override // io.appmetrica.analytics.coreapi.internal.io.SslSocketFactoryProvider
    public final SSLSocketFactory getSslSocketFactory() {
        return null;
    }

    public final Context a() {
        return this.f937a;
    }
}
