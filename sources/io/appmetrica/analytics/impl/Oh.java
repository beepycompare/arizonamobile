package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import io.appmetrica.analytics.coreutils.internal.db.DBUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
/* loaded from: classes5.dex */
public final class Oh {

    /* renamed from: a  reason: collision with root package name */
    public final C0165c7 f706a;
    public final C0670vl b;
    public final ap c;

    public Oh(C0447n5 c0447n5) {
        this.f706a = c0447n5.i();
        this.b = c0447n5.s();
        this.c = c0447n5.u();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List a(LinkedHashMap linkedHashMap) {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        C0165c7 c0165c7 = this.f706a;
        c0165c7.f924a.lock();
        try {
            readableDatabase = c0165c7.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            String a2 = C0165c7.a(linkedHashMap);
            ArrayList arrayList = new ArrayList(Arrays.asList(Long.toString(0L)));
            for (Map.Entry entry : linkedHashMap.entrySet()) {
                arrayList.add((String) entry.getValue());
            }
            cursor = readableDatabase.query("sessions", null, a2, (String[]) arrayList.toArray(new String[0]), null, null, "id ASC", null);
            c0165c7.f924a.unlock();
            if (cursor != null) {
                return CollectionsKt.emptyList();
            }
            ArrayList arrayList2 = new ArrayList();
            while (cursor.moveToNext()) {
                try {
                    ContentValues contentValues = new ContentValues();
                    DBUtils.cursorRowToContentValues(cursor, contentValues);
                    arrayList2.add(new K7(null, 1, null).toModel(contentValues));
                } catch (Throwable unused2) {
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(cursor, null);
            return arrayList2;
        }
        cursor = null;
        c0165c7.f924a.unlock();
        if (cursor != null) {
        }
    }

    public final int a() {
        int optInt;
        ap apVar = this.c;
        synchronized (apVar) {
            optInt = apVar.f896a.a().optInt("report_request_id", -1);
        }
        return optInt + 1;
    }
}
