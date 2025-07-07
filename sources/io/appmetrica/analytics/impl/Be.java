package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Be implements InterfaceC0583s8 {

    /* renamed from: a  reason: collision with root package name */
    public final Ee f355a;
    public final F3 b;
    public final La c;
    public final Uf d;

    public Be() {
        this(new Ee(), new F3(), new La(100), new Uf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ni> fromModel(Ae ae) {
        Ni ni;
        L8 l8 = new L8();
        l8.f515a = ae.f335a;
        l8.f = new A8();
        Ce ce = ae.b;
        C0733y8 c0733y8 = new C0733y8();
        c0733y8.f1141a = StringUtils.getUTF8Bytes(ce.f373a);
        Gn a2 = this.c.a(ce.b);
        c0733y8.b = StringUtils.getUTF8Bytes((String) a2.f449a);
        c0733y8.e = ce.c.size();
        Map<String, String> map = ce.d;
        if (map != null) {
            ni = this.f355a.fromModel(map);
            c0733y8.c = (C8) ni.f556a;
        } else {
            ni = null;
        }
        l8.f.f332a = c0733y8;
        int i = 0;
        char c = 1;
        C0678w3 c0678w3 = new C0678w3(C0678w3.b(a2, ni));
        List list = ce.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int computeInt32Size = l8.f515a != new L8().f515a ? CodedOutputByteBufferNano.computeInt32Size(1, l8.f515a) : 0;
        K8 k8 = l8.b;
        if (k8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(2, k8);
        }
        I8 i8 = l8.c;
        if (i8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, i8);
        }
        J8 j8 = l8.d;
        int i2 = 4;
        if (j8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, j8);
        }
        C0633u8 c0633u8 = l8.e;
        if (c0633u8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, c0633u8);
        }
        A8 a8 = l8.f;
        if (a8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, a8);
        }
        ArrayList arrayList2 = new ArrayList();
        L8 l82 = new L8();
        l82.f515a = l8.f515a;
        A8 a82 = new A8();
        l82.f = a82;
        a82.f332a = new C0733y8();
        C0733y8 c0733y82 = l82.f.f332a;
        C0733y8 c0733y83 = l8.f.f332a;
        c0733y82.b = c0733y83.b;
        c0733y82.f1141a = c0733y83.f1141a;
        c0733y82.e = c0733y83.e;
        c0733y82.c = c0733y83.c;
        C0678w3 c0678w32 = c0678w3;
        int i3 = 0;
        int i4 = computeInt32Size;
        while (i3 < list.size()) {
            char c2 = c;
            C0758z8 c0758z8 = new C0758z8();
            c0758z8.f1161a = i3;
            int i5 = i;
            Ni fromModel = this.b.fromModel((G3) list.get(i3));
            c0758z8.b = (C0658v8) fromModel.f556a;
            fromModel.b.getBytesTruncated();
            Ni ni2 = new Ni(c0758z8, fromModel);
            this.d.getClass();
            int computeTagSize = CodedOutputByteBufferNano.computeTagSize(i2);
            int computeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag((C0758z8) ni2.f556a);
            int computeRawVarint32Size = computeTagSize + computeMessageSizeNoTag + ((computeMessageSizeNoTag & (-128)) == 0 ? i5 : CodedOutputByteBufferNano.computeRawVarint32Size(computeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i4 + computeRawVarint32Size > 204800) {
                l82.f.f332a.d = (C0758z8[]) arrayList2.toArray(new C0758z8[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new Ni(l82, c0678w32));
                L8 l83 = new L8();
                l83.f515a = l8.f515a;
                A8 a83 = new A8();
                l83.f = a83;
                a83.f332a = new C0733y8();
                C0733y8 c0733y84 = l83.f.f332a;
                C0733y8 c0733y85 = l8.f.f332a;
                c0733y84.b = c0733y85.b;
                c0733y84.f1141a = c0733y85.f1141a;
                c0733y84.e = c0733y85.e;
                c0733y84.c = c0733y85.c;
                c0678w32 = c0678w3;
                i4 = computeInt32Size;
                l82 = l83;
                arrayList2 = arrayList3;
            }
            arrayList2.add((C0758z8) ni2.f556a);
            InterfaceC0703x3[] interfaceC0703x3Arr = new InterfaceC0703x3[2];
            interfaceC0703x3Arr[i5] = c0678w32;
            interfaceC0703x3Arr[c2] = ni2.b;
            c0678w32 = new C0678w3(C0678w3.b(interfaceC0703x3Arr));
            i4 += computeRawVarint32Size;
            i3++;
            c = c2;
            i = i5;
            i2 = 4;
        }
        l82.f.f332a.d = (C0758z8[]) arrayList2.toArray(new C0758z8[arrayList2.size()]);
        arrayList.add(new Ni(l82, c0678w32));
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Be(Ee ee, F3 f3, La la, Uf uf) {
        this.f355a = ee;
        this.b = f3;
        this.c = la;
        this.d = uf;
    }

    public final Ae a(List<Ni> list) {
        throw new UnsupportedOperationException();
    }
}
