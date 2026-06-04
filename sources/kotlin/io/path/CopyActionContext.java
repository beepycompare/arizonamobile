package kotlin.io.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.NativeProtocol;
import java.nio.file.Path;
import kotlin.Metadata;
/* compiled from: CopyActionContext.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H¦\u0080\u0004Ê\u0001\u0002\b\tÊ\u0001\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¨\u0006\b"}, d2 = {"Lkotlin/io/path/CopyActionContext;", "", "copyToIgnoringExistingDirectory", "Lkotlin/io/path/CopyActionResult;", "Ljava/nio/file/Path;", TypedValues.AttributesType.S_TARGET, "followLinks", "", "kotlin-stdlib-jdk7", "Lkotlin/io/path/ExperimentalPathApi;", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.8"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface CopyActionContext {
    CopyActionResult copyToIgnoringExistingDirectory(Path path, Path path2, boolean z);
}
