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
public final class C0568s8 extends MessageNano {
    public static volatile C0568s8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0469o8 f1116a;
    public C0543r8 b;

    public C0568s8() {
        a();
    }

    public static C0568s8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0568s8[0];
                }
            }
        }
        return c;
    }

    public final C0568s8 a() {
        this.f1116a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0469o8 c0469o8 = this.f1116a;
        if (c0469o8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0469o8);
        }
        C0543r8 c0543r8 = this.b;
        return c0543r8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0543r8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0469o8 c0469o8 = this.f1116a;
        if (c0469o8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0469o8);
        }
        C0543r8 c0543r8 = this.b;
        if (c0543r8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0543r8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0568s8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1116a == null) {
                    this.f1116a = new C0469o8();
                }
                codedInputByteBufferNano.readMessage(this.f1116a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0543r8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0568s8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0568s8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0568s8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0568s8) MessageNano.mergeFrom(new C0568s8(), bArr);
    }
}
