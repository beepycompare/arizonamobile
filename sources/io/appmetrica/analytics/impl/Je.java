package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Je implements A8 {

    /* renamed from: a  reason: collision with root package name */
    public final Me f519a;
    public final I3 b;
    public final Sa c;
    public final C0255fg d;

    public Je() {
        this(new Me(), new I3(), new Sa(100), new C0255fg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Zi> fromModel(Ie ie) {
        Zi zi;
        T8 t8 = new T8();
        t8.f683a = ie.f498a;
        t8.f = new I8();
        Ke ke = ie.b;
        G8 g8 = new G8();
        g8.f458a = StringUtils.getUTF8Bytes(ke.f539a);
        Sn a2 = this.c.a(ke.b);
        g8.b = StringUtils.getUTF8Bytes((String) a2.f676a);
        g8.e = ke.c.size();
        Map<String, String> map = ke.d;
        if (map != null) {
            zi = this.f519a.fromModel(map);
            g8.c = (K8) zi.f777a;
        } else {
            zi = null;
        }
        t8.f.f493a = g8;
        int i = 0;
        char c = 1;
        C0750z3 c0750z3 = new C0750z3(C0750z3.b(a2, zi));
        List list = ke.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int computeInt32Size = t8.f683a != new T8().f683a ? CodedOutputByteBufferNano.computeInt32Size(1, t8.f683a) : 0;
        S8 s8 = t8.b;
        if (s8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(2, s8);
        }
        Q8 q8 = t8.c;
        if (q8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, q8);
        }
        R8 r8 = t8.d;
        int i2 = 4;
        if (r8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, r8);
        }
        C8 c8 = t8.e;
        if (c8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, c8);
        }
        I8 i8 = t8.f;
        if (i8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, i8);
        }
        ArrayList arrayList2 = new ArrayList();
        T8 t82 = new T8();
        t82.f683a = t8.f683a;
        I8 i82 = new I8();
        t82.f = i82;
        i82.f493a = new G8();
        G8 g82 = t82.f.f493a;
        G8 g83 = t8.f.f493a;
        g82.b = g83.b;
        g82.f458a = g83.f458a;
        g82.e = g83.e;
        g82.c = g83.c;
        C0750z3 c0750z32 = c0750z3;
        int i3 = 0;
        int i4 = computeInt32Size;
        while (i3 < list.size()) {
            char c2 = c;
            H8 h8 = new H8();
            h8.f475a = i3;
            int i5 = i;
            Zi fromModel = this.b.fromModel((J3) list.get(i3));
            h8.b = (D8) fromModel.f777a;
            fromModel.b.getBytesTruncated();
            Zi zi2 = new Zi(h8, fromModel);
            this.d.getClass();
            int computeTagSize = CodedOutputByteBufferNano.computeTagSize(i2);
            int computeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag((H8) zi2.f777a);
            int computeRawVarint32Size = computeTagSize + computeMessageSizeNoTag + ((computeMessageSizeNoTag & (-128)) == 0 ? i5 : CodedOutputByteBufferNano.computeRawVarint32Size(computeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i4 + computeRawVarint32Size > 204800) {
                t82.f.f493a.d = (H8[]) arrayList2.toArray(new H8[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new Zi(t82, c0750z32));
                T8 t83 = new T8();
                t83.f683a = t8.f683a;
                I8 i83 = new I8();
                t83.f = i83;
                i83.f493a = new G8();
                G8 g84 = t83.f.f493a;
                G8 g85 = t8.f.f493a;
                g84.b = g85.b;
                g84.f458a = g85.f458a;
                g84.e = g85.e;
                g84.c = g85.c;
                c0750z32 = c0750z3;
                i4 = computeInt32Size;
                t82 = t83;
                arrayList2 = arrayList3;
            }
            arrayList2.add((H8) zi2.f777a);
            A3[] a3Arr = new A3[2];
            a3Arr[i5] = c0750z32;
            a3Arr[c2] = zi2.b;
            c0750z32 = new C0750z3(C0750z3.b(a3Arr));
            i4 += computeRawVarint32Size;
            i3++;
            c = c2;
            i = i5;
            i2 = 4;
        }
        t82.f.f493a.d = (H8[]) arrayList2.toArray(new H8[arrayList2.size()]);
        arrayList.add(new Zi(t82, c0750z32));
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Je(Me me2, I3 i3, Sa sa, C0255fg c0255fg) {
        this.f519a = me2;
        this.b = i3;
        this.c = sa;
        this.d = c0255fg;
    }

    public final Ie a(List<Zi> list) {
        throw new UnsupportedOperationException();
    }
}
