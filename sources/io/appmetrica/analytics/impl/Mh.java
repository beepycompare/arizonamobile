package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import io.appmetrica.analytics.coreutils.internal.ApiKeyUtils;
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
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class Mh implements UnderlyingNetworkTask {

    /* renamed from: a  reason: collision with root package name */
    public final C0572s5 f561a;
    public final LinkedHashMap b;
    public I7 c;
    public G9 d;
    public final C0297h7 e;
    public List f;
    public int g;
    public int h;
    public int i;
    public Lh j;
    public final C0645v3 k;
    public final PublicLogger l;
    public final zo m;
    public final InterfaceC0479ob n;
    public final C0559rh o;
    public final FullUrlFormer p;
    public final Vb q;
    public final RequestDataHolder r;
    public final ResponseDataHolder s;
    public final SendingDataTaskHelper t;
    public int u;
    public boolean v;

    public Mh(C0572s5 c0572s5, C0559rh c0559rh, Vb vb, FullUrlFormer<Ch> fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this(c0572s5, c0559rh, vb, fullUrlFormer, requestDataHolder, responseDataHolder, c0572s5.h(), c0572s5.o(), c0572s5.t(), requestBodyEncrypter);
    }

    public final G9 a(Lh lh, List list, Ch ch) {
        G9 g9 = new G9();
        C0726y9 c0726y9 = new C0726y9();
        c0726y9.f1155a = WrapUtils.getOrDefaultIfEmpty(this.c.b, ch.getUuid());
        c0726y9.b = WrapUtils.getOrDefaultIfEmpty(this.c.f492a, ch.getDeviceId());
        this.g = CodedOutputByteBufferNano.computeMessageSize(4, c0726y9) + this.g;
        g9.b = c0726y9;
        C0541qn A = Ka.F.A();
        Jh jh = new Jh(this, g9);
        synchronized (A) {
            A.f1032a.a(jh);
        }
        List list2 = lh.f546a;
        g9.f453a = (D9[]) list2.toArray(new D9[list2.size()]);
        g9.c = a(lh.c);
        g9.e = (String[]) list.toArray(new String[list.size()]);
        this.g = CodedOutputByteBufferNano.computeTagSize(8) + this.g;
        return g9;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final String description() {
        return "ReportTask_" + ApiKeyUtils.createPartialApiKey(this.f561a.b.b);
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
        return ((Ch) this.f561a.k.a()).getRetryPolicyConfig();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final SSLSocketFactory getSslSocketFactory() {
        ((Fl) Ka.F.y()).getClass();
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
        C0297h7 c0297h7 = this.f561a.e;
        c0297h7.getClass();
        ArrayList arrayList = new ArrayList();
        c0297h7.f883a.lock();
        try {
            SQLiteDatabase readableDatabase = c0297h7.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(Q5.b, null);
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
                            c0297h7.f883a.unlock();
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
                    I7 i7 = new I7(new Cb(asString));
                    this.c = i7;
                    this.o.c = i7;
                } catch (Throwable unused3) {
                    I7 i72 = new I7();
                    this.c = i72;
                    this.o.c = i72;
                }
            } else {
                I7 i73 = new I7();
                this.c = i73;
                this.o.c = i73;
            }
            Ch config = this.q.getConfig();
            List list = config.w;
            if (no.a((Collection) list)) {
                return false;
            }
            this.p.setHosts(config.q);
            if (config.t() && !no.a((Collection) this.p.getAllHosts())) {
                this.f = null;
                Lh a2 = a(config);
                this.j = a2;
                if (a2.f546a.isEmpty()) {
                    return false;
                }
                zo zoVar = this.m;
                synchronized (zoVar) {
                    optInt = zoVar.f1187a.a().optInt("report_request_id", -1);
                }
                int i = optInt + 1;
                this.u = i;
                this.o.e = i;
                G9 a3 = a(this.j, list, config);
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
        B9[] b9Arr;
        String a2;
        if (z) {
            a(false);
        } else if (this.s.getResponseCode() == 400) {
            a(true);
        }
        if (z) {
            for (int i = 0; i < this.j.f546a.size(); i++) {
                for (B9 b9 : ((D9) this.j.f546a.get(i)).c) {
                    if (b9 != null && (a2 = AbstractC0331ig.a(b9)) != null) {
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
        this.f561a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onSuccessfulTaskFinished() {
        this.v = true;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskAdded() {
        ((F5) this.f561a.p).d.set(false);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskFinished() {
        this.f561a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskRemoved() {
        ((F5) this.f561a.p).d.set(true);
        if (this.v) {
            ((F5) this.f561a.p).f();
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onUnsuccessfulTaskFinished() {
    }

    public Mh(C0572s5 c0572s5, C0559rh c0559rh, Vb vb, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, C0297h7 c0297h7, PublicLogger publicLogger, zo zoVar, RequestBodyEncrypter requestBodyEncrypter) {
        this(c0572s5, publicLogger, c0297h7, c0559rh, zoVar, vb, new C0645v3(1024000, "event value in ReportTask", publicLogger), AbstractC0593t1.a(), fullUrlFormer, requestDataHolder, responseDataHolder, requestBodyEncrypter);
    }

    public Mh(C0572s5 c0572s5, PublicLogger publicLogger, C0297h7 c0297h7, C0559rh c0559rh, zo zoVar, Vb vb, C0645v3 c0645v3, C0310hk c0310hk, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this.b = new LinkedHashMap();
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.v = false;
        this.t = new SendingDataTaskHelper(requestBodyEncrypter, new GZIPCompressor(), requestDataHolder, responseDataHolder, new DefaultNetworkResponseHandler());
        this.o = c0559rh;
        this.f561a = c0572s5;
        this.e = c0297h7;
        this.l = publicLogger;
        this.k = c0645v3;
        this.m = zoVar;
        this.q = vb;
        this.n = c0310hk;
        this.r = requestDataHolder;
        this.s = responseDataHolder;
        this.p = fullUrlFormer;
    }

    public static C0651v9[] a(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length > 0) {
            C0651v9[] c0651v9Arr = new C0651v9[length];
            Iterator<String> keys = jSONObject.keys();
            int i = 0;
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    C0651v9 c0651v9 = new C0651v9();
                    c0651v9.f1101a = next;
                    c0651v9.b = jSONObject.getString(next);
                    c0651v9Arr[i] = c0651v9;
                } catch (Throwable unused) {
                }
                i++;
            }
            return c0651v9Arr;
        }
        return null;
    }

    public final void a(boolean z) {
        boolean z2;
        zo zoVar = this.m;
        int i = this.u;
        synchronized (zoVar) {
            Ao ao = zoVar.f1187a;
            ao.a(ao.a().put("report_request_id", i));
        }
        D9[] d9Arr = this.d.f453a;
        int i2 = 0;
        while (i2 < d9Arr.length) {
            try {
                D9 d9 = d9Arr[i2];
                long longValue = ((Long) this.f.get(i2)).longValue();
                EnumC0156bl enumC0156bl = (EnumC0156bl) AbstractC0306hg.b.get(d9.b.c);
                if (enumC0156bl == null) {
                    enumC0156bl = EnumC0156bl.FOREGROUND;
                }
                z2 = z;
                try {
                    this.e.a(longValue, enumC0156bl.f799a, d9.c.length, z2);
                    AbstractC0306hg.a(d9);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                z2 = z;
            }
            i2++;
            z = z2;
        }
        C0297h7 c0297h7 = this.e;
        long a2 = this.f561a.j.a();
        c0297h7.b.lock();
        try {
            if (S5.f647a.booleanValue()) {
                c0297h7.d();
            }
            SQLiteDatabase writableDatabase = c0297h7.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("sessions", Q5.c, new String[]{String.valueOf(a2)});
            }
        } catch (Throwable unused3) {
        }
        c0297h7.b.unlock();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7 A[LOOP:1: B:44:0x00e1->B:46:0x00e7, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Lh a(Ch ch) {
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
                C0264g0 c0264g0 = null;
                while (a2.moveToNext() && this.h < 100) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(a2, contentValues);
                        P7 model = new Q7(null, 1, null).toModel(contentValues);
                        Long l = model.f601a;
                        if (l != null) {
                            O7 o7 = model.d;
                            F9 a3 = AbstractC0306hg.a(o7.f587a, o7.b, o7.c);
                            String locale = ch.getLocale();
                            EnumC0156bl enumC0156bl = model.b;
                            C9 c9 = new C9();
                            c9.f378a = a3;
                            c9.b = locale;
                            if (enumC0156bl != null) {
                                Integer num = (Integer) AbstractC0306hg.f889a.get(enumC0156bl);
                                c9.c = num != null ? num.intValue() : 0;
                            }
                            int computeUInt64Size = this.g + CodedOutputByteBufferNano.computeUInt64Size(1, Long.MAX_VALUE);
                            this.g = computeUInt64Size;
                            int computeMessageSize = computeUInt64Size + CodedOutputByteBufferNano.computeMessageSize(2, c9);
                            this.g = computeMessageSize;
                            if (computeMessageSize >= 250880) {
                                break;
                            }
                            Kh a4 = a(l.longValue(), c9, ch, arrayList3, arrayList.size());
                            if (a4 == null) {
                                continue;
                            } else {
                                if (c0264g0 == null) {
                                    c0264g0 = a4.b;
                                } else if (!c0264g0.equals(a4.b)) {
                                    break;
                                }
                                arrayList2.add(l);
                                arrayList.add(a4.f531a);
                                if (!TextUtils.isEmpty(a4.b.f862a)) {
                                    try {
                                        jSONObject2 = new JSONObject(a4.b.f862a);
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
                            return new Lh(arrayList, arrayList2, jSONObject);
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
        return new Lh(arrayList, arrayList2, jSONObject);
    }

    public static C0264g0 a(ContentValues contentValues) {
        B7 model = new C7(null, 1, null).toModel(contentValues);
        return new C0264g0((String) WrapUtils.getOrDefault(model.g.g, ""), ((Long) WrapUtils.getOrDefault(model.g.h, 0L)).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[Catch: all -> 0x010c, TryCatch #4 {all -> 0x010c, blocks: (B:7:0x0025, B:8:0x002b, B:10:0x0032, B:12:0x0038, B:29:0x006c, B:31:0x0072, B:40:0x0094, B:45:0x00a5, B:47:0x00b4, B:54:0x00c0, B:53:0x00bf, B:50:0x00ba, B:55:0x00c6, B:58:0x00d8, B:61:0x00df, B:42:0x009d, B:64:0x00e7, B:26:0x0065, B:65:0x00f1, B:67:0x00f7), top: B:90:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Kh a(long j, C9 c9, Ch ch, ArrayList arrayList, int i) {
        Cursor cursor;
        boolean z;
        Kh kh;
        B9 b9;
        int i2;
        C0651v9[] a2;
        C0551r9 c0551r9;
        D9 d9 = new D9();
        d9.f393a = j;
        d9.b = c9;
        EnumC0156bl enumC0156bl = (EnumC0156bl) AbstractC0306hg.b.get(c9.c);
        if (enumC0156bl == null) {
            enumC0156bl = EnumC0156bl.FOREGROUND;
        }
        try {
            cursor = a(j, enumC0156bl);
            if (cursor != null) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    C0264g0 c0264g0 = null;
                    while (true) {
                        z = false;
                        if (!cursor.moveToNext() || this.h >= 100) {
                            break;
                        }
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(cursor, contentValues);
                        try {
                            C0325i9 c0325i9 = new C0325i9(contentValues);
                            EnumC0728yb enumC0728yb = c0325i9.h;
                            if (enumC0728yb != null) {
                                c0551r9 = (C0551r9) AbstractC0306hg.d.get(enumC0728yb);
                            } else {
                                Map map = AbstractC0306hg.f889a;
                                c0551r9 = null;
                            }
                            if (c0551r9 == null) {
                                c0551r9 = C0551r9.i;
                            }
                            try {
                                b9 = c0551r9.a(c0325i9, ch);
                            } catch (Throwable th) {
                                th = th;
                                arrayList.add(th);
                                b9 = null;
                                if (b9 == null) {
                                }
                                arrayList2.add(b9);
                                this.h++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (b9 == null) {
                            C0264g0 a3 = a(contentValues);
                            if (c0264g0 == null) {
                                if (this.i < 0) {
                                    try {
                                        a2 = a(new JSONObject(a3.f862a));
                                    } catch (Throwable unused) {
                                    }
                                    if (a2 != null) {
                                        i2 = 0;
                                        for (C0651v9 c0651v9 : a2) {
                                            i2 += CodedOutputByteBufferNano.computeMessageSize(7, c0651v9);
                                        }
                                        this.i = i2;
                                        this.g += i2;
                                    }
                                    i2 = 0;
                                    this.i = i2;
                                    this.g += i2;
                                }
                                c0264g0 = a3;
                            } else if (!c0264g0.equals(a3)) {
                                z = true;
                                break;
                            }
                            C0645v3 c0645v3 = this.k;
                            byte[] bArr = b9.e;
                            c0645v3.getClass();
                            byte[] a4 = c0645v3.a(bArr);
                            byte[] bArr2 = b9.e;
                            if (bArr2 != a4) {
                                b9.i = ((bArr2 == null ? 0 : bArr2.length) - (a4 == null ? 0 : a4.length)) + b9.i;
                                b9.e = a4;
                            }
                            this.g += CodedOutputByteBufferNano.computeMessageSize(3, b9);
                            if (arrayList2.isEmpty() && i == 0) {
                                if (this.g >= 1048576) {
                                    break;
                                }
                            } else if (this.g >= 250880) {
                                break;
                            }
                        }
                        arrayList2.add(b9);
                        this.h++;
                    }
                    if (arrayList2.size() > 0) {
                        d9.c = (B9[]) arrayList2.toArray(new B9[arrayList2.size()]);
                        kh = new Kh(d9, c0264g0, z);
                        return kh;
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
            kh = null;
            return kh;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
    }

    public final Cursor a() {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        C0297h7 c0297h7 = this.e;
        LinkedHashMap linkedHashMap = this.b;
        c0297h7.f883a.lock();
        try {
            readableDatabase = c0297h7.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("sessions", null, C0297h7.a(linkedHashMap), C0297h7.a(new String[]{Long.toString(0L)}, linkedHashMap), null, null, "id ASC", null);
            c0297h7.f883a.unlock();
            return cursor;
        }
        cursor = null;
        c0297h7.f883a.unlock();
        return cursor;
    }

    public final Cursor a(long j, EnumC0156bl enumC0156bl) {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        C0297h7 c0297h7 = this.e;
        c0297h7.f883a.lock();
        try {
            readableDatabase = c0297h7.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("events", null, "session_id = ? AND session_type = ?", new String[]{Long.toString(j), Integer.toString(enumC0156bl.f799a)}, null, null, "number_in_session ASC", null);
            c0297h7.f883a.unlock();
            return cursor;
        }
        cursor = null;
        c0297h7.f883a.unlock();
        return cursor;
    }
}
