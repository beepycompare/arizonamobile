package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.protobuf.nano.CodedInputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.CodedOutputByteBufferNano;
import io.appmetrica.analytics.protobuf.nano.InternalNano;
import io.appmetrica.analytics.protobuf.nano.InvalidProtocolBufferNanoException;
import io.appmetrica.analytics.protobuf.nano.MessageNano;
import io.appmetrica.analytics.protobuf.nano.WireFormatNano;
import java.io.IOException;
/* renamed from: io.appmetrica.analytics.impl.vm  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0669vm extends MessageNano {
    public static volatile C0669vm[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f1132a;
    public C0644um b;

    public C0669vm() {
        a();
    }

    public static C0669vm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0669vm[0];
                }
            }
        }
        return c;
    }

    public final C0669vm a() {
        this.f1132a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1132a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1132a);
        }
        C0644um c0644um = this.b;
        return c0644um != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0644um) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1132a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1132a);
        }
        C0644um c0644um = this.b;
        if (c0644um != null) {
            codedOutputByteBufferNano.writeMessage(2, c0644um);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0669vm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1132a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0644um();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0669vm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0669vm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0669vm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0669vm) MessageNano.mergeFrom(new C0669vm(), bArr);
    }
}
