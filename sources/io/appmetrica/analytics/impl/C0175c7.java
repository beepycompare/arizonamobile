package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.ArrayList;
import java.util.Iterator;
/* renamed from: io.appmetrica.analytics.impl.c7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0175c7 extends InterruptionSafeThread {

    /* renamed from: a  reason: collision with root package name */
    public final C0572s5 f781a;
    public final /* synthetic */ C0201d7 b;

    public C0175c7(C0201d7 c0201d7, C0572s5 c0572s5) {
        this.b = c0201d7;
        this.f781a = c0572s5;
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
            ((InterfaceC0328i9) it2.next()).a(arrayList2);
        }
        ((D5) this.f781a.p).e();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        ArrayList arrayList;
        while (isRunning()) {
            try {
                synchronized (this) {
                    if (C0201d7.a(this.b)) {
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
            C0201d7 c0201d7 = this.b;
            c0201d7.getClass();
            if (!arrayList.isEmpty()) {
                c0201d7.b.lock();
                SQLiteDatabase sQLiteDatabase = null;
                try {
                    SQLiteDatabase writableDatabase = c0201d7.c.getWritableDatabase();
                    if (writableDatabase != null) {
                        try {
                            writableDatabase.beginTransaction();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                ContentValues contentValues = (ContentValues) it.next();
                                writableDatabase.insertOrThrow("events", null, contentValues);
                                c0201d7.i.incrementAndGet();
                                c0201d7.a(contentValues, "Event saved to db");
                            }
                            writableDatabase.setTransactionSuccessful();
                            c0201d7.i.get();
                        } catch (Throwable unused2) {
                            sQLiteDatabase = writableDatabase;
                            if (sQLiteDatabase != null) {
                                sQLiteDatabase.endTransaction();
                            }
                            c0201d7.b.unlock();
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
                c0201d7.b.unlock();
            }
            a(arrayList);
        }
    }
}
