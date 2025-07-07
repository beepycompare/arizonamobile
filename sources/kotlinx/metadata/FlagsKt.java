package kotlinx.metadata;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Flags.kt */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0005*D\b\u0007\u0010\u0006\"\u00020\u00012\u00020\u0001B6\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u001c\b\n\u0012\u0018\b\u000bB\u0014\b\u000b\u0012\u0006\b\f\u0012\u0002\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\n\b\u000f\u0012\u0006\b\n0\u00108\u0011¨\u0006\u0012"}, d2 = {"flagsOf", "", DownloaderServiceMarshaller.PARAMS_FLAGS, "", "Lkotlinx/metadata/Flag;", "([Lkotlinx/metadata/Flag;)I", "Flags", "Lkotlin/Deprecated;", "message", "Flags API is deprecated and this typealias will be removed. Use Int directly and then migrate to corresponding Km nodes extensions, e.g. KmClass.visibility", "replaceWith", "Lkotlin/ReplaceWith;", "imports", "expression", "Int", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "ERROR", "kotlinx-metadata"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlagsKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flags API is deprecated and this typealias will be removed. Use Int directly and then migrate to corresponding Km nodes extensions, e.g. KmClass.visibility", replaceWith = @ReplaceWith(expression = "Int", imports = {}))
    public static /* synthetic */ void Flags$annotations() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flags API is deprecated and this function will be removed. Create Km nodes directly and then use corresponding Km nodes extensions, e.g. KmClass.visibility")
    public static final int flagsOf(Flag... flags) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        int i = 0;
        for (Flag flag : flags) {
            i = flag.plus$kotlinx_metadata(i);
        }
        return i;
    }
}
