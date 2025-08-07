package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.mm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0443mm extends MessageNano {
    public static volatile C0443mm[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f959a;
    public C0418lm b;

    public C0443mm() {
        a();
    }

    public static C0443mm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0443mm[0];
                }
            }
        }
        return c;
    }

    public final C0443mm a() {
        this.f959a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f959a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f959a);
        }
        C0418lm c0418lm = this.b;
        return c0418lm != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0418lm) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f959a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f959a);
        }
        C0418lm c0418lm = this.b;
        if (c0418lm != null) {
            codedOutputByteBufferNano.writeMessage(2, c0418lm);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0443mm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f959a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0418lm();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0443mm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0443mm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0443mm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0443mm) MessageNano.mergeFrom(new C0443mm(), bArr);
    }
}
