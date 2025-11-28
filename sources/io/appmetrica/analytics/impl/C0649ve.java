package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* renamed from: io.appmetrica.analytics.impl.ve  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0649ve implements InterfaceC0291h8 {

    /* renamed from: a  reason: collision with root package name */
    public final C0724ye f1170a;
    public final C0538r3 b;
    public final C0745za c;
    public final Of d;

    public C0649ve() {
        this(new C0724ye(), new C0538r3(), new C0745za(100), new Of());
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    /* renamed from: a */
    public final List<Ii> fromModel(C0624ue c0624ue) {
        Ii ii;
        A8 a8 = new A8();
        a8.f393a = c0624ue.f1151a;
        a8.f = new C0494p8();
        C0674we c0674we = c0624ue.b;
        C0444n8 c0444n8 = new C0444n8();
        c0444n8.f1022a = StringUtils.getUTF8Bytes(c0674we.f1186a);
        On a2 = this.c.a(c0674we.b);
        c0444n8.b = StringUtils.getUTF8Bytes((String) a2.f625a);
        c0444n8.e = c0674we.c.size();
        Map<String, String> map = c0674we.d;
        if (map != null) {
            ii = this.f1170a.fromModel(map);
            c0444n8.c = (C0543r8) ii.f530a;
        } else {
            ii = null;
        }
        a8.f.f1053a = c0444n8;
        int i = 0;
        char c = 1;
        C0312i3 c0312i3 = new C0312i3(C0312i3.b(a2, ii));
        List list = c0674we.c;
        ArrayList arrayList = new ArrayList();
        this.d.getClass();
        int computeInt32Size = a8.f393a != new A8().f393a ? CodedOutputByteBufferNano.computeInt32Size(1, a8.f393a) : 0;
        C0743z8 c0743z8 = a8.b;
        if (c0743z8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(2, c0743z8);
        }
        C0693x8 c0693x8 = a8.c;
        if (c0693x8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, c0693x8);
        }
        C0718y8 c0718y8 = a8.d;
        int i2 = 4;
        if (c0718y8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(4, c0718y8);
        }
        C0342j8 c0342j8 = a8.e;
        if (c0342j8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(5, c0342j8);
        }
        C0494p8 c0494p8 = a8.f;
        if (c0494p8 != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(6, c0494p8);
        }
        ArrayList arrayList2 = new ArrayList();
        A8 a82 = new A8();
        a82.f393a = a8.f393a;
        C0494p8 c0494p82 = new C0494p8();
        a82.f = c0494p82;
        c0494p82.f1053a = new C0444n8();
        C0444n8 c0444n82 = a82.f.f1053a;
        C0444n8 c0444n83 = a8.f.f1053a;
        c0444n82.b = c0444n83.b;
        c0444n82.f1022a = c0444n83.f1022a;
        c0444n82.e = c0444n83.e;
        c0444n82.c = c0444n83.c;
        C0312i3 c0312i32 = c0312i3;
        int i3 = 0;
        int i4 = computeInt32Size;
        while (i3 < list.size()) {
            char c2 = c;
            C0469o8 c0469o8 = new C0469o8();
            c0469o8.f1037a = i3;
            int i5 = i;
            Ii fromModel = this.b.fromModel((C0563s3) list.get(i3));
            c0469o8.b = (C0368k8) fromModel.f530a;
            fromModel.b.getBytesTruncated();
            Ii ii2 = new Ii(c0469o8, fromModel);
            this.d.getClass();
            int computeTagSize = CodedOutputByteBufferNano.computeTagSize(i2);
            int computeMessageSizeNoTag = CodedOutputByteBufferNano.computeMessageSizeNoTag((C0469o8) ii2.f530a);
            int computeRawVarint32Size = computeTagSize + computeMessageSizeNoTag + ((computeMessageSizeNoTag & (-128)) == 0 ? i5 : CodedOutputByteBufferNano.computeRawVarint32Size(computeMessageSizeNoTag));
            if (arrayList2.size() != 0 && i4 + computeRawVarint32Size > 204800) {
                a82.f.f1053a.d = (C0469o8[]) arrayList2.toArray(new C0469o8[arrayList2.size()]);
                ArrayList arrayList3 = new ArrayList();
                arrayList.add(new Ii(a82, c0312i32));
                A8 a83 = new A8();
                a83.f393a = a8.f393a;
                C0494p8 c0494p83 = new C0494p8();
                a83.f = c0494p83;
                c0494p83.f1053a = new C0444n8();
                C0444n8 c0444n84 = a83.f.f1053a;
                C0444n8 c0444n85 = a8.f.f1053a;
                c0444n84.b = c0444n85.b;
                c0444n84.f1022a = c0444n85.f1022a;
                c0444n84.e = c0444n85.e;
                c0444n84.c = c0444n85.c;
                c0312i32 = c0312i3;
                i4 = computeInt32Size;
                a82 = a83;
                arrayList2 = arrayList3;
            }
            arrayList2.add((C0469o8) ii2.f530a);
            InterfaceC0337j3[] interfaceC0337j3Arr = new InterfaceC0337j3[2];
            interfaceC0337j3Arr[i5] = c0312i32;
            interfaceC0337j3Arr[c2] = ii2.b;
            c0312i32 = new C0312i3(C0312i3.b(interfaceC0337j3Arr));
            i4 += computeRawVarint32Size;
            i3++;
            c = c2;
            i = i5;
            i2 = 4;
        }
        a82.f.f1053a.d = (C0469o8[]) arrayList2.toArray(new C0469o8[arrayList2.size()]);
        arrayList.add(new Ii(a82, c0312i32));
        return arrayList;
    }

    @Override // io.appmetrica.analytics.coreapi.internal.data.Converter
    public final Object toModel(Object obj) {
        List list = (List) obj;
        throw new UnsupportedOperationException();
    }

    public C0649ve(C0724ye c0724ye, C0538r3 c0538r3, C0745za c0745za, Of of) {
        this.f1170a = c0724ye;
        this.b = c0538r3;
        this.c = c0745za;
        this.d = of;
    }

    public final C0624ue a(List<Ii> list) {
        throw new UnsupportedOperationException();
    }
}
