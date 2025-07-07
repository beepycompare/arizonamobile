package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.wk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0695wk implements ServiceStorageProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1110a;
    public final InterfaceC0571rl b;
    public final SQLiteOpenHelper c;

    public C0695wk(Context context, InterfaceC0571rl interfaceC0571rl, SQLiteOpenHelper sQLiteOpenHelper) {
        this.f1110a = context;
        this.b = interfaceC0571rl;
        this.c = sQLiteOpenHelper;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getAppDataStorage() {
        return FileUtils.getAppDataDir(this.f1110a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getAppFileStorage() {
        return FileUtils.getAppStorageDirectory(this.f1110a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final SQLiteOpenHelper getDbStorage() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getSdkDataStorage() {
        return FileUtils.sdkStorage(this.f1110a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final TempCacheStorage getTempCacheStorage() {
        C0474nn c0474nn;
        C0557r7 a2 = C0557r7.a(this.f1110a);
        synchronized (a2) {
            if (a2.o == null) {
                Context context = a2.e;
                Pm pm = Pm.SERVICE;
                if (a2.n == null) {
                    a2.n = new C0449mn(new C0472nl(a2.h()), "temp_cache");
                }
                a2.o = new C0474nn(context, pm, a2.n);
            }
            c0474nn = a2.o;
        }
        return c0474nn;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final ModulePreferences legacyModulePreferences() {
        return new Sb(this.b);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new C0539qd(str, this.b);
    }
}
