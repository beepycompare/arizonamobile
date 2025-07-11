package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.b2  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0144b2 extends MessageNano {
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 4;
    public static final int h = 5;
    public static final int i = -1;
    public static final int j = 0;
    public static final int k = 1;
    public static volatile C0144b2[] l;

    /* renamed from: a  reason: collision with root package name */
    public int f764a;
    public int b;

    public C0144b2() {
        a();
    }

    public static C0144b2[] b() {
        if (l == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (l == null) {
                    l = new C0144b2[0];
                }
            }
        }
        return l;
    }

    public final C0144b2 a() {
        this.f764a = 0;
        this.b = -1;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        return CodedOutputByteBufferNano.computeInt32Size(3, this.b) + CodedOutputByteBufferNano.computeInt32Size(2, this.f764a) + super.computeSerializedSize();
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeInt32(2, this.f764a);
        codedOutputByteBufferNano.writeInt32(3, this.b);
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0144b2 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3 || readInt32 == 4 || readInt32 == 5) {
                    this.f764a = readInt32;
                }
            } else if (readTag != 24) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int readInt322 = codedInputByteBufferNano.readInt32();
                if (readInt322 == -1 || readInt322 == 0 || readInt322 == 1) {
                    this.b = readInt322;
                }
            }
        }
        return this;
    }

    public static C0144b2 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0144b2().mergeFrom(codedInputByteBufferNano);
    }

    public static C0144b2 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0144b2) MessageNano.mergeFrom(new C0144b2(), bArr);
    }
}
