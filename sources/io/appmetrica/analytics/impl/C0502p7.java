package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
import java.util.Collection;
/* renamed from: io.appmetrica.analytics.impl.p7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0502p7 extends SQLiteOpenHelper implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final String f1146a;
    public final PublicLogger b;
    public final Jn c;

    public C0502p7(Context context, String str, Jn jn, PublicLogger publicLogger) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, M5.b);
        this.c = jn;
        this.f1146a = str;
        this.b = publicLogger;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get readable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.f1146a);
            C0541qk c0541qk = Oj.f708a;
            c0541qk.getClass();
            c0541qk.a(new Pj("db_read_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get writable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.f1146a);
            C0541qk c0541qk = Oj.f708a;
            c0541qk.getClass();
            c0541qk.a(new Pj("db_write_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            this.c.f621a.runScript(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        Jn jn = this.c;
        if (i > i2) {
            try {
                jn.b.runScript(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            try {
                jn.f621a.runScript(sQLiteDatabase);
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        jn.getClass();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        Jn jn = this.c;
        jn.getClass();
        try {
            Kn kn = jn.d;
            if (kn == null || kn.a(sQLiteDatabase)) {
                return;
            }
            try {
                jn.b.runScript(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            jn.f621a.runScript(sQLiteDatabase);
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
        Jn jn = this.c;
        jn.getClass();
        if (i2 > i) {
            for (int i3 = i + 1; i3 <= i2; i3++) {
                try {
                    Collection<DatabaseScript> collection = (Collection) jn.c.f765a.get(Integer.valueOf(i3));
                    if (collection != null) {
                        for (DatabaseScript databaseScript : collection) {
                            databaseScript.runScript(sQLiteDatabase);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            z = false;
            if (!z && !(!jn.d.a(sQLiteDatabase))) {
                try {
                    jn.b.runScript(sQLiteDatabase);
                } catch (Throwable unused2) {
                }
                try {
                    jn.f621a.runScript(sQLiteDatabase);
                    return;
                } catch (Throwable unused3) {
                    return;
                }
            }
            return;
        }
        z = true;
        if (!(z | (jn.d.a(sQLiteDatabase) ^ true))) {
        }
    }
}
