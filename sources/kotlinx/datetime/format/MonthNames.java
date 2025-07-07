package kotlinx.datetime.format;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LocalDateFormat.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bBg\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003¢\u0006\u0002\u0010\u000fB\u0013\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lkotlinx/datetime/format/MonthNames;", "", "january", "", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "names", "", "(Ljava/util/List;)V", "getNames", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", "toString", "Companion", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MonthNames {
    private final List<String> names;
    public static final Companion Companion = new Companion(null);
    private static final MonthNames ENGLISH_FULL = new MonthNames(CollectionsKt.listOf((Object[]) new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
    private static final MonthNames ENGLISH_ABBREVIATED = new MonthNames(CollectionsKt.listOf((Object[]) new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}));

    public MonthNames(List<String> names) {
        Intrinsics.checkNotNullParameter(names, "names");
        this.names = names;
        if (names.size() != 12) {
            throw new IllegalArgumentException("Month names must contain exactly 12 elements".toString());
        }
        Iterator<Integer> it = CollectionsKt.getIndices(names).iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            if (this.names.get(nextInt).length() <= 0) {
                throw new IllegalArgumentException("A month name can not be empty".toString());
            }
            for (int i = 0; i < nextInt; i++) {
                if (Intrinsics.areEqual(this.names.get(nextInt), this.names.get(i))) {
                    throw new IllegalArgumentException(("Month names must be unique, but '" + this.names.get(nextInt) + "' was repeated").toString());
                }
            }
        }
    }

    public final List<String> getNames() {
        return this.names;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MonthNames(String january, String february, String march, String april, String may, String june, String july, String august, String september, String october, String november, String december) {
        this(CollectionsKt.listOf((Object[]) new String[]{january, february, march, april, may, june, july, august, september, october, november, december}));
        Intrinsics.checkNotNullParameter(january, "january");
        Intrinsics.checkNotNullParameter(february, "february");
        Intrinsics.checkNotNullParameter(march, "march");
        Intrinsics.checkNotNullParameter(april, "april");
        Intrinsics.checkNotNullParameter(may, "may");
        Intrinsics.checkNotNullParameter(june, "june");
        Intrinsics.checkNotNullParameter(july, "july");
        Intrinsics.checkNotNullParameter(august, "august");
        Intrinsics.checkNotNullParameter(september, "september");
        Intrinsics.checkNotNullParameter(october, "october");
        Intrinsics.checkNotNullParameter(november, "november");
        Intrinsics.checkNotNullParameter(december, "december");
    }

    /* compiled from: LocalDateFormat.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlinx/datetime/format/MonthNames$Companion;", "", "()V", "ENGLISH_ABBREVIATED", "Lkotlinx/datetime/format/MonthNames;", "getENGLISH_ABBREVIATED", "()Lkotlinx/datetime/format/MonthNames;", "ENGLISH_FULL", "getENGLISH_FULL", "kotlinx-datetime"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MonthNames getENGLISH_FULL() {
            return MonthNames.ENGLISH_FULL;
        }

        public final MonthNames getENGLISH_ABBREVIATED() {
            return MonthNames.ENGLISH_ABBREVIATED;
        }
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.names, ", ", "MonthNames(", ")", 0, null, MonthNames$toString$1.INSTANCE, 24, null);
    }

    public boolean equals(Object obj) {
        return (obj instanceof MonthNames) && Intrinsics.areEqual(this.names, ((MonthNames) obj).names);
    }

    public int hashCode() {
        return this.names.hashCode();
    }
}
