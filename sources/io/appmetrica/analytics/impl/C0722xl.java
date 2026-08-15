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
public final class C0722xl {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0492oo f1283a;
    public final InterfaceC0505pb b;

    public C0722xl(C0497p3 c0497p3, C0540qk c0540qk) {
        this.f1283a = c0497p3;
        this.b = c0540qk;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0058 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Zi a(long j, C0762z9 c0762z9, List list, Eh eh, int i, C0407lh c0407lh) {
        boolean z;
        C0736y9 c0736y9;
        int i2;
        C0477o9 c0477o9;
        ArrayList arrayList = new ArrayList();
        int i3 = c0407lh.f1083a;
        int i4 = c0407lh.b;
        Integer num = c0407lh.c;
        Iterator it = list.iterator();
        int i5 = i4;
        C0364k0 c0364k0 = null;
        int i6 = i3;
        Integer num2 = num;
        while (it.hasNext()) {
            ContentValues contentValues = (ContentValues) it.next();
            if (i5 >= 100) {
                break;
            }
            C0296h9 c0296h9 = new C0296h9(contentValues);
            try {
                Db db = c0296h9.h;
                if (db != null) {
                    c0477o9 = (C0477o9) AbstractC0536qg.d.get(db);
                } else {
                    Map map = AbstractC0536qg.f1166a;
                    c0477o9 = null;
                }
                if (c0477o9 == null) {
                    c0477o9 = C0477o9.i;
                }
                try {
                    c0736y9 = c0477o9.a(c0296h9, eh);
                } catch (Throwable th) {
                    th = th;
                    this.b.reportError("protobuf_serialization_error", th);
                    c0736y9 = null;
                    if (c0736y9 == null) {
                    }
                    i5++;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            if (c0736y9 == null) {
                String str = c0296h9.u;
                C0364k0 c0364k02 = new C0364k0(str, c0296h9.v);
                if (c0364k0 != null) {
                    if (!Intrinsics.areEqual(c0364k0, c0364k02)) {
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
                                    C0580s9 c0580s9 = new C0580s9();
                                    c0580s9.f1197a = next;
                                    c0580s9.b = jSONObject.getString(next);
                                    i2 += CodedOutputByteBufferNano.computeMessageSize(7, c0580s9);
                                } catch (Throwable unused) {
                                }
                            }
                        } catch (Throwable unused2) {
                            i2 = 0;
                        }
                        num2 = Integer.valueOf(i2);
                        i6 += num2.intValue();
                    }
                    c0364k0 = c0364k02;
                }
                byte[] bArr = (byte[]) this.f1283a.a(c0736y9.e);
                byte[] bArr2 = c0736y9.e;
                if (bArr2 != bArr) {
                    c0736y9.i = ((bArr2 != null ? bArr2.length : 0) - (bArr != null ? bArr.length : 0)) + c0736y9.i;
                    c0736y9.e = bArr;
                }
                i6 += CodedOutputByteBufferNano.computeMessageSize(3, c0736y9);
                if (!arrayList.isEmpty() || i != 0) {
                    if (i6 >= 250880) {
                        break;
                    }
                    arrayList.add(c0736y9);
                } else {
                    if (i6 >= 1048576) {
                        break;
                    }
                    arrayList.add(c0736y9);
                }
            }
            i5++;
        }
        z = false;
        if (arrayList.isEmpty()) {
            return null;
        }
        A9 a9 = new A9();
        a9.f457a = j;
        a9.b = c0762z9;
        a9.c = (C0736y9[]) arrayList.toArray(new C0736y9[0]);
        return new Zi(a9, c0364k0, z, i6, i5, num2);
    }
}
