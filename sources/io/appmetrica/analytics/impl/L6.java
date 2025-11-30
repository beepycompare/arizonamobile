package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class L6 extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final Y4 f566a;
    public final /* synthetic */ M6 b;

    public L6(M6 m6, Y4 y4) {
        this.b = m6;
        this.f566a = y4;
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
            ((T8) it2.next()).a(arrayList2);
        }
        ((C0391l5) this.f566a.p).e();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        while (isRunning()) {
            try {
                synchronized (this) {
                    if (M6.a(this.b)) {
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
            M6 m6 = this.b;
            m6.getClass();
            if (!arrayList.isEmpty()) {
                m6.b.lock();
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase writableDatabase = m6.c.getWritableDatabase();
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.beginTransaction();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ContentValues contentValues = (ContentValues) it.next();
                                writableDatabase.insertOrThrow("events", null, contentValues);
                                m6.i.incrementAndGet();
                                m6.a(contentValues, "Event saved to db");
                            }
                            writableDatabase.setTransactionSuccessful();
                            m6.i.get();
                        } catch (Throwable unused2) {
                            sQLiteDatabase = writableDatabase;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            m6.b.unlock();
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
                m6.b.unlock();
            }
            a(arrayList);
        }
    }
}
