package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes5.dex */
public final class Cj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f538a;
    public final /* synthetic */ String b;

    public Cj(PluginErrorDetails pluginErrorDetails, String str) {
        this.f538a = pluginErrorDetails;
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.getPluginExtension().reportError(this.f538a, this.b);
    }
}
