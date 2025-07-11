package kotlinx.datetime;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.LongProgression;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.internal.MathKt;
/* compiled from: LocalDateRange.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001%B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B!\b\u0010\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u0016\u0010\u001d\u001a\u00020\u00162\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016J\u0011\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u0002H\u0096\u0002J\u0013\u0010!\u001a\u00020\u00162\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0002J\b\u0010$\u001a\u00020\u001aH\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lkotlinx/datetime/LocalDateProgression;", "", "Lkotlinx/datetime/LocalDate;", "longProgression", "Lkotlin/ranges/LongProgression;", "<init>", "(Lkotlin/ranges/LongProgression;)V", TtmlNode.START, "endInclusive", "step", "", "(Lkotlinx/datetime/LocalDate;Lkotlinx/datetime/LocalDate;J)V", "getLongProgression$kotlinx_datetime", "()Lkotlin/ranges/LongProgression;", "first", "getFirst", "()Lkotlinx/datetime/LocalDate;", "last", "getLast", "iterator", "", "isEmpty", "", "toString", "", "size", "", "getSize", "()I", "containsAll", "elements", "contains", "value", "equals", "other", "", "hashCode", "Companion", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public class LocalDateProgression implements Collection<LocalDate>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    private final LocalDate first;
    private final LocalDate last;
    private final LongProgression longProgression;

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(LocalDate localDate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* renamed from: add  reason: avoid collision after fix types in other method */
    public boolean add2(LocalDate localDate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends LocalDate> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeIf(Predicate<? super LocalDate> predicate) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof LocalDate) {
            return contains((LocalDate) obj);
        }
        return false;
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    public LocalDateProgression(LongProgression longProgression) {
        Intrinsics.checkNotNullParameter(longProgression, "longProgression");
        this.longProgression = longProgression;
        this.first = LocalDate.Companion.fromEpochDays(longProgression.getFirst());
        this.last = LocalDate.Companion.fromEpochDays(longProgression.getLast());
    }

    public final LongProgression getLongProgression$kotlinx_datetime() {
        return this.longProgression;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalDateProgression(LocalDate start, LocalDate endInclusive, long j) {
        this(LongProgression.Companion.fromClosedRange(start.m10087toEpochDays(), endInclusive.m10087toEpochDays(), j));
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(endInclusive, "endInclusive");
    }

    public final LocalDate getFirst() {
        return this.first;
    }

    public final LocalDate getLast() {
        return this.last;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [kotlin.collections.LongIterator] */
    @Override // java.util.Collection, java.lang.Iterable
    public Iterator<LocalDate> iterator() {
        return new LocalDateProgressionIterator(this.longProgression.iterator());
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.longProgression.isEmpty();
    }

    public String toString() {
        return this.longProgression.getStep() > 0 ? this.first + ".." + this.last + " step " + this.longProgression.getStep() + 'D' : this.first + " downTo " + this.last + " step " + this.longProgression.getStep() + 'D';
    }

    public int getSize() {
        return MathKt.getSizeUnsafe(this.longProgression);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x001c  */
    @Override // java.util.Collection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean containsAll(Collection<?> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<?> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof LocalDate) || !contains(obj)) {
                return false;
            }
            while (r4.hasNext()) {
            }
        }
        return true;
    }

    public boolean contains(LocalDate value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return MathKt.containsUnsafe(this.longProgression, value.m10087toEpochDays());
    }

    @Override // java.util.Collection
    public boolean equals(Object obj) {
        return (obj instanceof LocalDateProgression) && Intrinsics.areEqual(this.longProgression, ((LocalDateProgression) obj).longProgression);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.longProgression.hashCode();
    }

    /* compiled from: LocalDateRange.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\r¨\u0006\u000e"}, d2 = {"Lkotlinx/datetime/LocalDateProgression$Companion;", "", "<init>", "()V", "fromClosedRange", "Lkotlinx/datetime/LocalDateProgression;", "rangeStart", "Lkotlinx/datetime/LocalDate;", "rangeEnd", "stepValue", "", "stepUnit", "Lkotlinx/datetime/DateTimeUnit$DayBased;", "fromClosedRange$kotlinx_datetime", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final LocalDateProgression fromClosedRange$kotlinx_datetime(LocalDate rangeStart, LocalDate rangeEnd, long j, DateTimeUnit.DayBased stepUnit) {
            Intrinsics.checkNotNullParameter(rangeStart, "rangeStart");
            Intrinsics.checkNotNullParameter(rangeEnd, "rangeEnd");
            Intrinsics.checkNotNullParameter(stepUnit, "stepUnit");
            return new LocalDateProgression(rangeStart, rangeEnd, MathKt.safeMultiplyOrClamp(j, stepUnit.getDays()));
        }
    }
}
