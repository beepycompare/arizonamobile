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
public final class C0458nm extends MessageNano {
    public static volatile C0458nm[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f1036a;
    public C0433mm b;

    public C0458nm() {
        a();
    }

    public static C0458nm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0458nm[0];
                }
            }
        }
        return c;
    }

    public final C0458nm a() {
        this.f1036a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1036a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1036a);
        }
        C0433mm c0433mm = this.b;
        return c0433mm != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0433mm) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1036a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1036a);
        }
        C0433mm c0433mm = this.b;
        if (c0433mm != null) {
            codedOutputByteBufferNano.writeMessage(2, c0433mm);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0458nm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1036a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0433mm();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0458nm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0458nm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0458nm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0458nm) MessageNano.mergeFrom(new C0458nm(), bArr);
    }
}
