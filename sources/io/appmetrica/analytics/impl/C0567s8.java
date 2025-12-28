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
public final class C0567s8 extends MessageNano {
    public static volatile C0567s8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0468o8 f1214a;
    public C0542r8 b;

    public C0567s8() {
        a();
    }

    public static C0567s8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0567s8[0];
                }
            }
        }
        return c;
    }

    public final C0567s8 a() {
        this.f1214a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0468o8 c0468o8 = this.f1214a;
        if (c0468o8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0468o8);
        }
        C0542r8 c0542r8 = this.b;
        return c0542r8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0542r8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0468o8 c0468o8 = this.f1214a;
        if (c0468o8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0468o8);
        }
        C0542r8 c0542r8 = this.b;
        if (c0542r8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0542r8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0567s8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1214a == null) {
                    this.f1214a = new C0468o8();
                }
                codedInputByteBufferNano.readMessage(this.f1214a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0542r8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0567s8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0567s8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0567s8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0567s8) MessageNano.mergeFrom(new C0567s8(), bArr);
    }
}
