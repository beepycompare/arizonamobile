package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Fe implements InterfaceC0700x8 {

    /* renamed from: a  reason: collision with root package name */
    public final Ie f435a;
    public final F3 b;
    public final Pa c;
    public final C0151bg d;

    public Fe() {
        this(new Ie(), new F3(), new Pa(100), new C0151bg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Vi> fromModel(Ee ee) {
        Vi vi;
        Q8 q8 = new Q8();
        q8.f617a = ee.f413a;
        q8.f = new F8();
        Ge ge = ee.b;
        D8 d8 = new D8();
        d8.f392a = StringUtils.getUTF8Bytes(ge.f456a);
        On a2 = this.c.a(ge.b);
        d8.b = StringUtils.getUTF8Bytes((String) a2.f594a);
        d8.e = ge.c.size();
        Map<String, String> map = ge.d;
        if (map != null) {
            vi = this.f435a.fromModel(map);
            d8.c = (H8) vi.f697a;
        } else {
            vi = null;
        }
        q8.f.f430a = d8;
        int i = 0;
        char c = 1;
        C0670w3 c0670w3 = new C0670w3(C0670w3.b(a2, vi));
        List list = ge.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int computeInt32Size = q8.f617a != new Q8().f617a ? CodedOutputByteBufferNano.computeInt32Size(1, q8.f617a) : 0;
        P8 p8 = q8.b;
        if (p8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(2, p8);
        }
        N8 n8 = q8.c;
        if (n8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, n8);
        }
        O8 o8 = q8.d;
        int i2 = 4;
        if (o8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, o8);
        }
        C0750z8 c0750z8 = q8.e;
        if (c0750z8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, c0750z8);
        }
        F8 f8 = q8.f;
        if (f8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, f8);
        }
        ArrayList arrayList2 = new ArrayList();
        Q8 q82 = new Q8();
        q82.f617a = q8.f617a;
        F8 f82 = new F8();
        q82.f = f82;
        f82.f430a = new D8();
        D8 d82 = q82.f.f430a;
        D8 d83 = q8.f.f430a;
        d82.b = d83.b;
        d82.f392a = d83.f392a;
        d82.e = d83.e;
        d82.c = d83.c;
        C0670w3 c0670w32 = c0670w3;
        int i3 = 0;
        int i4 = computeInt32Size;
        while (i3 < list.size()) {
            char c2 = c;
            E8 e8 = new E8();
            e8.f410a = i3;
            int i5 = i;
            Vi fromModel = this.b.fromModel((G3) list.get(i3));
            e8.b = (A8) fromModel.f697a;
            fromModel.b.getBytesTruncated();
            Vi vi2 = new Vi(e8, fromModel);
            this.d.getClass();
            int computeTagSize = CodedOutputByteBufferNano.computeTagSize(i2);
            int computeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag((E8) vi2.f697a);
            int computeRawVarint32Size = computeTagSize + computeMessageSizeNoTag + ((computeMessageSizeNoTag & (-128)) == 0 ? i5 : CodedOutputByteBufferNano.computeRawVarint32Size(computeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i4 + computeRawVarint32Size > 204800) {
                q82.f.f430a.d = (E8[]) arrayList2.toArray(new E8[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new Vi(q82, c0670w32));
                Q8 q83 = new Q8();
                q83.f617a = q8.f617a;
                F8 f83 = new F8();
                q83.f = f83;
                f83.f430a = new D8();
                D8 d84 = q83.f.f430a;
                D8 d85 = q8.f.f430a;
                d84.b = d85.b;
                d84.f392a = d85.f392a;
                d84.e = d85.e;
                d84.c = d85.c;
                c0670w32 = c0670w3;
                i4 = computeInt32Size;
                q82 = q83;
                arrayList2 = arrayList3;
            }
            arrayList2.add((E8) vi2.f697a);
            InterfaceC0695x3[] interfaceC0695x3Arr = new InterfaceC0695x3[2];
            interfaceC0695x3Arr[i5] = c0670w32;
            interfaceC0695x3Arr[c2] = vi2.b;
            c0670w32 = new C0670w3(C0670w3.b(interfaceC0695x3Arr));
            i4 += computeRawVarint32Size;
            i3++;
            c = c2;
            i = i5;
            i2 = 4;
        }
        q82.f.f430a.d = (E8[]) arrayList2.toArray(new E8[arrayList2.size()]);
        arrayList.add(new Vi(q82, c0670w32));
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Fe(Ie ie, F3 f3, Pa pa, C0151bg c0151bg) {
        this.f435a = ie;
        this.b = f3;
        this.c = pa;
        this.d = c0151bg;
    }

    public final Ee a(List<Vi> list) {
        throw new UnsupportedOperationException();
    }
}
