package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class N8 extends MessageNano {
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    public static final int n = 7;
    public static volatile N8[] o;

    /* renamed from: a  reason: collision with root package name */
    public int f679a;
    public M8 b;
    public K8 c;
    public L8 d;
    public C0684w8 e;
    public C8 f;

    public N8() {
        a();
    }

    public static N8[] b() {
        if (o == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (o == null) {
                    o = new N8[0];
                }
            }
        }
        return o;
    }

    public final N8 a() {
        this.f679a = 0;
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
        int i2 = this.f679a;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i2);
        }
        M8 m8 = this.b;
        if (m8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, m8);
        }
        K8 k8 = this.c;
        if (k8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, k8);
        }
        L8 l8 = this.d;
        if (l8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, l8);
        }
        C0684w8 c0684w8 = this.e;
        if (c0684w8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0684w8);
        }
        C8 c8 = this.f;
        return c8 != null ? CodedOutputByteBufferNano.computeMessageSize(6, c8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i2 = this.f679a;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i2);
        }
        M8 m8 = this.b;
        if (m8 != null) {
            codedOutputByteBufferNano.writeMessage(2, m8);
        }
        K8 k8 = this.c;
        if (k8 != null) {
            codedOutputByteBufferNano.writeMessage(3, k8);
        }
        L8 l8 = this.d;
        if (l8 != null) {
            codedOutputByteBufferNano.writeMessage(4, l8);
        }
        C0684w8 c0684w8 = this.e;
        if (c0684w8 != null) {
            codedOutputByteBufferNano.writeMessage(5, c0684w8);
        }
        C8 c8 = this.f;
        if (c8 != null) {
            codedOutputByteBufferNano.writeMessage(6, c8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final N8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            this.f679a = readInt32;
                            continue;
                    }
                } else if (readTag == 18) {
                    if (this.b == null) {
                        this.b = new M8();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                } else if (readTag == 26) {
                    if (this.c == null) {
                        this.c = new K8();
                    }
                    codedInputByteBufferNano.readMessage(this.c);
                } else if (readTag == 34) {
                    if (this.d == null) {
                        this.d = new L8();
                    }
                    codedInputByteBufferNano.readMessage(this.d);
                } else if (readTag == 42) {
                    if (this.e == null) {
                        this.e = new C0684w8();
                    }
                    codedInputByteBufferNano.readMessage(this.e);
                } else if (readTag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    }
                } else {
                    if (this.f == null) {
                        this.f = new C8();
                    }
                    codedInputByteBufferNano.readMessage(this.f);
                }
            }
        }
        return this;
    }

    public static N8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new N8().mergeFrom(codedInputByteBufferNano);
    }

    public static N8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (N8) MessageNano.mergeFrom(new N8(), bArr);
    }
}
