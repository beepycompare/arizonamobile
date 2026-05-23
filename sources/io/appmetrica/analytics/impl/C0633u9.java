package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.u9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0633u9 extends MessageNano {
    public static volatile C0633u9[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f1227a;
    public long b;

    public C0633u9() {
        a();
    }

    public static C0633u9[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0633u9[0];
                }
            }
        }
        return c;
    }

    public final C0633u9 a() {
        this.f1227a = "";
        this.b = 0L;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return CodedOutputByteBufferNano.computeUInt64Size(2, this.b) + CodedOutputByteBufferNano.computeStringSize(1, this.f1227a) + computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeString(1, this.f1227a);
        codedOutputByteBufferNano.writeUInt64(2, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0633u9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1227a = codedInputByteBufferNano.readString();
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

    public static C0633u9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0633u9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0633u9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0633u9) MessageNano.mergeFrom(new C0633u9(), bArr);
    }
}
