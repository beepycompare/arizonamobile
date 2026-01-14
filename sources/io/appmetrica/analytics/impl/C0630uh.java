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
/* renamed from: io.appmetrica.analytics.impl.uh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0630uh implements UnderlyingNetworkTask {

    /* renamed from: a  reason: collision with root package name */
    public final X4 f1258a;
    public final LinkedHashMap b;
    public C0396l7 c;
    public C0347j9 d;
    public final L6 e;
    public List f;
    public int g;
    public int h;
    public int i;
    public C0605th j;
    public final Z2 k;
    public final PublicLogger l;
    public final xo m;
    public final Ra n;
    public final Zg o;
    public final FullUrlFormer p;
    public final C0724yb q;
    public final RequestDataHolder r;
    public final ResponseDataHolder s;
    public final SendingDataTaskHelper t;
    public int u;
    public boolean v;

    public C0630uh(X4 x4, Zg zg, C0724yb c0724yb, FullUrlFormer<C0381kh> fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this(x4, zg, c0724yb, fullUrlFormer, requestDataHolder, responseDataHolder, x4.i(), x4.p(), x4.u(), requestBodyEncrypter);
    }

    public final C0347j9 a(C0605th c0605th, List list, C0381kh c0381kh) {
        C0347j9 c0347j9 = new C0347j9();
        C0141b9 c0141b9 = new C0141b9();
        c0141b9.f916a = WrapUtils.getOrDefaultIfEmpty(this.c.b, c0381kh.getUuid());
        c0141b9.b = WrapUtils.getOrDefaultIfEmpty(this.c.f1094a, c0381kh.getDeviceId());
        this.g = CodedOutputByteBufferNano.computeMessageSize(4, c0141b9) + this.g;
        c0347j9.b = c0141b9;
        C0487on C = C0449na.I.C();
        C0555rh c0555rh = new C0555rh(this, c0347j9);
        synchronized (C) {
            C.f1163a.a(c0555rh);
        }
        c0347j9.f1061a = (C0270g9[]) c0605th.f1240a.toArray(new C0270g9[0]);
        c0347j9.c = a(c0605th.c);
        c0347j9.e = (String[]) list.toArray(new String[0]);
        Set set = c0381kh.x;
        String[] strArr = (String[]) set.toArray(new String[0]);
        c0347j9.f = new byte[strArr.length];
        for (int i = 0; i < set.size(); i++) {
            c0347j9.f[i] = StringUtils.getUTF8Bytes(strArr[i]);
        }
        return c0347j9;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final String description() {
        return "ReportTask_" + ApiKeyUtils.createPartialApiKey(this.f1258a.b.b);
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
        return ((C0381kh) this.f1258a.k.a()).getRetryPolicyConfig();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final SSLSocketFactory getSslSocketFactory() {
        ((Al) C0449na.I.z()).getClass();
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
        L6 l6 = this.f1258a.e;
        l6.getClass();
        ArrayList arrayList = new ArrayList();
        l6.f673a.lock();
        try {
            SQLiteDatabase readableDatabase = l6.c.getReadableDatabase();
            if (readableDatabase != null) {
                cursor = readableDatabase.rawQuery(AbstractC0618u5.b, null);
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
                            lo.a(cursor);
                            l6.f673a.unlock();
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
                    C0396l7 c0396l7 = new C0396l7(new C0246fb(asString));
                    this.c = c0396l7;
                    this.o.c = c0396l7;
                } catch (Throwable unused3) {
                    C0396l7 c0396l72 = new C0396l7();
                    this.c = c0396l72;
                    this.o.c = c0396l72;
                }
            } else {
                C0396l7 c0396l73 = new C0396l7();
                this.c = c0396l73;
                this.o.c = c0396l73;
            }
            C0381kh config = this.q.getConfig();
            List list = config.w;
            if (lo.a((Collection) list)) {
                return false;
            }
            this.p.setHosts(config.q);
            if (config.u() && !lo.a((Collection) this.p.getAllHosts())) {
                this.f = null;
                C0605th a2 = a(config);
                this.j = a2;
                if (a2.f1240a.isEmpty()) {
                    return false;
                }
                xo xoVar = this.m;
                synchronized (xoVar) {
                    optInt = xoVar.f1313a.a().optInt("report_request_id", -1);
                }
                int i = optInt + 1;
                this.u = i;
                this.o.e = i;
                C0347j9 a3 = a(this.j, list, config);
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
        C0218e9[] c0218e9Arr;
        String a2;
        if (z) {
            a(false);
        } else if (this.s.getResponseCode() == 400) {
            a(true);
        }
        if (z) {
            for (int i = 0; i < this.j.f1240a.size(); i++) {
                for (C0218e9 c0218e9 : ((C0270g9) this.j.f1240a.get(i)).c) {
                    if (c0218e9 != null && (a2 = Qf.a(c0218e9)) != null) {
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
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onSuccessfulTaskFinished() {
        this.v = true;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskAdded() {
        ((C0369k5) this.f1258a.p).d.set(false);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskFinished() {
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskRemoved() {
        ((C0369k5) this.f1258a.p).d.set(true);
        if (this.v) {
            ((C0369k5) this.f1258a.p).f();
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onUnsuccessfulTaskFinished() {
    }

    public C0630uh(X4 x4, Zg zg, C0724yb c0724yb, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, L6 l6, PublicLogger publicLogger, xo xoVar, RequestBodyEncrypter requestBodyEncrypter) {
        this(x4, publicLogger, l6, zg, xoVar, c0724yb, new Z2(1024000, "event value in ReportTask", publicLogger), AbstractC0689x1.a(), fullUrlFormer, requestDataHolder, responseDataHolder, requestBodyEncrypter);
    }

    public C0630uh(X4 x4, PublicLogger publicLogger, L6 l6, Zg zg, xo xoVar, C0724yb c0724yb, Z2 z2, Qj qj, FullUrlFormer fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this.b = new LinkedHashMap();
        this.g = 0;
        this.h = 0;
        this.i = -1;
        this.v = false;
        this.t = new SendingDataTaskHelper(requestBodyEncrypter, new GZIPCompressor(), requestDataHolder, responseDataHolder, new DefaultNetworkResponseHandler());
        this.o = zg;
        this.f1258a = x4;
        this.e = l6;
        this.l = publicLogger;
        this.k = z2;
        this.m = xoVar;
        this.q = c0724yb;
        this.n = qj;
        this.r = requestDataHolder;
        this.s = responseDataHolder;
        this.p = fullUrlFormer;
    }

    public static Y8[] a(JSONObject jSONObject) {
        int length = jSONObject.length();
        if (length > 0) {
            Y8[] y8Arr = new Y8[length];
            Iterator<String> keys = jSONObject.keys();
            int i = 0;
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    Y8 y8 = new Y8();
                    y8.f864a = next;
                    y8.b = jSONObject.getString(next);
                    y8Arr[i] = y8;
                } catch (Throwable unused) {
                }
                i++;
            }
            return y8Arr;
        }
        return null;
    }

    public final void a(boolean z) {
        boolean z2;
        xo xoVar = this.m;
        int i = this.u;
        synchronized (xoVar) {
            yo yoVar = xoVar.f1313a;
            yoVar.a(yoVar.a().put("report_request_id", i));
        }
        C0270g9[] c0270g9Arr = this.d.f1061a;
        int i2 = 0;
        while (i2 < c0270g9Arr.length) {
            try {
                C0270g9 c0270g9 = c0270g9Arr[i2];
                long longValue = ((Long) this.f.get(i2)).longValue();
                Vk vk = (Vk) Pf.b.get(c0270g9.b.c);
                if (vk == null) {
                    vk = Vk.FOREGROUND;
                }
                z2 = z;
                try {
                    this.e.a(longValue, vk.f831a, c0270g9.c.length, z2);
                    Pf.a(c0270g9);
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                z2 = z;
            }
            i2++;
            z = z2;
        }
        L6 l6 = this.e;
        long a2 = this.f1258a.j.a();
        l6.b.lock();
        try {
            if (AbstractC0668w5.f1283a.booleanValue()) {
                l6.c();
            }
            SQLiteDatabase writableDatabase = l6.c.getWritableDatabase();
            if (writableDatabase != null) {
                writableDatabase.delete("sessions", AbstractC0618u5.c, new String[]{String.valueOf(a2)});
            }
        } catch (Throwable unused3) {
        }
        l6.b.unlock();
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7 A[LOOP:1: B:44:0x00e1->B:46:0x00e7, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0605th a(C0381kh c0381kh) {
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
                C0313i0 c0313i0 = null;
                while (a2.moveToNext() && this.h < 100) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(a2, contentValues);
                        C0570s7 model = new C0595t7(null, 1, null).toModel(contentValues);
                        Long l = model.f1219a;
                        if (l != null) {
                            C0545r7 c0545r7 = model.d;
                            C0322i9 a3 = Pf.a(c0545r7.f1204a, c0545r7.b, c0545r7.c);
                            String locale = c0381kh.getLocale();
                            Vk vk = model.b;
                            C0244f9 c0244f9 = new C0244f9();
                            c0244f9.f992a = a3;
                            c0244f9.b = locale;
                            if (vk != null) {
                                Integer num = (Integer) Pf.f739a.get(vk);
                                c0244f9.c = num != null ? num.intValue() : 0;
                            }
                            int computeUInt64Size = this.g + CodedOutputByteBufferNano.computeUInt64Size(1, Long.MAX_VALUE);
                            this.g = computeUInt64Size;
                            int computeMessageSize = computeUInt64Size + CodedOutputByteBufferNano.computeMessageSize(2, c0244f9);
                            this.g = computeMessageSize;
                            if (computeMessageSize >= 250880) {
                                break;
                            }
                            C0580sh a4 = a(l.longValue(), c0244f9, c0381kh, arrayList3, arrayList.size());
                            if (a4 == null) {
                                continue;
                            } else {
                                if (c0313i0 == null) {
                                    c0313i0 = a4.b;
                                } else if (!c0313i0.equals(a4.b)) {
                                    break;
                                }
                                arrayList2.add(l);
                                arrayList.add(a4.f1224a);
                                if (!TextUtils.isEmpty(a4.b.f1036a)) {
                                    try {
                                        jSONObject2 = new JSONObject(a4.b.f1036a);
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
                            return new C0605th(arrayList, arrayList2, jSONObject);
                        } finally {
                            lo.a(cursor);
                        }
                    }
                }
                jSONObject = jSONObject2;
            }
            lo.a(a2);
        } catch (Throwable th2) {
            th = th2;
        }
        it = arrayList3.iterator();
        while (it.hasNext()) {
            this.n.reportError("protobuf_serialization_error", (Throwable) it.next());
        }
        return new C0605th(arrayList, arrayList2, jSONObject);
    }

    public static C0313i0 a(ContentValues contentValues) {
        C0216e7 model = new C0242f7(null, 1, null).toModel(contentValues);
        return new C0313i0((String) WrapUtils.getOrDefault(model.g.g, ""), ((Long) WrapUtils.getOrDefault(model.g.h, 0L)).longValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006c A[Catch: all -> 0x010c, TryCatch #4 {all -> 0x010c, blocks: (B:7:0x0025, B:8:0x002b, B:10:0x0032, B:12:0x0038, B:29:0x006c, B:31:0x0072, B:40:0x0094, B:45:0x00a5, B:47:0x00b4, B:54:0x00c0, B:53:0x00bf, B:50:0x00ba, B:55:0x00c6, B:58:0x00d8, B:61:0x00df, B:42:0x009d, B:64:0x00e7, B:26:0x0065, B:65:0x00f1, B:67:0x00f7), top: B:90:0x0025 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C0580sh a(long j, C0244f9 c0244f9, C0381kh c0381kh, ArrayList arrayList, int i) {
        Cursor cursor;
        boolean z;
        C0580sh c0580sh;
        C0218e9 c0218e9;
        int i2;
        Y8[] a2;
        U8 u8;
        C0270g9 c0270g9 = new C0270g9();
        c0270g9.f1011a = j;
        c0270g9.b = c0244f9;
        Vk vk = (Vk) Pf.b.get(c0244f9.c);
        if (vk == null) {
            vk = Vk.FOREGROUND;
        }
        try {
            cursor = a(j, vk);
            if (cursor != null) {
                try {
                    ArrayList arrayList2 = new ArrayList();
                    C0313i0 c0313i0 = null;
                    while (true) {
                        z = false;
                        if (!cursor.moveToNext() || this.h >= 100) {
                            break;
                        }
                        ContentValues contentValues = new ContentValues();
                        DBUtils.cursorRowToContentValues(cursor, contentValues);
                        try {
                            N8 n8 = new N8(contentValues);
                            EnumC0143bb enumC0143bb = n8.h;
                            if (enumC0143bb != null) {
                                u8 = (U8) Pf.d.get(enumC0143bb);
                            } else {
                                Map map = Pf.f739a;
                                u8 = null;
                            }
                            if (u8 == null) {
                                u8 = U8.i;
                            }
                            try {
                                c0218e9 = u8.a(n8, c0381kh);
                            } catch (Throwable th) {
                                th = th;
                                arrayList.add(th);
                                c0218e9 = null;
                                if (c0218e9 == null) {
                                }
                                arrayList2.add(c0218e9);
                                this.h++;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        if (c0218e9 == null) {
                            C0313i0 a3 = a(contentValues);
                            if (c0313i0 == null) {
                                if (this.i < 0) {
                                    try {
                                        a2 = a(new JSONObject(a3.f1036a));
                                    } catch (Throwable unused) {
                                    }
                                    if (a2 != null) {
                                        i2 = 0;
                                        for (Y8 y8 : a2) {
                                            i2 += CodedOutputByteBufferNano.computeMessageSize(7, y8);
                                        }
                                        this.i = i2;
                                        this.g += i2;
                                    }
                                    i2 = 0;
                                    this.i = i2;
                                    this.g += i2;
                                }
                                c0313i0 = a3;
                            } else if (!c0313i0.equals(a3)) {
                                z = true;
                                break;
                            }
                            Z2 z2 = this.k;
                            byte[] bArr = c0218e9.e;
                            z2.getClass();
                            byte[] a4 = z2.a(bArr);
                            byte[] bArr2 = c0218e9.e;
                            if (bArr2 != a4) {
                                c0218e9.i = ((bArr2 == null ? 0 : bArr2.length) - (a4 == null ? 0 : a4.length)) + c0218e9.i;
                                c0218e9.e = a4;
                            }
                            this.g += CodedOutputByteBufferNano.computeMessageSize(3, c0218e9);
                            if (arrayList2.isEmpty() && i == 0) {
                                if (this.g >= 1048576) {
                                    break;
                                }
                            } else if (this.g >= 250880) {
                                break;
                            }
                        }
                        arrayList2.add(c0218e9);
                        this.h++;
                    }
                    if (arrayList2.size() > 0) {
                        c0270g9.c = (C0218e9[]) arrayList2.toArray(new C0218e9[arrayList2.size()]);
                        c0580sh = new C0580sh(c0270g9, c0313i0, z);
                        return c0580sh;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    try {
                        arrayList.add(th);
                        lo.a(cursor);
                        return null;
                    } finally {
                        lo.a(cursor);
                    }
                }
            }
            c0580sh = null;
            return c0580sh;
        } catch (Throwable th4) {
            th = th4;
            cursor = null;
        }
    }

    public final Cursor a() {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        L6 l6 = this.e;
        LinkedHashMap linkedHashMap = this.b;
        l6.f673a.lock();
        try {
            readableDatabase = l6.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("sessions", null, L6.a(linkedHashMap), L6.a(new String[]{Long.toString(0L)}, linkedHashMap), null, null, "id ASC", null);
            l6.f673a.unlock();
            return cursor;
        }
        cursor = null;
        l6.f673a.unlock();
        return cursor;
    }

    public final Cursor a(long j, Vk vk) {
        Cursor cursor;
        SQLiteDatabase readableDatabase;
        L6 l6 = this.e;
        l6.f673a.lock();
        try {
            readableDatabase = l6.c.getReadableDatabase();
        } catch (Throwable unused) {
        }
        if (readableDatabase != null) {
            cursor = readableDatabase.query("events", null, "session_id = ? AND session_type = ?", new String[]{Long.toString(j), Integer.toString(vk.f831a)}, null, null, "number_in_session ASC", null);
            l6.f673a.unlock();
            return cursor;
        }
        cursor = null;
        l6.f673a.unlock();
        return cursor;
    }
}
