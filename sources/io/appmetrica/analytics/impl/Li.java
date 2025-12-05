package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Li extends MessageNano {
    public static volatile Li[] d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f656a;
    public Ki b;
    public Ji c;

    public Li() {
        a();
    }

    public static Li[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new Li[0];
                }
            }
        }
        return d;
    }

    public final Li a() {
        this.f656a = false;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f656a;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        Ki ki = this.b;
        if (ki != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, ki);
        }
        Ji ji = this.c;
        return ji != null ? CodedOutputByteBufferNano.computeMessageSize(3, ji) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f656a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        Ki ki = this.b;
        if (ki != null) {
            codedOutputByteBufferNano.writeMessage(2, ki);
        }
        Ji ji = this.c;
        if (ji != null) {
            codedOutputByteBufferNano.writeMessage(3, ji);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Li mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f656a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new Ki();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new Ji();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static Li b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Li().mergeFrom(codedInputByteBufferNano);
    }

    public static Li a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Li) MessageNano.mergeFrom(new Li(), bArr);
    }
}
