package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.h9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0292h9 extends MessageNano {
    public static volatile C0292h9[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f908a;
    public long b;

    public C0292h9() {
        a();
    }

    public static C0292h9[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0292h9[0];
                }
            }
        }
        return c;
    }

    public final C0292h9 a() {
        this.f908a = "";
        this.b = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeStringSize(1, this.f908a) + super.computeSerializedSize();
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f908a);
        codedOutputByteBufferNano.writeUInt64(2, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0292h9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f908a = codedInputByteBufferNano.readString();
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.b = codedInputByteBufferNano.readUInt64();
            }
        }
        return this;
    }

    public static C0292h9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0292h9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0292h9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0292h9) MessageNano.mergeFrom(new C0292h9(), bArr);
    }
}
