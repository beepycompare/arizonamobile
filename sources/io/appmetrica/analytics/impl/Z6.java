package io.appmetrica.analytics.impl;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import io.appmetrica.analytics.coreapi.internal.db.DatabaseScript;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.io.Closeable;
import java.util.Collection;
/* loaded from: classes5.dex */
public final class Z6 extends SQLiteOpenHelper implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    public final String f871a;
    public final PublicLogger b;
    public final C0356jn c;

    public Z6(Context context, String str, C0356jn c0356jn, PublicLogger publicLogger) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, AbstractC0689x5.b);
        this.c = c0356jn;
        this.f871a = str;
        this.b = publicLogger;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getReadableDatabase() {
        try {
            return super.getReadableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get readable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.f871a);
            Rj rj = AbstractC0504pj.f1168a;
            rj.getClass();
            rj.a(new C0529qj("db_read_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final SQLiteDatabase getWritableDatabase() {
        try {
            return super.getWritableDatabase();
        } catch (Throwable th) {
            this.b.error(th, "Could not get writable database %s due to an exception. AppMetrica SDK may behave unexpectedly.", this.f871a);
            Rj rj = AbstractC0504pj.f1168a;
            rj.getClass();
            rj.a(new C0529qj("db_write_error", th));
            return null;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            this.c.f1059a.runScript(sQLiteDatabase);
        } catch (Throwable unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        C0356jn c0356jn = this.c;
        if (i > i2) {
            try {
                c0356jn.b.runScript(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            try {
                c0356jn.f1059a.runScript(sQLiteDatabase);
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        c0356jn.getClass();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
        C0356jn c0356jn = this.c;
        c0356jn.getClass();
        try {
            InterfaceC0382kn interfaceC0382kn = c0356jn.d;
            if (interfaceC0382kn == null || interfaceC0382kn.a(sQLiteDatabase)) {
                return;
            }
            try {
                c0356jn.b.runScript(sQLiteDatabase);
            } catch (Throwable unused) {
            }
            c0356jn.f1059a.runScript(sQLiteDatabase);
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
        C0356jn c0356jn = this.c;
        c0356jn.getClass();
        if (i2 > i) {
            for (int i3 = i + 1; i3 <= i2; i3++) {
                try {
                    Collection<DatabaseScript> collection = (Collection) c0356jn.c.f1182a.get(Integer.valueOf(i3));
                    if (collection != null) {
                        for (DatabaseScript databaseScript : collection) {
                            databaseScript.runScript(sQLiteDatabase);
                        }
                    }
                } catch (Throwable unused) {
                }
            }
            z = false;
            if (!z && !(!c0356jn.d.a(sQLiteDatabase))) {
                try {
                    c0356jn.b.runScript(sQLiteDatabase);
                } catch (Throwable unused2) {
                }
                try {
                    c0356jn.f1059a.runScript(sQLiteDatabase);
                    return;
                } catch (Throwable unused3) {
                    return;
                }
            }
            return;
        }
        z = true;
        if (!(z | (c0356jn.d.a(sQLiteDatabase) ^ true))) {
        }
    }
}
