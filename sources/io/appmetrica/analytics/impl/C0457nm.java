package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.nm  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0457nm extends MessageNano {
    public static volatile C0457nm[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f1133a;
    public C0432mm b;

    public C0457nm() {
        a();
    }

    public static C0457nm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0457nm[0];
                }
            }
        }
        return c;
    }

    public final C0457nm a() {
        this.f1133a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1133a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1133a);
        }
        C0432mm c0432mm = this.b;
        return c0432mm != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0432mm) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1133a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1133a);
        }
        C0432mm c0432mm = this.b;
        if (c0432mm != null) {
            codedOutputByteBufferNano.writeMessage(2, c0432mm);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0457nm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1133a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0432mm();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0457nm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0457nm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0457nm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0457nm) MessageNano.mergeFrom(new C0457nm(), bArr);
    }
}
