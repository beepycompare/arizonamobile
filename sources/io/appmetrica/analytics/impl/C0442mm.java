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
public final class C0442mm extends MessageNano {
    public static volatile C0442mm[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f960a;
    public C0417lm b;

    public C0442mm() {
        a();
    }

    public static C0442mm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0442mm[0];
                }
            }
        }
        return c;
    }

    public final C0442mm a() {
        this.f960a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f960a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f960a);
        }
        C0417lm c0417lm = this.b;
        return c0417lm != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0417lm) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f960a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f960a);
        }
        C0417lm c0417lm = this.b;
        if (c0417lm != null) {
            codedOutputByteBufferNano.writeMessage(2, c0417lm);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0442mm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f960a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0417lm();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0442mm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0442mm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0442mm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0442mm) MessageNano.mergeFrom(new C0442mm(), bArr);
    }
}
