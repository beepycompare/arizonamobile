package kotlinx.metadata.internal.metadata.jvm.deserialization;

import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.jvm.JvmProtoBuf;
/* compiled from: JvmNameResolver.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lkotlinx/metadata/internal/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlinx/metadata/internal/metadata/jvm/deserialization/JvmNameResolverBase;", "types", "Lkotlinx/metadata/internal/metadata/jvm/JvmProtoBuf$StringTableTypes;", "strings", "", "", "<init>", "(Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$StringTableTypes;[Ljava/lang/String;)V", "getTypes", "()Lorg/jetbrains/kotlin/metadata/jvm/JvmProtoBuf$StringTableTypes;", "metadata.jvm"}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public final class JvmNameResolver extends JvmNameResolverBase {
    private final JvmProtoBuf.StringTableTypes types;

    public final JvmProtoBuf.StringTableTypes getTypes() {
        return this.types;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JvmNameResolver(JvmProtoBuf.StringTableTypes types, String[] strings) {
        super(strings, r0, JvmNameResolverKt.toExpandedRecordsList(r1));
        Set set;
        Intrinsics.checkNotNullParameter(types, "types");
        Intrinsics.checkNotNullParameter(strings, "strings");
        List<Integer> localNameList = types.getLocalNameList();
        if (localNameList.isEmpty()) {
            set = SetsKt.emptySet();
        } else {
            Intrinsics.checkNotNull(localNameList);
            set = CollectionsKt.toSet(localNameList);
        }
        List<JvmProtoBuf.StringTableTypes.Record> recordList = types.getRecordList();
        Intrinsics.checkNotNullExpressionValue(recordList, "getRecordList(...)");
        this.types = types;
    }
}
