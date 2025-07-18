package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {
    private static final RangeMap<Comparable<?>, Object> EMPTY_SUB_RANGE_MAP = new RangeMap<Comparable<?>, Object>() { // from class: com.google.common.collect.TreeRangeMap.1
        @Override // com.google.common.collect.RangeMap
        public void clear() {
        }

        @Override // com.google.common.collect.RangeMap
        @CheckForNull
        public Object get(Comparable<?> key) {
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        @CheckForNull
        public Map.Entry<Range<Comparable<?>>, Object> getEntry(Comparable<?> key) {
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        public Range<Comparable<?>> span() {
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.RangeMap
        public void put(Range<Comparable<?>> range, Object value) {
            Preconditions.checkNotNull(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        @Override // com.google.common.collect.RangeMap
        public void putCoalescing(Range<Comparable<?>> range, Object value) {
            Preconditions.checkNotNull(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(RangeMap<Comparable<?>, ? extends Object> rangeMap) {
            if (!rangeMap.asMapOfRanges().isEmpty()) {
                throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
            }
        }

        @Override // com.google.common.collect.RangeMap
        public void remove(Range<Comparable<?>> range) {
            Preconditions.checkNotNull(range);
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<Comparable<?>>, Object> asMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<Comparable<?>>, Object> asDescendingMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // com.google.common.collect.RangeMap
        public RangeMap<Comparable<?>, Object> subRangeMap(Range<Comparable<?>> range) {
            Preconditions.checkNotNull(range);
            return this;
        }
    };
    private final NavigableMap<Cut<K>, RangeMapEntry<K, V>> entriesByLowerBound = Maps.newTreeMap();

    public static <K extends Comparable, V> TreeRangeMap<K, V> create() {
        return new TreeRangeMap<>();
    }

    private TreeRangeMap() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class RangeMapEntry<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V> {
        private final Range<K> range;
        private final V value;

        RangeMapEntry(Cut<K> lowerBound, Cut<K> upperBound, V value) {
            this(Range.create(lowerBound, upperBound), value);
        }

        RangeMapEntry(Range<K> range, V value) {
            this.range = range;
            this.value = value;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Range<K> getKey() {
            return this.range;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.value;
        }

        public boolean contains(K value) {
            return this.range.contains(value);
        }

        Cut<K> getLowerBound() {
            return this.range.lowerBound;
        }

        Cut<K> getUpperBound() {
            return this.range.upperBound;
        }
    }

    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public V get(K key) {
        Map.Entry<Range<K>, V> entry = getEntry(key);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public Map.Entry<Range<K>, V> getEntry(K key) {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> floorEntry = this.entriesByLowerBound.floorEntry(Cut.belowValue(key));
        if (floorEntry == null || !floorEntry.getValue().contains(key)) {
            return null;
        }
        return floorEntry.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    public void put(Range<K> range, V value) {
        if (range.isEmpty()) {
            return;
        }
        Preconditions.checkNotNull(value);
        remove(range);
        this.entriesByLowerBound.put(range.lowerBound, new RangeMapEntry(range, value));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeMap
    public void putCoalescing(Range<K> range, V value) {
        if (this.entriesByLowerBound.isEmpty()) {
            put(range, value);
        } else {
            put(coalescedRange(range, Preconditions.checkNotNull(value)), value);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range<K> coalescedRange(Range<K> range, V value) {
        return coalesce(coalesce(range, value, this.entriesByLowerBound.lowerEntry(range.lowerBound)), value, this.entriesByLowerBound.floorEntry(range.upperBound));
    }

    private static <K extends Comparable, V> Range<K> coalesce(Range<K> range, V value, @CheckForNull Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry) {
        return (entry != null && entry.getValue().getKey().isConnected(range) && entry.getValue().getValue().equals(value)) ? range.span(entry.getValue().getKey()) : range;
    }

    @Override // com.google.common.collect.RangeMap
    public void putAll(RangeMap<K, ? extends V> rangeMap) {
        for (Map.Entry<Range<K>, ? extends V> entry : rangeMap.asMapOfRanges().entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.collect.RangeMap
    public void clear() {
        this.entriesByLowerBound.clear();
    }

    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> firstEntry = this.entriesByLowerBound.firstEntry();
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> lastEntry = this.entriesByLowerBound.lastEntry();
        if (firstEntry == null || lastEntry == null) {
            throw new NoSuchElementException();
        }
        return Range.create(firstEntry.getValue().getKey().lowerBound, lastEntry.getValue().getKey().upperBound);
    }

    private void putRangeMapEntry(Cut<K> lowerBound, Cut<K> upperBound, V value) {
        this.entriesByLowerBound.put(lowerBound, new RangeMapEntry(lowerBound, upperBound, value));
    }

    @Override // com.google.common.collect.RangeMap
    public void remove(Range<K> rangeToRemove) {
        if (rangeToRemove.isEmpty()) {
            return;
        }
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> lowerEntry = this.entriesByLowerBound.lowerEntry(rangeToRemove.lowerBound);
        if (lowerEntry != null) {
            RangeMapEntry<K, V> value = lowerEntry.getValue();
            if (value.getUpperBound().compareTo(rangeToRemove.lowerBound) > 0) {
                if (value.getUpperBound().compareTo(rangeToRemove.upperBound) > 0) {
                    putRangeMapEntry(rangeToRemove.upperBound, value.getUpperBound(), lowerEntry.getValue().getValue());
                }
                putRangeMapEntry(value.getLowerBound(), rangeToRemove.lowerBound, lowerEntry.getValue().getValue());
            }
        }
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> lowerEntry2 = this.entriesByLowerBound.lowerEntry(rangeToRemove.upperBound);
        if (lowerEntry2 != null) {
            RangeMapEntry<K, V> value2 = lowerEntry2.getValue();
            if (value2.getUpperBound().compareTo(rangeToRemove.upperBound) > 0) {
                putRangeMapEntry(rangeToRemove.upperBound, value2.getUpperBound(), lowerEntry2.getValue().getValue());
            }
        }
        this.entriesByLowerBound.subMap(rangeToRemove.lowerBound, rangeToRemove.upperBound).clear();
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asMapOfRanges() {
        return new AsMapOfRanges(this.entriesByLowerBound.values());
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asDescendingMapOfRanges() {
        return new AsMapOfRanges(this.entriesByLowerBound.descendingMap().values());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class AsMapOfRanges extends Maps.IteratorBasedAbstractMap<Range<K>, V> {
        final Iterable<Map.Entry<Range<K>, V>> entryIterable;

        AsMapOfRanges(Iterable<RangeMapEntry<K, V>> entryIterable) {
            this.entryIterable = entryIterable;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object key) {
            return get(key) != null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        public V get(@CheckForNull Object key) {
            if (key instanceof Range) {
                Range range = (Range) key;
                RangeMapEntry rangeMapEntry = (RangeMapEntry) TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
                if (rangeMapEntry == null || !rangeMapEntry.getKey().equals(range)) {
                    return null;
                }
                return (V) rangeMapEntry.getValue();
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public int size() {
            return TreeRangeMap.this.entriesByLowerBound.size();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<Range<K>, V>> entryIterator() {
            return this.entryIterable.iterator();
        }
    }

    @Override // com.google.common.collect.RangeMap
    public RangeMap<K, V> subRangeMap(Range<K> subRange) {
        return subRange.equals(Range.all()) ? this : new SubRangeMap(subRange);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RangeMap<K, V> emptySubRangeMap() {
        return EMPTY_SUB_RANGE_MAP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class SubRangeMap implements RangeMap<K, V> {
        private final Range<K> subRange;

        SubRangeMap(Range<K> subRange) {
            this.subRange = subRange;
        }

        @Override // com.google.common.collect.RangeMap
        @CheckForNull
        public V get(K key) {
            if (this.subRange.contains(key)) {
                return (V) TreeRangeMap.this.get(key);
            }
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        @CheckForNull
        public Map.Entry<Range<K>, V> getEntry(K key) {
            Map.Entry<Range<K>, V> entry;
            if (!this.subRange.contains(key) || (entry = TreeRangeMap.this.getEntry(key)) == null) {
                return null;
            }
            return Maps.immutableEntry(entry.getKey().intersection(this.subRange), entry.getValue());
        }

        @Override // com.google.common.collect.RangeMap
        public Range<K> span() {
            Cut<K> cut;
            Cut<K> upperBound;
            Map.Entry floorEntry = TreeRangeMap.this.entriesByLowerBound.floorEntry(this.subRange.lowerBound);
            if (floorEntry == null || ((RangeMapEntry) floorEntry.getValue()).getUpperBound().compareTo(this.subRange.lowerBound) <= 0) {
                cut = (Cut) TreeRangeMap.this.entriesByLowerBound.ceilingKey(this.subRange.lowerBound);
                if (cut == null || cut.compareTo(this.subRange.upperBound) >= 0) {
                    throw new NoSuchElementException();
                }
            } else {
                cut = this.subRange.lowerBound;
            }
            Map.Entry lowerEntry = TreeRangeMap.this.entriesByLowerBound.lowerEntry(this.subRange.upperBound);
            if (lowerEntry == null) {
                throw new NoSuchElementException();
            }
            if (((RangeMapEntry) lowerEntry.getValue()).getUpperBound().compareTo(this.subRange.upperBound) >= 0) {
                upperBound = this.subRange.upperBound;
            } else {
                upperBound = ((RangeMapEntry) lowerEntry.getValue()).getUpperBound();
            }
            return Range.create(cut, upperBound);
        }

        @Override // com.google.common.collect.RangeMap
        public void put(Range<K> range, V value) {
            Preconditions.checkArgument(this.subRange.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.subRange);
            TreeRangeMap.this.put(range, value);
        }

        @Override // com.google.common.collect.RangeMap
        public void putCoalescing(Range<K> range, V value) {
            if (TreeRangeMap.this.entriesByLowerBound.isEmpty() || !this.subRange.encloses(range)) {
                put(range, value);
            } else {
                put(TreeRangeMap.this.coalescedRange(range, Preconditions.checkNotNull(value)).intersection(this.subRange), value);
            }
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(RangeMap<K, ? extends V> rangeMap) {
            if (rangeMap.asMapOfRanges().isEmpty()) {
                return;
            }
            Range<K> span = rangeMap.span();
            Preconditions.checkArgument(this.subRange.encloses(span), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", span, this.subRange);
            TreeRangeMap.this.putAll(rangeMap);
        }

        @Override // com.google.common.collect.RangeMap
        public void clear() {
            TreeRangeMap.this.remove(this.subRange);
        }

        @Override // com.google.common.collect.RangeMap
        public void remove(Range<K> range) {
            if (range.isConnected(this.subRange)) {
                TreeRangeMap.this.remove(range.intersection(this.subRange));
            }
        }

        @Override // com.google.common.collect.RangeMap
        public RangeMap<K, V> subRangeMap(Range<K> range) {
            if (!range.isConnected(this.subRange)) {
                return TreeRangeMap.this.emptySubRangeMap();
            }
            return TreeRangeMap.this.subRangeMap(range.intersection(this.subRange));
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<K>, V> asMapOfRanges() {
            return new SubRangeMapAsMap();
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<K>, V> asDescendingMapOfRanges() {
            return new TreeRangeMap<K, V>.SubRangeMap.SubRangeMapAsMap() { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.1
                @Override // com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap
                Iterator<Map.Entry<Range<K>, V>> entryIterator() {
                    if (SubRangeMap.this.subRange.isEmpty()) {
                        return Iterators.emptyIterator();
                    }
                    final Iterator<V> it = TreeRangeMap.this.entriesByLowerBound.headMap(SubRangeMap.this.subRange.upperBound, false).descendingMap().values().iterator();
                    return new AbstractIterator<Map.Entry<Range<K>, V>>(this) { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.1.1
                        final /* synthetic */ AnonymousClass1 this$2;

                        {
                            this.this$2 = this;
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.google.common.collect.AbstractIterator
                        @CheckForNull
                        public Map.Entry<Range<K>, V> computeNext() {
                            if (it.hasNext()) {
                                RangeMapEntry rangeMapEntry = (RangeMapEntry) it.next();
                                if (rangeMapEntry.getUpperBound().compareTo((Cut<K>) SubRangeMap.this.subRange.lowerBound) > 0) {
                                    return Maps.immutableEntry(rangeMapEntry.getKey().intersection(SubRangeMap.this.subRange), rangeMapEntry.getValue());
                                }
                                return (Map.Entry) endOfData();
                            }
                            return (Map.Entry) endOfData();
                        }
                    };
                }
            };
        }

        @Override // com.google.common.collect.RangeMap
        public boolean equals(@CheckForNull Object o) {
            if (o instanceof RangeMap) {
                return asMapOfRanges().equals(((RangeMap) o).asMapOfRanges());
            }
            return false;
        }

        @Override // com.google.common.collect.RangeMap
        public int hashCode() {
            return asMapOfRanges().hashCode();
        }

        @Override // com.google.common.collect.RangeMap
        public String toString() {
            return asMapOfRanges().toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public class SubRangeMapAsMap extends AbstractMap<Range<K>, V> {
            SubRangeMapAsMap() {
            }

            @Override // java.util.AbstractMap, java.util.Map
            public boolean containsKey(@CheckForNull Object key) {
                return get(key) != null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            @CheckForNull
            public V get(@CheckForNull Object key) {
                RangeMapEntry rangeMapEntry;
                try {
                    if (key instanceof Range) {
                        Range range = (Range) key;
                        if (SubRangeMap.this.subRange.encloses(range) && !range.isEmpty()) {
                            if (range.lowerBound.compareTo((Cut) SubRangeMap.this.subRange.lowerBound) == 0) {
                                Map.Entry floorEntry = TreeRangeMap.this.entriesByLowerBound.floorEntry(range.lowerBound);
                                rangeMapEntry = floorEntry != null ? (RangeMapEntry) floorEntry.getValue() : null;
                            } else {
                                rangeMapEntry = (RangeMapEntry) TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
                            }
                            if (rangeMapEntry != null && rangeMapEntry.getKey().isConnected(SubRangeMap.this.subRange) && rangeMapEntry.getKey().intersection(SubRangeMap.this.subRange).equals(range)) {
                                return (V) rangeMapEntry.getValue();
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            @CheckForNull
            public V remove(@CheckForNull Object key) {
                V v = (V) get(key);
                if (v != null) {
                    TreeRangeMap.this.remove((Range) Objects.requireNonNull(key));
                    return v;
                }
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public void clear() {
                SubRangeMap.this.clear();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean removeEntryIf(Predicate<? super Map.Entry<Range<K>, V>> predicate) {
                ArrayList<Range<K>> newArrayList = Lists.newArrayList();
                for (Map.Entry<Range<K>, V> entry : entrySet()) {
                    if (predicate.apply(entry)) {
                        newArrayList.add(entry.getKey());
                    }
                }
                for (Range<K> range : newArrayList) {
                    TreeRangeMap.this.remove(range);
                }
                return !newArrayList.isEmpty();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Range<K>> keySet() {
                return new Maps.KeySet<Range<K>, V>(this) { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.1
                    @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(@CheckForNull Object o) {
                        return SubRangeMapAsMap.this.remove(o) != null;
                    }

                    @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean retainAll(Collection<?> c) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(c)), Maps.keyFunction()));
                    }
                };
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Map.Entry<Range<K>, V>> entrySet() {
                return new Maps.EntrySet<Range<K>, V>() { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.2
                    @Override // com.google.common.collect.Maps.EntrySet
                    Map<Range<K>, V> map() {
                        return SubRangeMapAsMap.this;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                    public Iterator<Map.Entry<Range<K>, V>> iterator() {
                        return SubRangeMapAsMap.this.entryIterator();
                    }

                    @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean retainAll(Collection<?> c) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.not(Predicates.in(c)));
                    }

                    @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public int size() {
                        return Iterators.size(iterator());
                    }

                    @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean isEmpty() {
                        return !iterator().hasNext();
                    }
                };
            }

            Iterator<Map.Entry<Range<K>, V>> entryIterator() {
                if (!SubRangeMap.this.subRange.isEmpty()) {
                    final Iterator<V> it = TreeRangeMap.this.entriesByLowerBound.tailMap((Cut) MoreObjects.firstNonNull((Cut) TreeRangeMap.this.entriesByLowerBound.floorKey(SubRangeMap.this.subRange.lowerBound), SubRangeMap.this.subRange.lowerBound), true).values().iterator();
                    return new AbstractIterator<Map.Entry<Range<K>, V>>(this) { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.3
                        final /* synthetic */ SubRangeMapAsMap this$2;

                        {
                            this.this$2 = this;
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.google.common.collect.AbstractIterator
                        @CheckForNull
                        public Map.Entry<Range<K>, V> computeNext() {
                            while (it.hasNext()) {
                                RangeMapEntry rangeMapEntry = (RangeMapEntry) it.next();
                                if (rangeMapEntry.getLowerBound().compareTo((Cut<K>) SubRangeMap.this.subRange.upperBound) < 0) {
                                    if (rangeMapEntry.getUpperBound().compareTo((Cut<K>) SubRangeMap.this.subRange.lowerBound) > 0) {
                                        return Maps.immutableEntry(rangeMapEntry.getKey().intersection(SubRangeMap.this.subRange), rangeMapEntry.getValue());
                                    }
                                } else {
                                    return (Map.Entry) endOfData();
                                }
                            }
                            return (Map.Entry) endOfData();
                        }
                    };
                }
                return Iterators.emptyIterator();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Collection<V> values() {
                return new Maps.Values<Range<K>, V>(this) { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.4
                    @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                    public boolean removeAll(Collection<?> c) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.in(c), Maps.valueFunction()));
                    }

                    @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                    public boolean retainAll(Collection<?> c) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(c)), Maps.valueFunction()));
                    }
                };
            }
        }
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(@CheckForNull Object o) {
        if (o instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) o).asMapOfRanges());
        }
        return false;
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    public String toString() {
        return this.entriesByLowerBound.values().toString();
    }
}
