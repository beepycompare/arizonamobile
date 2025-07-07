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
public final class C0373jm extends MessageNano {
    public static volatile C0373jm[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f896a;
    public C0348im b;

    public C0373jm() {
        a();
    }

    public static C0373jm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0373jm[0];
                }
            }
        }
        return c;
    }

    public final C0373jm a() {
        this.f896a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f896a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f896a);
        }
        C0348im c0348im = this.b;
        return c0348im != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0348im) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f896a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f896a);
        }
        C0348im c0348im = this.b;
        if (c0348im != null) {
            codedOutputByteBufferNano.writeMessage(2, c0348im);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0373jm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f896a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0348im();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0373jm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0373jm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0373jm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0373jm) MessageNano.mergeFrom(new C0373jm(), bArr);
    }
}
