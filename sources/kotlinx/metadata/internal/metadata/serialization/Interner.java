package kotlinx.metadata.internal.metadata.serialization;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Interner.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0019\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00028\u0000¢\u0006\u0002\u0010\u0015R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0010¨\u0006\u0016"}, d2 = {"Lkotlinx/metadata/internal/metadata/serialization/Interner;", ExifInterface.GPS_DIRECTION_TRUE, "", "parent", "<init>", "(Lorg/jetbrains/kotlin/metadata/serialization/Interner;)V", "firstIndex", "", "interned", "Ljava/util/HashMap;", "allInternedObjects", "", "getAllInternedObjects", "()Ljava/util/List;", "isEmpty", "", "()Z", "find", "obj", "(Ljava/lang/Object;)Ljava/lang/Integer;", "intern", "(Ljava/lang/Object;)I", TtmlNode.TAG_METADATA}, k = 1, mv = {2, 0, 0}, xi = 50)
/* loaded from: classes5.dex */
public final class Interner<T> {
    private final int firstIndex;
    private final HashMap<T, Integer> interned;
    private final Interner<T> parent;

    public Interner() {
        this(null, 1, null);
    }

    public Interner(Interner<T> interner) {
        this.parent = interner;
        this.firstIndex = interner != null ? interner.interned.size() + interner.firstIndex : 0;
        this.interned = new HashMap<>();
    }

    public /* synthetic */ Interner(Interner interner, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : interner);
    }

    public final List<T> getAllInternedObjects() {
        Set<T> keySet = this.interned.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        final HashMap<T, Integer> hashMap = this.interned;
        return CollectionsKt.sortedWith(keySet, new Comparator() { // from class: kotlinx.metadata.internal.metadata.serialization.Interner$special$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues((Integer) hashMap.get(t), (Integer) hashMap.get(t2));
            }
        });
    }

    public final boolean isEmpty() {
        if (this.interned.isEmpty()) {
            Interner<T> interner = this.parent;
            return interner == null || interner.isEmpty();
        }
        return false;
    }

    private final Integer find(T t) {
        Integer find;
        Interner<T> interner = this.parent;
        if (interner != null) {
            int size = interner.interned.size() + this.parent.firstIndex;
            int i = this.firstIndex;
        }
        Interner<T> interner2 = this.parent;
        return (interner2 == null || (find = interner2.find(t)) == null) ? this.interned.get(t) : find;
    }

    public final int intern(T t) {
        Integer find = find(t);
        if (find != null) {
            return find.intValue();
        }
        int size = this.firstIndex + this.interned.size();
        this.interned.put(t, Integer.valueOf(size));
        return size;
    }
}
