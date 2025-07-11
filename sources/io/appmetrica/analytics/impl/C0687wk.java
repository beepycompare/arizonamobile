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
public final class C0687wk implements ServiceStorageProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1111a;
    public final InterfaceC0563rl b;
    public final SQLiteOpenHelper c;

    public C0687wk(Context context, InterfaceC0563rl interfaceC0563rl, SQLiteOpenHelper sQLiteOpenHelper) {
        this.f1111a = context;
        this.b = interfaceC0563rl;
        this.c = sQLiteOpenHelper;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getAppDataStorage() {
        return FileUtils.getAppDataDir(this.f1111a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getAppFileStorage() {
        return FileUtils.getAppStorageDirectory(this.f1111a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final SQLiteOpenHelper getDbStorage() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getSdkDataStorage() {
        return FileUtils.sdkStorage(this.f1111a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final TempCacheStorage getTempCacheStorage() {
        C0466nn c0466nn;
        C0549r7 a2 = C0549r7.a(this.f1111a);
        synchronized (a2) {
            if (a2.o == null) {
                Context context = a2.e;
                Pm pm = Pm.SERVICE;
                if (a2.n == null) {
                    a2.n = new C0441mn(new C0464nl(a2.h()), "temp_cache");
                }
                a2.o = new C0466nn(context, pm, a2.n);
            }
            c0466nn = a2.o;
        }
        return c0466nn;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final ModulePreferences legacyModulePreferences() {
        return new Sb(this.b);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new C0531qd(str, this.b);
    }
}
