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
/* loaded from: classes4.dex */
public final class Qh implements UnderlyingNetworkTask {

    /* renamed from: a  reason: collision with root package name */
    public final C0651v5 f636a;
    public final LinkedHashMap b;
    public L7 c;
    public J9 d;
    public final C0374k7 e;
    public List f;
    public int g;
    public int h;
    public int i;
    public Ph j;
    public final C0724y3 k;
    public final PublicLogger l;
    public final Do m;
    public final InterfaceC0557rb n;
    public final C0663vh o;
    public final FullUrlFormer p;
    public final Yb q;
    public final RequestDataHolder r;
    public final ResponseDataHolder s;
    public final SendingDataTaskHelper t;
    public int u;
    public boolean v;

    public Qh(C0651v5 c0651v5, C0663vh c0663vh, Yb yb, FullUrlFormer<Gh> fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this(c0651v5, c0663vh, yb, fullUrlFormer, requestDataHolder, responseDataHolder, c0651v5.i(), c0651v5.p(), c0651v5.u(), requestBodyEncrypter);
    }

    public final J9 a(Ph ph, List list, Gh gh) {
        J9 j9 = new J9();
        B9 b9 = new B9();
        b9.f362a = WrapUtils.getOrDefaultIfEmpty(this.c.b, gh.getUuid());
        b9.b = WrapUtils.getOrDefaultIfEmpty(this.c.f550a, gh.getDeviceId());
        this.g = CodedOutputByteBufferNano.computeMessageSize(4, b9) + this.g;
        j9.b = b9;
        C0644un A = Na.F.A();
        Nh nh = new Nh(this, j9);
        synchronized (A) {
            A.f1112a.a(nh);
        }
        j9.f510a = (G9[]) ph.f623a.toArray(new G9[0]);
        j9.c = a(ph.c);
        j9.e = (String[]) list.toArray(new String[0]);
        Set set = gh.x;
        String[] strArr = (String[]) set.toArray(new String[0]);
        j9.f = new byte[strArr.length];
        for (int i = 0; i < set.size(); i++) {
            j9.f[i] = StringUtils.getUTF8Bytes(strArr[i]);
        }
        return j9;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final String description() {
        return "ReportTask_" + ApiKeyUtils.createPartialApiKey(this.f636a.b.b);
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
        return ((Gh) this.f636a.k.a()).getRetryPolicyConfig();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final SSLSocketFactory getSslSocketFactory() {
        ((Jl) Na.F.y()).getClass();
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
        C0374k7 c0374k7 = this.f636a.e;
        c0374k7.getClass();
        ArrayList arrayList = new ArrayList();
        c0374k7.f946a.lock();
        try {
            SQLiteDatabase readableDatabase = c0374k7.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(T5.b, null);
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
                            ro.a(cursor);
                            c0374k7.f946a.unlock();
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
                    L7 l7 = new L7(new Fb(asString));
                    this.c = l7;
                    this.o.c = l7;
                } catch (Throwable unused3) {
                    L7 l72 = new L7();
                    this.c = l72;
                    this.o.c = l72;
                }
            } else {
                L7 l73 = new L7();
                this.c = l73;
                this.o.c = l73;
            }
            Gh config = this.q.getConfig();
            List list = config.w;
            if (ro.a((Collection) list)) {
                return false;
            }
            this.p.setHosts(config.q);
            if (config.u() && !ro.a((Collection) this.p.getAllHosts())) {
                this.f = null;
                Ph a2 = a(config);
                this.j = a2;
                if (a2.f623a.isEmpty()) {
                    return false;
                }
                Do r2 = this.m;
                synchronized (r2) {
                    optInt = r2.f413a.a().optInt("report_request_id", -1);
                }
                int i = optInt + 1;
                this.u = i;
                this.o.e = i;
                J9 a3 = a(this.j, list, config);
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
        E9[] e9Arr;
        String a2;
        if (z) {
            a(false);
        } else if (this.s.getResponseCode() == 400) {
            a(true);
        }
        if (z) {
            for (int i = 0; i < this.j.f623a.size(); i++) {
                for (E9 e9 : ((G9) this.j.f623a.get(i)).c) {
                    if (e9 != null && (a2 = AbstractC0435mg.a(e9)) != null) {
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
        this.f636a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onSuccessfulTaskFinished() {
        this.v = true;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskAdded() {
        ((I5) this.f636a.p).d.set(false);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskFinished() {
        this.f636a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskRemoved() {
        ((I5) this.f636a.p).d.set(true);
        if (this.v) {
            ((I5) this.f636a.p).f();
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onUnsuccessfulTaskFinished() {
    }

    public Qh(C0651v5 c0651v5, C0663vh c0663vh, Yb yb, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, C0374k7 c0374k7, PublicLogger publicLogger, Do r22, RequestBodyEncrypter requestBodyEncrypter) {
        this(c0651v5, publicLogger, c0374k7, c0663vh, r22, yb, new C0724y3(1024000, "event value in ReportTask", publicLogger), AbstractC0647v1.a(), fullUrlFormer, requestDataHolder, responseDataHolder, requestBodyEncrypter);
    }

    public Qh(C0651v5 c0651v5, PublicLogger publicLogger, C0374k7 c0374k7, C0663vh c0663vh, Do r13, Yb yb, C0724y3 c0724y3, C0413lk c0413lk, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this.b = new LinkedHashMap();
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.v = false;
        this.t = new SendingDataTaskHelper(requestBodyEncrypter, new GZIPCompressor(), requestDataHolder, responseDataHolder, new DefaultNetworkResponseHandler());
        this.o = c0663vh;
        this.f636a = c0651v5;
        this.e = c0374k7;
        this.l = publicLogger;
        this.k = c0724y3;
        this.m = r13;
        this.q = yb;
        this.n = c0413lk;
        this.r = requestDataHolder;
        this.s = responseDataHolder;
        this.p = fullUrlFormer;
    }

    public static C0730y9[] a(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length > 0) {
            C0730y9[] c0730y9Arr = new C0730y9[length];
            Iterator<String> keys = jSONObject.keys();
            int i = 0;
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    C0730y9 c0730y9 = new C0730y9();
                    c0730y9.f1164a = next;
                    c0730y9.b = jSONObject.getString(next);
                    c0730y9Arr[i] = c0730y9;
                } catch (Throwable unused) {
                }
                i++;
            }
            return c0730y9Arr;
        }
        return null;
    }

    public final void a(boolean z) {
        boolean z2;
        Do r1 = this.m;
        int i = this.u;
        synchronized (r1) {
            Eo eo = r1.f413a;
            eo.a(eo.a().put("report_request_id", i));
        }
        G9[] g9Arr = this.d.f510a;
        int i2 = 0;
        while (i2 < g9Arr.length) {
            try {
                G9 g9 = g9Arr[i2];
                long longValue = ((Long) this.f.get(i2)).longValue();
                EnumC0259fl enumC0259fl = (EnumC0259fl) AbstractC0409lg.b.get(g9.b.c);
                if (enumC0259fl == null) {
                    enumC0259fl = EnumC0259fl.FOREGROUND;
                }
                z2 = z;
                try {
                    this.e.a(longValue, enumC0259fl.f879a, g9.c.length, z2);
                    AbstractC0409lg.a(g9);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                z2 = z;
            }
            i2++;
            z = z2;
        }
        C0374k7 c0374k7 = this.e;
        long a2 = this.f636a.j.a();
        c0374k7.b.lock();
        try {
            if (V5.f706a.booleanValue()) {
                c0374k7.d();
            }
            SQLiteDatabase writableDatabase = c0374k7.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("sessions", T5.c, new String[]{String.valueOf(a2)});
            }
        } catch (Throwable unused3) {
        }
        c0374k7.b.unlock();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7 A[LOOP:1: B:44:0x00e1->B:46:0x00e7, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Ph a(Gh gh) {
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
                C0290h0 c0290h0 = null;
                while (a2.moveToNext() && this.h < 100) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(a2, contentValues);
                        S7 model = new T7(null, 1, null).toModel(contentValues);
                        Long l = model.f663a;
                        if (l != null) {
                            R7 r7 = model.d;
                            I9 a3 = AbstractC0409lg.a(r7.f647a, r7.b, r7.c);
                            String locale = gh.getLocale();
                            EnumC0259fl enumC0259fl = model.b;
                            F9 f9 = new F9();
                            f9.f438a = a3;
                            f9.b = locale;
                            if (enumC0259fl != null) {
                                Integer num = (Integer) AbstractC0409lg.f969a.get(enumC0259fl);
                                f9.c = num != null ? num.intValue() : 0;
                            }
                            int computeUInt64Size = this.g + CodedOutputByteBufferNano.computeUInt64Size(1, Long.MAX_VALUE);
                            this.g = computeUInt64Size;
                            int computeMessageSize = computeUInt64Size + CodedOutputByteBufferNano.computeMessageSize(2, f9);
                            this.g = computeMessageSize;
                            if (computeMessageSize >= 250880) {
                                break;
                            }
                            Oh a4 = a(l.longValue(), f9, gh, arrayList3, arrayList.size());
                            if (a4 == null) {
                                continue;
                            } else {
                                if (c0290h0 == null) {
                                    c0290h0 = a4.b;
                                } else if (!c0290h0.equals(a4.b)) {
                                    break;
                                }
                                arrayList2.add(l);
                                arrayList.add(a4.f607a);
                                if (!TextUtils.isEmpty(a4.b.f898a)) {
                                    try {
                                        jSONObject2 = new JSONObject(a4.b.f898a);
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
                            return new Ph(arrayList, arrayList2, jSONObject);
                        } finally {
                            ro.a(cursor);
                        }
                    }
                }
                jSONObject = jSONObject2;
            }
            ro.a(a2);
        } catch (Throwable th2) {
            th = th2;
        }
        it = arrayList3.iterator();
        while (it.hasNext()) {
            this.n.reportError("protobuf_serialization_error", (Throwable) it.next());
        }
        return new Ph(arrayList, arrayList2, jSONObject);
    }

    public static C0290h0 a(ContentValues contentValues) {
        E7 model = new F7(null, 1, null).toModel(contentValues);
        return new C0290h0((String) WrapUtils.getOrDefault(model.g.g, ""), ((Long) WrapUtils.getOrDefault(model.g.h, 0L)).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[Catch: all -> 0x010c, TryCatch #4 {all -> 0x010c, blocks: (B:7:0x0025, B:8:0x002b, B:10:0x0032, B:12:0x0038, B:29:0x006c, B:31:0x0072, B:40:0x0094, B:45:0x00a5, B:47:0x00b4, B:54:0x00c0, B:53:0x00bf, B:50:0x00ba, B:55:0x00c6, B:58:0x00d8, B:61:0x00df, B:42:0x009d, B:64:0x00e7, B:26:0x0065, B:65:0x00f1, B:67:0x00f7), top: B:90:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Oh a(long j, F9 f9, Gh gh, ArrayList arrayList, int i) {
        Cursor cursor;
        boolean z;
        Oh oh;
        E9 e9;
        int i2;
        C0730y9[] a2;
        C0630u9 c0630u9;
        G9 g9 = new G9();
        g9.f454a = j;
        g9.b = f9;
        EnumC0259fl enumC0259fl = (EnumC0259fl) AbstractC0409lg.b.get(f9.c);
        if (enumC0259fl == null) {
            enumC0259fl = EnumC0259fl.FOREGROUND;
        }
        try {
            cursor = a(j, enumC0259fl);
            if (cursor != null) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    C0290h0 c0290h0 = null;
                    while (true) {
                        z = false;
                        if (!cursor.moveToNext() || this.h >= 100) {
                            break;
                        }
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(cursor, contentValues);
                        try {
                            C0402l9 c0402l9 = new C0402l9(contentValues);
                            Bb bb = c0402l9.h;
                            if (bb != null) {
                                c0630u9 = (C0630u9) AbstractC0409lg.d.get(bb);
                            } else {
                                Map map = AbstractC0409lg.f969a;
                                c0630u9 = null;
                            }
                            if (c0630u9 == null) {
                                c0630u9 = C0630u9.i;
                            }
                            try {
                                e9 = c0630u9.a(c0402l9, gh);
                            } catch (Throwable th) {
                                th = th;
                                arrayList.add(th);
                                e9 = null;
                                if (e9 == null) {
                                }
                                arrayList2.add(e9);
                                this.h++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (e9 == null) {
                            C0290h0 a3 = a(contentValues);
                            if (c0290h0 == null) {
                                if (this.i < 0) {
                                    try {
                                        a2 = a(new JSONObject(a3.f898a));
                                    } catch (Throwable unused) {
                                    }
                                    if (a2 != null) {
                                        i2 = 0;
                                        for (C0730y9 c0730y9 : a2) {
                                            i2 += CodedOutputByteBufferNano.computeMessageSize(7, c0730y9);
                                        }
                                        this.i = i2;
                                        this.g += i2;
                                    }
                                    i2 = 0;
                                    this.i = i2;
                                    this.g += i2;
                                }
                                c0290h0 = a3;
                            } else if (!c0290h0.equals(a3)) {
                                z = true;
                                break;
                            }
                            C0724y3 c0724y3 = this.k;
                            byte[] bArr = e9.e;
                            c0724y3.getClass();
                            byte[] a4 = c0724y3.a(bArr);
                            byte[] bArr2 = e9.e;
                            if (bArr2 != a4) {
                                e9.i = ((bArr2 == null ? 0 : bArr2.length) - (a4 == null ? 0 : a4.length)) + e9.i;
                                e9.e = a4;
                            }
                            this.g += CodedOutputByteBufferNano.computeMessageSize(3, e9);
                            if (arrayList2.isEmpty() && i == 0) {
                                if (this.g >= 1048576) {
                                    break;
                                }
                            } else if (this.g >= 250880) {
                                break;
                            }
                        }
                        arrayList2.add(e9);
                        this.h++;
                    }
                    if (arrayList2.size() > 0) {
                        g9.c = (E9[]) arrayList2.toArray(new E9[arrayList2.size()]);
                        oh = new Oh(g9, c0290h0, z);
                        return oh;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        arrayList.add(th);
                        ro.a(cursor);
                        return null;
                    } finally {
                        ro.a(cursor);
                    }
                }
            }
            oh = null;
            return oh;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
    }

    public final Cursor a() {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        C0374k7 c0374k7 = this.e;
        LinkedHashMap linkedHashMap = this.b;
        c0374k7.f946a.lock();
        try {
            readableDatabase = c0374k7.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("sessions", null, C0374k7.a(linkedHashMap), C0374k7.a(new String[]{Long.toString(0L)}, linkedHashMap), null, null, "id ASC", null);
            c0374k7.f946a.unlock();
            return cursor;
        }
        cursor = null;
        c0374k7.f946a.unlock();
        return cursor;
    }

    public final Cursor a(long j, EnumC0259fl enumC0259fl) {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        C0374k7 c0374k7 = this.e;
        c0374k7.f946a.lock();
        try {
            readableDatabase = c0374k7.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("events", null, "session_id = ? AND session_type = ?", new String[]{Long.toString(j), Integer.toString(enumC0259fl.f879a)}, null, null, "number_in_session ASC", null);
            c0374k7.f946a.unlock();
            return cursor;
        }
        cursor = null;
        c0374k7.f946a.unlock();
        return cursor;
    }
}
