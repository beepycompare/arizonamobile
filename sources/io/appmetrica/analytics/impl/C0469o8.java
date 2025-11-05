package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.o8  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0469o8 extends MessageNano {
    public static volatile C0469o8[] c;

    /* renamed from: a  reason: collision with root package name */
    public int f1037a;
    public C0368k8 b;

    public C0469o8() {
        a();
    }

    public static C0469o8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0469o8[0];
                }
            }
        }
        return c;
    }

    public final C0469o8 a() {
        this.f1037a = 0;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f1037a;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        C0368k8 c0368k8 = this.b;
        return c0368k8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0368k8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f1037a;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        C0368k8 c0368k8 = this.b;
        if (c0368k8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0368k8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0469o8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f1037a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0368k8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0469o8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0469o8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0469o8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0469o8) MessageNano.mergeFrom(new C0469o8(), bArr);
    }
}
