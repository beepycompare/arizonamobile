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
/* renamed from: io.appmetrica.analytics.impl.zh  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0752zh implements UnderlyingNetworkTask {

    /* renamed from: a  reason: collision with root package name */
    public final C0210e5 f1232a;
    public final LinkedHashMap b;
    public C0592t7 c;
    public C0520q9 d;
    public final S6 e;
    public List f;
    public int g;
    public int h;
    public int i;
    public C0727yh j;
    public final C0286h3 k;
    public final PublicLogger l;
    public final zo m;
    public final Ya n;
    public final C0222eh o;
    public final FullUrlFormer p;
    public final Fb q;
    public final RequestDataHolder r;
    public final ResponseDataHolder s;
    public final SendingDataTaskHelper t;
    public int u;
    public boolean v;

    public C0752zh(C0210e5 c0210e5, C0222eh c0222eh, Fb fb, FullUrlFormer<C0503ph> fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this(c0210e5, c0222eh, fb, fullUrlFormer, requestDataHolder, responseDataHolder, c0210e5.i(), c0210e5.p(), c0210e5.u(), requestBodyEncrypter);
    }

    public final C0520q9 a(C0727yh c0727yh, List list, C0503ph c0503ph) {
        C0520q9 c0520q9 = new C0520q9();
        C0318i9 c0318i9 = new C0318i9();
        c0318i9.f929a = WrapUtils.getOrDefaultIfEmpty(this.c.b, c0503ph.getUuid());
        c0318i9.b = WrapUtils.getOrDefaultIfEmpty(this.c.f1128a, c0503ph.getDeviceId());
        this.g = CodedOutputByteBufferNano.computeMessageSize(4, c0318i9) + this.g;
        c0520q9.b = c0318i9;
        C0534qn C = C0620ua.H.C();
        C0677wh c0677wh = new C0677wh(this, c0520q9);
        synchronized (C) {
            C.f1081a.a(c0677wh);
        }
        c0520q9.f1070a = (C0445n9[]) c0727yh.f1217a.toArray(new C0445n9[0]);
        c0520q9.c = a(c0727yh.c);
        c0520q9.e = (String[]) list.toArray(new String[0]);
        Set set = c0503ph.x;
        String[] strArr = (String[]) set.toArray(new String[0]);
        c0520q9.f = new byte[strArr.length];
        for (int i = 0; i < set.size(); i++) {
            c0520q9.f[i] = StringUtils.getUTF8Bytes(strArr[i]);
        }
        return c0520q9;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final String description() {
        return "ReportTask_" + ApiKeyUtils.createPartialApiKey(this.f1232a.b.b);
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
        return ((C0503ph) this.f1232a.k.a()).getRetryPolicyConfig();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final SSLSocketFactory getSslSocketFactory() {
        ((El) C0620ua.H.A()).getClass();
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
        S6 s6 = this.f1232a.e;
        s6.getClass();
        ArrayList arrayList = new ArrayList();
        s6.f678a.lock();
        try {
            SQLiteDatabase readableDatabase = s6.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(B5.b, null);
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
                            no.a(cursor);
                            s6.f678a.unlock();
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
                    C0592t7 c0592t7 = new C0592t7(new C0422mb(asString));
                    this.c = c0592t7;
                    this.o.c = c0592t7;
                } catch (Throwable unused3) {
                    C0592t7 c0592t72 = new C0592t7();
                    this.c = c0592t72;
                    this.o.c = c0592t72;
                }
            } else {
                C0592t7 c0592t73 = new C0592t7();
                this.c = c0592t73;
                this.o.c = c0592t73;
            }
            C0503ph config = this.q.getConfig();
            List list = config.w;
            if (no.a((Collection) list)) {
                return false;
            }
            this.p.setHosts(config.q);
            if (config.u() && !no.a((Collection) this.p.getAllHosts())) {
                this.f = null;
                C0727yh a2 = a(config);
                this.j = a2;
                if (a2.f1217a.isEmpty()) {
                    return false;
                }
                zo zoVar = this.m;
                synchronized (zoVar) {
                    optInt = zoVar.f1238a.a().optInt("report_request_id", -1);
                }
                int i = optInt + 1;
                this.u = i;
                this.o.e = i;
                C0520q9 a3 = a(this.j, list, config);
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
        C0395l9[] c0395l9Arr;
        String a2;
        if (z) {
            a(false);
        } else if (this.s.getResponseCode() == 400) {
            a(true);
        }
        if (z) {
            for (int i = 0; i < this.j.f1217a.size(); i++) {
                for (C0395l9 c0395l9 : ((C0445n9) this.j.f1217a.get(i)).c) {
                    if (c0395l9 != null && (a2 = Vf.a(c0395l9)) != null) {
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
        this.f1232a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onSuccessfulTaskFinished() {
        this.v = true;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskAdded() {
        ((C0540r5) this.f1232a.p).d.set(false);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskFinished() {
        this.f1232a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskRemoved() {
        ((C0540r5) this.f1232a.p).d.set(true);
        if (this.v) {
            ((C0540r5) this.f1232a.p).f();
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onUnsuccessfulTaskFinished() {
    }

    public C0752zh(C0210e5 c0210e5, C0222eh c0222eh, Fb fb, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, S6 s6, PublicLogger publicLogger, zo zoVar, RequestBodyEncrypter requestBodyEncrypter) {
        this(c0210e5, publicLogger, s6, c0222eh, zoVar, fb, new C0286h3(1024000, "event value in ReportTask", publicLogger), AbstractC0661w1.a(), fullUrlFormer, requestDataHolder, responseDataHolder, requestBodyEncrypter);
    }

    public C0752zh(C0210e5 c0210e5, PublicLogger publicLogger, S6 s6, C0222eh c0222eh, zo zoVar, Fb fb, C0286h3 c0286h3, Vj vj, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this.b = new LinkedHashMap();
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.v = false;
        this.t = new SendingDataTaskHelper(requestBodyEncrypter, new GZIPCompressor(), requestDataHolder, responseDataHolder, new DefaultNetworkResponseHandler());
        this.o = c0222eh;
        this.f1232a = c0210e5;
        this.e = s6;
        this.l = publicLogger;
        this.k = c0286h3;
        this.m = zoVar;
        this.q = fb;
        this.n = vj;
        this.r = requestDataHolder;
        this.s = responseDataHolder;
        this.p = fullUrlFormer;
    }

    public static C0240f9[] a(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length > 0) {
            C0240f9[] c0240f9Arr = new C0240f9[length];
            Iterator<String> keys = jSONObject.keys();
            int i = 0;
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    C0240f9 c0240f9 = new C0240f9();
                    c0240f9.f873a = next;
                    c0240f9.b = jSONObject.getString(next);
                    c0240f9Arr[i] = c0240f9;
                } catch (Throwable unused) {
                }
                i++;
            }
            return c0240f9Arr;
        }
        return null;
    }

    public final void a(boolean z) {
        boolean z2;
        zo zoVar = this.m;
        int i = this.u;
        synchronized (zoVar) {
            Ao ao = zoVar.f1238a;
            ao.a(ao.a().put("report_request_id", i));
        }
        C0445n9[] c0445n9Arr = this.d.f1070a;
        int i2 = 0;
        while (i2 < c0445n9Arr.length) {
            try {
                C0445n9 c0445n9 = c0445n9Arr[i2];
                long longValue = ((Long) this.f.get(i2)).longValue();
                EnumC0123al enumC0123al = (EnumC0123al) Uf.b.get(c0445n9.b.c);
                if (enumC0123al == null) {
                    enumC0123al = EnumC0123al.FOREGROUND;
                }
                z2 = z;
                try {
                    this.e.a(longValue, enumC0123al.f805a, c0445n9.c.length, z2);
                    Uf.a(c0445n9);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                z2 = z;
            }
            i2++;
            z = z2;
        }
        S6 s6 = this.e;
        long a2 = this.f1232a.j.a();
        s6.b.lock();
        try {
            if (D5.f437a.booleanValue()) {
                s6.d();
            }
            SQLiteDatabase writableDatabase = s6.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("sessions", B5.c, new String[]{String.valueOf(a2)});
            }
        } catch (Throwable unused3) {
        }
        s6.b.unlock();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7 A[LOOP:1: B:44:0x00e1->B:46:0x00e7, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0727yh a(C0503ph c0503ph) {
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
                        A7 model = new B7(null, 1, null).toModel(contentValues);
                        Long l = model.f392a;
                        if (l != null) {
                            C0742z7 c0742z7 = model.d;
                            C0495p9 a3 = Uf.a(c0742z7.f1226a, c0742z7.b, c0742z7.c);
                            String locale = c0503ph.getLocale();
                            EnumC0123al enumC0123al = model.b;
                            C0420m9 c0420m9 = new C0420m9();
                            c0420m9.f1006a = a3;
                            c0420m9.b = locale;
                            if (enumC0123al != null) {
                                Integer num = (Integer) Uf.f719a.get(enumC0123al);
                                c0420m9.c = num != null ? num.intValue() : 0;
                            }
                            int computeUInt64Size = this.g + CodedOutputByteBufferNano.computeUInt64Size(1, Long.MAX_VALUE);
                            this.g = computeUInt64Size;
                            int computeMessageSize = computeUInt64Size + CodedOutputByteBufferNano.computeMessageSize(2, c0420m9);
                            this.g = computeMessageSize;
                            if (computeMessageSize >= 250880) {
                                break;
                            }
                            C0702xh a4 = a(l.longValue(), c0420m9, c0503ph, arrayList3, arrayList.size());
                            if (a4 == null) {
                                continue;
                            } else {
                                if (c0309i0 == null) {
                                    c0309i0 = a4.b;
                                } else if (!c0309i0.equals(a4.b)) {
                                    break;
                                }
                                arrayList2.add(l);
                                arrayList.add(a4.f1202a);
                                if (!TextUtils.isEmpty(a4.b.f920a)) {
                                    try {
                                        jSONObject2 = new JSONObject(a4.b.f920a);
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
                            return new C0727yh(arrayList, arrayList2, jSONObject);
                        } finally {
                            no.a(cursor);
                        }
                    }
                }
                jSONObject = jSONObject2;
            }
            no.a(a2);
        } catch (Throwable th2) {
            th = th2;
        }
        it = arrayList3.iterator();
        while (it.hasNext()) {
            this.n.reportError("protobuf_serialization_error", (Throwable) it.next());
        }
        return new C0727yh(arrayList, arrayList2, jSONObject);
    }

    public static C0309i0 a(ContentValues contentValues) {
        C0418m7 model = new C0443n7(null, 1, null).toModel(contentValues);
        return new C0309i0((String) WrapUtils.getOrDefault(model.g.g, ""), ((Long) WrapUtils.getOrDefault(model.g.h, 0L)).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[Catch: all -> 0x010c, TryCatch #4 {all -> 0x010c, blocks: (B:7:0x0025, B:8:0x002b, B:10:0x0032, B:12:0x0038, B:29:0x006c, B:31:0x0072, B:40:0x0094, B:45:0x00a5, B:47:0x00b4, B:54:0x00c0, B:53:0x00bf, B:50:0x00ba, B:55:0x00c6, B:58:0x00d8, B:61:0x00df, B:42:0x009d, B:64:0x00e7, B:26:0x0065, B:65:0x00f1, B:67:0x00f7), top: B:90:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0702xh a(long j, C0420m9 c0420m9, C0503ph c0503ph, ArrayList arrayList, int i) {
        Cursor cursor;
        boolean z;
        C0702xh c0702xh;
        C0395l9 c0395l9;
        int i2;
        C0240f9[] a2;
        C0137b9 c0137b9;
        C0445n9 c0445n9 = new C0445n9();
        c0445n9.f1023a = j;
        c0445n9.b = c0420m9;
        EnumC0123al enumC0123al = (EnumC0123al) Uf.b.get(c0420m9.c);
        if (enumC0123al == null) {
            enumC0123al = EnumC0123al.FOREGROUND;
        }
        try {
            cursor = a(j, enumC0123al);
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
                            S8 s8 = new S8(contentValues);
                            EnumC0320ib enumC0320ib = s8.h;
                            if (enumC0320ib != null) {
                                c0137b9 = (C0137b9) Uf.d.get(enumC0320ib);
                            } else {
                                Map map = Uf.f719a;
                                c0137b9 = null;
                            }
                            if (c0137b9 == null) {
                                c0137b9 = C0137b9.i;
                            }
                            try {
                                c0395l9 = c0137b9.a(s8, c0503ph);
                            } catch (Throwable th) {
                                th = th;
                                arrayList.add(th);
                                c0395l9 = null;
                                if (c0395l9 == null) {
                                }
                                arrayList2.add(c0395l9);
                                this.h++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (c0395l9 == null) {
                            C0309i0 a3 = a(contentValues);
                            if (c0309i0 == null) {
                                if (this.i < 0) {
                                    try {
                                        a2 = a(new JSONObject(a3.f920a));
                                    } catch (Throwable unused) {
                                    }
                                    if (a2 != null) {
                                        i2 = 0;
                                        for (C0240f9 c0240f9 : a2) {
                                            i2 += CodedOutputByteBufferNano.computeMessageSize(7, c0240f9);
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
                            C0286h3 c0286h3 = this.k;
                            byte[] bArr = c0395l9.e;
                            c0286h3.getClass();
                            byte[] a4 = c0286h3.a(bArr);
                            byte[] bArr2 = c0395l9.e;
                            if (bArr2 != a4) {
                                c0395l9.i = ((bArr2 == null ? 0 : bArr2.length) - (a4 == null ? 0 : a4.length)) + c0395l9.i;
                                c0395l9.e = a4;
                            }
                            this.g += CodedOutputByteBufferNano.computeMessageSize(3, c0395l9);
                            if (arrayList2.isEmpty() && i == 0) {
                                if (this.g >= 1048576) {
                                    break;
                                }
                            } else if (this.g >= 250880) {
                                break;
                            }
                        }
                        arrayList2.add(c0395l9);
                        this.h++;
                    }
                    if (arrayList2.size() > 0) {
                        c0445n9.c = (C0395l9[]) arrayList2.toArray(new C0395l9[arrayList2.size()]);
                        c0702xh = new C0702xh(c0445n9, c0309i0, z);
                        return c0702xh;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        arrayList.add(th);
                        no.a(cursor);
                        return null;
                    } finally {
                        no.a(cursor);
                    }
                }
            }
            c0702xh = null;
            return c0702xh;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
    }

    public final Cursor a() {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        S6 s6 = this.e;
        LinkedHashMap linkedHashMap = this.b;
        s6.f678a.lock();
        try {
            readableDatabase = s6.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("sessions", null, S6.a(linkedHashMap), S6.a(new String[]{Long.toString(0L)}, linkedHashMap), null, null, "id ASC", null);
            s6.f678a.unlock();
            return cursor;
        }
        cursor = null;
        s6.f678a.unlock();
        return cursor;
    }

    public final Cursor a(long j, EnumC0123al enumC0123al) {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        S6 s6 = this.e;
        s6.f678a.lock();
        try {
            readableDatabase = s6.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("events", null, "session_id = ? AND session_type = ?", new String[]{Long.toString(j), Integer.toString(enumC0123al.f805a)}, null, null, "number_in_session ASC", null);
            s6.f678a.unlock();
            return cursor;
        }
        cursor = null;
        s6.f678a.unlock();
        return cursor;
    }
}
