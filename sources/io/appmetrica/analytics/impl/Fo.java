package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes3.dex */
public final class Fo implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f481a = "WebView interface setup is successful.";

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        ((PublicLogger) obj).info(this.f481a, new Object[0]);
    }
}
