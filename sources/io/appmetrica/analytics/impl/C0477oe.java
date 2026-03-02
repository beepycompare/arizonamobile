package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.oe  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0477oe implements InterfaceC0139b8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0576se f1154a;
    public final C0340j3 b;
    public final C0572sa c;
    public final Jf d;

    public C0477oe() {
        this(new C0576se(), new C0340j3(), new C0572sa(100), new Jf());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Di> fromModel(C0452ne c0452ne) {
        Di di;
        C0620u8 c0620u8 = new C0620u8();
        c0620u8.f1252a = c0452ne.f1135a;
        c0620u8.f = new C0345j8();
        C0502pe c0502pe = c0452ne.b;
        C0294h8 c0294h8 = new C0294h8();
        c0294h8.f1025a = StringUtils.getUTF8Bytes(c0502pe.f1175a);
        Mn a2 = this.c.a(c0502pe.b);
        c0294h8.b = StringUtils.getUTF8Bytes((String) a2.f699a);
        c0294h8.e = c0502pe.c.size();
        Map<String, String> map = c0502pe.d;
        if (map != null) {
            di = this.f1154a.fromModel(map);
            c0294h8.c = (C0396l8) di.f552a;
        } else {
            di = null;
        }
        c0620u8.f.f1059a = c0294h8;
        int i = 0;
        char c = 1;
        C0108a3 c0108a3 = new C0108a3(C0108a3.b(a2, di));
        List list = c0502pe.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int computeInt32Size = c0620u8.f1252a != new C0620u8().f1252a ? CodedOutputByteBufferNano.computeInt32Size(1, c0620u8.f1252a) : 0;
        C0595t8 c0595t8 = c0620u8.b;
        if (c0595t8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(2, c0595t8);
        }
        C0545r8 c0545r8 = c0620u8.c;
        if (c0545r8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, c0545r8);
        }
        C0570s8 c0570s8 = c0620u8.d;
        int i2 = 4;
        if (c0570s8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, c0570s8);
        }
        C0191d8 c0191d8 = c0620u8.e;
        if (c0191d8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, c0191d8);
        }
        C0345j8 c0345j8 = c0620u8.f;
        if (c0345j8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, c0345j8);
        }
        ArrayList arrayList2 = new ArrayList();
        C0620u8 c0620u82 = new C0620u8();
        c0620u82.f1252a = c0620u8.f1252a;
        C0345j8 c0345j82 = new C0345j8();
        c0620u82.f = c0345j82;
        c0345j82.f1059a = new C0294h8();
        C0294h8 c0294h82 = c0620u82.f.f1059a;
        C0294h8 c0294h83 = c0620u8.f.f1059a;
        c0294h82.b = c0294h83.b;
        c0294h82.f1025a = c0294h83.f1025a;
        c0294h82.e = c0294h83.e;
        c0294h82.c = c0294h83.c;
        C0108a3 c0108a32 = c0108a3;
        int i3 = 0;
        int i4 = computeInt32Size;
        while (i3 < list.size()) {
            char c2 = c;
            C0320i8 c0320i8 = new C0320i8();
            c0320i8.f1040a = i3;
            int i5 = i;
            Di fromModel = this.b.fromModel((C0366k3) list.get(i3));
            c0320i8.b = (C0216e8) fromModel.f552a;
            fromModel.b.getBytesTruncated();
            Di di2 = new Di(c0320i8, fromModel);
            this.d.getClass();
            int computeTagSize = CodedOutputByteBufferNano.computeTagSize(i2);
            int computeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag((C0320i8) di2.f552a);
            int computeRawVarint32Size = computeTagSize + computeMessageSizeNoTag + ((computeMessageSizeNoTag & (-128)) == 0 ? i5 : CodedOutputByteBufferNano.computeRawVarint32Size(computeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i4 + computeRawVarint32Size > 204800) {
                c0620u82.f.f1059a.d = (C0320i8[]) arrayList2.toArray(new C0320i8[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new Di(c0620u82, c0108a32));
                C0620u8 c0620u83 = new C0620u8();
                c0620u83.f1252a = c0620u8.f1252a;
                C0345j8 c0345j83 = new C0345j8();
                c0620u83.f = c0345j83;
                c0345j83.f1059a = new C0294h8();
                C0294h8 c0294h84 = c0620u83.f.f1059a;
                C0294h8 c0294h85 = c0620u8.f.f1059a;
                c0294h84.b = c0294h85.b;
                c0294h84.f1025a = c0294h85.f1025a;
                c0294h84.e = c0294h85.e;
                c0294h84.c = c0294h85.c;
                c0108a32 = c0108a3;
                i4 = computeInt32Size;
                c0620u82 = c0620u83;
                arrayList2 = arrayList3;
            }
            arrayList2.add((C0320i8) di2.f552a);
            InterfaceC0134b3[] interfaceC0134b3Arr = new InterfaceC0134b3[2];
            interfaceC0134b3Arr[i5] = c0108a32;
            interfaceC0134b3Arr[c2] = di2.b;
            c0108a32 = new C0108a3(C0108a3.b(interfaceC0134b3Arr));
            i4 += computeRawVarint32Size;
            i3++;
            c = c2;
            i = i5;
            i2 = 4;
        }
        c0620u82.f.f1059a.d = (C0320i8[]) arrayList2.toArray(new C0320i8[arrayList2.size()]);
        arrayList.add(new Di(c0620u82, c0108a32));
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0477oe(C0576se c0576se, C0340j3 c0340j3, C0572sa c0572sa, Jf jf) {
        this.f1154a = c0576se;
        this.b = c0340j3;
        this.c = c0572sa;
        this.d = jf;
    }

    public final C0452ne a(List<Di> list) {
        throw new UnsupportedOperationException();
    }
}
