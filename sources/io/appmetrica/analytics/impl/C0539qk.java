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
public final class C0539qk implements InterfaceC0504pb, IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1170a = new ArrayList();
    public volatile Ai b;

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb, io.appmetrica.analytics.impl.InterfaceC0607tb
    public final void a(C0620to c0620to) {
        a(new Zj(c0620to));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        a(new C0409lk());
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
        a(new C0383kk(str, str2));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        a(new C0125ak(adRevenue));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        a(new C0331ik(map));
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
        a(new C0461nk(str));
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
        a(new C0435mk());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        a(new Yj(z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        a(new C0280gk(str, bArr));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        a(new Uj(str));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0504pb, io.appmetrica.analytics.impl.InterfaceC0312i0
    public final void a(X x) {
        a(new C0357jk(x));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        a(new C0306hk(adRevenue, z));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        a(new Qj(str, str2, null));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        a(new C0487ok(str, str2));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        a(new C0151bk(pluginErrorDetails));
    }

    public final void a(InterfaceC0616tk interfaceC0616tk) {
        a(new C0228ek(interfaceC0616tk));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        a(new Qj(str, str2, th));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        a(new C0513pk(str, map));
    }

    public final synchronized void a(InterfaceC0478ob interfaceC0478ob) {
        if (this.b == null) {
            this.f1170a.add(interfaceC0478ob);
        } else {
            interfaceC0478ob.a(this.b);
        }
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        a(new C0177ck(pluginErrorDetails, str));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        a(new C0254fk(moduleEvent));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        a(new C0203dk(str, str2, pluginErrorDetails));
    }
}
