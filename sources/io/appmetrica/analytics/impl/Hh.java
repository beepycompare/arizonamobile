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
public final class Hh implements UnderlyingNetworkTask {

    /* renamed from: a  reason: collision with root package name */
    public final C0574s5 f472a;
    public final LinkedHashMap b;
    public H7 c;
    public E9 d;
    public final C0278g7 e;
    public List f;
    public int g;
    public int h;
    public int i;
    public Gh j;
    public final C0647v3 k;
    public final PublicLogger l;
    public final uo m;
    public final InterfaceC0431mb n;
    public final C0437mh o;
    public final FullUrlFormer p;
    public final Tb q;
    public final RequestDataHolder r;
    public final ResponseDataHolder s;
    public final SendingDataTaskHelper t;
    public int u;
    public boolean v;

    public Hh(C0574s5 c0574s5, C0437mh c0437mh, Tb tb, FullUrlFormer<C0711xh> fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this(c0574s5, c0437mh, tb, fullUrlFormer, requestDataHolder, responseDataHolder, c0574s5.h(), c0574s5.o(), c0574s5.t(), requestBodyEncrypter);
    }

    public final E9 a(Gh gh, List list, C0711xh c0711xh) {
        E9 e9 = new E9();
        C0678w9 c0678w9 = new C0678w9();
        c0678w9.f1117a = WrapUtils.getOrDefaultIfEmpty(this.c.b, c0711xh.getUuid());
        c0678w9.b = WrapUtils.getOrDefaultIfEmpty(this.c.f467a, c0711xh.getDeviceId());
        this.g = CodedOutputByteBufferNano.computeMessageSize(4, c0678w9) + this.g;
        e9.b = c0678w9;
        C0418ln A = Ia.F.A();
        Eh eh = new Eh(this, e9);
        synchronized (A) {
            A.f943a.a(eh);
        }
        List list2 = gh.f456a;
        e9.f414a = (B9[]) list2.toArray(new B9[list2.size()]);
        e9.c = a(gh.c);
        e9.e = (String[]) list.toArray(new String[list.size()]);
        this.g = CodedOutputByteBufferNano.computeTagSize(8) + this.g;
        return e9;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final String description() {
        return "ReportTask_" + ApiKeyUtils.createPartialApiKey(this.f472a.b.b);
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
        return ((C0711xh) this.f472a.k.a()).getRetryPolicyConfig();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final SSLSocketFactory getSslSocketFactory() {
        ((Al) Ia.F.y()).getClass();
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
        C0278g7 c0278g7 = this.f472a.e;
        c0278g7.getClass();
        ArrayList arrayList = new ArrayList();
        c0278g7.f861a.lock();
        try {
            SQLiteDatabase readableDatabase = c0278g7.c.getReadableDatabase();
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
                            io.a(cursor);
                            c0278g7.f861a.unlock();
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
                    H7 h7 = new H7(new Ab(asString));
                    this.c = h7;
                    this.o.c = h7;
                } catch (Throwable unused3) {
                    H7 h72 = new H7();
                    this.c = h72;
                    this.o.c = h72;
                }
            } else {
                H7 h73 = new H7();
                this.c = h73;
                this.o.c = h73;
            }
            C0711xh config = this.q.getConfig();
            List list = config.w;
            if (io.a((Collection) list)) {
                return false;
            }
            this.p.setHosts(config.q);
            if (config.t() && !io.a((Collection) this.p.getAllHosts())) {
                this.f = null;
                Gh a2 = a(config);
                this.j = a2;
                if (a2.f456a.isEmpty()) {
                    return false;
                }
                uo uoVar = this.m;
                synchronized (uoVar) {
                    optInt = uoVar.f1091a.a().optInt("report_request_id", -1);
                }
                int i = optInt + 1;
                this.u = i;
                this.o.e = i;
                E9 a3 = a(this.j, list, config);
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
        C0753z9[] c0753z9Arr;
        String a2;
        if (z) {
            a(false);
        } else if (this.s.getResponseCode() == 400) {
            a(true);
        }
        if (z) {
            for (int i = 0; i < this.j.f456a.size(); i++) {
                for (C0753z9 c0753z9 : ((B9) this.j.f456a.get(i)).c) {
                    if (c0753z9 != null && (a2 = AbstractC0210dg.a(c0753z9)) != null) {
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
        this.f472a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onSuccessfulTaskFinished() {
        this.v = true;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskAdded() {
        ((F5) this.f472a.p).d.set(false);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskFinished() {
        this.f472a.e.a();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskRemoved() {
        ((F5) this.f472a.p).d.set(true);
        if (this.v) {
            ((F5) this.f472a.p).f();
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onUnsuccessfulTaskFinished() {
    }

    public Hh(C0574s5 c0574s5, C0437mh c0437mh, Tb tb, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, C0278g7 c0278g7, PublicLogger publicLogger, uo uoVar, RequestBodyEncrypter requestBodyEncrypter) {
        this(c0574s5, publicLogger, c0278g7, c0437mh, uoVar, tb, new C0647v3(1024000, "event value in ReportTask", publicLogger), AbstractC0595t1.a(), fullUrlFormer, requestDataHolder, responseDataHolder, requestBodyEncrypter);
    }

    public Hh(C0574s5 c0574s5, PublicLogger publicLogger, C0278g7 c0278g7, C0437mh c0437mh, uo uoVar, Tb tb, C0647v3 c0647v3, C0188ck c0188ck, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this.b = new LinkedHashMap();
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.v = false;
        this.t = new SendingDataTaskHelper(requestBodyEncrypter, new GZIPCompressor(), requestDataHolder, responseDataHolder, new DefaultNetworkResponseHandler());
        this.o = c0437mh;
        this.f472a = c0574s5;
        this.e = c0278g7;
        this.l = publicLogger;
        this.k = c0647v3;
        this.m = uoVar;
        this.q = tb;
        this.n = c0188ck;
        this.r = requestDataHolder;
        this.s = responseDataHolder;
        this.p = fullUrlFormer;
    }

    public static C0603t9[] a(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length > 0) {
            C0603t9[] c0603t9Arr = new C0603t9[length];
            Iterator<String> keys = jSONObject.keys();
            int i = 0;
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    C0603t9 c0603t9 = new C0603t9();
                    c0603t9.f1062a = next;
                    c0603t9.b = jSONObject.getString(next);
                    c0603t9Arr[i] = c0603t9;
                } catch (Throwable unused) {
                }
                i++;
            }
            return c0603t9Arr;
        }
        return null;
    }

    public final void a(boolean z) {
        boolean z2;
        uo uoVar = this.m;
        int i = this.u;
        synchronized (uoVar) {
            vo voVar = uoVar.f1091a;
            voVar.a(voVar.a().put("report_request_id", i));
        }
        B9[] b9Arr = this.d.f414a;
        int i2 = 0;
        while (i2 < b9Arr.length) {
            try {
                B9 b9 = b9Arr[i2];
                long longValue = ((Long) this.f.get(i2)).longValue();
                Wk wk = (Wk) AbstractC0184cg.b.get(b9.b.c);
                if (wk == null) {
                    wk = Wk.FOREGROUND;
                }
                z2 = z;
                try {
                    this.e.a(longValue, wk.f706a, b9.c.length, z2);
                    AbstractC0184cg.a(b9);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                z2 = z;
            }
            i2++;
            z = z2;
        }
        C0278g7 c0278g7 = this.e;
        long a2 = this.f472a.j.a();
        c0278g7.b.lock();
        try {
            if (S5.f633a.booleanValue()) {
                c0278g7.d();
            }
            SQLiteDatabase writableDatabase = c0278g7.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("sessions", Q5.c, new String[]{String.valueOf(a2)});
            }
        } catch (Throwable unused3) {
        }
        c0278g7.b.unlock();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7 A[LOOP:1: B:44:0x00e1->B:46:0x00e7, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Gh a(C0711xh c0711xh) {
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
                C0271g0 c0271g0 = null;
                while (a2.moveToNext() && this.h < 100) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(a2, contentValues);
                        O7 model = new P7(null, 1, null).toModel(contentValues);
                        Long l = model.f574a;
                        if (l != null) {
                            N7 n7 = model.d;
                            D9 a3 = AbstractC0184cg.a(n7.f560a, n7.b, n7.c);
                            String locale = c0711xh.getLocale();
                            Wk wk = model.b;
                            A9 a9 = new A9();
                            a9.f335a = a3;
                            a9.b = locale;
                            if (wk != null) {
                                Integer num = (Integer) AbstractC0184cg.f798a.get(wk);
                                a9.c = num != null ? num.intValue() : 0;
                            }
                            int computeUInt64Size = this.g + CodedOutputByteBufferNano.computeUInt64Size(1, Long.MAX_VALUE);
                            this.g = computeUInt64Size;
                            int computeMessageSize = computeUInt64Size + CodedOutputByteBufferNano.computeMessageSize(2, a9);
                            this.g = computeMessageSize;
                            if (computeMessageSize >= 250880) {
                                break;
                            }
                            Fh a4 = a(l.longValue(), a9, c0711xh, arrayList3, arrayList.size());
                            if (a4 == null) {
                                continue;
                            } else {
                                if (c0271g0 == null) {
                                    c0271g0 = a4.b;
                                } else if (!c0271g0.equals(a4.b)) {
                                    break;
                                }
                                arrayList2.add(l);
                                arrayList.add(a4.f438a);
                                if (!TextUtils.isEmpty(a4.b.f855a)) {
                                    try {
                                        jSONObject2 = new JSONObject(a4.b.f855a);
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
                            return new Gh(arrayList, arrayList2, jSONObject);
                        } finally {
                            io.a(cursor);
                        }
                    }
                }
                jSONObject = jSONObject2;
            }
            io.a(a2);
        } catch (Throwable th2) {
            th = th2;
        }
        it = arrayList3.iterator();
        while (it.hasNext()) {
            this.n.reportError("protobuf_serialization_error", (Throwable) it.next());
        }
        return new Gh(arrayList, arrayList2, jSONObject);
    }

    public static C0271g0 a(ContentValues contentValues) {
        A7 model = new B7(null, 1, null).toModel(contentValues);
        return new C0271g0((String) WrapUtils.getOrDefault(model.g.g, ""), ((Long) WrapUtils.getOrDefault(model.g.h, 0L)).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[Catch: all -> 0x010c, TryCatch #4 {all -> 0x010c, blocks: (B:7:0x0025, B:8:0x002b, B:10:0x0032, B:12:0x0038, B:29:0x006c, B:31:0x0072, B:40:0x0094, B:45:0x00a5, B:47:0x00b4, B:54:0x00c0, B:53:0x00bf, B:50:0x00ba, B:55:0x00c6, B:58:0x00d8, B:61:0x00df, B:42:0x009d, B:64:0x00e7, B:26:0x0065, B:65:0x00f1, B:67:0x00f7), top: B:90:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Fh a(long j, A9 a9, C0711xh c0711xh, ArrayList arrayList, int i) {
        Cursor cursor;
        boolean z;
        Fh fh;
        C0753z9 c0753z9;
        int i2;
        C0603t9[] a2;
        C0504p9 c0504p9;
        B9 b9 = new B9();
        b9.f354a = j;
        b9.b = a9;
        Wk wk = (Wk) AbstractC0184cg.b.get(a9.c);
        if (wk == null) {
            wk = Wk.FOREGROUND;
        }
        try {
            cursor = a(j, wk);
            if (cursor != null) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    C0271g0 c0271g0 = null;
                    while (true) {
                        z = false;
                        if (!cursor.moveToNext() || this.h >= 100) {
                            break;
                        }
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(cursor, contentValues);
                        try {
                            C0280g9 c0280g9 = new C0280g9(contentValues);
                            EnumC0680wb enumC0680wb = c0280g9.h;
                            if (enumC0680wb != null) {
                                c0504p9 = (C0504p9) AbstractC0184cg.d.get(enumC0680wb);
                            } else {
                                Map map = AbstractC0184cg.f798a;
                                c0504p9 = null;
                            }
                            if (c0504p9 == null) {
                                c0504p9 = C0504p9.i;
                            }
                            try {
                                c0753z9 = c0504p9.a(c0280g9, c0711xh);
                            } catch (Throwable th) {
                                th = th;
                                arrayList.add(th);
                                c0753z9 = null;
                                if (c0753z9 == null) {
                                }
                                arrayList2.add(c0753z9);
                                this.h++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (c0753z9 == null) {
                            C0271g0 a3 = a(contentValues);
                            if (c0271g0 == null) {
                                if (this.i < 0) {
                                    try {
                                        a2 = a(new JSONObject(a3.f855a));
                                    } catch (Throwable unused) {
                                    }
                                    if (a2 != null) {
                                        i2 = 0;
                                        for (C0603t9 c0603t9 : a2) {
                                            i2 += CodedOutputByteBufferNano.computeMessageSize(7, c0603t9);
                                        }
                                        this.i = i2;
                                        this.g += i2;
                                    }
                                    i2 = 0;
                                    this.i = i2;
                                    this.g += i2;
                                }
                                c0271g0 = a3;
                            } else if (!c0271g0.equals(a3)) {
                                z = true;
                                break;
                            }
                            C0647v3 c0647v3 = this.k;
                            byte[] bArr = c0753z9.e;
                            c0647v3.getClass();
                            byte[] a4 = c0647v3.a(bArr);
                            byte[] bArr2 = c0753z9.e;
                            if (bArr2 != a4) {
                                c0753z9.i = ((bArr2 == null ? 0 : bArr2.length) - (a4 == null ? 0 : a4.length)) + c0753z9.i;
                                c0753z9.e = a4;
                            }
                            this.g += CodedOutputByteBufferNano.computeMessageSize(3, c0753z9);
                            if (arrayList2.isEmpty() && i == 0) {
                                if (this.g >= 1048576) {
                                    break;
                                }
                            } else if (this.g >= 250880) {
                                break;
                            }
                        }
                        arrayList2.add(c0753z9);
                        this.h++;
                    }
                    if (arrayList2.size() > 0) {
                        b9.c = (C0753z9[]) arrayList2.toArray(new C0753z9[arrayList2.size()]);
                        fh = new Fh(b9, c0271g0, z);
                        return fh;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        arrayList.add(th);
                        io.a(cursor);
                        return null;
                    } finally {
                        io.a(cursor);
                    }
                }
            }
            fh = null;
            return fh;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
    }

    public final Cursor a() {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        C0278g7 c0278g7 = this.e;
        LinkedHashMap linkedHashMap = this.b;
        c0278g7.f861a.lock();
        try {
            readableDatabase = c0278g7.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("sessions", null, C0278g7.a(linkedHashMap), C0278g7.a(new String[]{Long.toString(0L)}, linkedHashMap), null, null, "id ASC", null);
            c0278g7.f861a.unlock();
            return cursor;
        }
        cursor = null;
        c0278g7.f861a.unlock();
        return cursor;
    }

    public final Cursor a(long j, Wk wk) {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        C0278g7 c0278g7 = this.e;
        c0278g7.f861a.lock();
        try {
            readableDatabase = c0278g7.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("events", null, "session_id = ? AND session_type = ?", new String[]{Long.toString(j), Integer.toString(wk.f706a)}, null, null, "number_in_session ASC", null);
            c0278g7.f861a.unlock();
            return cursor;
        }
        cursor = null;
        c0278g7.f861a.unlock();
        return cursor;
    }
}
