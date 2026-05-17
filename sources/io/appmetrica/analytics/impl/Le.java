package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes5.dex */
public final class Le implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f683a;
    public final /* synthetic */ Oe b;

    public Le(Oe oe, PluginErrorDetails pluginErrorDetails) {
        this.b = oe;
        this.f683a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Ra) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f683a);
    }
}
