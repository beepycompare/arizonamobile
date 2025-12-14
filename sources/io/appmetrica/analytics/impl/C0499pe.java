package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.pe  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0499pe implements InterfaceC0161c8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0598te f1164a;
    public final C0362k3 b;
    public final C0594ta c;
    public final Kf d;

    public C0499pe() {
        this(new C0598te(), new C0362k3(), new C0594ta(100), new Kf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ei> fromModel(C0474oe c0474oe) {
        Ei ei;
        C0642v8 c0642v8 = new C0642v8();
        c0642v8.f1262a = c0474oe.f1145a;
        c0642v8.f = new C0367k8();
        C0524qe c0524qe = c0474oe.b;
        C0316i8 c0316i8 = new C0316i8();
        c0316i8.f1034a = StringUtils.getUTF8Bytes(c0524qe.f1185a);
        Nn a2 = this.c.a(c0524qe.b);
        c0316i8.b = StringUtils.getUTF8Bytes((String) a2.f708a);
        c0316i8.e = c0524qe.c.size();
        Map<String, String> map = c0524qe.d;
        if (map != null) {
            ei = this.f1164a.fromModel(map);
            c0316i8.c = (C0418m8) ei.f560a;
        } else {
            ei = null;
        }
        c0642v8.f.f1069a = c0316i8;
        int i = 0;
        char c = 1;
        C0130b3 c0130b3 = new C0130b3(C0130b3.b(a2, ei));
        List list = c0524qe.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int computeInt32Size = c0642v8.f1262a != new C0642v8().f1262a ? CodedOutputByteBufferNano.computeInt32Size(1, c0642v8.f1262a) : 0;
        C0617u8 c0617u8 = c0642v8.b;
        if (c0617u8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(2, c0617u8);
        }
        C0567s8 c0567s8 = c0642v8.c;
        if (c0567s8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, c0567s8);
        }
        C0592t8 c0592t8 = c0642v8.d;
        int i2 = 4;
        if (c0592t8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, c0592t8);
        }
        C0212e8 c0212e8 = c0642v8.e;
        if (c0212e8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, c0212e8);
        }
        C0367k8 c0367k8 = c0642v8.f;
        if (c0367k8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, c0367k8);
        }
        ArrayList arrayList2 = new ArrayList();
        C0642v8 c0642v82 = new C0642v8();
        c0642v82.f1262a = c0642v8.f1262a;
        C0367k8 c0367k82 = new C0367k8();
        c0642v82.f = c0367k82;
        c0367k82.f1069a = new C0316i8();
        C0316i8 c0316i82 = c0642v82.f.f1069a;
        C0316i8 c0316i83 = c0642v8.f.f1069a;
        c0316i82.b = c0316i83.b;
        c0316i82.f1034a = c0316i83.f1034a;
        c0316i82.e = c0316i83.e;
        c0316i82.c = c0316i83.c;
        C0130b3 c0130b32 = c0130b3;
        int i3 = 0;
        int i4 = computeInt32Size;
        while (i3 < list.size()) {
            char c2 = c;
            C0341j8 c0341j8 = new C0341j8();
            c0341j8.f1049a = i3;
            int i5 = i;
            Ei fromModel = this.b.fromModel((C0388l3) list.get(i3));
            c0341j8.b = (C0238f8) fromModel.f560a;
            fromModel.b.getBytesTruncated();
            Ei ei2 = new Ei(c0341j8, fromModel);
            this.d.getClass();
            int computeTagSize = CodedOutputByteBufferNano.computeTagSize(i2);
            int computeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag((C0341j8) ei2.f560a);
            int computeRawVarint32Size = computeTagSize + computeMessageSizeNoTag + ((computeMessageSizeNoTag & (-128)) == 0 ? i5 : CodedOutputByteBufferNano.computeRawVarint32Size(computeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i4 + computeRawVarint32Size > 204800) {
                c0642v82.f.f1069a.d = (C0341j8[]) arrayList2.toArray(new C0341j8[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new Ei(c0642v82, c0130b32));
                C0642v8 c0642v83 = new C0642v8();
                c0642v83.f1262a = c0642v8.f1262a;
                C0367k8 c0367k83 = new C0367k8();
                c0642v83.f = c0367k83;
                c0367k83.f1069a = new C0316i8();
                C0316i8 c0316i84 = c0642v83.f.f1069a;
                C0316i8 c0316i85 = c0642v8.f.f1069a;
                c0316i84.b = c0316i85.b;
                c0316i84.f1034a = c0316i85.f1034a;
                c0316i84.e = c0316i85.e;
                c0316i84.c = c0316i85.c;
                c0130b32 = c0130b3;
                i4 = computeInt32Size;
                c0642v82 = c0642v83;
                arrayList2 = arrayList3;
            }
            arrayList2.add((C0341j8) ei2.f560a);
            InterfaceC0156c3[] interfaceC0156c3Arr = new InterfaceC0156c3[2];
            interfaceC0156c3Arr[i5] = c0130b32;
            interfaceC0156c3Arr[c2] = ei2.b;
            c0130b32 = new C0130b3(C0130b3.b(interfaceC0156c3Arr));
            i4 += computeRawVarint32Size;
            i3++;
            c = c2;
            i = i5;
            i2 = 4;
        }
        c0642v82.f.f1069a.d = (C0341j8[]) arrayList2.toArray(new C0341j8[arrayList2.size()]);
        arrayList.add(new Ei(c0642v82, c0130b32));
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0499pe(C0598te c0598te, C0362k3 c0362k3, C0594ta c0594ta, Kf kf) {
        this.f1164a = c0598te;
        this.b = c0362k3;
        this.c = c0594ta;
        this.d = kf;
    }

    public final C0474oe a(List<Ei> list) {
        throw new UnsupportedOperationException();
    }
}
