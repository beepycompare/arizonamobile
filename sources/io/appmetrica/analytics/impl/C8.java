package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class C8 extends MessageNano {
    public static volatile C8[] c;

    /* renamed from: a  reason: collision with root package name */
    public int f375a;
    public C0727y8 b;

    public C8() {
        a();
    }

    public static C8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C8[0];
                }
            }
        }
        return c;
    }

    public final C8 a() {
        this.f375a = 0;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f375a;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        C0727y8 c0727y8 = this.b;
        return c0727y8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0727y8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f375a;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        C0727y8 c0727y8 = this.b;
        if (c0727y8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0727y8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f375a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0727y8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C8().mergeFrom(codedInputByteBufferNano);
    }

    public static C8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C8) MessageNano.mergeFrom(new C8(), bArr);
    }
}
