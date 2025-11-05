package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.x8  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0693x8 extends MessageNano {
    public static volatile C0693x8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0593t8 f1200a;
    public C0668w8 b;

    public C0693x8() {
        a();
    }

    public static C0693x8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0693x8[0];
                }
            }
        }
        return c;
    }

    public final C0693x8 a() {
        this.f1200a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0593t8 c0593t8 = this.f1200a;
        if (c0593t8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0593t8);
        }
        C0668w8 c0668w8 = this.b;
        return c0668w8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0668w8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0593t8 c0593t8 = this.f1200a;
        if (c0593t8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0593t8);
        }
        C0668w8 c0668w8 = this.b;
        if (c0668w8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0668w8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0693x8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1200a == null) {
                    this.f1200a = new C0593t8();
                }
                codedInputByteBufferNano.readMessage(this.f1200a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0668w8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0693x8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0693x8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0693x8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0693x8) MessageNano.mergeFrom(new C0693x8(), bArr);
    }
}
