package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.x7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0704x7 extends SQLiteOpenHelper implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final String f1152a;
    public final PublicLogger b;
    public final C0546qn c;

    public C0704x7(Context context, String str, C0546qn c0546qn, PublicLogger publicLogger) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, V5.b);
        this.c = c0546qn;
        this.f1152a = str;
        this.b = publicLogger;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get readable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.f1152a);
            C0414lk c0414lk = Kj.f543a;
            c0414lk.getClass();
            c0414lk.a(new Lj("db_read_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get writable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.f1152a);
            C0414lk c0414lk = Kj.f543a;
            c0414lk.getClass();
            c0414lk.a(new Lj("db_write_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            this.c.f1057a.runScript(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0546qn c0546qn = this.c;
        if (i > i2) {
            try {
                c0546qn.b.runScript(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            try {
                c0546qn.f1057a.runScript(sQLiteDatabase);
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        c0546qn.getClass();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        C0546qn c0546qn = this.c;
        c0546qn.getClass();
        try {
            C0570rn c0570rn = c0546qn.d;
            if (c0570rn == null || c0570rn.a(sQLiteDatabase)) {
                return;
            }
            try {
                c0546qn.b.runScript(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            c0546qn.f1057a.runScript(sQLiteDatabase);
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
        C0546qn c0546qn = this.c;
        c0546qn.getClass();
        if (i2 > i) {
            for (int i3 = i + 1; i3 <= i2; i3++) {
                try {
                    Collection<DatabaseScript> collection = (Collection) c0546qn.c.f624a.get(Integer.valueOf(i3));
                    if (collection != null) {
                        for (DatabaseScript databaseScript : collection) {
                            databaseScript.runScript(sQLiteDatabase);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            z = false;
            if (!z && !(!c0546qn.d.a(sQLiteDatabase))) {
                try {
                    c0546qn.b.runScript(sQLiteDatabase);
                } catch (Throwable unused2) {
                }
                try {
                    c0546qn.f1057a.runScript(sQLiteDatabase);
                    return;
                } catch (Throwable unused3) {
                    return;
                }
            }
            return;
        }
        z = true;
        if (!(z | (c0546qn.d.a(sQLiteDatabase) ^ true))) {
        }
    }
}
