package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public final class Co implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f386a;
    public final /* synthetic */ String b = "WebView interface setup failed because of an exception.";

    public Co(Throwable th) {
        this.f386a = th;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        ((PublicLogger) obj).error(this.f386a, this.b, new Object[0]);
    }
}
