package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Ti extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    public static volatile Ti[] h;

    /* renamed from: a  reason: collision with root package name */
    public int f645a;
    public int b;

    public Ti() {
        a();
    }

    public static Ti[] b() {
        if (h == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (h == null) {
                    h = new Ti[0];
                }
            }
        }
        return h;
    }

    public final Ti a() {
        this.f645a = 0;
        this.b = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f645a;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.b;
        return i2 != 0 ? CodedOutputByteBufferNano.computeInt32Size(2, i2) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f645a;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.b;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(2, i2);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Ti mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f645a = codedInputByteBufferNano.readUInt32();
            } else if (readTag != 16) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4) {
                    this.b = readInt32;
                }
            }
        }
        return this;
    }

    public static Ti b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Ti().mergeFrom(codedInputByteBufferNano);
    }

    public static Ti a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Ti) MessageNano.mergeFrom(new Ti(), bArr);
    }
}
