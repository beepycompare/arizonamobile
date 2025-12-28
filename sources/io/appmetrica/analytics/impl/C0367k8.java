package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.k8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0367k8 extends MessageNano {
    public static volatile C0367k8[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0316i8 f1070a;

    public C0367k8() {
        a();
    }

    public static C0367k8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0367k8[0];
                }
            }
        }
        return b;
    }

    public final C0367k8 a() {
        this.f1070a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0316i8 c0316i8 = this.f1070a;
        return c0316i8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, c0316i8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0316i8 c0316i8 = this.f1070a;
        if (c0316i8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0316i8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0367k8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f1070a == null) {
                    this.f1070a = new C0316i8();
                }
                codedInputByteBufferNano.readMessage(this.f1070a);
            }
        }
        return this;
    }

    public static C0367k8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0367k8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0367k8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0367k8) MessageNano.mergeFrom(new C0367k8(), bArr);
    }
}
