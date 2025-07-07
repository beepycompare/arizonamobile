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
/* renamed from: io.appmetrica.analytics.impl.d7  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0209d7 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantReadWriteLock.ReadLock f799a;
    public final ReentrantReadWriteLock.WriteLock b;
    public final C0533q7 c;
    public final C0183c7 d;
    public final Object e;
    public final ArrayList f;
    public final Context g;
    public final C0580s5 h;
    public final AtomicLong i;
    public final ArrayList j;
    public final Z6 k;
    public final C0732y7 l;

    static {
        HashSet hashSet = new HashSet();
        EnumC0636ub enumC0636ub = EnumC0636ub.EVENT_TYPE_UNDEFINED;
        hashSet.add(0);
        hashSet.add(6400);
    }

    public C0209d7(C0580s5 c0580s5, C0533q7 c0533q7, Z6 z6, C0732y7 c0732y7) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f799a = reentrantReadWriteLock.readLock();
        this.b = reentrantReadWriteLock.writeLock();
        this.e = new Object();
        this.f = new ArrayList(3);
        AtomicLong atomicLong = new AtomicLong();
        this.i = atomicLong;
        this.j = new ArrayList();
        this.c = c0533q7;
        this.g = c0580s5.getContext();
        this.h = c0580s5;
        this.k = z6;
        this.l = c0732y7;
        atomicLong.set(c());
        C0183c7 c0183c7 = new C0183c7(this, c0580s5);
        this.d = c0183c7;
        c0183c7.setName(a(c0580s5));
    }

    public final long a(Set set) {
        this.f799a.lock();
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
        fo.a(cursor);
        this.f799a.unlock();
        return j;
    }

    public final long b() {
        this.f799a.lock();
        try {
            return this.i.get();
        } finally {
            this.f799a.unlock();
        }
    }

    public final long c() {
        long j;
        SQLiteDatabase readableDatabase;
        this.f799a.lock();
        try {
            readableDatabase = this.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            j = DBUtils.queryRowsCount(readableDatabase, "events");
            this.f799a.unlock();
            return j;
        }
        j = 0;
        this.f799a.unlock();
        return j;
    }

    public final void d() {
        Cursor cursor;
        Cursor cursor2;
        this.f799a.lock();
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
                    this.f799a.unlock();
                    fo.a(cursor2);
                    fo.a(cursor3);
                }
            } else {
                cursor2 = null;
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        this.f799a.unlock();
        fo.a(cursor2);
        fo.a(cursor3);
    }

    public final void e() {
        this.d.start();
    }

    public final void a(InterfaceC0336i9 interfaceC0336i9) {
        this.j.add(interfaceC0336i9);
    }

    public static String a(Xa xa) {
        return "DatabaseWorker [" + xa.b().e() + "]";
    }

    public final void a(long j, Tk tk, long j2) {
        JSONObject jSONObject;
        boolean b;
        M7 m7 = new M7(null, 1, null);
        C0667vh c0667vh = (C0667vh) this.h.k.a();
        Long valueOf = Long.valueOf(j);
        Long valueOf2 = Long.valueOf(j2);
        try {
            jSONObject = new JSONObject().put("dId", c0667vh.getDeviceId()).put("uId", c0667vh.getUuid()).put("appVer", c0667vh.getAppVersion()).put(RemoteConfigConstants.RequestFieldKey.APP_BUILD, c0667vh.getAppBuildNumber()).put("kitBuildType", c0667vh.getAnalyticsSdkBuildType()).put("osVer", c0667vh.getOsVersion()).put("osApiLev", c0667vh.getOsApiLevel()).put("lang", c0667vh.getLocale()).put("root", c0667vh.getDeviceRootStatus()).put("app_debuggable", ((C0283g6) c0667vh).f851a).put(CommonUrlParts.APP_FRAMEWORK, c0667vh.getAppFramework()).put("attribution_id", c0667vh.r).put("analyticsSdkVersionName", c0667vh.getAnalyticsSdkVersionName()).put("kitBuildNumber", c0667vh.getAnalyticsSdkBuildNumber());
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        Long valueOf3 = Long.valueOf(Cn.a());
        C0247ek c0247ek = AbstractC0222dk.f808a;
        synchronized (c0247ek) {
            b = c0247ek.b.b(true);
        }
        ContentValues fromModel = m7.fromModel(new L7(valueOf, tk, jSONObject2, new K7(valueOf2, valueOf3, Boolean.valueOf(b))));
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
            if (this.i.get() > ((C0667vh) this.h.k.a()).v && (writableDatabase = this.c.getWritableDatabase()) != null) {
                int a2 = a(writableDatabase);
                this.i.addAndGet(-a2);
                if (a2 != 0) {
                    Iterator it = this.j.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC0336i9) it.next()).a();
                    }
                }
            }
        } catch (Throwable unused) {
        }
        this.b.unlock();
    }

    public final int a(SQLiteDatabase sQLiteDatabase) {
        try {
            return this.k.a(sQLiteDatabase, String.format("id IN (SELECT id FROM events ORDER BY CASE WHEN type IN (%1$s) THEN 2 WHEN type IN (%2$s) THEN 1 ELSE 0 END, id LIMIT (SELECT count() FROM events) / %3$s)", TextUtils.join(", ", O9.i), TextUtils.join(", ", O9.j), 10), 2, this.h.b.b, true).b;
        } catch (Throwable th) {
            Zj zj = AbstractC0744yj.f1148a;
            zj.getClass();
            zj.a(new C0769zj("deleteExcessiveReports exception", th));
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
                X6 a2 = this.k.a(writableDatabase, format, 1, this.h.b.b, z);
                if (a2.f700a != null) {
                    ArrayList arrayList = new ArrayList();
                    for (ContentValues contentValues : a2.f700a) {
                        arrayList.add(Integer.valueOf(contentValues.getAsInteger("type").intValue()));
                    }
                    Iterator it = this.j.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC0336i9) it.next()).b(arrayList);
                    }
                }
                List list = a2.f700a;
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

    public final ContentValues a(long j, Tk tk) {
        ContentValues contentValues = new ContentValues();
        this.f799a.lock();
        Cursor cursor = null;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(String.format(Locale.US, "SELECT report_request_parameters FROM sessions WHERE id = %s AND type = %s ORDER BY id DESC LIMIT 1", Long.valueOf(j), Integer.valueOf(tk.f646a)), null);
                if (cursor.moveToNext()) {
                    ContentValues contentValues2 = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursor, contentValues2);
                    contentValues = contentValues2;
                }
            }
        } catch (Throwable unused) {
        }
        fo.a(cursor);
        this.f799a.unlock();
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
        if (O9.d.contains(EnumC0636ub.a(asInteger != null ? asInteger.intValue() : -1))) {
            C0707x7 model = new C0732y7(null, 1, null).toModel(contentValues);
            PublicLogger publicLogger = this.h.m;
            EnumC0636ub enumC0636ub = model.d;
            C0682w7 c0682w7 = model.g;
            publicLogger.info(AbstractC0166bg.a(str, enumC0636ub, c0682w7.b, c0682w7.c), new Object[0]);
        }
    }

    public static boolean a(C0209d7 c0209d7) {
        boolean isEmpty;
        synchronized (c0209d7.e) {
            isEmpty = c0209d7.f.isEmpty();
        }
        return isEmpty;
    }
}
