package io.appmetrica.analytics.impl;

import android.app.Activity;
import android.location.Location;
import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.AnrListener;
import io.appmetrica.analytics.ExternalAttribution;
import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public final class Uc extends C0760zi implements InterfaceC0249fb {
    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(Activity activity) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void a(Location location) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(AnrListener anrListener) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(ExternalAttribution externalAttribution) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(Io io2) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(EnumC0417m enumC0417m) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb, io.appmetrica.analytics.impl.InterfaceC0120ab
    public final void a(String str) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void a(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(String str, boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void a(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void b(Activity activity) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void b(String str) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb, io.appmetrica.analytics.impl.InterfaceC0120ab
    public final void b(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb, io.appmetrica.analytics.impl.InterfaceC0225ed
    public final void b(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb, io.appmetrica.analytics.impl.InterfaceC0120ab
    public final boolean b() {
        return false;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void c() {
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final List<String> f() {
        return new ArrayList();
    }

    @Override // io.appmetrica.analytics.impl.C0760zi, io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
    }

    @Override // io.appmetrica.analytics.impl.C0760zi, io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
    }
}
