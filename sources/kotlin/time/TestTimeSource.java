package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
/* compiled from: TimeSources.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u00020\u0005H\u0094\u0080\u0004J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086\u0082\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0082\u0080\u0004¢\u0006\u0004\b\u000e\u0010\fR\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012Ê\u0001\u0010\b\u0013\u0012\f\b\u0014\u0012\b\b\fJ\u0004\b\t0\u0015¨\u0006\u000f"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "<init>", "()V", "reading", "", "read", "plusAssign", "", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "plusAssign-LRDsOJo", "(J)V", "overflow", "overflow-LRDsOJo", "kotlin-stdlib", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.time.AbstractLongTimeSource
    public long read() {
        return this.reading;
    }

    /* renamed from: plusAssign-LRDsOJo  reason: not valid java name */
    public final void m11410plusAssignLRDsOJo(long j) {
        long m11335toLongimpl = Duration.m11335toLongimpl(j, getUnit());
        if (((m11335toLongimpl - 1) | 1) != Long.MAX_VALUE) {
            long j2 = this.reading;
            long j3 = j2 + m11335toLongimpl;
            if ((m11335toLongimpl ^ j2) >= 0 && (j2 ^ j3) < 0) {
                m11409overflowLRDsOJo(j);
            }
            this.reading = j3;
            return;
        }
        long m11299divUwyO8pc = Duration.m11299divUwyO8pc(j, 2);
        if ((1 | (Duration.m11335toLongimpl(m11299divUwyO8pc, getUnit()) - 1)) != Long.MAX_VALUE) {
            long j4 = this.reading;
            try {
                m11410plusAssignLRDsOJo(m11299divUwyO8pc);
                m11410plusAssignLRDsOJo(Duration.m11324minusLRDsOJo(j, m11299divUwyO8pc));
                return;
            } catch (IllegalStateException e) {
                this.reading = j4;
                throw e;
            }
        }
        m11409overflowLRDsOJo(j);
    }

    /* renamed from: overflow-LRDsOJo  reason: not valid java name */
    private final void m11409overflowLRDsOJo(long j) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m11336toStringimpl(j)) + '.');
    }
}
