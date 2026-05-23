package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class kp implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f1070a;
    public final /* synthetic */ String b = "WebView interface setup failed because of an exception.";

    public kp(Throwable th) {
        this.f1070a = th;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        ((PublicLogger) obj).error(this.f1070a, this.b, new Object[0]);
    }
}
