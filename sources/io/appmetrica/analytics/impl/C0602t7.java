package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.t7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0602t7 extends SQLiteOpenHelper implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final String f1061a;
    public final PublicLogger b;
    public final C0320hn c;

    public C0602t7(Context context, String str, C0320hn c0320hn, PublicLogger publicLogger) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, S5.b);
        this.c = c0320hn;
        this.f1061a = str;
        this.b = publicLogger;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get readable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.f1061a);
            C0189ck c0189ck = Bj.f361a;
            c0189ck.getClass();
            c0189ck.a(new Cj("db_read_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get writable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.f1061a);
            C0189ck c0189ck = Bj.f361a;
            c0189ck.getClass();
            c0189ck.a(new Cj("db_write_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            this.c.f891a.runScript(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0320hn c0320hn = this.c;
        if (i > i2) {
            try {
                c0320hn.b.runScript(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            try {
                c0320hn.f891a.runScript(sQLiteDatabase);
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        c0320hn.getClass();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        C0320hn c0320hn = this.c;
        c0320hn.getClass();
        try {
            C0344in c0344in = c0320hn.d;
            if (c0344in == null || c0344in.a(sQLiteDatabase)) {
                return;
            }
            try {
                c0320hn.b.runScript(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            c0320hn.f891a.runScript(sQLiteDatabase);
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
        C0320hn c0320hn = this.c;
        c0320hn.getClass();
        if (i2 > i) {
            for (int i3 = i + 1; i3 <= i2; i3++) {
                try {
                    Collection<DatabaseScript> collection = (Collection) c0320hn.c.f519a.get(Integer.valueOf(i3));
                    if (collection != null) {
                        for (DatabaseScript databaseScript : collection) {
                            databaseScript.runScript(sQLiteDatabase);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            z = false;
            if (!z && !(!c0320hn.d.a(sQLiteDatabase))) {
                try {
                    c0320hn.b.runScript(sQLiteDatabase);
                } catch (Throwable unused2) {
                }
                try {
                    c0320hn.f891a.runScript(sQLiteDatabase);
                    return;
                } catch (Throwable unused3) {
                    return;
                }
            }
            return;
        }
        z = true;
        if (!(z | (c0320hn.d.a(sQLiteDatabase) ^ true))) {
        }
    }
}
