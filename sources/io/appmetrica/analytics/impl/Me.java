package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes5.dex */
public final class Me implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f695a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Oe c;

    public Me(Oe oe, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = oe;
        this.f695a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Ra) this.c.d.get()).getPluginExtension().reportError(this.f695a, this.b);
    }
}
