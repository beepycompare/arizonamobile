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
public final class Fh implements UnderlyingNetworkTask {

    /* renamed from: a  reason: collision with root package name */
    public final C0572s5 f431a;
    public final LinkedHashMap b;
    public E7 c;
    public B9 d;
    public final C0201d7 e;
    public List f;
    public int g;
    public int h;
    public int i;
    public Eh j;
    public final C0645v3 k;
    public final PublicLogger l;
    public final ro m;
    public final InterfaceC0379kb n;
    public final C0385kh o;
    public final FullUrlFormer p;
    public final Rb q;
    public final RequestDataHolder r;
    public final ResponseDataHolder s;
    public final SendingDataTaskHelper t;
    public int u;
    public boolean v;

    public Fh(C0572s5 c0572s5, C0385kh c0385kh, Rb rb, FullUrlFormer<C0659vh> fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this(c0572s5, c0385kh, rb, fullUrlFormer, requestDataHolder, responseDataHolder, c0572s5.h(), c0572s5.o(), c0572s5.t(), requestBodyEncrypter);
    }

    public final B9 a(Eh eh, List list, C0659vh c0659vh) {
        B9 b9 = new B9();
        C0601t9 c0601t9 = new C0601t9();
        c0601t9.f1057a = WrapUtils.getOrDefaultIfEmpty(this.c.b, c0659vh.getUuid());
        c0601t9.b = WrapUtils.getOrDefaultIfEmpty(this.c.f404a, c0659vh.getDeviceId());
        this.g = CodedOutputByteBufferNano.computeMessageSize(4, c0601t9) + this.g;
        b9.b = c0601t9;
        C0341in A = Ga.F.A();
        Ch ch = new Ch(this, b9);
        synchronized (A) {
            A.f882a.a(ch);
        }
        List list2 = eh.f411a;
        b9.f352a = (C0726y9[]) list2.toArray(new C0726y9[list2.size()]);
        b9.c = a(eh.c);
        b9.e = (String[]) list.toArray(new String[list.size()]);
        this.g = CodedOutputByteBufferNano.computeTagSize(8) + this.g;
        return b9;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final String description() {
        return "ReportTask_" + ApiKeyUtils.createPartialApiKey(this.f431a.b.b);
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
        return ((C0659vh) this.f431a.k.a()).getRetryPolicyConfig();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final SSLSocketFactory getSslSocketFactory() {
        ((C0713xl) Ga.F.y()).getClass();
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
        C0201d7 c0201d7 = this.f431a.e;
        c0201d7.getClass();
        ArrayList arrayList = new ArrayList();
        c0201d7.f800a.lock();
        try {
            SQLiteDatabase readableDatabase = c0201d7.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(N5.b, null);
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
                            fo.a(cursor);
                            c0201d7.f800a.unlock();
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
                    E7 e7 = new E7(new C0728yb(asString));
                    this.c = e7;
                    this.o.c = e7;
                } catch (Throwable unused3) {
                    E7 e72 = new E7();
                    this.c = e72;
                    this.o.c = e72;
                }
            } else {
                E7 e73 = new E7();
                this.c = e73;
                this.o.c = e73;
            }
            C0659vh config = this.q.getConfig();
            List list = config.w;
            if (fo.a((Collection) list)) {
                return false;
            }
            this.p.setHosts(config.q);
            if (config.t() && !fo.a((Collection) this.p.getAllHosts())) {
                this.f = null;
                Eh a2 = a(config);
                this.j = a2;
                if (a2.f411a.isEmpty()) {
                    return false;
                }
                ro roVar = this.m;
                synchronized (roVar) {
                    optInt = roVar.f1034a.a().optInt("report_request_id", -1);
                }
                int i = optInt + 1;
                this.u = i;
                this.o.e = i;
                B9 a3 = a(this.j, list, config);
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
        C0676w9[] c0676w9Arr;
        String a2;
        if (z) {
            a(false);
        } else if (this.s.getResponseCode() == 400) {
            a(true);
        }
        if (z) {
            for (int i = 0; i < this.j.f411a.size(); i++) {
                for (C0676w9 c0676w9 : ((C0726y9) this.j.f411a.get(i)).c) {
                    if (c0676w9 != null && (a2 = AbstractC0158bg.a(c0676w9)) != null) {
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
        this.f431a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onSuccessfulTaskFinished() {
        this.v = true;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskAdded() {
        ((D5) this.f431a.p).d.set(false);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskFinished() {
        this.f431a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskRemoved() {
        ((D5) this.f431a.p).d.set(true);
        if (this.v) {
            ((D5) this.f431a.p).f();
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onUnsuccessfulTaskFinished() {
    }

    public Fh(C0572s5 c0572s5, C0385kh c0385kh, Rb rb, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, C0201d7 c0201d7, PublicLogger publicLogger, ro roVar, RequestBodyEncrypter requestBodyEncrypter) {
        this(c0572s5, publicLogger, c0201d7, c0385kh, roVar, rb, new C0645v3(1024000, "event value in ReportTask", publicLogger), AbstractC0593t1.a(), fullUrlFormer, requestDataHolder, responseDataHolder, requestBodyEncrypter);
    }

    public Fh(C0572s5 c0572s5, PublicLogger publicLogger, C0201d7 c0201d7, C0385kh c0385kh, ro roVar, Rb rb, C0645v3 c0645v3, Zj zj, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this.b = new LinkedHashMap();
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.v = false;
        this.t = new SendingDataTaskHelper(requestBodyEncrypter, new GZIPCompressor(), requestDataHolder, responseDataHolder, new DefaultNetworkResponseHandler());
        this.o = c0385kh;
        this.f431a = c0572s5;
        this.e = c0201d7;
        this.l = publicLogger;
        this.k = c0645v3;
        this.m = roVar;
        this.q = rb;
        this.n = zj;
        this.r = requestDataHolder;
        this.s = responseDataHolder;
        this.p = fullUrlFormer;
    }

    public static C0527q9[] a(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length > 0) {
            C0527q9[] c0527q9Arr = new C0527q9[length];
            Iterator<String> keys = jSONObject.keys();
            int i = 0;
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    C0527q9 c0527q9 = new C0527q9();
                    c0527q9.f1004a = next;
                    c0527q9.b = jSONObject.getString(next);
                    c0527q9Arr[i] = c0527q9;
                } catch (Throwable unused) {
                }
                i++;
            }
            return c0527q9Arr;
        }
        return null;
    }

    public final void a(boolean z) {
        boolean z2;
        ro roVar = this.m;
        int i = this.u;
        synchronized (roVar) {
            so soVar = roVar.f1034a;
            soVar.a(soVar.a().put("report_request_id", i));
        }
        C0726y9[] c0726y9Arr = this.d.f352a;
        int i2 = 0;
        while (i2 < c0726y9Arr.length) {
            try {
                C0726y9 c0726y9 = c0726y9Arr[i2];
                long longValue = ((Long) this.f.get(i2)).longValue();
                Tk tk = (Tk) AbstractC0132ag.b.get(c0726y9.b.c);
                if (tk == null) {
                    tk = Tk.FOREGROUND;
                }
                z2 = z;
                try {
                    this.e.a(longValue, tk.f647a, c0726y9.c.length, z2);
                    AbstractC0132ag.a(c0726y9);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                z2 = z;
            }
            i2++;
            z = z2;
        }
        C0201d7 c0201d7 = this.e;
        long a2 = this.f431a.j.a();
        c0201d7.b.lock();
        try {
            if (P5.f575a.booleanValue()) {
                c0201d7.d();
            }
            SQLiteDatabase writableDatabase = c0201d7.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("sessions", N5.c, new String[]{String.valueOf(a2)});
            }
        } catch (Throwable unused3) {
        }
        c0201d7.b.unlock();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7 A[LOOP:1: B:44:0x00e1->B:46:0x00e7, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Eh a(C0659vh c0659vh) {
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
                C0269g0 c0269g0 = null;
                while (a2.moveToNext() && this.h < 100) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(a2, contentValues);
                        L7 model = new M7(null, 1, null).toModel(contentValues);
                        Long l = model.f515a;
                        if (l != null) {
                            K7 k7 = model.d;
                            A9 a3 = AbstractC0132ag.a(k7.f503a, k7.b, k7.c);
                            String locale = c0659vh.getLocale();
                            Tk tk = model.b;
                            C0701x9 c0701x9 = new C0701x9();
                            c0701x9.f1122a = a3;
                            c0701x9.b = locale;
                            if (tk != null) {
                                Integer num = (Integer) AbstractC0132ag.f755a.get(tk);
                                c0701x9.c = num != null ? num.intValue() : 0;
                            }
                            int computeUInt64Size = this.g + CodedOutputByteBufferNano.computeUInt64Size(1, Long.MAX_VALUE);
                            this.g = computeUInt64Size;
                            int computeMessageSize = computeUInt64Size + CodedOutputByteBufferNano.computeMessageSize(2, c0701x9);
                            this.g = computeMessageSize;
                            if (computeMessageSize >= 250880) {
                                break;
                            }
                            Dh a4 = a(l.longValue(), c0701x9, c0659vh, arrayList3, arrayList.size());
                            if (a4 == null) {
                                continue;
                            } else {
                                if (c0269g0 == null) {
                                    c0269g0 = a4.b;
                                } else if (!c0269g0.equals(a4.b)) {
                                    break;
                                }
                                arrayList2.add(l);
                                arrayList.add(a4.f392a);
                                if (!TextUtils.isEmpty(a4.b.f847a)) {
                                    try {
                                        jSONObject2 = new JSONObject(a4.b.f847a);
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
                            return new Eh(arrayList, arrayList2, jSONObject);
                        } finally {
                            fo.a(cursor);
                        }
                    }
                }
                jSONObject = jSONObject2;
            }
            fo.a(a2);
        } catch (Throwable th2) {
            th = th2;
        }
        it = arrayList3.iterator();
        while (it.hasNext()) {
            this.n.reportError("protobuf_serialization_error", (Throwable) it.next());
        }
        return new Eh(arrayList, arrayList2, jSONObject);
    }

    public static C0269g0 a(ContentValues contentValues) {
        C0699x7 model = new C0724y7(null, 1, null).toModel(contentValues);
        return new C0269g0((String) WrapUtils.getOrDefault(model.g.g, ""), ((Long) WrapUtils.getOrDefault(model.g.h, 0L)).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[Catch: all -> 0x010c, TryCatch #4 {all -> 0x010c, blocks: (B:7:0x0025, B:8:0x002b, B:10:0x0032, B:12:0x0038, B:29:0x006c, B:31:0x0072, B:40:0x0094, B:45:0x00a5, B:47:0x00b4, B:54:0x00c0, B:53:0x00bf, B:50:0x00ba, B:55:0x00c6, B:58:0x00d8, B:61:0x00df, B:42:0x009d, B:64:0x00e7, B:26:0x0065, B:65:0x00f1, B:67:0x00f7), top: B:90:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Dh a(long j, C0701x9 c0701x9, C0659vh c0659vh, ArrayList arrayList, int i) {
        Cursor cursor;
        boolean z;
        Dh dh;
        C0676w9 c0676w9;
        int i2;
        C0527q9[] a2;
        C0427m9 c0427m9;
        C0726y9 c0726y9 = new C0726y9();
        c0726y9.f1143a = j;
        c0726y9.b = c0701x9;
        Tk tk = (Tk) AbstractC0132ag.b.get(c0701x9.c);
        if (tk == null) {
            tk = Tk.FOREGROUND;
        }
        try {
            cursor = a(j, tk);
            if (cursor != null) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    C0269g0 c0269g0 = null;
                    while (true) {
                        z = false;
                        if (!cursor.moveToNext() || this.h >= 100) {
                            break;
                        }
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(cursor, contentValues);
                        try {
                            C0203d9 c0203d9 = new C0203d9(contentValues);
                            EnumC0628ub enumC0628ub = c0203d9.h;
                            if (enumC0628ub != null) {
                                c0427m9 = (C0427m9) AbstractC0132ag.d.get(enumC0628ub);
                            } else {
                                Map map = AbstractC0132ag.f755a;
                                c0427m9 = null;
                            }
                            if (c0427m9 == null) {
                                c0427m9 = C0427m9.i;
                            }
                            try {
                                c0676w9 = c0427m9.a(c0203d9, c0659vh);
                            } catch (Throwable th) {
                                th = th;
                                arrayList.add(th);
                                c0676w9 = null;
                                if (c0676w9 == null) {
                                }
                                arrayList2.add(c0676w9);
                                this.h++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (c0676w9 == null) {
                            C0269g0 a3 = a(contentValues);
                            if (c0269g0 == null) {
                                if (this.i < 0) {
                                    try {
                                        a2 = a(new JSONObject(a3.f847a));
                                    } catch (Throwable unused) {
                                    }
                                    if (a2 != null) {
                                        i2 = 0;
                                        for (C0527q9 c0527q9 : a2) {
                                            i2 += CodedOutputByteBufferNano.computeMessageSize(7, c0527q9);
                                        }
                                        this.i = i2;
                                        this.g += i2;
                                    }
                                    i2 = 0;
                                    this.i = i2;
                                    this.g += i2;
                                }
                                c0269g0 = a3;
                            } else if (!c0269g0.equals(a3)) {
                                z = true;
                                break;
                            }
                            C0645v3 c0645v3 = this.k;
                            byte[] bArr = c0676w9.e;
                            c0645v3.getClass();
                            byte[] a4 = c0645v3.a(bArr);
                            byte[] bArr2 = c0676w9.e;
                            if (bArr2 != a4) {
                                c0676w9.i = ((bArr2 == null ? 0 : bArr2.length) - (a4 == null ? 0 : a4.length)) + c0676w9.i;
                                c0676w9.e = a4;
                            }
                            this.g += CodedOutputByteBufferNano.computeMessageSize(3, c0676w9);
                            if (arrayList2.isEmpty() && i == 0) {
                                if (this.g >= 1048576) {
                                    break;
                                }
                            } else if (this.g >= 250880) {
                                break;
                            }
                        }
                        arrayList2.add(c0676w9);
                        this.h++;
                    }
                    if (arrayList2.size() > 0) {
                        c0726y9.c = (C0676w9[]) arrayList2.toArray(new C0676w9[arrayList2.size()]);
                        dh = new Dh(c0726y9, c0269g0, z);
                        return dh;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        arrayList.add(th);
                        fo.a(cursor);
                        return null;
                    } finally {
                        fo.a(cursor);
                    }
                }
            }
            dh = null;
            return dh;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
    }

    public final Cursor a() {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        C0201d7 c0201d7 = this.e;
        LinkedHashMap linkedHashMap = this.b;
        c0201d7.f800a.lock();
        try {
            readableDatabase = c0201d7.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("sessions", null, C0201d7.a(linkedHashMap), C0201d7.a(new String[]{Long.toString(0L)}, linkedHashMap), null, null, "id ASC", null);
            c0201d7.f800a.unlock();
            return cursor;
        }
        cursor = null;
        c0201d7.f800a.unlock();
        return cursor;
    }

    public final Cursor a(long j, Tk tk) {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        C0201d7 c0201d7 = this.e;
        c0201d7.f800a.lock();
        try {
            readableDatabase = c0201d7.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("events", null, "session_id = ? AND session_type = ?", new String[]{Long.toString(j), Integer.toString(tk.f647a)}, null, null, "number_in_session ASC", null);
            c0201d7.f800a.unlock();
            return cursor;
        }
        cursor = null;
        c0201d7.f800a.unlock();
        return cursor;
    }
}
