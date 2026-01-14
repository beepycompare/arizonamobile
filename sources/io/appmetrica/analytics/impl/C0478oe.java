package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.oe  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0478oe implements InterfaceC0140b8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0577se f1155a;
    public final C0341j3 b;
    public final C0573sa c;
    public final Jf d;

    public C0478oe() {
        this(new C0577se(), new C0341j3(), new C0573sa(100), new Jf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Di> fromModel(C0453ne c0453ne) {
        Di di;
        C0621u8 c0621u8 = new C0621u8();
        c0621u8.f1253a = c0453ne.f1136a;
        c0621u8.f = new C0346j8();
        C0503pe c0503pe = c0453ne.b;
        C0295h8 c0295h8 = new C0295h8();
        c0295h8.f1026a = StringUtils.getUTF8Bytes(c0503pe.f1176a);
        Mn a2 = this.c.a(c0503pe.b);
        c0295h8.b = StringUtils.getUTF8Bytes((String) a2.f700a);
        c0295h8.e = c0503pe.c.size();
        Map<String, String> map = c0503pe.d;
        if (map != null) {
            di = this.f1155a.fromModel(map);
            c0295h8.c = (C0397l8) di.f553a;
        } else {
            di = null;
        }
        c0621u8.f.f1060a = c0295h8;
        int i = 0;
        char c = 1;
        C0109a3 c0109a3 = new C0109a3(C0109a3.b(a2, di));
        List list = c0503pe.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int computeInt32Size = c0621u8.f1253a != new C0621u8().f1253a ? CodedOutputByteBufferNano.computeInt32Size(1, c0621u8.f1253a) : 0;
        C0596t8 c0596t8 = c0621u8.b;
        if (c0596t8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(2, c0596t8);
        }
        C0546r8 c0546r8 = c0621u8.c;
        if (c0546r8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, c0546r8);
        }
        C0571s8 c0571s8 = c0621u8.d;
        int i2 = 4;
        if (c0571s8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, c0571s8);
        }
        C0192d8 c0192d8 = c0621u8.e;
        if (c0192d8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, c0192d8);
        }
        C0346j8 c0346j8 = c0621u8.f;
        if (c0346j8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, c0346j8);
        }
        ArrayList arrayList2 = new ArrayList();
        C0621u8 c0621u82 = new C0621u8();
        c0621u82.f1253a = c0621u8.f1253a;
        C0346j8 c0346j82 = new C0346j8();
        c0621u82.f = c0346j82;
        c0346j82.f1060a = new C0295h8();
        C0295h8 c0295h82 = c0621u82.f.f1060a;
        C0295h8 c0295h83 = c0621u8.f.f1060a;
        c0295h82.b = c0295h83.b;
        c0295h82.f1026a = c0295h83.f1026a;
        c0295h82.e = c0295h83.e;
        c0295h82.c = c0295h83.c;
        C0109a3 c0109a32 = c0109a3;
        int i3 = 0;
        int i4 = computeInt32Size;
        while (i3 < list.size()) {
            char c2 = c;
            C0321i8 c0321i8 = new C0321i8();
            c0321i8.f1041a = i3;
            int i5 = i;
            Di fromModel = this.b.fromModel((C0367k3) list.get(i3));
            c0321i8.b = (C0217e8) fromModel.f553a;
            fromModel.b.getBytesTruncated();
            Di di2 = new Di(c0321i8, fromModel);
            this.d.getClass();
            int computeTagSize = CodedOutputByteBufferNano.computeTagSize(i2);
            int computeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag((C0321i8) di2.f553a);
            int computeRawVarint32Size = computeTagSize + computeMessageSizeNoTag + ((computeMessageSizeNoTag & (-128)) == 0 ? i5 : CodedOutputByteBufferNano.computeRawVarint32Size(computeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i4 + computeRawVarint32Size > 204800) {
                c0621u82.f.f1060a.d = (C0321i8[]) arrayList2.toArray(new C0321i8[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new Di(c0621u82, c0109a32));
                C0621u8 c0621u83 = new C0621u8();
                c0621u83.f1253a = c0621u8.f1253a;
                C0346j8 c0346j83 = new C0346j8();
                c0621u83.f = c0346j83;
                c0346j83.f1060a = new C0295h8();
                C0295h8 c0295h84 = c0621u83.f.f1060a;
                C0295h8 c0295h85 = c0621u8.f.f1060a;
                c0295h84.b = c0295h85.b;
                c0295h84.f1026a = c0295h85.f1026a;
                c0295h84.e = c0295h85.e;
                c0295h84.c = c0295h85.c;
                c0109a32 = c0109a3;
                i4 = computeInt32Size;
                c0621u82 = c0621u83;
                arrayList2 = arrayList3;
            }
            arrayList2.add((C0321i8) di2.f553a);
            InterfaceC0135b3[] interfaceC0135b3Arr = new InterfaceC0135b3[2];
            interfaceC0135b3Arr[i5] = c0109a32;
            interfaceC0135b3Arr[c2] = di2.b;
            c0109a32 = new C0109a3(C0109a3.b(interfaceC0135b3Arr));
            i4 += computeRawVarint32Size;
            i3++;
            c = c2;
            i = i5;
            i2 = 4;
        }
        c0621u82.f.f1060a.d = (C0321i8[]) arrayList2.toArray(new C0321i8[arrayList2.size()]);
        arrayList.add(new Di(c0621u82, c0109a32));
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0478oe(C0577se c0577se, C0341j3 c0341j3, C0573sa c0573sa, Jf jf) {
        this.f1155a = c0577se;
        this.b = c0341j3;
        this.c = c0573sa;
        this.d = jf;
    }

    public final C0453ne a(List<Di> list) {
        throw new UnsupportedOperationException();
    }
}
