package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.s8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0571s8 extends MessageNano {
    public static volatile C0571s8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0447n8 f1219a;
    public C0497p8 b;

    public C0571s8() {
        a();
    }

    public static C0571s8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0571s8[0];
                }
            }
        }
        return c;
    }

    public final C0571s8 a() {
        this.f1219a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0447n8 c0447n8 = this.f1219a;
        if (c0447n8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0447n8);
        }
        C0497p8 c0497p8 = this.b;
        return c0497p8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0497p8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0447n8 c0447n8 = this.f1219a;
        if (c0447n8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0447n8);
        }
        C0497p8 c0497p8 = this.b;
        if (c0497p8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0497p8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0571s8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1219a == null) {
                    this.f1219a = new C0447n8();
                }
                codedInputByteBufferNano.readMessage(this.f1219a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0497p8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0571s8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0571s8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0571s8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0571s8) MessageNano.mergeFrom(new C0571s8(), bArr);
    }
}
