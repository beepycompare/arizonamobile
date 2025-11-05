package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.plugins.PluginErrorDetails;
/* loaded from: classes3.dex */
public final class Gj implements Xa {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PluginErrorDetails f494a;

    public Gj(PluginErrorDetails pluginErrorDetails) {
        this.f494a = pluginErrorDetails;
    }

    @Override // io.appmetrica.analytics.impl.Xa
    public final void a(Ya ya) {
        ya.getPluginExtension().reportUnhandledException(this.f494a);
    }
}
