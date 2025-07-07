package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.net.HttpHeaders;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: PagingDataEvent.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0005\u0004\u0005\u0006\u0007\bB\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Landroidx/paging/PagingDataEvent;", ExifInterface.GPS_DIRECTION_TRUE, "", "()V", "Append", "DropAppend", "DropPrepend", "Prepend", HttpHeaders.REFRESH, "Landroidx/paging/PagingDataEvent$Append;", "Landroidx/paging/PagingDataEvent$DropAppend;", "Landroidx/paging/PagingDataEvent$DropPrepend;", "Landroidx/paging/PagingDataEvent$Prepend;", "Landroidx/paging/PagingDataEvent$Refresh;", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class PagingDataEvent<T> {
    public /* synthetic */ PagingDataEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private PagingDataEvent() {
    }

    /* compiled from: PagingDataEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0015"}, d2 = {"Landroidx/paging/PagingDataEvent$Prepend;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PagingDataEvent;", "inserted", "", "newPlaceholdersBefore", "", "oldPlaceholdersBefore", "(Ljava/util/List;II)V", "getInserted", "()Ljava/util/List;", "getNewPlaceholdersBefore", "()I", "getOldPlaceholdersBefore", "equals", "", "other", "hashCode", "toString", "", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Prepend<T> extends PagingDataEvent<T> {
        private final List<T> inserted;
        private final int newPlaceholdersBefore;
        private final int oldPlaceholdersBefore;

        public final List<T> getInserted() {
            return this.inserted;
        }

        public final int getNewPlaceholdersBefore() {
            return this.newPlaceholdersBefore;
        }

        public final int getOldPlaceholdersBefore() {
            return this.oldPlaceholdersBefore;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Prepend(List<? extends T> inserted, int i, int i2) {
            super(null);
            Intrinsics.checkNotNullParameter(inserted, "inserted");
            this.inserted = inserted;
            this.newPlaceholdersBefore = i;
            this.oldPlaceholdersBefore = i2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Prepend) {
                Prepend prepend = (Prepend) obj;
                return Intrinsics.areEqual(this.inserted, prepend.inserted) && this.newPlaceholdersBefore == prepend.newPlaceholdersBefore && this.oldPlaceholdersBefore == prepend.oldPlaceholdersBefore;
            }
            return false;
        }

        public int hashCode() {
            return this.inserted.hashCode() + Integer.hashCode(this.newPlaceholdersBefore) + Integer.hashCode(this.oldPlaceholdersBefore);
        }

        public String toString() {
            return StringsKt.trimMargin$default("PagingDataEvent.Prepend loaded " + this.inserted.size() + " items (\n                    |   first item: " + CollectionsKt.firstOrNull((List<? extends Object>) this.inserted) + "\n                    |   last item: " + CollectionsKt.lastOrNull((List<? extends Object>) this.inserted) + "\n                    |   newPlaceholdersBefore: " + this.newPlaceholdersBefore + "\n                    |   oldPlaceholdersBefore: " + this.oldPlaceholdersBefore + "\n                    |)\n                    |", null, 1, null);
        }
    }

    /* compiled from: PagingDataEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B-\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0017"}, d2 = {"Landroidx/paging/PagingDataEvent$Append;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PagingDataEvent;", "startIndex", "", "inserted", "", "newPlaceholdersAfter", "oldPlaceholdersAfter", "(ILjava/util/List;II)V", "getInserted", "()Ljava/util/List;", "getNewPlaceholdersAfter", "()I", "getOldPlaceholdersAfter", "getStartIndex", "equals", "", "other", "hashCode", "toString", "", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Append<T> extends PagingDataEvent<T> {
        private final List<T> inserted;
        private final int newPlaceholdersAfter;
        private final int oldPlaceholdersAfter;
        private final int startIndex;

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final List<T> getInserted() {
            return this.inserted;
        }

        public final int getNewPlaceholdersAfter() {
            return this.newPlaceholdersAfter;
        }

        public final int getOldPlaceholdersAfter() {
            return this.oldPlaceholdersAfter;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public Append(int i, List<? extends T> inserted, int i2, int i3) {
            super(null);
            Intrinsics.checkNotNullParameter(inserted, "inserted");
            this.startIndex = i;
            this.inserted = inserted;
            this.newPlaceholdersAfter = i2;
            this.oldPlaceholdersAfter = i3;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Append) {
                Append append = (Append) obj;
                return this.startIndex == append.startIndex && Intrinsics.areEqual(this.inserted, append.inserted) && this.newPlaceholdersAfter == append.newPlaceholdersAfter && this.oldPlaceholdersAfter == append.oldPlaceholdersAfter;
            }
            return false;
        }

        public int hashCode() {
            return Integer.hashCode(this.startIndex) + this.inserted.hashCode() + Integer.hashCode(this.newPlaceholdersAfter) + Integer.hashCode(this.oldPlaceholdersAfter);
        }

        public String toString() {
            return StringsKt.trimMargin$default("PagingDataEvent.Append loaded " + this.inserted.size() + " items (\n                    |   startIndex: " + this.startIndex + "\n                    |   first item: " + CollectionsKt.firstOrNull((List<? extends Object>) this.inserted) + "\n                    |   last item: " + CollectionsKt.lastOrNull((List<? extends Object>) this.inserted) + "\n                    |   newPlaceholdersBefore: " + this.newPlaceholdersAfter + "\n                    |   oldPlaceholdersBefore: " + this.oldPlaceholdersAfter + "\n                    |)\n                    |", null, 1, null);
        }
    }

    /* compiled from: PagingDataEvent.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B#\b\u0007\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/paging/PagingDataEvent$Refresh;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PagingDataEvent;", "newList", "Landroidx/paging/PlaceholderPaddedList;", "previousList", "(Landroidx/paging/PlaceholderPaddedList;Landroidx/paging/PlaceholderPaddedList;)V", "getNewList", "()Landroidx/paging/PlaceholderPaddedList;", "getPreviousList", "equals", "", "other", "hashCode", "", "toString", "", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Refresh<T> extends PagingDataEvent<T> {
        private final PlaceholderPaddedList<T> newList;
        private final PlaceholderPaddedList<T> previousList;

        public final PlaceholderPaddedList<T> getNewList() {
            return this.newList;
        }

        public final PlaceholderPaddedList<T> getPreviousList() {
            return this.previousList;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Refresh(PlaceholderPaddedList<T> newList, PlaceholderPaddedList<T> previousList) {
            super(null);
            Intrinsics.checkNotNullParameter(newList, "newList");
            Intrinsics.checkNotNullParameter(previousList, "previousList");
            this.newList = newList;
            this.previousList = previousList;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Refresh) {
                Refresh refresh = (Refresh) obj;
                return this.newList.getPlaceholdersBefore() == refresh.newList.getPlaceholdersBefore() && this.newList.getPlaceholdersAfter() == refresh.newList.getPlaceholdersAfter() && this.newList.getSize() == refresh.newList.getSize() && this.newList.getDataCount() == refresh.newList.getDataCount() && this.previousList.getPlaceholdersBefore() == refresh.previousList.getPlaceholdersBefore() && this.previousList.getPlaceholdersAfter() == refresh.previousList.getPlaceholdersAfter() && this.previousList.getSize() == refresh.previousList.getSize() && this.previousList.getDataCount() == refresh.previousList.getDataCount();
            }
            return false;
        }

        public int hashCode() {
            return this.newList.hashCode() + this.previousList.hashCode();
        }

        public String toString() {
            return StringsKt.trimMargin$default("PagingDataEvent.Refresh loaded newList\n                    |   newList (\n                    |       placeholdersBefore: " + this.newList.getPlaceholdersBefore() + "\n                    |       placeholdersAfter: " + this.newList.getPlaceholdersAfter() + "\n                    |       size: " + this.newList.getSize() + "\n                    |       dataCount: " + this.newList.getDataCount() + "\n                    |   )\n                    |   previousList (\n                    |       placeholdersBefore: " + this.previousList.getPlaceholdersBefore() + "\n                    |       placeholdersAfter: " + this.previousList.getPlaceholdersAfter() + "\n                    |       size: " + this.previousList.getSize() + "\n                    |       dataCount: " + this.previousList.getDataCount() + "\n                    |   )\n                    |", null, 1, null);
        }
    }

    /* compiled from: PagingDataEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0005H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\n¨\u0006\u0013"}, d2 = {"Landroidx/paging/PagingDataEvent$DropPrepend;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PagingDataEvent;", "dropCount", "", "newPlaceholdersBefore", "oldPlaceholdersBefore", "(III)V", "getDropCount", "()I", "getNewPlaceholdersBefore", "getOldPlaceholdersBefore", "equals", "", "other", "hashCode", "toString", "", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DropPrepend<T> extends PagingDataEvent<T> {
        private final int dropCount;
        private final int newPlaceholdersBefore;
        private final int oldPlaceholdersBefore;

        public final int getDropCount() {
            return this.dropCount;
        }

        public final int getNewPlaceholdersBefore() {
            return this.newPlaceholdersBefore;
        }

        public final int getOldPlaceholdersBefore() {
            return this.oldPlaceholdersBefore;
        }

        public DropPrepend(int i, int i2, int i3) {
            super(null);
            this.dropCount = i;
            this.newPlaceholdersBefore = i2;
            this.oldPlaceholdersBefore = i3;
        }

        public boolean equals(Object obj) {
            if (obj instanceof DropPrepend) {
                DropPrepend dropPrepend = (DropPrepend) obj;
                return this.dropCount == dropPrepend.dropCount && this.newPlaceholdersBefore == dropPrepend.newPlaceholdersBefore && this.oldPlaceholdersBefore == dropPrepend.oldPlaceholdersBefore;
            }
            return false;
        }

        public int hashCode() {
            return Integer.hashCode(this.dropCount) + Integer.hashCode(this.newPlaceholdersBefore) + Integer.hashCode(this.oldPlaceholdersBefore);
        }

        public String toString() {
            return StringsKt.trimMargin$default("PagingDataEvent.DropPrepend dropped " + this.dropCount + " items (\n                    |   dropCount: " + this.dropCount + "\n                    |   newPlaceholdersBefore: " + this.newPlaceholdersBefore + "\n                    |   oldPlaceholdersBefore: " + this.oldPlaceholdersBefore + "\n                    |)\n                    |", null, 1, null);
        }
    }

    /* compiled from: PagingDataEvent.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0015"}, d2 = {"Landroidx/paging/PagingDataEvent$DropAppend;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PagingDataEvent;", "startIndex", "", "dropCount", "newPlaceholdersAfter", "oldPlaceholdersAfter", "(IIII)V", "getDropCount", "()I", "getNewPlaceholdersAfter", "getOldPlaceholdersAfter", "getStartIndex", "equals", "", "other", "hashCode", "toString", "", "paging-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DropAppend<T> extends PagingDataEvent<T> {
        private final int dropCount;
        private final int newPlaceholdersAfter;
        private final int oldPlaceholdersAfter;
        private final int startIndex;

        public final int getStartIndex() {
            return this.startIndex;
        }

        public final int getDropCount() {
            return this.dropCount;
        }

        public final int getNewPlaceholdersAfter() {
            return this.newPlaceholdersAfter;
        }

        public final int getOldPlaceholdersAfter() {
            return this.oldPlaceholdersAfter;
        }

        public DropAppend(int i, int i2, int i3, int i4) {
            super(null);
            this.startIndex = i;
            this.dropCount = i2;
            this.newPlaceholdersAfter = i3;
            this.oldPlaceholdersAfter = i4;
        }

        public boolean equals(Object obj) {
            if (obj instanceof DropAppend) {
                DropAppend dropAppend = (DropAppend) obj;
                return this.startIndex == dropAppend.startIndex && this.dropCount == dropAppend.dropCount && this.newPlaceholdersAfter == dropAppend.newPlaceholdersAfter && this.oldPlaceholdersAfter == dropAppend.oldPlaceholdersAfter;
            }
            return false;
        }

        public int hashCode() {
            return Integer.hashCode(this.startIndex) + Integer.hashCode(this.dropCount) + Integer.hashCode(this.newPlaceholdersAfter) + Integer.hashCode(this.oldPlaceholdersAfter);
        }

        public String toString() {
            return StringsKt.trimMargin$default("PagingDataEvent.DropAppend dropped " + this.dropCount + " items (\n                    |   startIndex: " + this.startIndex + "\n                    |   dropCount: " + this.dropCount + "\n                    |   newPlaceholdersBefore: " + this.newPlaceholdersAfter + "\n                    |   oldPlaceholdersBefore: " + this.oldPlaceholdersAfter + "\n                    |)\n                    |", null, 1, null);
        }
    }
}
