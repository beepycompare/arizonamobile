package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class Q8 extends MessageNano {
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    public static final int n = 7;
    public static volatile Q8[] o;

    /* renamed from: a  reason: collision with root package name */
    public int f617a;
    public P8 b;
    public N8 c;
    public O8 d;
    public C0750z8 e;
    public F8 f;

    public Q8() {
        a();
    }

    public static Q8[] b() {
        if (o == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (o == null) {
                    o = new Q8[0];
                }
            }
        }
        return o;
    }

    public final Q8 a() {
        this.f617a = 0;
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
        int i2 = this.f617a;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i2);
        }
        P8 p8 = this.b;
        if (p8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, p8);
        }
        N8 n8 = this.c;
        if (n8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, n8);
        }
        O8 o8 = this.d;
        if (o8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, o8);
        }
        C0750z8 c0750z8 = this.e;
        if (c0750z8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0750z8);
        }
        F8 f8 = this.f;
        return f8 != null ? CodedOutputByteBufferNano.computeMessageSize(6, f8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i2 = this.f617a;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i2);
        }
        P8 p8 = this.b;
        if (p8 != null) {
            codedOutputByteBufferNano.writeMessage(2, p8);
        }
        N8 n8 = this.c;
        if (n8 != null) {
            codedOutputByteBufferNano.writeMessage(3, n8);
        }
        O8 o8 = this.d;
        if (o8 != null) {
            codedOutputByteBufferNano.writeMessage(4, o8);
        }
        C0750z8 c0750z8 = this.e;
        if (c0750z8 != null) {
            codedOutputByteBufferNano.writeMessage(5, c0750z8);
        }
        F8 f8 = this.f;
        if (f8 != null) {
            codedOutputByteBufferNano.writeMessage(6, f8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Q8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            this.f617a = readInt32;
                            continue;
                    }
                } else if (readTag == 18) {
                    if (this.b == null) {
                        this.b = new P8();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                } else if (readTag == 26) {
                    if (this.c == null) {
                        this.c = new N8();
                    }
                    codedInputByteBufferNano.readMessage(this.c);
                } else if (readTag == 34) {
                    if (this.d == null) {
                        this.d = new O8();
                    }
                    codedInputByteBufferNano.readMessage(this.d);
                } else if (readTag == 42) {
                    if (this.e == null) {
                        this.e = new C0750z8();
                    }
                    codedInputByteBufferNano.readMessage(this.e);
                } else if (readTag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    }
                } else {
                    if (this.f == null) {
                        this.f = new F8();
                    }
                    codedInputByteBufferNano.readMessage(this.f);
                }
            }
        }
        return this;
    }

    public static Q8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Q8().mergeFrom(codedInputByteBufferNano);
    }

    public static Q8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Q8) MessageNano.mergeFrom(new Q8(), bArr);
    }
}
