package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.j8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0342j8 extends MessageNano {
    public static volatile C0342j8[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0368k8 f948a;

    public C0342j8() {
        a();
    }

    public static C0342j8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0342j8[0];
                }
            }
        }
        return b;
    }

    public final C0342j8 a() {
        this.f948a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0368k8 c0368k8 = this.f948a;
        return c0368k8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, c0368k8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0368k8 c0368k8 = this.f948a;
        if (c0368k8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0368k8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0342j8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f948a == null) {
                    this.f948a = new C0368k8();
                }
                codedInputByteBufferNano.readMessage(this.f948a);
            }
        }
        return this;
    }

    public static C0342j8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0342j8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0342j8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0342j8) MessageNano.mergeFrom(new C0342j8(), bArr);
    }
}
