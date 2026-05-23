package androidx.compose.foundation.gestures;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.Channel;
/* compiled from: NonTouchScrollingLogic.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002H\u0080@¢\u0006\u0002\u0010\u0003\u001a$\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00060\u0005\"\u0004\b\u0000\u0010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00060\bH\u0000¨\u0006\t"}, d2 = {"busyReceive", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/channels/Channel;", "(Lkotlinx/coroutines/channels/Channel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "untilNull", "Lkotlin/sequences/Sequence;", ExifInterface.LONGITUDE_EAST, "builderAction", "Lkotlin/Function0;", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NonTouchScrollingLogicKt {
    public static final <T> Object busyReceive(Channel<T> channel, Continuation<? super T> continuation) {
        return CoroutineScopeKt.coroutineScope(new NonTouchScrollingLogicKt$busyReceive$2(channel, null), continuation);
    }

    public static final <E> Sequence<E> untilNull(Function0<? extends E> function0) {
        return SequencesKt.sequence(new NonTouchScrollingLogicKt$untilNull$1(function0, null));
    }
}
