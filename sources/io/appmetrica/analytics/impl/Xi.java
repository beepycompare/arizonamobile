package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Xi extends MessageNano {
    public static volatile Xi[] d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f721a;
    public Wi b;
    public Vi c;

    public Xi() {
        a();
    }

    public static Xi[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new Xi[0];
                }
            }
        }
        return d;
    }

    public final Xi a() {
        this.f721a = false;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f721a;
        if (z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        Wi wi = this.b;
        if (wi != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, wi);
        }
        Vi vi = this.c;
        return vi != null ? CodedOutputByteBufferNano.computeMessageSize(3, vi) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f721a;
        if (z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        Wi wi = this.b;
        if (wi != null) {
            codedOutputByteBufferNano.writeMessage(2, wi);
        }
        Vi vi = this.c;
        if (vi != null) {
            codedOutputByteBufferNano.writeMessage(3, vi);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Xi mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f721a = codedInputByteBufferNano.readBool();
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new Wi();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new Vi();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static Xi b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Xi().mergeFrom(codedInputByteBufferNano);
    }

    public static Xi a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Xi) MessageNano.mergeFrom(new Xi(), bArr);
    }
}
