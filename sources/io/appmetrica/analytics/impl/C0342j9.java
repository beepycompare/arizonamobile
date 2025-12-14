package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.j9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0342j9 extends MessageNano {
    public static volatile C0342j9[] e;

    /* renamed from: a  reason: collision with root package name */
    public long f1050a;
    public int b;
    public long c;
    public boolean d;

    public C0342j9() {
        a();
    }

    public static C0342j9[] b() {
        if (e == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (e == null) {
                    e = new C0342j9[0];
                }
            }
        }
        return e;
    }

    public final C0342j9 a() {
        this.f1050a = 0L;
        this.b = 0;
        this.c = 0L;
        this.d = false;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSInt32Size = CodedOutputByteBufferNano.computeSInt32Size(2, this.b) + CodedOutputByteBufferNano.computeUInt64Size(1, this.f1050a) + super.computeSerializedSize();
        long j = this.c;
        if (j != 0) {
            computeSInt32Size += CodedOutputByteBufferNano.computeInt64Size(3, j);
        }
        boolean z = this.d;
        return z ? CodedOutputByteBufferNano.computeBoolSize(4, z) + computeSInt32Size : computeSInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeUInt64(1, this.f1050a);
        codedOutputByteBufferNano.writeSInt32(2, this.b);
        long j = this.c;
        if (j != 0) {
            codedOutputByteBufferNano.writeInt64(3, j);
        }
        boolean z = this.d;
        if (z) {
            codedOutputByteBufferNano.writeBool(4, z);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0342j9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 8) {
                this.f1050a = codedInputByteBufferNano.readUInt64();
            } else if (readTag == 16) {
                this.b = codedInputByteBufferNano.readSInt32();
            } else if (readTag == 24) {
                this.c = codedInputByteBufferNano.readInt64();
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

    public static C0342j9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0342j9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0342j9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0342j9) MessageNano.mergeFrom(new C0342j9(), bArr);
    }
}
