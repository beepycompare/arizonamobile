package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.StringCompanionObject;
/* loaded from: classes5.dex */
public final class X8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0502p7 f838a;
    public final C0448n5 b;
    public final AtomicLong c;
    public final List d;
    public final Z6 e;
    public final ReentrantReadWriteLock.WriteLock f;

    public X8(C0502p7 c0502p7, C0448n5 c0448n5, AtomicLong atomicLong, ArrayList arrayList, Z6 z6, ReentrantReadWriteLock reentrantReadWriteLock) {
        this.f838a = c0502p7;
        this.b = c0448n5;
        this.c = atomicLong;
        this.d = arrayList;
        this.e = z6;
        this.f = reentrantReadWriteLock.writeLock();
    }

    public final int a(SQLiteDatabase sQLiteDatabase) {
        try {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            return this.e.a(sQLiteDatabase, String.format("id IN (SELECT id FROM events ORDER BY CASE WHEN type IN (%1$s) THEN 2 WHEN type IN (%2$s) THEN 1 ELSE 0 END, id LIMIT (SELECT count() FROM events) / %3$s)", Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(Q9.i, ", ", null, null, 0, null, null, 62, null), CollectionsKt.joinToString$default(Q9.j, ", ", null, null, 0, null, null, 62, null), 10}, 3)), null, 2, this.b.b.b, true).b;
        } catch (Throwable th) {
            C0541qk c0541qk = Oj.f706a;
            c0541qk.getClass();
            c0541qk.a(new Pj("deleteExcessiveReports exception", th));
            return 0;
        }
    }

    public final void b(List list) {
        int i;
        if (list.isEmpty()) {
            return;
        }
        long j = ((Eh) this.b.k.a()).v;
        ReentrantReadWriteLock.WriteLock writeLock = this.f;
        writeLock.lock();
        SQLiteDatabase sQLiteDatabase = null;
        try {
            try {
                SQLiteDatabase writableDatabase = this.f838a.getWritableDatabase();
                if (writableDatabase != null) {
                    try {
                        writableDatabase.beginTransaction();
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ContentValues contentValues = (ContentValues) it.next();
                            writableDatabase.insertOrThrow("events", null, contentValues);
                            this.c.incrementAndGet();
                            a(contentValues);
                        }
                        if (this.c.get() > j) {
                            i = a(writableDatabase);
                            this.c.addAndGet(-i);
                        } else {
                            i = 0;
                        }
                        writableDatabase.setTransactionSuccessful();
                        if (i != 0) {
                            for (InterfaceC0426m9 interfaceC0426m9 : this.d) {
                                interfaceC0426m9.a();
                            }
                        }
                        Unit unit = Unit.INSTANCE;
                    } catch (Throwable unused) {
                        sQLiteDatabase = writableDatabase;
                        Unit unit2 = Unit.INSTANCE;
                        Oo.a(sQLiteDatabase);
                    }
                }
                Oo.a(writableDatabase);
            } finally {
                writeLock.unlock();
            }
        } catch (Throwable unused2) {
        }
    }

    public final void a(ContentValues contentValues) {
        Integer asInteger = contentValues.getAsInteger("type");
        if (Q9.d.contains(Db.a(asInteger != null ? asInteger.intValue() : -1))) {
            C0657v7 model = new C0683w7(null, 1, null).toModel(contentValues);
            PublicLogger publicLogger = this.b.m;
            Db db = model.d;
            C0631u7 c0631u7 = model.g;
            publicLogger.info(AbstractC0562rg.a("Event saved to db", db, c0631u7.b, c0631u7.c), new Object[0]);
        }
    }

    public final void a(List list) {
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Integer asInteger = ((ContentValues) it.next()).getAsInteger("type");
            arrayList.add(Integer.valueOf(asInteger != null ? asInteger.intValue() : -1));
        }
        for (InterfaceC0426m9 interfaceC0426m9 : this.d) {
            interfaceC0426m9.a(arrayList);
        }
        ((A5) this.b.p).e();
    }
}
