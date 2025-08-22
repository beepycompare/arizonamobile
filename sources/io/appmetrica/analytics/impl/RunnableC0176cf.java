package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* renamed from: io.appmetrica.analytics.impl.cf  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0176cf implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f812a;
    public final /* synthetic */ String b;
    public final /* synthetic */ C0227ef c;

    public RunnableC0176cf(C0227ef c0227ef, PluginErrorDetails pluginErrorDetails, String str) {
        this.c = c0227ef;
        this.f812a = pluginErrorDetails;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((InterfaceC0479ob) this.c.d.get()).getPluginExtension().reportError(this.f812a, this.b);
    }
}
