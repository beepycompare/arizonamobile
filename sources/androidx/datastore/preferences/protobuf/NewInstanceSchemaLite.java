package androidx.datastore.preferences.protobuf;
@CheckReturnValue
/* loaded from: classes2.dex */
final class NewInstanceSchemaLite implements NewInstanceSchema {
    @Override // androidx.datastore.preferences.protobuf.NewInstanceSchema
    public Object newInstance(Object defaultInstance) {
        return ((GeneratedMessageLite) defaultInstance).newMutableInstance();
    }
}
