package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composer.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J/\u0010\u0016\u001a\u00020\u00172\u001d\u0010\u0018\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a\u0012\u0004\u0012\u00020\u00170\u0019¢\u0006\u0002\b\u001bH\u0086\b¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\b\u0088\u0001\u0003\u0092\u0001\u00020\u0004¨\u0006\u001e"}, d2 = {"Landroidx/compose/runtime/SkippableUpdater;", ExifInterface.GPS_DIRECTION_TRUE, "", "composer", "Landroidx/compose/runtime/Composer;", "constructor-impl", "(Landroidx/compose/runtime/Composer;)Landroidx/compose/runtime/Composer;", "getComposer$annotations", "()V", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/Composer;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/Composer;)I", "toString", "", "toString-impl", "(Landroidx/compose/runtime/Composer;)Ljava/lang/String;", "update", "", "block", "Lkotlin/Function1;", "Landroidx/compose/runtime/Updater;", "Lkotlin/ExtensionFunctionType;", "update-impl", "(Landroidx/compose/runtime/Composer;Lkotlin/jvm/functions/Function1;)V", "runtime_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class SkippableUpdater<T> {
    private final Composer composer;

    /* renamed from: box-impl */
    public static final /* synthetic */ SkippableUpdater m3493boximpl(Composer composer) {
        return new SkippableUpdater(composer);
    }

    /* renamed from: constructor-impl */
    public static <T> Composer m3494constructorimpl(Composer composer) {
        return composer;
    }

    /* renamed from: equals-impl */
    public static boolean m3495equalsimpl(Composer composer, Object obj) {
        return (obj instanceof SkippableUpdater) && Intrinsics.areEqual(composer, ((SkippableUpdater) obj).m3500unboximpl());
    }

    /* renamed from: equals-impl0 */
    public static final boolean m3496equalsimpl0(Composer composer, Composer composer2) {
        return Intrinsics.areEqual(composer, composer2);
    }

    public static /* synthetic */ void getComposer$annotations() {
    }

    /* renamed from: hashCode-impl */
    public static int m3497hashCodeimpl(Composer composer) {
        return composer.hashCode();
    }

    /* renamed from: toString-impl */
    public static String m3498toStringimpl(Composer composer) {
        return "SkippableUpdater(composer=" + composer + ')';
    }

    public boolean equals(Object obj) {
        return m3495equalsimpl(this.composer, obj);
    }

    public int hashCode() {
        return m3497hashCodeimpl(this.composer);
    }

    public String toString() {
        return m3498toStringimpl(this.composer);
    }

    /* renamed from: unbox-impl */
    public final /* synthetic */ Composer m3500unboximpl() {
        return this.composer;
    }

    private /* synthetic */ SkippableUpdater(Composer composer) {
        this.composer = composer;
    }

    /* renamed from: update-impl */
    public static final void m3499updateimpl(Composer composer, Function1<? super Updater<T>, Unit> function1) {
        composer.startReplaceableGroup(509942095);
        function1.invoke(Updater.m3519boximpl(Updater.m3520constructorimpl(composer)));
        composer.endReplaceableGroup();
    }
}
