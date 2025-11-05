package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.y8  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0718y8 extends MessageNano {
    public static volatile C0718y8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0593t8 f1212a;
    public C0643v8 b;

    public C0718y8() {
        a();
    }

    public static C0718y8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0718y8[0];
                }
            }
        }
        return c;
    }

    public final C0718y8 a() {
        this.f1212a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0593t8 c0593t8 = this.f1212a;
        if (c0593t8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0593t8);
        }
        C0643v8 c0643v8 = this.b;
        return c0643v8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0643v8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0593t8 c0593t8 = this.f1212a;
        if (c0593t8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0593t8);
        }
        C0643v8 c0643v8 = this.b;
        if (c0643v8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0643v8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0718y8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1212a == null) {
                    this.f1212a = new C0593t8();
                }
                codedInputByteBufferNano.readMessage(this.f1212a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0643v8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0718y8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0718y8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0718y8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0718y8) MessageNano.mergeFrom(new C0718y8(), bArr);
    }
}
