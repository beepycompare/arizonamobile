package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes5.dex */
public final class Ne implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f689a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Pe c;

    public Ne(Pe pe, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = pe;
        this.f689a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Sa) this.c.d.get()).getPluginExtension().reportError(this.f689a, this.b);
    }
}
