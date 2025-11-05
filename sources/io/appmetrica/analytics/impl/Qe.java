package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes3.dex */
public final class Qe implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f651a;
    public final /* synthetic */ Te b;

    public Qe(Te te, PluginErrorDetails pluginErrorDetails) {
        this.b = te;
        this.f651a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Ya) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f651a);
    }
}
