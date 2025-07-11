package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.jm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0365jm extends MessageNano {
    public static volatile C0365jm[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f897a;
    public C0340im b;

    public C0365jm() {
        a();
    }

    public static C0365jm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0365jm[0];
                }
            }
        }
        return c;
    }

    public final C0365jm a() {
        this.f897a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f897a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f897a);
        }
        C0340im c0340im = this.b;
        return c0340im != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0340im) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f897a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f897a);
        }
        C0340im c0340im = this.b;
        if (c0340im != null) {
            codedOutputByteBufferNano.writeMessage(2, c0340im);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0365jm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f897a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0340im();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0365jm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0365jm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0365jm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0365jm) MessageNano.mergeFrom(new C0365jm(), bArr);
    }
}
