package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.os.ResultReceiver;
import io.appmetrica.analytics.coreutils.internal.logger.LoggerStorage;
import io.appmetrica.analytics.internal.CounterConfiguration;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Z6 {

    /* renamed from: a  reason: collision with root package name */
    public final CounterConfigurationReporterType f866a;

    public Z6(CounterConfigurationReporterType counterConfigurationReporterType) {
        this.f866a = counterConfigurationReporterType;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:1|(2:2|3)|(3:64|65|(10:67|(2:70|68)|71|6|7|8|9|(2:16|(8:19|83|27|28|(4:31|(5:35|36|(1:38)(1:42)|39|40)|41|29)|45|46|(2:50|51)))|60|61))|5|6|7|8|9|(4:11|13|16|(2:19|83))|60|61|(1:(0))) */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final X6 a(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, int i, String str2, boolean z) {
        Cursor cursor;
        ArrayList<ContentValues> arrayList;
        Mj mj;
        Kj kj;
        C0189d4 c0189d4;
        Integer num;
        int i2 = 0;
        try {
            cursor = sQLiteDatabase.query("events", new String[]{"global_number", "type", "event_description"}, str, strArr, null, null, null);
        } catch (Throwable th) {
            th = th;
            cursor = null;
        }
        if (cursor != null) {
            try {
            } catch (Throwable th2) {
                th = th2;
                try {
                    C0541qk c0541qk = Oj.f705a;
                    c0541qk.getClass();
                    c0541qk.a(new Pj("select_rows_to_delete_exception", th));
                    Oo.a(cursor);
                    arrayList = null;
                    i2 = sQLiteDatabase.delete("events", str, strArr);
                    if (arrayList != null) {
                    }
                    return new X6(arrayList, i2);
                } finally {
                    Oo.a(cursor);
                }
            }
            if (cursor.getCount() > 0) {
                arrayList = new ArrayList(cursor.getCount());
                while (cursor.moveToNext()) {
                    ContentValues contentValues = new ContentValues();
                    DatabaseUtils.cursorRowToContentValues(cursor, contentValues);
                    arrayList.add(contentValues);
                }
                i2 = sQLiteDatabase.delete("events", str, strArr);
                if (arrayList != null && arrayList.size() != 0 && i2 == arrayList.size() && z) {
                    mj = Na.I.f;
                    if (str2 != null && mj != null) {
                        CounterConfigurationReporterType counterConfigurationReporterType = this.f866a;
                        synchronized (mj) {
                            kj = (Kj) mj.c.get(str2);
                            if (kj == null) {
                                kj = new Kj(str2, mj.b, counterConfigurationReporterType, mj.f666a);
                                mj.c.put(str2, kj);
                            }
                        }
                        try {
                            JSONObject jSONObject = new JSONObject();
                            JSONArray jSONArray = new JSONArray();
                            JSONArray jSONArray2 = new JSONArray();
                            for (ContentValues contentValues2 : arrayList) {
                                Integer asInteger = contentValues2.getAsInteger("global_number");
                                Integer asInteger2 = contentValues2.getAsInteger("type");
                                if (asInteger != null && asInteger2 != null) {
                                    jSONArray.put(asInteger);
                                    Db a2 = Db.a(asInteger2.intValue());
                                    if (a2 == null) {
                                        Map map = AbstractC0537qg.f1163a;
                                        num = null;
                                    } else {
                                        num = (Integer) AbstractC0537qg.c.get(a2);
                                    }
                                    jSONArray2.put(num);
                                }
                            }
                            jSONObject.put("global_number", jSONArray).put("event_type", jSONArray2);
                            JSONObject put = new JSONObject().put("details", new JSONObject().put("reason", Y6.a(i)).put("cleared", jSONObject).put("actual_deleted_number", i2));
                            PublicLogger orCreatePublicLogger = LoggerStorage.getOrCreatePublicLogger(str2);
                            String jSONObject2 = put.toString();
                            Set set = Q9.f727a;
                            Db db = Db.EVENT_TYPE_UNDEFINED;
                            c0189d4 = new C0189d4(jSONObject2, "", 12290, 0, orCreatePublicLogger);
                        } catch (Throwable unused) {
                            c0189d4 = null;
                        }
                        if (c0189d4 != null && kj.c != null) {
                            try {
                                CounterConfiguration counterConfiguration = new CounterConfiguration(kj.f629a);
                                counterConfiguration.setReporterType(kj.c);
                                kj.d.f687a.reportData(1, c0189d4.d(new Zh(new C0175cg(kj.b, (ResultReceiver) null), counterConfiguration, new W8(new Wl(LoggerStorage.getOrCreatePublicLogger(kj.f629a), "Crash Environment")), null).c()));
                            } catch (Throwable unused2) {
                            }
                        }
                    }
                }
                return new X6(arrayList, i2);
            }
        }
        arrayList = null;
        i2 = sQLiteDatabase.delete("events", str, strArr);
        if (arrayList != null) {
            mj = Na.I.f;
            if (str2 != null) {
                CounterConfigurationReporterType counterConfigurationReporterType2 = this.f866a;
                synchronized (mj) {
                }
            }
        }
        return new X6(arrayList, i2);
    }
}
