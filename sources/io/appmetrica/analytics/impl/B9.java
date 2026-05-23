package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class B9 extends MessageNano {
    public static volatile B9[] e;

    /* renamed from: a  reason: collision with root package name */
    public int f471a;
    public int b;
    public String c;
    public boolean d;

    public B9() {
        a();
    }

    public static B9[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new B9[0];
                }
            }
        }
        return e;
    }

    public final B9 a() {
        this.f471a = 0;
        this.b = 0;
        this.c = "";
        this.d = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i = this.f471a;
        if (i != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(1, i);
        }
        int i2 = this.b;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeUInt32Size(2, i2);
        }
        if (!this.c.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(3, this.c);
        }
        boolean z = this.d;
        return z ? CodedOutputByteBufferNano.computeBoolSize(4, z) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i = this.f471a;
        if (i != 0) {
            codedOutputByteBufferNano.writeUInt32(1, i);
        }
        int i2 = this.b;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeUInt32(2, i2);
        }
        if (!this.c.equals("")) {
            codedOutputByteBufferNano.writeString(3, this.c);
        }
        boolean z = this.d;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final B9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f471a = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 16) {
                this.b = codedInputByteBufferNano.readUInt32();
            } else if (readTag == 26) {
                this.c = codedInputByteBufferNano.readString();
            } else if (readTag != 32) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                this.d = codedInputByteBufferNano.readBool();
            }
        }
        return this;
    }

    public static B9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new B9().mergeFrom(codedInputByteBufferNano);
    }

    public static B9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (B9) MessageNano.mergeFrom(new B9(), bArr);
    }
}
