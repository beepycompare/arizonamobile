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
public final class C0716xl {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0486oo f1286a;
    public final InterfaceC0499pb b;

    public C0716xl(C0491p3 c0491p3, C0534qk c0534qk) {
        this.f1286a = c0491p3;
        this.b = c0534qk;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0058 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Zi a(long j, C0756z9 c0756z9, List list, Eh eh, int i, C0401lh c0401lh) {
        boolean z;
        C0730y9 c0730y9;
        int i2;
        C0471o9 c0471o9;
        ArrayList arrayList = new ArrayList();
        int i3 = c0401lh.f1086a;
        int i4 = c0401lh.b;
        Integer num = c0401lh.c;
        Iterator it = list.iterator();
        int i5 = i4;
        C0358k0 c0358k0 = null;
        int i6 = i3;
        Integer num2 = num;
        while (it.hasNext()) {
            ContentValues contentValues = (ContentValues) it.next();
            if (i5 >= 100) {
                break;
            }
            C0290h9 c0290h9 = new C0290h9(contentValues);
            try {
                Db db = c0290h9.h;
                if (db != null) {
                    c0471o9 = (C0471o9) AbstractC0530qg.d.get(db);
                } else {
                    Map map = AbstractC0530qg.f1169a;
                    c0471o9 = null;
                }
                if (c0471o9 == null) {
                    c0471o9 = C0471o9.i;
                }
                try {
                    c0730y9 = c0471o9.a(c0290h9, eh);
                } catch (Throwable th) {
                    th = th;
                    this.b.reportError("protobuf_serialization_error", th);
                    c0730y9 = null;
                    if (c0730y9 == null) {
                    }
                    i5++;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (c0730y9 == null) {
                String str = c0290h9.u;
                C0358k0 c0358k02 = new C0358k0(str, c0290h9.v);
                if (c0358k0 != null) {
                    if (!Intrinsics.areEqual(c0358k0, c0358k02)) {
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
                                    C0574s9 c0574s9 = new C0574s9();
                                    c0574s9.f1200a = next;
                                    c0574s9.b = jSONObject.getString(next);
                                    i2 += CodedOutputByteBufferNano.computeMessageSize(7, c0574s9);
                                } catch (Throwable unused) {
                                }
                            }
                        } catch (Throwable unused2) {
                            i2 = 0;
                        }
                        num2 = Integer.valueOf(i2);
                        i6 += num2.intValue();
                    }
                    c0358k0 = c0358k02;
                }
                byte[] bArr = (byte[]) this.f1286a.a(c0730y9.e);
                byte[] bArr2 = c0730y9.e;
                if (bArr2 != bArr) {
                    c0730y9.i = ((bArr2 != null ? bArr2.length : 0) - (bArr != null ? bArr.length : 0)) + c0730y9.i;
                    c0730y9.e = bArr;
                }
                i6 += CodedOutputByteBufferNano.computeMessageSize(3, c0730y9);
                if (!arrayList.isEmpty() || i != 0) {
                    if (i6 >= 250880) {
                        break;
                    }
                    arrayList.add(c0730y9);
                } else {
                    if (i6 >= 1048576) {
                        break;
                    }
                    arrayList.add(c0730y9);
                }
            }
            i5++;
        }
        z = false;
        if (arrayList.isEmpty()) {
            return null;
        }
        A9 a9 = new A9();
        a9.f460a = j;
        a9.b = c0756z9;
        a9.c = (C0730y9[]) arrayList.toArray(new C0730y9[0]);
        return new Zi(a9, c0358k0, z, i6, i5, num2);
    }
}
