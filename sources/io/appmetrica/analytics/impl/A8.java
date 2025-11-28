package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class A8 extends MessageNano {
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    public static final int n = 7;
    public static volatile A8[] o;

    /* renamed from: a  reason: collision with root package name */
    public int f393a;
    public C0743z8 b;
    public C0693x8 c;
    public C0718y8 d;
    public C0342j8 e;
    public C0494p8 f;

    public A8() {
        a();
    }

    public static A8[] b() {
        if (o == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (o == null) {
                    o = new A8[0];
                }
            }
        }
        return o;
    }

    public final A8 a() {
        this.f393a = 0;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        int i2 = this.f393a;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i2);
        }
        C0743z8 c0743z8 = this.b;
        if (c0743z8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0743z8);
        }
        C0693x8 c0693x8 = this.c;
        if (c0693x8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0693x8);
        }
        C0718y8 c0718y8 = this.d;
        if (c0718y8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c0718y8);
        }
        C0342j8 c0342j8 = this.e;
        if (c0342j8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0342j8);
        }
        C0494p8 c0494p8 = this.f;
        return c0494p8 != null ? CodedOutputByteBufferNano.computeMessageSize(6, c0494p8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i2 = this.f393a;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i2);
        }
        C0743z8 c0743z8 = this.b;
        if (c0743z8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0743z8);
        }
        C0693x8 c0693x8 = this.c;
        if (c0693x8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0693x8);
        }
        C0718y8 c0718y8 = this.d;
        if (c0718y8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0718y8);
        }
        C0342j8 c0342j8 = this.e;
        if (c0342j8 != null) {
            codedOutputByteBufferNano.writeMessage(5, c0342j8);
        }
        C0494p8 c0494p8 = this.f;
        if (c0494p8 != null) {
            codedOutputByteBufferNano.writeMessage(6, c0494p8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final A8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag == 8) {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    switch (readInt32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                            this.f393a = readInt32;
                            continue;
                    }
                } else if (readTag == 18) {
                    if (this.b == null) {
                        this.b = new C0743z8();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                } else if (readTag == 26) {
                    if (this.c == null) {
                        this.c = new C0693x8();
                    }
                    codedInputByteBufferNano.readMessage(this.c);
                } else if (readTag == 34) {
                    if (this.d == null) {
                        this.d = new C0718y8();
                    }
                    codedInputByteBufferNano.readMessage(this.d);
                } else if (readTag == 42) {
                    if (this.e == null) {
                        this.e = new C0342j8();
                    }
                    codedInputByteBufferNano.readMessage(this.e);
                } else if (readTag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    }
                } else {
                    if (this.f == null) {
                        this.f = new C0494p8();
                    }
                    codedInputByteBufferNano.readMessage(this.f);
                }
            }
        }
        return this;
    }

    public static A8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new A8().mergeFrom(codedInputByteBufferNano);
    }

    public static A8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (A8) MessageNano.mergeFrom(new A8(), bArr);
    }
}
