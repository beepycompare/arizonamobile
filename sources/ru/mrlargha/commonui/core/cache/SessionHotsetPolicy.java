package ru.mrlargha.commonui.core.cache;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import ru.mrlargha.commonui.core.cache.SessionHotsetPolicy;
/* compiled from: SessionHotsetPolicy.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u0000 =*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0002<=B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ=\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J)\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0002\u0010\u001bJ1\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0002\u0010\u001fJ\u001a\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0!2\u0006\u0010\u0014\u001a\u00020\u0006J7\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0!2\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u0006¢\u0006\u0002\u0010&J\u001b\u0010'\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0002\u0010(J\r\u0010)\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010*J\u0006\u0010+\u001a\u00020,J\u0006\u0010-\u001a\u00020.J\u001c\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\"0!2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u001e\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bH\u0002J,\u00102\u001a\b\u0012\u0004\u0012\u00028\u00000\"2\f\u00103\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0015\u00104\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00105J\b\u00106\u001a\u00020.H\u0002J\b\u00107\u001a\u00020\u0006H\u0002J\u0010\u00108\u001a\u00020.2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0018\u00109\u001a\u00020\u00062\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lru/mrlargha/commonui/core/cache/SessionHotsetPolicy;", "K", "", "maxHiddenEntries", "", "hiddenTtlMs", "", "<init>", "(IJ)V", "hiddenByKey", "", "Lru/mrlargha/commonui/core/cache/SessionHotsetPolicy$HiddenRecord;", "hideGenerationByKey", "lastEventAtMs", "insertionSequence", "peakHiddenEntries", "onHidden", "Lru/mrlargha/commonui/core/cache/SessionHotsetHideDecision;", "key", "entryToken", "nowMs", "hiddenAtMs", "mustAdmit", "", "(Ljava/lang/Object;JJJZ)Lru/mrlargha/commonui/core/cache/SessionHotsetHideDecision;", "onVisible", "Lru/mrlargha/commonui/core/cache/SessionHotsetShowDecision;", "(Ljava/lang/Object;JJ)Lru/mrlargha/commonui/core/cache/SessionHotsetShowDecision;", "onExpiry", "Lru/mrlargha/commonui/core/cache/SessionHotsetExpiryDecision;", "hideGeneration", "(Ljava/lang/Object;JJJ)Lru/mrlargha/commonui/core/cache/SessionHotsetExpiryDecision;", "sweepExpired", "", "Lru/mrlargha/commonui/core/cache/SessionHotsetEviction;", "onExternalEviction", "reason", "Lru/mrlargha/commonui/core/cache/SessionHotsetEvictionReason;", "(Ljava/lang/Object;JLru/mrlargha/commonui/core/cache/SessionHotsetEvictionReason;J)Ljava/util/List;", "dropHidden", "(Ljava/lang/Object;J)Z", "nextExpiryAtMs", "()Ljava/lang/Long;", "snapshot", "Lru/mrlargha/commonui/core/cache/SessionHotsetSnapshot;", "clearSession", "", "pruneExpired", "selectCapacityVictim", "protectedRecord", "evictionOf", "record", "nextHideGeneration", "(Ljava/lang/Object;)J", "updatePeak", "nextSequence", "checkTime", "saturatedAdd", TtmlNode.LEFT, TtmlNode.RIGHT, "HiddenRecord", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SessionHotsetPolicy<K> {
    public static final Companion Companion = new Companion(null);
    public static final long DEFAULT_HIDDEN_TTL_MS = 900000;
    public static final int DEFAULT_MAX_HIDDEN_ENTRIES = 10;
    private final Map<K, HiddenRecord<K>> hiddenByKey;
    private final long hiddenTtlMs;
    private final Map<K, Long> hideGenerationByKey;
    private long insertionSequence;
    private long lastEventAtMs;
    private final int maxHiddenEntries;
    private int peakHiddenEntries;

    public SessionHotsetPolicy() {
        this(0, 0L, 3, null);
    }

    private final long saturatedAdd(long j, long j2) {
        if (Long.MAX_VALUE - j < j2) {
            return Long.MAX_VALUE;
        }
        return j + j2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean selectCapacityVictim$lambda$0(HiddenRecord hiddenRecord, HiddenRecord it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it != hiddenRecord;
    }

    public SessionHotsetPolicy(int i, long j) {
        this.maxHiddenEntries = i;
        this.hiddenTtlMs = j;
        this.hiddenByKey = new LinkedHashMap();
        this.hideGenerationByKey = new LinkedHashMap();
        this.lastEventAtMs = Long.MIN_VALUE;
        if (i <= 0) {
            throw new IllegalArgumentException("maxHiddenEntries must be positive".toString());
        }
        if (j <= 0) {
            throw new IllegalArgumentException("hiddenTtlMs must be positive".toString());
        }
    }

    public /* synthetic */ SessionHotsetPolicy(int i, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 10 : i, (i2 & 2) != 0 ? DEFAULT_HIDDEN_TTL_MS : j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SessionHotsetPolicy.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B7\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0015\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003JP\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006$"}, d2 = {"Lru/mrlargha/commonui/core/cache/SessionHotsetPolicy$HiddenRecord;", "K", "", "key", "entryToken", "", "hideGeneration", "hiddenAtMs", "expiresAtMs", "insertionSequence", "<init>", "(Ljava/lang/Object;JJJJJ)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getEntryToken", "()J", "getHideGeneration", "getHiddenAtMs", "getExpiresAtMs", "getInsertionSequence", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/Object;JJJJJ)Lru/mrlargha/commonui/core/cache/SessionHotsetPolicy$HiddenRecord;", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class HiddenRecord<K> {
        private final long entryToken;
        private final long expiresAtMs;
        private final long hiddenAtMs;
        private final long hideGeneration;
        private final long insertionSequence;
        private final K key;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ HiddenRecord copy$default(HiddenRecord hiddenRecord, Object obj, long j, long j2, long j3, long j4, long j5, int i, Object obj2) {
            K k = obj;
            if ((i & 1) != 0) {
                k = hiddenRecord.key;
            }
            if ((i & 2) != 0) {
                j = hiddenRecord.entryToken;
            }
            if ((i & 4) != 0) {
                j2 = hiddenRecord.hideGeneration;
            }
            if ((i & 8) != 0) {
                j3 = hiddenRecord.hiddenAtMs;
            }
            if ((i & 16) != 0) {
                j4 = hiddenRecord.expiresAtMs;
            }
            if ((i & 32) != 0) {
                j5 = hiddenRecord.insertionSequence;
            }
            long j6 = j5;
            long j7 = j4;
            long j8 = j3;
            return hiddenRecord.copy(k, j, j2, j8, j7, j6);
        }

        public final K component1() {
            return this.key;
        }

        public final long component2() {
            return this.entryToken;
        }

        public final long component3() {
            return this.hideGeneration;
        }

        public final long component4() {
            return this.hiddenAtMs;
        }

        public final long component5() {
            return this.expiresAtMs;
        }

        public final long component6() {
            return this.insertionSequence;
        }

        public final HiddenRecord<K> copy(K k, long j, long j2, long j3, long j4, long j5) {
            return new HiddenRecord<>(k, j, j2, j3, j4, j5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof HiddenRecord) {
                HiddenRecord hiddenRecord = (HiddenRecord) obj;
                return Intrinsics.areEqual(this.key, hiddenRecord.key) && this.entryToken == hiddenRecord.entryToken && this.hideGeneration == hiddenRecord.hideGeneration && this.hiddenAtMs == hiddenRecord.hiddenAtMs && this.expiresAtMs == hiddenRecord.expiresAtMs && this.insertionSequence == hiddenRecord.insertionSequence;
            }
            return false;
        }

        public int hashCode() {
            K k = this.key;
            return ((((((((((k == null ? 0 : k.hashCode()) * 31) + Long.hashCode(this.entryToken)) * 31) + Long.hashCode(this.hideGeneration)) * 31) + Long.hashCode(this.hiddenAtMs)) * 31) + Long.hashCode(this.expiresAtMs)) * 31) + Long.hashCode(this.insertionSequence);
        }

        public String toString() {
            K k = this.key;
            long j = this.entryToken;
            long j2 = this.hideGeneration;
            long j3 = this.hiddenAtMs;
            long j4 = this.expiresAtMs;
            return "HiddenRecord(key=" + k + ", entryToken=" + j + ", hideGeneration=" + j2 + ", hiddenAtMs=" + j3 + ", expiresAtMs=" + j4 + ", insertionSequence=" + this.insertionSequence + ")";
        }

        public HiddenRecord(K k, long j, long j2, long j3, long j4, long j5) {
            this.key = k;
            this.entryToken = j;
            this.hideGeneration = j2;
            this.hiddenAtMs = j3;
            this.expiresAtMs = j4;
            this.insertionSequence = j5;
        }

        public final K getKey() {
            return this.key;
        }

        public final long getEntryToken() {
            return this.entryToken;
        }

        public final long getHideGeneration() {
            return this.hideGeneration;
        }

        public final long getHiddenAtMs() {
            return this.hiddenAtMs;
        }

        public final long getExpiresAtMs() {
            return this.expiresAtMs;
        }

        public final long getInsertionSequence() {
            return this.insertionSequence;
        }
    }

    public static /* synthetic */ SessionHotsetHideDecision onHidden$default(SessionHotsetPolicy sessionHotsetPolicy, Object obj, long j, long j2, long j3, boolean z, int i, Object obj2) {
        if ((i & 8) != 0) {
            j3 = j2;
        }
        if ((i & 16) != 0) {
            z = false;
        }
        return sessionHotsetPolicy.onHidden(obj, j, j2, j3, z);
    }

    public final SessionHotsetHideDecision<K> onHidden(K k, long j, long j2, long j3, boolean z) {
        Object obj;
        checkTime(j2);
        List mutableList = CollectionsKt.toMutableList((Collection) pruneExpired(j2));
        ListIterator listIterator = mutableList.listIterator(mutableList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                obj = null;
                break;
            }
            obj = listIterator.previous();
            SessionHotsetEviction sessionHotsetEviction = (SessionHotsetEviction) obj;
            if (Intrinsics.areEqual(sessionHotsetEviction.getKey(), k) && sessionHotsetEviction.getEntryToken() == j) {
                break;
            }
        }
        SessionHotsetEviction sessionHotsetEviction2 = (SessionHotsetEviction) obj;
        if (sessionHotsetEviction2 != null) {
            return new SessionHotsetHideDecision<>(false, true, this.hiddenTtlMs, j2, sessionHotsetEviction2.getHideGeneration(), mutableList);
        }
        HiddenRecord<K> hiddenRecord = this.hiddenByKey.get(k);
        if (hiddenRecord != null) {
            if (hiddenRecord.getEntryToken() == j) {
                return new SessionHotsetHideDecision<>(true, true, hiddenRecord.getExpiresAtMs() - hiddenRecord.getHiddenAtMs(), hiddenRecord.getExpiresAtMs(), hiddenRecord.getHideGeneration(), mutableList);
            }
            this.hiddenByKey.remove(k);
            mutableList.add(evictionOf(hiddenRecord, SessionHotsetEvictionReason.REPLACED, j2));
        }
        long nextHideGeneration = nextHideGeneration(k);
        long coerceAtLeast = RangesKt.coerceAtLeast(RangesKt.coerceAtMost(j3, j2), 0L);
        long saturatedAdd = saturatedAdd(coerceAtLeast, this.hiddenTtlMs);
        if (saturatedAdd <= j2) {
            mutableList.add(new SessionHotsetEviction(k, j, nextHideGeneration, SessionHotsetEvictionReason.TTL, RangesKt.coerceAtLeast(j2 - coerceAtLeast, 0L)));
            return new SessionHotsetHideDecision<>(false, false, this.hiddenTtlMs, saturatedAdd, nextHideGeneration, mutableList);
        }
        HiddenRecord<K> hiddenRecord2 = new HiddenRecord<>(k, j, nextHideGeneration, coerceAtLeast, saturatedAdd, nextSequence());
        this.hiddenByKey.put(k, hiddenRecord2);
        while (this.hiddenByKey.size() > this.maxHiddenEntries) {
            HiddenRecord<K> selectCapacityVictim = selectCapacityVictim(z ? hiddenRecord2 : null);
            this.hiddenByKey.remove(selectCapacityVictim.getKey());
            mutableList.add(evictionOf(selectCapacityVictim, SessionHotsetEvictionReason.CAPACITY, j2));
        }
        updatePeak();
        HiddenRecord<K> hiddenRecord3 = this.hiddenByKey.get(k);
        boolean z2 = false;
        if (hiddenRecord3 != null && hiddenRecord3.getEntryToken() == j) {
            z2 = true;
        }
        return new SessionHotsetHideDecision<>(z2, false, this.hiddenTtlMs, hiddenRecord2.getExpiresAtMs(), hiddenRecord2.getHideGeneration(), mutableList);
    }

    public final SessionHotsetShowDecision<K> onVisible(K k, long j, long j2) {
        checkTime(j2);
        HiddenRecord<K> hiddenRecord = this.hiddenByKey.get(k);
        if (hiddenRecord == null || hiddenRecord.getEntryToken() != j) {
            hiddenRecord = null;
        }
        if (hiddenRecord != null) {
            this.hiddenByKey.remove(k);
        }
        List mutableList = CollectionsKt.toMutableList((Collection) pruneExpired(j2));
        HiddenRecord<K> hiddenRecord2 = this.hiddenByKey.get(k);
        if (hiddenRecord2 == null || hiddenRecord2.getEntryToken() == j) {
            hiddenRecord2 = null;
        }
        if (hiddenRecord2 != null) {
            this.hiddenByKey.remove(k);
            mutableList.add(evictionOf(hiddenRecord2, SessionHotsetEvictionReason.REPLACED, j2));
        }
        return new SessionHotsetShowDecision<>(hiddenRecord != null ? Long.valueOf(hiddenRecord.getEntryToken()) : null, mutableList);
    }

    public final SessionHotsetExpiryDecision<K> onExpiry(K k, long j, long j2, long j3) {
        checkTime(j3);
        HiddenRecord<K> hiddenRecord = this.hiddenByKey.get(k);
        boolean z = true;
        boolean z2 = hiddenRecord != null && hiddenRecord.getEntryToken() == j && hiddenRecord.getHideGeneration() == j2;
        List<SessionHotsetEviction<K>> pruneExpired = pruneExpired(j3);
        if (z2) {
            List<SessionHotsetEviction<K>> list = pruneExpired;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    SessionHotsetEviction sessionHotsetEviction = (SessionHotsetEviction) it.next();
                    if (Intrinsics.areEqual(sessionHotsetEviction.getKey(), k) && sessionHotsetEviction.getEntryToken() == j && sessionHotsetEviction.getHideGeneration() == j2) {
                        break;
                    }
                }
            }
        }
        z = false;
        return new SessionHotsetExpiryDecision<>(z, pruneExpired);
    }

    public final List<SessionHotsetEviction<K>> sweepExpired(long j) {
        checkTime(j);
        return pruneExpired(j);
    }

    public final List<SessionHotsetEviction<K>> onExternalEviction(K k, long j, SessionHotsetEvictionReason reason, long j2) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        checkTime(j2);
        if (reason == SessionHotsetEvictionReason.TTL) {
            throw new IllegalArgumentException("TTL eviction is owned by sweep/onExpiry".toString());
        }
        if (reason == SessionHotsetEvictionReason.CAPACITY) {
            throw new IllegalArgumentException("Capacity eviction is owned by onHidden".toString());
        }
        List<SessionHotsetEviction<K>> mutableList = CollectionsKt.toMutableList((Collection) pruneExpired(j2));
        SessionHotsetEvictionReason sessionHotsetEvictionReason = SessionHotsetEvictionReason.HOST_DESTROY;
        Map<K, HiddenRecord<K>> map = this.hiddenByKey;
        if (reason != sessionHotsetEvictionReason) {
            HiddenRecord<K> hiddenRecord = map.get(k);
            if (hiddenRecord == null || hiddenRecord.getEntryToken() != j) {
                if (reason == SessionHotsetEvictionReason.EXPLICIT) {
                    this.hideGenerationByKey.remove(k);
                }
            } else {
                this.hiddenByKey.remove(k);
                mutableList.add(evictionOf(hiddenRecord, reason, j2));
                if (reason == SessionHotsetEvictionReason.EXPLICIT) {
                    this.hideGenerationByKey.remove(k);
                    return mutableList;
                }
            }
            return mutableList;
        }
        List<HiddenRecord<K>> sortedWith = CollectionsKt.sortedWith(map.values(), new Comparator() { // from class: ru.mrlargha.commonui.core.cache.SessionHotsetPolicy$onExternalEviction$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((SessionHotsetPolicy.HiddenRecord) t).getInsertionSequence()), Long.valueOf(((SessionHotsetPolicy.HiddenRecord) t2).getInsertionSequence()));
            }
        });
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        for (HiddenRecord<K> hiddenRecord2 : sortedWith) {
            arrayList.add(evictionOf(hiddenRecord2, reason, j2));
        }
        CollectionsKt.addAll(mutableList, arrayList);
        clearSession();
        return mutableList;
    }

    public final boolean dropHidden(K k, long j) {
        HiddenRecord<K> hiddenRecord = this.hiddenByKey.get(k);
        if (hiddenRecord != null && hiddenRecord.getEntryToken() == j) {
            this.hiddenByKey.remove(k);
            return true;
        }
        return false;
    }

    public final Long nextExpiryAtMs() {
        Long l;
        Iterator<T> it = this.hiddenByKey.values().iterator();
        if (it.hasNext()) {
            Long valueOf = Long.valueOf(((HiddenRecord) it.next()).getExpiresAtMs());
            while (it.hasNext()) {
                Long valueOf2 = Long.valueOf(((HiddenRecord) it.next()).getExpiresAtMs());
                if (valueOf.compareTo(valueOf2) > 0) {
                    valueOf = valueOf2;
                }
            }
            l = valueOf;
        } else {
            l = null;
        }
        return l;
    }

    public final SessionHotsetSnapshot snapshot() {
        return new SessionHotsetSnapshot(this.hiddenByKey.size(), this.peakHiddenEntries, this.maxHiddenEntries, this.hiddenTtlMs);
    }

    public final void clearSession() {
        this.hiddenByKey.clear();
        this.hideGenerationByKey.clear();
        this.lastEventAtMs = Long.MIN_VALUE;
        this.insertionSequence = 0L;
        this.peakHiddenEntries = 0;
    }

    private final List<SessionHotsetEviction<K>> pruneExpired(long j) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.hiddenByKey.values()) {
            if (((HiddenRecord) obj).getExpiresAtMs() <= j) {
                arrayList.add(obj);
            }
        }
        final Comparator comparator = new Comparator() { // from class: ru.mrlargha.commonui.core.cache.SessionHotsetPolicy$pruneExpired$$inlined$compareBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((SessionHotsetPolicy.HiddenRecord) t).getExpiresAtMs()), Long.valueOf(((SessionHotsetPolicy.HiddenRecord) t2).getExpiresAtMs()));
            }
        };
        List sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: ru.mrlargha.commonui.core.cache.SessionHotsetPolicy$pruneExpired$$inlined$thenBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                return compare != 0 ? compare : ComparisonsKt.compareValues(Long.valueOf(((SessionHotsetPolicy.HiddenRecord) t).getInsertionSequence()), Long.valueOf(((SessionHotsetPolicy.HiddenRecord) t2).getInsertionSequence()));
            }
        });
        if (sortedWith.isEmpty()) {
            return CollectionsKt.emptyList();
        }
        List<HiddenRecord<K>> list = sortedWith;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (HiddenRecord<K> hiddenRecord : list) {
            this.hiddenByKey.remove(hiddenRecord.getKey());
            arrayList2.add(evictionOf(hiddenRecord, SessionHotsetEvictionReason.TTL, j));
        }
        return arrayList2;
    }

    private final HiddenRecord<K> selectCapacityVictim(final HiddenRecord<K> hiddenRecord) {
        Sequence filter = SequencesKt.filter(CollectionsKt.asSequence(this.hiddenByKey.values()), new Function1() { // from class: ru.mrlargha.commonui.core.cache.SessionHotsetPolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Boolean.valueOf(SessionHotsetPolicy.selectCapacityVictim$lambda$0(SessionHotsetPolicy.HiddenRecord.this, (SessionHotsetPolicy.HiddenRecord) obj));
            }
        });
        final Comparator comparator = new Comparator() { // from class: ru.mrlargha.commonui.core.cache.SessionHotsetPolicy$selectCapacityVictim$$inlined$compareBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((SessionHotsetPolicy.HiddenRecord) t).getHiddenAtMs()), Long.valueOf(((SessionHotsetPolicy.HiddenRecord) t2).getHiddenAtMs()));
            }
        };
        HiddenRecord<K> hiddenRecord2 = (HiddenRecord) SequencesKt.minWithOrNull(filter, new Comparator() { // from class: ru.mrlargha.commonui.core.cache.SessionHotsetPolicy$selectCapacityVictim$$inlined$thenBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int compare = comparator.compare(t, t2);
                return compare != 0 ? compare : ComparisonsKt.compareValues(Long.valueOf(((SessionHotsetPolicy.HiddenRecord) t).getInsertionSequence()), Long.valueOf(((SessionHotsetPolicy.HiddenRecord) t2).getInsertionSequence()));
            }
        });
        if (hiddenRecord2 != null) {
            return hiddenRecord2;
        }
        throw new IllegalStateException("Cannot select a capacity victim from an empty hot-set".toString());
    }

    private final SessionHotsetEviction<K> evictionOf(HiddenRecord<K> hiddenRecord, SessionHotsetEvictionReason sessionHotsetEvictionReason, long j) {
        return new SessionHotsetEviction<>(hiddenRecord.getKey(), hiddenRecord.getEntryToken(), hiddenRecord.getHideGeneration(), sessionHotsetEvictionReason, RangesKt.coerceAtLeast(j - hiddenRecord.getHiddenAtMs(), 0L));
    }

    private final long nextHideGeneration(K k) {
        Long l = this.hideGenerationByKey.get(k);
        long j = 1;
        if (l != null) {
            long longValue = l.longValue();
            if (longValue != Long.MAX_VALUE) {
                j = longValue + 1;
            }
        }
        this.hideGenerationByKey.put(k, Long.valueOf(j));
        return j;
    }

    private final void updatePeak() {
        this.peakHiddenEntries = Math.max(this.peakHiddenEntries, this.hiddenByKey.size());
    }

    private final long nextSequence() {
        long j = this.insertionSequence + 1;
        this.insertionSequence = j;
        return j;
    }

    private final void checkTime(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("nowMs must be non-negative".toString());
        }
        long j2 = this.lastEventAtMs;
        if (j2 != Long.MIN_VALUE && j < j2) {
            throw new IllegalArgumentException(("nowMs must be monotonic: previous=" + j2 + " current=" + j).toString());
        }
        this.lastEventAtMs = j;
    }

    /* compiled from: SessionHotsetPolicy.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/core/cache/SessionHotsetPolicy$Companion;", "", "<init>", "()V", "DEFAULT_MAX_HIDDEN_ENTRIES", "", "DEFAULT_HIDDEN_TTL_MS", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
