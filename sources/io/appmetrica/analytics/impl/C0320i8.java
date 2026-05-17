package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.i8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0320i8 extends MessageNano {
    public static volatile C0320i8[] c;

    /* renamed from: a  reason: collision with root package name */
    public int f1045a;
    public C0216e8 b;

    public C0320i8() {
        a();
    }

    public static C0320i8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0320i8[0];
                }
            }
        }
        return c;
    }

    public final C0320i8 a() {
        this.f1045a = 0;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f1045a;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        C0216e8 c0216e8 = this.b;
        return c0216e8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0216e8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f1045a;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        C0216e8 c0216e8 = this.b;
        if (c0216e8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0216e8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0320i8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f1045a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0216e8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0320i8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0320i8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0320i8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0320i8) MessageNano.mergeFrom(new C0320i8(), bArr);
    }
}
