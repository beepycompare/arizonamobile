package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes5.dex */
public final class Me implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f687a;
    public final /* synthetic */ Pe b;

    public Me(Pe pe, PluginErrorDetails pluginErrorDetails) {
        this.b = pe;
        this.f687a = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Sa) this.b.d.get()).getPluginExtension().reportUnhandledException(this.f687a);
    }
}
