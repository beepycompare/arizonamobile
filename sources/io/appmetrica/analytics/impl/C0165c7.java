package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.miami.game.core.firebase.notification.NotificationStatsStore;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.db.DBUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.c7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0165c7 {

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantReadWriteLock.ReadLock f924a;
    public final ReentrantReadWriteLock.WriteLock b;
    public final C0501p7 c;
    public final Context d;
    public final C0447n5 e;
    public final AtomicLong f;
    public final ArrayList g;
    public final Z6 h;
    public final C0682w7 i;
    public final C0419m3 j;

    public C0165c7(C0447n5 c0447n5, C0501p7 c0501p7, Z6 z6, C0682w7 c0682w7) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f924a = reentrantReadWriteLock.readLock();
        this.b = reentrantReadWriteLock.writeLock();
        AtomicLong atomicLong = new AtomicLong();
        this.f = atomicLong;
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        this.c = c0501p7;
        this.d = c0447n5.getContext();
        this.e = c0447n5;
        this.h = z6;
        this.i = c0682w7;
        atomicLong.set(b());
        this.j = new C0419m3(new X8(c0501p7, c0447n5, atomicLong, arrayList, z6, reentrantReadWriteLock), Na.k().w().e());
    }

    public final long a() {
        this.f924a.lock();
        try {
            return this.f.get();
        } finally {
            this.f924a.unlock();
        }
    }

    public final long b() {
        long j;
        SQLiteDatabase readableDatabase;
        this.f924a.lock();
        try {
            readableDatabase = this.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            j = DBUtils.queryRowsCount(readableDatabase, NotificationStatsStore.KEY_EVENTS);
            this.f924a.unlock();
            return j;
        }
        j = 0;
        this.f924a.unlock();
        return j;
    }

    public final void c() {
        Cursor cursor;
        Cursor cursor2;
        this.f924a.lock();
        Cursor cursor3 = null;
        try {
            SQLiteDatabase readableDatabase = this.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor2 = readableDatabase.query(true, "sessions", new String[]{TtmlNode.ATTR_ID}, null, null, null, null, "id ASC", null);
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("All sessions in db: ");
                    while (cursor2.moveToNext()) {
                        stringBuffer.append(cursor2.getString(0)).append(", ");
                    }
                    cursor3 = readableDatabase.query(true, NotificationStatsStore.KEY_EVENTS, new String[]{"session_id"}, null, null, null, null, "session_id ASC", null);
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
                    this.f924a.unlock();
                    Oo.a(cursor2);
                    Oo.a(cursor3);
                }
            } else {
                cursor2 = null;
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        this.f924a.unlock();
        Oo.a(cursor2);
        Oo.a(cursor3);
    }

    public final long a(Set set) {
        long j;
        SQLiteDatabase readableDatabase;
        String[] strArr;
        String str;
        this.f924a.lock();
        try {
            readableDatabase = this.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            if (set.isEmpty()) {
                strArr = null;
                str = null;
            } else {
                StringBuilder sb = new StringBuilder("type IN (");
                strArr = new String[set.size()];
                Iterator it = set.iterator();
                int i = 0;
                while (it.hasNext()) {
                    Integer num = (Integer) it.next();
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append("?");
                    strArr[i] = String.valueOf(num);
                    i++;
                }
                sb.append(")");
                str = sb.toString();
            }
            j = DatabaseUtils.queryNumEntries(readableDatabase, NotificationStatsStore.KEY_EVENTS, str, strArr);
            this.f924a.unlock();
            return j;
        }
        j = 0;
        this.f924a.unlock();
        return j;
    }

    public final void a(InterfaceC0425m9 interfaceC0425m9) {
        this.g.add(interfaceC0425m9);
    }

    public final void a(ContentValues contentValues) {
        if (contentValues == null) {
            return;
        }
        this.b.lock();
        try {
            SQLiteDatabase writableDatabase = this.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.insertOrThrow("sessions", null, contentValues);
            }
        } catch (Throwable unused) {
        }
        this.b.unlock();
    }

    public final X6 a(SQLiteDatabase sQLiteDatabase, String str, C0385kl c0385kl) {
        return this.h.a(sQLiteDatabase, str, new String[]{Long.toString(c0385kl.f1072a), Integer.toString(c0385kl.b), Long.toString(c0385kl.c)}, 1, this.e.b.b, c0385kl.d);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:1|(2:2|3)|(9:5|7|8|(2:10|11)|13|14|15|(2:17|18)|21)|24|13|14|15|(0)|21) */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0060 A[Catch: all -> 0x006b, TRY_LEAVE, TryCatch #0 {all -> 0x006b, blocks: (B:12:0x0056, B:14:0x0060), top: B:20:0x0056 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0696wl a(long j, Al al) {
        Cursor cursor;
        String asString;
        SQLiteDatabase readableDatabase;
        ContentValues contentValues = new ContentValues();
        this.f924a.lock();
        try {
            readableDatabase = this.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("sessions", new String[]{"report_request_parameters"}, "id = ? AND type = ?", new String[]{String.valueOf(j), String.valueOf(al.f465a)}, null, null, null, "1");
            try {
                if (cursor.moveToNext()) {
                    ContentValues contentValues2 = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursor, contentValues2);
                    contentValues = contentValues2;
                }
            } catch (Throwable unused2) {
            }
            Oo.a(cursor);
            this.f924a.unlock();
            asString = contentValues.getAsString("report_request_parameters");
            if (!StringUtils.isNullOrEmpty(asString)) {
                return new C0696wl(new JSONObject(asString));
            }
            return null;
        }
        cursor = null;
        Oo.a(cursor);
        this.f924a.unlock();
        asString = contentValues.getAsString("report_request_parameters");
        if (!StringUtils.isNullOrEmpty(asString)) {
        }
        return null;
    }

    public static String a(LinkedHashMap linkedHashMap) {
        StringBuilder sb = new StringBuilder("id >= ?");
        for (String str : linkedHashMap.keySet()) {
            sb.append(sb.length() > 0 ? " AND " : "");
            sb.append(str).append(" = ? ");
        }
        if (TextUtils.isEmpty(sb.toString())) {
            return null;
        }
        return sb.toString();
    }
}
