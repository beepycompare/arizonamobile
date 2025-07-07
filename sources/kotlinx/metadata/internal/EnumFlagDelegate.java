package kotlinx.metadata.internal;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.vending.expansion.downloader.DownloaderServiceMarshaller;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.lang.Enum;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KProperty;
import kotlinx.metadata.internal.metadata.deserialization.Flags;
import kotlinx.metadata.internal.protobuf.Internal;
/* compiled from: FlagDelegatesImpl.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u000e\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004BE\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J\"\u0010\u0013\u001a\u00028\u00012\u0006\u0010\u0014\u001a\u00028\u00002\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0016H\u0086\u0002¢\u0006\u0002\u0010\u0017J*\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00028\u00002\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u001a\u001a\u00028\u0001H\u0086\u0002¢\u0006\u0002\u0010\u001bR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lkotlinx/metadata/internal/EnumFlagDelegate;", "Node", ExifInterface.LONGITUDE_EAST, "", "", DownloaderServiceMarshaller.PARAMS_FLAGS, "Lkotlin/reflect/KMutableProperty1;", "", "protoSet", "Lkotlinx/metadata/internal/metadata/deserialization/Flags$FlagField;", "Lkotlinx/metadata/internal/protobuf/Internal$EnumLite;", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "Lkotlin/enums/EnumEntries;", "flagValues", "", "Lkotlinx/metadata/internal/FlagImpl;", "(Lkotlin/reflect/KMutableProperty1;Lorg/jetbrains/kotlin/metadata/deserialization/Flags$FlagField;Lkotlin/enums/EnumEntries;Ljava/util/List;)V", "getFlags", "()Lkotlin/reflect/KMutableProperty1;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Enum;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Enum;)V", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EnumFlagDelegate<Node, E extends Enum<E>> {
    private final EnumEntries<E> entries;
    private final List<FlagImpl> flagValues;
    private final KMutableProperty1<Node, Integer> flags;
    private final Flags.FlagField<? extends Internal.EnumLite> protoSet;

    public EnumFlagDelegate(KMutableProperty1<Node, Integer> flags, Flags.FlagField<? extends Internal.EnumLite> protoSet, EnumEntries<E> entries, List<FlagImpl> flagValues) {
        Intrinsics.checkNotNullParameter(flags, "flags");
        Intrinsics.checkNotNullParameter(protoSet, "protoSet");
        Intrinsics.checkNotNullParameter(entries, "entries");
        Intrinsics.checkNotNullParameter(flagValues, "flagValues");
        this.flags = flags;
        this.protoSet = protoSet;
        this.entries = entries;
        this.flagValues = flagValues;
    }

    public final KMutableProperty1<Node, Integer> getFlags() {
        return this.flags;
    }

    public final E getValue(Node node, KProperty<?> property) {
        Intrinsics.checkNotNullParameter(property, "property");
        return (E) this.entries.get(this.protoSet.get(this.flags.get(node).intValue()).getNumber());
    }

    public final void setValue(Node node, KProperty<?> property, E value) {
        Intrinsics.checkNotNullParameter(property, "property");
        Intrinsics.checkNotNullParameter(value, "value");
        this.flags.set(node, Integer.valueOf(this.flagValues.get(value.ordinal()).plus$kotlinx_metadata(this.flags.get(node).intValue())));
    }
}
