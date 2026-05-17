package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.r8  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0545r8 extends MessageNano {
    public static volatile C0545r8[] c;

    /* renamed from: a  reason: collision with root package name */
    public C0446n8 f1209a;
    public C0521q8 b;

    public C0545r8() {
        a();
    }

    public static C0545r8[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0545r8[0];
                }
            }
        }
        return c;
    }

    public final C0545r8 a() {
        this.f1209a = null;
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        C0446n8 c0446n8 = this.f1209a;
        if (c0446n8 != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, c0446n8);
        }
        C0521q8 c0521q8 = this.b;
        return c0521q8 != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0521q8) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        C0446n8 c0446n8 = this.f1209a;
        if (c0446n8 != null) {
            codedOutputByteBufferNano.writeMessage(1, c0446n8);
        }
        C0521q8 c0521q8 = this.b;
        if (c0521q8 != null) {
            codedOutputByteBufferNano.writeMessage(2, c0521q8);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0545r8 mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1209a == null) {
                    this.f1209a = new C0446n8();
                }
                codedInputByteBufferNano.readMessage(this.f1209a);
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0521q8();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0545r8 b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0545r8().mergeFrom(codedInputByteBufferNano);
    }

    public static C0545r8 a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0545r8) MessageNano.mergeFrom(new C0545r8(), bArr);
    }
}
