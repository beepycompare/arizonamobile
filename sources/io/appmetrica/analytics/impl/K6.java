package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class K6 extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final X4 f659a;
    public final /* synthetic */ L6 b;

    public K6(L6 l6, X4 x4) {
        this.b = l6;
        this.f659a = x4;
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
            ((S8) it2.next()).a(arrayList2);
        }
        ((C0368k5) this.f659a.p).e();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        int i;
        while (isRunning()) {
            try {
                synchronized (this) {
                    if (L6.a(this.b)) {
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
            L6 l6 = this.b;
            l6.getClass();
            if (!arrayList.isEmpty()) {
                long j = ((C0380kh) l6.h.k.a()).v;
                l6.b.lock();
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase writableDatabase = l6.c.getWritableDatabase();
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.beginTransaction();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ContentValues contentValues = (ContentValues) it.next();
                                writableDatabase.insertOrThrow("events", null, contentValues);
                                l6.i.incrementAndGet();
                                l6.a(contentValues, "Event saved to db");
                            }
                            if (l6.i.get() > j) {
                                i = l6.a(writableDatabase);
                                l6.i.addAndGet(-i);
                            } else {
                                i = 0;
                            }
                            writableDatabase.setTransactionSuccessful();
                            if (i != 0) {
                                Iterator it2 = l6.j.iterator();
                                while (it2.hasNext()) {
                                    ((S8) it2.next()).a();
                                }
                            }
                        } catch (Throwable unused2) {
                            sQLiteDatabase = writableDatabase;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            l6.b.unlock();
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
                l6.b.unlock();
            }
            a(arrayList);
        }
    }
}
