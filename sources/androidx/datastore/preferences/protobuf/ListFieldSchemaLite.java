package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.List;
/* loaded from: classes2.dex */
final class ListFieldSchemaLite implements ListFieldSchema {
    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public <L> List<L> mutableListAt(Object message, long offset) {
        Internal.ProtobufList protobufList = getProtobufList(message, offset);
        if (protobufList.isModifiable()) {
            return protobufList;
        }
        int size = protobufList.size();
        Internal.ProtobufList mutableCopyWithCapacity = protobufList.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
        UnsafeUtil.putObject(message, offset, mutableCopyWithCapacity);
        return mutableCopyWithCapacity;
    }

    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public void makeImmutableListAt(Object message, long offset) {
        getProtobufList(message, offset).makeImmutable();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.datastore.preferences.protobuf.Internal$ProtobufList] */
    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public <E> void mergeListsAt(Object msg, Object otherMsg, long offset) {
        Internal.ProtobufList<E> protobufList = getProtobufList(msg, offset);
        Internal.ProtobufList<E> protobufList2 = getProtobufList(otherMsg, offset);
        int size = protobufList.size();
        int size2 = protobufList2.size();
        Internal.ProtobufList<E> protobufList3 = protobufList;
        protobufList3 = protobufList;
        if (size > 0 && size2 > 0) {
            boolean isModifiable = protobufList.isModifiable();
            Internal.ProtobufList<E> protobufList4 = protobufList;
            if (!isModifiable) {
                protobufList4 = protobufList.mutableCopyWithCapacity(size2 + size);
            }
            protobufList4.addAll(protobufList2);
            protobufList3 = protobufList4;
        }
        if (size > 0) {
            protobufList2 = protobufList3;
        }
        UnsafeUtil.putObject(msg, offset, protobufList2);
    }

    static <E> Internal.ProtobufList<E> getProtobufList(Object message, long offset) {
        return (Internal.ProtobufList) UnsafeUtil.getObject(message, offset);
    }
}
