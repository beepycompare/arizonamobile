package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public final class Be implements InterfaceC0575s8 {

    /* renamed from: a  reason: collision with root package name */
    public final Ee f356a;
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
        l8.f516a = ae.f336a;
        l8.f = new A8();
        Ce ce = ae.b;
        C0725y8 c0725y8 = new C0725y8();
        c0725y8.f1142a = StringUtils.getUTF8Bytes(ce.f374a);
        Gn a2 = this.c.a(ce.b);
        c0725y8.b = StringUtils.getUTF8Bytes((String) a2.f450a);
        c0725y8.e = ce.c.size();
        Map<String, String> map = ce.d;
        if (map != null) {
            ni = this.f356a.fromModel(map);
            c0725y8.c = (C8) ni.f557a;
        } else {
            ni = null;
        }
        l8.f.f333a = c0725y8;
        int i = 0;
        char c = 1;
        C0670w3 c0670w3 = new C0670w3(C0670w3.b(a2, ni));
        List list = ce.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int computeInt32Size = l8.f516a != new L8().f516a ? CodedOutputByteBufferNano.computeInt32Size(1, l8.f516a) : 0;
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
        C0625u8 c0625u8 = l8.e;
        if (c0625u8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, c0625u8);
        }
        A8 a8 = l8.f;
        if (a8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, a8);
        }
        ArrayList arrayList2 = new ArrayList();
        L8 l82 = new L8();
        l82.f516a = l8.f516a;
        A8 a82 = new A8();
        l82.f = a82;
        a82.f333a = new C0725y8();
        C0725y8 c0725y82 = l82.f.f333a;
        C0725y8 c0725y83 = l8.f.f333a;
        c0725y82.b = c0725y83.b;
        c0725y82.f1142a = c0725y83.f1142a;
        c0725y82.e = c0725y83.e;
        c0725y82.c = c0725y83.c;
        C0670w3 c0670w32 = c0670w3;
        int i3 = 0;
        int i4 = computeInt32Size;
        while (i3 < list.size()) {
            char c2 = c;
            C0750z8 c0750z8 = new C0750z8();
            c0750z8.f1162a = i3;
            int i5 = i;
            Ni fromModel = this.b.fromModel((G3) list.get(i3));
            c0750z8.b = (C0650v8) fromModel.f557a;
            fromModel.b.getBytesTruncated();
            Ni ni2 = new Ni(c0750z8, fromModel);
            this.d.getClass();
            int computeTagSize = CodedOutputByteBufferNano.computeTagSize(i2);
            int computeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag((C0750z8) ni2.f557a);
            int computeRawVarint32Size = computeTagSize + computeMessageSizeNoTag + ((computeMessageSizeNoTag & (-128)) == 0 ? i5 : CodedOutputByteBufferNano.computeRawVarint32Size(computeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i4 + computeRawVarint32Size > 204800) {
                l82.f.f333a.d = (C0750z8[]) arrayList2.toArray(new C0750z8[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new Ni(l82, c0670w32));
                L8 l83 = new L8();
                l83.f516a = l8.f516a;
                A8 a83 = new A8();
                l83.f = a83;
                a83.f333a = new C0725y8();
                C0725y8 c0725y84 = l83.f.f333a;
                C0725y8 c0725y85 = l8.f.f333a;
                c0725y84.b = c0725y85.b;
                c0725y84.f1142a = c0725y85.f1142a;
                c0725y84.e = c0725y85.e;
                c0725y84.c = c0725y85.c;
                c0670w32 = c0670w3;
                i4 = computeInt32Size;
                l82 = l83;
                arrayList2 = arrayList3;
            }
            arrayList2.add((C0750z8) ni2.f557a);
            InterfaceC0695x3[] interfaceC0695x3Arr = new InterfaceC0695x3[2];
            interfaceC0695x3Arr[i5] = c0670w32;
            interfaceC0695x3Arr[c2] = ni2.b;
            c0670w32 = new C0670w3(C0670w3.b(interfaceC0695x3Arr));
            i4 += computeRawVarint32Size;
            i3++;
            c = c2;
            i = i5;
            i2 = 4;
        }
        l82.f.f333a.d = (C0750z8[]) arrayList2.toArray(new C0750z8[arrayList2.size()]);
        arrayList.add(new Ni(l82, c0670w32));
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public Be(Ee ee, F3 f3, La la, Uf uf) {
        this.f356a = ee;
        this.b = f3;
        this.c = la;
        this.d = uf;
    }

    public final Ae a(List<Ni> list) {
        throw new UnsupportedOperationException();
    }
}
