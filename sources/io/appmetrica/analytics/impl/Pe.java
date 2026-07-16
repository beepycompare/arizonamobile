package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public final class Pe implements InterfaceC0632u8 {

    /* renamed from: a  reason: collision with root package name */
    public final Te f719a;
    public final A3 b;
    public final Va c;
    public final C0381kg d;

    public Pe() {
        this(new Te(), new A3(), new Va(100), new C0381kg());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Xi> fromModel(Oe oe) {
        Xi xi;
        N8 n8 = new N8();
        n8.f682a = oe.f703a;
        n8.f = new C8();
        Qe qe = oe.b;
        A8 a8 = new A8();
        a8.f456a = StringUtils.getUTF8Bytes(qe.f734a);
        C0519po a2 = this.c.a(qe.b);
        a8.b = StringUtils.getUTF8Bytes((String) a2.f1155a);
        a8.e = qe.c.size();
        Map<String, String> map = qe.d;
        if (map != null) {
            xi = this.f719a.fromModel(map);
            a8.c = (E8) xi.f841a;
        } else {
            xi = null;
        }
        n8.f.f493a = a8;
        int i = 0;
        char c = 1;
        C0524q3 c0524q3 = new C0524q3(C0524q3.b(a2, xi));
        List list = qe.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int computeInt32Size = n8.f682a != new N8().f682a ? CodedOutputByteBufferNano.computeInt32Size(1, n8.f682a) : 0;
        M8 m8 = n8.b;
        if (m8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(2, m8);
        }
        K8 k8 = n8.c;
        if (k8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, k8);
        }
        L8 l8 = n8.d;
        int i2 = 4;
        if (l8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, l8);
        }
        C0684w8 c0684w8 = n8.e;
        if (c0684w8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, c0684w8);
        }
        C8 c8 = n8.f;
        if (c8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, c8);
        }
        ArrayList arrayList2 = new ArrayList();
        N8 n82 = new N8();
        n82.f682a = n8.f682a;
        C8 c82 = new C8();
        n82.f = c82;
        c82.f493a = new A8();
        A8 a82 = n82.f.f493a;
        A8 a83 = n8.f.f493a;
        a82.b = a83.b;
        a82.f456a = a83.f456a;
        a82.e = a83.e;
        a82.c = a83.c;
        C0524q3 c0524q32 = c0524q3;
        int i3 = 0;
        int i4 = computeInt32Size;
        while (i3 < list.size()) {
            char c2 = c;
            B8 b8 = new B8();
            b8.f473a = i3;
            int i5 = i;
            Xi fromModel = this.b.fromModel((B3) list.get(i3));
            b8.b = (C0710x8) fromModel.f841a;
            fromModel.b.getBytesTruncated();
            Xi xi2 = new Xi(b8, fromModel);
            this.d.getClass();
            int computeTagSize = CodedOutputByteBufferNano.computeTagSize(i2);
            int computeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag((B8) xi2.f841a);
            int computeRawVarint32Size = computeTagSize + computeMessageSizeNoTag + ((computeMessageSizeNoTag & (-128)) == 0 ? i5 : CodedOutputByteBufferNano.computeRawVarint32Size(computeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i4 + computeRawVarint32Size > 204800) {
                n82.f.f493a.d = (B8[]) arrayList2.toArray(new B8[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new Xi(n82, c0524q32));
                N8 n83 = new N8();
                n83.f682a = n8.f682a;
                C8 c83 = new C8();
                n83.f = c83;
                c83.f493a = new A8();
                A8 a84 = n83.f.f493a;
                A8 a85 = n8.f.f493a;
                a84.b = a85.b;
                a84.f456a = a85.f456a;
                a84.e = a85.e;
                a84.c = a85.c;
                c0524q32 = c0524q3;
                i4 = computeInt32Size;
                n82 = n83;
                arrayList2 = arrayList3;
            }
            arrayList2.add((B8) xi2.f841a);
            InterfaceC0549r3[] interfaceC0549r3Arr = new InterfaceC0549r3[2];
            interfaceC0549r3Arr[i5] = c0524q32;
            interfaceC0549r3Arr[c2] = xi2.b;
            c0524q32 = new C0524q3(C0524q3.b(interfaceC0549r3Arr));
            i4 += computeRawVarint32Size;
            i3++;
            c = c2;
            i = i5;
            i2 = 4;
        }
        n82.f.f493a.d = (B8[]) arrayList2.toArray(new B8[arrayList2.size()]);
        arrayList.add(new Xi(n82, c0524q32));
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Pe(Te te, A3 a3, Va va, C0381kg c0381kg) {
        this.f719a = te;
        this.b = a3;
        this.c = va;
        this.d = c0381kg;
    }

    public final Oe a(List<Xi> list) {
        throw new UnsupportedOperationException();
    }
}
