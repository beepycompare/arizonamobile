package kotlinx.metadata.jvm.internal;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.WriteContext;
import kotlinx.metadata.internal.metadata.jvm.deserialization.JvmProtoBufUtil;
import kotlinx.metadata.internal.metadata.jvm.serialization.JvmStringTable;
import kotlinx.metadata.internal.metadata.serialization.StringTable;
import kotlinx.metadata.internal.protobuf.MessageLite;
/* compiled from: JvmWriteUtils.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¨\u0006\b"}, d2 = {"writeProtoBufData", "Lkotlin/Pair;", "", "", "message", "Lkotlinx/metadata/internal/protobuf/MessageLite;", "c", "Lkotlinx/metadata/internal/WriteContext;", "kotlinx-metadata-jvm"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class JvmWriteUtilsKt {
    public static final Pair<String[], String[]> writeProtoBufData(MessageLite message, WriteContext c) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(c, "c");
        StringTable strings = c.getStrings();
        Intrinsics.checkNotNull(strings, "null cannot be cast to non-null type org.jetbrains.kotlin.metadata.jvm.serialization.JvmStringTable");
        JvmStringTable jvmStringTable = (JvmStringTable) strings;
        return new Pair<>(JvmProtoBufUtil.writeData(message, jvmStringTable), jvmStringTable.getStrings().toArray(new String[0]));
    }
}
