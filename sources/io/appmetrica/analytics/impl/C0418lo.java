package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.lo  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0418lo extends MessageNano {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    public static final int h = 3;
    public static volatile C0418lo[] i;

    /* renamed from: a  reason: collision with root package name */
    public byte[] f981a;
    public int b;
    public C0444mo c;
    public C0470no d;

    public C0418lo() {
        a();
    }

    public static C0418lo[] b() {
        if (i == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (i == null) {
                    i = new C0418lo[0];
                }
            }
        }
        return i;
    }

    public final C0418lo a() {
        this.f981a = WireFormatNano.EMPTY_BYTES;
        this.b = 0;
        this.c = null;
        this.d = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeInt32Size = CodedOutputByteBufferNano.computeInt32Size(2, this.b) + CodedOutputByteBufferNano.computeBytesSize(1, this.f981a) + super.computeSerializedSize();
        C0444mo c0444mo = this.c;
        if (c0444mo != null) {
            computeInt32Size += CodedOutputByteBufferNano.computeMessageSize(3, c0444mo);
        }
        C0470no c0470no = this.d;
        return c0470no != null ? CodedOutputByteBufferNano.computeMessageSize(4, c0470no) + computeInt32Size : computeInt32Size;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        codedOutputByteBufferNano.writeBytes(1, this.f981a);
        codedOutputByteBufferNano.writeInt32(2, this.b);
        C0444mo c0444mo = this.c;
        if (c0444mo != null) {
            codedOutputByteBufferNano.writeMessage(3, c0444mo);
        }
        C0470no c0470no = this.d;
        if (c0470no != null) {
            codedOutputByteBufferNano.writeMessage(4, c0470no);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0418lo mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f981a = codedInputByteBufferNano.readBytes();
            } else if (readTag == 16) {
                int readInt32 = codedInputByteBufferNano.readInt32();
                if (readInt32 == 0 || readInt32 == 1 || readInt32 == 2 || readInt32 == 3) {
                    this.b = readInt32;
                }
            } else if (readTag == 26) {
                if (this.c == null) {
                    this.c = new C0444mo();
                }
                codedInputByteBufferNano.readMessage(this.c);
            } else if (readTag != 34) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.d == null) {
                    this.d = new C0470no();
                }
                codedInputByteBufferNano.readMessage(this.d);
            }
        }
        return this;
    }

    public static C0418lo b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0418lo().mergeFrom(codedInputByteBufferNano);
    }

    public static C0418lo a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0418lo) MessageNano.mergeFrom(new C0418lo(), bArr);
    }
}
