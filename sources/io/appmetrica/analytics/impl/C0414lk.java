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
/* renamed from: io.appmetrica.analytics.impl.lk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0414lk implements InterfaceC0558rb, IPluginReporter {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f977a = new ArrayList();
    public volatile Ci b;

    @Override // io.appmetrica.analytics.impl.InterfaceC0558rb, io.appmetrica.analytics.impl.InterfaceC0633ub
    public final void a(Wn wn) {
        a(new Vj(wn));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void clearAppEnvironment() {
        a(new C0285gk());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final IPluginReporter getPluginExtension() {
        return this;
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void pauseSession() {
        a(new Pj());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void putAppEnvironmentValue(String str, String str2) {
        a(new C0259fk(str, str2));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAdRevenue(AdRevenue adRevenue) {
        a(new Wj(adRevenue));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportAnr(Map<Thread, StackTraceElement[]> map) {
        a(new C0208dk(map));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportECommerce(ECommerceEvent eCommerceEvent) {
        a(new Tj(eCommerceEvent));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, Throwable th) {
        a(new Lj(str, th));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str) {
        a(new C0336ik(str));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportRevenue(Revenue revenue) {
        a(new Sj(revenue));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUnhandledException(Throwable th) {
        a(new Nj(th));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportUserProfile(UserProfile userProfile) {
        a(new Rj(userProfile));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void resumeSession() {
        a(new Oj());
    }

    @Override // io.appmetrica.analytics.IReporter, io.appmetrica.analytics.IModuleReporter
    public final void sendEventsBuffer() {
        a(new C0311hk());
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setDataSendingEnabled(boolean z) {
        a(new Uj(z));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void setSessionExtra(String str, byte[] bArr) {
        a(new C0156bk(str, bArr));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void setUserProfileID(String str) {
        a(new Qj(str));
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0558rb, io.appmetrica.analytics.impl.InterfaceC0239f0
    public final void a(U u) {
        a(new C0233ek(u));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportAdRevenue(AdRevenue adRevenue, boolean z) {
        a(new C0182ck(adRevenue, z));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2) {
        a(new Mj(str, str2, null));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, String str2) {
        a(new C0362jk(str, str2));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportUnhandledException(PluginErrorDetails pluginErrorDetails) {
        a(new Xj(pluginErrorDetails));
    }

    public final synchronized void a(InterfaceC0534qb interfaceC0534qb) {
        if (this.b == null) {
            this.f977a.add(interfaceC0534qb);
        } else {
            interfaceC0534qb.a(this.b);
        }
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportError(String str, String str2, Throwable th) {
        a(new Mj(str, str2, th));
    }

    @Override // io.appmetrica.analytics.IReporter
    public final void reportEvent(String str, Map<String, Object> map) {
        a(new C0388kk(str, map));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(PluginErrorDetails pluginErrorDetails, String str) {
        a(new Yj(pluginErrorDetails, str));
    }

    @Override // io.appmetrica.analytics.IModuleReporter
    public final void reportEvent(ModuleEvent moduleEvent) {
        a(new C0130ak(moduleEvent));
    }

    @Override // io.appmetrica.analytics.plugins.IPluginReporter
    public final void reportError(String str, String str2, PluginErrorDetails pluginErrorDetails) {
        a(new Zj(str, str2, pluginErrorDetails));
    }
}
