package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.miami.game.core.firebase.notification.NotificationStatsStore;
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
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class Nh implements UnderlyingNetworkTask {

    /* renamed from: a  reason: collision with root package name */
    public final C0448n5 f687a;
    public C7 c;
    public final Oh d;
    public Vf e;
    public final C0589sh f;
    public final PublicLogger g;
    public final C0615th h;
    public final FullUrlFormer i;
    public final C0119ac j;
    public final RequestDataHolder k;
    public final ResponseDataHolder l;
    public final SendingDataTaskHelper m;
    public int n;
    public final LinkedHashMap b = new LinkedHashMap();
    public boolean o = false;

    public Nh(C0448n5 c0448n5, C0615th c0615th, C0119ac c0119ac, FullUrlFormer<Eh> fullUrlFormer, RequestDataHolder requestDataHolder, ResponseDataHolder responseDataHolder, RequestBodyEncrypter requestBodyEncrypter) {
        this.m = new SendingDataTaskHelper(requestBodyEncrypter, new GZIPCompressor(), requestDataHolder, responseDataHolder, new DefaultNetworkResponseHandler());
        this.h = c0615th;
        this.f687a = c0448n5;
        Oh oh = new Oh(c0448n5);
        this.d = oh;
        PublicLogger p = c0448n5.p();
        this.g = p;
        this.j = c0119ac;
        this.k = requestDataHolder;
        this.l = responseDataHolder;
        this.i = fullUrlFormer;
        this.f = new C0589sh(oh, new C0498p3(1024000, "event value in ReportTask", p), AbstractC0755z1.a(), Na.k().C());
    }

    /* JADX WARN: Type inference failed for: r6v22, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    public final void a(boolean z) {
        int i;
        int i2;
        int i3;
        Oh oh = this.d;
        Vf vf = this.e;
        A9[] a9Arr = vf.f810a.f510a;
        List list = vf.b;
        int i4 = this.n;
        ap apVar = oh.c;
        synchronized (apVar) {
            JSONObject a2 = apVar.f894a.a();
            if (a2.optInt("report_request_id", -1) != i4) {
                apVar.f894a.a(a2.put("report_request_id", i4));
            }
            bp bpVar = apVar.f894a;
            bp.a(bpVar.f914a);
            bp.a(bpVar.b);
        }
        ArrayList arrayList = new ArrayList(a9Arr.length);
        int length = a9Arr.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            Long l = null;
            if (i6 >= length) {
                break;
            }
            A9 a9 = a9Arr[i6];
            int i8 = i7 + 1;
            long longValue = ((Number) list.get(i7)).longValue();
            Al al = (Al) AbstractC0537qg.b.get(a9.b.c);
            if (al == null) {
                al = Al.FOREGROUND;
            }
            C0737y9[] c0737y9Arr = a9.c;
            if (c0737y9Arr.length == 0) {
                i2 = i5;
                i3 = i6;
            } else {
                i2 = i5;
                i3 = i6;
                Long valueOf = Long.valueOf(c0737y9Arr[i5].f1291a);
                ?? it = new IntRange(1, ArraysKt.getLastIndex(c0737y9Arr)).iterator();
                l = valueOf;
                while (it.hasNext()) {
                    List list2 = list;
                    A9[] a9Arr2 = a9Arr;
                    Long valueOf2 = Long.valueOf(c0737y9Arr[it.nextInt()].f1291a);
                    if (l.compareTo(valueOf2) < 0) {
                        l = valueOf2;
                    }
                    a9Arr = a9Arr2;
                    list = list2;
                }
            }
            List list3 = list;
            A9[] a9Arr3 = a9Arr;
            long longValue2 = l != null ? l.longValue() : 0L;
            C0737y9[] c0737y9Arr2 = a9.c;
            if (c0737y9Arr2 != null) {
                int length2 = c0737y9Arr2.length;
                for (int i9 = i2; i9 < length2; i9++) {
                    C0737y9 c0737y9 = c0737y9Arr2[i9];
                }
            }
            arrayList.add(new C0386kl(longValue, al.f463a, longValue2, z));
            i6 = i3 + 1;
            a9Arr = a9Arr3;
            i7 = i8;
            i5 = i2;
            list = list3;
        }
        int i10 = i5;
        C0166c7 c0166c7 = oh.f704a;
        long a3 = oh.b.a();
        c0166c7.getClass();
        ArrayList arrayList2 = new ArrayList();
        String format = String.format(Locale.US, "%1$s = ? AND %2$s = ? AND %3$s <= ?", "session_id", "session_type", "number_in_session");
        c0166c7.b.lock();
        try {
            SQLiteDatabase writableDatabase = c0166c7.c.getWritableDatabase();
            if (writableDatabase != null) {
                if (M5.f658a.booleanValue()) {
                    c0166c7.c();
                }
                writableDatabase.beginTransaction();
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(c0166c7.a(writableDatabase, format, (C0386kl) it2.next()));
                }
                String str = K5.c;
                String[] strArr = new String[1];
                strArr[i10] = String.valueOf(a3);
                writableDatabase.delete("sessions", str, strArr);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (Throwable unused) {
        }
        c0166c7.b.unlock();
        Iterator it3 = arrayList2.iterator();
        int i11 = i10;
        while (it3.hasNext()) {
            X6 x6 = (X6) it3.next();
            if (x6.f837a != null) {
                ArrayList arrayList3 = new ArrayList();
                for (ContentValues contentValues : x6.f837a) {
                    arrayList3.add(Integer.valueOf(contentValues.getAsInteger("type").intValue()));
                }
                Iterator it4 = c0166c7.g.iterator();
                while (it4.hasNext()) {
                    ((InterfaceC0426m9) it4.next()).b(arrayList3);
                }
                List list4 = x6.f837a;
                int i12 = i10;
                while (i12 < list4.size()) {
                    ContentValues contentValues2 = (ContentValues) list4.get(i12);
                    Integer asInteger = contentValues2.getAsInteger("type");
                    if (Q9.d.contains(Db.a(asInteger != null ? asInteger.intValue() : -1))) {
                        C0657v7 model = new C0683w7(null, 1, null).toModel(contentValues2);
                        PublicLogger publicLogger = c0166c7.e.m;
                        Db db = model.d;
                        C0631u7 c0631u7 = model.g;
                        String a4 = AbstractC0562rg.a("Event removed from db", db, c0631u7.b, c0631u7.c);
                        i = i10;
                        publicLogger.info(a4, new Object[i]);
                    } else {
                        i = i10;
                    }
                    i12++;
                    i10 = i;
                }
            }
            i11 += x6.b;
            i10 = i10;
        }
        c0166c7.f.addAndGet(-i11);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final String description() {
        return "ReportTask_" + ApiKeyUtils.createPartialApiKey(this.f687a.b.b);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final FullUrlFormer<?> getFullUrlFormer() {
        return this.i;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final RequestDataHolder getRequestDataHolder() {
        return this.k;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final ResponseDataHolder getResponseDataHolder() {
        return this.l;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final RetryPolicyConfig getRetryPolicyConfig() {
        return ((Eh) this.f687a.k.a()).getRetryPolicyConfig();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final SSLSocketFactory getSslSocketFactory() {
        ((C0181cm) Na.I.z()).getClass();
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x03f4  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0055 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x04a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x04ac  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03e9 A[EDGE_INSN: B:249:0x03e9->B:164:0x03e9 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x03e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e4 A[LOOP:3: B:80:0x01de->B:82:0x01e4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0218  */
    /* JADX WARN: Type inference failed for: r0v72, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v25 */
    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onCreateTask() {
        Cursor cursor;
        ContentValues contentValues;
        int i;
        int i2;
        LinkedHashMap linkedHashMap;
        boolean z;
        boolean z2;
        Cursor cursor2;
        SQLiteDatabase readableDatabase;
        Throwable th;
        LinkedHashMap linkedHashMap2;
        ?? r13;
        Iterator it;
        C0365k0 c0365k0;
        JSONObject jSONObject;
        ArrayList arrayList;
        ArrayList arrayList2;
        JSONObject jSONObject2;
        int i3;
        C0581s9[] c0581s9Arr;
        Vf vf;
        Zi zi;
        C0166c7 c0166c7 = this.d.f704a;
        c0166c7.getClass();
        ArrayList arrayList3 = new ArrayList();
        c0166c7.f922a.lock();
        try {
            SQLiteDatabase readableDatabase2 = c0166c7.c.getReadableDatabase();
            if (readableDatabase2 != null) {
                cursor = readableDatabase2.rawQuery(K5.b, null);
                while (cursor.moveToNext()) {
                    try {
                        ContentValues contentValues2 = new ContentValues();
                        DatabaseUtils.cursorRowToContentValues(cursor, contentValues2);
                        arrayList3.add(contentValues2);
                    } catch (Throwable unused) {
                        try {
                            arrayList3 = new ArrayList();
                            contentValues = (ContentValues) CollectionsKt.firstOrNull((List<? extends Object>) arrayList3);
                            if (contentValues != null) {
                            }
                        } finally {
                            Oo.a(cursor);
                            c0166c7.f922a.unlock();
                        }
                    }
                }
            } else {
                cursor = null;
            }
        } catch (Throwable unused2) {
            cursor = null;
        }
        contentValues = (ContentValues) CollectionsKt.firstOrNull((List<? extends Object>) arrayList3);
        if (contentValues != null) {
            return false;
        }
        this.b.clear();
        for (Map.Entry<String, Object> entry : contentValues.valueSet()) {
            this.b.put(entry.getKey(), entry.getValue().toString());
        }
        String asString = contentValues.getAsString("report_request_parameters");
        if (!TextUtils.isEmpty(asString)) {
            try {
                C7 c7 = new C7(new Hb(asString));
                this.c = c7;
                this.h.c = c7;
            } catch (Throwable unused3) {
                C7 c72 = new C7();
                this.c = c72;
                this.h.c = c72;
            }
        } else {
            C7 c73 = new C7();
            this.c = c73;
            this.h.c = c73;
        }
        Eh config = this.j.getConfig();
        List list = config.w;
        if (Oo.a((Collection) list)) {
            return false;
        }
        this.i.setHosts(config.q);
        boolean z3 = true;
        if (config.v() && !Oo.a((Collection) this.i.getAllHosts())) {
            C7 c74 = this.c;
            if (c74 == null) {
                c74 = new C7();
            }
            C7 c75 = c74;
            C0589sh c0589sh = this.f;
            LinkedHashMap linkedHashMap3 = this.b;
            Mh mh = c0589sh.b;
            mh.getClass();
            ArrayList arrayList4 = new ArrayList();
            int i4 = 2;
            int i5 = 100;
            try {
                i2 = 0;
                for (J7 j7 : mh.f666a.a(linkedHashMap3)) {
                    try {
                        if (arrayList4.size() >= i5) {
                            break;
                        }
                        Long l = j7.f608a;
                        if (l != null) {
                            I7 i7 = j7.d;
                            i = i5;
                            try {
                                C9 a2 = AbstractC0537qg.a(i7.f590a, i7.b, i7.c);
                                String locale = config.getLocale();
                                Al al = j7.b;
                                C0763z9 c0763z9 = new C0763z9();
                                c0763z9.f1311a = a2;
                                c0763z9.b = locale;
                                if (al != null) {
                                    Integer num = (Integer) AbstractC0537qg.f1164a.get(al);
                                    c0763z9.c = num != null ? num.intValue() : 0;
                                }
                                i2 = i2 + CodedOutputByteBufferNano.computeUInt64Size(1, Long.MAX_VALUE) + CodedOutputByteBufferNano.computeMessageSize(i4, c0763z9);
                                if (i2 >= 250880) {
                                    break;
                                }
                                Al al2 = (Al) AbstractC0537qg.b.get(c0763z9.c);
                                if (al2 == null) {
                                    al2 = Al.FOREGROUND;
                                }
                                int i6 = i4;
                                try {
                                    arrayList4.add(new Lh(l.longValue(), c0763z9, al2.f463a));
                                    i5 = i;
                                    i4 = i6;
                                } catch (Throwable th2) {
                                    th = th2;
                                    mh.b.reportError("protobuf_serialization_error", th);
                                    Pair pair = new Pair(arrayList4, Integer.valueOf(i2));
                                    List<Lh> list2 = (List) pair.component1();
                                    int intValue = ((Number) pair.component2()).intValue();
                                    linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list2, 10)), 16));
                                    while (r0.hasNext()) {
                                    }
                                    C0166c7 c0166c72 = mh.f666a.f704a;
                                    c0166c72.getClass();
                                    if (linkedHashMap.isEmpty()) {
                                    }
                                    if (cursor2 != null) {
                                    }
                                    JSONObject jSONObject3 = new JSONObject();
                                    ArrayList arrayList5 = new ArrayList();
                                    ArrayList arrayList6 = new ArrayList();
                                    it = list2.iterator();
                                    int i8 = intValue;
                                    Integer num2 = r13;
                                    int i9 = 0;
                                    JSONObject jSONObject4 = jSONObject3;
                                    c0365k0 = r13;
                                    while (true) {
                                        if (it.hasNext()) {
                                        }
                                        linkedHashMap2 = r24;
                                        i = 100;
                                        c0365k0 = c0365k0;
                                    }
                                    arrayList = arrayList5;
                                    arrayList2 = arrayList6;
                                    jSONObject2 = jSONObject;
                                    if (arrayList.isEmpty()) {
                                    }
                                    this.e = vf;
                                    if (vf != null) {
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        i = i5;
                    }
                }
                i = i5;
            } catch (Throwable th5) {
                th = th5;
                i = 100;
                i2 = 0;
            }
            Pair pair2 = new Pair(arrayList4, Integer.valueOf(i2));
            List<Lh> list22 = (List) pair2.component1();
            int intValue2 = ((Number) pair2.component2()).intValue();
            linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list22, 10)), 16));
            for (Lh lh : list22) {
                Pair pair3 = TuplesKt.to(Long.valueOf(lh.f648a), Integer.valueOf(lh.c));
                linkedHashMap.put(pair3.getFirst(), pair3.getSecond());
            }
            C0166c7 c0166c722 = mh.f666a.f704a;
            c0166c722.getClass();
            if (linkedHashMap.isEmpty()) {
                c0166c722.f922a.lock();
                try {
                    readableDatabase = c0166c722.c.getReadableDatabase();
                } catch (Throwable unused4) {
                }
                if (readableDatabase != null) {
                    StringBuilder sb = new StringBuilder();
                    String[] strArr = new String[linkedHashMap.size() * 2];
                    int i10 = 0;
                    for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                        if (i10 > 0) {
                            sb.append(" OR ");
                        }
                        z = z3;
                        try {
                            sb.append("(").append("session_id").append(" = ? AND ").append("session_type").append(" = ?)");
                            int i11 = i10 * 2;
                            strArr[i11] = Long.toString(((Long) entry2.getKey()).longValue());
                            strArr[i11 + 1] = Integer.toString(((Integer) entry2.getValue()).intValue());
                            i10++;
                            z3 = z;
                        } catch (Throwable unused5) {
                        }
                    }
                    z = z3;
                    cursor2 = readableDatabase.query(NotificationStatsStore.KEY_EVENTS, null, sb.toString(), strArr, null, null, "session_id ASC, number_in_session ASC", String.valueOf(i));
                    z2 = z3;
                    c0166c722.f922a.unlock();
                    z3 = z2;
                }
                z = z3;
                cursor2 = null;
                z2 = z3;
                c0166c722.f922a.unlock();
                z3 = z2;
            } else {
                z = true;
                cursor2 = null;
            }
            if (cursor2 != null) {
                linkedHashMap2 = MapsKt.emptyMap();
                r13 = 0;
            } else {
                LinkedHashMap linkedHashMap4 = new LinkedHashMap();
                while (cursor2.moveToNext()) {
                    try {
                        try {
                            try {
                                ContentValues contentValues3 = new ContentValues();
                                DBUtils.cursorRowToContentValues(cursor2, contentValues3);
                                Long asLong = contentValues3.getAsLong("session_id");
                                Object obj = linkedHashMap4.get(asLong);
                                if (obj == null) {
                                    obj = new ArrayList();
                                    linkedHashMap4.put(asLong, obj);
                                }
                                ((List) obj).add(contentValues3);
                            } catch (Throwable th6) {
                                th = th6;
                                throw th;
                            }
                        } catch (Throwable unused6) {
                        }
                    } catch (Throwable th7) {
                        th = th7;
                    }
                }
                Unit unit = Unit.INSTANCE;
                z3 = false;
                CloseableKt.closeFinally(cursor2, null);
                linkedHashMap2 = linkedHashMap4;
                r13 = z3;
            }
            JSONObject jSONObject32 = new JSONObject();
            ArrayList arrayList52 = new ArrayList();
            ArrayList arrayList62 = new ArrayList();
            it = list22.iterator();
            int i82 = intValue2;
            Integer num22 = r13;
            int i92 = 0;
            JSONObject jSONObject42 = jSONObject32;
            c0365k0 = r13;
            while (true) {
                if (it.hasNext()) {
                    jSONObject = jSONObject42;
                    break;
                }
                Iterator it2 = it;
                Lh lh2 = (Lh) it.next();
                jSONObject = jSONObject42;
                if (i92 >= i) {
                    break;
                }
                Mh mh2 = mh;
                C0723xl c0723xl = mh2.c;
                long j = lh2.f648a;
                ArrayList arrayList7 = arrayList62;
                C0763z9 c0763z92 = lh2.b;
                List list3 = (List) linkedHashMap2.get(Long.valueOf(j));
                if (list3 == null) {
                    list3 = CollectionsKt.emptyList();
                }
                int size = arrayList52.size();
                List list4 = list3;
                C0408lh c0408lh = new C0408lh(i82, i92, num22);
                c0723xl.getClass();
                int i12 = i92;
                arrayList2 = arrayList7;
                LinkedHashMap linkedHashMap5 = linkedHashMap2;
                int i13 = i82;
                Integer num3 = num22;
                arrayList = arrayList52;
                try {
                    zi = c0723xl.a(j, c0763z92, list4, config, size, c0408lh);
                } catch (Throwable th8) {
                    c0723xl.b.reportError("protobuf_serialization_error", th8);
                    zi = null;
                }
                if (zi != null) {
                    i82 = zi.d;
                    i92 = zi.e;
                    num22 = zi.f;
                    if (c0365k0 != null && !Intrinsics.areEqual(c0365k0, zi.b)) {
                        break;
                    }
                    c0365k0 = zi.b;
                    arrayList2.add(Long.valueOf(lh2.f648a));
                    arrayList.add(zi.f872a);
                    C0365k0 c0365k02 = zi.b;
                    String str = c0365k02 != null ? c0365k02.f1059a : null;
                    if (str != null && str.length() != 0) {
                        try {
                            jSONObject2 = new JSONObject(str);
                        } catch (Throwable unused7) {
                        }
                        if (!zi.c) {
                            break;
                        }
                        arrayList62 = arrayList2;
                        arrayList52 = arrayList;
                        jSONObject42 = jSONObject2;
                        it = it2;
                        mh = mh2;
                    }
                    jSONObject2 = jSONObject;
                    if (!zi.c) {
                    }
                } else {
                    arrayList62 = arrayList2;
                    arrayList52 = arrayList;
                    i92 = i12;
                    it = it2;
                    jSONObject42 = jSONObject;
                    num22 = num3;
                    mh = mh2;
                    i82 = i13;
                }
                linkedHashMap2 = linkedHashMap5;
                i = 100;
                c0365k0 = c0365k0;
            }
            arrayList = arrayList52;
            arrayList2 = arrayList62;
            jSONObject2 = jSONObject;
            if (arrayList.isEmpty()) {
                C0563rh c0563rh = c0589sh.c;
                c0563rh.getClass();
                D9 d9 = new D9();
                C0659v9 c0659v9 = new C0659v9();
                c0659v9.f1246a = WrapUtils.getOrDefaultIfEmpty(c75.b, config.getUuid());
                c0659v9.b = WrapUtils.getOrDefaultIfEmpty(c75.f490a, config.getDeviceId());
                d9.b = c0659v9;
                Pn pn = c0563rh.f1183a;
                C0538qh c0538qh = new C0538qh(d9);
                synchronized (pn) {
                    pn.f722a.a(c0538qh);
                }
                d9.f510a = (A9[]) arrayList.toArray(new A9[0]);
                int length = jSONObject2.length();
                if (length <= 0) {
                    c0581s9Arr = null;
                    i3 = 0;
                } else {
                    ArrayList arrayList8 = new ArrayList(length);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        try {
                            C0581s9 c0581s9 = new C0581s9();
                            c0581s9.f1195a = next;
                            c0581s9.b = jSONObject2.getString(next);
                            arrayList8.add(c0581s9);
                        } catch (Throwable unused8) {
                        }
                    }
                    i3 = 0;
                    c0581s9Arr = (C0581s9[]) arrayList8.toArray(new C0581s9[0]);
                }
                d9.c = c0581s9Arr;
                d9.e = (String[]) list.toArray(new String[i3]);
                String[] strArr2 = (String[]) config.x.toArray(new String[i3]);
                int length2 = strArr2.length;
                byte[][] bArr = new byte[length2];
                for (int i14 = 0; i14 < length2; i14++) {
                    bArr[i14] = StringUtils.getUTF8Bytes(strArr2[i14]);
                }
                d9.f = bArr;
                vf = new Vf(d9, arrayList2, c0589sh.f1199a.a());
            } else {
                vf = null;
            }
            this.e = vf;
            if (vf != null) {
                return false;
            }
            int i15 = vf.c;
            this.n = i15;
            this.h.e = i15;
            this.m.prepareAndSetPostData(MessageNano.toByteArray(vf.f810a));
            return z;
        }
        this.o = true;
        return false;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onPerformRequest() {
        this.m.onPerformRequest();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onPostRequestComplete(boolean z) {
        C0737y9[] c0737y9Arr;
        String a2;
        if (z) {
            a(false);
        } else if (this.l.getResponseCode() == 400) {
            a(true);
        }
        if (z) {
            for (A9 a9 : this.e.f810a.f510a) {
                for (C0737y9 c0737y9 : a9.c) {
                    if (c0737y9 != null && (a2 = AbstractC0562rg.a(c0737y9)) != null) {
                        this.g.info(a2, new Object[0]);
                    }
                }
            }
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final boolean onRequestComplete() {
        return this.m.isResponseValid();
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onRequestError(Throwable th) {
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onShouldNotExecute() {
        this.o = true;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onSuccessfulTaskFinished() {
        this.o = true;
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskAdded() {
        ((A5) this.f687a.p).d.set(false);
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskFinished() {
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onTaskRemoved() {
        ((A5) this.f687a.p).d.set(true);
        if (this.o) {
            ((A5) this.f687a.p).f();
        }
    }

    @Override // io.appmetrica.analytics.networktasks.internal.UnderlyingNetworkTask
    public final void onUnsuccessfulTaskFinished() {
    }
}
