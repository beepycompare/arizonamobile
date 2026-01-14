package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes5.dex */
public final class Dj implements Qa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f554a;
    public final /* synthetic */ String b;
    public final /* synthetic */ PluginErrorDetails c;

    public Dj(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        this.f554a = str;
        this.b = str2;
        this.c = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.Qa
    public final void a(Ra ra) {
        ra.getPluginExtension().reportError(this.f554a, this.b, this.c);
    }
}
