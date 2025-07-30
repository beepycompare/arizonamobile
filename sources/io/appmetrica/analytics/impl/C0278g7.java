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
/* renamed from: io.appmetrica.analytics.impl.g7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0278g7 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantReadWriteLock.ReadLock f862a;
    public final ReentrantReadWriteLock.WriteLock b;
    public final C0601t7 c;
    public final C0252f7 d;
    public final Object e;
    public final ArrayList f;
    public final Context g;
    public final C0574s5 h;
    public final AtomicLong i;
    public final ArrayList j;
    public final C0175c7 k;
    public final B7 l;

    static {
        HashSet hashSet = new HashSet();
        EnumC0680wb enumC0680wb = EnumC0680wb.EVENT_TYPE_UNDEFINED;
        hashSet.add(0);
        hashSet.add(6400);
    }

    public C0278g7(C0574s5 c0574s5, C0601t7 c0601t7, C0175c7 c0175c7, B7 b7) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f862a = reentrantReadWriteLock.readLock();
        this.b = reentrantReadWriteLock.writeLock();
        this.e = new Object();
        this.f = new ArrayList(3);
        AtomicLong atomicLong = new AtomicLong();
        this.i = atomicLong;
        this.j = new ArrayList();
        this.c = c0601t7;
        this.g = c0574s5.getContext();
        this.h = c0574s5;
        this.k = c0175c7;
        this.l = b7;
        atomicLong.set(c());
        C0252f7 c0252f7 = new C0252f7(this, c0574s5);
        this.d = c0252f7;
        c0252f7.setName(a(c0574s5));
    }

    public final long a(Set set) {
        this.f862a.lock();
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
        io.a(cursor);
        this.f862a.unlock();
        return j;
    }

    public final long b() {
        this.f862a.lock();
        try {
            return this.i.get();
        } finally {
            this.f862a.unlock();
        }
    }

    public final long c() {
        long j;
        SQLiteDatabase readableDatabase;
        this.f862a.lock();
        try {
            readableDatabase = this.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            j = DBUtils.queryRowsCount(readableDatabase, "events");
            this.f862a.unlock();
            return j;
        }
        j = 0;
        this.f862a.unlock();
        return j;
    }

    public final void d() {
        Cursor cursor;
        Cursor cursor2;
        this.f862a.lock();
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
                    this.f862a.unlock();
                    io.a(cursor2);
                    io.a(cursor3);
                }
            } else {
                cursor2 = null;
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        this.f862a.unlock();
        io.a(cursor2);
        io.a(cursor3);
    }

    public final void e() {
        this.d.start();
    }

    public final void a(InterfaceC0404l9 interfaceC0404l9) {
        this.j.add(interfaceC0404l9);
    }

    public static String a(Za za) {
        return "DatabaseWorker [" + za.b().e() + "]";
    }

    public final void a(long j, Wk wk, long j2) {
        JSONObject jSONObject;
        boolean b;
        P7 p7 = new P7(null, 1, null);
        C0711xh c0711xh = (C0711xh) this.h.k.a();
        Long valueOf = Long.valueOf(j);
        Long valueOf2 = Long.valueOf(j2);
        try {
            jSONObject = new JSONObject().put("dId", c0711xh.getDeviceId()).put("uId", c0711xh.getUuid()).put("appVer", c0711xh.getAppVersion()).put(RemoteConfigConstants.RequestFieldKey.APP_BUILD, c0711xh.getAppBuildNumber()).put("kitBuildType", c0711xh.getAnalyticsSdkBuildType()).put("osVer", c0711xh.getOsVersion()).put("osApiLev", c0711xh.getOsApiLevel()).put("lang", c0711xh.getLocale()).put("root", c0711xh.getDeviceRootStatus()).put("app_debuggable", ((C0351j6) c0711xh).f915a).put(CommonUrlParts.APP_FRAMEWORK, c0711xh.getAppFramework()).put("attribution_id", c0711xh.r).put("analyticsSdkVersionName", c0711xh.getAnalyticsSdkVersionName()).put("kitBuildNumber", c0711xh.getAnalyticsSdkBuildNumber());
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        Long valueOf3 = Long.valueOf(Fn.a());
        C0316hk c0316hk = AbstractC0291gk.f870a;
        synchronized (c0316hk) {
            b = c0316hk.b.b(true);
        }
        ContentValues fromModel = p7.fromModel(new O7(valueOf, wk, jSONObject2, new N7(valueOf2, valueOf3, Boolean.valueOf(b))));
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
            if (this.i.get() > ((C0711xh) this.h.k.a()).v && (writableDatabase = this.c.getWritableDatabase()) != null) {
                int a2 = a(writableDatabase);
                this.i.addAndGet(-a2);
                if (a2 != 0) {
                    Iterator it = this.j.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC0404l9) it.next()).a();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.b.unlock();
    }

    public final int a(SQLiteDatabase sQLiteDatabase) {
        try {
            return this.k.a(sQLiteDatabase, String.format("id IN (SELECT id FROM events ORDER BY CASE WHEN type IN (%1$s) THEN 2 WHEN type IN (%2$s) THEN 1 ELSE 0 END, id LIMIT (SELECT count() FROM events) / %3$s)", TextUtils.join(", ", R9.i), TextUtils.join(", ", R9.j), 10), 2, this.h.b.b, true).b;
        } catch (Throwable th) {
            C0188ck c0188ck = Bj.f362a;
            c0188ck.getClass();
            c0188ck.a(new Cj("deleteExcessiveReports exception", th));
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
                C0123a7 a2 = this.k.a(writableDatabase, format, 1, this.h.b.b, z);
                if (a2.f764a != null) {
                    ArrayList arrayList = new ArrayList();
                    for (ContentValues contentValues : a2.f764a) {
                        arrayList.add(Integer.valueOf(contentValues.getAsInteger("type").intValue()));
                    }
                    Iterator it = this.j.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC0404l9) it.next()).b(arrayList);
                    }
                }
                List list = a2.f764a;
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

    public final ContentValues a(long j, Wk wk) {
        ContentValues contentValues = new ContentValues();
        this.f862a.lock();
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(String.format(Locale.US, "SELECT report_request_parameters FROM sessions WHERE id = %s AND type = %s ORDER BY id DESC LIMIT 1", Long.valueOf(j), Integer.valueOf(wk.f707a)), null);
                if (cursor.moveToNext()) {
                    ContentValues contentValues2 = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursor, contentValues2);
                    contentValues = contentValues2;
                }
            }
        } catch (Throwable unused) {
        }
        io.a(cursor);
        this.f862a.unlock();
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
        if (R9.d.contains(EnumC0680wb.a(asInteger != null ? asInteger.intValue() : -1))) {
            A7 model = new B7(null, 1, null).toModel(contentValues);
            PublicLogger publicLogger = this.h.m;
            EnumC0680wb enumC0680wb = model.d;
            C0751z7 c0751z7 = model.g;
            publicLogger.info(AbstractC0210dg.a(str, enumC0680wb, c0751z7.b, c0751z7.c), new Object[0]);
        }
    }

    public static boolean a(C0278g7 c0278g7) {
        boolean isEmpty;
        synchronized (c0278g7.e) {
            isEmpty = c0278g7.f.isEmpty();
        }
        return isEmpty;
    }
}
