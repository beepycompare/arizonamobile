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
/* loaded from: classes3.dex */
public final class S6 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantReadWriteLock.ReadLock f678a;
    public final ReentrantReadWriteLock.WriteLock b;
    public final C0238f7 c;
    public final R6 d;
    public final Object e;
    public final ArrayList f;
    public final Context g;
    public final C0210e5 h;
    public final AtomicLong i;
    public final ArrayList j;
    public final O6 k;
    public final C0443n7 l;

    static {
        HashSet hashSet = new HashSet();
        EnumC0320ib enumC0320ib = EnumC0320ib.EVENT_TYPE_UNDEFINED;
        hashSet.add(0);
        hashSet.add(6400);
    }

    public S6(C0210e5 c0210e5, C0238f7 c0238f7, O6 o6, C0443n7 c0443n7) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f678a = reentrantReadWriteLock.readLock();
        this.b = reentrantReadWriteLock.writeLock();
        this.e = new Object();
        this.f = new ArrayList(3);
        AtomicLong atomicLong = new AtomicLong();
        this.i = atomicLong;
        this.j = new ArrayList();
        this.c = c0238f7;
        this.g = c0210e5.getContext();
        this.h = c0210e5;
        this.k = o6;
        this.l = c0443n7;
        atomicLong.set(c());
        R6 r6 = new R6(this, c0210e5);
        this.d = r6;
        r6.setName(a(c0210e5));
    }

    public final long a(Set set) {
        this.f678a.lock();
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
        no.a(cursor);
        this.f678a.unlock();
        return j;
    }

    public final long b() {
        this.f678a.lock();
        try {
            return this.i.get();
        } finally {
            this.f678a.unlock();
        }
    }

    public final long c() {
        long j;
        SQLiteDatabase readableDatabase;
        this.f678a.lock();
        try {
            readableDatabase = this.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            j = DBUtils.queryRowsCount(readableDatabase, "events");
            this.f678a.unlock();
            return j;
        }
        j = 0;
        this.f678a.unlock();
        return j;
    }

    public final void d() {
        Cursor cursor;
        Cursor cursor2;
        this.f678a.lock();
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
                    this.f678a.unlock();
                    no.a(cursor2);
                    no.a(cursor3);
                }
            } else {
                cursor2 = null;
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        this.f678a.unlock();
        no.a(cursor2);
        no.a(cursor3);
    }

    public final void e() {
        this.d.start();
    }

    public final void a(X8 x8) {
        this.j.add(x8);
    }

    public static String a(La la) {
        return "DatabaseWorker [" + la.b().e() + "]";
    }

    public final void a(long j, EnumC0123al enumC0123al, long j2) {
        JSONObject jSONObject;
        boolean b;
        B7 b7 = new B7(null, 1, null);
        C0503ph c0503ph = (C0503ph) this.h.k.a();
        Long valueOf = Long.valueOf(j);
        Long valueOf2 = Long.valueOf(j2);
        try {
            jSONObject = new JSONObject().put("dId", c0503ph.getDeviceId()).put("uId", c0503ph.getUuid()).put("appVer", c0503ph.getAppVersion()).put(RemoteConfigConstants.RequestFieldKey.APP_BUILD, c0503ph.getAppBuildNumber()).put("kitBuildType", c0503ph.getAnalyticsSdkBuildType()).put("osVer", c0503ph.getOsVersion()).put("osApiLev", c0503ph.getOsApiLevel()).put("lang", c0503ph.getLocale()).put("root", c0503ph.getDeviceRootStatus()).put("app_debuggable", ((U5) c0503ph).f717a).put(CommonUrlParts.APP_FRAMEWORK, c0503ph.getAppFramework()).put("attribution_id", c0503ph.r).put("analyticsSdkVersionName", c0503ph.getAnalyticsSdkVersionName()).put("kitBuildNumber", c0503ph.getAnalyticsSdkBuildNumber());
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        Long valueOf3 = Long.valueOf(Kn.a());
        C0174ck c0174ck = AbstractC0148bk.f818a;
        synchronized (c0174ck) {
            b = c0174ck.b.b(true);
        }
        ContentValues fromModel = b7.fromModel(new A7(valueOf, enumC0123al, jSONObject2, new C0742z7(valueOf2, valueOf3, Boolean.valueOf(b))));
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

    public final void a() {
        SQLiteDatabase writableDatabase;
        try {
            this.b.lock();
            if (this.i.get() > ((C0503ph) this.h.k.a()).v && (writableDatabase = this.c.getWritableDatabase()) != null) {
                int a2 = a(writableDatabase);
                this.i.addAndGet(-a2);
                if (a2 != 0) {
                    Iterator it = this.j.iterator();
                    while (it.hasNext()) {
                        ((X8) it.next()).a();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.b.unlock();
    }

    public final int a(SQLiteDatabase sQLiteDatabase) {
        try {
            return this.k.a(sQLiteDatabase, String.format("id IN (SELECT id FROM events ORDER BY CASE WHEN type IN (%1$s) THEN 2 WHEN type IN (%2$s) THEN 1 ELSE 0 END, id LIMIT (SELECT count() FROM events) / %3$s)", TextUtils.join(", ", D9.i), TextUtils.join(", ", D9.j), 10), 2, this.h.b.b, true).b;
        } catch (Throwable th) {
            Vj vj = AbstractC0604tj.f1136a;
            vj.getClass();
            vj.a(new C0629uj("deleteExcessiveReports exception", th));
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
                M6 a2 = this.k.a(writableDatabase, format, 1, this.h.b.b, z);
                if (a2.f586a != null) {
                    ArrayList arrayList = new ArrayList();
                    for (ContentValues contentValues : a2.f586a) {
                        arrayList.add(Integer.valueOf(contentValues.getAsInteger("type").intValue()));
                    }
                    Iterator it = this.j.iterator();
                    while (it.hasNext()) {
                        ((X8) it.next()).b(arrayList);
                    }
                }
                List list = a2.f586a;
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

    public final ContentValues a(long j, EnumC0123al enumC0123al) {
        ContentValues contentValues = new ContentValues();
        this.f678a.lock();
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(String.format(Locale.US, "SELECT report_request_parameters FROM sessions WHERE id = %s AND type = %s ORDER BY id DESC LIMIT 1", Long.valueOf(j), Integer.valueOf(enumC0123al.f805a)), null);
                if (cursor.moveToNext()) {
                    ContentValues contentValues2 = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursor, contentValues2);
                    contentValues = contentValues2;
                }
            }
        } catch (Throwable unused) {
        }
        no.a(cursor);
        this.f678a.unlock();
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
        if (D9.d.contains(EnumC0320ib.a(asInteger != null ? asInteger.intValue() : -1))) {
            C0418m7 model = new C0443n7(null, 1, null).toModel(contentValues);
            PublicLogger publicLogger = this.h.m;
            EnumC0320ib enumC0320ib = model.d;
            C0393l7 c0393l7 = model.g;
            publicLogger.info(Vf.a(str, enumC0320ib, c0393l7.b, c0393l7.c), new Object[0]);
        }
    }

    public static boolean a(S6 s6) {
        boolean isEmpty;
        synchronized (s6.e) {
            isEmpty = s6.f.isEmpty();
        }
        return isEmpty;
    }
}
