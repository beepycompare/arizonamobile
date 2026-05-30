package io.appmetrica.analytics.impl;

import android.content.ContentValues;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
/* renamed from: io.appmetrica.analytics.impl.xl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0723xl {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0493oo f1281a;
    public final InterfaceC0506pb b;

    public C0723xl(C0498p3 c0498p3, C0541qk c0541qk) {
        this.f1281a = c0498p3;
        this.b = c0541qk;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0058 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Zi a(long j, C0763z9 c0763z9, List list, Eh eh, int i, C0408lh c0408lh) {
        boolean z;
        C0737y9 c0737y9;
        int i2;
        C0478o9 c0478o9;
        ArrayList arrayList = new ArrayList();
        int i3 = c0408lh.f1081a;
        int i4 = c0408lh.b;
        Integer num = c0408lh.c;
        Iterator it = list.iterator();
        int i5 = i4;
        C0365k0 c0365k0 = null;
        int i6 = i3;
        Integer num2 = num;
        while (it.hasNext()) {
            ContentValues contentValues = (ContentValues) it.next();
            if (i5 >= 100) {
                break;
            }
            C0297h9 c0297h9 = new C0297h9(contentValues);
            try {
                Db db = c0297h9.h;
                if (db != null) {
                    c0478o9 = (C0478o9) AbstractC0537qg.d.get(db);
                } else {
                    Map map = AbstractC0537qg.f1164a;
                    c0478o9 = null;
                }
                if (c0478o9 == null) {
                    c0478o9 = C0478o9.i;
                }
                try {
                    c0737y9 = c0478o9.a(c0297h9, eh);
                } catch (Throwable th) {
                    th = th;
                    this.b.reportError("protobuf_serialization_error", th);
                    c0737y9 = null;
                    if (c0737y9 == null) {
                    }
                    i5++;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (c0737y9 == null) {
                String str = c0297h9.u;
                C0365k0 c0365k02 = new C0365k0(str, c0297h9.v);
                if (c0365k0 != null) {
                    if (!Intrinsics.areEqual(c0365k0, c0365k02)) {
                        z = true;
                        break;
                    }
                } else {
                    if (num2 == null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            Iterator<String> keys = jSONObject.keys();
                            i2 = 0;
                            while (keys.hasNext()) {
                                String next = keys.next();
                                try {
                                    C0581s9 c0581s9 = new C0581s9();
                                    c0581s9.f1195a = next;
                                    c0581s9.b = jSONObject.getString(next);
                                    i2 += CodedOutputByteBufferNano.computeMessageSize(7, c0581s9);
                                } catch (Throwable unused) {
                                }
                            }
                        } catch (Throwable unused2) {
                            i2 = 0;
                        }
                        num2 = Integer.valueOf(i2);
                        i6 += num2.intValue();
                    }
                    c0365k0 = c0365k02;
                }
                byte[] bArr = (byte[]) this.f1281a.a(c0737y9.e);
                byte[] bArr2 = c0737y9.e;
                if (bArr2 != bArr) {
                    c0737y9.i = ((bArr2 != null ? bArr2.length : 0) - (bArr != null ? bArr.length : 0)) + c0737y9.i;
                    c0737y9.e = bArr;
                }
                i6 += CodedOutputByteBufferNano.computeMessageSize(3, c0737y9);
                if (!arrayList.isEmpty() || i != 0) {
                    if (i6 >= 250880) {
                        break;
                    }
                    arrayList.add(c0737y9);
                } else {
                    if (i6 >= 1048576) {
                        break;
                    }
                    arrayList.add(c0737y9);
                }
            }
            i5++;
        }
        z = false;
        if (arrayList.isEmpty()) {
            return null;
        }
        A9 a9 = new A9();
        a9.f455a = j;
        a9.b = c0763z9;
        a9.c = (C0737y9[]) arrayList.toArray(new C0737y9[0]);
        return new Zi(a9, c0365k0, z, i6, i5, num2);
    }
}
