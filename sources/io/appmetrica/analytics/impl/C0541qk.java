package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.ModuleEvent;
import io.appmetrica.analytics.Revenue;
import io.appmetrica.analytics.ecommerce.ECommerceEvent;
import io.appmetrica.analytics.plugins.IPluginReporter;
import io.appmetrica.analytics.plugins.PluginErrorDetails;
import io.appmetrica.analytics.profile.UserProfile;
import java.util.ArrayList;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.qk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0541qk implements InterfaceC0506pb, IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1167a = new ArrayList();
    public volatile Ai b;

    @Override // io.appmetrica.analytics.impl.InterfaceC0506pb, io.appmetrica.analytics.impl.InterfaceC0609tb
    public final void a(C0622to c0622to) {
        a(new Zj(c0622to));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        a(new C0411lk());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final IPluginReporter getPluginExtension() {
        return this;
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void pauseSession() {
        a(new Tj());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void putAppEnvironmentValue(String str, String str2) {
        a(new C0385kk(str, str2));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        a(new C0127ak(adRevenue));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        a(new C0333ik(map));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        a(new Xj(eCommerceEvent));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        a(new Pj(str, th));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        a(new C0463nk(str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        a(new Wj(revenue));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        a(new Rj(th));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        a(new Vj(userProfile));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void resumeSession() {
        a(new Sj());
    }

    @Override // io.appmetrica.analytics.IReporter, io.appmetrica.analytics.IModuleReporter
    public final void sendEventsBuffer() {
        a(new C0437mk());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        a(new Yj(z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        a(new C0282gk(str, bArr));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        a(new Uj(str));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0506pb, io.appmetrica.analytics.impl.InterfaceC0314i0
    public final void a(X x) {
        a(new C0359jk(x));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        a(new C0308hk(adRevenue, z));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        a(new Qj(str, str2, null));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        a(new C0489ok(str, str2));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        a(new C0153bk(pluginErrorDetails));
    }

    public final void a(InterfaceC0618tk interfaceC0618tk) {
        a(new C0230ek(interfaceC0618tk));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        a(new Qj(str, str2, th));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        a(new C0515pk(str, map));
    }

    public final synchronized void a(InterfaceC0480ob interfaceC0480ob) {
        if (this.b == null) {
            this.f1167a.add(interfaceC0480ob);
        } else {
            interfaceC0480ob.a(this.b);
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        a(new C0179ck(pluginErrorDetails, str));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        a(new C0256fk(moduleEvent));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        a(new C0205dk(str, str2, pluginErrorDetails));
    }
}
