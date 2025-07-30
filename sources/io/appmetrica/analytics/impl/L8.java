package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class L8 extends MessageNano {
    public static volatile L8[] c;

    /* renamed from: a  reason: collision with root package name */
    public H8 f531a;
    public K8 b;

    public L8() {
        a();
    }

    public static L8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new L8[0];
                }
            }
        }
        return c;
    }

    public final L8 a() {
        this.f531a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        H8 h8 = this.f531a;
        if (h8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, h8);
        }
        K8 k8 = this.b;
        return k8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, k8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        H8 h8 = this.f531a;
        if (h8 != null) {
            codedOutputByteBufferNano.writeMessage(1, h8);
        }
        K8 k8 = this.b;
        if (k8 != null) {
            codedOutputByteBufferNano.writeMessage(2, k8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final L8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f531a == null) {
                    this.f531a = new H8();
                }
                codedInputByteBufferNano.readMessage(this.f531a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new K8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static L8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new L8().mergeFrom(codedInputByteBufferNano);
    }

    public static L8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (L8) MessageNano.mergeFrom(new L8(), bArr);
    }
}
