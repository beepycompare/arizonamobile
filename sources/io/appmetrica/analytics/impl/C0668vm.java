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
public final class C0668vm extends MessageNano {
    public static volatile C0668vm[] c;

    /* renamed from: a  reason: collision with root package name */
    public String f1131a;
    public C0643um b;

    public C0668vm() {
        a();
    }

    public static C0668vm[] b() {
        if (c == null) {
            synchronized (InternalNano.LAZY_INIT_LOCK) {
                if (c == null) {
                    c = new C0668vm[0];
                }
            }
        }
        return c;
    }

    public final C0668vm a() {
        this.f1131a = "";
        this.b = null;
        this.cachedSize = -1;
        return this;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final int computeSerializedSize() {
        int computeSerializedSize = super.computeSerializedSize();
        if (!this.f1131a.equals("")) {
            computeSerializedSize += CodedOutputByteBufferNano.computeStringSize(1, this.f1131a);
        }
        C0643um c0643um = this.b;
        return c0643um != null ? CodedOutputByteBufferNano.computeMessageSize(2, c0643um) + computeSerializedSize : computeSerializedSize;
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    public final void writeTo(CodedOutputByteBufferNano codedOutputByteBufferNano) throws IOException {
        if (!this.f1131a.equals("")) {
            codedOutputByteBufferNano.writeString(1, this.f1131a);
        }
        C0643um c0643um = this.b;
        if (c0643um != null) {
            codedOutputByteBufferNano.writeMessage(2, c0643um);
        }
        super.writeTo(codedOutputByteBufferNano);
    }

    @Override // io.appmetrica.analytics.protobuf.nano.MessageNano
    /* renamed from: a */
    public final C0668vm mergeFrom(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        while (true) {
            int readTag = codedInputByteBufferNano.readTag();
            if (readTag == 0) {
                break;
            } else if (readTag == 10) {
                this.f1131a = codedInputByteBufferNano.readString();
            } else if (readTag != 18) {
                if (!WireFormatNano.parseUnknownField(codedInputByteBufferNano, readTag)) {
                    break;
                }
            } else {
                if (this.b == null) {
                    this.b = new C0643um();
                }
                codedInputByteBufferNano.readMessage(this.b);
            }
        }
        return this;
    }

    public static C0668vm b(CodedInputByteBufferNano codedInputByteBufferNano) throws IOException {
        return new C0668vm().mergeFrom(codedInputByteBufferNano);
    }

    public static C0668vm a(byte[] bArr) throws InvalidProtocolBufferNanoException {
        return (C0668vm) MessageNano.mergeFrom(new C0668vm(), bArr);
    }
}
