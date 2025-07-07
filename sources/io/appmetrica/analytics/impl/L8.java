package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes4.dex */
public final class L8 extends MessageNano {
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    public static final int n = 7;
    public static volatile L8[] o;

    /* renamed from: a  reason: collision with root package name */
    public int f515a;
    public K8 b;
    public I8 c;
    public J8 d;
    public C0633u8 e;
    public A8 f;

    public L8() {
        a();
    }

    public static L8[] b() {
        if (o == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (o == null) {
                    o = new L8[0];
                }
            }
        }
        return o;
    }

    public final L8 a() {
        this.f515a = 0;
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
        int i2 = this.f515a;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i2);
        }
        K8 k8 = this.b;
        if (k8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, k8);
        }
        I8 i8 = this.c;
        if (i8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, i8);
        }
        J8 j8 = this.d;
        if (j8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, j8);
        }
        C0633u8 c0633u8 = this.e;
        if (c0633u8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0633u8);
        }
        A8 a8 = this.f;
        return a8 != null ? CodedOutputByteBufferNano.computeMessageSize(6, a8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i2 = this.f515a;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i2);
        }
        K8 k8 = this.b;
        if (k8 != null) {
            codedOutputByteBufferNano.writeMessage(2, k8);
        }
        I8 i8 = this.c;
        if (i8 != null) {
            codedOutputByteBufferNano.writeMessage(3, i8);
        }
        J8 j8 = this.d;
        if (j8 != null) {
            codedOutputByteBufferNano.writeMessage(4, j8);
        }
        C0633u8 c0633u8 = this.e;
        if (c0633u8 != null) {
            codedOutputByteBufferNano.writeMessage(5, c0633u8);
        }
        A8 a8 = this.f;
        if (a8 != null) {
            codedOutputByteBufferNano.writeMessage(6, a8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final L8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            this.f515a = readInt32;
                            continue;
                    }
                } else if (readTag == 18) {
                    if (this.b == null) {
                        this.b = new K8();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                } else if (readTag == 26) {
                    if (this.c == null) {
                        this.c = new I8();
                    }
                    codedInputByteBufferNano.readMessage(this.c);
                } else if (readTag == 34) {
                    if (this.d == null) {
                        this.d = new J8();
                    }
                    codedInputByteBufferNano.readMessage(this.d);
                } else if (readTag == 42) {
                    if (this.e == null) {
                        this.e = new C0633u8();
                    }
                    codedInputByteBufferNano.readMessage(this.e);
                } else if (readTag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    }
                } else {
                    if (this.f == null) {
                        this.f = new A8();
                    }
                    codedInputByteBufferNano.readMessage(this.f);
                }
            }
        }
        return this;
    }

    public static L8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new L8().mergeFrom(codedInputByteBufferNano);
    }

    public static L8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (L8) MessageNano.mergeFrom(new L8(), bArr);
    }
}
