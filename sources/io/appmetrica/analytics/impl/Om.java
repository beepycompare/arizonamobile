package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* loaded from: classes5.dex */
public final class Om extends MessageNano {
    public static volatile Om[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f710a;
    public Nm b;

    public Om() {
        a();
    }

    public static Om[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new Om[0];
                }
            }
        }
        return c;
    }

    public final Om a() {
        this.f710a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f710a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f710a);
        }
        Nm nm = this.b;
        return nm != null ? CodedOutputByteBufferNano.computeMessageSize(2, nm) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f710a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f710a);
        }
        Nm nm = this.b;
        if (nm != null) {
            codedOutputByteBufferNano.writeMessage(2, nm);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final Om mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f710a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new Nm();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static Om b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new Om().mergeFrom(codedInputByteBufferNano);
    }

    public static Om a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (Om) MessageNano.mergeFrom(new Om(), bArr);
    }
}
