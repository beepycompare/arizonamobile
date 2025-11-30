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
public final class C0652vh implements UnderlyingNetworkTask {

    /* renamed from: a  reason: collision with root package name */
    public final Y4 f1170a;
    public final LinkedHashMap b;
    public C0418m7 c;
    public C0369k9 d;
    public final M6 e;
    public List f;
    public int g;
    public int h;
    public int i;
    public C0627uh j;
    public final C0105a3 k;
    public final PublicLogger l;
    public final yo m;
    public final Sa n;
    public final C0119ah o;
    public final FullUrlFormer p;
    public final C0746zb q;
    public final RequestDataHolder r;
    public final ResponseDataHolder s;
    public final SendingDataTaskHelper t;
    public int u;
    public boolean v;

    public C0652vh(Y4 y4, C0119ah c0119ah, C0746zb c0746zb, FullUrlFormer<C0403lh> fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this(y4, c0119ah, c0746zb, fullUrlFormer, requestDataHolder, responseDataHolder, y4.i(), y4.p(), y4.u(), requestBodyEncrypter);
    }

    public final C0369k9 a(C0627uh c0627uh, List list, C0403lh c0403lh) {
        C0369k9 c0369k9 = new C0369k9();
        C0163c9 c0163c9 = new C0163c9();
        c0163c9.f827a = WrapUtils.getOrDefaultIfEmpty(this.c.b, c0403lh.getUuid());
        c0163c9.b = WrapUtils.getOrDefaultIfEmpty(this.c.f1006a, c0403lh.getDeviceId());
        this.g = CodedOutputByteBufferNano.computeMessageSize(4, c0163c9) + this.g;
        c0369k9.b = c0163c9;
        C0509pn C = C0471oa.I.C();
        C0577sh c0577sh = new C0577sh(this, c0369k9);
        synchronized (C) {
            C.f1075a.a(c0577sh);
        }
        c0369k9.f973a = (C0292h9[]) c0627uh.f1152a.toArray(new C0292h9[0]);
        c0369k9.c = a(c0627uh.c);
        c0369k9.e = (String[]) list.toArray(new String[0]);
        Set set = c0403lh.x;
        String[] strArr = (String[]) set.toArray(new String[0]);
        c0369k9.f = new byte[strArr.length];
        for (int i = 0; i < set.size(); i++) {
            c0369k9.f[i] = StringUtils.getUTF8Bytes(strArr[i]);
        }
        return c0369k9;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final String description() {
        return "ReportTask_" + ApiKeyUtils.createPartialApiKey(this.f1170a.b.b);
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
        return ((C0403lh) this.f1170a.k.a()).getRetryPolicyConfig();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final SSLSocketFactory getSslSocketFactory() {
        ((Bl) C0471oa.I.z()).getClass();
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
        M6 m6 = this.f1170a.e;
        m6.getClass();
        ArrayList arrayList = new ArrayList();
        m6.f584a.lock();
        try {
            SQLiteDatabase readableDatabase = m6.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(AbstractC0640v5.b, null);
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
                            m6.f584a.unlock();
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
                    C0418m7 c0418m7 = new C0418m7(new C0268gb(asString));
                    this.c = c0418m7;
                    this.o.c = c0418m7;
                } catch (Throwable unused3) {
                    C0418m7 c0418m72 = new C0418m7();
                    this.c = c0418m72;
                    this.o.c = c0418m72;
                }
            } else {
                C0418m7 c0418m73 = new C0418m7();
                this.c = c0418m73;
                this.o.c = c0418m73;
            }
            C0403lh config = this.q.getConfig();
            List list = config.w;
            if (mo.a((Collection) list)) {
                return false;
            }
            this.p.setHosts(config.q);
            if (config.u() && !mo.a((Collection) this.p.getAllHosts())) {
                this.f = null;
                C0627uh a2 = a(config);
                this.j = a2;
                if (a2.f1152a.isEmpty()) {
                    return false;
                }
                yo yoVar = this.m;
                synchronized (yoVar) {
                    optInt = yoVar.f1225a.a().optInt("report_request_id", -1);
                }
                int i = optInt + 1;
                this.u = i;
                this.o.e = i;
                C0369k9 a3 = a(this.j, list, config);
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
        C0240f9[] c0240f9Arr;
        String a2;
        if (z) {
            a(false);
        } else if (this.s.getResponseCode() == 400) {
            a(true);
        }
        if (z) {
            for (int i = 0; i < this.j.f1152a.size(); i++) {
                for (C0240f9 c0240f9 : ((C0292h9) this.j.f1152a.get(i)).c) {
                    if (c0240f9 != null && (a2 = Rf.a(c0240f9)) != null) {
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
        this.f1170a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onSuccessfulTaskFinished() {
        this.v = true;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskAdded() {
        ((C0391l5) this.f1170a.p).d.set(false);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskFinished() {
        this.f1170a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskRemoved() {
        ((C0391l5) this.f1170a.p).d.set(true);
        if (this.v) {
            ((C0391l5) this.f1170a.p).f();
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onUnsuccessfulTaskFinished() {
    }

    public C0652vh(Y4 y4, C0119ah c0119ah, C0746zb c0746zb, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, M6 m6, PublicLogger publicLogger, yo yoVar, RequestBodyEncrypter requestBodyEncrypter) {
        this(y4, publicLogger, m6, c0119ah, yoVar, c0746zb, new C0105a3(1024000, "event value in ReportTask", publicLogger), AbstractC0711y1.a(), fullUrlFormer, requestDataHolder, responseDataHolder, requestBodyEncrypter);
    }

    public C0652vh(Y4 y4, PublicLogger publicLogger, M6 m6, C0119ah c0119ah, yo yoVar, C0746zb c0746zb, C0105a3 c0105a3, Rj rj, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this.b = new LinkedHashMap();
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.v = false;
        this.t = new SendingDataTaskHelper(requestBodyEncrypter, new GZIPCompressor(), requestDataHolder, responseDataHolder, new DefaultNetworkResponseHandler());
        this.o = c0119ah;
        this.f1170a = y4;
        this.e = m6;
        this.l = publicLogger;
        this.k = c0105a3;
        this.m = yoVar;
        this.q = c0746zb;
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
                    z8.f775a = next;
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
            zo zoVar = yoVar.f1225a;
            zoVar.a(zoVar.a().put("report_request_id", i));
        }
        C0292h9[] c0292h9Arr = this.d.f973a;
        int i2 = 0;
        while (i2 < c0292h9Arr.length) {
            try {
                C0292h9 c0292h9 = c0292h9Arr[i2];
                long longValue = ((Long) this.f.get(i2)).longValue();
                Wk wk = (Wk) Qf.b.get(c0292h9.b.c);
                if (wk == null) {
                    wk = Wk.FOREGROUND;
                }
                z2 = z;
                try {
                    this.e.a(longValue, wk.f742a, c0292h9.c.length, z2);
                    Qf.a(c0292h9);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                z2 = z;
            }
            i2++;
            z = z2;
        }
        M6 m6 = this.e;
        long a2 = this.f1170a.j.a();
        m6.b.lock();
        try {
            if (AbstractC0690x5.f1195a.booleanValue()) {
                m6.d();
            }
            SQLiteDatabase writableDatabase = m6.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("sessions", AbstractC0640v5.c, new String[]{String.valueOf(a2)});
            }
        } catch (Throwable unused3) {
        }
        m6.b.unlock();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7 A[LOOP:1: B:44:0x00e1->B:46:0x00e7, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0627uh a(C0403lh c0403lh) {
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
                C0309i0 c0309i0 = null;
                while (a2.moveToNext() && this.h < 100) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(a2, contentValues);
                        C0592t7 model = new C0617u7(null, 1, null).toModel(contentValues);
                        Long l = model.f1130a;
                        if (l != null) {
                            C0567s7 c0567s7 = model.d;
                            C0343j9 a3 = Qf.a(c0567s7.f1115a, c0567s7.b, c0567s7.c);
                            String locale = c0403lh.getLocale();
                            Wk wk = model.b;
                            C0266g9 c0266g9 = new C0266g9();
                            c0266g9.f903a = a3;
                            c0266g9.b = locale;
                            if (wk != null) {
                                Integer num = (Integer) Qf.f650a.get(wk);
                                c0266g9.c = num != null ? num.intValue() : 0;
                            }
                            int computeUInt64Size = this.g + CodedOutputByteBufferNano.computeUInt64Size(1, Long.MAX_VALUE);
                            this.g = computeUInt64Size;
                            int computeMessageSize = computeUInt64Size + CodedOutputByteBufferNano.computeMessageSize(2, c0266g9);
                            this.g = computeMessageSize;
                            if (computeMessageSize >= 250880) {
                                break;
                            }
                            C0602th a4 = a(l.longValue(), c0266g9, c0403lh, arrayList3, arrayList.size());
                            if (a4 == null) {
                                continue;
                            } else {
                                if (c0309i0 == null) {
                                    c0309i0 = a4.b;
                                } else if (!c0309i0.equals(a4.b)) {
                                    break;
                                }
                                arrayList2.add(l);
                                arrayList.add(a4.f1135a);
                                if (!TextUtils.isEmpty(a4.b.f931a)) {
                                    try {
                                        jSONObject2 = new JSONObject(a4.b.f931a);
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
                            return new C0627uh(arrayList, arrayList2, jSONObject);
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
        return new C0627uh(arrayList, arrayList2, jSONObject);
    }

    public static C0309i0 a(ContentValues contentValues) {
        C0238f7 model = new C0264g7(null, 1, null).toModel(contentValues);
        return new C0309i0((String) WrapUtils.getOrDefault(model.g.g, ""), ((Long) WrapUtils.getOrDefault(model.g.h, 0L)).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[Catch: all -> 0x010c, TryCatch #4 {all -> 0x010c, blocks: (B:7:0x0025, B:8:0x002b, B:10:0x0032, B:12:0x0038, B:29:0x006c, B:31:0x0072, B:40:0x0094, B:45:0x00a5, B:47:0x00b4, B:54:0x00c0, B:53:0x00bf, B:50:0x00ba, B:55:0x00c6, B:58:0x00d8, B:61:0x00df, B:42:0x009d, B:64:0x00e7, B:26:0x0065, B:65:0x00f1, B:67:0x00f7), top: B:90:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0602th a(long j, C0266g9 c0266g9, C0403lh c0403lh, ArrayList arrayList, int i) {
        Cursor cursor;
        boolean z;
        C0602th c0602th;
        C0240f9 c0240f9;
        int i2;
        Z8[] a2;
        V8 v8;
        C0292h9 c0292h9 = new C0292h9();
        c0292h9.f921a = j;
        c0292h9.b = c0266g9;
        Wk wk = (Wk) Qf.b.get(c0266g9.c);
        if (wk == null) {
            wk = Wk.FOREGROUND;
        }
        try {
            cursor = a(j, wk);
            if (cursor != null) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    C0309i0 c0309i0 = null;
                    while (true) {
                        z = false;
                        if (!cursor.moveToNext() || this.h >= 100) {
                            break;
                        }
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(cursor, contentValues);
                        try {
                            O8 o8 = new O8(contentValues);
                            EnumC0165cb enumC0165cb = o8.h;
                            if (enumC0165cb != null) {
                                v8 = (V8) Qf.d.get(enumC0165cb);
                            } else {
                                Map map = Qf.f650a;
                                v8 = null;
                            }
                            if (v8 == null) {
                                v8 = V8.i;
                            }
                            try {
                                c0240f9 = v8.a(o8, c0403lh);
                            } catch (Throwable th) {
                                th = th;
                                arrayList.add(th);
                                c0240f9 = null;
                                if (c0240f9 == null) {
                                }
                                arrayList2.add(c0240f9);
                                this.h++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (c0240f9 == null) {
                            C0309i0 a3 = a(contentValues);
                            if (c0309i0 == null) {
                                if (this.i < 0) {
                                    try {
                                        a2 = a(new JSONObject(a3.f931a));
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
                                c0309i0 = a3;
                            } else if (!c0309i0.equals(a3)) {
                                z = true;
                                break;
                            }
                            C0105a3 c0105a3 = this.k;
                            byte[] bArr = c0240f9.e;
                            c0105a3.getClass();
                            byte[] a4 = c0105a3.a(bArr);
                            byte[] bArr2 = c0240f9.e;
                            if (bArr2 != a4) {
                                c0240f9.i = ((bArr2 == null ? 0 : bArr2.length) - (a4 == null ? 0 : a4.length)) + c0240f9.i;
                                c0240f9.e = a4;
                            }
                            this.g += CodedOutputByteBufferNano.computeMessageSize(3, c0240f9);
                            if (arrayList2.isEmpty() && i == 0) {
                                if (this.g >= 1048576) {
                                    break;
                                }
                            } else if (this.g >= 250880) {
                                break;
                            }
                        }
                        arrayList2.add(c0240f9);
                        this.h++;
                    }
                    if (arrayList2.size() > 0) {
                        c0292h9.c = (C0240f9[]) arrayList2.toArray(new C0240f9[arrayList2.size()]);
                        c0602th = new C0602th(c0292h9, c0309i0, z);
                        return c0602th;
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
            c0602th = null;
            return c0602th;
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
        m6.f584a.lock();
        try {
            readableDatabase = m6.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("sessions", null, M6.a(linkedHashMap), M6.a(new String[]{Long.toString(0L)}, linkedHashMap), null, null, "id ASC", null);
            m6.f584a.unlock();
            return cursor;
        }
        cursor = null;
        m6.f584a.unlock();
        return cursor;
    }

    public final Cursor a(long j, Wk wk) {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        M6 m6 = this.e;
        m6.f584a.lock();
        try {
            readableDatabase = m6.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("events", null, "session_id = ? AND session_type = ?", new String[]{Long.toString(j), Integer.toString(wk.f742a)}, null, null, "number_in_session ASC", null);
            m6.f584a.unlock();
            return cursor;
        }
        cursor = null;
        m6.f584a.unlock();
        return cursor;
    }
}
