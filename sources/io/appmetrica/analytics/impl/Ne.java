package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes5.dex */
public final class Ne implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f714a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;
    public final /* synthetic */ Oe d;

    public Ne(Oe oe, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.d = oe;
        this.f714a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Ra) this.d.d.get()).getPluginExtension().reportError(this.f714a, this.b, this.c);
    }
}
