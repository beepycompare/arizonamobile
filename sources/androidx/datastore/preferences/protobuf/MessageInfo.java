package androidx.datastore.preferences.protobuf;
@CheckReturnValue
/* loaded from: classes2.dex */
interface MessageInfo {
    MessageLite getDefaultInstance();

    ProtoSyntax getSyntax();

    boolean isMessageSetWireFormat();
}
