package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class B8 extends MessageNano {
    public static volatile B8[] c;

    /* renamed from: a  reason: collision with root package name */
    public int f470a;
    public C0710x8 b;

    public B8() {
        a();
    }

    public static B8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new B8[0];
                }
            }
        }
        return c;
    }

    public final B8 a() {
        this.f470a = 0;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f470a;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        C0710x8 c0710x8 = this.b;
        return c0710x8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0710x8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f470a;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        C0710x8 c0710x8 = this.b;
        if (c0710x8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0710x8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final B8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f470a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0710x8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static B8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new B8().mergeFrom(codedInputByteBufferNano);
    }

    public static B8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (B8) MessageNano.mergeFrom(new B8(), bArr);
    }
}
