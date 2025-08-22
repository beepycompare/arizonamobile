package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider;
import java.io.File;
/* loaded from: classes4.dex */
public final class Ek implements ServiceStorageProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Context f418a;
    public final InterfaceC0763zl b;
    public final SQLiteOpenHelper c;

    public Ek(Context context, InterfaceC0763zl interfaceC0763zl, SQLiteOpenHelper sQLiteOpenHelper) {
        this.f418a = context;
        this.b = interfaceC0763zl;
        this.c = sQLiteOpenHelper;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getAppDataStorage() {
        return FileUtils.getAppDataDir(this.f418a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getAppFileStorage() {
        return FileUtils.getAppStorageDirectory(this.f418a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final SQLiteOpenHelper getDbStorage() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getSdkDataStorage() {
        return FileUtils.sdkStorage(this.f418a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final TempCacheStorage getTempCacheStorage() {
        C0665vn c0665vn;
        C0649v7 a2 = C0649v7.a(this.f418a);
        synchronized (a2) {
            if (a2.o == null) {
                Context context = a2.e;
                Xm xm = Xm.SERVICE;
                if (a2.n == null) {
                    a2.n = new C0640un(new C0663vl(a2.h()), "temp_cache");
                }
                a2.o = new C0665vn(context, xm, a2.n);
            }
            c0665vn = a2.o;
        }
        return c0665vn;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final ModulePreferences legacyModulePreferences() {
        return new Wb(this.b);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new C0630ud(str, this.b);
    }
}
