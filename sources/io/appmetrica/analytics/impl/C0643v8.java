package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.v8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0643v8 extends MessageNano {
    public static final int g = 0;
    public static final int h = 1;
    public static final int i = 2;
    public static final int j = 3;
    public static final int k = 4;
    public static final int l = 5;
    public static final int m = 6;
    public static final int n = 7;
    public static volatile C0643v8[] o;

    /* renamed from: a  reason: collision with root package name */
    public int f1165a;
    public C0618u8 b;
    public C0568s8 c;
    public C0593t8 d;
    public C0213e8 e;
    public C0368k8 f;

    public C0643v8() {
        a();
    }

    public static C0643v8[] b() {
        if (o == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (o == null) {
                    o = new C0643v8[0];
                }
            }
        }
        return o;
    }

    public final C0643v8 a() {
        this.f1165a = 0;
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
        int i2 = this.f1165a;
        if (i2 != 0) {
            computeSerializedSize += CodedOutputByteBufferNano.computeInt32Size(1, i2);
        }
        C0618u8 c0618u8 = this.b;
        if (c0618u8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, c0618u8);
        }
        C0568s8 c0568s8 = this.c;
        if (c0568s8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(3, c0568s8);
        }
        C0593t8 c0593t8 = this.d;
        if (c0593t8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(4, c0593t8);
        }
        C0213e8 c0213e8 = this.e;
        if (c0213e8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(5, c0213e8);
        }
        C0368k8 c0368k8 = this.f;
        return c0368k8 != null ? CodedOutputByteBufferNano.computeMessageSize(6, c0368k8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        int i2 = this.f1165a;
        if (i2 != 0) {
            codedOutputByteBufferNano.writeInt32(1, i2);
        }
        C0618u8 c0618u8 = this.b;
        if (c0618u8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0618u8);
        }
        C0568s8 c0568s8 = this.c;
        if (c0568s8 != null) {
            codedOutputByteBufferNano.writeMessage(3, c0568s8);
        }
        C0593t8 c0593t8 = this.d;
        if (c0593t8 != null) {
            codedOutputByteBufferNano.writeMessage(4, c0593t8);
        }
        C0213e8 c0213e8 = this.e;
        if (c0213e8 != null) {
            codedOutputByteBufferNano.writeMessage(5, c0213e8);
        }
        C0368k8 c0368k8 = this.f;
        if (c0368k8 != null) {
            codedOutputByteBufferNano.writeMessage(6, c0368k8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0643v8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
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
                            this.f1165a = readInt32;
                            continue;
                    }
                } else if (readTag == 18) {
                    if (this.b == null) {
                        this.b = new C0618u8();
                    }
                    codedInputByteBufferNano.readMessage(this.b);
                } else if (readTag == 26) {
                    if (this.c == null) {
                        this.c = new C0568s8();
                    }
                    codedInputByteBufferNano.readMessage(this.c);
                } else if (readTag == 34) {
                    if (this.d == null) {
                        this.d = new C0593t8();
                    }
                    codedInputByteBufferNano.readMessage(this.d);
                } else if (readTag == 42) {
                    if (this.e == null) {
                        this.e = new C0213e8();
                    }
                    codedInputByteBufferNano.readMessage(this.e);
                } else if (readTag != 50) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    }
                } else {
                    if (this.f == null) {
                        this.f = new C0368k8();
                    }
                    codedInputByteBufferNano.readMessage(this.f);
                }
            }
        }
        return this;
    }

    public static C0643v8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0643v8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0643v8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0643v8) MessageNano.mergeFrom(new C0643v8(), bArr);
    }
}
