package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.pe  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0500pe implements InterfaceC0162c8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0599te f1067a;
    public final C0363k3 b;
    public final C0595ta c;
    public final Kf d;

    public C0500pe() {
        this(new C0599te(), new C0363k3(), new C0595ta(100), new Kf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ei> fromModel(C0475oe c0475oe) {
        Ei ei;
        C0643v8 c0643v8 = new C0643v8();
        c0643v8.f1165a = c0475oe.f1048a;
        c0643v8.f = new C0368k8();
        C0525qe c0525qe = c0475oe.b;
        C0317i8 c0317i8 = new C0317i8();
        c0317i8.f937a = StringUtils.getUTF8Bytes(c0525qe.f1088a);
        Nn a2 = this.c.a(c0525qe.b);
        c0317i8.b = StringUtils.getUTF8Bytes((String) a2.f611a);
        c0317i8.e = c0525qe.c.size();
        Map<String, String> map = c0525qe.d;
        if (map != null) {
            ei = this.f1067a.fromModel(map);
            c0317i8.c = (C0419m8) ei.f463a;
        } else {
            ei = null;
        }
        c0643v8.f.f972a = c0317i8;
        int i = 0;
        char c = 1;
        C0131b3 c0131b3 = new C0131b3(C0131b3.b(a2, ei));
        List list = c0525qe.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int computeInt32Size = c0643v8.f1165a != new C0643v8().f1165a ? CodedOutputByteBufferNano.computeInt32Size(1, c0643v8.f1165a) : 0;
        C0618u8 c0618u8 = c0643v8.b;
        if (c0618u8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(2, c0618u8);
        }
        C0568s8 c0568s8 = c0643v8.c;
        if (c0568s8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, c0568s8);
        }
        C0593t8 c0593t8 = c0643v8.d;
        int i2 = 4;
        if (c0593t8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, c0593t8);
        }
        C0213e8 c0213e8 = c0643v8.e;
        if (c0213e8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, c0213e8);
        }
        C0368k8 c0368k8 = c0643v8.f;
        if (c0368k8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, c0368k8);
        }
        ArrayList arrayList2 = new ArrayList();
        C0643v8 c0643v82 = new C0643v8();
        c0643v82.f1165a = c0643v8.f1165a;
        C0368k8 c0368k82 = new C0368k8();
        c0643v82.f = c0368k82;
        c0368k82.f972a = new C0317i8();
        C0317i8 c0317i82 = c0643v82.f.f972a;
        C0317i8 c0317i83 = c0643v8.f.f972a;
        c0317i82.b = c0317i83.b;
        c0317i82.f937a = c0317i83.f937a;
        c0317i82.e = c0317i83.e;
        c0317i82.c = c0317i83.c;
        C0131b3 c0131b32 = c0131b3;
        int i3 = 0;
        int i4 = computeInt32Size;
        while (i3 < list.size()) {
            char c2 = c;
            C0342j8 c0342j8 = new C0342j8();
            c0342j8.f952a = i3;
            int i5 = i;
            Ei fromModel = this.b.fromModel((C0389l3) list.get(i3));
            c0342j8.b = (C0239f8) fromModel.f463a;
            fromModel.b.getBytesTruncated();
            Ei ei2 = new Ei(c0342j8, fromModel);
            this.d.getClass();
            int computeTagSize = CodedOutputByteBufferNano.computeTagSize(i2);
            int computeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag((C0342j8) ei2.f463a);
            int computeRawVarint32Size = computeTagSize + computeMessageSizeNoTag + ((computeMessageSizeNoTag & (-128)) == 0 ? i5 : CodedOutputByteBufferNano.computeRawVarint32Size(computeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i4 + computeRawVarint32Size > 204800) {
                c0643v82.f.f972a.d = (C0342j8[]) arrayList2.toArray(new C0342j8[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new Ei(c0643v82, c0131b32));
                C0643v8 c0643v83 = new C0643v8();
                c0643v83.f1165a = c0643v8.f1165a;
                C0368k8 c0368k83 = new C0368k8();
                c0643v83.f = c0368k83;
                c0368k83.f972a = new C0317i8();
                C0317i8 c0317i84 = c0643v83.f.f972a;
                C0317i8 c0317i85 = c0643v8.f.f972a;
                c0317i84.b = c0317i85.b;
                c0317i84.f937a = c0317i85.f937a;
                c0317i84.e = c0317i85.e;
                c0317i84.c = c0317i85.c;
                c0131b32 = c0131b3;
                i4 = computeInt32Size;
                c0643v82 = c0643v83;
                arrayList2 = arrayList3;
            }
            arrayList2.add((C0342j8) ei2.f463a);
            InterfaceC0157c3[] interfaceC0157c3Arr = new InterfaceC0157c3[2];
            interfaceC0157c3Arr[i5] = c0131b32;
            interfaceC0157c3Arr[c2] = ei2.b;
            c0131b32 = new C0131b3(C0131b3.b(interfaceC0157c3Arr));
            i4 += computeRawVarint32Size;
            i3++;
            c = c2;
            i = i5;
            i2 = 4;
        }
        c0643v82.f.f972a.d = (C0342j8[]) arrayList2.toArray(new C0342j8[arrayList2.size()]);
        arrayList.add(new Ei(c0643v82, c0131b32));
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0500pe(C0599te c0599te, C0363k3 c0363k3, C0595ta c0595ta, Kf kf) {
        this.f1067a = c0599te;
        this.b = c0363k3;
        this.c = c0595ta;
        this.d = kf;
    }

    public final C0475oe a(List<Ei> list) {
        throw new UnsupportedOperationException();
    }
}
