package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes5.dex */
public final class Oe implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f718a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;
    public final /* synthetic */ Pe d;

    public Oe(Pe pe, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.d = pe;
        this.f718a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Sa) this.d.d.get()).getPluginExtension().reportError(this.f718a, this.b, this.c);
    }
}
