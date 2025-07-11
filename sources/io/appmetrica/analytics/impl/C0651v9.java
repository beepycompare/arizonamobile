package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.v9  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0651v9 extends MessageNano {
    public static volatile C0651v9[] c;

    /* renamed from: a  reason: collision with root package name */
    public int f1089a;
    public String b;

    public C0651v9() {
        a();
    }

    public static C0651v9[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0651v9[0];
                }
            }
        }
        return c;
    }

    public final C0651v9 a() {
        this.f1089a = 2;
        this.b = "";
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f1089a;
        if (i != 2) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(3, i);
        }
        return !this.b.equals("") ? CodedOutputByteBufferNano.computeStringSize(4, this.b) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f1089a;
        if (i != 2) {
            codedOutputByteBufferNano.writeInt32(3, i);
        }
        if (!this.b.equals("")) {
            codedOutputByteBufferNano.writeString(4, this.b);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0651v9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag == 24) {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    switch (readInt32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                            this.f1089a = readInt32;
                            continue;
                    }
                } else if (readTag != 34) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    }
                } else {
                    this.b = codedInputByteBufferNano.readString();
                }
            }
        }
        return this;
    }

    public static C0651v9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0651v9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0651v9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0651v9) MessageNano.mergeFrom(new C0651v9(), bArr);
    }
}
