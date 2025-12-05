package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.j8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0341j8 extends MessageNano {
    public static volatile C0341j8[] c;

    /* renamed from: a  reason: collision with root package name */
    public int f1035a;
    public C0238f8 b;

    public C0341j8() {
        a();
    }

    public static C0341j8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0341j8[0];
                }
            }
        }
        return c;
    }

    public final C0341j8 a() {
        this.f1035a = 0;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f1035a;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        C0238f8 c0238f8 = this.b;
        return c0238f8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0238f8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f1035a;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        C0238f8 c0238f8 = this.b;
        if (c0238f8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0238f8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0341j8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f1035a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0238f8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0341j8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0341j8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0341j8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0341j8) MessageNano.mergeFrom(new C0341j8(), bArr);
    }
}
