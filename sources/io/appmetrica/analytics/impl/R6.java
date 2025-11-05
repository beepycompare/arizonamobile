package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes3.dex */
public final class R6 extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final C0210e5 f661a;
    public final /* synthetic */ S6 b;

    public R6(S6 s6, C0210e5 c0210e5) {
        this.b = s6;
        this.f661a = c0210e5;
    }

    public final synchronized void a(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.b.getClass();
            arrayList2.add(Integer.valueOf(((ContentValues) it.next()).getAsInteger("type").intValue()));
        }
        Iterator it2 = this.b.j.iterator();
        while (it2.hasNext()) {
            ((X8) it2.next()).a(arrayList2);
        }
        ((C0540r5) this.f661a.p).e();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        while (isRunning()) {
            try {
                synchronized (this) {
                    if (S6.a(this.b)) {
                        wait();
                    }
                }
            } catch (Throwable unused) {
                stopRunning();
            }
            synchronized (this.b.e) {
                arrayList = new ArrayList(this.b.f);
                this.b.f.clear();
            }
            S6 s6 = this.b;
            s6.getClass();
            if (!arrayList.isEmpty()) {
                s6.b.lock();
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase writableDatabase = s6.c.getWritableDatabase();
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.beginTransaction();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ContentValues contentValues = (ContentValues) it.next();
                                writableDatabase.insertOrThrow("events", null, contentValues);
                                s6.i.incrementAndGet();
                                s6.a(contentValues, "Event saved to db");
                            }
                            writableDatabase.setTransactionSuccessful();
                            s6.i.get();
                        } catch (Throwable unused2) {
                            sQLiteDatabase = writableDatabase;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            s6.b.unlock();
                            a(arrayList);
                        }
                    }
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.endTransaction();
                        } catch (Throwable unused3) {
                        }
                    }
                } catch (Throwable unused4) {
                }
                s6.b.unlock();
            }
            a(arrayList);
        }
    }
}
