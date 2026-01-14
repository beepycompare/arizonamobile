package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.backport.Consumer;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public final class Fo implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f587a = "WebView interface setup failed because javascript is disabled for the WebView.";

    @Override // io.appmetrica.analytics.coreapi.internal.backport.Consumer
    public final void consume(Object obj) {
        ((PublicLogger) obj).warning(this.f587a, new Object[0]);
    }
}
