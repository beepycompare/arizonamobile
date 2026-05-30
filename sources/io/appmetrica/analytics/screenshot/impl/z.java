package io.appmetrica.analytics.screenshot.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class z extends MessageNano {
    public static volatile z[] d;

    /* renamed from: a  reason: collision with root package name */
    public w f1464a;
    public y b;
    public x c;

    public z() {
        a();
    }

    public static z[] b() {
        if (d == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (d == null) {
                    d = new z[0];
                }
            }
        }
        return d;
    }

    public final z a() {
        this.f1464a = null;
        this.b = null;
        this.c = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        w wVar = this.f1464a;
        if (wVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(1, wVar);
        }
        y yVar = this.b;
        if (yVar != null) {
            computeSerializedSize += CodedOutputByteBufferNano.computeMessageSize(2, yVar);
        }
        x xVar = this.c;
        return xVar != null ? CodedOutputByteBufferNano.computeMessageSize(3, xVar) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        w wVar = this.f1464a;
        if (wVar != null) {
            codedOutputByteBufferNano.writeMessage(1, wVar);
        }
        y yVar = this.b;
        if (yVar != null) {
            codedOutputByteBufferNano.writeMessage(2, yVar);
        }
        x xVar = this.c;
        if (xVar != null) {
            codedOutputByteBufferNano.writeMessage(3, xVar);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final z mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                if (this.f1464a == null) {
                    this.f1464a = new w();
                }
                codedInputByteBufferNano.readMessage(this.f1464a);
            } else if (readTag == 18) {
                if (this.b == null) {
                    this.b = new y();
                }
                codedInputByteBufferNano.readMessage(this.b);
            } else if (readTag != 26) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.c == null) {
                    this.c = new x();
                }
                codedInputByteBufferNano.readMessage(this.c);
            }
        }
        return this;
    }

    public static z b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new z().mergeFrom(codedInputByteBufferNano);
    }

    public static z a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (z) MessageNano.mergeFrom(new z(), bArr);
    }
}
