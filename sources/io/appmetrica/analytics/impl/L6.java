package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import io.appmetrica.analytics.coreutils.internal.db.DBUtils;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.networktasks.internal.CommonUrlParts;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class L6 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantReadWriteLock.ReadLock f672a;
    public final ReentrantReadWriteLock.WriteLock b;
    public final Y6 c;
    public final K6 d;
    public final Object e;
    public final ArrayList f;
    public final Context g;
    public final X4 h;
    public final AtomicLong i;
    public final ArrayList j;
    public final H6 k;
    public final C0242f7 l;

    static {
        HashSet hashSet = new HashSet();
        EnumC0143bb enumC0143bb = EnumC0143bb.EVENT_TYPE_UNDEFINED;
        hashSet.add(0);
        hashSet.add(6400);
    }

    public L6(X4 x4, Y6 y6, H6 h6, C0242f7 c0242f7) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f672a = reentrantReadWriteLock.readLock();
        this.b = reentrantReadWriteLock.writeLock();
        this.e = new Object();
        this.f = new ArrayList(3);
        AtomicLong atomicLong = new AtomicLong();
        this.i = atomicLong;
        this.j = new ArrayList();
        this.c = y6;
        this.g = x4.getContext();
        this.h = x4;
        this.k = h6;
        this.l = c0242f7;
        atomicLong.set(b());
        K6 k6 = new K6(this, x4);
        this.d = k6;
        k6.setName(a(x4));
    }

    public final long a() {
        this.f672a.lock();
        try {
            return this.i.get();
        } finally {
            this.f672a.unlock();
        }
    }

    public final long b() {
        long j;
        SQLiteDatabase readableDatabase;
        this.f672a.lock();
        try {
            readableDatabase = this.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            j = DBUtils.queryRowsCount(readableDatabase, "events");
            this.f672a.unlock();
            return j;
        }
        j = 0;
        this.f672a.unlock();
        return j;
    }

    public final void c() {
        Cursor cursor;
        Cursor cursor2;
        this.f672a.lock();
        Cursor cursor3 = null;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor2 = readableDatabase.rawQuery(" SELECT DISTINCT id From sessions order by id asc ", new String[0]);
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("All sessions in db: ");
                    while (cursor2.moveToNext()) {
                        stringBuffer.append(cursor2.getString(0)).append(", ");
                    }
                    cursor3 = readableDatabase.rawQuery(" SELECT DISTINCT session_id From events order by session_id asc ", new String[0]);
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("All sessions in reports db: ");
                    while (cursor3.moveToNext()) {
                        stringBuffer2.append(cursor3.getString(0)).append(", ");
                    }
                } catch (Throwable unused) {
                    cursor = cursor3;
                    cursor3 = cursor2;
                    cursor2 = cursor3;
                    cursor3 = cursor;
                    this.f672a.unlock();
                    lo.a(cursor2);
                    lo.a(cursor3);
                }
            } else {
                cursor2 = null;
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        this.f672a.unlock();
        lo.a(cursor2);
        lo.a(cursor3);
    }

    public final void d() {
        this.d.start();
    }

    public final long a(Set set) {
        this.f672a.lock();
        Cursor cursor = null;
        long j = 0;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                StringBuilder sb = new StringBuilder("SELECT count() FROM events");
                if (!set.isEmpty()) {
                    sb.append(" WHERE ");
                }
                Iterator it = set.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    if (i > 0) {
                        sb.append(" OR ");
                    }
                    sb.append("type == " + num);
                    i++;
                }
                cursor = readableDatabase.rawQuery(sb.toString(), null);
                if (cursor.moveToFirst()) {
                    j = cursor.getLong(0);
                }
            }
        } catch (Throwable unused) {
        }
        lo.a(cursor);
        this.f672a.unlock();
        return j;
    }

    public final void a(S8 s8) {
        this.j.add(s8);
    }

    public static String a(Ea ea) {
        return "DatabaseWorker [" + ea.b().e() + "]";
    }

    public final void a(long j, Vk vk, long j2) {
        JSONObject jSONObject;
        boolean b;
        C0595t7 c0595t7 = new C0595t7(null, 1, null);
        C0381kh c0381kh = (C0381kh) this.h.k.a();
        Long valueOf = Long.valueOf(j);
        Long valueOf2 = Long.valueOf(j2);
        try {
            jSONObject = new JSONObject().put("dId", c0381kh.getDeviceId()).put("uId", c0381kh.getUuid()).put("appVer", c0381kh.getAppVersion()).put(RemoteConfigConstants.RequestFieldKey.APP_BUILD, c0381kh.getAppBuildNumber()).put("kitBuildType", c0381kh.getAnalyticsSdkBuildType()).put("osVer", c0381kh.getOsVersion()).put("osApiLev", c0381kh.getOsApiLevel()).put("lang", c0381kh.getLocale()).put("root", c0381kh.getDeviceRootStatus()).put("app_debuggable", ((N5) c0381kh).f705a).put(CommonUrlParts.APP_FRAMEWORK, c0381kh.getAppFramework()).put("attribution_id", c0381kh.r).put("analyticsSdkVersionName", c0381kh.getAnalyticsSdkVersionName()).put("kitBuildNumber", c0381kh.getAnalyticsSdkBuildNumber());
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        Long valueOf3 = Long.valueOf(In.a());
        Xj xj = Wj.f841a;
        synchronized (xj) {
            b = xj.b.b(true);
        }
        ContentValues fromModel = c0595t7.fromModel(new C0570s7(valueOf, vk, jSONObject2, new C0545r7(valueOf2, valueOf3, Boolean.valueOf(b))));
        if (fromModel == null) {
            return;
        }
        this.b.lock();
        try {
            SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.insertOrThrow("sessions", null, fromModel);
            }
        } catch (Throwable unused2) {
        }
        this.b.unlock();
    }

    public final void a(ContentValues contentValues) {
        synchronized (this.e) {
            this.f.add(contentValues);
        }
        synchronized (this.d) {
            this.d.notifyAll();
        }
    }

    public final int a(SQLiteDatabase sQLiteDatabase) {
        try {
            return this.k.a(sQLiteDatabase, String.format("id IN (SELECT id FROM events ORDER BY CASE WHEN type IN (%1$s) THEN 2 WHEN type IN (%2$s) THEN 1 ELSE 0 END, id LIMIT (SELECT count() FROM events) / %3$s)", TextUtils.join(", ", AbstractC0672w9.i), TextUtils.join(", ", AbstractC0672w9.j), 10), 2, this.h.b.b, true).b;
        } catch (Throwable th) {
            Qj qj = AbstractC0483oj.f1158a;
            qj.getClass();
            qj.a(new C0508pj("deleteExcessiveReports exception", th));
            return 0;
        }
    }

    public final void a(long j, int i, int i2, boolean z) {
        if (i2 <= 0) {
            return;
        }
        this.b.lock();
        try {
            String format = String.format(Locale.US, "%1$s = %2$s AND %3$s = %4$s AND %5$s <= (SELECT %5$s FROM %6$s WHERE %1$s = %2$s AND %3$s = %4$s ORDER BY %5$s ASC LIMIT %7$s, 1)", "session_id", Long.toString(j), "session_type", Integer.toString(i), "id", "events", Integer.toString(i2 - 1));
            SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            if (writableDatabase != null) {
                F6 a2 = this.k.a(writableDatabase, format, 1, this.h.b.b, z);
                if (a2.f578a != null) {
                    ArrayList arrayList = new ArrayList();
                    for (ContentValues contentValues : a2.f578a) {
                        arrayList.add(Integer.valueOf(contentValues.getAsInteger("type").intValue()));
                    }
                    Iterator it = this.j.iterator();
                    while (it.hasNext()) {
                        ((S8) it.next()).b(arrayList);
                    }
                }
                List list = a2.f578a;
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        a((ContentValues) list.get(i3), "Event removed from db");
                    }
                }
                this.i.addAndGet(-a2.b);
            }
        } catch (Throwable unused) {
        }
        this.b.unlock();
    }

    public final ContentValues a(long j, Vk vk) {
        ContentValues contentValues = new ContentValues();
        this.f672a.lock();
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(String.format(Locale.US, "SELECT report_request_parameters FROM sessions WHERE id = %s AND type = %s ORDER BY id DESC LIMIT 1", Long.valueOf(j), Integer.valueOf(vk.f830a)), null);
                if (cursor.moveToNext()) {
                    ContentValues contentValues2 = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursor, contentValues2);
                    contentValues = contentValues2;
                }
            }
        } catch (Throwable unused) {
        }
        lo.a(cursor);
        this.f672a.unlock();
        return contentValues;
    }

    public static String a(LinkedHashMap linkedHashMap) {
        StringBuilder sb = new StringBuilder("id >= ?");
        for (String str : linkedHashMap.keySet()) {
            sb.append(sb.length() > 0 ? " AND " : "");
            sb.append(str + " = ? ");
        }
        if (TextUtils.isEmpty(sb.toString())) {
            return null;
        }
        return sb.toString();
    }

    public static String[] a(String[] strArr, LinkedHashMap linkedHashMap) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(strArr));
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            arrayList.add((String) entry.getValue());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public final void a(ContentValues contentValues, String str) {
        Integer asInteger = contentValues.getAsInteger("type");
        if (AbstractC0672w9.d.contains(EnumC0143bb.a(asInteger != null ? asInteger.intValue() : -1))) {
            C0216e7 model = new C0242f7(null, 1, null).toModel(contentValues);
            PublicLogger publicLogger = this.h.m;
            EnumC0143bb enumC0143bb = model.d;
            C0191d7 c0191d7 = model.g;
            publicLogger.info(Qf.a(str, enumC0143bb, c0191d7.b, c0191d7.c), new Object[0]);
        }
    }

    public static boolean a(L6 l6) {
        boolean isEmpty;
        synchronized (l6.e) {
            isEmpty = l6.f.isEmpty();
        }
        return isEmpty;
    }
}
