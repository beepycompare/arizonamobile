package kotlinx.metadata.internal.extensions;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.KmExtensionType;
/* compiled from: ExtensionUtils.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u0006\u0012\u0002\b\u00030\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"singleOfType", "N", "Lkotlinx/metadata/internal/extensions/KmExtension;", "", "type", "Lkotlinx/metadata/KmExtensionType;", "(Ljava/util/Collection;Lkotlinx/metadata/KmExtensionType;)Lkotlinx/metadata/internal/extensions/KmExtension;", "kotlinx-metadata"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExtensionUtilsKt {
    public static final <N extends KmExtension<?>> N singleOfType(Collection<? extends N> collection, KmExtensionType type) {
        Intrinsics.checkNotNullParameter(collection, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        N n = null;
        for (N n2 : collection) {
            if (Intrinsics.areEqual(n2.getType(), type)) {
                if (n != null) {
                    throw new IllegalStateException("Multiple extensions handle the same extension type: " + type);
                }
                n = n2;
            }
        }
        if (n != null) {
            return n;
        }
        throw new IllegalStateException("No extensions handle the extension type: " + type);
    }
}
