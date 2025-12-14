package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Q extends MessageNano {
    public static volatile Q[] d;

    /* renamed from: a  reason: collision with root package name */
    public N f1445a;
    public P b;
    public O c;

    public Q() {
        a();
    }

    public static Q[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new Q[0];
                }
            }
        }
        return d;
    }

    public final Q a() {
        this.f1445a = null;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        N n = this.f1445a;
        if (n != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, n);
        }
        P p = this.b;
        if (p != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, p);
        }
        O o = this.c;
        return o != null ? CodedOutputByteBufferNano.computeMessageSize(3, o) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        N n = this.f1445a;
        if (n != null) {
            codedOutputByteBufferNano.writeMessage(1, n);
        }
        P p = this.b;
        if (p != null) {
            codedOutputByteBufferNano.writeMessage(2, p);
        }
        O o = this.c;
        if (o != null) {
            codedOutputByteBufferNano.writeMessage(3, o);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Q mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1445a == null) {
                    this.f1445a = new N();
                }
                codedInputByteBufferNano.readMessage(this.f1445a);
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new P();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new O();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static Q b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Q().mergeFrom(codedInputByteBufferNano);
    }

    public static Q a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Q) MessageNano.mergeFrom(new Q(), bArr);
    }
}
