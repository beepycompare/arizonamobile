package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/ArchiveForegroundPromotion;", "", "Ready", "Rejected", "Lcom/arizona/launcher/ArchiveForegroundPromotion$Ready;", "Lcom/arizona/launcher/ArchiveForegroundPromotion$Rejected;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveForegroundPromotion {

    /* compiled from: ArchiveUpdateServiceFlow.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/ArchiveForegroundPromotion$Ready;", "Lcom/arizona/launcher/ArchiveForegroundPromotion;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Ready implements ArchiveForegroundPromotion {
        public static final int $stable = 0;
        public static final Ready INSTANCE = new Ready();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Ready) {
                Ready ready = (Ready) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -171093722;
        }

        public String toString() {
            return "Ready";
        }

        private Ready() {
        }
    }

    /* compiled from: ArchiveUpdateServiceFlow.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/ArchiveForegroundPromotion$Rejected;", "Lcom/arizona/launcher/ArchiveForegroundPromotion;", "detail", "", "<init>", "(Ljava/lang/String;)V", "getDetail", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Rejected implements ArchiveForegroundPromotion {
        public static final int $stable = 0;
        private final String detail;

        public static /* synthetic */ Rejected copy$default(Rejected rejected, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = rejected.detail;
            }
            return rejected.copy(str);
        }

        public final String component1() {
            return this.detail;
        }

        public final Rejected copy(String detail) {
            Intrinsics.checkNotNullParameter(detail, "detail");
            return new Rejected(detail);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Rejected) && Intrinsics.areEqual(this.detail, ((Rejected) obj).detail);
        }

        public int hashCode() {
            return this.detail.hashCode();
        }

        public String toString() {
            return "Rejected(detail=" + this.detail + ")";
        }

        public Rejected(String detail) {
            Intrinsics.checkNotNullParameter(detail, "detail");
            this.detail = detail;
        }

        public final String getDetail() {
            return this.detail;
        }
    }
}
