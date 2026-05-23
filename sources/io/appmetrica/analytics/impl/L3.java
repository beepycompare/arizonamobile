package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class L3 extends MessageNano {
    public static volatile L3[] c;

    /* renamed from: a  reason: collision with root package name */
    public N3 f638a;
    public int b;

    public L3() {
        a();
    }

    public static L3[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new L3[0];
                }
            }
        }
        return c;
    }

    public final L3 a() {
        this.f638a = null;
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        N3 n3 = this.f638a;
        if (n3 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, n3);
        }
        int i = this.b;
        return i != 0 ? CodedOutputByteBufferNano.computeInt32Size(2, i) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        N3 n3 = this.f638a;
        if (n3 != null) {
            codedOutputByteBufferNano.writeMessage(1, n3);
        }
        int i = this.b;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(2, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final L3 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f638a == null) {
                    this.f638a = new N3();
                }
                codedInputByteBufferNano.readMessage(this.f638a);
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.b = readInt32;
                }
            }
        }
        return this;
    }

    public static L3 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new L3().mergeFrom(codedInputByteBufferNano);
    }

    public static L3 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (L3) MessageNano.mergeFrom(new L3(), bArr);
    }
}
