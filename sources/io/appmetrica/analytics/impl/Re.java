package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes3.dex */
public final class Re implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f666a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Te c;

    public Re(Te te, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = te;
        this.f666a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Ya) this.c.d.get()).getPluginExtension().reportError(this.f666a, this.b);
    }
}
