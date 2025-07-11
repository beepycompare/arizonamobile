package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.q7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0525q7 extends SQLiteOpenHelper implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final String f1003a;
    public final PublicLogger b;
    public final C0242en c;

    public C0525q7(Context context, String str, C0242en c0242en, PublicLogger publicLogger) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, P5.b);
        this.c = c0242en;
        this.f1003a = str;
        this.b = publicLogger;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get readable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.f1003a);
            Zj zj = AbstractC0736yj.f1149a;
            zj.getClass();
            zj.a(new C0761zj("db_read_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get writable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.f1003a);
            Zj zj = AbstractC0736yj.f1149a;
            zj.getClass();
            zj.a(new C0761zj("db_write_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            this.c.f827a.runScript(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0242en c0242en = this.c;
        if (i > i2) {
            try {
                c0242en.b.runScript(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            try {
                c0242en.f827a.runScript(sQLiteDatabase);
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        c0242en.getClass();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        C0242en c0242en = this.c;
        c0242en.getClass();
        try {
            C0267fn c0267fn = c0242en.d;
            if (c0267fn == null || c0267fn.a(sQLiteDatabase)) {
                return;
            }
            try {
                c0242en.b.runScript(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            c0242en.f827a.runScript(sQLiteDatabase);
        } catch (Throwable unused2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // android.database.sqlite.SQLiteOpenHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        boolean z;
        C0242en c0242en = this.c;
        c0242en.getClass();
        if (i2 > i) {
            for (int i3 = i + 1; i3 <= i2; i3++) {
                try {
                    Collection<DatabaseScript> collection = (Collection) c0242en.c.f474a.get(Integer.valueOf(i3));
                    if (collection != null) {
                        for (DatabaseScript databaseScript : collection) {
                            databaseScript.runScript(sQLiteDatabase);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            z = false;
            if (!z && !(!c0242en.d.a(sQLiteDatabase))) {
                try {
                    c0242en.b.runScript(sQLiteDatabase);
                } catch (Throwable unused2) {
                }
                try {
                    c0242en.f827a.runScript(sQLiteDatabase);
                    return;
                } catch (Throwable unused3) {
                    return;
                }
            }
            return;
        }
        z = true;
        if (!(z | (c0242en.d.a(sQLiteDatabase) ^ true))) {
        }
    }
}
