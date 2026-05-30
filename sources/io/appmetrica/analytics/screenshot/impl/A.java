package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class A extends MessageNano {
    public static volatile A[] c;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1430a;
    public z b;

    public A() {
        a();
    }

    public static A[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new A[0];
                }
            }
        }
        return c;
    }

    public final A a() {
        this.f1430a = true;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        boolean z = this.f1430a;
        if (!z) {
            computeSerializedSize += CodedOutputByteBufferNano.computeBoolSize(1, z);
        }
        z zVar = this.b;
        return zVar != null ? CodedOutputByteBufferNano.computeMessageSize(2, zVar) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        boolean z = this.f1430a;
        if (!z) {
            codedOutputByteBufferNano.writeBool(1, z);
        }
        z zVar = this.b;
        if (zVar != null) {
            codedOutputByteBufferNano.writeMessage(2, zVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final A mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f1430a = codedInputByteBufferNano.readBool();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new z();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static A b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new A().mergeFrom(codedInputByteBufferNano);
    }

    public static A a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (A) MessageNano.mergeFrom(new A(), bArr);
    }
}
