package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes3.dex */
public final class Hj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f510a;
    public final /* synthetic */ String b;

    public Hj(PluginErrorDetails pluginErrorDetails, String str) {
        this.f510a = pluginErrorDetails;
        this.b = str;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.getPluginExtension().reportError(this.f510a, this.b);
    }
}
