package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.t8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0595t8 extends MessageNano {
    public static volatile C0595t8[] b;

    /* renamed from: a  reason: collision with root package name */
    public C0521q8 f1233a;

    public C0595t8() {
        a();
    }

    public static C0595t8[] b() {
        if (b == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (b == null) {
                    b = new C0595t8[0];
                }
            }
        }
        return b;
    }

    public final C0595t8 a() {
        this.f1233a = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0521q8 c0521q8 = this.f1233a;
        return c0521q8 != null ? CodedOutputByteBufferNano.computeMessageSize(1, c0521q8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0521q8 c0521q8 = this.f1233a;
        if (c0521q8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0521q8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0595t8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag != 10) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.f1233a == null) {
                    this.f1233a = new C0521q8();
                }
                codedInputByteBufferNano.readMessage(this.f1233a);
            }
        }
        return this;
    }

    public static C0595t8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0595t8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0595t8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0595t8) MessageNano.mergeFrom(new C0595t8(), bArr);
    }
}
