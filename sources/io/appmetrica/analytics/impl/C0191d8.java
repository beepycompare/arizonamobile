package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.d8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0191d8 extends MessageNano {
    public static volatile C0191d8[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0216e8 f959a;

    public C0191d8() {
        a();
    }

    public static C0191d8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0191d8[0];
                }
            }
        }
        return b;
    }

    public final C0191d8 a() {
        this.f959a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0216e8 c0216e8 = this.f959a;
        return c0216e8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, c0216e8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0216e8 c0216e8 = this.f959a;
        if (c0216e8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0216e8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0191d8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f959a == null) {
                    this.f959a = new C0216e8();
                }
                codedInputByteBufferNano.readMessage(this.f959a);
            }
        }
        return this;
    }

    public static C0191d8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0191d8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0191d8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0191d8) MessageNano.mergeFrom(new C0191d8(), bArr);
    }
}
