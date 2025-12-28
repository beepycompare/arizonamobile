package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.coreutils.internal.WrapUtils;
import io.appmetrica.analytics.coreutils.internal.db.DBUtils;
import io.appmetrica.analytics.coreutils.internal.io.GZIPCompressor;
import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import io.appmetrica.analytics.networktasks.internal.DefaultNetworkResponseHandler;
import io.appmetrica.analytics.networktasks.internal.FullUrlFormer;
import io.appmetrica.analytics.networktasks.internal.RequestBodyEncrypter;
import io.appmetrica.analytics.networktasks.internal.RequestDataHolder;
import io.appmetrica.analytics.networktasks.internal.ResponseDataHolder;
import io.appmetrica.analytics.networktasks.internal.RetryPolicyConfig;
import io.appmetrica.analytics.networktasks.internal.SendingDataTaskHelper;
import io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.vh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0651vh implements UnderlyingNetworkTask {

    /* renamed from: a  reason: collision with root package name */
    public final Y4 f1268a;
    public final LinkedHashMap b;
    public C0417m7 c;
    public C0368k9 d;
    public final M6 e;
    public List f;
    public int g;
    public int h;
    public int i;
    public C0626uh j;
    public final C0104a3 k;
    public final PublicLogger l;
    public final yo m;
    public final Sa n;
    public final C0118ah o;
    public final FullUrlFormer p;
    public final C0745zb q;
    public final RequestDataHolder r;
    public final ResponseDataHolder s;
    public final SendingDataTaskHelper t;
    public int u;
    public boolean v;

    public C0651vh(Y4 y4, C0118ah c0118ah, C0745zb c0745zb, FullUrlFormer<C0402lh> fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this(y4, c0118ah, c0745zb, fullUrlFormer, requestDataHolder, responseDataHolder, y4.i(), y4.p(), y4.u(), requestBodyEncrypter);
    }

    public final C0368k9 a(C0626uh c0626uh, List list, C0402lh c0402lh) {
        C0368k9 c0368k9 = new C0368k9();
        C0162c9 c0162c9 = new C0162c9();
        c0162c9.f925a = WrapUtils.getOrDefaultIfEmpty(this.c.b, c0402lh.getUuid());
        c0162c9.b = WrapUtils.getOrDefaultIfEmpty(this.c.f1104a, c0402lh.getDeviceId());
        this.g = CodedOutputByteBufferNano.computeMessageSize(4, c0162c9) + this.g;
        c0368k9.b = c0162c9;
        C0508pn C = C0470oa.I.C();
        C0576sh c0576sh = new C0576sh(this, c0368k9);
        synchronized (C) {
            C.f1173a.a(c0576sh);
        }
        c0368k9.f1071a = (C0291h9[]) c0626uh.f1250a.toArray(new C0291h9[0]);
        c0368k9.c = a(c0626uh.c);
        c0368k9.e = (String[]) list.toArray(new String[0]);
        Set set = c0402lh.x;
        String[] strArr = (String[]) set.toArray(new String[0]);
        c0368k9.f = new byte[strArr.length];
        for (int i = 0; i < set.size(); i++) {
            c0368k9.f[i] = StringUtils.getUTF8Bytes(strArr[i]);
        }
        return c0368k9;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final String description() {
        return "ReportTask_" + ApiKeyUtils.createPartialApiKey(this.f1268a.b.b);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final FullUrlFormer<?> getFullUrlFormer() {
        return this.p;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final RequestDataHolder getRequestDataHolder() {
        return this.r;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final ResponseDataHolder getResponseDataHolder() {
        return this.s;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final RetryPolicyConfig getRetryPolicyConfig() {
        return ((C0402lh) this.f1268a.k.a()).getRetryPolicyConfig();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final SSLSocketFactory getSslSocketFactory() {
        ((Bl) C0470oa.I.z()).getClass();
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0052  */
    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onCreateTask() {
        Cursor cursor;
        int optInt;
        M6 m6 = this.f1268a.e;
        m6.getClass();
        ArrayList arrayList = new ArrayList();
        m6.f682a.lock();
        try {
            SQLiteDatabase readableDatabase = m6.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(AbstractC0639v5.b, null);
                while (cursor.moveToNext()) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        DatabaseUtils.cursorRowToContentValues(cursor, contentValues);
                        arrayList.add(contentValues);
                    } catch (Throwable unused) {
                        try {
                            arrayList = new ArrayList();
                            if (arrayList.isEmpty()) {
                            }
                        } finally {
                            mo.a(cursor);
                            m6.f682a.unlock();
                        }
                    }
                }
            } else {
                cursor = null;
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        if (arrayList.isEmpty()) {
            ContentValues contentValues2 = (ContentValues) arrayList.get(0);
            this.b.clear();
            for (Map.Entry<String, Object> entry : contentValues2.valueSet()) {
                this.b.put(entry.getKey(), entry.getValue().toString());
            }
            String asString = contentValues2.getAsString("report_request_parameters");
            if (!TextUtils.isEmpty(asString)) {
                try {
                    C0417m7 c0417m7 = new C0417m7(new C0267gb(asString));
                    this.c = c0417m7;
                    this.o.c = c0417m7;
                } catch (Throwable unused3) {
                    C0417m7 c0417m72 = new C0417m7();
                    this.c = c0417m72;
                    this.o.c = c0417m72;
                }
            } else {
                C0417m7 c0417m73 = new C0417m7();
                this.c = c0417m73;
                this.o.c = c0417m73;
            }
            C0402lh config = this.q.getConfig();
            List list = config.w;
            if (mo.a((Collection) list)) {
                return false;
            }
            this.p.setHosts(config.q);
            if (config.u() && !mo.a((Collection) this.p.getAllHosts())) {
                this.f = null;
                C0626uh a2 = a(config);
                this.j = a2;
                if (a2.f1250a.isEmpty()) {
                    return false;
                }
                yo yoVar = this.m;
                synchronized (yoVar) {
                    optInt = yoVar.f1323a.a().optInt("report_request_id", -1);
                }
                int i = optInt + 1;
                this.u = i;
                this.o.e = i;
                C0368k9 a3 = a(this.j, list, config);
                this.d = a3;
                this.f = this.j.b;
                this.t.prepareAndSetPostData(MessageNano.toByteArray(a3));
                return true;
            }
            this.v = true;
            return false;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onPerformRequest() {
        this.t.onPerformRequest();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onPostRequestComplete(boolean z) {
        C0239f9[] c0239f9Arr;
        String a2;
        if (z) {
            a(false);
        } else if (this.s.getResponseCode() == 400) {
            a(true);
        }
        if (z) {
            for (int i = 0; i < this.j.f1250a.size(); i++) {
                for (C0239f9 c0239f9 : ((C0291h9) this.j.f1250a.get(i)).c) {
                    if (c0239f9 != null && (a2 = Rf.a(c0239f9)) != null) {
                        this.l.info(a2, new Object[0]);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final boolean onRequestComplete() {
        return this.t.isResponseValid();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onRequestError(Throwable th) {
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onShouldNotExecute() {
        this.v = true;
        this.f1268a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onSuccessfulTaskFinished() {
        this.v = true;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskAdded() {
        ((C0390l5) this.f1268a.p).d.set(false);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskFinished() {
        this.f1268a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskRemoved() {
        ((C0390l5) this.f1268a.p).d.set(true);
        if (this.v) {
            ((C0390l5) this.f1268a.p).f();
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onUnsuccessfulTaskFinished() {
    }

    public C0651vh(Y4 y4, C0118ah c0118ah, C0745zb c0745zb, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, M6 m6, PublicLogger publicLogger, yo yoVar, RequestBodyEncrypter requestBodyEncrypter) {
        this(y4, publicLogger, m6, c0118ah, yoVar, c0745zb, new C0104a3(1024000, "event value in ReportTask", publicLogger), AbstractC0710y1.a(), fullUrlFormer, requestDataHolder, responseDataHolder, requestBodyEncrypter);
    }

    public C0651vh(Y4 y4, PublicLogger publicLogger, M6 m6, C0118ah c0118ah, yo yoVar, C0745zb c0745zb, C0104a3 c0104a3, Rj rj, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this.b = new LinkedHashMap();
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.v = false;
        this.t = new SendingDataTaskHelper(requestBodyEncrypter, new GZIPCompressor(), requestDataHolder, responseDataHolder, new DefaultNetworkResponseHandler());
        this.o = c0118ah;
        this.f1268a = y4;
        this.e = m6;
        this.l = publicLogger;
        this.k = c0104a3;
        this.m = yoVar;
        this.q = c0745zb;
        this.n = rj;
        this.r = requestDataHolder;
        this.s = responseDataHolder;
        this.p = fullUrlFormer;
    }

    public static Z8[] a(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length > 0) {
            Z8[] z8Arr = new Z8[length];
            Iterator<String> keys = jSONObject.keys();
            int i = 0;
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    Z8 z8 = new Z8();
                    z8.f873a = next;
                    z8.b = jSONObject.getString(next);
                    z8Arr[i] = z8;
                } catch (Throwable unused) {
                }
                i++;
            }
            return z8Arr;
        }
        return null;
    }

    public final void a(boolean z) {
        boolean z2;
        yo yoVar = this.m;
        int i = this.u;
        synchronized (yoVar) {
            zo zoVar = yoVar.f1323a;
            zoVar.a(zoVar.a().put("report_request_id", i));
        }
        C0291h9[] c0291h9Arr = this.d.f1071a;
        int i2 = 0;
        while (i2 < c0291h9Arr.length) {
            try {
                C0291h9 c0291h9 = c0291h9Arr[i2];
                long longValue = ((Long) this.f.get(i2)).longValue();
                Wk wk = (Wk) Qf.b.get(c0291h9.b.c);
                if (wk == null) {
                    wk = Wk.FOREGROUND;
                }
                z2 = z;
                try {
                    this.e.a(longValue, wk.f840a, c0291h9.c.length, z2);
                    Qf.a(c0291h9);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                z2 = z;
            }
            i2++;
            z = z2;
        }
        M6 m6 = this.e;
        long a2 = this.f1268a.j.a();
        m6.b.lock();
        try {
            if (AbstractC0689x5.f1293a.booleanValue()) {
                m6.d();
            }
            SQLiteDatabase writableDatabase = m6.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("sessions", AbstractC0639v5.c, new String[]{String.valueOf(a2)});
            }
        } catch (Throwable unused3) {
        }
        m6.b.unlock();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7 A[LOOP:1: B:44:0x00e1->B:46:0x00e7, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0626uh a(C0402lh c0402lh) {
        Iterator it;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList3 = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor a2 = a();
            if (a2 != null) {
                JSONObject jSONObject2 = jSONObject;
                C0308i0 c0308i0 = null;
                while (a2.moveToNext() && this.h < 100) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(a2, contentValues);
                        C0591t7 model = new C0616u7(null, 1, null).toModel(contentValues);
                        Long l = model.f1228a;
                        if (l != null) {
                            C0566s7 c0566s7 = model.d;
                            C0342j9 a3 = Qf.a(c0566s7.f1213a, c0566s7.b, c0566s7.c);
                            String locale = c0402lh.getLocale();
                            Wk wk = model.b;
                            C0265g9 c0265g9 = new C0265g9();
                            c0265g9.f1001a = a3;
                            c0265g9.b = locale;
                            if (wk != null) {
                                Integer num = (Integer) Qf.f748a.get(wk);
                                c0265g9.c = num != null ? num.intValue() : 0;
                            }
                            int computeUInt64Size = this.g + CodedOutputByteBufferNano.computeUInt64Size(1, Long.MAX_VALUE);
                            this.g = computeUInt64Size;
                            int computeMessageSize = computeUInt64Size + CodedOutputByteBufferNano.computeMessageSize(2, c0265g9);
                            this.g = computeMessageSize;
                            if (computeMessageSize >= 250880) {
                                break;
                            }
                            C0601th a4 = a(l.longValue(), c0265g9, c0402lh, arrayList3, arrayList.size());
                            if (a4 == null) {
                                continue;
                            } else {
                                if (c0308i0 == null) {
                                    c0308i0 = a4.b;
                                } else if (!c0308i0.equals(a4.b)) {
                                    break;
                                }
                                arrayList2.add(l);
                                arrayList.add(a4.f1233a);
                                if (!TextUtils.isEmpty(a4.b.f1029a)) {
                                    try {
                                        jSONObject2 = new JSONObject(a4.b.f1029a);
                                    } catch (Throwable unused) {
                                    }
                                }
                                if (a4.c) {
                                    break;
                                }
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = a2;
                        jSONObject = jSONObject2;
                        try {
                            arrayList3.add(th);
                            it = arrayList3.iterator();
                            while (it.hasNext()) {
                            }
                            return new C0626uh(arrayList, arrayList2, jSONObject);
                        } finally {
                            mo.a(cursor);
                        }
                    }
                }
                jSONObject = jSONObject2;
            }
            mo.a(a2);
        } catch (Throwable th2) {
            th = th2;
        }
        it = arrayList3.iterator();
        while (it.hasNext()) {
            this.n.reportError("protobuf_serialization_error", (Throwable) it.next());
        }
        return new C0626uh(arrayList, arrayList2, jSONObject);
    }

    public static C0308i0 a(ContentValues contentValues) {
        C0237f7 model = new C0263g7(null, 1, null).toModel(contentValues);
        return new C0308i0((String) WrapUtils.getOrDefault(model.g.g, ""), ((Long) WrapUtils.getOrDefault(model.g.h, 0L)).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[Catch: all -> 0x010c, TryCatch #4 {all -> 0x010c, blocks: (B:7:0x0025, B:8:0x002b, B:10:0x0032, B:12:0x0038, B:29:0x006c, B:31:0x0072, B:40:0x0094, B:45:0x00a5, B:47:0x00b4, B:54:0x00c0, B:53:0x00bf, B:50:0x00ba, B:55:0x00c6, B:58:0x00d8, B:61:0x00df, B:42:0x009d, B:64:0x00e7, B:26:0x0065, B:65:0x00f1, B:67:0x00f7), top: B:90:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0601th a(long j, C0265g9 c0265g9, C0402lh c0402lh, ArrayList arrayList, int i) {
        Cursor cursor;
        boolean z;
        C0601th c0601th;
        C0239f9 c0239f9;
        int i2;
        Z8[] a2;
        V8 v8;
        C0291h9 c0291h9 = new C0291h9();
        c0291h9.f1019a = j;
        c0291h9.b = c0265g9;
        Wk wk = (Wk) Qf.b.get(c0265g9.c);
        if (wk == null) {
            wk = Wk.FOREGROUND;
        }
        try {
            cursor = a(j, wk);
            if (cursor != null) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    C0308i0 c0308i0 = null;
                    while (true) {
                        z = false;
                        if (!cursor.moveToNext() || this.h >= 100) {
                            break;
                        }
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(cursor, contentValues);
                        try {
                            O8 o8 = new O8(contentValues);
                            EnumC0164cb enumC0164cb = o8.h;
                            if (enumC0164cb != null) {
                                v8 = (V8) Qf.d.get(enumC0164cb);
                            } else {
                                Map map = Qf.f748a;
                                v8 = null;
                            }
                            if (v8 == null) {
                                v8 = V8.i;
                            }
                            try {
                                c0239f9 = v8.a(o8, c0402lh);
                            } catch (Throwable th) {
                                th = th;
                                arrayList.add(th);
                                c0239f9 = null;
                                if (c0239f9 == null) {
                                }
                                arrayList2.add(c0239f9);
                                this.h++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (c0239f9 == null) {
                            C0308i0 a3 = a(contentValues);
                            if (c0308i0 == null) {
                                if (this.i < 0) {
                                    try {
                                        a2 = a(new JSONObject(a3.f1029a));
                                    } catch (Throwable unused) {
                                    }
                                    if (a2 != null) {
                                        i2 = 0;
                                        for (Z8 z8 : a2) {
                                            i2 += CodedOutputByteBufferNano.computeMessageSize(7, z8);
                                        }
                                        this.i = i2;
                                        this.g += i2;
                                    }
                                    i2 = 0;
                                    this.i = i2;
                                    this.g += i2;
                                }
                                c0308i0 = a3;
                            } else if (!c0308i0.equals(a3)) {
                                z = true;
                                break;
                            }
                            C0104a3 c0104a3 = this.k;
                            byte[] bArr = c0239f9.e;
                            c0104a3.getClass();
                            byte[] a4 = c0104a3.a(bArr);
                            byte[] bArr2 = c0239f9.e;
                            if (bArr2 != a4) {
                                c0239f9.i = ((bArr2 == null ? 0 : bArr2.length) - (a4 == null ? 0 : a4.length)) + c0239f9.i;
                                c0239f9.e = a4;
                            }
                            this.g += CodedOutputByteBufferNano.computeMessageSize(3, c0239f9);
                            if (arrayList2.isEmpty() && i == 0) {
                                if (this.g >= 1048576) {
                                    break;
                                }
                            } else if (this.g >= 250880) {
                                break;
                            }
                        }
                        arrayList2.add(c0239f9);
                        this.h++;
                    }
                    if (arrayList2.size() > 0) {
                        c0291h9.c = (C0239f9[]) arrayList2.toArray(new C0239f9[arrayList2.size()]);
                        c0601th = new C0601th(c0291h9, c0308i0, z);
                        return c0601th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        arrayList.add(th);
                        mo.a(cursor);
                        return null;
                    } finally {
                        mo.a(cursor);
                    }
                }
            }
            c0601th = null;
            return c0601th;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
    }

    public final Cursor a() {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        M6 m6 = this.e;
        LinkedHashMap linkedHashMap = this.b;
        m6.f682a.lock();
        try {
            readableDatabase = m6.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("sessions", null, M6.a(linkedHashMap), M6.a(new String[]{Long.toString(0L)}, linkedHashMap), null, null, "id ASC", null);
            m6.f682a.unlock();
            return cursor;
        }
        cursor = null;
        m6.f682a.unlock();
        return cursor;
    }

    public final Cursor a(long j, Wk wk) {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        M6 m6 = this.e;
        m6.f682a.lock();
        try {
            readableDatabase = m6.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("events", null, "session_id = ? AND session_type = ?", new String[]{Long.toString(j), Integer.toString(wk.f840a)}, null, null, "number_in_session ASC", null);
            m6.f682a.unlock();
            return cursor;
        }
        cursor = null;
        m6.f682a.unlock();
        return cursor;
    }
}
