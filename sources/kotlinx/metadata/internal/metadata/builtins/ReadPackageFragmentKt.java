package kotlinx.metadata.internal.metadata.builtins;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.metadata.internal.metadata.ProtoBuf;
import kotlinx.metadata.internal.protobuf.ExtensionRegistryLite;
/* compiled from: readPackageFragment.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001*\u00020\u0004¨\u0006\u0005"}, d2 = {"readBuiltinsPackageFragment", "Lkotlin/Pair;", "Lkotlinx/metadata/internal/metadata/ProtoBuf$PackageFragment;", "Lkotlinx/metadata/internal/metadata/builtins/BuiltInsBinaryVersion;", "Ljava/io/InputStream;", TtmlNode.TAG_METADATA}, k = 2, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public final class ReadPackageFragmentKt {
    public static final Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> readBuiltinsPackageFragment(InputStream inputStream) {
        ProtoBuf.PackageFragment packageFragment;
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        InputStream inputStream2 = inputStream;
        try {
            InputStream inputStream3 = inputStream2;
            BuiltInsBinaryVersion readFrom = BuiltInsBinaryVersion.Companion.readFrom(inputStream3);
            if (readFrom.isCompatibleWithCurrentCompilerVersion()) {
                ExtensionRegistryLite newInstance = ExtensionRegistryLite.newInstance();
                BuiltInsProtoBuf.registerAllExtensions(newInstance);
                packageFragment = ProtoBuf.PackageFragment.parseFrom(inputStream3, newInstance);
            } else {
                packageFragment = null;
            }
            Pair<ProtoBuf.PackageFragment, BuiltInsBinaryVersion> pair = TuplesKt.to(packageFragment, readFrom);
            CloseableKt.closeFinally(inputStream2, null);
            return pair;
        } finally {
        }
    }
}
