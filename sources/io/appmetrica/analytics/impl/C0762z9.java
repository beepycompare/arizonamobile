package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.z9  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0762z9 extends MessageNano {
    public static final int d = 0;
    public static final int e = 1;
    public static final int f = 2;
    public static volatile C0762z9[] g;

    /* renamed from: a  reason: collision with root package name */
    public C9 f1313a;
    public String b;
    public int c;

    public C0762z9() {
        a();
    }

    public static C0762z9[] b() {
        if (g == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (g == null) {
                    g = new C0762z9[0];
                }
            }
        }
        return g;
    }

    public final C0762z9 a() {
        this.f1313a = null;
        this.b = "";
        this.c = 0;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C9 c9 = this.f1313a;
        if (c9 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c9);
        }
        int computeStringSize = CodedOutputByteBufferNano.computeStringSize(2, this.b) + computeSerializedSize;
        int i = this.c;
        return i != 0 ? CodedOutputByteBufferNano.computeInt32Size(5, i) + computeStringSize : computeStringSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C9 c9 = this.f1313a;
        if (c9 != null) {
            codedOutputByteBufferNano.writeMessage(1, c9);
        }
        codedOutputByteBufferNano.writeString(2, this.b);
        int i = this.c;
        if (i != 0) {
            codedOutputByteBufferNano.writeInt32(5, i);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0762z9 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1313a == null) {
                    this.f1313a = new C9();
                }
                codedInputByteBufferNano.readMessage(this.f1313a);
            } else if (readTag == 18) {
                this.b = codedInputByteBufferNano.readString();
            } else if (readTag != 40) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2) {
                    this.c = readInt32;
                }
            }
        }
        return this;
    }

    public static C0762z9 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0762z9().mergeFrom(codedInputByteBufferNano);
    }

    public static C0762z9 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0762z9) MessageNano.mergeFrom(new C0762z9(), bArr);
    }
}
