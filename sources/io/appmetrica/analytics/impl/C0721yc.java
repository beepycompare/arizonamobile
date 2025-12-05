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
/* renamed from: io.appmetrica.analytics.impl.yc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0721yc extends C0325ii implements Ja {
    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(Activity activity) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ic
    public final void a(Location location) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(AnrListener anrListener) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(ExternalAttribution externalAttribution) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(Io io2) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(EnumC0434n enumC0434n) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ic
    public final void a(String str) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ic
    public final void a(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void a(String str, boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ic
    public final void a(boolean z) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ic
    public final void a(boolean z, boolean z2) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void b(Activity activity) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ea
    public final void b(String str) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ea
    public final void b(String str, String str2) {
    }

    @Override // io.appmetrica.analytics.impl.Ja, io.appmetrica.analytics.impl.Ea
    public final boolean b() {
        return false;
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void c() {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final void c(String str) {
    }

    @Override // io.appmetrica.analytics.impl.Ja
    public final List<String> f() {
        return new ArrayList();
    }

    @Override // io.appmetrica.analytics.impl.C0325ii, io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
    }

    @Override // io.appmetrica.analytics.impl.C0325ii, io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
    }
}
