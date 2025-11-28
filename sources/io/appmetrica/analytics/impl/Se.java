package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes5.dex */
public final class Se implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f684a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;
    public final /* synthetic */ Te d;

    public Se(Te te, String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.d = te;
        this.f684a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Ya) this.d.d.get()).getPluginExtension().reportError(this.f684a, this.b, this.c);
    }
}
