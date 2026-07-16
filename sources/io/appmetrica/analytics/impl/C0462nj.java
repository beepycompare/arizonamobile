package io.appmetrica.analytics.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import java.util.List;
import kotlin.collections.CollectionsKt;
/* renamed from: io.appmetrica.analytics.impl.nj  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0462nj {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1120a;

    public C0462nj(Context context) {
        this.f1120a = context;
    }

    public static final void a(C0462nj c0462nj, ServiceConnection serviceConnection) {
        c0462nj.getClass();
        try {
            c0462nj.f1120a.unbindService(serviceConnection);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Dg dg) {
        ComponentName componentName;
        List<ResolveInfo> queryIntentServices;
        try {
            Intent intent = new Intent("ru.vk.store.sdk.install.referrer.InstallReferrerProvider");
            intent.setPackage("ru.vk.store");
            queryIntentServices = this.f1120a.getPackageManager().queryIntentServices(intent, 0);
        } catch (Throwable unused) {
        }
        if (queryIntentServices.isEmpty()) {
            componentName = null;
            if (componentName != null) {
                dg.a(new Jg("RuStore service component not found", null, 2, null));
                return;
            }
            Intent intent2 = new Intent("ru.vk.store.sdk.install.referrer.InstallReferrerProvider");
            intent2.setComponent(componentName);
            try {
                if (this.f1120a.bindService(intent2, new ServiceConnectionC0436mj(this, dg), 1)) {
                    return;
                }
                dg.a(new Jg("bindService returned false for RuStore service: " + componentName, null, 2, null));
                return;
            } catch (Throwable th) {
                dg.a(new Jg("Failed to bind RuStore service", th));
                return;
            }
        }
        ServiceInfo serviceInfo = ((ResolveInfo) CollectionsKt.first((List<? extends Object>) queryIntentServices)).serviceInfo;
        componentName = new ComponentName(serviceInfo.packageName, serviceInfo.name);
        if (componentName != null) {
        }
    }
}
