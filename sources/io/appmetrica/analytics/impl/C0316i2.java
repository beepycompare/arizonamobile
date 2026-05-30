package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.i2  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0316i2 extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    public static final int h = 5;
    public static final int i = 6;
    public static final int j = -1;
    public static final int k = 0;
    public static final int l = 1;
    public static volatile C0316i2[] m;

    /* renamed from: a  reason: collision with root package name */
    public int f1026a;
    public int b;

    public C0316i2() {
        a();
    }

    public static C0316i2[] b() {
        if (m == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (m == null) {
                    m = new C0316i2[0];
                }
            }
        }
        return m;
    }

    public final C0316i2 a() {
        this.f1026a = 0;
        this.b = -1;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        return CodedOutputByteBufferNano.computeInt32Size(3, this.b) + CodedOutputByteBufferNano.computeInt32Size(2, this.f1026a) + computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt32(2, this.f1026a);
        codedOutputByteBufferNano.writeInt32(3, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0316i2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag != 0) {
                if (readTag == 16) {
                    int readInt32 = codedInputByteBufferNano.readInt32();
                    switch (readInt32) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                            this.f1026a = readInt32;
                            continue;
                    }
                } else if (readTag != 24) {
                    if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    }
                } else {
                    int readInt322 = codedInputByteBufferNano.readInt32();
                    if (readInt322 == -1 || readInt322 == 0 || readInt322 == 1) {
                        this.b = readInt322;
                    }
                }
            }
        }
        return this;
    }

    public static C0316i2 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0316i2().mergeFrom(codedInputByteBufferNano);
    }

    public static C0316i2 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0316i2) MessageNano.mergeFrom(new C0316i2(), bArr);
    }
}
