package com.google.common.collect;

import androidx.collection.SieveCacheKt;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Serialization;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
@ElementTypesAreNonnullByDefault
/* loaded from: classes4.dex */
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {
    private static final long serialVersionUID = 1;
    private final transient AvlNode<E> header;
    private final transient GeneralRange<E> range;
    private final transient Reference<AvlNode<E>> rootReference;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int nodeAggregate(AvlNode<?> node) {
                return ((AvlNode) node).elemCount;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long treeAggregate(@CheckForNull AvlNode<?> root) {
                if (root == null) {
                    return 0L;
                }
                return ((AvlNode) root).totalCount;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int nodeAggregate(AvlNode<?> node) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long treeAggregate(@CheckForNull AvlNode<?> root) {
                if (root == null) {
                    return 0L;
                }
                return ((AvlNode) root).distinctElements;
            }
        };

        abstract int nodeAggregate(AvlNode<?> node);

        abstract long treeAggregate(@CheckForNull AvlNode<?> root);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object element) {
        return super.contains(element);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(@ParametricNullness Object fromElement, BoundType fromBoundType, @ParametricNullness Object toElement, BoundType toBoundType) {
        return super.subMultiset(fromElement, fromBoundType, toElement, toBoundType);
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    public static <E> TreeMultiset<E> create(@CheckForNull Comparator<? super E> comparator) {
        if (comparator == null) {
            return new TreeMultiset<>(Ordering.natural());
        }
        return new TreeMultiset<>(comparator);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> elements) {
        TreeMultiset<E> create = create();
        Iterables.addAll(create, elements);
        return create;
    }

    TreeMultiset(Reference<AvlNode<E>> rootReference, GeneralRange<E> range, AvlNode<E> endLink) {
        super(range.comparator());
        this.rootReference = rootReference;
        this.range = range;
        this.header = endLink;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        AvlNode<E> avlNode = new AvlNode<>();
        this.header = avlNode;
        successor(avlNode, avlNode);
        this.rootReference = new Reference<>();
    }

    private long aggregateForEntries(Aggregate aggr) {
        AvlNode<E> avlNode = this.rootReference.get();
        long treeAggregate = aggr.treeAggregate(avlNode);
        if (this.range.hasLowerBound()) {
            treeAggregate -= aggregateBelowRange(aggr, avlNode);
        }
        return this.range.hasUpperBound() ? treeAggregate - aggregateAboveRange(aggr, avlNode) : treeAggregate;
    }

    private long aggregateBelowRange(Aggregate aggr, @CheckForNull AvlNode<E> node) {
        long treeAggregate;
        long aggregateBelowRange;
        if (node == null) {
            return 0L;
        }
        int compare = comparator().compare(NullnessCasts.uncheckedCastNullableTToT(this.range.getLowerEndpoint()), node.getElement());
        if (compare < 0) {
            return aggregateBelowRange(aggr, ((AvlNode) node).left);
        }
        if (compare == 0) {
            int i = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getLowerBoundType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    throw new AssertionError();
                }
                return aggr.treeAggregate(((AvlNode) node).left);
            }
            treeAggregate = aggr.nodeAggregate(node);
            aggregateBelowRange = aggr.treeAggregate(((AvlNode) node).left);
        } else {
            treeAggregate = aggr.treeAggregate(((AvlNode) node).left) + aggr.nodeAggregate(node);
            aggregateBelowRange = aggregateBelowRange(aggr, ((AvlNode) node).right);
        }
        return treeAggregate + aggregateBelowRange;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.collect.TreeMultiset$4  reason: invalid class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType;

        static {
            int[] iArr = new int[BoundType.values().length];
            $SwitchMap$com$google$common$collect$BoundType = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private long aggregateAboveRange(Aggregate aggr, @CheckForNull AvlNode<E> node) {
        long treeAggregate;
        long aggregateAboveRange;
        if (node == null) {
            return 0L;
        }
        int compare = comparator().compare(NullnessCasts.uncheckedCastNullableTToT(this.range.getUpperEndpoint()), node.getElement());
        if (compare > 0) {
            return aggregateAboveRange(aggr, ((AvlNode) node).right);
        }
        if (compare == 0) {
            int i = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getUpperBoundType().ordinal()];
            if (i != 1) {
                if (i != 2) {
                    throw new AssertionError();
                }
                return aggr.treeAggregate(((AvlNode) node).right);
            }
            treeAggregate = aggr.nodeAggregate(node);
            aggregateAboveRange = aggr.treeAggregate(((AvlNode) node).right);
        } else {
            treeAggregate = aggr.treeAggregate(((AvlNode) node).right) + aggr.nodeAggregate(node);
            aggregateAboveRange = aggregateAboveRange(aggr, ((AvlNode) node).left);
        }
        return treeAggregate + aggregateAboveRange;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.SIZE));
    }

    @Override // com.google.common.collect.AbstractMultiset
    int distinctElements() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.DISTINCT));
    }

    static int distinctElements(@CheckForNull AvlNode<?> node) {
        if (node == null) {
            return 0;
        }
        return ((AvlNode) node).distinctElements;
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object element) {
        try {
            AvlNode<E> avlNode = this.rootReference.get();
            if (this.range.contains(element) && avlNode != null) {
                return avlNode.count(comparator(), element);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int add(@ParametricNullness E element, int occurrences) {
        CollectPreconditions.checkNonnegative(occurrences, "occurrences");
        if (occurrences == 0) {
            return count(element);
        }
        Preconditions.checkArgument(this.range.contains(element));
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode == null) {
            comparator().compare(element, element);
            AvlNode<E> avlNode2 = new AvlNode<>(element, occurrences);
            AvlNode<E> avlNode3 = this.header;
            successor(avlNode3, avlNode2, avlNode3);
            this.rootReference.checkAndSet(avlNode, avlNode2);
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.checkAndSet(avlNode, avlNode.add(comparator(), element, occurrences, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int remove(@CheckForNull Object element, int occurrences) {
        CollectPreconditions.checkNonnegative(occurrences, "occurrences");
        if (occurrences == 0) {
            return count(element);
        }
        AvlNode<E> avlNode = this.rootReference.get();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(element) && avlNode != null) {
                this.rootReference.checkAndSet(avlNode, avlNode.remove(comparator(), element, occurrences, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int setCount(@ParametricNullness E element, int count) {
        CollectPreconditions.checkNonnegative(count, "count");
        if (!this.range.contains(element)) {
            Preconditions.checkArgument(count == 0);
            return 0;
        }
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode == null) {
            if (count > 0) {
                add(element, count);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.checkAndSet(avlNode, avlNode.setCount(comparator(), element, count, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public boolean setCount(@ParametricNullness E element, int oldCount, int newCount) {
        CollectPreconditions.checkNonnegative(newCount, "newCount");
        CollectPreconditions.checkNonnegative(oldCount, "oldCount");
        Preconditions.checkArgument(this.range.contains(element));
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode != null) {
            int[] iArr = new int[1];
            this.rootReference.checkAndSet(avlNode, avlNode.setCount(comparator(), element, oldCount, newCount, iArr));
            return iArr[0] == oldCount;
        } else if (oldCount == 0) {
            if (newCount > 0) {
                add(element, newCount);
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.range.hasLowerBound() || this.range.hasUpperBound()) {
            Iterators.clear(entryIterator());
            return;
        }
        AvlNode<E> succ = this.header.succ();
        while (true) {
            AvlNode<E> avlNode = this.header;
            if (succ == avlNode) {
                successor(avlNode, avlNode);
                this.rootReference.clear();
                return;
            }
            AvlNode<E> succ2 = succ.succ();
            ((AvlNode) succ).elemCount = 0;
            ((AvlNode) succ).left = null;
            ((AvlNode) succ).right = null;
            ((AvlNode) succ).pred = null;
            ((AvlNode) succ).succ = null;
            succ = succ2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset.Entry<E> wrapEntry(final AvlNode<E> baseEntry) {
        return new Multisets.AbstractEntry<E>(this) { // from class: com.google.common.collect.TreeMultiset.1
            final /* synthetic */ TreeMultiset this$0;

            {
                this.this$0 = this;
            }

            @Override // com.google.common.collect.Multiset.Entry
            @ParametricNullness
            public E getElement() {
                return (E) baseEntry.getElement();
            }

            @Override // com.google.common.collect.Multiset.Entry
            public int getCount() {
                int count = baseEntry.getCount();
                return count == 0 ? this.this$0.count(getElement()) : count;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public AvlNode<E> firstNode() {
        AvlNode<E> succ;
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            Object uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.range.getLowerEndpoint());
            succ = avlNode.ceiling(comparator(), uncheckedCastNullableTToT);
            if (succ == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(uncheckedCastNullableTToT, succ.getElement()) == 0) {
                succ = succ.succ();
            }
        } else {
            succ = this.header.succ();
        }
        if (succ == this.header || !this.range.contains(succ.getElement())) {
            return null;
        }
        return succ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public AvlNode<E> lastNode() {
        AvlNode<E> pred;
        AvlNode<E> avlNode = this.rootReference.get();
        if (avlNode == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            Object uncheckedCastNullableTToT = NullnessCasts.uncheckedCastNullableTToT(this.range.getUpperEndpoint());
            pred = avlNode.floor(comparator(), uncheckedCastNullableTToT);
            if (pred == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(uncheckedCastNullableTToT, pred.getElement()) == 0) {
                pred = pred.pred();
            }
        } else {
            pred = this.header.pred();
        }
        if (pred == this.header || !this.range.contains(pred.getElement())) {
            return null;
        }
        return pred;
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<E> elementIterator() {
        return Multisets.elementIterator(entryIterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<Multiset.Entry<E>> entryIterator() {
        return new Iterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.TreeMultiset.2
            @CheckForNull
            AvlNode<E> current;
            @CheckForNull
            Multiset.Entry<E> prevEntry;

            {
                this.current = TreeMultiset.this.firstNode();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (TreeMultiset.this.range.tooHigh(this.current.getElement())) {
                    this.current = null;
                    return false;
                }
                return true;
            }

            @Override // java.util.Iterator
            public Multiset.Entry<E> next() {
                if (hasNext()) {
                    Multiset.Entry<E> wrapEntry = TreeMultiset.this.wrapEntry((AvlNode) Objects.requireNonNull(this.current));
                    this.prevEntry = wrapEntry;
                    if (this.current.succ() == TreeMultiset.this.header) {
                        this.current = null;
                        return wrapEntry;
                    }
                    this.current = this.current.succ();
                    return wrapEntry;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.checkState(this.prevEntry != null, "no calls to next() since the last call to remove()");
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractSortedMultiset
    Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new Iterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.TreeMultiset.3
            @CheckForNull
            AvlNode<E> current;
            @CheckForNull
            Multiset.Entry<E> prevEntry = null;

            {
                this.current = TreeMultiset.this.lastNode();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (TreeMultiset.this.range.tooLow(this.current.getElement())) {
                    this.current = null;
                    return false;
                }
                return true;
            }

            @Override // java.util.Iterator
            public Multiset.Entry<E> next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Objects.requireNonNull(this.current);
                Multiset.Entry<E> wrapEntry = TreeMultiset.this.wrapEntry(this.current);
                this.prevEntry = wrapEntry;
                if (this.current.pred() == TreeMultiset.this.header) {
                    this.current = null;
                    return wrapEntry;
                }
                this.current = this.current.pred();
                return wrapEntry;
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.checkState(this.prevEntry != null, "no calls to next() since the last call to remove()");
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(@ParametricNullness E upperBound, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), upperBound, boundType)), this.header);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(@ParametricNullness E lowerBound, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), lowerBound, boundType)), this.header);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class Reference<T> {
        @CheckForNull
        private T value;

        private Reference() {
        }

        @CheckForNull
        public T get() {
            return this.value;
        }

        public void checkAndSet(@CheckForNull T expected, @CheckForNull T newValue) {
            if (this.value != expected) {
                throw new ConcurrentModificationException();
            }
            this.value = newValue;
        }

        void clear() {
            this.value = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class AvlNode<E> {
        private int distinctElements;
        @CheckForNull
        private final E elem;
        private int elemCount;
        private int height;
        @CheckForNull
        private AvlNode<E> left;
        @CheckForNull
        private AvlNode<E> pred;
        @CheckForNull
        private AvlNode<E> right;
        @CheckForNull
        private AvlNode<E> succ;
        private long totalCount;

        AvlNode(@ParametricNullness E elem, int elemCount) {
            Preconditions.checkArgument(elemCount > 0);
            this.elem = elem;
            this.elemCount = elemCount;
            this.totalCount = elemCount;
            this.distinctElements = 1;
            this.height = 1;
            this.left = null;
            this.right = null;
        }

        AvlNode() {
            this.elem = null;
            this.elemCount = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AvlNode<E> pred() {
            return (AvlNode) Objects.requireNonNull(this.pred);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AvlNode<E> succ() {
            return (AvlNode) Objects.requireNonNull(this.succ);
        }

        /* JADX WARN: Multi-variable type inference failed */
        int count(Comparator<? super E> comparator, @ParametricNullness E e) {
            int compare = comparator.compare(e, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    return 0;
                }
                return avlNode.count(comparator, e);
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    return 0;
                }
                return avlNode2.count(comparator, e);
            } else {
                return this.elemCount;
            }
        }

        private AvlNode<E> addRightChild(@ParametricNullness E e, int count) {
            AvlNode<E> avlNode = new AvlNode<>(e, count);
            this.right = avlNode;
            TreeMultiset.successor(this, avlNode, succ());
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += count;
            return this;
        }

        private AvlNode<E> addLeftChild(@ParametricNullness E e, int count) {
            this.left = new AvlNode<>(e, count);
            TreeMultiset.successor(pred(), this.left, this);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += count;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> add(Comparator<? super E> comparator, @ParametricNullness E e, int count, int[] result) {
            int compare = comparator.compare(e, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    result[0] = 0;
                    return addLeftChild(e, count);
                }
                int i = avlNode.height;
                AvlNode<E> add = avlNode.add(comparator, e, count, result);
                this.left = add;
                if (result[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += count;
                if (add.height != i) {
                    return rebalance();
                }
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    result[0] = 0;
                    return addRightChild(e, count);
                }
                int i2 = avlNode2.height;
                AvlNode<E> add2 = avlNode2.add(comparator, e, count, result);
                this.right = add2;
                if (result[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += count;
                if (add2.height != i2) {
                    return rebalance();
                }
            } else {
                int i3 = this.elemCount;
                result[0] = i3;
                long j = count;
                Preconditions.checkArgument(((long) i3) + j <= SieveCacheKt.NodeLinkMask);
                this.elemCount += count;
                this.totalCount += j;
                return this;
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        AvlNode<E> remove(Comparator<? super E> comparator, @ParametricNullness E e, int count, int[] result) {
            int compare = comparator.compare(e, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    result[0] = 0;
                    return this;
                }
                this.left = avlNode.remove(comparator, e, count, result);
                int i = result[0];
                if (i > 0) {
                    if (count >= i) {
                        this.distinctElements--;
                        this.totalCount -= i;
                    } else {
                        this.totalCount -= count;
                    }
                }
                return i == 0 ? this : rebalance();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    result[0] = 0;
                    return this;
                }
                this.right = avlNode2.remove(comparator, e, count, result);
                int i2 = result[0];
                if (i2 > 0) {
                    if (count >= i2) {
                        this.distinctElements--;
                        this.totalCount -= i2;
                    } else {
                        this.totalCount -= count;
                    }
                }
                return rebalance();
            } else {
                int i3 = this.elemCount;
                result[0] = i3;
                if (count >= i3) {
                    return deleteMe();
                }
                this.elemCount = i3 - count;
                this.totalCount -= count;
                return this;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        AvlNode<E> setCount(Comparator<? super E> comparator, @ParametricNullness E e, int count, int[] result) {
            int i;
            int compare = comparator.compare(e, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    result[0] = 0;
                    if (count > 0) {
                        return addLeftChild(e, count);
                    }
                } else {
                    this.left = avlNode.setCount(comparator, e, count, result);
                    if (count == 0 && result[0] != 0) {
                        this.distinctElements--;
                    } else if (count > 0 && result[0] == 0) {
                        this.distinctElements++;
                    }
                    this.totalCount += count - result[0];
                    return rebalance();
                }
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    result[0] = 0;
                    if (count > 0) {
                        return addRightChild(e, count);
                    }
                } else {
                    this.right = avlNode2.setCount(comparator, e, count, result);
                    if (count == 0 && result[0] != 0) {
                        this.distinctElements--;
                    } else if (count > 0 && result[0] == 0) {
                        this.distinctElements++;
                    }
                    this.totalCount += count - result[0];
                    return rebalance();
                }
            } else {
                result[0] = this.elemCount;
                if (count == 0) {
                    return deleteMe();
                }
                this.totalCount += count - i;
                this.elemCount = count;
                return this;
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        AvlNode<E> setCount(Comparator<? super E> comparator, @ParametricNullness E e, int expectedCount, int newCount, int[] result) {
            int compare = comparator.compare(e, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    result[0] = 0;
                    if (expectedCount == 0 && newCount > 0) {
                        return addLeftChild(e, newCount);
                    }
                } else {
                    this.left = avlNode.setCount(comparator, e, expectedCount, newCount, result);
                    int i = result[0];
                    if (i == expectedCount) {
                        if (newCount == 0 && i != 0) {
                            this.distinctElements--;
                        } else if (newCount > 0 && i == 0) {
                            this.distinctElements++;
                        }
                        this.totalCount += newCount - i;
                    }
                    return rebalance();
                }
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    result[0] = 0;
                    if (expectedCount == 0 && newCount > 0) {
                        return addRightChild(e, newCount);
                    }
                } else {
                    this.right = avlNode2.setCount(comparator, e, expectedCount, newCount, result);
                    int i2 = result[0];
                    if (i2 == expectedCount) {
                        if (newCount == 0 && i2 != 0) {
                            this.distinctElements--;
                        } else if (newCount > 0 && i2 == 0) {
                            this.distinctElements++;
                        }
                        this.totalCount += newCount - i2;
                    }
                    return rebalance();
                }
            } else {
                int i3 = this.elemCount;
                result[0] = i3;
                if (expectedCount == i3) {
                    if (newCount == 0) {
                        return deleteMe();
                    }
                    this.totalCount += newCount - i3;
                    this.elemCount = newCount;
                }
            }
            return this;
        }

        @CheckForNull
        private AvlNode<E> deleteMe() {
            int i = this.elemCount;
            this.elemCount = 0;
            TreeMultiset.successor(pred(), succ());
            AvlNode<E> avlNode = this.left;
            if (avlNode == null) {
                return this.right;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return avlNode;
            }
            if (avlNode.height >= avlNode2.height) {
                AvlNode<E> pred = pred();
                pred.left = this.left.removeMax(pred);
                pred.right = this.right;
                pred.distinctElements = this.distinctElements - 1;
                pred.totalCount = this.totalCount - i;
                return pred.rebalance();
            }
            AvlNode<E> succ = succ();
            succ.right = this.right.removeMin(succ);
            succ.left = this.left;
            succ.distinctElements = this.distinctElements - 1;
            succ.totalCount = this.totalCount - i;
            return succ.rebalance();
        }

        @CheckForNull
        private AvlNode<E> removeMin(AvlNode<E> node) {
            AvlNode<E> avlNode = this.left;
            if (avlNode == null) {
                return this.right;
            }
            this.left = avlNode.removeMin(node);
            this.distinctElements--;
            this.totalCount -= node.elemCount;
            return rebalance();
        }

        @CheckForNull
        private AvlNode<E> removeMax(AvlNode<E> node) {
            AvlNode<E> avlNode = this.right;
            if (avlNode == null) {
                return this.left;
            }
            this.right = avlNode.removeMax(node);
            this.distinctElements--;
            this.totalCount -= node.elemCount;
            return rebalance();
        }

        private void recomputeMultiset() {
            this.distinctElements = TreeMultiset.distinctElements(this.left) + 1 + TreeMultiset.distinctElements(this.right);
            this.totalCount = this.elemCount + totalCount(this.left) + totalCount(this.right);
        }

        private void recomputeHeight() {
            this.height = Math.max(height(this.left), height(this.right)) + 1;
        }

        private void recompute() {
            recomputeMultiset();
            recomputeHeight();
        }

        private AvlNode<E> rebalance() {
            int balanceFactor = balanceFactor();
            if (balanceFactor == -2) {
                Objects.requireNonNull(this.right);
                if (this.right.balanceFactor() > 0) {
                    this.right = this.right.rotateRight();
                }
                return rotateLeft();
            } else if (balanceFactor == 2) {
                Objects.requireNonNull(this.left);
                if (this.left.balanceFactor() < 0) {
                    this.left = this.left.rotateLeft();
                }
                return rotateRight();
            } else {
                recomputeHeight();
                return this;
            }
        }

        private int balanceFactor() {
            return height(this.left) - height(this.right);
        }

        private AvlNode<E> rotateLeft() {
            Preconditions.checkState(this.right != null);
            AvlNode<E> avlNode = this.right;
            this.right = avlNode.left;
            avlNode.left = this;
            avlNode.totalCount = this.totalCount;
            avlNode.distinctElements = this.distinctElements;
            recompute();
            avlNode.recomputeHeight();
            return avlNode;
        }

        private AvlNode<E> rotateRight() {
            Preconditions.checkState(this.left != null);
            AvlNode<E> avlNode = this.left;
            this.left = avlNode.right;
            avlNode.right = this;
            avlNode.totalCount = this.totalCount;
            avlNode.distinctElements = this.distinctElements;
            recompute();
            avlNode.recomputeHeight();
            return avlNode;
        }

        private static long totalCount(@CheckForNull AvlNode<?> node) {
            if (node == null) {
                return 0L;
            }
            return ((AvlNode) node).totalCount;
        }

        private static int height(@CheckForNull AvlNode<?> node) {
            if (node == null) {
                return 0;
            }
            return ((AvlNode) node).height;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public AvlNode<E> ceiling(Comparator<? super E> comparator, @ParametricNullness E e) {
            int compare = comparator.compare(e, getElement());
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode != null) {
                    return (AvlNode) MoreObjects.firstNonNull(avlNode.ceiling(comparator, e), this);
                }
            } else if (compare != 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    return null;
                }
                return avlNode2.ceiling(comparator, e);
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public AvlNode<E> floor(Comparator<? super E> comparator, @ParametricNullness E e) {
            int compare = comparator.compare(e, getElement());
            if (compare > 0) {
                AvlNode<E> avlNode = this.right;
                if (avlNode != null) {
                    return (AvlNode) MoreObjects.firstNonNull(avlNode.floor(comparator, e), this);
                }
            } else if (compare != 0) {
                AvlNode<E> avlNode2 = this.left;
                if (avlNode2 == null) {
                    return null;
                }
                return avlNode2.floor(comparator, e);
            }
            return this;
        }

        @ParametricNullness
        E getElement() {
            return (E) NullnessCasts.uncheckedCastNullableTToT(this.elem);
        }

        int getCount() {
            return this.elemCount;
        }

        public String toString() {
            return Multisets.immutableEntry(getElement(), getCount()).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(AvlNode<T> a2, AvlNode<T> b) {
        ((AvlNode) a2).succ = b;
        ((AvlNode) b).pred = a2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void successor(AvlNode<T> a2, AvlNode<T> b, AvlNode<T> c) {
        successor(a2, b);
        successor(b, c);
    }

    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(elementSet().comparator());
        Serialization.writeMultiset(this, stream);
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        Comparator comparator = (Comparator) Objects.requireNonNull(stream.readObject());
        Serialization.getFieldSetter(AbstractSortedMultiset.class, "comparator").set((Serialization.FieldSetter) this, (Object) comparator);
        Serialization.getFieldSetter(TreeMultiset.class, "range").set((Serialization.FieldSetter) this, (Object) GeneralRange.all(comparator));
        Serialization.getFieldSetter(TreeMultiset.class, "rootReference").set((Serialization.FieldSetter) this, (Object) new Reference());
        AvlNode avlNode = new AvlNode();
        Serialization.getFieldSetter(TreeMultiset.class, "header").set((Serialization.FieldSetter) this, (Object) avlNode);
        successor(avlNode, avlNode);
        Serialization.populateMultiset(this, stream);
    }
}
