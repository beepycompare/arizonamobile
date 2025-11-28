package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.z8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0743z8 extends MessageNano {
    public static volatile C0743z8[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0668w8 f1227a;

    public C0743z8() {
        a();
    }

    public static C0743z8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0743z8[0];
                }
            }
        }
        return b;
    }

    public final C0743z8 a() {
        this.f1227a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0668w8 c0668w8 = this.f1227a;
        return c0668w8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, c0668w8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0668w8 c0668w8 = this.f1227a;
        if (c0668w8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0668w8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0743z8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f1227a == null) {
                    this.f1227a = new C0668w8();
                }
                codedInputByteBufferNano.readMessage(this.f1227a);
            }
        }
        return this;
    }

    public static C0743z8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0743z8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0743z8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0743z8) MessageNano.mergeFrom(new C0743z8(), bArr);
    }
}
