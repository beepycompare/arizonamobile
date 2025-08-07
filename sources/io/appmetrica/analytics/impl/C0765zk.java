package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import io.appmetrica.analytics.coreapi.internal.data.TempCacheStorage;
import io.appmetrica.analytics.coreutils.internal.io.FileUtils;
import io.appmetrica.analytics.modulesapi.internal.common.ModulePreferences;
import io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider;
import java.io.File;
/* renamed from: io.appmetrica.analytics.impl.zk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0765zk implements ServiceStorageProvider {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1175a;
    public final InterfaceC0641ul b;
    public final SQLiteOpenHelper c;

    public C0765zk(Context context, InterfaceC0641ul interfaceC0641ul, SQLiteOpenHelper sQLiteOpenHelper) {
        this.f1175a = context;
        this.b = interfaceC0641ul;
        this.c = sQLiteOpenHelper;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getAppDataStorage() {
        return FileUtils.getAppDataDir(this.f1175a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getAppFileStorage() {
        return FileUtils.getAppStorageDirectory(this.f1175a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final SQLiteOpenHelper getDbStorage() {
        return this.c;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final File getSdkDataStorage() {
        return FileUtils.sdkStorage(this.f1175a);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final TempCacheStorage getTempCacheStorage() {
        C0544qn c0544qn;
        C0627u7 a2 = C0627u7.a(this.f1175a);
        synchronized (a2) {
            if (a2.o == null) {
                Context context = a2.e;
                Sm sm = Sm.SERVICE;
                if (a2.n == null) {
                    a2.n = new C0519pn(new C0542ql(a2.h()), "temp_cache");
                }
                a2.o = new C0544qn(context, sm, a2.n);
            }
            c0544qn = a2.o;
        }
        return c0544qn;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final ModulePreferences legacyModulePreferences() {
        return new Ub(this.b);
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.ServiceStorageProvider
    public final ModulePreferences modulePreferences(String str) {
        return new C0583sd(str, this.b);
    }
}
