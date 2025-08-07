package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class De implements InterfaceC0653v8 {

    /* renamed from: a  reason: collision with root package name */
    public final Ge f397a;
    public final F3 b;
    public final Na c;
    public final Wf d;

    public De() {
        this(new Ge(), new F3(), new Na(100), new Wf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Qi> fromModel(Ce ce) {
        Qi qi;
        O8 o8 = new O8();
        o8.f575a = ce.f377a;
        o8.f = new D8();
        Ee ee = ce.b;
        B8 b8 = new B8();
        b8.f353a = StringUtils.getUTF8Bytes(ee.f417a);
        Jn a2 = this.c.a(ee.b);
        b8.b = StringUtils.getUTF8Bytes((String) a2.f511a);
        b8.e = ee.c.size();
        Map<String, String> map = ee.d;
        if (map != null) {
            qi = this.f397a.fromModel(map);
            b8.c = (F8) qi.f612a;
        } else {
            qi = null;
        }
        o8.f.f392a = b8;
        int i = 0;
        char c = 1;
        C0673w3 c0673w3 = new C0673w3(C0673w3.b(a2, qi));
        List list = ee.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int computeInt32Size = o8.f575a != new O8().f575a ? CodedOutputByteBufferNano.computeInt32Size(1, o8.f575a) : 0;
        N8 n8 = o8.b;
        if (n8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(2, n8);
        }
        L8 l8 = o8.c;
        if (l8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, l8);
        }
        M8 m8 = o8.d;
        int i2 = 4;
        if (m8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, m8);
        }
        C0703x8 c0703x8 = o8.e;
        if (c0703x8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, c0703x8);
        }
        D8 d8 = o8.f;
        if (d8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, d8);
        }
        ArrayList arrayList2 = new ArrayList();
        O8 o82 = new O8();
        o82.f575a = o8.f575a;
        D8 d82 = new D8();
        o82.f = d82;
        d82.f392a = new B8();
        B8 b82 = o82.f.f392a;
        B8 b83 = o8.f.f392a;
        b82.b = b83.b;
        b82.f353a = b83.f353a;
        b82.e = b83.e;
        b82.c = b83.c;
        C0673w3 c0673w32 = c0673w3;
        int i3 = 0;
        int i4 = computeInt32Size;
        while (i3 < list.size()) {
            char c2 = c;
            C8 c8 = new C8();
            c8.f374a = i3;
            int i5 = i;
            Qi fromModel = this.b.fromModel((G3) list.get(i3));
            c8.b = (C0728y8) fromModel.f612a;
            fromModel.b.getBytesTruncated();
            Qi qi2 = new Qi(c8, fromModel);
            this.d.getClass();
            int computeTagSize = CodedOutputByteBufferNano.computeTagSize(i2);
            int computeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag((C8) qi2.f612a);
            int computeRawVarint32Size = computeTagSize + computeMessageSizeNoTag + ((computeMessageSizeNoTag & (-128)) == 0 ? i5 : CodedOutputByteBufferNano.computeRawVarint32Size(computeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i4 + computeRawVarint32Size > 204800) {
                o82.f.f392a.d = (C8[]) arrayList2.toArray(new C8[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new Qi(o82, c0673w32));
                O8 o83 = new O8();
                o83.f575a = o8.f575a;
                D8 d83 = new D8();
                o83.f = d83;
                d83.f392a = new B8();
                B8 b84 = o83.f.f392a;
                B8 b85 = o8.f.f392a;
                b84.b = b85.b;
                b84.f353a = b85.f353a;
                b84.e = b85.e;
                b84.c = b85.c;
                c0673w32 = c0673w3;
                i4 = computeInt32Size;
                o82 = o83;
                arrayList2 = arrayList3;
            }
            arrayList2.add((C8) qi2.f612a);
            InterfaceC0698x3[] interfaceC0698x3Arr = new InterfaceC0698x3[2];
            interfaceC0698x3Arr[i5] = c0673w32;
            interfaceC0698x3Arr[c2] = qi2.b;
            c0673w32 = new C0673w3(C0673w3.b(interfaceC0698x3Arr));
            i4 += computeRawVarint32Size;
            i3++;
            c = c2;
            i = i5;
            i2 = 4;
        }
        o82.f.f392a.d = (C8[]) arrayList2.toArray(new C8[arrayList2.size()]);
        arrayList.add(new Qi(o82, c0673w32));
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public De(Ge ge, F3 f3, Na na, Wf wf) {
        this.f397a = ge;
        this.b = f3;
        this.c = na;
        this.d = wf;
    }

    public final Ce a(List<Qi> list) {
        throw new UnsupportedOperationException();
    }
}
