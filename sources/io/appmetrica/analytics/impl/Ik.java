package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider;
import java.io.File;
/* loaded from: classes4.dex */
public final class Ik implements ServiceStorageProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Context f503a;
    public final Dl b;
    public final SQLiteOpenHelper c;

    public Ik(Context context, Dl dl, SQLiteOpenHelper sQLiteOpenHelper) {
        this.f503a = context;
        this.b = dl;
        this.c = sQLiteOpenHelper;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getAppDataStorage() {
        return FileUtils.getAppDataDir(this.f503a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getAppFileStorage() {
        return FileUtils.getAppStorageDirectory(this.f503a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final SQLiteOpenHelper getDbStorage() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getSdkDataStorage() {
        return FileUtils.sdkStorage(this.f503a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final TempCacheStorage getTempCacheStorage() {
        C0769zn c0769zn;
        C0728y7 a2 = C0728y7.a(this.f503a);
        synchronized (a2) {
            if (a2.o == null) {
                Context context = a2.e;
                EnumC0158bn enumC0158bn = EnumC0158bn.SERVICE;
                if (a2.n == null) {
                    a2.n = new C0744yn(new C0767zl(a2.h()), "temp_cache");
                }
                a2.o = new C0769zn(context, enumC0158bn, a2.n);
            }
            c0769zn = a2.o;
        }
        return c0769zn;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final ModulePreferences legacyModulePreferences() {
        return new Zb(this.b);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new C0709xd(str, this.b);
    }
}
