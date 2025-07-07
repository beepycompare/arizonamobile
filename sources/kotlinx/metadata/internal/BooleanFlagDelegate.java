package kotlinx.metadata.internal;

import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
/* compiled from: FlagDelegatesImpl.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B!\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00028\u00002\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0086\u0002¢\u0006\u0002\u0010\u000fJ*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00028\u00002\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0012\u001a\u00020\u000bH\u0086\u0002¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlinx/metadata/internal/BooleanFlagDelegate;", "Node", "", DownloaderServiceMarshaller.PARAMS_FLAGS, "Lkotlin/reflect/KMutableProperty1;", "", "flag", "Lkotlinx/metadata/internal/FlagImpl;", "(Lkotlin/reflect/KMutableProperty1;Lkotlinx/metadata/internal/FlagImpl;)V", "mask", "getValue", "", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Z", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Z)V", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BooleanFlagDelegate<Node> {
    private final FlagImpl flag;
    private final KMutableProperty1<Node, Integer> flags;
    private final int mask;

    public BooleanFlagDelegate(KMutableProperty1<Node, Integer> flags, FlagImpl flag) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Intrinsics.checkNotNullParameter(flag, "flag");
        this.flags = flags;
        this.flag = flag;
        if (flag.getBitWidth$kotlinx_metadata() != 1 || flag.getValue$kotlinx_metadata() != 1) {
            throw new IllegalArgumentException(("BooleanFlagDelegate can work only with boolean flags (bitWidth = 1 and value = 1), but " + flag + " was passed").toString());
        }
        this.mask = 1 << flag.getOffset$kotlinx_metadata();
    }

    public final boolean getValue(Node node, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.flag.invoke(this.flags.get(node).intValue());
    }

    public final void setValue(Node node, KProperty<?> property, boolean z) {
        Intrinsics.checkNotNullParameter(property, "property");
        int intValue = this.flags.get(node).intValue();
        this.flags.set(node, Integer.valueOf(z ? intValue | this.mask : intValue & (~this.mask)));
    }
}
