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
/* renamed from: io.appmetrica.analytics.impl.h7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0297h7 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantReadWriteLock.ReadLock f883a;
    public final ReentrantReadWriteLock.WriteLock b;
    public final C0624u7 c;
    public final C0271g7 d;
    public final Object e;
    public final ArrayList f;
    public final Context g;
    public final C0572s5 h;
    public final AtomicLong i;
    public final ArrayList j;
    public final C0194d7 k;
    public final C7 l;

    static {
        HashSet hashSet = new HashSet();
        EnumC0728yb enumC0728yb = EnumC0728yb.EVENT_TYPE_UNDEFINED;
        hashSet.add(0);
        hashSet.add(6400);
    }

    public C0297h7(C0572s5 c0572s5, C0624u7 c0624u7, C0194d7 c0194d7, C7 c7) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f883a = reentrantReadWriteLock.readLock();
        this.b = reentrantReadWriteLock.writeLock();
        this.e = new Object();
        this.f = new ArrayList(3);
        AtomicLong atomicLong = new AtomicLong();
        this.i = atomicLong;
        this.j = new ArrayList();
        this.c = c0624u7;
        this.g = c0572s5.getContext();
        this.h = c0572s5;
        this.k = c0194d7;
        this.l = c7;
        atomicLong.set(c());
        C0271g7 c0271g7 = new C0271g7(this, c0572s5);
        this.d = c0271g7;
        c0271g7.setName(a(c0572s5));
    }

    public final long a(Set set) {
        this.f883a.lock();
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
        this.f883a.unlock();
        return j;
    }

    public final long b() {
        this.f883a.lock();
        try {
            return this.i.get();
        } finally {
            this.f883a.unlock();
        }
    }

    public final long c() {
        long j;
        SQLiteDatabase readableDatabase;
        this.f883a.lock();
        try {
            readableDatabase = this.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            j = DBUtils.queryRowsCount(readableDatabase, "events");
            this.f883a.unlock();
            return j;
        }
        j = 0;
        this.f883a.unlock();
        return j;
    }

    public final void d() {
        Cursor cursor;
        Cursor cursor2;
        this.f883a.lock();
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
                    this.f883a.unlock();
                    no.a(cursor2);
                    no.a(cursor3);
                }
            } else {
                cursor2 = null;
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        this.f883a.unlock();
        no.a(cursor2);
        no.a(cursor3);
    }

    public final void e() {
        this.d.start();
    }

    public final void a(InterfaceC0452n9 interfaceC0452n9) {
        this.j.add(interfaceC0452n9);
    }

    public static String a(InterfaceC0146bb interfaceC0146bb) {
        return "DatabaseWorker [" + interfaceC0146bb.b().e() + "]";
    }

    public final void a(long j, EnumC0156bl enumC0156bl, long j2) {
        JSONObject jSONObject;
        boolean b;
        Q7 q7 = new Q7(null, 1, null);
        Ch ch = (Ch) this.h.k.a();
        Long valueOf = Long.valueOf(j);
        Long valueOf2 = Long.valueOf(j2);
        try {
            jSONObject = new JSONObject().put("dId", ch.getDeviceId()).put("uId", ch.getUuid()).put("appVer", ch.getAppVersion()).put(RemoteConfigConstants.RequestFieldKey.APP_BUILD, ch.getAppBuildNumber()).put("kitBuildType", ch.getAnalyticsSdkBuildType()).put("osVer", ch.getOsVersion()).put("osApiLev", ch.getOsApiLevel()).put("lang", ch.getLocale()).put("root", ch.getDeviceRootStatus()).put("app_debuggable", ((C0347j6) ch).f919a).put(CommonUrlParts.APP_FRAMEWORK, ch.getAppFramework()).put("attribution_id", ch.r).put("analyticsSdkVersionName", ch.getAnalyticsSdkVersionName()).put("kitBuildNumber", ch.getAnalyticsSdkBuildNumber());
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        Long valueOf3 = Long.valueOf(Kn.a());
        C0438mk c0438mk = AbstractC0413lk.f955a;
        synchronized (c0438mk) {
            b = c0438mk.b.b(true);
        }
        ContentValues fromModel = q7.fromModel(new P7(valueOf, enumC0156bl, jSONObject2, new O7(valueOf2, valueOf3, Boolean.valueOf(b))));
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
            if (this.i.get() > ((Ch) this.h.k.a()).v && (writableDatabase = this.c.getWritableDatabase()) != null) {
                int a2 = a(writableDatabase);
                this.i.addAndGet(-a2);
                if (a2 != 0) {
                    Iterator it = this.j.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC0452n9) it.next()).a();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.b.unlock();
    }

    public final int a(SQLiteDatabase sQLiteDatabase) {
        try {
            return this.k.a(sQLiteDatabase, String.format("id IN (SELECT id FROM events ORDER BY CASE WHEN type IN (%1$s) THEN 2 WHEN type IN (%2$s) THEN 1 ELSE 0 END, id LIMIT (SELECT count() FROM events) / %3$s)", TextUtils.join(", ", T9.i), TextUtils.join(", ", T9.j), 10), 2, this.h.b.b, true).b;
        } catch (Throwable th) {
            C0310hk c0310hk = Gj.f460a;
            c0310hk.getClass();
            c0310hk.a(new Hj("deleteExcessiveReports exception", th));
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
                C0142b7 a2 = this.k.a(writableDatabase, format, 1, this.h.b.b, z);
                if (a2.f790a != null) {
                    ArrayList arrayList = new ArrayList();
                    for (ContentValues contentValues : a2.f790a) {
                        arrayList.add(Integer.valueOf(contentValues.getAsInteger("type").intValue()));
                    }
                    Iterator it = this.j.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC0452n9) it.next()).b(arrayList);
                    }
                }
                List list = a2.f790a;
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

    public final ContentValues a(long j, EnumC0156bl enumC0156bl) {
        ContentValues contentValues = new ContentValues();
        this.f883a.lock();
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(String.format(Locale.US, "SELECT report_request_parameters FROM sessions WHERE id = %s AND type = %s ORDER BY id DESC LIMIT 1", Long.valueOf(j), Integer.valueOf(enumC0156bl.f799a)), null);
                if (cursor.moveToNext()) {
                    ContentValues contentValues2 = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursor, contentValues2);
                    contentValues = contentValues2;
                }
            }
        } catch (Throwable unused) {
        }
        no.a(cursor);
        this.f883a.unlock();
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
        if (T9.d.contains(EnumC0728yb.a(asInteger != null ? asInteger.intValue() : -1))) {
            B7 model = new C7(null, 1, null).toModel(contentValues);
            PublicLogger publicLogger = this.h.m;
            EnumC0728yb enumC0728yb = model.d;
            A7 a7 = model.g;
            publicLogger.info(AbstractC0331ig.a(str, enumC0728yb, a7.b, a7.c), new Object[0]);
        }
    }

    public static boolean a(C0297h7 c0297h7) {
        boolean isEmpty;
        synchronized (c0297h7.e) {
            isEmpty = c0297h7.f.isEmpty();
        }
        return isEmpty;
    }
}
